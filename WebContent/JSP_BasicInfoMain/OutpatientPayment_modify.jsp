<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <h4 align="center">�����շ�������Ϣ�޸�</h4>
   <form action="<%=contextPath %>/OutpatientPayment/modify2.action" method="post">
      <table align=center>
         <tr>
           <td>�����շ����ƣ�</td>
           <td><input type="text" name="outpatientPayment_name" value="${paymentmodifyInfo.outpatientPayment_name}"></td>
           <td><input type="hidden" name="id" value="${paymentmodifyInfo.outpatientPayment_id}"></td>
         </tr>
         <tr>
           <td>�����շѱ�ţ�</td>
           <td><input type="text" name="outpatientPayment_number" value="${paymentmodifyInfo.outpatientPayment_number}"></td>
         </tr>
         <tr>
           <td>�����շ����ʣ�</td>
           <td><input type="text" name="outpatientPayment_property" value="${paymentmodifyInfo.outpatientPayment_property}"></td>
         </tr>
         <tr>
           <td>�����շѶ���</td>
           <td><input type="text" name="outpatientPayment_object" value="${paymentmodifyInfo.outpatientPayment_object}"></td>
         </tr>
         <tr>
           <td>��ע��</td>
           <td><input type="text" name="outpatientPayment_remark" value="${paymentmodifyInfo.outpatientPayment_remark}"></td>
         </tr>
         <tr>
           <td>�����룺</td>
           <td><input type="text" name="outpatientPayment_zjm" value="${paymentmodifyInfo.outpatientPayment_zjm}"></td>
         </tr>
         <tr>
           <td><input id="modifyOrNot" type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></td>
           <td><input type="reset" value="" style="background-image:url(../image/CRUD_image/Reset.png);width: 100px; height: 26px"></td>
         </tr>
       </table>
   </form>
   <script type="text/javascript">
	
	document.getElementById("modifyOrNot").onclick=function(){
		confirm("ȷ���޸���");
		}
</script>
</body>
</html>