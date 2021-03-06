<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="platformWeb.base.WebConstant,platform.constant.SysfunctionitemConstant,commonTool.constant.CommonConstant,platformWeb.base.KeyInMemoryConstant,java.util.Locale,commonTool.constant.PayTypeConstant" %>
<%@ include file="/pubs/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <title>系统功能列表</title>
	<link rel="stylesheet" type="text/css" href="../styles/css/list.css">
	<script type="text/javascript" src="../styles/script/pageAction.js"></script>
	<script type="text/javascript" src="../styles/script/movediv.js"></script>
  </head>
  
  <body>
  <div class="listPage">
  <html:form styleId="list" action="/sysadmin/sysfunctionitem.do?method=list" method="post">
    <input id="backUrl" type="hidden" name="backUrl" value="<bean:write name="sysfunctionitemForm" property="backUrl"/>">
    <input id="backUrlEncode" type="hidden" name="backUrlEncode" value="<bean:write name="sysfunctionitemForm" property="backUrlEncode"/>">	
    
  <%
	      Locale locale = (Locale)request.getAttribute(KeyInMemoryConstant.LocaleKey);
	      %>
  <div id="firstLineDiv">
      <div id="help">
	       <a href="" title="<bean:message key="platform.commonpage.help"/>"><img src="../styles/imgs/help.jpg"></a>
      </div>
      <div id="searchDiv">所属系统: 
		<html:select  name="sysfunctionitemForm" property="queryVO.systemid" styleId="selectSys" style="width:100px;">
		   <option></option>
		   <html:optionsCollection name="sysfunctionitemForm" property="sysList"/>
	    </html:select>
		有效性:
		<select name="queryVO.status" style="width:100px;">
	        <option > </option>
	        <option <logic:present name="sysfunctionitemForm" property="queryVO.status"><logic:equal name="sysfunctionitemForm" property="queryVO.status" value="<%=String.valueOf(SysfunctionitemConstant.Status_using)%>">selected="selected"</logic:equal></logic:present> value="<%=SysfunctionitemConstant.Status_using%>">生效</option>
	        <option <logic:present name="sysfunctionitemForm" property="queryVO.status"><logic:equal name="sysfunctionitemForm" property="queryVO.status" value="<%=String.valueOf(SysfunctionitemConstant.Status_nouse)%>">selected="selected"</logic:equal></logic:present>  value="<%=SysfunctionitemConstant.Status_nouse%>">失效</option>
		</select>
		<input type="submit" name="Submit" value="<bean:message key="platform.commonpage.query"/>" />
		
      </div>
  </div>

  <div id="functionLineDiv">
	  <div id="functionButtonDiv">
		  <ul>
			 <li><button type="button" onclick="modifyRecord('list','keys','/sysadmin/sysfunctionitem.do?method=editPage&editType=<%=WebConstant.editType_edit%>&queryVO.functioncode=','<bean:message key="commonWeb.js.pageAction.modifyRecord.selectOneMsg" bundle="BizKey"/>','<bean:message key="commonWeb.js.pageAction.modifyRecord.oneOnlyMsg" bundle="BizKey"/>');return false;"><bean:message key="platform.commonpage.modify"/></button></li>
	      </ul>
	  </div>
	  <!-- page list -->
      <div id="pageNumLineDiv">
         <tiles:insert page="/pubs/pagetiles.jsp"></tiles:insert>
      </div>
      <!-- page list -->
  </div>
  
  <div class="dashLine"></div>
  
  <div id="displayMessDiv">
      <tiles:insert page="/pubs/messDiv.jsp"></tiles:insert>
  </div>


  <div id="DataTableDiv">
    <table class="listDataTable" >
      <tr class="listDataTableHead">
        <td width="20px"><input type="checkbox" name="select1_1Checkbox" value="" onClick="selectAllCheckbox('list',this,'keys')"></td>
        <td>功能名称</td>

        <td>功能代码</td>

        <td>所属系统</td>

        <td>支付方式</td>

        <td>价格</td>

        <td>生效日期</td>

        <td>中止日期</td>

        <td>有效性</td>

		<div id="dataTableColumnPlus"></div>
      </tr>
      <logic:present name="pageList">
	  <logic:iterate id="vo" name="pageList">
	  <bean:define id="functioncode" name="vo" property="functioncode" type="java.lang.String"></bean:define>
	  <bean:define id="systemid" name="vo" property="systemid" type="java.lang.String"></bean:define>
	  
      <tr>
        <td><input type="checkbox" name="keys" value="<bean:write name="vo" property="functioncode"/>" onClick="selectInfo(this,'clickedRow')"></td>
        
        <td><a href="javascript:newDiv('/sysadmin/sysfunctionitem.do?method=editPage&queryVO.functioncode=<bean:write name="vo" property="functioncode"/>&editType=<%=WebConstant.editType_view%>',0,1,600,400);"><%=SysfunctionitemConstant.qryFuncName(functioncode,locale)%></a></td>

        <td><%=functioncode%></td>

        <td><%=CommonConstant.qrySystemName(systemid,locale)%></td>

        <td><bean:writeSaas name="vo" property="paytype" consCode="Common.PayTypeConstant.PayType"/></td>

        <td><bean:write name="vo" property="cost"/></td>

        <td><bean:write name="vo" property="startdate" format="yyyy-MM-dd"/></td>

        <td><bean:write name="vo" property="status"/></td>

		<div id="dataTableColumnDataPlus"></div>
      </tr>
      </logic:iterate>
      </logic:present>
    </table>
  </div>
  <div id="buttomDiv"></div>
  </html:form>
  </div>
  <script language=JavaScript>
    
     window.onload=function (){  
        setListTableStyle();
     } 
    
  </script>
  </body>
</html:html>
