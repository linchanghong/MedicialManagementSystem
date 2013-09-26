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
<script src="../js/AjaxRequest.js" type="text/javascript"></script>
<h4 align=center>新建科室信息</h4>
<body>
     <form action="<%=contextPath %>/DeptInfo/add.action" method="post">
       <table align=center>
         <tr>
           <td>科室编码：</td>
           <td><input type="text" id="deptInfo_number" name="deptInfo_number" onblur="numberValidate()" ></td>
           <td><div id="msg"></div></td>
         </tr>
         <tr>
           <td>科室名称：</td>
           <td><input type="text" name="deptInfo_name" id="deptInfo_name" onblur="nameValidate()"></td>
           <td><div id="msg1"></div></td>
         </tr>
         <tr>
           <td>科室助记码：</td>
           <td><input type="text" name="deptInfo_zjm" id="deptInfo_zjm" onblur="zjmValidate()"></td>
           <td><div id="msg2"></div></td>
         </tr>
         <tr>
           <td><input type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></td>
           <td><input type="reset" value="" style="background-image:url(../image/CRUD_image/Reset.png);width: 100px; height: 26px"></td>
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
   
   function numberValidate()
   {
	   var deptInfo_number=document.getElementById("deptInfo_number").value;
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processNumberValidate;
	   xmlHttp.open("GET", "<%=contextPath %>/DeptInfo/numberValidate.action?number="+deptInfo_number);
	   xmlHttp.send(null);
   }
   
   function processNumberValidate()
   {
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {
		    	    responseContext=xmlHttp.responseText;
		    	    if(responseContext.length>1)
		    	    {
		    	    	document.getElementById('msg').innerHTML="<font color='red' size='-1'>"+responseContext+"</font>";
		    	    }
		    	 }
		   }
   }
   function nameValidate()
   {
	   var deptInfo_name=document.getElementById("deptInfo_name").value;
	   createXMLHttpRequest(deptInfo_name+"  "+"1234567");
	   xmlHttp.onreadystatechange=processNameValidate;
	   xmlHttp.open("GET", "<%=contextPath %>/DeptInfo/nameValidate.action?name="+deptInfo_name);
	   xmlHttp.send(null);
   }
   
   function processNameValidate()
   {
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {
		    	    responseContext=xmlHttp.responseText;
		    	    if(responseContext.length>1)
		    	    {
		    	    	document.getElementById('msg1').innerHTML="<font color='red' size='-1'>"+responseContext+"</font>";
		    	    }
		    	 }
		   }
   }
   
   function zjmValidate()
   {
	   var deptInfo_zjm=document.getElementById("deptInfo_zjm").value;
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processZjmValidate;
	   xmlHttp.open("GET", "<%=contextPath %>/DeptInfo/zjmValidate.action?zjm="+deptInfo_zjm);
	   xmlHttp.send(null);
   }
   
   function processZjmValidate()
   {
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {
		    	    responseContext=xmlHttp.responseText;
		    	    if(responseContext.length>1)
		    	    {
		    	    	document.getElementById('msg2').innerHTML="<font color='red' size='-1'>"+responseContext+"</font>";
		    	    }
		    	 }
		   }
   }
</script>
</body>
</html>