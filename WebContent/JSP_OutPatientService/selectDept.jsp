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
    <td>科室名</td>
    <td>科室编码</td>
    <td>科室助记码</td>
  </tr>

<%
    DeptInfoDao dao=new DeptInfoDao();
    List<JC_LC_DeptInfo> list=dao.findAllDeptInfo();
    for(int i=0;i<list.size();i++)
    {
 %>
    	
    	  <tr align=center>
    	    <td><input type="button" value="选择" onclick="saveDept('<%= list.get(i).getDeptInfo_name() %>','<%= list.get(i).getDeptInfo_number() %>')"></td>
    	    <td><%= list.get(i).getDeptInfo_name() %></td>
    	    <td><%= list.get(i).getDeptInfo_number() %></td>
    	    <td><%= list.get(i).getDeptInfo_zjm() %></td>
    	  </tr>
    	
<%
    }
%>
</table>

<SCRIPT LANGUAGE=javascript>
	function saveDept(a,b){
		
		window.opener.document.getElementById('registerMain_deptName').value=a;
		window.opener.document.getElementById('registerMain_deptCode').value=b;
		window.close();
  }
 
 
  </script>
</body>
</html>