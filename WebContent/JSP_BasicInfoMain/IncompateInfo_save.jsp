<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>���������Ϣ����</title>
<style type="text/css">
   table#border{
      border-top:#000 1px solid;
      border-left:#000 1px solid;
   }
   table#border td{
      border-bottom:#000 1px solid;
      border-right:#000 1px solid;
   }
</style>
</head>
<body>
<form action="<%=contextPath %>/Icom/save.action" method="post">
<table  width="350" align=center>
<br/>
<br/>
    <caption align="top">����ҩƷ�����</caption>
      <tr>
         <td>
                             ҩƷ����:
         </td>
         <td>
            <input type="text" name="a"></input>
         </td>
      </tr>
      <tr>
         <td>
                              ����ҩƷ���ƣ�
         </td>
         <td>
            <input type="text" name="b"></input>
         </td>
      </tr>
      <tr>
         <td>
                                ���ý����
         </td>
         <td>
            <input type="text" name="result"></input>
         </td>
      </tr>
      <tr>
         <td colspan="2" align="right">
            <input type="submit" id="save" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></input>
         </td>
      </tr>
</table>
</form>
<script type="text/javascript">
	
	document.getElementById("save").onclick=function(){
		confirm("����ɹ�");
		}
</script>
</body>
</html>