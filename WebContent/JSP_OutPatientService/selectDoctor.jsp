<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.BasicInfoManagement.action.*" %>
<%@ page import="com.BasicInfoManagement.dao.*" %>
<%@ page import="com.BasicInfoManagement.model.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="400" align="center" cellpadding="0" cellspacing="0">
  <tr align=center>
    <td></td>
    <td>医生名</td>
    <td>医生编码</td>
  </tr>
<% String deptNo=request.getParameter("sType");
   DoctorInfoDao dao=new DoctorInfoDao();
   List<JC_RY_DoctorInfo> list=dao.findAllDoctor(deptNo);
   for(int i=0;i<list.size();i++)
   {
%>
         <tr align=center>
    	    <td><input type="button" value="选择" onclick="saveDoctor('<%= list.get(i).getDoctorInfo_name() %>')"></td>
    	    <td><%= list.get(i).getDoctorInfo_name() %></td>
    	    <td><%= list.get(i).getDoctorInfo_sex() %></td>
    	  </tr>
<%
   }
%>
</table>
<SCRIPT LANGUAGE=javascript>
	function saveDoctor(a){
		
		window.opener.document.getElementById('registerMain_docName').value=a;
		
		window.close();
  }
 
 
  </script>
</body>
</html>