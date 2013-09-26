<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.OutPatientService.action.*" %>
<%@ page import="java.io.OutputStream" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <% 
     out.clear();
     out=pageContext.pushBody();
     response.setContentType("application/octet-stream");
     response.setHeader("Content-Disposition", "attachment;filename=Books.doc");
     OutputStream outs=response.getOutputStream();
     RegisterAction service=new RegisterAction();
     service.downloadWorDoc(outs);
   %>
</body>
</html>