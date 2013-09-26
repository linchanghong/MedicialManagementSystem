<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- struts标签库 -->
<%@ page import="com.BasicInfoManagement.dao.SupplierDao" %>
<%@ page import="com.BasicInfoManagement.model.JC_YP_Supplier" %>
<%@ page import="java.util.List" %>
 <%
String contextPath = request.getContextPath();
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商信息</title>
</head>
<body style="background:url(../image/bg_image/bg_gray01.png) #F0F8FF">
<div id="container">

<div id="header">
<h1 style="text-align:center;">供应商信息</h1>
</div>

<div id="content">
<c:choose>
   <c:when test="${empty list}">
			<center><font color="Brown" size="4">对不起，没有查询到你想要的信息!</font></center>	
 </c:when>
   <c:otherwise>
        <table border=1 align=center width="750" align="center" cellpadding="0" cellspacing="0">
              <caption><b>供应商信息</b></caption>
              <tr>
<th>ID</th><th>供应商名称</th><th>供应商类型</th><th>供应商编码</th><th>供应商地址</th><th>供应商邮编</th>
<th>供应商电话</th><th>供应商传真</th><th>供应商联系人</th><th>助记码</th><th>操作</th><!-- 表头 -->
</tr>
                       <c:forEach items="${list}" var="list">
                       <tr align=center>
                              
                              <td>${list.supplier_id}</td>
                              <td>${list.supplier_name}</td>
                              <td>${list.supplier_type}</td>
                              <td>${list.supplier_number}</td>
                              <td>${list.supplier_address}&nbsp;</td>
                              <td>${list.supplier_postcode}&nbsp;</td>
                              <td>${list.supplier_telephone }&nbsp;</td>
                              <td>${list.supplier_fax }&nbsp;</td>
                              <td>${list.supplier_linkman }&nbsp;</td>
                              <td>${list.supplier_zjm }&nbsp;</td>
                              <td><a href="<%=contextPath %>/supplier/update.action?supplier.supplier_id=${list.supplier_id} %>">修改</a>
       						  |<a id="deleteOrNot" href="<%=contextPath %>/supplier/delete.action?supplier.supplier_id=${list.supplier_id} %>">删除</a></td>
                      </tr>
                      </c:forEach>
                    </table>
                  </c:otherwise>
              </c:choose>
<br/><center><a href="<%=contextPath %>/supplier/returnIndex.action">返回</a> </center> 
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