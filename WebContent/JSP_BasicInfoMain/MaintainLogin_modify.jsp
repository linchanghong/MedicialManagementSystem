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
   <h4 align="center">用户信息修改</h4>
   <form action="<%=contextPath %>/LoginMaintain/modify2.action" method="post">
      <table align=center>
         <tr>
           <td>用户名：</td>
           <td><input type="text" name="login_name" value="${loginmodifyInfo.login_name}"></td>
           <td><input type="hidden" name="id" value="${loginmodifyInfo.login_id}"></td>
         </tr>
         <tr>
           <td>密码：</td>
           <td><input type="text" name="login_password" value="${loginmodifyInfo.login_password}"></td>
         </tr>
         <tr>
           <td>权限类型：</td>
           <td><input type="text" name="login_type" value="${loginmodifyInfo.login_type}"></td>
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