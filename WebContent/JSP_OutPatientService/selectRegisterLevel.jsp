<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.OutPatientService.dao.*" %>
<%@ page import="com.OutPatientService.action.*" %>
<%@ page import="com.OutPatientService.model.*" %>
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
    <td>挂号级别</td>
    <td>挂号费</td>
    <td>挂号级别编码</td>
  </tr>

<%
    RegisterDao dao=new RegisterDao();
    List<MZ_RegisterLevel> list=dao.findAllRegisterLevel();
    for(int i=0;i<list.size();i++)
    {
 %>
    	
    	  <tr align=center>
    	    <td><input type="button" value="选择" onclick="saveDept('<%= list.get(i).getRegisterLevel_name() %>','<%= list.get(i).getRegisterLevel_fee() %>','<%= list.get(i).getRegisterLevel_code() %>')"></td>
    	    <td><%= list.get(i).getRegisterLevel_name() %></td>
    	    <td><%= list.get(i).getRegisterLevel_fee() %></td>
    	    <td><%= list.get(i).getRegisterLevel_code() %></td>
    	  </tr>
    	
<%
    }
%>
</table>

<SCRIPT LANGUAGE=javascript>
	function saveDept(a,b,c){
		
		window.opener.document.getElementById('registerMainr_rlName').value=a;
		window.opener.document.getElementById('registerMain_fee').value=b;
		window.opener.document.getElementById('registerMain_rlCode').value=c;
		window.close();
  }
 
 
  </script>
</body>
</html>