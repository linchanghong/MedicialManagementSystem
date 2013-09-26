<!-- /*
 *组合划价详情JSP文件
 *对应数据表组合划价项目(JC_SF_CombinationAccounting)
 *编辑者：林世鹏
 *时间：2013.8.13
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
	 //定义一个变量用于存放XMLHttpRequest对象
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
	   var old_number, old_name;
	   
	   /* 判断修改编号时编号是否重复 */
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
	   /* 判断修改编号时名称是否重复 */
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
	   /* 判断添加编号时编号是否重复 */
	   function ajaxValidateByNumber()
	   {
		   var combinationAccounting_number=document.getElementById("combinationAccounting_number1").value;
		   createXMLHttpRequest();
		   xmlHttp.onreadystatechange=processAjaxValidateByNumber;
		   xmlHttp.open("GET", "<%=contextPath%>/JSP_BasicInfoMain/JudgeCAccountingByNumber?number="+combinationAccounting_number);
		   xmlHttp.send(null);
	   }
	   /* 判断添加名称时名称是否重复 */
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
	   /* 添加名称时经判断之后打印信息名 */
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
	   /* 添加编号时经判断之后打印信息名 */
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
	   /* 修改名称时经判断之后打印信息 */
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
	   /* 修改编号时经判断之后打印信息 */
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
				updateTips("组合划价编号不能为空！",0);
				return false;
			}
			if ($("#combinationAccounting_name").val() == "") {
				updateTips("组合划价名称不能为空！",0);
				return false;
			}
			if ($("#combinationAccounting_price").val() == "") {
				updateTips("组合划价价格不能为空！",0);
				return false;

			}
			if ($("#combinationAccountingl_zjm").val() == "") {
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
		function add(form) {
			if ($("#combinationAccounting_number1").val() == "") {
				updateTips("组合划价编号不能为空！",1);
				return false;
			}
			if ($("#combinationAccounting_name1").val() == "") {
				updateTips("组合划价名称不能为空！",1);
				return false;
			}
			if ($("#combinationAccounting_price1").val() == "") {
				updateTips("组合划价价格不能为空！",1);
				return false;

			}
			if ($("#combinationAccountingl_zjm1").val() == "") {
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
				"确认修改" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/

					bValid = change(fr);

					bValid = bValid && checkRegexp( Cprice, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数" ,0);
					if (bValid) {
						$("#change_combinationAccounting").submit();
						$(this).dialog("close");
					}
				},
				"取消" : function() {
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
			Valid = Valid && checkRegexp( price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数" ,1);
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

	<div id="dialog-form" title="修改组合划价项目">
		<p class="ChangeValidateTips">注意：除备注为非必须其余各项均需添加</p>
			<div id="ChangeNumber"></div>
			<div id="ChangeName"></div>
		<s:form id="change_combinationAccounting" action="updateCAccounting" method="post">
			<fieldset>
				<input type="hidden" name="combinationAccounting.combinationAccounting_id" id="combinationAccounting_id" />
				<label for="name">收费编号: &nbsp;&nbsp; &nbsp;  </label><input type="text"
					name="combinationAccounting.combinationAccounting_number" id="combinationAccounting_number"
					class="text ui-widget-content ui-corner-all" onblur="ajaxValidateChangeByNumber()" /> 
					<label for="name">组合划价名称:</label>
				<input type="text" name="combinationAccounting.pcombinationAccountingayDetail_name"
					id="combinationAccounting_name" class="text ui-widget-content ui-corner-all" onblur="ajaxValidateChangeByName()"  />
				<label for="name">组合划价价格:</label>
				<input type="text" name="combinationAccounting.combinationAccounting_price"
					id="combinationAccounting_price" class="text ui-widget-content ui-corner-all" />
				<label for="name">助记码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</label> <input type="text"
					name="combinationAccounting.combinationAccounting_zjm" id="combinationAccounting_zjm"
					class="text ui-widget-content ui-corner-all" /> 


			</fieldset>
		</s:form>
	</div>

	<h4>欢迎来到组合划价项目</h4>
	<div id="number"></div>
	<div id="name"></div>
	<p class="AddValidateTips">注意：除备注为非必须其余各项均需添加</p>
	<div>

		<s:form id="add_combinationAccounting" method="post" action="addCAccounting">


			<table>
				<tr>
					<td><label for="name">收费编号</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_number"
						id="combinationAccounting_number1"
						class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByNumber()"/></td>
					<td><label for="name">组合划名称</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_name"
						id="combinationAccounting_name1" class="text ui-widget-content ui-corner-all" onblur="ajaxValidateByName()"/></td>
					<td><label for="name">组合划价价格</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_price"
						id="combinationAccounting_price1" class="text ui-widget-content ui-corner-all" /></td>
				</tr>
				<tr>
					<td><label for="name">助记码&nbsp;&nbsp;&nbsp;</label></td>
					<td><input type="text" name="combinationAccounting.combinationAccounting_zjm"
						id="combinationAccounting_zjm1" class="text ui-widget-content ui-corner-all" /></td>
					<td><input id="addSubmit" type="button" value="确认添加" />
					</td>

				</tr>
			</table>
		</s:form>

	</div>

	<div>
		<form action="QueryCAccounting" method="post">
			按组合划价编号进行查询：<input type="text" name="QueryId"
				class="text ui-widget-content ui-corner-all" /> <input id="query"
				type="submit" value="查询">
		</form>

	</div>
	<br>
	<form action="deleteCAccounting" method="post">
		<div>
			<c:choose>
				<c:when test="${empty pageModel.list}">
					<td align="center">
						<p style="padding-left: 300px">
							<font color="red">没有组合划价项目信息!</font>
						</p>
					</td>
				</c:when>
				<c:otherwise>
					<table border=1 align=center width="100%" align="center"
						cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>选择</td>
								<td>组合划价编号</td>
								<td>组合划价名称</td>
								<td>组合划价价格</td>
								<td>助记码</td>
								<td>操作</td>
							</tr>

							<c:forEach items="${pageModel.list}" var="m">
								<tr bgcolor="#f2f2f2">
									<td><input name="checkId" id="DataId" type="checkbox"
										value="${m.combinationAccounting_id}" /></td>
									<td>${m.combinationAccounting_number}</td>
									<td>${m.combinationAccounting_name}</td>
									<td>${m.combinationAccounting_price}</td>
									<td>${m.combinationAccounting_zjm}</td>
									<td><button name="change">修改</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input id="deleteSubmit" type="submit" value="删除选择项" />
	</form>
	<table border="0" width="750" align="center">
		<tr>

			<td align="right">总记录数：${pageModel.totalRecords}
				当前${pageModel.currPage}/${pageModel.totalPage}页 <a
				href="showCAccounting?currentPage=${pageModel.previousPage}"> 上一页 </a> <a
				href="showCAccounting?currentPage=${pageModel.nextPage}"> 下一页 </a> <select
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
<script type="text/javascript">
  
</script>
</body>
</html>