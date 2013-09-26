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
	$("#save").click(function() {
		event.preventDefault();
		$('#Complete').attr('action', 'SuccessFaYao?PreCreptNumber=${Patient.preCriptionNumber}');
		$("#dialog-confirm").dialog("open");

	});
    $( "#dialog-confirm" ).dialog({
    	autoOpen : false,
        resizable: false,
        height:140,
        modal: true,
        buttons: {
          "ȷ�����": function() {
        	  $("#Complete").submit();
            $( this ).dialog( "close" );
          },
        	" ȡ��": function() {
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
                    document.getElementById("partdiv").innerHTML = "���ݼ��س���";  
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
	
		<div style="width:100%;height:90px;background-color:#FFFFE8;font-color:white;">
		<table>
			<tr align="center">
				<td><a href="<%=contextPath %>/JSP_OutPatientService/FaYaoShowPatientNameDetail"><img id="refresh" src="../image/Drug_image/refresh.png"></a></td>
				<td><img id="print" src="../image/Drug_image/printer.png"></td>
				<td><a href="<%=contextPath %>/JSP_OutPatientService/SuccessFaYao?PreCreptNumber=${Patient.preCriptionNumber }"><img id="save" src="../image/Drug_image/save.png"></a></td>
				<td><img id="return" src="../image/Drug_image/return.png"></td>
				<td><a href="javascript:parent.location.reload();"><img id="exit" src="../image/bg_image/exit.png" border="0"></a></td>
			</tr>
			<tr align="center">
				<td>ˢ��</td>
				<td>��ӡ</td>
				<td>ȷ�Ϸ�ҩ</td>
				<td>��ҩ����</td>
				<td>�˳�</td>
			</tr>
				</table>
		</div>

	<div id="dialog-confirm" title="ȷ��Ҫ�ύ��ҩ��Ϣ?">
  <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;">
  </span>ע�����֮���ύ��ҩƷ��洦������!</p>
</div>
<div style="float:right; width:140px; height:180%;" id="tabs">
������<input type="text" value="${Patient.preCriptionNumber }">
<ul>
    <li><a href="#tabs-1">δ��ҩ</a></li>
    <li><a href="#tabs-2">�ѷ�ҩ</a></li>
  </ul>
	<div id="tabs-1">
		
		<c:forEach items="${list }" var="m">
			<a href="<%=contextPath %>/JSP_OutPatientService/FaYaoShowDrugDetailByPatientName.action?PreCreptNumber=${m.preCriptionNumber }">${m.patientName } </a>
			<br>
		</c:forEach>
	</div>
	<div id="tabs-2">
     <c:forEach items="${list2 }" var="m">
			<a href="<%=contextPath %>/JSP_OutPatientService/YiFaYaoShowDrugDetailByPatientName.action?PreCreptNumber=${m.preCriptionNumber }">${m.patientName } </a>
			<br>
		</c:forEach>
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
							<td>��Ʊ��:</td>
							<td style="width:85px"></td>
							<td>�����:</td>
							<td></td>
							<td>��������:</td>
							<td>${Patient.patientName }</td>
						</tr>
						<tr>
							<td>�����Ա�:</td>
							<td>${Patient.patientSex }</td>
							<td>��������:</td>
							<td>${Patient.patientAge }</td>
							<td >�Һ�����:</td>
							<td style="width:152px" id="guahao"> ${Patient.registerDate }</td>
						</tr>
						<tr>
							<td>�շ���:</td>
							<td></td>
							<td>�շ�ʱ��:</td>
							<td style="width:152px" id="shoufei">${Patient.chargeDate }</td>
							<td>�������:</td>
							<td>${Patient.prescription_doctordept }</td>
						</tr>
						<tr>
							<td>ҽ��:</td>
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
				<th trueWidth="80">ҩƷ���ơ����</th>
				<th>��������λ��</th>
				<th>����</th>
				<th>Ƶ��</th>
				<th>�÷�</th>
				<th>����</th>
				<th>���</th>		
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
					<td>�ϼ�:</td>
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
	
	</form>
</div>
<div style="clear:both;"></div>
</body>
</html>