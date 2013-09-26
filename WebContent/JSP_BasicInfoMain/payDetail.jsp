<!-- /*
 *收费项目详情JSP文件
 *对应数据表组合划价项目(JC_SF_PayDetail)
 *编辑者：林世鹏
 *时间：2013.8.8
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
	
	   //定义一个变量用于存放XMLHttpRequest对象
	   var xmlHttp;
	   //定义修改时初始状态下的编号与名称
	   var old_number,old_name;
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
	   //判断添加编号时编号是否重复
	   function ajaxValidateByNumber()
	   {

		   var payDetail_number=document.getElementById("payDetail_number1").value;
		   createXMLHttpRequest();
		   xmlHttp.onreadystatechange=processAjaxValidateByNumber;
		   xmlHttp.open("GET", "<%=contextPath %>/JSP_BasicInfoMain/JudgePayDetailByNumber?number="+payDetail_number);
		   xmlHttp.send(null);
	   }
	 //判断添加名称时名称是否重复
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
	   //判断修改编号时编号是否重复
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
	 //判断修改名称时名称是否重复
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
	 //添加信息名称时经判断是否重复并打印信息
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
	   //添加信息编号时经判断是否重复并打印信息
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
		 //修改信息名称时经判断是否重复并打印信息
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
	   //修改信息编号时经判断是否重复并打印信息
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
		//判断修改表时是否符合规范
		function change(form) {
			if ($("#payDetail_number").val() == "") {
				updateTips("收费编号不能为空！",0);
				return false;
			}
			if ($("#payDetail_name").val() == "") {
				updateTips("收费名称不能为！",0);
				return false;
			}
			if ($("#payDetail_property").val() == "") {
				updateTips("收费性质不能为空！",0);
				return false;
			}
			if ($("#payDetail_object").val() == "") {
				updateTips("收费对象不能为空！",0);
				return false;
			}
			if ($("#payDetail_standard").val() == "") {
				updateTips("收费标准不能为空！",0);
				return false;
			}
			if ($("#payDetail_price").val() == "") {
				updateTips("收费价格不能为空！",0);
				return false;

			}
			if ($("#payDetail_zjm").val() == "") {
				updateTips("助记码不能为空！",0);
				return false;
			}
			if ($.trim($("#ChangeNumber").html()) != "") {
				updateTips("不符合规格，请重新输入！",0);
				return false;
			}
			if ($.trim($("#ChangeName").html()) != "") {
				updateTips("不符合规格，请重新输入！",0);
				return false;
			}
			return true;
		}
		//判断添加表时是否符合规范
		function add(form) {
			if ($("#payDetail_number1").val() == "") {
				updateTips("收费编号不能为空！",1);
				return false;
			}
			if ($("#payDetail_name1").val() == "") {
				updateTips("收费名称不能为！",1);
				return false;
			}
			if ($("#payDetail_property1").val() == "") {
				updateTips("收费性质不能为空！",1);
				return false;
			}
			if ($("#payDetail_object1").val() == "") {
				updateTips("收费对象不能为空！",1);
				return false;
			}
			if ($("#payDetail_standard1").val() == "") {
				updateTips("收费标准不能为空！",1);
				return false;
			}
			if ($("#payDetail_price1").val() == "") {
				updateTips("收费价格不能为空！",1);
				return false;

			}
			if ($("#payDetail_zjm1").val() == "") {
				updateTips("助记码不能为空！",1);
				return false;
			}
			if ($.trim($("#number").html()) != "") {
				updateTips("不符合规格，请重新输入！",1);
				return false;
			}
			if ($.trim($("#name").html()) != "") {
				updateTips("不符合规格，请重新输入！",1);
				return false;
			}
			return true;
		}
		//打印错误信息
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
		 //判断是否符合输入格式
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
				"确认修改" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/

					bValid = change(fr);
					bValid = bValid && checkRegexp( ChangePrice, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数",0 );
					if (bValid) {
						$("#change_pay").submit();
						$(this).dialog("close");
					}
				},
				"取消" : function() {
					$(this).dialog("close");
				}
			},

		});

		$("#deleteSubmit").button().click(function() {

		});
		
		$("#addSubmit").button().click(function() {
				var Valid = true;
				Valid = add(fb);
				Valid = Valid && checkRegexp( price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数" ,1);
				if (Valid) {
					$("#add_pay").submit();
				}

		});
		$("#query").button().click(function() {

		});
		$("[name='change']").button().click(function() {
			//限制其实命令，只执行本操作
			event.preventDefault();
			//获取父类的前节点
			var temp = $(this).parent().prev();
			//将前节点的值赋给指定ID的value
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
			//给初始名称赋值
			old_name=$("#payDetail_name").val();
			
			temp = $(temp).prev();
			$("#payDetail_number").val($(temp).text());
			//给初始编号赋值
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

	<div id="dialog-form" title="修改收费明细项目">
		<p class="ChangeValidateTips">注意：除备注为非必须其余各项均需添加</p>
			<div id="ChangeNumber"></div>
			<div id="ChangeName"></div>
		<s:form id="change_pay" action="update" method="post">
			<fieldset>
				<input type="hidden" name="payDetail.payDetail_id" id="payDetail_id" />
				<label for="name">收费编号</label> <input type="text"
					name="payDetail.payDetail_number" id="payDetail_number"
					class="text ui-widget-content ui-corner-all"  onblur="ajaxValidateChangeByNumber()"/> 
					<label for="name">收费名称</label>
				<input type="text" name="payDetail.payDetail_name"
					id="payDetail_name" class="text ui-widget-content ui-corner-all"  onblur="ajaxValidateChangeByName()"/>
				<label for="name">收费性质</label> <input type="text"
					name="payDetail.payDetail_property" id="payDetail_property"
					class="text ui-widget-content ui-corner-all" /> 
					<label for="name">收费对象</label>
				<input type="text" name="payDetail.payDetail_object"
					id="payDetail_object" class="text ui-widget-content ui-corner-all" />
				<label for="name">收费标准</label> <input type="text"
					name="payDetail.payDetail_standard" id="payDetail_standard"
					class="text ui-widget-content ui-corner-all" /> <label for="name">收费价格</label>
				<input type="text" name="payDetail.payDetail_price"
					id="payDetail_price" class="text ui-widget-content ui-corner-all" />
				<label for="name">助记码&nbsp;&nbsp;&nbsp;</label> <input type="text"
					name="payDetail.payDetail_zjm" id="payDetail_zjm"
					class="text ui-widget-content ui-corner-all" /> <br> <label
					for="name">备注信息:</label><br>
				<textarea name="payDetail.payDetail_remark" id="payDetail_remark"
					class="text ui-widget-content ui-corner-all" style="width: 310px;"></textarea>


			</fieldset>
		</s:form>
	</div>

	<h4>欢迎来到收费明细项目</h4>
			<div id="number"></div>
	<div id="name"></div>
	<p class="AddValidateTips">注意：除备注为非必须其余各项均需添加</p>

	<div>

		<s:form id="add_pay" method="post" action="add">
			<table>

				<tr>
					<%-- 		<tr>
			<td><s:textfield name="payDetail.payDetail_number" label="收费编号"
				cssStyle="text ui-widget-content ui-corner-all"></s:textfield>
			<s:textfield name="payDetail.payDetail_name" label="收费名称"></s:textfield>
			</td>
			
			<td><s:textfield name="payDetail.payDetail_property" label="收费性质"></s:textfield>
			<s:textfield name="payDetail.payDetail_object" label="收费对象"></s:textfield>
			</td><td>
			<s:textfield name="payDetail.payDetail_standard" label="收费标准"></s:textfield>
			<s:textfield name="payDetail.payDetail_price" label="收费价格"></s:textfield>
			<s:textfield name="payDetail.payDetail_zjm" label="助记码"></s:textfield>
			<s:textfield name="payDetail.payDetail_remark" label="备注信息"></s:textfield>
			</td></tr> --%>
					<td><label for="name">收费编号</label></td>
					<td><input type="text" name="payDetail.payDetail_number"
						id="payDetail_number1"
						class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByNumber()"/></td>
					<td><label for="name">收费名称</label></td>
					<td><input type="text" name="payDetail.payDetail_name"
						id="payDetail_name1" class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByName()"/></td>
					<td><label for="name">收费性质</label></td>
					<td><input type="text" name="payDetail.payDetail_property"
						id="payDetail_property1" class="text ui-widget-content ui-corner-all" /></td>
				</tr>
				<tr>
					<td><label for="name">收费对象</label></td>
					<td><input type="text" name="payDetail.payDetail_object"
						id="payDetail_object1" class="text ui-widget-content ui-corner-all" /></td>
					<td><label for="name">收费标准</label></td>
					<td><input type="text" name="payDetail.payDetail_standard"
						id="payDetail_standard1" class="text ui-widget-content ui-corner-all" /></td>
					<td><label for="name">收费价格</label></td>
					<td><input type="text" name="payDetail.payDetail_price"
						id="payDetail_price1" class="text ui-widget-content ui-corner-all" /></td>
				</tr>
				<tr>
					<td><label for="name">助记码&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="text" name="payDetail.payDetail_zjm"
						id="payDetail_zjm1" class="text ui-widget-content ui-corner-all" /></td>

					<td><label for="name">备注信息:</label></td>

					<td colspan="3"><textarea name="payDetail.payDetail_remark"
							class="text ui-widget-content ui-corner-all"
							style="width: 310px;"></textarea> 
							<input id="addSubmit" type="button" value="确认添加"></td>
						
				</tr>
			</table>
		</s:form>

	</div>

	<div>
		<form action="QueryPayDetail" method="post">
			按收费编号进行查询：<input type="text" name="QueryId"
				class="text ui-widget-content ui-corner-all" /> <input id="query"
				type="submit" value="查询">
		</form>

	</div>
	<br>
	<form action="delete" method="post">
		<div>
			<c:choose>
				<c:when test="${empty pageModel.list}">
					<td align="center">
						<p style="padding-left: 300px">
							<font color="red">没有收费项目信息!</font>
						</p>
					</td>
				</c:when>
				<c:otherwise>
					<table border=1 align=center width="100%" align="center"
						cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>选择</td>
								<td>收费编号</td>
								<td>收费名称</td>
								<td>收费性质</td>
								<td>收费对象</td>
								<td>收费标准</td>
								<td>收费价格</td>
								<td>助记码</td>
								<td>备注</td>
								<td>操作</td>
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
									<td><button name="change">修改</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input id="deleteSubmit" type="submit" value="删除选择项" /></form>
	<table border="0" width="750" align="center">
		<tr>

			<td align="right">总记录数：${pageModel.totalRecords}
				当前${pageModel.currPage}/${pageModel.totalPage}页 <a
				href="show?currentPage=${pageModel.previousPage}"> 上一页 </a> <a
				href="show?currentPage=${pageModel.nextPage}"> 下一页 </a> <select
				id="currentPage" onchange="changePage()">
					<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
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
		</c:otherwise>
		</c:choose>
	</table>

	</div>
</body>
</html>