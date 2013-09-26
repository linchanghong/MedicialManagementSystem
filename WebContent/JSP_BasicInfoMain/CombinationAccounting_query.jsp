<!-- /*
 *�շ���Ŀ����JSP�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(JC_SF_PayDetail)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.8
 *
*/ -->
<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
<script>
	function getDataID() {
		var id = document.getElementById("DataId").value;
	}
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
	   var old_number, old_name;
	   
	   /* �ж��޸ı��ʱ����Ƿ��ظ� */
	   function ajaxValidateChangeByNumber()
	   {
		   var combinationAccounting_number=document.getElementById("combinationAccounting_number").value;
		   if(combinationAccounting_number!=old_number) {
			   createXMLHttpRequest();
			   xmlHttp.onreadystatechange=processAjaxValidateChangeByNumber;
			   xmlHttp.open("GET", "<%=contextPath%>/JSP_BasicInfoMain/JudgeCAccountingChangeByNumber?ChangeNumber="+combinationAccounting_number);
			   xmlHttp.send(null);
		   } else {
			   document.getElementById('ChangeNumber').innerHTML="";
				
		   }
	   }
	   /* �ж��޸ı��ʱ�����Ƿ��ظ� */
	   function ajaxValidateChangeByName()
	   {
		   var combinationAccounting_name=document.getElementById("combinationAccounting_name").value;
		   if(combinationAccounting_name != old_name)
			   {
		   			createXMLHttpRequest();
		   			xmlHttp.onreadystatechange=processAjaxValidateChangeByName;
		   			xmlHttp.open("GET", "<%=contextPath%>/JSP_BasicInfoMain/JudgeCAccountingChangeByName?ChangeName="+combinationAccounting_name);
		   			xmlHttp.send(null);
			   }
		   else
			   {
			   document.getElementById('ChangeName').innerHTML="";
			   }
	   }
	   /* �޸�����ʱ���ж�֮���ӡ��Ϣ */
	   function processAjaxValidateChangeByName()
	   {
		   var responseContext;
		   if(xmlHttp.readyState==4)
			   {
			     if(xmlHttp.status==200)
			    	 {
			    	    responseContext=xmlHttp.responseText;
			    	    if(responseContext.length>1)
			    	    {
			    	    	document.getElementById('ChangeName').innerHTML=responseContext;
			    	    }
			    	 }
			   }
	   }
	   /* �޸ı��ʱ���ж�֮���ӡ��Ϣ */
	   function processAjaxValidateChangeByNumber()
	   {
		   var responseContext;
		   if(xmlHttp.readyState==4)
			   {
			     if(xmlHttp.status==200)
			    	 {
			    	    responseContext=xmlHttp.responseText;
			    	    if(responseContext.length>1)
			    	    {
			    	    	document.getElementById('ChangeNumber').innerHTML=responseContext;
			    	    }
			    	 }
			   }
	   }
	$(function() {
		var Cprice=$("#combinationAccounting_price");
		fr = $("#change_combinationAccounting");
		tips = $(".validateTips");
		function change(form) {
			if ($("#combinationAccounting_number").val() == "") {
				updateTips("��ϻ��۱�Ų���Ϊ�գ�");
				return false;
			}
			if ($("#combinationAccounting_name").val() == "") {
				updateTips("��ϻ������Ʋ���Ϊ�գ�");
				return false;
			}
			if ($("#combinationAccounting_price").val() == "") {
				updateTips("��ϻ��ۼ۸���Ϊ�գ�");
				return false;

			}
			if ($("#combinationAccountingl_zjm").val() == "") {
				updateTips("�����벻��Ϊ�գ�");
				return false;
			}
			if ($.trim($("#ChangeNumber").html()) != "") {
				updateTips("�����Ϲ�����������룡");
				return false;
			}
			if ($.trim($("#ChangeName").html()) != "") {
				updateTips("�����Ϲ�����������룡");
				return false;
			}
			return true;
		}

		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}

		/*     function checkLength( o, n, min, max ) {
		 if ( o.val().length > max || o.val().length < min ) {
		 o.addClass( "ui-state-error" );
		 updateTips( "Length of " + n + " must be between " +
		 min + " and " + max + "." );
		 return false;
		 } else {
		 return true;
		 }
		 } */
		     function checkRegexp( o, regexp, n ) {
		 if ( !( regexp.test( o.val() ) ) ) {
		 o.addClass( "ui-state-error" );
		 updateTips( n );
		 return false;
		 } else {
		 return true;
		 }
		 } 

		$("#dialog-form").dialog({
			autoOpen : false,
			height : 280,
			width : 490,
			modal : true,
			buttons : {
				"ȷ���޸�" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/

					bValid = change(fr);
					bValid = bValid && checkRegexp( Cprice, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "�۸�ֻ������Ǹ���" );
					if (bValid) {
						$("#change_combinationAccounting").submit();
						$(this).dialog("close");
					}
				},
				"ȡ��" : function() {
					$(this).dialog("close");
				}
			},
			close : function() {
				/*allFields.val( "" ).removeClass( "ui-state-error" );*/
			}
		});

		$("#deleteSubmit").button().click(function() {

		});

		$("#query").button().click(function() {

		});
		$("[name='change']").button().click(function() {
			event.preventDefault();
			var temp = $(this).parent().prev();
			$("#combinationAccounting_zjm").val($(temp).text());
			temp = $(temp).prev();
			$("#combinationAccounting_price").val($(temp).text());
			temp = $(temp).prev();
			$("#combinationAccounting_name").val($(temp).text());
			old_name=$("#combinationAccounting_name").val();
			temp = $(temp).prev();
			$("#combinationAccounting_number").val($(temp).text());
			old_number = $("#combinationAccounting_number").val();
			temp = $(temp).prev().children("#DataId");
			$("#combinationAccounting_id").val($(temp).val());

			$("#dialog-form").dialog("open");
		});
	});
</script>
<style>
.validateTips {
	color: red;
}
#ChangeName,#ChangeNumber{
	color: red;
	font-size: small;
}
</style>
</head>
<body>
<div id="dialog-form" title="�޸���ϻ�����Ŀ">
		<p class="validateTips">ע�⣺����עΪ�Ǳ����������������</p>
			<div id="ChangeNumber"></div>
			<div id="ChangeName"></div>
		<s:form id="change_combinationAccounting" action="updateCAccounting" method="post">
			<fieldset>
				<input type="hidden" name="combinationAccounting.combinationAccounting_id" id="combinationAccounting_id" />
				<label for="name">�շѱ��: &nbsp;&nbsp; &nbsp;  </label><input type="text"
					name="combinationAccounting.combinationAccounting_number" id="combinationAccounting_number"
					class="text ui-widget-content ui-corner-all" onblur="ajaxValidateChangeByNumber()" /> 
					<label for="name">��ϻ�������:</label>
				<input type="text" name="combinationAccounting.pcombinationAccountingayDetail_name"
					id="combinationAccounting_name" class="text ui-widget-content ui-corner-all" onblur="ajaxValidateChangeByName()"  />
				<label for="name">��ϻ��ۼ۸�:</label>
				<input type="text" name="combinationAccounting.combinationAccounting_price"
					id="combinationAccounting_price" class="text ui-widget-content ui-corner-all" />
				<label for="name">������:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</label> <input type="text"
					name="combinationAccounting.combinationAccounting_zjm" id="combinationAccounting_zjm"
					class="text ui-widget-content ui-corner-all" /> 


			</fieldset>
		</s:form>
	</div>
	<h4 align="left">��ϻ�����Ŀ��ѯ</h4>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td align="center">
					<p style="padding-left: 300px">
						<font color="red">δ��ѯ������Ҫ����Ϣ!</font>
					</p>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
		<form action="delete" method="post">
			<table border=1 align=center width="750" align="center"
				cellpadding="0" cellspacing="0">
				<tr align=center>
								<td>ѡ��</td>
								<td>��ϻ��۱��</td>
								<td>��ϻ�������</td>
								<td>��ϻ��ۼ۸�</td>
								<td>������</td>
								<td>����</td>
				</tr>
				<tr align=center>			
							<td><input name="checkId" id="DataId" type="checkbox"
										value="${list.combinationAccounting_id}" /></td>
									<td>${list.combinationAccounting_number}</td>
									<td>${list.combinationAccounting_name}</td>
									<td>${list.combinationAccounting_price}</td>
									<td>${list.combinationAccounting_zjm}</td>
									<td><button name="change">�޸�</button></td>
				</tr>
			</table>
			<input id="deleteSubmit" type="submit" value="ɾ��ѡ����" />
			</form>
		</c:otherwise>
	</c:choose>
	<p align="center">
		<a href="<%=contextPath %>/JSP_BasicInfoMain/showCAccounting">����</a>
	</p>

</body>
</html>