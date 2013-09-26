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
<body>
   <h4 align="center">门诊挂号种类信息修改</h4>
   <form action="<%=contextPath %>/OutpatientRegistration/modify2.action" method="post">
      <table align=center>
         <tr>
           <td>门诊挂号名称：</td>
           <td><input type="text" name="outpatientRegistration_name" value="${RegistrationmodifyInfo.outpatientRegistration_name}"></td>
           <td><input type="hidden" name="id" value="${RegistrationmodifyInfo.outpatientRegistration_id}"></td>
         </tr>
         <tr>
           <td>门诊挂号编号：</td>
           <td><input type="text" name="outpatientRegistration_number" value="${RegistrationmodifyInfo.outpatientRegistration_number}"></td>
         </tr>
         <tr>
           <td>门诊挂号价格：</td>
           <td><input type="text" name="outpatientRegistration_price" value="${RegistrationmodifyInfo.outpatientRegistration_price}"></td>
         </tr>    
         <tr>
           <td>助记码：</td>
           <td><input type="text" name="outpatientRegistration_zjm" value="${RegistrationmodifyInfo.outpatientRegistration_zjm}"></td>
         </tr>
         <tr>
           <td><input id="modifyOrNot" type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></td>
           <td><input type="reset" value="" style="background-image:url(../image/CRUD_image/Reset.png);width: 100px; height: 26px"></td>
         </tr>
       </table>
   </form>
   <script type="text/javascript">
	
	document.getElementById("modifyOrNot").onclick=function(){
		confirm("确定修改吗？");
		}
</script>
</body>
</html>