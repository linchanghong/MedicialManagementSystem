<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>门诊药房发药管理</title>
</head>
<frameset cols="100,*"  id="frame_main"  border="0">
    <frame  src="<%=contextPath%>/Prescription/fillData.action" noresize="noresize" name="left" scrolling="no" >
    
    
	<frame src="../JSP_OutPatientService/Pre_details.jsp" name="details" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no"  />
	

    
</frameset>


  <noframes>
      <body>
      </body>
  </noframes>
</html>