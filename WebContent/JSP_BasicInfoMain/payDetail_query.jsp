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
		var price=$( "#payDetail_price" );
		fr = $("#change_pay");
		tips = $(".validateTips");
		
		   
		   
		function add(form) {
			if ($("#payDetail_number").val() == "") {
				updateTips("收费编号不能为空！");
				return false;
			}
			if ($("#payDetail_name").val() == "") {
				updateTips("收费名称不能为！");
				return false;
			}
			if ($("#payDetail_property").val() == "") {
				updateTips("收费性质不能为空！");
				return false;
			}
			if ($("#payDetail_object").val() == "") {
				updateTips("收费对象不能为空！");
				return false;
			}
			if ($("#payDetail_standard").val() == "") {
				updateTips("收费标准不能为空！");
				return false;
			}
			if ($("#payDetail_price").val() == "") {
				updateTips("收费价格不能为空！");
				return false;

			}
			if ($("#payDetail_zjm").val() == "") {
				updateTips("助记码不能为空！");
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
				"确认修改" : function() {
					var bValid = true;
					/*allFields.removeClass( "ui-state-error" );*/
					
					bValid = add(fr);
					bValid = bValid && checkRegexp(price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数" );
					if (bValid) {
						$("#change_pay").submit();
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
<div id="dialog-form" title="修改收费明细项目">
		<p class="validateTips">注意：除备注为非必须其余各项均需添加</p>
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
	<h4 align="left">收费明细项目查询</h4>
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
				<td>状态</td>
					<td>收费编号：</td>
					<td>收费名称：</td>
					<td>收费性质：</td>
					<td>收费对象：</td>
					<td>收费标准：</td>
					<td>收费价格：</td>
					<td>助记码：</td>
					<td>备注信息：</td>
					<td>操作：</td>
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
							<td><button name="change">修改</button></td>
				</tr>
			</table>
			<input id="deleteSubmit" type="submit" value="删除选择项" />
			</form>
		</c:otherwise>
	</c:choose>
	<p align="center">
		<a href="<%=contextPath %>/JSP_BasicInfoMain/show">返回</a>
	</p>

</body>
</html>