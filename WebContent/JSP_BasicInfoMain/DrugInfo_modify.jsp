<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%
	String contextPath = request.getContextPath();
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ҩƷ��Ϣ�޸�</title>
</head>
<body>
   <h3 align="center">ҩƷ��Ϣ�޸�</h3>
	<form action="<%=contextPath%>/DrugInfo/druginfo_Modify" method="post" onSubmit="return check()">
		<table align=center>
		    <tr>
				<td>ҩƷ���ƣ�</td>
				<td><input type="text" value="${modifyDrugInfo.drugInfo_name }" name="druginfo.drugInfo_name" width="150px" readonly="readonly"></td>
				<td width="150px"><span id="namemessage" style="color: red;"></span></td>
				<td width="10px"><input type="hidden" name="modifyid" value="${modifyDrugInfo.drugInfo_id}"></td>
			</tr>
			<tr>
				<td>ҩƷ���룺</td>
				<td><input type="text" value="${modifyDrugInfo.drugCode.drugCode_number }" name="drugCode" readonly="readonly">
			</tr>
			<tr>
				<td>ҩƷ���</td>
				<td><input id="standard" type="text" value="${modifyDrugInfo.drugInfo_standard }" name="druginfo.drugInfo_standard" onblur="checkstandard()"></td>
				<td width="150px"><span id="standardmessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>ҩƷ���ࣺ</td>
				<td><input type="text" value="${modifyDrugInfo.drugCategory.drugCategory_name }" name="categoryName" readonly="readonly">
			</tr>
			<tr>
				<td>ҩƷ�����̣�</td>
				<td><input id="getsupplier" type="text" value="${modifyDrugInfo.drugManuf.drugManuf_name }" name="supplier" width="120px" onblur="checksupplier()">
				<img src="../image/CRUD_image/find.gif" onclick="findsupplier()" ></td>
				<td width="150px"><span id="suppliermessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>��׼���֣�</td>
				<td><input id="approve" type="text" value="${modifyDrugInfo.drugInfo_approve }" name="druginfo.drugInfo_approve" onblur="checkapprove()"></td>
				<td width="150px"><span id="approvemessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>���۷��ࣺ</td>
				<td><input id="saleclassification" type="text" value="${modifyDrugInfo.drugInfo_saleclassification }" name="druginfo.drugInfo_saleclassification" onblur="checksaleclassification()"></td>
				<td width="150px"><span id="saleclassificationmessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>���ͣ�</td>
				<td><input id="dosage" type="text" value="${modifyDrugInfo.drugInfo_dosage }" name="druginfo.drugInfo_dosage" onblur="checkdosage()"></td>
				<td width="150px"><span id="dosagemessage" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>�� �� �룺</td>
				<td><input id="zjm" type="text" value="${modifyDrugInfo.drugInfo_zjm }" name="druginfo.drugInfo_zjm"onblur="checkzjm()"></td>
				<td width="150px"><span id="zjmmessage" style="color: red;"></span></td>
			</tr>
         <tr>
           <td><input id="modifyOrNot" type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></td>
           <td><input type="reset" value="" style="background-image:url(../image/CRUD_image/Reset.png);width: 100px; height: 26px"></td>
         </tr>
		</table>
	</form>

    <script type="text/javascript">

	function check(){
		if(checkstandard()&&checksupplier()&&checkapprove()&&checksaleclassification()&&checkdosage()&&checkzjm()){
			return true;
		}else{
			return false;
		}
	}

	function checkstandard() {
		var str = document.getElementById("standard").value;
		if (str == "") {
			document.getElementById("standardmessage").innerHTML = "*ҩƷ�����Ϊ��";
			return false;
		}else{
			document.getElementById("standardmessage").innerHTML = "";
			return true;
		}
	}
	
	function checksupplier() {
		var str =document.getElementById("getsupplier").value;
		if (str == "") {
			document.getElementById("suppliermessage").innerHTML = "*�������̲���Ϊ��";
			return false;
		}else{
			document.getElementById("suppliermessage").innerHTML = "";
			return true;
		}
	}
	
	function checkapprove() {
		var str =document.getElementById("approve").value;
		if (str == "") {
			document.getElementById("approvemessage").innerHTML = "*��׼���ֲ���Ϊ��";
			return false;
		}else{
			document.getElementById("approvemessage").innerHTML = "";
			return true;
		}
	}
    
	function checksaleclassification() {
		var str =document.getElementById("saleclassification").value;
		if (str == "") {
			document.getElementById("saleclassificationmessage").innerHTML = "*�������Ͳ���Ϊ��";
			return false;
		}else{
			document.getElementById("saleclassificationmessage").innerHTML = "";
			return true;
		}
	}
	
	function checkdosage() {
		var str = document.getElementById("dosage").value;
		if (str == "") {
			document.getElementById("dosagemessage").innerHTML = "*���Ͳ���Ϊ��";
			return false;
		}else{
			document.getElementById("dosagemessage").innerHTML = "";
			return true;
		}
	}
	
	function checkzjm() {
		var str = document.getElementById("zjm").value;
		if (str == "") {
			document.getElementById("zjmmessage").innerHTML = "*�����벻��Ϊ��";
			return false;
		}else{
			document.getElementById("zjmmessage").innerHTML = "";
			return true;
		}
	}
		function findsupplier(){
			window.open('<%=contextPath %>/DrugManuf/findAll','newwindow', 'height=450px, width=800px,  toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
		}
	</script>
</body>
</html>