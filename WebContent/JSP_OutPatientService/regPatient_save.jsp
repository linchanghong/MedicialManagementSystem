<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String contextPath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>»¼ÕßÐÅÏ¢±£´æ</title>
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
					yearRange: '1900:2099', //È¡Öµ·¶Î§.
					showOn: 'both', //ÊäÈë¿òºÍÍ¼Æ¬°´Å¥¶¼¿ÉÒÔÊ¹ÓÃÈÕÀú¿Ø¼þ¡£
					buttonImage: '../image/CRUD_image/calendar.gif', //ÈÕÀú¿Ø¼þµÄ°´Å¥
					buttonImageOnly: true,
					showButtonPanel: true,
					dateFormate:'yy-MM-dd'
				});	
			
			$("#telephone").blur(function(){
				if(!(/(^(\d{3,4}-)?\d{7,8})$|(^1[3|4|5|8][0-9]{9})/.test($("#telephone").val()))){
					        alert("²»ÊÇÕýÈ·µÄ11Î»ÊÖ»úºÅ»òÕßÕýÈ·µÄ¹Ì»°");
					        $("#telephone").val("");
					    }
			});
				
			});
		</script>
</head>
<body>
  <a href="<%=contextPath %>/RegPatient/queryAll.action" target="main">µã»÷´Ë´¦Ìø×ªµ½Ê×Ò³</a>
  <p>ÇëÔÚÏÂÃæÌîÈë»¼ÕßµÄÏà¹ØÐÅÏ¢</p>
  <form action="<%=contextPath %>/RegPatient/save.action" method="post">
  <table width="" >
    <!--  <tr>
        <td colspan="3">
          <input type="hidden" name="regPatient.regiserPatient_id" />
        </td>
     </tr> -->
     <tr>
        <td>
            &nbsp;&nbsp;²¡ÀúºÅ£º<input type="text" width="100" name="regPatient.regiserPatient_caseNo" id="regiserPatient_caseNo" readonly value="<%=request.getAttribute("regiserPatient_caseNo") %>" class="text ui-widget-content ui-corner-all">
        </td>
        <td>
            &nbsp;&nbsp;&nbsp;&nbsp; ÐÕÃû£º   <input type="text" name="regPatient.regiserPatient_name" class="text ui-widget-content ui-corner-all" > 
        </td>
        <td>
            &nbsp;&nbsp;ÐÔ±ð:<SELECT style="WIDTH: 100px;height:20px" name="regPatient.regiserPatient_sex" class="text ui-widget-content ui-corner-all"> 
                   <OPTION selected>ÄÐ</OPTION> 
                   <OPTION >Å®</OPTION></SELECT>
            <!-- <input type="text" name="regPatient.regiserPatient_sex" class="text ui-widget-content ui-corner-all"> -->
        </td>
     </tr>
     <tr>
        <td>³öÉúÈÕÆÚ£º<input type="text" id="datepicker" name="regPatient.regiserPatient_birthday" class="text ui-widget-content ui-corner-all"></td>
        <td>&nbsp;ÁªÏµµç»°£º&nbsp;<input id="telephone" type="text"  name="regPatient.regiserPatient_phoneNo" class="text ui-widget-content ui-corner-all"></td>
     </tr>
     <tr>
        <td colspan="2">
            &nbsp;&nbsp;×¡&nbsp;&nbsp;Ö·:<input type="text" size="50" name="regPatient.regiserPatient_address" class="text ui-widget-content ui-corner-all">
        </td>
        <td colspan="">
           <input type="submit" value="Ìá½»">
        <!-- <input type="button" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 30px" 
                              class="text ui-widget-content ui-corner-all" onclick="window.location.href='<%=contextPath %>/RegPatient/save.action';"> --></td>
     </tr>
     
  </table>
  </form>
</body>
</html>