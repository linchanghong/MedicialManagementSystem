<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="/struts-tags" prefix="s" %><!-- struts标签库 -->
 <%@ page import="com.BasicInfoManagement.dao.DrugCategoryDao" %>
 <%@ page import="com.BasicInfoManagement.model.JC_YP_DrugCategory" %>   
 <%@ page import="java.util.List" %>
 <%
String contextPath = request.getContextPath();
 %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加药品编码信息</title>

</head>
<body >

<div id="container">
<%
 JC_YP_DrugCategory drugCategory=(JC_YP_DrugCategory)request.getAttribute("drugCategory");
%>
<div id="header">
<h1 style="text-align:center;">修改药品编码信息</h1>
</div>
<div id="content">
<form  name="drugCategoryUpdate_form" action="<%=contextPath %>/DrugCate/drugCategorySaveUpdate.action" >
<center>
<font color="#0099FF" size="3">药品分类名称：</font>
<input type="hidden" name="drugCategory.drugCategory_id" value="${drugCategory.drugCategory_id }">
<input type="text" align="middle" value="${drugCategory.drugCategory_name}" name="drugCategory.drugCategory_name" size="30" >
<font color="red" size="3">*</font></br>
<font color="#0099FF" size="3" align="middle">药品分类编码：</font>
<input type="text" align="middle"  value="${drugCategory.drugCategory_number}" name="drugCategory.drugCategory_number" size="30">
<font color="red" size="3">*</font></br>
<font color="#0099FF" size="3">药品助记码：</font>
<input type="text" align="middle" value="${drugCategory.drugCategory_zjm}" name="drugCategory.drugCategory_zjm" size="30"></br></br>
<input type="reset" align="middle" id="btn_reset" name="reset_btn" value="重  置">
<input  type="submit" align="middle" id="btn_save" name="save_btn" value="保  存">
</center>
</form>
</br></br>
</div>

</body>
</html>