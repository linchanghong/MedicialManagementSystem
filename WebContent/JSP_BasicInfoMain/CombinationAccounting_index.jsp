<!-- /*
 *��ϻ�������JSP�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(JC_SF_CombinationAccounting)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.13
 *
*/ -->
<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	function changePage() {
		var currentPage = document.getElementById("currentPage").value;
		window.self.location = "showCAccounting?currentPage=" + currentPage;
	}
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
	   /* �ж���ӱ��ʱ����Ƿ��ظ� */
	   function ajaxValidateByNumber()
	   {
		   var combinationAccounting_number=document.getElementById("combinationAccounting_number1").value;
		   createXMLHttpRequest();
		   xmlHttp.onreadystatechange=processAjaxValidateByNumber;
		   xmlHttp.open("GET", "<%=contextPath%>/JSP_BasicInfoMain/JudgeCAccountingByNumber?number="+combinationAccounting_number);
		   xmlHttp.send(null);
	   }
	   /* �ж��������ʱ�����Ƿ��ظ� */
	   function ajaxValidateByName()
	   {
		   var combinationAccounting_name=document.getElementById("combinationAccounting_name1").value;
			createXMLHttpRequest();
		   xmlHttp.onreadystatechange=processAjaxValidateByName;
		   xmlHttp.open("GET", "<%=contextPath%>/JSP_BasicInfoMain/JudgeCAccountingByName?name="+combinationAccounting_name);
		   xmlHttp.send(null);
	<%-- 	   $.post('<%=contextPath %>/JSP_BasicInfoMain/JudgeCAccountingByName',{name:combinationAccounting_name}, function(data){if(data.length>1)
		    {
		    	document.getElementById('name').innerHTML=data;
		    }}); --%>
	   }
	   /* �������ʱ���ж�֮���ӡ��Ϣ�� */
	   function processAjaxValidateByName()
	   {
		   var responseContext;
		   if(xmlHttp.readyState==4)
			   {
			     if(xmlHttp.status==200)
			    	 {
			    	    responseContext=xmlHttp.responseText;
			    	    if(responseContext.length>1)
			    	    {
			    	    	document.getElementById('name').innerHTML=responseContext;
			    	    }
			    	 }
			   }
	   }
	   /* ��ӱ��ʱ���ж�֮���ӡ��Ϣ�� */
	   function processAjaxValidateByNumber()
	   {
		   var responseContext;
		   if(xmlHttp.readyState==4)
			   {
			     if(xmlHttp.status==200)
			    	 {
			    	    responseContext=xmlHttp.responseText;
			    	    if(responseContext.length>1)
			    	    {
			    	    	document.getElementById('number').innerHTML=responseContext;
			    	    }
			    	 }
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
		var price=$("#combinationAccounting_price1");
		var Cprice=$("#combinationAccounting_price");
		fb = $("#add_combinationAccounting");
		fr = $("#change_combinationAccounting");
		tips = $(".validateTips");
		function change(form) {
			if ($("#combinationAccounting_number").val() == "") {
				updateTips("��ϻ��۱�Ų���Ϊ�գ�",0);
				return false;
			}
			if ($("#combinationAccounting_name").val() == "") {
				updateTips("��ϻ������Ʋ���Ϊ�գ�",0);
				return false;
			}
			if ($("#combinationAccounting_price").val() == "") {
				updateTips("��ϻ��ۼ۸���Ϊ�գ�",0);
				return false;

			}
			if ($("#combinationAccountingl_zjm").val() == "") {
				updateTips("�����벻��Ϊ�գ�",0);
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
		function add(form) {
			if ($("#combinationAccounting_number1").val() == "") {
				updateTips("��ϻ��۱�Ų���Ϊ�գ�",1);
				return false;
			}
			if ($("#combinationAccounting_name1").val() == "") {
				updateTips("��ϻ������Ʋ���Ϊ�գ�",1);
				return false;
			}
			if ($("#combinationAccounting_price1").val() == "") {
				updateTips("��ϻ��ۼ۸���Ϊ�գ�",1);
				return false;

			}
			if ($("#combinationAccountingl_zjm1").val() == "") {
				updateTips("�����벻��Ϊ�գ�",1);
				return false;
			}
			if ($.trim($("#number").html()) != "") {
				updateTips("�����Ϲ�����������룡",1);
				return false;
			}
			if ($.trim($("#name").html()) != "") {
				updateTips("�����Ϲ�����������룡",1);
				return false;
			}
			return true;
		}

		function updateTips(t,c) {
			
			if(c==0)
				{
					tips=$(".ChangeValidateTips");
				}
			else
				{
					tips=$(".AddValidateTips");
				}
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
   		function checkRegexp( o, regexp, n ,c) {
		 if ( !( regexp.test( o.val() ) ) ) {
		 o.addClass( "ui-state-error" );
		 updateTips( n ,c);
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

					bValid = bValid && checkRegexp( Cprice, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "�۸�ֻ������Ǹ���" ,0);
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

		$("#addSubmit").button().click(function() {
			var Valid = true;
			Valid = add(fb);
			Valid = Valid && checkRegexp( price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "�۸�ֻ������Ǹ���" ,1);
			if (Valid) {
				$("#add_combinationAccounting").submit();
			}

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
.AddValidateTips,.ChangeValidateTips{
	color: red;
}
#name, #number ,#ChangeName,#ChangeNumber{
	color: red;
	font-size: small;
}
</style>
</head>
<body>

	<div id="dialog-form" title="�޸���ϻ�����Ŀ">
		<p class="ChangeValidateTips">ע�⣺����עΪ�Ǳ����������������</p>
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

	<h4>��ӭ������ϻ�����Ŀ</h4>
	<div id="number"></div>
	<div id="name"></div>
	<p class="AddValidateTips">ע�⣺����עΪ�Ǳ����������������</p>
	<div>

		<s:form id="add_combinationAccounting" method="post" action="addCAccounting">


			<table>
				<tr>
					<td><label for="name">�շѱ��</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_number"
						id="combinationAccounting_number1"
						class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByNumber()"/></td>
					<td><label for="name">��ϻ�����</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_name"
						id="combinationAccounting_name1" class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByName()"/></td>
					<td><label for="name">��ϻ��ۼ۸�</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_price"
						id="combinationAccounting_price1" class="text ui-widget-content ui-corner-all" /></td>
				</tr>
				<tr>
					<td><label for="name">������&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_zjm"
						id="combinationAccounting_zjm1" class="text ui-widget-content ui-corner-all" /></td>
					<td><input id="addSubmit" type="button" value="ȷ�����" />
					</td>

				</tr>
			</table>
		</s:form>

	</div>

	<div>
		<form action="QueryCAccounting" method="post">
			����ϻ��۱�Ž��в�ѯ��<input type="text" name="QueryId"
				class="text ui-widget-content ui-corner-all" /> <input id="query"
				type="submit" value="��ѯ">
		</form>

	</div>
	<br>
	<form action="deleteCAccounting" method="post">
		<div>
			<c:choose>
				<c:when test="${empty pageModel.list}">
					<td align="center">
						<p style="padding-left: 300px">
							<font color="red">û����ϻ�����Ŀ��Ϣ!</font>
						</p>
					</td>
				</c:when>
				<c:otherwise>
					<table border=1 align=center width="100%" align="center"
						cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>ѡ��</td>
								<td>��ϻ��۱��</td>
								<td>��ϻ�������</td>
								<td>��ϻ��ۼ۸�</td>
								<td>������</td>
								<td>����</td>
							</tr>

							<c:forEach items="${pageModel.list}" var="m">
								<tr bgcolor="#f2f2f2">
									<td><input name="checkId" id="DataId" type="checkbox"
										value="${m.combinationAccounting_id}" /></td>
									<td>${m.combinationAccounting_number}</td>
									<td>${m.combinationAccounting_name}</td>
									<td>${m.combinationAccounting_price}</td>
									<td>${m.combinationAccounting_zjm}</td>
									<td><button name="change">�޸�</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input id="deleteSubmit" type="submit" value="ɾ��ѡ����" />
	</form>
	<table border="0" width="750" align="center">
		<tr>

			<td align="right">�ܼ�¼����${pageModel.totalRecords}
				��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ <a
				href="showCAccounting?currentPage=${pageModel.previousPage}"> ��һҳ </a> <a
				href="showCAccounting?currentPage=${pageModel.nextPage}"> ��һҳ </a> <select
				id="currentPage" onchange="changePage()">
					<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
						<c:choose>
							<c:when test="${pageModel.currPage ne vs.count}">
								<option value="${vs.count}">��${vs.count}ҳ</option>
							</c:when>
							<c:otherwise>
								<option value="${vs.count}" selected="selected">
									��${vs.count}ҳ</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select>
			</td>
		</tr>
		</c:otherwise>
		</c:choose>
	</table>

	</div>
<script type="text/javascript">
  
</script>
</body>
</html>