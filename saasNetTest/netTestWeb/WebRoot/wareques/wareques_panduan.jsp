<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="netTestWeb.base.WebConstant,netTest.wareques.constant.QuestionConstant" %>
<%@ include file="/pubs/taglibs.jsp"%>

<bean:define id="jsSuffix" name="warequesForm" property="jsSuffix" type="java.lang.String"/>
<bean:define id="editType" name="warequesForm" property="editType" type="java.lang.Integer"/>
<bean:define id="quesType" name="warequesForm" property="vo.questype" type="java.lang.Integer"/>
<bean:define id="filetype" name="warequesForm" property="vo.filetype" type="java.lang.Short"/>
<bean:define id="quesidVar" name="warequesForm" property="vo.quesid" type="java.lang.Long"/>
<bean:define id="productbaseidVar" name="warequesForm" property="vo.productbaseid" type="java.lang.Long"/>
<bean:define id="ableuploadlocal" name="warequesForm" property="ableuploadlocal" type="java.lang.Boolean"/>

 <% boolean isDisable=false;
    if(editType!=null&&editType.intValue()!=WebConstant.editType_add){
      isDisable = true;
    }
    String quesidVarStr = (quesidVar==null)?"":quesidVar.toString();
%>
      
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    <title>判断题</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="../styles/css/edit.css">
	<script language=JavaScript src="<%=WebConstant.WebContext %>/styles/script/resource/mess<%=jsSuffix %>.js"></script>
    <script language=JavaScript src="../styles/script/pageAction.js"></script>
    <script type="text/javascript" src="../styles/script/movediv.js"></script>
    <script type="text/javascript" src="../styles/script/commonlogic.js"></script>
    <script type="text/javascript" src="../styles/ckeditor/ckeditor.js"></script>
    <script language="javascript">
	<!--
       
       function changeQuesRadio(value){
		if(value=='<%=QuestionConstant.FileType_None.toString() %>'){
            document.getElementById("quesFileId").value = '';
            document.getElementById("quesFileId").disabled = "disabled";
            document.getElementById("quesFileUploadTrId").style.display = 'none';
            document.getElementById("quesFileurlTrId").style.display = 'none';
         }else if(value=='<%=QuestionConstant.FileType_pict.toString() %>'){
            document.getElementById("quesFileId").disabled = "";
            document.getElementById("quesFileId").value = '';
            document.getElementById("quesFileUploadTrId").style.display = 'block';
            document.getElementById("quesFileurlTrId").style.display = 'none';
         } else if(value=='<%=QuestionConstant.FileType_voice.toString() %>'){
       	    document.getElementById("quesFileUploadTrId").style.display = 'none';
       	    document.getElementById("quesFileurlTrId").style.display = 'block';
         }
       }
       
       function delFile(Idprefix,type,obj){
	      document.getElementById(Idprefix+"0").disabled="";
	        document.getElementById(Idprefix+"0").checked="checked";
	      document.getElementById(Idprefix+"1").disabled="";
	        document.getElementById(Idprefix+"1").checked="";
	      if(type=="1"){
	         document.getElementById(Idprefix+"2").disabled="";
	         document.getElementById(Idprefix+"2").checked="";
	         document.getElementById("quesFileUploadTrId").style.display="none";
	         document.getElementById("quesFileId").value="";
	         document.getElementById("quesFileId").disabled="disabled";
	         document.getElementById("quesFileurlTrId").style.display="none";
	         document.getElementById("quesFileurlId").value="";
	      } 
	      obj.style.visibility="hidden";
	   }
       	   
	//-->
	</script>
  </head>
  
  <body> 
	<div class="editPage">
	<html:form styleId="editForm" action='<%="/wareques/saveWareques.do?recurltype=2&vo.quesid="+quesidVarStr+"&vo.productbaseid="+productbaseidVar %>' method="post" enctype="multipart/form-data">
     <input id="backUrl" type="hidden" name="backUrl" value="<bean:write name="warequesForm" property="backUrl"/>">
     <input id="backUrlEncode" type="hidden" name="backUrlEncode" value='<bean:write name="warequesForm" property="backUrlEncode"/>'>
     <input id="delItemStrId" type="hidden" name="delItemStr" value=""/>
	 <input id="prodidId" type="hidden" value="<%=productbaseidVar %>">
	 <input name="paperid" type="hidden" value='<bean:write name="warequesForm" property="paperid"/>'>
     <input type="hidden" name="vo.questype" value='<bean:write name="warequesForm" property="vo.questype"/>'/>
	
	  <div id="fieldsTitleDiv"><%if(!isDisable){ %>新增<%}else{ %>编辑<%} %>题目</div>
      
      <div style="width:98%;float: left;padding-left: 7px;">
	  <div style="padding-top:2px;margin-top:20px;background-color:#DCEAFC"><font style="font-weight: bold;">题目属性</font></div>
	  <div>
		  <jsp:include flush="true" page="ques_include.jsp"></jsp:include>
	  </div>
	  <div style="padding-top:2px;margin-top:10px;background-color:#DCEAFC"><font color="red">*</font><font style="font-weight: bold;">题目题干</font></div>
	  <div>
	      <table class="formTable">
		     <tr>
		        <td colspan="2">
	                <textarea id="questionId" name="vo.question" style="width:100%" rows="4" usage="notempty,max-length:1500" fie="题目题干"><bean:write name="warequesForm" property="vo.question"/></textarea>
	                <script type="text/javascript">
				         var p_editor = CKEDITOR.replace( 'questionId',
				         {
				      		toolbar : 'question',
				      		height : '80px'
				    	 });
				    </script>
	            </td>
	         </tr>
	         <tr style="background: #DCEAFC">
		        <td align="left" width="85">多媒体附件</td>
		        <td>
		            <table style="border: 0px;width: 100%;">
		               <tr>
		                  <td>
		                      <input type="hidden" name="vo.filetypeOrigin" value="<bean:write name="warequesForm" property="vo.filetype"/>" >
				              <%if(QuestionConstant.FileType_None.equals(filetype)){ isDisable=false; } 
				                else {isDisable=true;} %>
		                      <html:radio styleId="quesFileRadioId0" name="warequesForm" property="vo.filetype" value="<%=QuestionConstant.FileType_None.toString() %>" onclick='<%="changeQuesRadio(\'"+QuestionConstant.FileType_None.toString()+"\')" %>' disabled="<%=isDisable%>"></html:radio>无
		                      <html:radio styleId="quesFileRadioId1" name="warequesForm" property="vo.filetype" value="<%=QuestionConstant.FileType_pict.toString() %>" onclick='<%="changeQuesRadio(\'"+QuestionConstant.FileType_pict.toString()+"\')" %>' disabled="<%=isDisable%>"></html:radio>图片
		                      
		                      <html:radio styleId="quesFileRadioId2" name="warequesForm" property="vo.filetype" value="<%=QuestionConstant.FileType_voice.toString() %>" onclick='<%="changeQuesRadio(\'"+QuestionConstant.FileType_voice.toString()+"\')" %>' disabled="<%=isDisable%>"></html:radio>声音
		                      
		                      <%if(isDisable){%>&nbsp;<a href="javascript:void(0)" onclick="delFile('quesFileRadioId','1',this);return false;" >删除附件</a><%} %>
		                  </td>
		               </tr>
		               <tr id="quesFileUploadTrId" style="<%if(!QuestionConstant.FileType_pict.equals(filetype)&&!QuestionConstant.FileType_voice.equals(filetype)){out.print("display:none");}%>">
		                  <td style="white-space: nowrap;width: 100%;">
		                      选择文件上传: <input id="quesFileId" type="file" name="vo.quesFile" style="width:70%" disabled="disabled" onchange="checkQuesFile('quesFileId','quesPreviewImgId');" usage="notempty" fie="题干文件">
		                  </td>
		               </tr>
		               <tr id="quesFileurlTrId" style="<%if(!QuestionConstant.FileType_voice.equals(filetype)){out.print("display:none");}%>">
		                  <td style="white-space: nowrap;width: 100%;">
		                      输入文件在线地址: <input id="quesFileurlId" type="text" name="vo.fileurl" style="width:70%" value='<bean:write name="warequesForm" property="vo.fileurl"/>'>
		                  </td>
		               </tr>
		            </table>
		        </td>
	         </tr>
	      </table>
	  </div>
	  <div style="padding-top:2px;margin-top:10px;background-color:#DCEAFC"><font style="font-weight: bold;">答案</font></div>
	  <div>
	      <table class="formTable">
	         <tbody>
             <tr>
                <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;
                <label for="quesItemRightId">
                <html:radio styleId="quesItemRightId" value="<%=QuestionConstant.IsRight_right.toString() %>" name="warequesForm" tagName="vo.answersim" property="vo.answersim">正确</html:radio>
                </label>
                <label for="quesItemWrongId">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <html:radio styleId="quesItemWrongId" value="<%=QuestionConstant.IsRight_wrong.toString() %>" name="warequesForm" tagName="vo.answersim" property="vo.answersim">错误</html:radio>
                </label>
                </td>
             </tr>
             </tbody>
           </table>
	  </div>
	  
	  <div style="padding-top:2px;margin-top:30px;background-color:#DCEAFC"><font style="font-weight: bold;">解题思路</font></div>
	  <div>
	      <table class="formTable">
	         <tbody>
             <tr>
                <td>
                    <textarea name="answerVO.solvedesc" id="editor2" style="width:100%" rows="4" usage="max-length:1500" fie="解题思路"><bean:write name="warequesForm" property="answerVO.solvedesc"/></textarea>
                    <script type="text/javascript">
				         var p_editor = CKEDITOR.replace( 'editor2',
				         {
				      		toolbar : 'question',
				      		height : '80px'
				    	 });
				    </script>
                </td>
             </tr>
             </tbody>
           </table>
	  </div>
	  
	  </div>
	  <div style="width:30px;float:right">&nbsp;</div>
	  
	  <div id="displayMessDiv">
          <tiles:insert page="/pubs/messDiv.jsp"></tiles:insert>
	  </div>
	  
	  <div id="functionBarButtomDiv">
	  	 <ul>
		    <li><button type="button" onclick="submitQues();" type="button">保存题目</button></li>
			<li><button type="button" onclick="getAndToUrl('backUrl');return false;" type="button">取消返回</button></li>
		 </ul>
	  </div>
	  <br>
	  <div id="buttomDiv"></div>
	</html:form>
	</div>
	
	<script type="text/javascript">
	   
	   function submitQues(){
	      var checkValue = getCheckedValue("vo.answersim");
	      var mess = "";
	      if(checkValue==null||checkValue==""){
	         mess = mess+"<li>请选择正确答案</li>";
	      }
	      if(mess!=""){
	         var messDiv = document.getElementById("displayMessDiv");
	         messDiv.innerHTML = "";
	         messDiv.innerHTML = messDiv.innerHTML + mess;
	         return;
	      }
	      
	      var ques_content = CKEDITOR.instances.questionId.getData();
   	   	  document.getElementById("questionId").value = ques_content;
   	   	  var editor2_content = CKEDITOR.instances.editor2.getData();
	   	  document.getElementById("editor2").value = editor2_content;
   	   	  
          submitForm('editForm');
	   }
	   
	</script>
	
  </body>
</html:html>
