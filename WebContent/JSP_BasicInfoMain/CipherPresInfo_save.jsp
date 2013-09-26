<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form action="<%=contextPath %>/CiphPres/save.action" method="post">
  <fieldset>
         <table>
           <!--  <tr><td>
             <input type="hidden" name="cipherPres.cipherPres_id" id="cipherPres_id" />
           <td></tr>-->
           <tr><td>
             <input type="hidden" name="cipherPres.cipherPres_id" id="cipherPres_id" />
           </td><tr>
             <td>
                                           ´¦·½Ãû³Æ:&nbsp;<input type="text"
					name="cipherPres.cipherPres_name" id="cipherPres_name"
					class="text ui-widget-content ui-corner-all" /> 
             </td>
             
             <td>
                &nbsp;&nbsp;´¦·½±àºÅ:&nbsp;<input type="text" name="cipherPres.cipherPres_number"
					id="cipherPres_number" class="text ui-widget-content ui-corner-all" />
             </td>
             
             <td>
           &nbsp;&nbsp;½û¼É:<input type="text" name="cipherPres.cipherPres_taboo" size=""
					id="cipherPres_taboo" class="text ui-widget-content ui-corner-all" />
             </td>
           </tr>
           <tr>
             <td colspan="3">Ò©Îï×é³É:&nbsp;<textarea
					name="cipherPres.cipherPres_drugsof"  id="cipherPres_drugsof"
					class="text ui-widget-content ui-corner-all" style="width: 350px;" ></textarea> </td>
           </tr>
           <tr>
             <td colspan="3">¹¦Ð§Ö÷ÖÎ:&nbsp;<textarea
					name="cipherPres.cipherPres_efficacy"  id="cipherPres_efficacy"
					class="text ui-widget-content ui-corner-all" style="width: 350px;"></textarea></td>
           </tr>
           <tr>
             <td colspan="3">ÊÊÓ¦Ö¢:&nbsp;&nbsp;<textarea name="cipherPres.cipherPres_indication" id="cipherPres_indication"
					class="text ui-widget-content ui-corner-all" style="width: 350px;"></textarea>
					
		    &nbsp;&nbsp;&nbsp;<input type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px">
           </td></tr>
         </table>
			</fieldset>
	 </form>
</body>
</html>