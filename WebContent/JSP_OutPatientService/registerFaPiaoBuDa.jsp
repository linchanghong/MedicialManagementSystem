<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
       <%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<style>
div#container
div#header {background-color:#CCCCCC;}
div#footer {background-color:#CCCCCC;clear:both;text-align:center;}
</style>
</head>
<body>
<div id="container">
<div id="header"><h3 align=center>挂号发票补打</h3></div>
<br/>
<form action="<%=contextPath %>/Register/registerBuDa.action">
   <table align=center>
     <tr>
      <td>处方号：</td>
      <td><input type="text" name="chuFangHao"></td>
      <td><input type="submit" value="查询" style=";width:50px;height:30px"></td>
     </tr>
   </table>
</form>
<br/>
<div id="footer">挂号管理</div>
</div>
</body>
</html>