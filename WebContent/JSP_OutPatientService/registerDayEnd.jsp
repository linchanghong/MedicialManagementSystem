<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.OutPatientService.dao.*" %>
<%@ page import="com.OutPatientService.action.*" %>
<%@ page import="com.OutPatientService.model.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
<%
   SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   String endDate=sDateFormat.format(new Date());   //当前时间作为截止时间
%>
<body>
 <br/>
  <br/>
<div id="container">
<div id="header"><h3 align=center>门诊挂号日结</h3></div>
   <form action="<%=contextPath %>/Register/saveDayEnd.action" method="post">
      <table border="1" align="center" cellpadding="0" cellspacing="0">
         <br/>
         <tr>
            <td>日结者：</td>
            <td><input type="text" name="dayEnd_oper" id="dayEnd_oper" onblur="findMaxBeginDate()"></td>
            <td></td>
            <td><input type="button" value="日结" onclick="RegisterDayEnd()" style="width:70px;height:30px"></td>
         </tr>
         
         <tr>
            <td>开始时间</td>
            <td><input type="text" name="dayEnd_beginDate" id="dayEnd_beginDate" readonly></td>
            <td>截止时间</td>
            <td><input type="text" name="dayEnd_endDate" id="dayEnd_endDate" value="<%=endDate %>"></td>
         </tr>
         
         <tr>
             <td>总挂号费</td>
             <td><input type="text" name="dayEnd_feeCount" id="dayEnd_feeCount" readonly>￥</td>
             <td>总的单数</td>
             <td><input type="text" name="dayEnd_danHaoCount" id="dayEnd_danHaoCount" readonly></td>
         </tr>
         <tr>
            <td>正常单数</td>
            <td><input type="text" name="dayEnd_danHaoZC" id="dayEnd_danHaoZC" readonly></td>
            <td>退号单数</td>
            <td><input type="text" name="dayEnd_danHaoTH" id="dayEnd_danHaoTH" readonly></td>
         </tr>
          <br/><br/><br/>
      </table>
      <p align=center><input type="submit" value="存盘" style="width:50px;height:30px"></p>
   </form>
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
function findMaxBeginDate()
{
	  
	  var dayEnd_oper=document.getElementById("dayEnd_oper").value;
	  
	  
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processBeginDate;
	   xmlHttp.open("GET", "<%=contextPath %>/Register/findMaxBeginDate.action?dayEnd_oper="+dayEnd_oper);
	   xmlHttp.send(null);
}
function processBeginDate()  
{
	   var responseContext;
	   if(xmlHttp.readyState==4)
		   {
		     if(xmlHttp.status==200)
		    	 {
		    	    var session=JSON.parse(xmlHttp.responseText);
		    	    document.getElementById("dayEnd_beginDate").value=session.temp1; //时间
		    	 }
		   }
}
  function RegisterDayEnd()
  {
	  
	  var dayEnd_oper=document.getElementById("dayEnd_oper").value;
	  var dayEnd_beginDate=document.getElementById("dayEnd_beginDate").value;
	  
	  var dayEnd_endDate=document.getElementById("dayEnd_endDate").value;
	  
	   createXMLHttpRequest();
	   xmlHttp.onreadystatechange=processPaitent;
	   xmlHttp.open("GET", "<%=contextPath %>/Register/dayEnd.action?dayEnd_oper="+dayEnd_oper+"&dayEnd_beginDate="+dayEnd_beginDate+"&dayEnd_endDate="+dayEnd_endDate);
	   xmlHttp.send(null);
  }
  function processPaitent()  
  {
  	   var responseContext;
  	   if(xmlHttp.readyState==4)
  		   {
  		     if(xmlHttp.status==200)
  		    	 {
  		    	    var session=JSON.parse(xmlHttp.responseText);
  		    	    document.getElementById("dayEnd_feeCount").value=session.fee;
  		    	    document.getElementById("dayEnd_danHaoCount").value=session.danHaoCount;
  		    	    document.getElementById("dayEnd_danHaoZC").value=session.danHaoZC;
  		    	    document.getElementById("dayEnd_danHaoTH").value=session.danHaoTH;
  		    	    
  		    	 }
  		   }
  }
</script>
</div>
</body>
</html>