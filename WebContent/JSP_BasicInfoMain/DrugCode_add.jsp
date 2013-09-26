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
<title>新建药品编码</title>
</head>
<h3 align="center">药品编码维护</h3>
<h4>新建药品编码</h4>
<body>
	<form action="<%=contextPath%>/DrugCode/drugcode_Add"
		onSubmit="return validate();">
		<table align=center>
			<tr>
				<td>药品编码：</td>
				<td><input type="text" name="drugcode.drugCode_number"
					onblur="checkcode(this,'<%=contextPath%>/DrugCode/drugcode_Exists')"></td>
				<td width="150px"><span id="codemessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>助 记 码：</td>
				<td><input id="zjm" type="text" name="drugcode.drugCode_zjm"
					onblur="checkzjm()"></td>
				<td width="150px"><span id="zjmmessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value=""
					style="background-image: url(../image/CRUD_image/save1.png); width: 100px; height: 26px"></td>
				<td><input type="reset" value=""
					style="background-image: url(../image/CRUD_image/Reset.png); width: 100px; height: 26px"></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		function validate() {
			if (ajaxCallback() && checkzjm() && checkflag()) {
				return true;
			} else {
				return false;
			}
		}
		var xmlHttpRequest = null;
		function checkcode(field, url) {
			var code = field.value;
			var flag = null;
			if (code == "") {
				document.getElementById("codemessage").innerHTML = "*编码不能为空";
				flag = 0;
				return false;
			} else {
				if (window.ActiveXObject) {
					xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} else if (window.XMLHttpRequest) {
					xmlHttpRequest = new XMLHttpRequest();
				}
				if (null != xmlHttpRequest) {
					xmlHttpRequest.open("get", url
							+ "?drugcode.drugCode_number=" + code, true);
					xmlHttpRequest.onreadystatechange = ajaxCallback;
					xmlHttpRequest.send(null);
				}
			}
		}
		function ajaxCallback() {
			if (xmlHttpRequest.readyState == 4) {
				if (xmlHttpRequest.status == 200) {
					var responseText = xmlHttpRequest.responseText;
					if (responseText != "") {
						document.getElementById("codemessage").innerHTML = responseText;
						return false;
					} else {
						document.getElementById("codemessage").innerHTML = "";
						return true;
					}
				}
			}
		}

		function checkzjm() {
			var zjm = document.getElementById("zjm").value;
			if (zjm == "") {
				document.getElementById("zjmmessage").innerHTML = "*助记码不能为空";
				return false;
			} else {
				document.getElementById("zjmmessage").innerHTML = "";
				return true;
			}
		}

		function checkflag() {
			if (flag == 0) {
				return false;
			} else {
				return true;
			}
		}
	</script>
</body>
</html>