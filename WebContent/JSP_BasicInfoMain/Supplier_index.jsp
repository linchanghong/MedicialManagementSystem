<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>供应商信息</title>

</head>
<body>

<div id="container">

<div id="header">
<h1 style="text-align:center;">供应商信息</h1>
</div>

<div id="search">
<form name="supplier_frm" action="<%=contextPath %>/supplier/query.action">
<center>
 <table>
 <tr>
 <td><font color="#0099FF" size="4">供应商名称：</font></td>
 <td><input type="text" id="txt_query" name="supplier.supplier_name" size="30"></td>
 <td><select name="supplier.supplier_type"  size="1">
      <option value="none">选择供应商类型</option>
      <option value="sb">--设备供应商--</option>
      <option value="wc">--卫材供应商--</option>
      <option value="wz">--物质供应商--</option>
      <option value="yp">--药品供应商--</option>
</select></td>
 <td><input type="submit" value="查  询" id="submit_query" name="query_submit"></br></br></td></tr>
 <tr><td></td><td><a id="a_add" href="Supplier_Add.jsp">添加供应商信息</a></td><td></td></tr>
 </table>
 </center>
 
</form>
</div>
<%!List<JC_YP_Supplier> supplierList;%>
<%SupplierDao dao=new SupplierDao();
supplierList=dao.findAllSupplier();
%>
<br/>
<div id="content">
<table border="1" width="750" align="center" cellpadding="0" cellspacing="0">
<caption><b>供应商信息</b></caption>
<tr style="background:#CCCCCC">
<th>ID</th><th>供应商名称</th><th>供应商类型</th><th>编码</th><th>地址</th><th>邮编</th>
<th>电话</th><th>传真</th><th>联系人</th><th>助记码</th><th>操作</th><th>操作</th><!-- 表头 -->
</tr>
<tr>
   <%
    
       for(int index=0;index<supplierList.size();index++)
       {
    	   JC_YP_Supplier obj=supplierList.get(index);
    	   //request.setAttribute("drugCategory_id", obj.getDrugCategory_id());
       	%>
       	<tr align=center><td><%=obj.getSupplier_id() %></td>
       	<td><%=obj.getSupplier_name() %></td>
       	<td><%=obj.getSupplier_type() %></td> 
       	<td><%=obj.getSupplier_number()%></td>
       	<td><%=obj.getSupplier_address()%>&nbsp;</td>
       	<td><%=obj.getSupplier_postcode()%>&nbsp;</td>
       	<td><%=obj.getSupplier_telephone()%>&nbsp;</td>
       	<td><%=obj.getSupplier_fax()%>&nbsp;</td>
       	<td><%=obj.getSupplier_linkman()%>&nbsp;</td>
       	<td><%=obj.getSupplier_zjm()%>&nbsp;</td>
       	<td><a href="<%=contextPath %>/supplier/update.action?supplier.supplier_id=<%=obj.getSupplier_id() %>">修改</a></td>
       	<td><a id="deleteOrNot" href="<%=contextPath %>/supplier/delete.action?supplier.supplier_id=<%=obj.getSupplier_id() %>">删除</a></td></tr>
       	<%
       }
       %>   
 </tr>  
</table>

</div >



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