<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="/struts-tags" prefix="s" %><!-- struts��ǩ�� -->
    <%
String contextPath = request.getContextPath();
 %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��ӹ�Ӧ����Ϣ</title>

</head>
<body >
<div id="container">

<div id="header">
<h1 style="text-align:center;">��ӹ�Ӧ����Ϣ</h1>
</div>
<div id="content">
<form  name="supplierUpdate_frm" action="<%=contextPath %>/supplier/saveUpdate.action" >
<table align=center>
<tr>
    <td><input type="hidden"  value="${supplier.supplier_id}" name="supplier.supplier_id"></td></tr>
 <tr>
    <td><font color="#0099FF" size="3">��Ӧ�����ƣ�</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_name}" name="supplier.supplier_name" size="30">
        <font color="red" size="3">*</font></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">��Ӧ�����ͣ�</font></td>
    <td><input type="text" readonly="readonly" align="middle"  value="${supplier.supplier_type}" name="supplier.supplier_type" size="30">
        <font color="red" size="3">*</font></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3" align="middle">��Ӧ�̱��룺</font></td>
    <td><input type="text" align="middle"  value="${supplier.supplier_number}" name="supplier.supplier_number" size="30">
        <font color="red" size="3">*</font></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">��Ӧ�̵�ַ��</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_address}" name="supplier.supplier_address" size="30"></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">��Ӧ���ʱࣺ</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_postcode}" name="supplier.supplier_postcode" size="30"></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">��Ӧ�̵绰��</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_telephone}" name="supplier.supplier_telephone" size="30"></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">��Ӧ�̴��棺</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_fax}" name="supplier.supplier_fax" size="30"></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">��Ӧ����ϵ�ˣ�</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_linkman}" name="supplier.supplier_linkman" size="30"></td>
</tr>
<tr>
    <td><font color="#0099FF" size="3">ҩƷ�����룺</font></td>
    <td><input type="text" align="middle" value="${supplier.supplier_zjm}" name="supplier.supplier_zjm" size="30"></td>
</tr>
<br/>
<br/>
<tr>
   <td><input type="reset" align="middle" id="btn_reset" name="reset_btn" value="��  ��"></td>
   <td><input type="submit" align="middle" id="btn_save" name="save_btn" value="��  ��"></td>
</tr>
</table>
</form>
</br></br>
</div>

</body>
</html>