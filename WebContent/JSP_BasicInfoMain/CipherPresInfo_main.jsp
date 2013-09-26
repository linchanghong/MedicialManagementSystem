<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%String contextPath = request.getContextPath(); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>处方协定信息主页</title>
<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript">
$(function() {
	var //price=$( "#payDetail_price" );
	fr = $("#change_pay");
	//tips = $(".validateTips");
	
	   
	   
	function add(form) {
		if ($("#cipherPres_name").val() == "") {
			updateTips("协定处方名称不能为空！");
			return false;
		}
		if ($("#cipherPres_number").val() == "") {
			updateTips("协定处方编号不能为！");
			return false;
		}
		if ($("#cipherPres_drugsof").val() == "") {
			updateTips("药物组成不能为空！");
			return false;
		}
		if ($("#cipherPres_indication").val() == "") {
			updateTips("适应症不能为空！");
			return false;
		}
		if ($("#cipherPres_efficacy").val() == "") {
			updateTips("功效主治不能为空！");
			return false;
		}
		if ($("#cipherPres_taboo").val() == "") {
			updateTips("禁忌不能为空！");
			return false;

		}
		return true;
	}
      /*function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}*/

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
	   /* function checkRegexp( o, regexp, n ) {
	 if ( !( regexp.test( o.val() ) ) ) {
	 o.addClass( "ui-state-error" );
	 updateTips( n );
	 return false;
	 } else {
	 return true;
	 }
	 } */

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
				//bValid = bValid && checkRegexp(price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "价格只能输入非负数" );
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
		$("#cipherPres_taboo").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#cipherPres_efficacy").val($.trim((temp).text()));
		temp = $(temp).prev();
		$("#cipherPres_indication").val($.trim((temp).text()));
		temp = $(temp).prev();
		$("#cipherPres_drugsof").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#cipherPres_number").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#cipherPres_name").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#cipherPres_id").val($.trim((temp).text()));
		//给初始名称赋值*/
		
		$("#dialog-form").dialog("open");
	});
	/*$("[name='change']").button().click(function() {
		//限制其实命令，只执行本操作
		event.preventDefault();
		//获取父类的前节点
		var temp = $(this).parent().prev();
		//将前节点的值赋给指定ID的value
		$("#cipherPres_taboo").val($(temp).text());
		
		temp = $(temp).prev();
		$("#cipherPres_efficacy").val($(temp).text());
		temp = $(temp).prev();
		$("#cipherPres_indication").val($(temp).text());
		temp = $(temp).prev();
		$("#cipherPres_drugsof").val($(temp).text());
		
		temp = $(temp).prev();
		$("#cipherPres_number").val($(temp).text());
		
		temp = $(temp).prev();
		$("#cipherPres_name").val($(temp).text());
		temp=$(temp).prev();
		$("#cipherPres_id").val($(temp).text);
		temp = $(temp).prev();
		$("#cipherPres_id").val($.trim($(temp).text()));
		
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
	});*/
});
</script>

</head>
<body>

     <div >
       <input type="button" value=""  onclick="window.location.href='<%=contextPath %>/JSP_BasicInfoMain/CipherPresInfo_save.jsp';"
                               style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 30px">
        <form action="<%=contextPath %>/CiphPres/conditionQuery.action" method="post">
         <fieldset>
        <h4>查询或删除条件</h4>
        <!-- <p style="padding-left:650px"><input type="button" id="new" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 23px"></p> -->
         
           <table style="padding-left:100px" >
           
             <tr>
               <td>选择条件：</td>
               <td><SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <OPTION selected value="cipherPres_id">编码</OPTION> 
                   <OPTION value="cipherPres_name">处方名称</OPTION>
                   <OPTION value="cipherPres_number">处方编号</OPTION> 
                   </SELECT>
                   </td>
             </tr>
             <tr>
               <td>输入相关数据：</td>
               <td><input type="text" name="queryData"></td>
               <td><input type="submit" value="" id="query" style="background-image:url(../image/CRUD_image/query1.png);width: 100px; height: 30px"></td>
             </tr>
             </table>
             
             <tr><td><div   >
             <c:choose>
                 <c:when test="${empty list }">
                   
                         
                              <p align=center><font color="red">没有相关信息!</font></p>
                       
                 </c:when>
                 <c:otherwise>
                 <table align="center" border="1" cellspacing="0" width="800">
                    <tr align=center style="background:#CCCCCC">
                       <td width="" align="center">
                                                                        处方顺序号
                       </td>
                       <td width="" align="center">
                                                                          处方名称
                       </td>
                       <td width="" align="center">
                                                                           处方编号
                       </td>
                       <td width="" align="center">
                                                                           药物组成
                       </td>
                       <td width="" align="center">
                                                                            适应症
                       </td>
                       <td width="" align="center">
                                                                             功效
                       </td>
                       <td width="" align="center">
                                                                             主治
                       </td>
                       <td>修改</td>
                       <td>删除</td>
                    </tr>
                   <c:forEach items="${list}" var="l">
                    <tr>
             <td width="" align="center">
                 ${l.cipherPres_id}
             </td>
             <td width="" align="center"> 
                 ${l.cipherPres_name}
             </td>
             <td width="" align="center"> 
                 ${l.cipherPres_number}
             </td>
             <td width="" align="center"> 
                 ${l.cipherPres_drugsof}
             </td>
             <td>
                 ${l.cipherPres_indication}
             </td>
             <td>
                 ${l.cipherPres_efficacy}
             </td>
             <td>
                 ${l.cipherPres_taboo}
             </td>
             <td>
                <input type="button" value="" name="change"  
                               style="background-image:url(../image/CRUD_image/modify1.png);width: 80px; height: 28px">
             </td>
             <td>
                <input type="button" value=""  onclick="window.location.href='<%=contextPath %>/CiphPres/delete.action?cipherPres_id=${m.cipherPres_id}';"
                               style="background-image:url(../image/CRUD_image/delete.png);width: 80px; height: 25px">
             </td>
             
         </tr>
                 </c:forEach>
                 </table>
                 </c:otherwise>
             </c:choose>
             </div></td></tr>
           
          </fieldset>
        </form>
      </div>
      <div id="dialog-form" title="修改协定处方信息">
         <p>注意：修改时若有值为空将不能进行保存</p>
   <form action="<%=contextPath %>/CiphPres/save.action" id="change_pay" method="post">
      <fieldset>
         <table>
           <!--  <tr><td>
             <input type="hidden" name="cipherPres.cipherPres_id" id="cipherPres_id" />
           <td></tr>-->
           <tr><td>
             <input type="hidden" name="cipherPres.cipherPres_id" id="cipherPres_id" />
           </td>
           </tr>
           <tr>
             <td>
                                           处方名称:&nbsp;<input type="text"
					name="cipherPres.cipherPres_name" id="cipherPres_name"
					class="text ui-widget-content ui-corner-all" /> 
             </td>
             
             <td>
                &nbsp;&nbsp;处方编号:&nbsp;<input type="text" name="cipherPres.cipherPres_number"
					id="cipherPres_number" class="text ui-widget-content ui-corner-all" />
             </td>
             
             <td>
           &nbsp;&nbsp;禁忌:<input type="text" name="cipherPres.cipherPres_taboo" size=""
					id="cipherPres_taboo" class="text ui-widget-content ui-corner-all" />
             </td>
           </tr>
           <tr>
             <td colspan="3">药物组成:&nbsp;<textarea
					name="cipherPres.cipherPres_drugsof"  id="cipherPres_drugsof"
					class="text ui-widget-content ui-corner-all" style="width: 350px;" ></textarea> </td>
           </tr>
           <tr>
             <td colspan="3">功效主治:&nbsp;<textarea
					name="cipherPres.cipherPres_efficacy"  id="cipherPres_efficacy"
					class="text ui-widget-content ui-corner-all" style="width: 350px;"></textarea></td>
           </tr>
           <tr>
             <td colspan="3">适应症:&nbsp;&nbsp;<textarea name="cipherPres.cipherPres_indication" id="cipherPres_indication"
					class="text ui-widget-content ui-corner-all" style="width: 350px;"></textarea>
					
		    &nbsp;&nbsp;&nbsp;<!-- <input type="submit" value="" id="save" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"> -->
           </td></tr>
         </table>
				
			</fieldset>
   </form>
</div>
          <c:choose>
                 <c:when test="${empty pageModel.list}">
								
			 	<p align="center"><font color="red">没有处方协定信息!</font></p>
								
				</c:when>
				<c:otherwise>
				<div id="header"><h1>
                                                处方信息协定表
                 </h1></div>
                 <div class="content">  
	<table align="center" border="1" cellspacing="0" width="800">
      
      <tr style="background:#CCCCCC">
         <td width="" align="center">
                                处方顺序号
         </td>
         <td width="" align="center">
                                 处方名称
         </td>
         <td width="" align="center">
                                 处方编号
         </td>
         <td width="" align="center">
                                  药物组成
         </td>
         <td>
                                  适应症
         </td>
         <td>
                                   功效主治
         </td>
         <td>
                                       禁忌                   
         </td>
         <td>
                                        删除
         </td>
      </tr>
     <c:forEach items="${pageModel.list}" var="m">
         <tr>
             <td width="" align="center">
                 ${m.cipherPres_id}
             </td>
             <td width="" align="center"> 
                 ${m.cipherPres_name}
             </td>
             <td width="" align="center"> 
                 ${m.cipherPres_number}
             </td>
             <td width="" align="center"> 
                 ${m.cipherPres_drugsof}
             </td>
             <td>
                 ${m.cipherPres_indication}
             </td>
             <td>
                 ${m.cipherPres_efficacy}
             </td>
             <td>
                 ${m.cipherPres_taboo}
             </td>
             
             <td>
                <input type="button" value=""  onclick="window.location.href='<%=contextPath %>/CiphPres/delete.action?cipherPres_id=${m.cipherPres_id}';"
                               style="background-image:url(../image/CRUD_image/delete.png);width: 80px; height: 28px">
             </td>
             
         </tr>
     </c:forEach> 
     </table> 
     </div>
      </c:otherwise>
</c:choose>  
   
  
   
   <table border="0" width="750" align="center">
	   <tr>
		  <td align="right">
		       总记录数：${pageModel.totalRecords}
		        当前${pageModel.currPage}/${pageModel.totalPage}页
		   <a href="<%=contextPath %>/CiphPres/queryAll.action?currPage=${pageModel.previousPage}">上一页</a>
		   <a href="<%=contextPath %>/CiphPres/queryAll.action?currPage=${pageModel.nextPage}">下一页</a>
		   <select id="currpage" onchange="changePage()">
			   <c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			   <c:choose>
			      <c:when test="${pageModel.currPage ne vs.count}">
						<option value="${vs.count}">
							第${vs.count}页
					    </option>
				  </c:when>
			      <c:otherwise>
			            <option value="${vs.count}" selected="selected">
							第${vs.count}页
						</option>
				  </c:otherwise>
			   </c:choose>
			   </c:forEach>
		  </select>
		</td>
	</tr>
</table>
<script type="text/javascript">
	
	
	function changePage() {
		var currPage = document.getElementById("currpage").value;
		window.self.location = "<%=contextPath %>/DoctorInfo/add.action?currPage="
				+ currPage;
	}
	
</script>
</body>
</html>