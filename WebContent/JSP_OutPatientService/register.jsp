<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String contextPath = request.getContextPath();
 %>
 <%@ page import="java.text.SimpleDateFormat" %>
 <%@ page import="java.util.Date" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
       <%
          SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
          String date=sDateFormat.format(new Date());
          SimpleDateFormat sDateFormat1=new SimpleDateFormat("yyyyMMddhhmmss");
          String date1=sDateFormat1.format(new Date());
          SimpleDateFormat sDateFormat2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          String date2=sDateFormat2.format(new Date());
       %>
<body>
      <p align=right style="background:#CCCCCC"><a href="<%=contextPath %>/Register/quit.action"><input type="button" value="�˳�" style="width:50px;height:30px;"></a>
      <hr/>
      <form action="<%=contextPath %>/Register/save.action" method="post" name="form">
         <table id="order">
           <tr>
              <td>�����ţ�</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="registerMain_No" value="${code}" readonly style="width:90px;height:20px;"></td>
              <td><a href="<%=contextPath %>/Register/sequenceCode.action"><input type="button" value="ˢ��" style="width:50px;height:30px;"></a></td>
              <td>&nbsp;�Һ�ʱ�䣺</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="registerMain_date" value="<%=date2 %>" readonly></td>
           </tr>
          </table><hr/>
          <table>
            <tr>
              <td><font color="red" size=5>*</font></td>
              <td>�����ţ�</td>
              <td><input type="text" name="registerMain_caseNo" id="registerMain_caseNo" onblur="findPaitent()"></td>
              <td>����������</td>
              <td><input type="text" name="registerMain_name" id="registerMain_name" readonly></td>
              <td>�����Ա�</td>
              <td><input type="text" name="registerMain_sex" id="registerMain_sex" readonly></td>
             </tr>
             <tr>
              <td></td>
              <td>���߳����գ�</td>
              <td><input type="text" name="registerMain_birthday" id="registerMain_birthday" readonly></td>
              <td>������ϵ�绰��</td>
              <td><input type="text" name="registerMain_phoneNo" id="registerMain_phoneNo" readonly></td>
              <td>���ߵ�ַ��</td>
              <td><input type="text" name="registerMain_address" id="registerMain_address" readonly></td>
            </tr>
          </table><hr/>
          <table>
            <tr>
              <td><font color="red" size=5>*</font></td>
              <td>�Һż���</td>
              <td>&nbsp;&nbsp;<input type="text" name="registerMainr_rlName" id="registerMainr_rlName" onclick="openScriptRegisterLevel('<%=contextPath %>/JSP_OutPatientService/selectRegisterLevel.jsp','pur2',500,400)"></td>
              <td>�Һŷѣ�</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="registerMain_fee" id="registerMain_fee" readonly></td>
              <td>������룺</td>
              <td><input type="text" name="registerMain_rlCode" id="registerMain_rlCode" readonly></td>
            </tr>
          </table><hr/>
          <table>
            <tr>
              <td>�������ƣ�</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="registerMain_deptName" id="registerMain_deptName" onclick="openScriptDept('<%=contextPath %>/JSP_OutPatientService/selectDept.jsp','pur',500,400)"></td>
              <td>���Һţ�</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="registerMain_deptCode" id="registerMain_deptCode" readonly ></td>
            </tr>
            <tr>
              <td>ҽ������</td>
              <td>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="registerMain_docName" id="registerMain_docName" onclick="openScriptDoctor('<%=contextPath %>/JSP_OutPatientService/selectDoctor.jsp','pur1',500,400)" ></td>
            </tr>
          </table>
          <table>
            <tr>
              <td><input type="hidden" name="registerMain_invoiceNo" value="<%=date1 %>"></td>
              <td><input type="hidden" name="registerMain_operName" value="${registerUserName}"></td>
              <td><input type="hidden" name="registerMain_operDate" value="<%=date2 %>"></td>
            </tr>
          </table>
          <br/>
          <br/>
          <table  width=100% style="background:#CCCCCC">
            <tr>
              <td align=center><input type="submit" value="ȷ��" style="width:50px;height:30px"></td>
            </tr>
          </table>
      </form>
      
<div id="bingLi">
   
</div>



<script type="text/javascript">
//����һ���������ڴ��XMLHttpRequest����
var xmlHttp;

//�ú������ڴ���һ��XMLHttpRequest����
function createXMLHttpRequest()
{
	   if(window.ActiveXObject)
		   {
		      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		   }
	   else if(window.XMLHttpRequest)
		   {
		     xmlHttp=new XMLHttpRequest();
		   }
}

function findPaitent()
{
	   var registerMain_caseNo=document.getElementById("registerMain_caseNo").value;
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processPaitent;
	   xmlHttp.open("GET", "<%=contextPath %>/Register/findPaitent.action?registerMain_caseNo="+registerMain_caseNo);
	   xmlHttp.send(null);
}

function processPaitent()  //��δ��ɸ÷���
{
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {var paitent=JSON.parse(xmlHttp.responseText);
		    	  if(paitent==null)
		    		{
		    		  alert("�����ڸû��ߣ����������");
		    		}
		    	  else
		    		  {
		    	        
		    	        document.getElementById("registerMain_name").value=paitent.regiserPatient_name;
		    	        document.getElementById("registerMain_sex").value=paitent.regiserPatient_sex;
		    	        document.getElementById("registerMain_birthday").value=paitent.regiserPatient_birthday;
		    	        document.getElementById("registerMain_phoneNo").value=paitent.regiserPatient_phoneNo;
		    	        document.getElementById("registerMain_address").value=paitent.regiserPatient_address;
		    		  }
		    	 }
		   }
}


function openScriptDept(url,name, width, height){
	//var param="?sType="+document.form.stype.value;
	var Win = window.open(url,name,'width=' + width + ',height=' + height + ',top=200,left=200,resizable=1,scrollbars=yes,menubar=no,status=yes,location=no');
}
function openScriptDoctor(url,name, width, height){
	
	var param="?sType="+document.getElementById("registerMain_deptCode").value;
	var Win = window.open(url+param,name,'width=' + width + ',height=' + height + ',top=200,left=200,resizable=1,scrollbars=yes,menubar=no,status=yes,location=no');
}
function openScriptRegisterLevel(url,name, width, height){
	//var param="?sType="+document.form.stype.value;
	var Win = window.open(url,name,'width=' + width + ',height=' + height + ',top=200,left=200,resizable=1,scrollbars=yes,menubar=no,status=yes,location=no');
}
</script>
</body>
</html>