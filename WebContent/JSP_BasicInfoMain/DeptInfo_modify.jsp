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
   <h4 align="center">科室信息修改</h4>
   <form action="<%=contextPath %>/DeptInfo/modify2.action" method="post">
      <table align=center>
         <tr>
           <td>科室编码：</td>
           <td><input type="text" name="deptInfo_number" value="${modifyInfo.deptInfo_number}"></td>
           <td><input type="hidden" name="id" value="${modifyInfo.deptInfo_id}"></td>
         </tr>
         <tr>
           <td>科室名称：</td>
           <td><input type="text" name="deptInfo_name" value="${modifyInfo.deptInfo_name}"></td>
         </tr>
         <tr>
           <td>科室助记码：</td>
           <td><input type="text" name="deptInfo_zjm" value="${modifyInfo.deptInfo_zjm}"></td>
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