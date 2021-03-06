<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String contextPath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>患者信息保存</title>
<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" language="javascript" src="../js/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" language="javascript" src="../js/jquery-ui-1.8.16.custom.min.js"></script>  
<script type="text/javascript" language="javascript" src="../js/jquery[1].ui.datepicker-zh-CN.js"></script>  
  
<!--css-->  
<link type="text/css" rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" /> 
<script type="text/javascript" charset="utf-8">
			jQuery(function($){
			$('#datepicker').datepicker({
					yearRange: '1900:2099', //取值范围.
					showOn: 'both', //输入框和图片按钮都可以使用日历控件。
					buttonImage: '../image/CRUD_image/calendar.gif', //日历控件的按钮
					buttonImageOnly: true,
					showButtonPanel: true,
					dateFormate:'yy-MM-dd'
				});	
			
			$("#telephone").blur(function(){
				if(!(/(^(\d{3,4}-)?\d{7,8})$|(^1[3|4|5|8][0-9]{9})/.test($("#telephone").val()))){
					        alert("不是正确的11位手机号或者正确的固话");
					        $("#telephone").val("");
					    }
			});
				
			});
		</script>
</head>
<body>
  <a href="<%=contextPath %>/RegPatient/queryAll.action" target="main">点击此处跳转到首页</a>
  <p>请在下面填入患者的相关信息</p>
  <form action="<%=contextPath %>/RegPatient/save.action" method="post">
  <table width="" >
    <!--  <tr>
        <td colspan="3">
          <input type="hidden" name="regPatient.regiserPatient_id" />
        </td>
     </tr> -->
     <tr>
        <td>
            &nbsp;&nbsp;病历号：<input type="text" width="100" name="regPatient.regiserPatient_caseNo" id="regiserPatient_caseNo" readonly value="<%=request.getAttribute("regiserPatient_caseNo") %>" class="text ui-widget-content ui-corner-all">
        </td>
        <td>
            &nbsp;&nbsp;&nbsp;&nbsp; 姓名：   <input type="text" name="regPatient.regiserPatient_name" class="text ui-widget-content ui-corner-all" > 
        </td>
        <td>
            &nbsp;&nbsp;性别:<SELECT style="WIDTH: 100px;height:20px" name="regPatient.regiserPatient_sex" class="text ui-widget-content ui-corner-all"> 
                   <OPTION selected>男</OPTION> 
                   <OPTION >女</OPTION></SELECT>
            <!-- <input type="text" name="regPatient.regiserPatient_sex" class="text ui-widget-content ui-corner-all"> -->
        </td>
     </tr>
     <tr>
        <td>出生日期：<input type="text" id="datepicker" name="regPatient.regiserPatient_birthday" class="text ui-widget-content ui-corner-all"></td>
        <td>&nbsp;联系电话：&nbsp;<input id="telephone" type="text"  name="regPatient.regiserPatient_phoneNo" class="text ui-widget-content ui-corner-all"></td>
     </tr>
     <tr>
        <td colspan="2">
            &nbsp;&nbsp;住&nbsp;&nbsp;址:<input type="text" size="50" name="regPatient.regiserPatient_address" class="text ui-widget-content ui-corner-all">
        </td>
        <td colspan="">
           <input type="submit" value="提交">
        <!-- <input type="button" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 30px" 
                              class="text ui-widget-content ui-corner-all" onclick="window.location.href='<%=contextPath %>/RegPatient/save.action';"> --></td>
     </tr>
     
  </table>
  </form>
</body>
</html>