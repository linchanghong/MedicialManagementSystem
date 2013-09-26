<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.BasicInfoManagement.model.JC_YP_Incompatibility" %>
    <%
String contextPath = request.getContextPath();
//JC_YP_Incompatibility incom=(JC_YP_Incompatibility)request.getAttribute("incom");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ÅäÎé½û¼ÉÐÅÏ¢ÐÞ¸Ä</title>
<style type="text/css">
div#header {
   background-color:#99bbbb;
   text-align:center;
                
   }
   div.content {
   background-color:#99CCFF;
   text-align:center;
   }
</style>
</head>
<!-- <style type="text/css">

  .title_main{font-size:24px; color:#f00; line-height:20px;} 
  .tableset{
    color:#666633;
  }

  </style>
 -->
<body>
  <form action="<%=contextPath %>/Icom/update.action" method="post">
   <div id="header"><h1>½ûÅäÒ©Æ·ÐÞ¸Ä±í</h1></div>
   <div class="content">
    <table>
     <!-- <caption align="top" class="">½ûÅäÒ©Æ·ÐÞ¸Ä±í</caption> -->
       <tr>
           <td>
                                        ±àºÅ£º
           </td>
           <td>
               <input type="text" name="incompatibility_id" readonly value="${ incom.incompatibility_id}">
           </td>
       </tr>
       <tr>
           <td>
                                       Ò©Æ·Ãû³Æ£º
           </td>
           <td>
               <input type="text" name="incompatibility_drugA"  value="${incom.incompatibility_drugA }" >
           </td>
       </tr>
       <tr>
           <td>
                                      ½ûÅäÒ©Æ·Ãû³Æ£º
           </td>
           <td>
               <input type="text" name="incompatibility_drugB"  value="${incom.incompatibility_drugB }">
           </td>
       </tr>
       <tr>
           <td>
                                       ÅäÖÃ½á¹û£º
           </td>
           <td>
               <input type="text" name="incompatibility_result"  value="${incom.incompatibility_result }">
           </td>
       </tr>
       <tr>
          <td colspan="2" align="right">
               <input type="submit"  value="" style="background-image:url(../image/CRUD_image/modify1.png);width: 80px; height: 28px">
          </td>
       </tr>
   </table>
   </div>
   </form>
</body>
</html>