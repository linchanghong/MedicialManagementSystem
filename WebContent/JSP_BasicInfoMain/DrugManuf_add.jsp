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
</head>
<h4>新建生产商信息</h4>
<body>
     <form action="<%=contextPath %>/DrugManuf/add.action" method="post">
       <table align=center>
         <tr>
           <td>生产商编码：</td>
           <td><input type="text" name="drugManuf_number"></td>
         </tr>
         <tr>
           <td>生产商名称：</td>
           <td><input type="text" name="drugManuf_name"></td>
         </tr>
         <tr>
           <td>生产商助记码：</td>
           <td><input type="text" name="drugManuf_zjm"></td>
         </tr>
         <tr>
           <td>生产商电话：</td>
           <td><input type="text" name="drugManuf_telephone"></td>
         </tr>
         <tr>
           <td>生产商地址：</td>
           <td><input type="text" name="drugManuf_address"></td>
         </tr>
         <tr>
           <td>生产商邮编：</td>
           <td><input type="text" name="drugManuf_postcode"></td>
         </tr>
         <tr>
           <td>生产商传真：</td>
           <td><input type="text" name="drugManuf_fax"></td>
         </tr>
         <tr>
           <td>联系人：</td>
           <td><input type="text" name="drugManuf_linkman"></td>
         </tr>

         <tr>
           <td><input type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></td>
           <td><input type="reset" value="" style="background-image:url(../image/CRUD_image/Reset.png);width: 100px; height: 26px"></td>
         </tr>
       </table>
     </form>
</body>
</html>