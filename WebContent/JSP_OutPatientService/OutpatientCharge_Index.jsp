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
<link href="mystyle.css"  rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.9.1.js"></script>
<style type="text/css">
[title=border]{border:#CCCCFF solid thin;}
</style><!-- ������ʽ -->
<script type="text/javascript">
//����һ���������ڴ��XMLHttpRequest����




//��̬������
function addRaw(list){
	var newTr=document.getElementById("presDetails_tb").insertRow();
	for(var i=0;i<list.size();i++){
	var newTd0=newTr.insertCell();
	var newTd1=newTr.insertCell();
	var newTd2=newTr.insertCell();
	var newTd3=newTr.insertCell();
	var newTd4=newTr.insertCell();
	var newTd5=newTr.insertCell();
	var newTd6=newTr.insertCell();
	var newTd7=newTr.insertCell();
	var newTd8=newTr.insertCell();
	var newTd9=newTr.insertCell();
	var newTd10=newTr.insertCell();
	var newTd11=newTr.insertCell();
	var newTd12=newTr.insertCell();
	var newTd13=newTr.insertCell();
	var newTd14=newTr.insertCell();
	var newTd15=newTr.insertCell();
	var newTd16=newTr.insertCell();
	newTd0.innerHTML=i;
	
	}
	
}


</script>
</head>

<body>
<div id="container">
<div id="header" >
<table >
<tr align="center">
<td><img id="saveAccurately" src="../image/bg_image/save.png"></td>
<td><img id="charge" src="../image/bg_image/charge.png"></td>
<td><img id="cleanScreen" src="../image/bg_image/cleanScreen.png"></td>
<td><a href="../index.jsp"><img id="exit" src="../image/bg_image/exit.png" border="0"></a></td></tr>
<tr align="center"><td>���滮��</td><td>ȷ���շ�</td><td>����</td><td>�˳�</td></tr>
</table>
</div>

<form name="prescription_frm" action="<%=contextPath %>/charge/findPrescription.action" method="post">
<div id="left">
<table>
<tr>
<td>�����ţ�</td><td><input id="casenumber" type="text" name="invoiceDetail.card_no" onblur="processPrescription()" size="20" ></td>
<td>����������</td><td><input type="text" id="name" name="" size="20" readonly></td>
<td>�ձ�<input type="text" id="sex" name="" size="10" readonly></td>
<td>����:<input type="text" id="age" name="" size="5" readonly></td>
</tr>
<tr>
<td>�����ţ�</td><td><input type="text" id="number" name="" size="20" readonly></td>
<td>������ң�</td><td><input type="text" id="doctordept"  name="" size="20" readonly></td>
<td>����ҽ����</td><td><input type="text" id="doctor" name="" size="20" readonly></td>
<!-- <td>��ͬ��λ��</td><td><input type="text" name="" size="20"></td> -->
</tr>
</table>
</div>

<div id="right" title="border">
<input type="checkbox">
<br/><br/><br/>
</div>

<hr size="2">

<div id="content" >
<font size="4" ><b>�ۼƽ�</b></font>
<table id="presDetails_tb" border="1" width="750" align="center" cellpadding="0" cellspacing="0">
<tr><th>���</th><th>����</th><th>����</th><th>����</th><th>��ʾ��λ</th><th>����</th><th>����</th><th>������λ</th><th>��</th>
<th>Ƶ��</th><th>�÷�</th><th>ִ�п���</th><th>���</th><th>����</th><th>С��</th><th>����</th><th>��ע</th></tr>
</table>
<br/>
<img src="../image/bg_image/addItem.png" title="����շ���Ŀ" border="0" >
</div>
</form>

<hr size="2">

<div id="footer">
<p><b>ҽ������ͳһ�շ�(����)</b>&nbsp;&nbsp;&nbsp;&nbsp;
------Ʊ�ݺţ�<input type="text" size="20"> <input type="submit" value="����">
</p>
<table>
<tr><td>�Էѽ�</td><td><input type="text" size="20"></td><td>�Ը���</td><td><input type="text" size="20"></td>
<td>���˽�</td><td><input type="text" size="20"></td></tr>
<tr><td>ʵ���ֽ�</td><td><input type="text" size="20"></td><td>�����</td><td><input type="text" size="20"></td>
<td>ҩƷ�ܶ</td><td><input type="text" size="20"></td></tr>
<tr><td>��ҩҩ����</td><td><input type="text" size="20"></td><td>�ܼǣ�</td><td><input type="text" size="20"></td></tr>
</table>
<p title="border"><br/></p>
</div>

</div>

<script type="text/javascript">
var xmlHttp;
//����һ��XMLHttpRequest����ı�׼���������AJAX�����Ե���
function loadXMLDoc(url,cfunc)
{
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=cfunc;
xmlhttp.open("GET",url,true);
xmlhttp.send();
}

  function processPrescription()  
  {    
  	   var caseNo=document.getElementById("casenumber").value;
  	   loadXMLDoc("<%=contextPath %>/charge/findPrescription.action?caseNo="+caseNo,function()
  			{   	 
			 if(xmlHttp.readyState==4&&xmlhttp.status==200)
		           { 
    		    	 var info=JSON.parse(xmlHttp.responseText);
    		    	  if(info.pres==null)
    		    		{
    		    		  alert("�ò����Ų����ڣ����������");
    		    		}
    		    	  else
    		    		  {
    		    		   //alert("++++++"+info.pres.prescription_name);
    		    		    
    		    	        document.getElementById("name").value=info.pres.prescription_name;
    		    	        document.getElementById("sex").value=info.pres.prescription_sex;
    		    	        document.getElementById("age").value=info.pres.prescription_age;
    		    	        document.getElementById("number").value=info.pres.prescription_number;
    		    	        document.getElementById("doctordept").value=info.pres.prescription_doctordept;
    		    	        document.getElementById("doctor").value=info.pres.prescription_doctor;
    		    	        
    		    		  }
    		    	  //alert("++++++"+info.pres.prescription_name);
    		    	 }     		 
  			}
  	 );
  	   
  	
  }


</script>
</body>
</html>