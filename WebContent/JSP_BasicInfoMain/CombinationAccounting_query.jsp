<!-- /*
 *收费项目详情JSP文件
 *对应数据表组合划价项目(JC_SF_PayDetail)
 *编辑者：林世鹏
 *时间：2013.8.8
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
		var Cprice=$("#combinationAccounting_price");
		fr = $("#change_combinationAccounting");
		tips = $(".validateTips");
		function change(form) {
			if ($("#combinationAccounting_number").val() == "") {
				updateTips("组合划价编号不能为空！");
				return false;
			}
			if ($("#combinationAccounting_name").val() == "") {
				updateTips("组合划价名称不能为空！");
				return false;
			}
			if ($("#combinationAccounting_price").val() == "") {
				updateTips("组合划价价格不能为空！");
				return false;

			}
			if ($("#combinationAccountingl_zjm").val() == "") {
				updateTips("助记码不能为空！");
				return false;
			}
			if ($.trim($("#ChangeNumber").html()) != "") {
				updateTips("不符合规格，请重新输入！");
				return false;
			}
			if ($.trim($("#ChangeName").html()) != "") {
				updateTips("不符合规格，请重新输入！");
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
				"确认修改" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/

					bValid = change(fr);
					bValid = bValid && checkRegexp( Cprice, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数" );
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
<div id="dialog-form" title="修改组合划价项目">
		<p class="validateTips">注意：除备注为非必须其余各项均需添加</p>
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
	<h4 align="left">组合划价项目查询</h4>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td align="center">
					<p style="padding-left: 300px">
						<font color="red">未查询到你想要的信息!</font>
					</p>
				</td>
			</tr>
		</c:when>
		<c:otherwise>
		<form action="delete" method="post">
			<table border=1 align=center width="750" align="center"
				cellpadding="0" cellspacing="0">
				<tr align=center>
								<td>选择</td>
								<td>组合划价编号</td>
								<td>组合划价名称</td>
								<td>组合划价价格</td>
								<td>助记码</td>
								<td>操作</td>
				</tr>
				<tr align=center>			
							<td><input name="checkId" id="DataId" type="checkbox"
										value="${list.combinationAccounting_id}" /></td>
									<td>${list.combinationAccounting_number}</td>
									<td>${list.combinationAccounting_name}</td>
									<td>${list.combinationAccounting_price}</td>
									<td>${list.combinationAccounting_zjm}</td>
									<td><button name="change">修改</button></td>
				</tr>
			</table>
			<input id="deleteSubmit" type="submit" value="删除选择项" />
			</form>
		</c:otherwise>
	</c:choose>
	<p align="center">
		<a href="<%=contextPath %>/JSP_BasicInfoMain/showCAccounting">返回</a>
	</p>

</body>
</html>