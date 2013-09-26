<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>药品分类维护</title>
</head>
<body >
<div id="header">
<h1 style="text-align:center;">药品分类维护</h1>
</div>

<div id="search">
<form id="frm_drugCategory" name="drugCategory_form" action="<%=contextPath %>/DrugCate/drugCategroyQuery.action">
 <center>
 <table>
 <tr>
 <td><font color="#0099FF" size="4">药品分类名称：</font></td>
 <td><input type="text" id="txt_query" name="drugCategory.drugCategory_name" size="30"></td>
 <td><input type="submit" value="查  询" id="submit_query" name="query_submit"></br></br></td></tr>
 <tr>
 <td></td>
 <td>
 <a id="a_add" href="DrugCategory_Add.jsp">添加药品分类信息</a>
 </td>
 <td></td>
 </tr>
 </table>
 </center>
</form>
</div>

<%!List<JC_YP_DrugCategory> drugCategoryList;%>
<%DrugCategoryDao drugCategoryDao=new DrugCategoryDao();
drugCategoryList=drugCategoryDao.findAllDrugCategory();
%>
<br/>

<div id="content">
<table border="1" width="750" align="center" cellpadding="0" cellspacing="0">
<caption><b>药品分类信息</b></caption>
<tr style="background:#CCCCCC">
<th>ID</th><th>药品分类名称</th><th>药品分类编码</th><th>助记码</th><th>操作</th><th>操作</th><!-- 表头 -->
</tr>
<tr>
   <%
    
       for(int index=0;index<drugCategoryList.size();index++)
       {
    	   JC_YP_DrugCategory obj=drugCategoryList.get(index);
    	   //request.setAttribute("drugCategory_id", obj.getDrugCategory_id());
       	%>
       	<tr align=center><td><%=obj.getDrugCategory_id()%></td>
       	<td><%=obj.getDrugCategory_name()+"" %></td>
       	<td><%=obj.getDrugCategory_number()+"" %></td> 
       	<td><%=obj.getDrugCategory_zjm()+"" %></td>
       	<td><a href="<%=contextPath %>/DrugCate/drugCategoryUpdate.action?drugCategory.drugCategory_id=<%=obj.getDrugCategory_id() %>">修改</a></td>
       	<td><a id="deleteOrNot" href="<%=contextPath %>/DrugCate/drugCategoryDel.action?drugCategory.drugCategory_id=<%=obj.getDrugCategory_id() %>">删除</a></td></tr>
       	<%
       }
       %>   
 </tr>  
</table>

</div>
   <script type="text/javascript">
	document.getElementById("deleteOrNot").onclick=function(){
		if(confirm("确定删除吗？"))
			return true;
		else
			return false ;
		}
</script>
</body>
</html>