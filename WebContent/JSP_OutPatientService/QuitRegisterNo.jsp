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
<div id="header"><h3 align=center>门诊挂号日结</h3></div>
    <div id="query">
      <form>
         <table align=center >
            <tr>
               <td>处方号：</td>
               <td><input type="text" name="chuFangNo" id="chuFangNo"></td>
               <td><input type="button" value="查询" onclick="queryRegister()" style="width:50px;height:30px"></td>
            </tr>
         </table>
         <hr/>
      </form>
      </div>
      <div id="details">
        <form action="<%=contextPath %>/Register/quitRegister.action">
           <table id="order" border=1 align="center" cellpadding="0" cellspacing="0">
           <tr>
              <td>处方号：<input type="hidden" id="registerMain_No1" name="registerMain_No"></td>
              <td><div id="registerMain_No"></div></td>
              <td>挂号时间：</td>
              <td><div id="registerMain_date"></div></td>
              <td></td>
              <td></td>
           </tr>
            <tr>
              
              <td>病历号：</td>
              <td><div id="registerMain_caseNo"></div></td>
              <td>患者姓名：</td>
              <td><div id="registerMain_name"></div></td>
              <td>患者性别：</td>
              <td><div id="registerMain_sex"></div></td>
             </tr>
             <tr>
              
              <td>患者出生日：</td>
              <td><div id="registerMain_birthday"></div></td>
              <td>患者联系电话：</td>
              <td><div id="registerMain_phoneNo"></div></td>
              <td>患者地址：</td>
              <td><div id="registerMain_address"></div></td>
            </tr>
         
            <tr>
        
              <td>挂号级别：</td>
              <td><div id="registerMainr_rlName"></div></td>
              <td>挂号费：</td>
              <td><div id="registerMain_fee"></div>￥</td>
              <td>挂号级别编码：</td>
              <td><div id="registerMain_rlCode"></div></td>
            </tr>
          
            <tr>
              <td>科室名称：</td>
              <td><div id="registerMain_deptName"></div></td>
              <td>科室号：</td>
              <td><div id="registerMain_deptCode"></div></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>医生名：</td>
              <td><div id="registerMain_docName"></div></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>发票号：</td>
              <td><div id="registerMain_invoiceNo"></div></td>
              <td></td>
              <td></td>
              <td>状态：</td>
              <td><div id="registerMain_status"></div></td>
            </tr>
            
               <br/><br/>
               
            
   </table>
        <p align=center><input type="submit" value="退号"></p>
        </form>
 </div>
      
<script type="text/javascript">
var xmlHttp;

//该函数用于创建一个XMLHttpRequest对象
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
  function processPaitent()  //还未完成该方法
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