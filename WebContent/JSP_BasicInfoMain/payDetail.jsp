<!-- /*
 *�շ���Ŀ����JSP�ļ�
 *��Ӧ���ݱ���ϻ�����Ŀ(JC_SF_PayDetail)
 *�༭�ߣ�������
 *ʱ�䣺2013.8.8
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
		window.self.location = "show?currentPage=" + currentPage;
	}
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
	   //�ж���ӱ��ʱ����Ƿ��ظ�
	   function ajaxValidateByNumber()
	   {

		   var payDetail_number=document.getElementById("payDetail_number1").value;
		   createXMLHttpRequest();
		   xmlHttp.onreadystatechange=processAjaxValidateByNumber;
		   xmlHttp.open("GET", "<%=contextPath %>/JSP_BasicInfoMain/JudgePayDetailByNumber?number="+payDetail_number);
		   xmlHttp.send(null);
	   }
	 //�ж��������ʱ�����Ƿ��ظ�
	   function ajaxValidateByName()
	   {
		   var payDetail_name=document.getElementById("payDetail_name1").value;
			createXMLHttpRequest();
		   xmlHttp.onreadystatechange=processAjaxValidateByName;
		   xmlHttp.open("GET", "<%=contextPath %>/JSP_BasicInfoMain/JudgePayDetailByName?name="+payDetail_name);
		   xmlHttp.send(null);
	<%-- 	   $.post('<%=contextPath %>/JSP_BasicInfoMain/JudgeCAccountingByName',{name:combinationAccounting_name}, function(data){if(data.length>1)
		    {
		    	document.getElementById('name').innerHTML=data;
		    }}); --%>
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
	 //�����Ϣ����ʱ���ж��Ƿ��ظ�����ӡ��Ϣ
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
	   //�����Ϣ���ʱ���ж��Ƿ��ظ�����ӡ��Ϣ
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
		var price=$( "#payDetail_price1" );
		var ChangePrice=$( "#payDetail_price" );
		 fb=$("#add_pay");
		fr = $("#change_pay");
		//�ж��޸ı�ʱ�Ƿ���Ϲ淶
		function change(form) {
			if ($("#payDetail_number").val() == "") {
				updateTips("�շѱ�Ų���Ϊ�գ�",0);
				return false;
			}
			if ($("#payDetail_name").val() == "") {
				updateTips("�շ����Ʋ���Ϊ��",0);
				return false;
			}
			if ($("#payDetail_property").val() == "") {
				updateTips("�շ����ʲ���Ϊ�գ�",0);
				return false;
			}
			if ($("#payDetail_object").val() == "") {
				updateTips("�շѶ�����Ϊ�գ�",0);
				return false;
			}
			if ($("#payDetail_standard").val() == "") {
				updateTips("�շѱ�׼����Ϊ�գ�",0);
				return false;
			}
			if ($("#payDetail_price").val() == "") {
				updateTips("�շѼ۸���Ϊ�գ�",0);
				return false;

			}
			if ($("#payDetail_zjm").val() == "") {
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
		//�ж���ӱ�ʱ�Ƿ���Ϲ淶
		function add(form) {
			if ($("#payDetail_number1").val() == "") {
				updateTips("�շѱ�Ų���Ϊ�գ�",1);
				return false;
			}
			if ($("#payDetail_name1").val() == "") {
				updateTips("�շ����Ʋ���Ϊ��",1);
				return false;
			}
			if ($("#payDetail_property1").val() == "") {
				updateTips("�շ����ʲ���Ϊ�գ�",1);
				return false;
			}
			if ($("#payDetail_object1").val() == "") {
				updateTips("�շѶ�����Ϊ�գ�",1);
				return false;
			}
			if ($("#payDetail_standard1").val() == "") {
				updateTips("�շѱ�׼����Ϊ�գ�",1);
				return false;
			}
			if ($("#payDetail_price1").val() == "") {
				updateTips("�շѼ۸���Ϊ�գ�",1);
				return false;

			}
			if ($("#payDetail_zjm1").val() == "") {
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
		//��ӡ������Ϣ
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
		 //�ж��Ƿ���������ʽ
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
			width : 455,
			modal : true,
			buttons : {
				"ȷ���޸�" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/

					bValid = change(fr);
					bValid = bValid && checkRegexp( ChangePrice, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "�۸�ֻ������Ǹ���",0 );
					if (bValid) {
						$("#change_pay").submit();
						$(this).dialog("close");
					}
				},
				"ȡ��" : function() {
					$(this).dialog("close");
				}
			},

		});

		$("#deleteSubmit").button().click(function() {

		});
		
		$("#addSubmit").button().click(function() {
				var Valid = true;
				Valid = add(fb);
				Valid = Valid && checkRegexp( price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "�۸�ֻ������Ǹ���" ,1);
				if (Valid) {
					$("#add_pay").submit();
				}

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
.AddValidateTips,.ChangeValidateTips{
	color: red;
}
#name, #number ,#ChangeNumber,#ChangeName{
	color: red;
	font-size: small;
}
</style>
</head>
<body>

	<div id="dialog-form" title="�޸��շ���ϸ��Ŀ">
		<p class="ChangeValidateTips">ע�⣺����עΪ�Ǳ����������������</p>
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

	<h4>��ӭ�����շ���ϸ��Ŀ</h4>
			<div id="number"></div>
	<div id="name"></div>
	<p class="AddValidateTips">ע�⣺����עΪ�Ǳ����������������</p>

	<div>

		<s:form id="add_pay" method="post" action="add">
			<table>

				<tr>
					<%-- 		<tr>
			<td><s:textfield name="payDetail.payDetail_number" label="�շѱ��"
				cssStyle="text ui-widget-content ui-corner-all"></s:textfield>
			<s:textfield name="payDetail.payDetail_name" label="�շ�����"></s:textfield>
			</td>
			
			<td><s:textfield name="payDetail.payDetail_property" label="�շ�����"></s:textfield>
			<s:textfield name="payDetail.payDetail_object" label="�շѶ���"></s:textfield>
			</td><td>
			<s:textfield name="payDetail.payDetail_standard" label="�շѱ�׼"></s:textfield>
			<s:textfield name="payDetail.payDetail_price" label="�շѼ۸�"></s:textfield>
			<s:textfield name="payDetail.payDetail_zjm" label="������"></s:textfield>
			<s:textfield name="payDetail.payDetail_remark" label="��ע��Ϣ"></s:textfield>
			</td></tr> --%>
					<td><label for="name">�շѱ��</label></td>
					<td><input type="text" name="payDetail.payDetail_number"
						id="payDetail_number1"
						class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByNumber()"/></td>
					<td><label for="name">�շ�����</label></td>
					<td><input type="text" name="payDetail.payDetail_name"
						id="payDetail_name1" class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByName()"/></td>
					<td><label for="name">�շ�����</label></td>
					<td><input type="text" name="payDetail.payDetail_property"
						id="payDetail_property1" class="text ui-widget-content ui-corner-all" /></td>
				</tr>
				<tr>
					<td><label for="name">�շѶ���</label></td>
					<td><input type="text" name="payDetail.payDetail_object"
						id="payDetail_object1" class="text ui-widget-content ui-corner-all" /></td>
					<td><label for="name">�շѱ�׼</label></td>
					<td><input type="text" name="payDetail.payDetail_standard"
						id="payDetail_standard1" class="text ui-widget-content ui-corner-all" /></td>
					<td><label for="name">�շѼ۸�</label></td>
					<td><input type="text" name="payDetail.payDetail_price"
						id="payDetail_price1" class="text ui-widget-content ui-corner-all" /></td>
				</tr>
				<tr>
					<td><label for="name">������&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="text" name="payDetail.payDetail_zjm"
						id="payDetail_zjm1" class="text ui-widget-content ui-corner-all" /></td>

					<td><label for="name">��ע��Ϣ:</label></td>

					<td colspan="3"><textarea name="payDetail.payDetail_remark"
							class="text ui-widget-content ui-corner-all"
							style="width: 310px;"></textarea> 
							<input id="addSubmit" type="button" value="ȷ�����"></td>
						
				</tr>
			</table>
		</s:form>

	</div>

	<div>
		<form action="QueryPayDetail" method="post">
			���շѱ�Ž��в�ѯ��<input type="text" name="QueryId"
				class="text ui-widget-content ui-corner-all" /> <input id="query"
				type="submit" value="��ѯ">
		</form>

	</div>
	<br>
	<form action="delete" method="post">
		<div>
			<c:choose>
				<c:when test="${empty pageModel.list}">
					<td align="center">
						<p style="padding-left: 300px">
							<font color="red">û���շ���Ŀ��Ϣ!</font>
						</p>
					</td>
				</c:when>
				<c:otherwise>
					<table border=1 align=center width="100%" align="center"
						cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>ѡ��</td>
								<td>�շѱ��</td>
								<td>�շ�����</td>
								<td>�շ�����</td>
								<td>�շѶ���</td>
								<td>�շѱ�׼</td>
								<td>�շѼ۸�</td>
								<td>������</td>
								<td>��ע</td>
								<td>����</td>
							</tr>

							<c:forEach items="${pageModel.list}" var="m">
								<tr bgcolor="#f2f2f2">
									<td><input name="checkId" id="DataId" type="checkbox"
										value="${m.payDetail_id}" /></td>
									<td>${m.payDetail_number}</td>
									<td>${m.payDetail_name}</td>
									<td>${m.payDetail_property}</td>
									<td>${m.payDetail_object}</td>
									<td>${m.payDetail_standard}</td>
									<td>${m.payDetail_price}</td>
									<td>${m.payDetail_zjm}</td>
									<td>${m.payDetail_remark}</td>
									<td><button name="change">�޸�</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input id="deleteSubmit" type="submit" value="ɾ��ѡ����" /></form>
	<table border="0" width="750" align="center">
		<tr>

			<td align="right">�ܼ�¼����${pageModel.totalRecords}
				��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ <a
				href="show?currentPage=${pageModel.previousPage}"> ��һҳ </a> <a
				href="show?currentPage=${pageModel.nextPage}"> ��һҳ </a> <select
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
</body>
</html>