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
<td>处方号：</td>
<td><input type="text" id="number" name="number" size="20" onblur="findPaitent()"></td>

<td>患者姓名：</td>
<td><input type="text" id="name" name="name" size="20" readonly></td>
<td>姓别：<input type="text" id="sex" name="sex" size="10" readonly></td>
<td>年龄:<input type="text" id="age" name="age" size="5" readonly></td>
</tr>
<tr>
<td>病例号：</td><td><input id="casenumber" type="text" name="casenumber" " size="20" ></td>
<td>看诊科室：</td><td><input type="text" id="doctordept"  name="doctordept" size="20" readonly></td>
<td>开方医生：</td><td><input type="text" id="doctor" name="doctor" size="20" readonly></td>
<!-- <td>合同单位：</td><td><input type="text" name="" size="20"></td> -->
<td></td>
</tr>
<tr>
<td>费用：</td>
<td><input type="text" id="money" name="" size="20" readonly></td>
</tr>
<tr align=center>
<td ><input type="submit" value="确认收费"></td>
</tr>
</table>
</form>


<script type="text/javascript">
//定义一个变量用于存放XMLHttpRequest对象
var xmlHttp;

//该函数用于创建一个XMLHttpRequest对象
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

function processPaitent()  //还未完成该方法
{
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {var paitent=JSON.parse(xmlHttp.responseText);
		    	  if(paitent==null)
		    		{
		    		  alert("不存在该患者，或输入错误。");
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