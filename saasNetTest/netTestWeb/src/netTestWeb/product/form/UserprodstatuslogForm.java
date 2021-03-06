
package netTestWeb.product.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import netTest.product.dto.UserprodstatuslogQuery;
import netTest.product.vo.Userprodstatuslog;
import netTestWeb.base.BaseForm;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 08-08-2007
 */
public class UserprodstatuslogForm extends BaseForm {
	
	private Userprodstatuslog vo;
	private UserprodstatuslogQuery queryVO;
	
	private String[] keys;
	
	private int editType;
	/** 搜索类型�?1为只搜索本目录，2为包括下级数据的搜索�?3为包含所有级别的数据 **/
	private String complexSearchDivStatus;
	
	private List<Userprodstatuslog> datalist;

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		vo = new Userprodstatuslog();
		queryVO = new UserprodstatuslogQuery();
	}

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		//if(queryVO!=null){
		//   if(request.getParameter("queryVO.categorylevel")==null
		//      ||(!((String)request.getParameter("queryVO.categorylevel")).matches("^\\d+$")))
		//    	queryVO.setCategorylevel(null);
		//}
		return null;
	}
	
	public UserprodstatuslogQuery getQueryVO() {
		return queryVO;
	}

	public void setQueryVO(UserprodstatuslogQuery queryVO) {
		this.queryVO = queryVO;
	}

	public Userprodstatuslog getVo() {
		return vo;
	}

	public void setVo(Userprodstatuslog vo) {
		this.vo = vo;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}

	public int getEditType() {
		return editType;
	}

	public void setEditType(int editType) {
		this.editType = editType;
	}

	public String getComplexSearchDivStatus() {
		return complexSearchDivStatus;
	}

	public void setComplexSearchDivStatus(String complexSearchDivStatus) {
		this.complexSearchDivStatus = complexSearchDivStatus;
	}

	public List<Userprodstatuslog> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<Userprodstatuslog> datalist) {
		this.datalist = datalist;
	}
		
}
