<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
 <%@ page import="java.text.SimpleDateFormat" %>
 <%@ page import="java.util.Date" %>
 <%
 SimpleDateFormat dsf = new SimpleDateFormat("yyyy-MM-dd");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <table id="order" border=1 align="center" cellpadding="0" cellspacing="0">
           <tr>
              <td>�����ţ�</td>
              <td>${registerDetails.registerMain_No}</td>
              <td>�Һ�ʱ�䣺</td>
              <td>${registerDetails.registerMain_date }</td>
              <td></td>
              <td></td>
           </tr>
            <tr>
              
              <td>�����ţ�</td>
              <td>${registerDetails.registerMain_caseNo }</td>
              <td>����������</td>
              <td>${registerDetails.registerMain_name }</td>
              <td>�����Ա�</td>
              <td>${registerDetails.registerMain_sex }</td>
             </tr>
             <tr>
              
              <td>���߳����գ�</td>
              <td>${registerDetails.registerMain_birthday }</td>
              <td>������ϵ�绰��</td>
              <td>${registerDetails.registerMain_phoneNo }</td>
              <td>���ߵ�ַ��</td>
              <td>${registerDetails.registerMain_address }</td>
            </tr>
         
            <tr>
        
              <td>�Һż���</td>
              <td>${registerDetails.registerMainr_rlName }</td>
              <td>�Һŷѣ�</td>
              <td>${registerDetails.registerMain_fee }��</td>
              <td>�Һż�����룺</td>
              <td>${registerDetails.registerMain_rlCode }</td>
            </tr>
          
            <tr>
              <td>�������ƣ�</td>
              <td>${registerDetails.registerMain_deptName }</td>
              <td>���Һţ�</td>
              <td>${registerDetails.registerMain_deptCode }</td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>ҽ������</td>
              <td>${registerDetails.registerMain_docName }</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>��Ʊ�ţ�</td>
              <td>${registerDetails.registerMain_invoiceNo }</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            
   </table>
   <br/>
   <br/>
   <P align=center><a href="<%=contextPath %>/Register/down.action"><input type="button" value="��ӡ��Ʊ" style="width:80px;height:30px"></a></P>
</body>
</html>