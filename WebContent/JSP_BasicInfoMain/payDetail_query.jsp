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
	function getDataID()
	{
		var id=document.getElementById("DataId").value;
	}

	  //����һ���������ڴ��XMLHttpRequest����
	   var xmlHttp;
	   //�����޸�ʱ��ʼ״̬�µı��������
	   var old_number,old_name;
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
	
	 //�ж��޸ı��ʱ����Ƿ��ظ�
	   function ajaxValidateChangeByNumber()
	   {
		   var payDetail_number=document.getElementById("payDetail_number").value;
		   if(payDetail_number != old_number)
			   {
		   			createXMLHttpRequest();
		   			xmlHttp.onreadystatechange=processAjaxValidateChangeByNumber;
		   			xmlHttp.open("GET", "<%=contextPath %>/JSP_BasicInfoMain/JudgePayDetailChangeByNumber?ChangeNumber="+payDetail_number);
		   			xmlHttp.send(null);
			   }
		   else
			   {
			   document.getElementById('ChangeNumber').innerHTML="";
			   }
	   }
	 //�ж��޸�����ʱ�����Ƿ��ظ�
	   function ajaxValidateChangeByName()
	   {
		   var payDetail_name=document.getElementById("payDetail_name").value;
		   if(payDetail_name != old_name)
			   {
					createXMLHttpRequest();
		   			xmlHttp.onreadystatechange=processAjaxValidateChangeByName;
		   			xmlHttp.open("GET", "<%=contextPath %>/JSP_BasicInfoMain/JudgePayDetailChangeByName?ChangeName="+payDetail_name);
		   			xmlHttp.send(null);
			   }
		   else
		   {
			   document.getElementById('ChangeName').innerHTML="";
		   }
	   }
	   //�޸���Ϣ����ʱ���ж��Ƿ��ظ�����ӡ��Ϣ
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
	   //�޸���Ϣ���ʱ���ж��Ƿ��ظ�����ӡ��Ϣ
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
		var price=$( "#payDetail_price" );
		fr = $("#change_pay");
		tips = $(".validateTips");
		
		   
		   
		function add(form) {
			if ($("#payDetail_number").val() == "") {
				updateTips("�շѱ�Ų���Ϊ�գ�");
				return false;
			}
			if ($("#payDetail_name").val() == "") {
				updateTips("�շ����Ʋ���Ϊ��");
				return false;
			}
			if ($("#payDetail_property").val() == "") {
				updateTips("�շ����ʲ���Ϊ�գ�");
				return false;
			}
			if ($("#payDetail_object").val() == "") {
				updateTips("�շѶ�����Ϊ�գ�");
				return false;
			}
			if ($("#payDetail_standard").val() == "") {
				updateTips("�շѱ�׼����Ϊ�գ�");
				return false;
			}
			if ($("#payDetail_price").val() == "") {
				updateTips("�շѼ۸���Ϊ�գ�");
				return false;

			}
			if ($("#payDetail_zjm").val() == "") {
				updateTips("�����벻��Ϊ�գ�");
				return false;
			}
			if ($.trim($("#ChangeNumber").html()) != "") {
				updateTips("�����Ϲ�����������룡",0);
				return false;
			}
			if ($.trim($("#ChangeName").html()) != "") {
				updateTips("�����Ϲ�����������룡",0);
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
			width : 455,
			modal : true,
			buttons : {
				"ȷ���޸�" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/
					
					bValid = add(fr);
					bValid = bValid && checkRegexp(price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "�۸�ֻ������Ǹ���" );
					if (bValid) {
						$("#change_pay").submit();
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
		$("#addSubmit").button().click(function() {

		});
		$("#query").button().click(function() {

		});
		$("[name='change']").button().click(function() {
			//������ʵ���ִֻ�б�����
			event.preventDefault();
			//��ȡ�����ǰ�ڵ�
			var temp = $(this).parent().prev();
			//��ǰ�ڵ��ֵ����ָ��ID��value
			$("#payDetail_remark").val($(temp).text());
			
			temp = $(temp).prev();
			$("#payDetail_zjm").val($(temp).text());
			temp = $(temp).prev();
			$("#payDetail_price").val($(temp).text());
			temp = $(temp).prev();
			$("#payDetail_standard").val($(temp).text());
			
			temp = $(temp).prev();
			$("#payDetail_object").val($(temp).text());
			
			temp = $(temp).prev();
			$("#payDetail_property").val($(temp).text());
			
			temp = $(temp).prev();
			$("#payDetail_name").val($(temp).text());
			//����ʼ���Ƹ�ֵ
			old_name=$("#payDetail_name").val();
			
			temp = $(temp).prev();
			$("#payDetail_number").val($(temp).text());
			//����ʼ��Ÿ�ֵ
			old_number=$("#payDetail_number").val();
			
			temp = $(temp).prev().children("#DataId");
			$("#payDetail_id").val($(temp).val());
			
			$("#dialog-form").dialog("open");
		});
	});
</script>
<style>
.validateTips {
	color: red;
}
#ChangeNumber,#ChangeName{
	color: red;
	font-size: small;
}
</style>
</head>
<body>
<div id="dialog-form" title="�޸��շ���ϸ��Ŀ">
		<p class="validateTips">ע�⣺����עΪ�Ǳ����������������</p>
			<div id="ChangeNumber"></div>
			<div id="ChangeName"></div>
		<s:form id="change_pay" action="update" method="post">
			<fieldset>
				<input type="hidden" name="payDetail.payDetail_id" id="payDetail_id" />
				<label for="name">�շѱ��</label> <input type="text"
					name="payDetail.payDetail_number" id="payDetail_number"
					class="text ui-widget-content ui-corner-all"  onblur="ajaxValidateChangeByNumber()"/> 
					<label for="name">�շ�����</label>
				<input type="text" name="payDetail.payDetail_name"
					id="payDetail_name" class="text ui-widget-content ui-corner-all"  onblur="ajaxValidateChangeByName()"/>
				<label for="name">�շ�����</label> <input type="text"
					name="payDetail.payDetail_property" id="payDetail_property"
					class="text ui-widget-content ui-corner-all" /> 
					<label for="name">�շѶ���</label>
				<input type="text" name="payDetail.payDetail_object"
					id="payDetail_object" class="text ui-widget-content ui-corner-all" />
				<label for="name">�շѱ�׼</label> <input type="text"
					name="payDetail.payDetail_standard" id="payDetail_standard"
					class="text ui-widget-content ui-corner-all" /> <label for="name">�շѼ۸�</label>
				<input type="text" name="payDetail.payDetail_price"
					id="payDetail_price" class="text ui-widget-content ui-corner-all" />
				<label for="name">������&nbsp;&nbsp;&nbsp;</label> <input type="text"
					name="payDetail.payDetail_zjm" id="payDetail_zjm"
					class="text ui-widget-content ui-corner-all" /> <br> <label
					for="name">��ע��Ϣ:</label><br>
				<textarea name="payDetail.payDetail_remark" id="payDetail_remark"
					class="text ui-widget-content ui-corner-all" style="width: 310px;"></textarea>


			</fieldset>
		</s:form>
	</div>
	<h4 align="left">�շ���ϸ��Ŀ��ѯ</h4>
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
				<td>״̬</td>
					<td>�շѱ�ţ�</td>
					<td>�շ����ƣ�</td>
					<td>�շ����ʣ�</td>
					<td>�շѶ���</td>
					<td>�շѱ�׼��</td>
					<td>�շѼ۸�</td>
					<td>�����룺</td>
					<td>��ע��Ϣ��</td>
					<td>������</td>
				</tr>
				<tr align=center>			
							<td><input name="checkId"  type="checkbox"
								value="${list.payDetail_id}" /></td>
							<td>${list.payDetail_number}</td>
							<td>${list.payDetail_name}</td>
							<td>${list.payDetail_property}</td>
							<td>${list.payDetail_object}</td>
							<td>${list.payDetail_standard}</td>
							<td>${list.payDetail_price}</td>
							<td>${list.payDetail_zjm}</td>
							<td>${list.payDetail_remark}</td>
							<td><button name="change">�޸�</button></td>
				</tr>
			</table>
			<input id="deleteSubmit" type="submit" value="ɾ��ѡ����" />
			</form>
		</c:otherwise>
	</c:choose>
	<p align="center">
		<a href="<%=contextPath %>/JSP_BasicInfoMain/show">����</a>
	</p>

</body>
</html>