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
<style>
div#container
div#header {background-color:#CCCCCC;}
div#footer {background-color:#99bbbb;clear:both;text-align:center;}
</style>
</head>
<body>
<br/>
<br/>
<div id="container">
<div id="header"><h3 align=center>����Һ��ս�</h3></div>
    <div id="query">
      <form>
         <table align=center >
            <tr>
               <td>�����ţ�</td>
               <td><input type="text" name="chuFangNo" id="chuFangNo"></td>
               <td><input type="button" value="��ѯ" onclick="queryRegister()" style="width:50px;height:30px"></td>
            </tr>
         </table>
         <hr/>
      </form>
      </div>
      <div id="details">
        <form action="<%=contextPath %>/Register/quitRegister.action">
           <table id="order" border=1 align="center" cellpadding="0" cellspacing="0">
           <tr>
              <td>�����ţ�<input type="hidden" id="registerMain_No1" name="registerMain_No"></td>
              <td><div id="registerMain_No"></div></td>
              <td>�Һ�ʱ�䣺</td>
              <td><div id="registerMain_date"></div></td>
              <td></td>
              <td></td>
           </tr>
            <tr>
              
              <td>�����ţ�</td>
              <td><div id="registerMain_caseNo"></div></td>
              <td>����������</td>
              <td><div id="registerMain_name"></div></td>
              <td>�����Ա�</td>
              <td><div id="registerMain_sex"></div></td>
             </tr>
             <tr>
              
              <td>���߳����գ�</td>
              <td><div id="registerMain_birthday"></div></td>
              <td>������ϵ�绰��</td>
              <td><div id="registerMain_phoneNo"></div></td>
              <td>���ߵ�ַ��</td>
              <td><div id="registerMain_address"></div></td>
            </tr>
         
            <tr>
        
              <td>�Һż���</td>
              <td><div id="registerMainr_rlName"></div></td>
              <td>�Һŷѣ�</td>
              <td><div id="registerMain_fee"></div>��</td>
              <td>�Һż�����룺</td>
              <td><div id="registerMain_rlCode"></div></td>
            </tr>
          
            <tr>
              <td>�������ƣ�</td>
              <td><div id="registerMain_deptName"></div></td>
              <td>���Һţ�</td>
              <td><div id="registerMain_deptCode"></div></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>ҽ������</td>
              <td><div id="registerMain_docName"></div></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>��Ʊ�ţ�</td>
              <td><div id="registerMain_invoiceNo"></div></td>
              <td></td>
              <td></td>
              <td>״̬��</td>
              <td><div id="registerMain_status"></div></td>
            </tr>
            
               <br/><br/>
               
            
   </table>
        <p align=center><input type="submit" value="�˺�"></p>
        </form>
 </div>
      
<script type="text/javascript">
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
  function queryRegister()
  {
	  
	  var chuFangNo=document.getElementById("chuFangNo").value;
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processPaitent;
	   xmlHttp.open("GET", "<%=contextPath %>/Register/findRegister.action?chuFangNo="+chuFangNo);
	   xmlHttp.send(null);
  }
  function processPaitent()  //��δ��ɸ÷���
  {
  	   var responseContext;
  	   if(xmlHttp.readyState==4)
  		   {
  		     if(xmlHttp.status==200)
  		    	 {
  		    	
  		    	    var register=JSON.parse(xmlHttp.responseText);
  		    	    document.getElementById("registerMain_No1").value=register.registerMain_id;
  		    	    document.getElementById("registerMain_No").innerHTML=register.registerMain_No;
  		    	    document.getElementById("registerMain_date").innerHTML=register.registerMain_date;
  		    	    document.getElementById("registerMain_caseNo").innerHTML=register.registerMain_caseNo;
  		    	    document.getElementById("registerMain_name").innerHTML=register.registerMain_name;
  		    	    document.getElementById("registerMain_sex").innerHTML=register.registerMain_sex;
  		    	    document.getElementById("registerMain_birthday").innerHTML=register.registerMain_birthday;
  		    	    document.getElementById("registerMain_phoneNo").innerHTML=register.registerMain_phoneNo;
  		    	    document.getElementById("registerMain_address").innerHTML=register.registerMain_address;
  		    	    document.getElementById("registerMainr_rlName").innerHTML=register.registerMainr_rlName;
  		    	    document.getElementById("registerMain_fee").innerHTML=register.registerMain_fee;
  		    	    document.getElementById("registerMain_rlCode").innerHTML=register.registerMain_rlCode;
  		    	    document.getElementById("registerMain_deptName").innerHTML=register.registerMain_deptName;
  		    	    document.getElementById("registerMain_deptCode").innerHTML=register.registerMain_deptCode;
  		    	    document.getElementById("registerMain_docName").innerHTML=register.registerMain_docName;
  		    	    document.getElementById("registerMain_invoiceNo").innerHTML=register.registerMain_invoiceNo;
  		    	    document.getElementById("registerMain_status").innerHTML=register.registerMain_status;
  		    	 }
  		   }
  }
</script>
</div>
</body>
</html>