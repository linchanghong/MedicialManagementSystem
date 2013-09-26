<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
%>
<%@ page import="com.OutPatientService.model.MZ_PrescriptionDetails"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>门诊收费管理</title>
<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
table#ShowTable {
	border-collapse: collapse;
	border: 1px solid #ccc;
}

table#ShowTable td {
	border: 1px solid #ccc;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
.color{
	background-color:#FFFFC8
}
</style>
<!-- 内联样式 -->
<script type="text/javascript">
//定义一个变量用于存放XMLHttpRequest对象

function hello(e)
{
	 document.getElementById("selectDrugName").value=e.cells[1].innerHTML;
	 document.getElementById("selectDrugStandard").value=e.cells[2].innerHTML;
}


//动态增加行
function addRow(index,object){
	var newTr=document.getElementById("ShowTable").insertRow(index);
	newTr.onmouseover=addTrColor;
	newTr.onmouseout=deleteTrColor;
	
	if(index%2==0) {
		newTr.className = "color";
	}
	var newTd0=newTr.insertCell(0);
	var newTd1=newTr.insertCell(1);
	var newTd2=newTr.insertCell(2);
	var newTd3=newTr.insertCell(3);
	var newTd4=newTr.insertCell(4);
	var newTd5=newTr.insertCell(5);
	var newTd6=newTr.insertCell(6);
	var newTd7=newTr.insertCell(7);
	var newTd8=newTr.insertCell(8);
	newTd0.innerHTML=index;
	newTd1.innerHTML=object.prescription_drugName;
	newTd2.innerHTML=object.prescription_drugStandard;
	newTd3.innerHTML=object.prescription_drugNumber;
	newTd4.innerHTML=object.prescription_drugUnit;
	newTd5.innerHTML=object.prescription_drugNumber;
	newTd6.innerHTML=object.prescription_drugDoseonce;
	newTd7.innerHTML=object.prescription_drugdoseunit;
	newTd8.innerHTML=object.prescription_drugRate;
	newTr.onclick=function()
	{
		 document.getElementById("selectDrugName").value=this.cells[1].innerHTML;
		 document.getElementById("selectDrugStandard").value=this.cells[2].innerHTML;
	};
}

	function addTrColor() {
		this.style.background = "#D0FFE8";
	}

	function deleteTrColor() {
		this.style.background = "";
	}

	var xmlhttp;
	var oldInvoiceNumber = "";
	//创建一个XMLHttpRequest对象的标准函数，多个AJAX都可以调用
	function loadXMLDoc(url, cfunc) {
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
			//alert(xmlhttp.status);
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			//alert(xmlhttp.status);
		}
		xmlhttp.onreadystatechange = cfunc;
		xmlhttp.open("GET", url, true);
		xmlhttp.send(null);
	}

	function processPrescription() {
		
		var invoiceNum =document.getElementById("invoiceNumber").value;
		
		if(oldInvoiceNumber!=invoiceNum)
			{

		loadXMLDoc("<%=contextPath %>/JSP_OutPatientService/ShowDrugDetailByInvoiceNumber?invoiceNum="+invoiceNum,
		function()
			{   	 		
			
			if(xmlhttp.readyState==4&&xmlhttp.status==200 )
	           { 		
				
				if(xmlhttp.responseText.length <= 42)
					{				
		    		  document.getElementById('ErrorWorn').innerHTML=xmlhttp.responseText;
		    		}
		    	  else
		    		  {
		  			oldInvoiceNumber=invoiceNum;
		    		  	var info=JSON.parse(xmlhttp.responseText);
		    		  	document.getElementById('ErrorWorn').innerHTML="";
		    	        document.getElementById("caseNumber").value=info.drugstore_Dosage[0].patientCaseNumber;	    	        
		    	        document.getElementById("name").value=info.drugstore_Dosage[0].patientName;
		    	        document.getElementById("Contractunit").value="现金";
		    	        document.getElementById("totalPrice").value=info.drugstore_Dosage[0].prescription_drugTotalprice;
		    	        document.getElementById("selfPrice").value=info.drugstore_Dosage[0].prescription_drugTotalprice;
		    	        document.getElementById("selfPayPrice").value="0";
		    	        document.getElementById("chargePrice").value="0";		    	
		    	        for(var i=0; i<info.drugstore_Dosage.length; i++)
		    	        {		    	        	
		    	        	addRow(i+1, info.drugstore_Dosage[i]);		    	  
			    	           
		    	        }
		    		  }
		    	  
		    	 }   		 
			}
	 );
			}
	   
	
}


</script>
<style type="text/css">
div#ErrorWorn{
	color: red;
	font-size: small;
	}
</style>
</head>

<body>
	<div id="container">
		<div id="header" style="background-color: #FFFFE8;">
			<table>
				<tr align="center">
					<td><img id="saveAccurately" src="../image/bg_image/save.png"></td>
					<td><img id="return" src="../image/Drug_image/return.png"></td>
					<td><a href="../JSP_OutPatientService/ReturnDrug.jsp"><img id="cleanScreen"
						src="../image/bg_image/cleanScreen.png"></a></td>
					<td><a href="javascript:parent.location.reload();"><img id="exit" src="../image/bg_image/exit.png" border="0"></a></td>
				</tr>
				<tr align="center">
					<td>确定审核</td>
					<td>全退</td>
					<td>清空</td>
					<td>退出</td>
				</tr>
			</table>
		</div>

		<form name="prescription_frm"
			action="<%=contextPath %>/JSP_OutPatientService/ShowDrugDetailByInvoiceNumber.action"
			method="post">
			<div id="users-contain">
			<div id="ErrorWorn"></div>
				<table>
					<tr>
						<td>发票号：</td>
						<td><input id="invoiceNumber" type="text"
							name="invoice_num" onblur="processPrescription()"
							></td>
						<td>病历号：</td>
						<td><input type="text" id="caseNumber" name="" readonly  ></td>
						<td>姓名：</td>
						<td><input type="text" id="name" name="" readonly></td>

					</tr>
					<tr>

						<td>合同单位:</td><td><input type="text" id="Contractunit" name="" readonly></td>
						<td>总金额：</td>
						<td><input type="text" id="totalPrice" name="" size="20" readonly></td>
						<td>自费金额：</td>
						<td><input type="text" id="selfPrice" name="" size="20"
							readonly></td>
					</tr>
					<tr>

						<td>自付金额：</td>
						<td><input type="text" id="selfPayPrice" name="" size="20" readonly></td>
						<td>记账金额：</td>
						<td><input type="text" id="chargePrice" name="" size="20" readonly></td>
						</tr>
						
					
				</table>
			</div>

			<hr size="2">

			<div id="users-contain">
			<font size="4"><b>药品展示：</b></font>
				<table border="0" align=center width="100%" align="center"
					cellpadding="0" cellspacing="0" style="border-collapse: collapse;"
					id="ShowTable">
					<tr>
						<th>序号</th>
						<th>药品名称</th>
						<th>药品规格</th>
						<th>数量</th>
						<th>显示单位</th>
						<th>可退数量</th>
						<th>用量</th>
						<th>剂量单位</th>
						<th>频次</th>
					</tr>
				</table>
				<br /> <img src="../image/bg_image/addItem.png" title="添加退费项目"
					border="0">
			</div>
		</form>

		<hr size="2">
		<div id="slect">
			<table>
				<tr>
					<td>项目名称：</td>
					<td><input id="selectDrugName" type="text" readonly></td>
					<td>规格：</td>
					<td><input id="selectDrugStandard" type="text" readonly></td>
					<td>退费数量：</td>
					<td><input type="text" ></td>					
				</tr>
			</table>
		</div>
		<hr>
		<div>
			<table  align=center width="100%" align="center"
					cellpadding="0" cellspacing="0" style="border-collapse: collapse;" >
			<tr>
				<th>序号</th>
				<th>已退药名称</th>
				<th>规格</th>
				<th>已退数量</th>
				<th>单位</th>
				<th>标识</th>
				<th>单价</th>
				<th>金额</th>
				</tr>
			</table>
		</div>
		
	</div>


</body>
</html>