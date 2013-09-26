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
<title>�����շѹ���</title>
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
<!-- ������ʽ -->
<script type="text/javascript">
//����һ���������ڴ��XMLHttpRequest����

function hello(e)
{
	 document.getElementById("selectDrugName").value=e.cells[1].innerHTML;
	 document.getElementById("selectDrugStandard").value=e.cells[2].innerHTML;
}


//��̬������
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
	//����һ��XMLHttpRequest����ı�׼���������AJAX�����Ե���
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
		    	        document.getElementById("Contractunit").value="�ֽ�";
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
					<td>ȷ�����</td>
					<td>ȫ��</td>
					<td>���</td>
					<td>�˳�</td>
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
						<td>��Ʊ�ţ�</td>
						<td><input id="invoiceNumber" type="text"
							name="invoice_num" onblur="processPrescription()"
							></td>
						<td>�����ţ�</td>
						<td><input type="text" id="caseNumber" name="" readonly  ></td>
						<td>������</td>
						<td><input type="text" id="name" name="" readonly></td>

					</tr>
					<tr>

						<td>��ͬ��λ:</td><td><input type="text" id="Contractunit" name="" readonly></td>
						<td>�ܽ�</td>
						<td><input type="text" id="totalPrice" name="" size="20" readonly></td>
						<td>�Էѽ�</td>
						<td><input type="text" id="selfPrice" name="" size="20"
							readonly></td>
					</tr>
					<tr>

						<td>�Ը���</td>
						<td><input type="text" id="selfPayPrice" name="" size="20" readonly></td>
						<td>���˽�</td>
						<td><input type="text" id="chargePrice" name="" size="20" readonly></td>
						</tr>
						
					
				</table>
			</div>

			<hr size="2">

			<div id="users-contain">
			<font size="4"><b>ҩƷչʾ��</b></font>
				<table border="0" align=center width="100%" align="center"
					cellpadding="0" cellspacing="0" style="border-collapse: collapse;"
					id="ShowTable">
					<tr>
						<th>���</th>
						<th>ҩƷ����</th>
						<th>ҩƷ���</th>
						<th>����</th>
						<th>��ʾ��λ</th>
						<th>��������</th>
						<th>����</th>
						<th>������λ</th>
						<th>Ƶ��</th>
					</tr>
				</table>
				<br /> <img src="../image/bg_image/addItem.png" title="����˷���Ŀ"
					border="0">
			</div>
		</form>

		<hr size="2">
		<div id="slect">
			<table>
				<tr>
					<td>��Ŀ���ƣ�</td>
					<td><input id="selectDrugName" type="text" readonly></td>
					<td>���</td>
					<td><input id="selectDrugStandard" type="text" readonly></td>
					<td>�˷�������</td>
					<td><input type="text" ></td>					
				</tr>
			</table>
		</div>
		<hr>
		<div>
			<table  align=center width="100%" align="center"
					cellpadding="0" cellspacing="0" style="border-collapse: collapse;" >
			<tr>
				<th>���</th>
				<th>����ҩ����</th>
				<th>���</th>
				<th>��������</th>
				<th>��λ</th>
				<th>��ʶ</th>
				<th>����</th>
				<th>���</th>
				</tr>
			</table>
		</div>
		
	</div>


</body>
</html>