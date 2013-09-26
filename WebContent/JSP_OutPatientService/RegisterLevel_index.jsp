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
<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
</head>


<table width="820" border="0">
	<tr>
		<td colspan="2" style="background-color: #99bbbb;">
			<h1 align=center>�Һż�����Ϣά��</h1>
		</td>
	</tr>
</table>

<body>
	<hr />
	<!--  ��ʾ��Ϣ�� -->
	<div id="users-contain" class="ui-widget">
		<h2>�Һż�����Ϣ</h2>
		<table id="users" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header ">
					<th>ѡ�н��в���</th>
					<th>�Һż�����</th>
					<th>�Һż�������</th>
					<th>�Һż���������</th>
					<th>�Һŷ�</th>
					<th>ƴ����</th>
					<th>�Һż������</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<!--           //��ʾ���� -->
					<c:forEach items="${pageModel.list}" var="a">
						<tr align="center">
							<td><input type="radio" name="rlid"
								value="${a.registerLevel_id}" /></td>
							<td>
								<div class="title1">${a.registerLevel_id}</div>
							</td>
							<td>
								<div class="td1">${a.registerLevel_name}</div>
							</td>
							<td>
								<div class="td1">${a.registerLevel_zjm}</div>
							</td>
							<td>
								<div class="td1">${a.registerLevel_fee}</div>
							</td>
							<td>
								<div class="td1">${a.registerLevel_py}</div>
							</td>
							<td>
								<div class="td1">${a.registerLevel_code}</div>
							</td>

						</tr>
					</c:forEach>
					<!-- //��ʾҳ�� -->
					<table border="0" width="750" align="center">
						<tr>
							<td align="right">�ܼ�¼����${pageModel.totalRecords}
								��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ <a
								href="<%=contextPath %>/RegisterLevel/queryAll.action?currPage=${pageModel.previousPage}">��һҳ</a>
								<a
								href="<%=contextPath %>/RegisterLevel/queryAll.action?currPage=${pageModel.nextPage}">��һҳ</a>
								<select id="currpage" onchange="changePage()">
									<c:forEach begin="1" end="${pageModel.totalPage}"
										varStatus="vs">
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
					</table>
				</tr>
			</tbody>
		</table>
	<button id="create-user">���</button>
	<button id="modify-user">�޸�</button>
	<button id="delete-user">ɾ��</button>
	<button id="query-user">��ѯ</button>
	</div>


	<!-- //ʵ���������޸Ĺ��� -->
	<style>
body {
	font-size: 62.5%;
}

label,input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

div#users-contain {
	width: 100%;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td,div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
	<script>
		$(function() { //¼����Ϣ
			var name = $("#registerLevel_name"), zjm = $("#registerLevel_zjm"), fee = $("#registerLevel_fee"), py = $("#registerLevel_py"), code = $("#registerLevel_code"), allFields = $(
					[]).add(name).add(zjm).add(fee).add(py).add(code), tips = $(".validateTips");

			function updateTips(t) {
				tips.text(t).addClass("ui-state-highlight");
				setTimeout(function() {
					tips.removeClass("ui-state-highlight", 1500);
				}, 500);
			}

			function checkLength(o, n, min, max) { //��֤��������
				if (o.val().length > max || o.val().length <= min) {
					o.addClass("ui-state-error");
					updateTips(n + "Ҫ��Ϊ��");
					return false;
				} else {
					return true;
				}
			}
             //��ʾ��
			$( "#dialog-pop" ).dialog({
				autoOpen : false});
			
			
			//��֤Ϊ��
			$("#dialog-form1").dialog({
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					"ȷ��" : function() {
						var bValid = true;
						allFields.removeClass("ui-state-error");

						bValid = bValid && checkLength(name, "�Һż�������", 0, 80);
						bValid = bValid && checkLength(zjm, "�Һż���������", 0, 80);
						bValid = bValid && checkLength(fee, "�Һŷ�", 0, 80);
						bValid = bValid && checkLength(py, "ƴ����", 0, 80);
						bValid = bValid && checkLength(code, "�Һż������", 0, 80);

						if (bValid) {
							$("#form1").submit();
							$(this).dialog("close");
						}
					},
					ȡ�� : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
					allFields.val("").removeClass("ui-state-error");
				}
			});
			
			$("#dialog-form2").dialog({
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					"ȷ��" : function() {
						//alert($("input[name='queryData']").val());
						$("#form2").submit();
					},
					ȡ�� : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				
				}
			});
			
           //����  ɾ�� �޸İ�ť�Ĳ���
			$("#create-user").button().click(function() {
				$("#registerLevel_id").val("");
				$("#dialog-form1").dialog("open");
			});

			$("#modify-user").button().click(function() {
				var item = $("input[name='rlid']:checked");
				if (null == $(item).val()) {
					$("#dialog-pop").dialog("open");
					return;
				}
				$("input[name='registerLevel_id']").val($(item).val());
				item = $(item).parent().next().next().children(".td1");
				$("#registerLevel_name").val($(item).text());
				item = $(item).parent().next().children(".td1");
				$("#registerLevel_zjm").val($(item).text());
				item = $(item).parent().next().children(".td1");
				$("#registerLevel_fee").val($(item).text());
				item = $(item).parent().next().children(".td1");
				$("#registerLevel_py").val($(item).text());
				item = $(item).parent().next().children(".td1");
				$("#registerLevel_code").val($(item).text());
				$("#dialog-form1").dialog("open");
				
			});

			$("#delete-user").button().click(function() {
				var item = $("input[name='rlid']:checked");
				if (null == $(item).val()) {
					$("#dialog-pop").dialog("open");
					return;
				}
				window.location = "delete?registerLevel_id=" + $(item).val();
			});
			
			$("#query-user").button().click(function() {
					$("#dialog-form2").dialog("open");
					

			});
			
		});
	</script>
	
<!-- 	��ʾ�� -->
	<div id="dialog-pop" title="��ʾ��Ϣ">
		<p>��ѡ��һ�����в���</p>
	</div>
	
	
	<div id="dialog-form2" title="">
	<form id="form2" action="<%=contextPath%>/RegisterLevel/query.action"
			method="post">      
               <fieldset>
				<label for="name">ѡ���ѯ����</label> 
				<td><SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <option selected value="all">��ʾȫ��</option>
                   <OPTION value="registerLevel_id">������</OPTION> 
                   <OPTION value="registerLevel_name">��������</OPTION>
                   <OPTION value="registerLevel_zjm">����������</OPTION> 
                   </SELECT>
                </td>
				<label for="zjm">�����ѯ����</label>
				<input type="text" name="queryData" id="queryData" class="text ui-widget-content ui-corner-all" /> 
			</fieldset>
			<div id="queryResult"></div>
    </form>       
	</div>
	
	<!--  ��ӶԻ��� -->
	<div id="dialog-form1" title="��д��Ϣ">
		<p class="validateTips">������Ŀ������д</p>
		<form id="form1" action="<%=contextPath%>/RegisterLevel/add.action"
			method="post">
			<fieldset>
				<input type="hidden" name="registerLevel_id" />
				<label for="name">�Һż�������</label> 
				<input type="text" name="registerLevel_name" id="registerLevel_name" class="text ui-widget-content ui-corner-all" /> 
				<label for="zjm">�Һż���������</label>
				<input type="text" name="registerLevel_zjm" id="registerLevel_zjm" value="" class="text ui-widget-content ui-corner-all" /> 
				<label for="zjm">�Һŷ�</label> 
				<input type="text" name="registerLevel_fee" id="registerLevel_fee" value="" class="text ui-widget-content ui-corner-all" /> 
				<label for="zjm">ƴ����</label>
				<input type="text" name="registerLevel_py" id="registerLevel_py" value="" class="text ui-widget-content ui-corner-all" /> 
				<label	for="password">�Һż������</label>
				<input type="text" name="registerLevel_code" id="registerLevel_code" value="" class="text ui-widget-content ui-corner-all" />
			</fieldset>
		</form>
	</div>


</body>

</html>