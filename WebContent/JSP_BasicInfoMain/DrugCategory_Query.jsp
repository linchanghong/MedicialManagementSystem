<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.BasicInfoManagement.model.JC_YP_DrugCategory" %>
<%@ page import="com.BasicInfoManagement.dao.DrugCategoryDao" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String contextPath = request.getContextPath();
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>药品分类维护查询结果</title>

</head>
<body >
<body >
<div id="container">

<div id="header">
<h1 style="text-align:center;">药品分类维护</h1>
</div>
<div id="content">
              <c:choose>
                 <c:when test="${empty list}">							
				 <center><font color="Brown" size="4">对不起，没有查询到你想要的信息!</font></center>								
				 </c:when>
		       <c:otherwise>
                    <table border=1 align=center width="750" align="center" cellpadding="0" cellspacing="0">
                       <caption><b>药品分类信息</b></caption>
	<tr style="background:#CCCCCC">
	<th>ID</th><th>药品分类名称</th><th>药品分类编码</th><th>助记码</th><th>操作</th><!-- 表头 -->
	</tr>
                       <c:forEach items="${list}" var="list">
                       <tr align=center>
                              
                              <td>${list.drugCategory_id}</td>
                              <td>${list.drugCategory_name}</td>
                              <td>${list.drugCategory_number}</td>
                              <td>${list.drugCategory_zjm}</td>
			                  <td><a href="<%=contextPath %>/DrugCate/drugCategoryUpdate.action?drugCategory.drugCategory_id=${list.drugCategory_id}">修改</a>
       	                     |<a id="deleteOrNot" href="<%=contextPath %>/DrugCate/drugCategoryDel.action?drugCategory.drugCategory_id=${list.drugCategory_id}%>">删除</a></td></tr>
                      </c:forEach>
                    </table>
                  </c:otherwise>
              </c:choose>
<br/><center><a href="<%=contextPath %>/DrugCate/returnIndex.action">返回</a></center>  
</div>

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