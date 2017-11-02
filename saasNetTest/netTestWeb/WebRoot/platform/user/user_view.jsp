<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="netTestWeb.base.WebConstant"%>
<%@ include file="/pubs/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <bean:define id="jsSuffix" name="userForm" property="jsSuffix" type="java.lang.String"/>
    <title>用户信息编辑</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="<%=WebConstant.WebContext %>/styles/css/leftMenu.css"/>
	<style>
	    body{ margin:0px }
	    input{
	       border: 1px solid #eeeeee;
	    }
	
		.userinput_div{
		    width: 100%;
			float:left;
			overflow: auto;
		}
		
		.field_left{
			width:285px;
			padding-right: 7px;
			text-align:right;
			margin:2px;
			font-size: larger;
		}

		.login_field{
			width: 251px;
			font-size: larger;
		}

		.login_fieldDesc{
			padding-left:5px;
			text-align:left;
			font-size:15px;
			color:#999;
		}
		
		.centerstyle{
		    width:1000px;
		    left: 50%;
			position:relative;
			clear: both;
			margin-left: -500px;
		}
		
		.leftmenu{
		    float:left;
     	    margin: 20px 5px 5px 5px;
     	    width: 150px;
		}
		
		.centercontent{
		    float: left; margin: 5px;
		    width: 820px;
		}

		
	</style>
	
    <script type='text/javascript' src="../../styles/script/pageAction.js"></script>
    <script type='text/javascript' src="<%=WebConstant.WebContext %>/styles/script/timezone/timezone<%=jsSuffix %>.js"></script>
        
  </head>
  
  <body>
	<div class="centerstyle">
	<jsp:include flush="true" page='<%="/userAdmin/banner_user.jsp" %>'></jsp:include>
	
	<div class="navlistBar">
       <table width="100%" align="center">
          <tr><td>个人设置&gt;&gt;用户基本信息</td>
              <td align="right"></td>
          </tr>
       </table>
    </div>
	
	<div class="leftmenu">
       <ul id="nav">
          <li class="press"><a href="javascript:void(0);" onclick="goUrl('/customers/viewuser.do');return false;">基本信息</a></li>
          <li class="menu"><a href="javascript:void(0);" onclick="goUrl('/platform/user/user_updPassword.jsp');return false;">修改密码</a></li>
       </ul>
    </div>
	
	<div class="centercontent">
	<div class="fieldsTitleDiv" style="margin-top:15px; margin-bottom:15px; padding:5px; background-color:#DCEAFC;font-size:25px; text-align: center">用户基本信息</div>
	  
	  <div class="userinput_div">
	  
	     <table cellspacing="7" cellpadding="5" border="0" width="100%">
		    <tr>
			   <td class="field_left">登录名:</td>
			   <td class="login_field"><bean:write name="userForm" property="vo.loginname"/></td>
			   <td id="nameId_tip_td" class="login_fieldDesc"></td>
			</tr>
			<tr>
			   <td class="field_left">姓名:</td>
			   <td class="login_field"><bean:write name="userForm" property="vo.displayname"/></td>
			   <td id="nameId_tip_td" class="login_fieldDesc"></td>
			</tr>
			<tr>
			   <td class="field_left">电子邮件:</td>
			   <td class="login_field"><bean:write name="userForm" property="vo.email"/></td>
			   <td id="emailId_tip_td" class="login_fieldDesc"></td>
			</tr>
			<tr>
			   <td class="field_left">电话:</td>
			   <td class="login_field"><bean:write name="userForm" property="contactinfo.telephone"/></td>
			   <td id="telephoneId_tip_td" class="login_fieldDesc"></td>
			</tr>
			<tr>
			   <td class="field_left">所在国家:</td>
			   <td class="login_field">
			       <bean:writeSaas name="userForm" property="vo.localeid" showLocaleName="true"/>
			   </td>
			   <td id="" class="login_fieldDesc"><i></i><span id="_tip"></span></td>
			</tr>
			<tr>
			   <td class="field_left" >所在地区:</td>
			   <td colspan="2">
			      <bean:writeSaas name="userForm" property="contactinfo.regioncode" consCode="CountryregionConstant.RegionCode"/>
			   </td>
			</tr>
			<tr>
			   <td class="field_left">所在时区:</td>
			   <td colspan="2">
			       <span id="spanTimezoneId"></span>
			   </td>
			</tr>
			<tr>
			   <td class="field_left">性别:</td>
			   <td class="login_field">
			      <bean:writeSaas name="userForm" property="vo.gender" consCode="Sysconst.Gender"/>
			   </td>
			   <td id="" class="login_fieldDesc"></td>
			</tr>
			<tr>
			   <td class="field_left">出生年份:</td>
			   <td class="login_field">
			      <bean:write name="userForm" property="custinfoex.birthday"/>
			   </td>
			   <td></td>
			</tr>
			<tr>
			   <td class="field_left">状态:</td>
			   <td class="login_field">
			      <bean:writeSaas name="userForm" property="vo.status" consCode="platform.CustomerConstant.UserStatus"/>
			      <logic:present name="userForm" property="statusvo">
			          (原因:<bean:write name="userForm" property="statusvo.statusdisc"/>,时间:<bean:write name="userForm" property="statusvo.statustime" format="yyyy-mm-dd"/>)
			      </logic:present>
			   </td>
			   <td></td>
			</tr>
			
			<tr>
			   <td colspan="3" style="padding-top:30px;padding-bottom:30px;text-align: center">
			      <button style="font-size:25px;" onclick="goUrl('/customers/edituser.do?vo.userid=<bean:write name="userForm" property="vo.userid"/>');return false;">修改</button>
			   </td>
			</tr>
		 </table>

      </div>
	  <div id="buttomDiv"></div>
	
	</div>
	</div>
    <script type="text/javascript">
        var timezone = '<bean:write name="userForm" property="vo.timezone"/>';
        var timezoneValue = '';
        for(var i=0;i<timezoneArr.length;i++){
            if(timezoneArr[i][0]==timezone){
               timezoneValue = timezoneArr[i][1];
               document.getElementById("spanTimezoneId").innerHTML = timezoneValue;
               break;
            }
        }
    </script>
  </body>
</html:html>
