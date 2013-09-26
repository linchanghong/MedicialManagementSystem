<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- struts��ǩ�� -->
<%@ page import="com.BasicInfoManagement.dao.SupplierDao" %>
<%@ page import="com.BasicInfoManagement.model.JC_YP_Supplier" %>
<%@ page import="java.util.List" %>
 <%
String contextPath = request.getContextPath();
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��Ӧ����Ϣ</title>

</head>
<body>

<div id="container">

<div id="header">
<h1 style="text-align:center;">��Ӧ����Ϣ</h1>
</div>

<div id="search">
<form name="supplier_frm" action="<%=contextPath %>/supplier/query.action">
<center>
 <table>
 <tr>
 <td><font color="#0099FF" size="4">��Ӧ�����ƣ�</font></td>
 <td><input type="text" id="txt_query" name="supplier.supplier_name" size="30"></td>
 <td><select name="supplier.supplier_type"  size="1">
      <option value="none">ѡ��Ӧ������</option>
      <option value="sb">--�豸��Ӧ��--</option>
      <option value="wc">--���Ĺ�Ӧ��--</option>
      <option value="wz">--���ʹ�Ӧ��--</option>
      <option value="yp">--ҩƷ��Ӧ��--</option>
</select></td>
 <td><input type="submit" value="��  ѯ" id="submit_query" name="query_submit"></br></br></td></tr>
 <tr><td></td><td><a id="a_add" href="Supplier_Add.jsp">��ӹ�Ӧ����Ϣ</a></td><td></td></tr>
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
<caption><b>��Ӧ����Ϣ</b></caption>
<tr style="background:#CCCCCC">
<th>ID</th><th>��Ӧ������</th><th>��Ӧ������</th><th>����</th><th>��ַ</th><th>�ʱ�</th>
<th>�绰</th><th>����</th><th>��ϵ��</th><th>������</th><th>����</th><th>����</th><!-- ��ͷ -->
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
       	<td><a href="<%=contextPath %>/supplier/update.action?supplier.supplier_id=<%=obj.getSupplier_id() %>">�޸�</a></td>
       	<td><a id="deleteOrNot" href="<%=contextPath %>/supplier/delete.action?supplier.supplier_id=<%=obj.getSupplier_id() %>">ɾ��</a></td></tr>
       	<%
       }
       %>   
 </tr>  
</table>

</div >



</div>
   <script type="text/javascript">
	document.getElementById("deleteOrNot").onclick=function(){
		if(confirm("ȷ��ɾ����"))
			return true;
		else
			return false ;
		}
</script>
</body>
</html>