<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- struts��ǩ�� -->
<%@ page import="com.BasicInfoManagement.dao.DrugCategoryDao" %>
<%@ page import="com.BasicInfoManagement.model.JC_YP_DrugCategory" %>
<%@ page import="java.util.List" %>
 <%
String contextPath = request.getContextPath();
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ҩƷ����ά��</title>
</head>
<body >
<div id="header">
<h1 style="text-align:center;">ҩƷ����ά��</h1>
</div>

<div id="search">
<form id="frm_drugCategory" name="drugCategory_form" action="<%=contextPath %>/DrugCate/drugCategroyQuery.action">
 <center>
 <table>
 <tr>
 <td><font color="#0099FF" size="4">ҩƷ�������ƣ�</font></td>
 <td><input type="text" id="txt_query" name="drugCategory.drugCategory_name" size="30"></td>
 <td><input type="submit" value="��  ѯ" id="submit_query" name="query_submit"></br></br></td></tr>
 <tr>
 <td></td>
 <td>
 <a id="a_add" href="DrugCategory_Add.jsp">���ҩƷ������Ϣ</a>
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
<caption><b>ҩƷ������Ϣ</b></caption>
<tr style="background:#CCCCCC">
<th>ID</th><th>ҩƷ��������</th><th>ҩƷ�������</th><th>������</th><th>����</th><th>����</th><!-- ��ͷ -->
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
       	<td><a href="<%=contextPath %>/DrugCate/drugCategoryUpdate.action?drugCategory.drugCategory_id=<%=obj.getDrugCategory_id() %>">�޸�</a></td>
       	<td><a id="deleteOrNot" href="<%=contextPath %>/DrugCate/drugCategoryDel.action?drugCategory.drugCategory_id=<%=obj.getDrugCategory_id() %>">ɾ��</a></td></tr>
       	<%
       }
       %>   
 </tr>  
</table>

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