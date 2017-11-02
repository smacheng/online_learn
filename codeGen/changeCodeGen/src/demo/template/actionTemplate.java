
package {[#ProjectWeb#]}.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import commonTool.base.Page;
import {[#PackageDao#]}.{[#className#]}Dao;
import {[#PackageDto#]}.{[#className#]}Query;
import {[#Project#]}.bean.BOFactory;
import {[#PackageVO#]}.{[#className#]};
import {[#Project#]}Web.base.BaseAction;
import {[#Project#]}Web.base.WebConstant;
import {[#Project#]}Web.base.KeyInMemoryConstant;
import commonTool.constant.CommonConstant;
import {[#ProjectWeb#]}.form.{[#className#]}Form;

/** 
 * MyEclipse Struts
 * Creation date: 08-08-2007
 */
public class {[#className#]}Action extends BaseAction {
	
	static Logger log = Logger.getLogger({[#className#]}Action.class.getName());
		
	public ActionForward execute(ActionMapping mapping, ActionForm actionform,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ActionForward myforward = null;
		String myaction = mapping.getParameter();
		{[#className#]}Form theForm = ({[#className#]}Form) actionform;

		if ("".equalsIgnoreCase(myaction)) {
			myforward = mapping.findForward("failure");
		} else if ("list{[#className#]}".equals(myaction)) {
			myforward = list(mapping, actionform, request,response);
		} else if ("save{[#className#]}".equals(myaction)) {
			myforward = save(mapping, actionform, request,response);
		} else if ("edit{[#className#]}".equals(myaction)) {
			theForm.setEditType(WebConstant.editType_edit);
			myforward = editPage(mapping, actionform, request,response);
		} else if ("view{[#className#]}".equals(myaction)) {
			theForm.setEditType(WebConstant.editType_view);
			myforward = editPage(mapping, actionform, request,response);
		} else if ("add{[#className#]}".equals(myaction)) {
			myforward = addPage(mapping, actionform, request,response);
		} else if ("delete{[#className#]}".equals(myaction)) {
			myforward = delete(mapping, actionform, request,response);
		} else {
			myforward = mapping.findForward("failure");
		}
		return myforward;
	}
	
	/** 
	 * Method list
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		{[#className#]}Form theForm = ({[#className#]}Form) form;
		{[#className#]}Query queryVO = theForm.getQueryVO();
		
		{[#className#]}Dao dao = BOFactory.get{[#className#]}Dao();
		Page page = dao.selectByVOPage(queryVO, getCurrPageNumber(request), getPageSize(request), getTotalNumber(request));
		this.setPage(request, page);
		
		return mapping.findForward("list");
	}
	
	/** 
	 * Method save
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String messCode = KeyInMemoryConstant.modifySuccess;
		if(!isTokenValid(request)){
			saveToken(request);
			return this.forwardErrorPage(mapping, request, null, "commonWeb.java.commonaction.errors.resubmit");
		}else{
			resetToken(request);
		}
		
		{[#className#]}Form theForm = ({[#className#]}Form) form;
		{[#className#]} vo = theForm.getVo();
        if(vo!=null&&(vo.get{[#pkInMethod#]}()==null||vo.get{[#pkInMethod#]}()==0))
        	messCode = KeyInMemoryConstant.AddSuccess;
        
        {[#className#]}Dao dao = BOFactory.get{[#className#]}Dao();
		dao.save(vo);
		// set messag page parameters.
		super.setMessagePage(request,theForm, messCode, "1","BaseKey");
		return mapping.findForward("toUrl");
	}
	
	/** 
	 * Method edit
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward editPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		saveToken(request);
		{[#className#]}Form theForm = ({[#className#]}Form) form;
		{[#className#]}Query queryVO = theForm.getQueryVO();
		Long pk = queryVO.get{[#pkInMethod#]}();
		
		{[#className#]}Dao dao = BOFactory.get{[#className#]}Dao();
		{[#className#]} vo = dao.selectByPK(pk);
		if(vo==null)
		   throw new NoSuchRecordException("--class:{[#className#]}Action;--method:editPage;");
		theForm.setVo(vo);

		if(theForm.getEditType()==WebConstant.editType_edit)
		   return mapping.findForward("addEditPage");
		else
		   return mapping.findForward("viewPage");
	}
	
	/** 
	 * Method add
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		saveToken(request);
		{[#className#]}Form theForm = ({[#className#]}Form) form;
		theForm.setEditType(WebConstant.editType_add);
		return mapping.findForward("addEditPage");
	}
	
	/** 
	 * Method delete
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		{[#className#]}Form theForm = ({[#className#]}Form) form;
		String[] keys = theForm.getKeys();
		int rows = 0;
		String result = String.valueOf(CommonConstant.success);
		String messKey = "";
		try {
			{[#className#]}Dao dao = BOFactory.get{[#className#]}Dao();
			rows = dao.deleteBatchByPK(keys);
			messKey = KeyInMemoryConstant.deleteSuccessCommon;
		}catch (Exception e) {
			result = String.valueOf(CommonConstant.fail);
			if(e instanceof LogicException){
				messKey = e.getMessage();
			}else {
				messKey = ExceptionConstant.Error_System;
			}
		}
		String message = getResources(request).getMessage(messKey);
		this.writeAjaxRtn(result, message, null, response);
		return null;
	}
	
}