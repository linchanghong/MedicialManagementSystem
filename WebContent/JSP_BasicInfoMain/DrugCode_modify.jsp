<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
  <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <h4 align="center">药品编码修改</h4>
   <form action="<%=contextPath %>/DrugCode/drugcode_Modify" method="post">
      <table align=center>
         <tr>
           <td>药品编码：</td>
           <td><input type="text" name="drugcode.drugCode_number" readonly="readonly"  value="${modifyDrugCodeInfo.drugCode_number}"></td>
           <td width="150px"><input type="hidden" name="modifyid" value="${modifyDrugCodeInfo.drugCode_id}"></td>
         </tr>
         <tr>
           <td>助记码：</td>
           <td><input type="text" name="drugcode.drugCode_zjm" value="${modifyDrugCodeInfo.drugCode_zjm}" onblur="checkzjm(this)"></td>
           <td width="150px"><span id="zjmmessage" style="color: red;"></span></td>
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
	
	function checkzjm(field){
		var zjm=field.value;
		if (zjm== "") {
			document.getElementById("zjmmessage").innerHTML = "*助记码不能为空";
			return;
		}else{
			document.getElementById("zjmmessage").innerHTML = "";
			return;
		}
	}
	
</script>
</body>
</html>