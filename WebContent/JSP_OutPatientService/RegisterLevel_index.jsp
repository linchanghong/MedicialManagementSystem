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
			<h1 align=center>挂号级别信息维护</h1>
		</td>
	</tr>
</table>

<body>
	<hr />
	<!--  显示信息表 -->
	<div id="users-contain" class="ui-widget">
		<h2>挂号级别信息</h2>
		<table id="users" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header ">
					<th>选中进行操作</th>
					<th>挂号级别编号</th>
					<th>挂号级别名称</th>
					<th>挂号级别助记码</th>
					<th>挂号费</th>
					<th>拼音码</th>
					<th>挂号级别编码</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<!--           //显示数据 -->
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
					<!-- //显示页数 -->
					<table border="0" width="750" align="center">
						<tr>
							<td align="right">总记录数：${pageModel.totalRecords}
								当前${pageModel.currPage}/${pageModel.totalPage}页 <a
								href="<%=contextPath %>/RegisterLevel/queryAll.action?currPage=${pageModel.previousPage}">上一页</a>
								<a
								href="<%=contextPath %>/RegisterLevel/queryAll.action?currPage=${pageModel.nextPage}">下一页</a>
								<select id="currpage" onchange="changePage()">
									<c:forEach begin="1" end="${pageModel.totalPage}"
										varStatus="vs">
										<c:choose>
											<c:when test="${pageModel.currPage ne vs.count}">
												<option value="${vs.count}">第${vs.count}页</option>
											</c:when>
											<c:otherwise>
												<option value="${vs.count}" selected="selected">
													第${vs.count}页</option>
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
	<button id="create-user">添加</button>
	<button id="modify-user">修改</button>
	<button id="delete-user">删除</button>
	<button id="query-user">查询</button>
	</div>


	<!-- //实现增加与修改功能 -->
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
		$(function() { //录入信息
			var name = $("#registerLevel_name"), zjm = $("#registerLevel_zjm"), fee = $("#registerLevel_fee"), py = $("#registerLevel_py"), code = $("#registerLevel_code"), allFields = $(
					[]).add(name).add(zjm).add(fee).add(py).add(code), tips = $(".validateTips");

			function updateTips(t) {
				tips.text(t).addClass("ui-state-highlight");
				setTimeout(function() {
					tips.removeClass("ui-state-highlight", 1500);
				}, 500);
			}

			function checkLength(o, n, min, max) { //验证输入字数
				if (o.val().length > max || o.val().length <= min) {
					o.addClass("ui-state-error");
					updateTips(n + "要不为空");
					return false;
				} else {
					return true;
				}
			}
             //提示框
			$( "#dialog-pop" ).dialog({
				autoOpen : false});
			
			
			//验证为空
			$("#dialog-form1").dialog({
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					"确认" : function() {
						var bValid = true;
						allFields.removeClass("ui-state-error");

						bValid = bValid && checkLength(name, "挂号级别名称", 0, 80);
						bValid = bValid && checkLength(zjm, "挂号级别助记码", 0, 80);
						bValid = bValid && checkLength(fee, "挂号费", 0, 80);
						bValid = bValid && checkLength(py, "拼音码", 0, 80);
						bValid = bValid && checkLength(code, "挂号级别编码", 0, 80);

						if (bValid) {
							$("#form1").submit();
							$(this).dialog("close");
						}
					},
					取消 : function() {
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
					"确认" : function() {
						//alert($("input[name='queryData']").val());
						$("#form2").submit();
					},
					取消 : function() {
						$(this).dialog("close");
					}
				},
				close : function() {
				
				}
			});
			
           //增加  删除 修改按钮的操作
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
	
<!-- 	提示框 -->
	<div id="dialog-pop" title="提示信息">
		<p>请选择一个进行操作</p>
	</div>
	
	
	<div id="dialog-form2" title="">
	<form id="form2" action="<%=contextPath%>/RegisterLevel/query.action"
			method="post">      
               <fieldset>
				<label for="name">选择查询条件</label> 
				<td><SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <option selected value="all">显示全部</option>
                   <OPTION value="registerLevel_id">级别编号</OPTION> 
                   <OPTION value="registerLevel_name">级别名称</OPTION>
                   <OPTION value="registerLevel_zjm">级别助记码</OPTION> 
                   </SELECT>
                </td>
				<label for="zjm">输入查询数据</label>
				<input type="text" name="queryData" id="queryData" class="text ui-widget-content ui-corner-all" /> 
			</fieldset>
			<div id="queryResult"></div>
    </form>       
	</div>
	
	<!--  添加对话框 -->
	<div id="dialog-form1" title="填写信息">
		<p class="validateTips">所有项目必须填写</p>
		<form id="form1" action="<%=contextPath%>/RegisterLevel/add.action"
			method="post">
			<fieldset>
				<input type="hidden" name="registerLevel_id" />
				<label for="name">挂号级别名称</label> 
				<input type="text" name="registerLevel_name" id="registerLevel_name" class="text ui-widget-content ui-corner-all" /> 
				<label for="zjm">挂号级别助记码</label>
				<input type="text" name="registerLevel_zjm" id="registerLevel_zjm" value="" class="text ui-widget-content ui-corner-all" /> 
				<label for="zjm">挂号费</label> 
				<input type="text" name="registerLevel_fee" id="registerLevel_fee" value="" class="text ui-widget-content ui-corner-all" /> 
				<label for="zjm">拼音码</label>
				<input type="text" name="registerLevel_py" id="registerLevel_py" value="" class="text ui-widget-content ui-corner-all" /> 
				<label	for="password">挂号级别编码</label>
				<input type="text" name="registerLevel_code" id="registerLevel_code" value="" class="text ui-widget-content ui-corner-all" />
			</fieldset>
		</form>
	</div>


</body>

</html>