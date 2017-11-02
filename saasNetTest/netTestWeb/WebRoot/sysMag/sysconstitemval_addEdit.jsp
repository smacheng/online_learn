<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="netTestWeb.base.WebConstant" %>
<%@ include file="/pubs/taglibs.jsp"%>
<bean:define id="jsSuffix" name="sysconstitemvalForm" property="jsSuffix" type="java.lang.String"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <title>子选项语言国家编辑</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="../styles/css/edit.css">
	<script language=JavaScript src="<%=WebConstant.WebContext %>/styles/script/resource/mess<%=jsSuffix %>.js"></script>
    <script language=JavaScript src="../styles/script/pageAction.js"></script>

  </head>
  
  <body>
	<div class="editPage">
	<html:form styleId="editForm" action="/sysMag/sysconstitemval.do?method=save" method="post">
     <input id="backUrl" type="hidden" name="backUrl" value="<bean:write name="sysconstitemvalForm" property="backUrl"/>">
     <input id="backUrlEncode" type="hidden" name="backUrlEncode" value="<bean:write name="sysconstitemvalForm" property="backUrlEncode"/>">
	 <input type="hidden" name="vo.itemvalueid" value="<bean:write name="sysconstitemvalForm" property="vo.itemvalueid"/>">
	 <input type="hidden" name="vo.itemid" value="<bean:write name="sysconstitemvalForm" property="vo.itemid"/>">
	  <div id="functionLineDiv">
		  <div id="functionBarTopDiv">
			  <ul>
				 <li><button type="button" onclick="submitForm('editForm');"><bean:message key="netTest.commonpage.save"/></button></li>
				 <li><button type="button" onclick="return false;"><bean:message key="netTest.commonpage.reset"/></button></li>
				 <li><button type="button" onclick="getAndToUrl('backUrl');return false;"><bean:message key="netTest.commonpage.back"/></button></li>
			  </ul>
		  </div>
		  <div id="help">
		       <a href="" title="<bean:message key="netTest.commonpage.help"/>"><img src="../styles/imgs/help.jpg"></a>
		  </div>
	  </div>
	
	  <div id="fieldsTitleDiv">子选项语言设置编辑</div>
	  
	  <div id="errorDisplayDiv"></div>

	  <div id="fieldDisDiv">
	     <ul>
            
            <li>
			   <div class="fieldLabel">所属语言地区:</div>
			   <div class="field"> 
			   <%boolean isAdd = true; %>
			     <logic:empty name="sysconstitemvalForm" property="vo.itemvalueid"><%isAdd=false;%></logic:empty>
			     <html:select name="sysconstitemvalForm" property="vo.localeid"  disabled="<%=isAdd %>" style="width:150px;">
					<html:optionsCollection name="sysconstitemvalForm" property="localesList"/>
			     </html:select>
			   </div>
			   <div class="fieldDesc"></div>
			</li>
            
            <li>
			   <div class="fieldLabel">子选项名:</div>
			   <div class="field"> 
			     <input type="text" name="vo.labelname" value="<bean:write name="sysconstitemvalForm" property="vo.labelname"/>" usage="notempty,max-length:40" fie="子选项名"/>
			   </div>
			   <div class="fieldDesc"></div>
			</li>
			
		 </ul>
	  </div>
	  <div id="functionBarButtomDiv">
	  	 <ul>
		    <li><button type="button" onclick="submitForm('editForm');"><bean:message key="netTest.commonpage.save"/></button></li>
			<li><button type="button" onclick="return false;"><bean:message key="netTest.commonpage.reset"/></button></li>
			<li><button type="button" onclick="getAndToUrl('backUrl');return false;"><bean:message key="netTest.commonpage.back"/></button></li>
		 </ul>
	  </div>
	  <div id="buttomDiv"></div>
	</html:form>
	</div>
  </body>
</html:html>
