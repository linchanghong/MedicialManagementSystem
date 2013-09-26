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
              <td>处方号：</td>
              <td>${registerDetails.registerMain_No}</td>
              <td>挂号时间：</td>
              <td>${registerDetails.registerMain_date }</td>
              <td></td>
              <td></td>
           </tr>
            <tr>
              
              <td>病历号：</td>
              <td>${registerDetails.registerMain_caseNo }</td>
              <td>患者姓名：</td>
              <td>${registerDetails.registerMain_name }</td>
              <td>患者性别：</td>
              <td>${registerDetails.registerMain_sex }</td>
             </tr>
             <tr>
              
              <td>患者出生日：</td>
              <td>${registerDetails.registerMain_birthday }</td>
              <td>患者联系电话：</td>
              <td>${registerDetails.registerMain_phoneNo }</td>
              <td>患者地址：</td>
              <td>${registerDetails.registerMain_address }</td>
            </tr>
         
            <tr>
        
              <td>挂号级别：</td>
              <td>${registerDetails.registerMainr_rlName }</td>
              <td>挂号费：</td>
              <td>${registerDetails.registerMain_fee }￥</td>
              <td>挂号级别编码：</td>
              <td>${registerDetails.registerMain_rlCode }</td>
            </tr>
          
            <tr>
              <td>科室名称：</td>
              <td>${registerDetails.registerMain_deptName }</td>
              <td>科室号：</td>
              <td>${registerDetails.registerMain_deptCode }</td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>医生名：</td>
              <td>${registerDetails.registerMain_docName }</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>发票号：</td>
              <td>${registerDetails.registerMain_invoiceNo }</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            
   </table>
   <br/>
   <br/>
   <P align=center><a href="<%=contextPath %>/Register/down.action"><input type="button" value="打印发票" style="width:80px;height:30px"></a></P>
</body>
</html>