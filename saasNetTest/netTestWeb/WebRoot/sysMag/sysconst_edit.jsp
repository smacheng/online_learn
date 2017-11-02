<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="netTestWeb.base.KeyInMemoryConstant,commonTool.constant.SysconstConstant,netTestWeb.base.WebConstant" %>
<%@ include file="/pubs/taglibs.jsp"%>
<bean:define id="jsSuffix" name="sysconstForm" property="jsSuffix" type="java.lang.String"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <title>系统常量编辑</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="../styles/css/edit.css">
	<script language=JavaScript src="<%=WebConstant.WebContext %>/styles/script/resource/mess<%=jsSuffix %>.js"></script>
    <script language=JavaScript src="../styles/script/pageAction.js"></script>
    <script type="text/javascript">
      <!--
      function setDisable(selObj){ //v3.0
	     itemValue = selObj.options[selObj.selectedIndex].value;
         if(itemValue!=null&&itemValue=="1"){
            document.getElementById("valuewayId").disabled="disabled";
            document.getElementById("dbItemDiv").style.display="block";
         }else{
            document.getElementById("valuewayId").disabled="";
            document.getElementById("dbItemDiv").style.display="none";
         }
	  }
	  //-->
    </script>
    
  </head>
  
  <body>
	<div class="editPage">
	<html:form styleId="editForm" action="/sysMag/sysconst.do?method=save" method="post">
     <input id="backUrl" type="hidden" name="backUrl" value="<bean:write name="sysconstForm" property="backUrl"/>">
     <input id="backUrlEncode" type="hidden" name="backUrlEncode" value="<bean:write name="sysconstForm" property="backUrlEncode"/>">
	 <input type="hidden" name="vo.sysconstid" value="<bean:write name="sysconstForm" property="vo.sysconstid"/>">
	 <bean:define id="editType" name="sysconstForm" property="editType" type="Integer"></bean:define>
	 <%boolean show=true;%>
	 
	  <div id="fieldsTitleDiv"><bean:write name="sysconstForm" property="vo.name"/></div>
	  
	  <div id="displayMessDiv">
	      <% String disMessKey = request.getParameter(KeyInMemoryConstant.DisMessKey)==null?null:((String)request.getParameter(KeyInMemoryConstant.DisMessKey));
	         String disMessArg0Key = request.getParameter(KeyInMemoryConstant.DisMessArg0Key)==null?null:((String)request.getParameter(KeyInMemoryConstant.DisMessArg0Key));
	         if(disMessKey!=null&&disMessKey.trim().length()>0){
	           if(disMessArg0Key==null||disMessArg0Key.trim().length()<1){
	       %>
	         <bean:message key="<%=disMessKey %>" bundle="BizKey"/>
	      <% }else{
	       %>
	         <bean:message key="<%=disMessKey %>" bundle="BizKey" arg0="<%=disMessArg0Key %>"/>
	      <%}} %>
	  </div>

	  <div id="fieldDisDiv">
	     <ul>
	     
	        <li>
			   <div class="fieldLabel">常量编码:</div>
			   <div class="field"> 
			      <bean:write name="sysconstForm" property="vo.sysconstcode"/>
			   </div>
			   <div class="fieldDesc"></div>
			</li>
	        
		    <li>
			   <div class="fieldLabel">取值方式:</div>
			   <div class="field"> 
			       <html:select name="sysconstForm" property="vo.getvalueway" style="width:150px;" disabled="<%=show %>" onchange="setDisable(this)">
		               <html:option value=""></html:option>
		               <html:optionsSaas consCode="Const.Common.getValueWay"/>
		           </html:select>
			   </div>
			   <div class="fieldDesc"></div>
			</li>
		           
		    <li>
			   <div class="fieldLabel">取值:</div>
			   <div class="field"> 
			       <html:text styleId="valuewayId" name="sysconstForm" property="vo.valueway" style="width:300px"></html:text>
			   </div>
			   <div class="fieldDesc"></div>
			</li>
		           
		 </ul>
	  </div>
	  <div id="dbItemDiv">
	  <div id="functionBarButtomDiv">
	  	 <ul>
	  	    <logic:equal name="sysconstForm" property="editType" value="2">
		    <li><button type="button" onclick="submitForm('editForm');"><bean:message key="netTest.commonpage.save"/></button></li>
			<li><button type="button" onclick="return false;"><bean:message key="netTest.commonpage.reset"/></button></li>
			</logic:equal>
			<li><button type="button" onclick="getAndToUrl('backUrl');return false;"><bean:message key="netTest.commonpage.back"/></button></li>
		 </ul>
	  </div>
	  <div style="height:20px;width100%;background:#eeeeee">常量名不同语言国家设置：</div>
	  <div style="width:100%;height:450px;">
	      <iframe width="100%" height="100%" src="<%=WebConstant.WebContext %>/sysMag/sysconstval.do?method=list&queryVO.sysconstid=<bean:write name="sysconstForm" property="vo.sysconstid"/>" scrolling="auto" frameborder="1"></iframe>
       </div>
       </div>
	  <div id="buttomDiv"></div>
	</html:form>
	</div>
	  <script language=JavaScript>
		 <!--
	       window.onload=function(){
	           <logic:equal name="sysconstForm" property="vo.getvalueway" value="<%=String.valueOf(SysconstConstant.GetValueWay_ConsItem) %>">
		           document.getElementById("valuewayId").disabled="disabled";
		       </logic:equal>

		   }
	     //-->
	  </script>
  </body>
</html:html>
