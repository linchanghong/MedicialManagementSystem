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

<form action="<%=contextPath %>/Register/changePrescription.action" method="post">
<table>
<tr>
<td>�����ţ�</td>
<td><input type="text" id="number" name="number" size="20" onblur="findPaitent()"></td>

<td>����������</td>
<td><input type="text" id="name" name="name" size="20" readonly></td>
<td>�ձ�<input type="text" id="sex" name="sex" size="10" readonly></td>
<td>����:<input type="text" id="age" name="age" size="5" readonly></td>
</tr>
<tr>
<td>�����ţ�</td><td><input id="casenumber" type="text" name="casenumber" " size="20" ></td>
<td>������ң�</td><td><input type="text" id="doctordept"  name="doctordept" size="20" readonly></td>
<td>����ҽ����</td><td><input type="text" id="doctor" name="doctor" size="20" readonly></td>
<!-- <td>��ͬ��λ��</td><td><input type="text" name="" size="20"></td> -->
<td></td>
</tr>
<tr>
<td>���ã�</td>
<td><input type="text" id="money" name="" size="20" readonly></td>
</tr>
<tr align=center>
<td ><input type="submit" value="ȷ���շ�"></td>
</tr>
</table>
</form>


<script type="text/javascript">
//����һ���������ڴ��XMLHttpRequest����
var xmlHttp;

//�ú������ڴ���һ��XMLHttpRequest����
function createXMLHttpRequest()
{
	   if(window.ActiveXObject)
		   {
		      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		   }
	   else if(window.XMLHttpRequest)
		   {
		     xmlHttp=new XMLHttpRequest();
		   }
}

function findPaitent()
{
	   var registerMain_caseNo=document.getElementById("number").value;
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processPaitent;
	   xmlHttp.open("GET", "<%=contextPath %>/Register/findPrescription.action?registerMain_caseNo="+registerMain_caseNo);
	   xmlHttp.send(null);
}

function processPaitent()  //��δ��ɸ÷���
{
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {var paitent=JSON.parse(xmlHttp.responseText);
		    	  if(paitent==null)
		    		{
		    		  alert("�����ڸû��ߣ����������");
		    		}
		    	  else
		    		  {
		    	        
		    	        document.getElementById("name").value=paitent.prescription_name;
		    	        document.getElementById("sex").value=paitent.prescription_sex;
		    	        document.getElementById("age").value=paitent.prescription_age;
		    	        document.getElementById("casenumber").value=paitent.prescription_casenumber;
		    	        document.getElementById("doctordept").value=paitent.prescription_doctordept;
		    	        document.getElementById("doctor").value=paitent.prescription_doctor;
		    	        document.getElementById("money").value=paitent.prescription_cost;
		    		  }
		    	 }
		   }
}



</script>
</body>
</html>