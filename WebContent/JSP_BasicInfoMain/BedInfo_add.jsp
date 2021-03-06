<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>

</head>
<script src="../js/AjaxRequest.js" type="text/javascript"></script>
<h4 align=center>新建床位信息</h4>
<body>
     <form action="<%=contextPath %>/BedInfo/add.action" method="post">
       <table align=center>
         <tr>
           <td>选择所属科室：</td>
           <td><select style="WIDTH: 100px;height:20px" name="deptInfoName">
               <c:forEach items="${DeptName}" var="n">
               <OPTION value="${n}">${n}</OPTION> 
               </c:forEach>
              </select>
           </td>
         </tr>
         <tr>
           <td>床位号：</td>
           <td><input type="text" id="bed_number" name="bed_number" onblur="numberValidate()"></td>
           <td><div id="msg"></div></td>
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
	   var bed_number=document.getElementById("bed_number").value;
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processAjaxValidate;
	   xmlHttp.open("GET", "<%=contextPath %>/BedInfo/numberValidate.action?number="+bed_number);
	   xmlHttp.send(null);
   }
   
   function processAjaxValidate()
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
</script>
</body>
</html>