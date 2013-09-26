<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String contextPath = request.getContextPath();
%>
<script>
  $(function() {
	  var txt = $("#guahao").text();
	  txt = txt.substring(0,20);
	  $("#guahao").text(txt);
	  
	  var txt = $("#shoufei").text();
	  txt = txt.substring(0,19);
	  $("#shoufei").text(txt);
	  
    $( "#tabs" ).tabs();
    function TableUtil()
	{
	 var table = document.getElementById('ShowTable');
	 var trs = table.getElementsByTagName("tr");
	 var len = trs.length;
	 for(var i=1;i<len;i++)
	 {
	  trs[i].onmouseover=addTrColor;
	  trs[i].onmouseout=deleteTrColor;
	 }
	}
	function addTrColor()
	{
	 this.style.background="#D0FFE8";
	}

	function deleteTrColor()
	{
	 this.style.background="";
	}

	TableUtil();
	$("#addSubmit").button().click(function() {
		$("#dialog-confirm").dialog("open");

	});
    $( "#dialog-confirm" ).dialog({
    	autoOpen : false,
        resizable: false,
        height:140,
        modal: true,
        buttons: {
          "确定完成": function() {
        	  $("#Complete").submit();
            $( this ).dialog( "close" );
          },
        	" 取消": function() {
            $( this ).dialog( "close" );
          }
        }
      });
    var xmlhttp;  
    try{  
        xmlhttp= new ActiveXObject('Msxml2.XMLHTTP');  
    }catch(e){  
        try{  
            xmlhttp= new ActiveXObject('Microsoft.XMLHTTP');  
        }catch(e){  
            try{  
                xmlhttp= new XMLHttpRequest();  
            }catch(e){}  
        }  
    }  
    function getPart(url){  
        xmlhttp.open("get",url,true);  
        xmlhttp.onreadystatechange = function(){  
            if(xmlhttp.readyState == 4)  
            {  
                if(xmlhttp.status == 200)  
                {  
                    if(xmlhttp.responseText!=""){  
                        document.getElementById("partdiv").innerHTML = unescape(xmlhttp.responseText);          
                    }  
                }  
                else{  
                    document.getElementById("partdiv").innerHTML = "数据加载出错";  
                }  
            }  
        }  
        xmlhttp.setRequestHeader("If-Modified-Since","0");  
        xmlhttp.send(null);  
    }  
    setInterval("getPart('test.jsp')",1000)  
  });
  </script>
  <style>
table {
	border-collapse: collapse;
	border:1px solid #ccc;
}

td {
border:1px solid #ccc;
}
div#users-contain { width: 350px; margin: 20px 0; }
    div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>
</head>
<body>
<div id="dialog-confirm" title="确定要提交配药信息?">
  <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;">
  </span>注：完成之后将提交至发药处进行发药!</p>
</div>
<div style="float:right; width:140px; height:180%;" id="tabs">
处方号<input type="text" value="${Patient.preCriptionNumber }">
<ul>
    <li><a href="#tabs-1">已打印</a></li>
    <li><a href="#tabs-2">未打印</a></li>
  </ul>
	<div id="tabs-1">
		
		<c:forEach items="${list }" var="m">
			<a href="<%=contextPath %>/JSP_OutPatientService/ShowDrugDetailByPatientName.action?PreCreptNumber=${m.preCriptionNumber }">${m.patientName } </a>
			<br>
		</c:forEach>
	</div>
	<div id="tabs-2">
     1233
   </div>

</div>

</div>
<div style="float:left;">
	<table>
		<tr>
			<td>
				<div>
					<table cellpadding="5">
						<tr>
							<td>发票号:</td>
							<td style="width:85px">${Patient.preCriptionBillNumber}</td>
							<td>门诊号:</td>
							<td>24631643</td>
							<td>患者姓名:</td>
							<td>${Patient.patientName }</td>
						</tr>
						<tr>
							<td>患者性别:</td>
							<td>${Patient.patientSex }</td>
							<td>患者年龄:</td>
							<td>${Patient.patientAge }</td>
							<td >挂号日期:</td>
							<td style="width:152px" id="guahao"> ${Patient.registerDate }</td>
						</tr>
						<tr>
							<td>收费人:</td>
							<td>${registerUserName}</td>
							<td>收费时间:</td>
							<td style="width:152px" id="shoufei">${Patient.chargeDate }</td>
							<td>看诊科室:</td>
							<td>${Patient.prescription_doctordept }</td>
						</tr>
						<tr>
							<td>医生:</td>
							<td colspan="5">${Patient.prescription_doctor }</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<hr>
	<form id="Complete" action="CommitFaYao" method="post">
	<table  border="0" align=center width="100%" align="center" cellpadding="0" cellspacing="0"
	 style="border-collapse:collapse;" id="ShowTable">
		
		<thead>
			<tr style="line-height:28px;" class="ui-widget-header " thTrueWidth="true">
				<th trueWidth="80">药品名称【规格】</th>
				<th>数量【单位】</th>
				<th>用量</th>
				<th>频次</th>
				<th>用法</th>
				<th>单价</th>
				<th>金额</th>		
			</tr>
			</thead>
			<tbody>
			<%
				int i = 0;
			%>
			<c:forEach items="${PatientDruginfo }" var="p">
						<%
							i++;
								if (i % 2 == 0) {
						%>
						<tr bgcolor="#FFFFC8" style="line-height: 23px;">
							<%
								} else {
							%>
						
						
						<tr style="line-height: 23px;">
							<%
								}
							%>

							<td>${p.prescription_drugName
								}[${p.prescription_drugStandard }]</td>
							<td>${p.prescription_drugNumber }${p.prescription_drugUnit }</td>
							<td>${p.prescription_drugDoseonce
								}${p.prescription_drugdoseunit }</td>
							<td>${p.prescription_drugRate }</td>
							<td>${p.prescription_drugUsename }</td>
							<td>15.6</td>
							<td>15.6</td>
						</tr>
					</c:forEach>
			
				<tr>
					<td>合计:</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>${Patient.prescription_drugTotalprice }</td>
				</tr>
			</tbody>
			
	</table>
	<input type="hidden" name="precreptNumber" value="${Patient.preCriptionNumber }">
	<input id="addSubmit" type="button" value="确认">
	
	</form>
</div>
<div style="clear:both;"></div>
</body>
</html>