<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String contextPath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" language="javascript" src="../js/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" language="javascript" src="../js/jquery-ui-1.8.16.custom.min.js"></script>  
<script type="text/javascript" language="javascript" src="../js/jquery[1].ui.datepicker-zh-CN.js"></script>  
  
<!--css-->  
<link type="text/css" rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" /> 

<link rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" />
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" charset="utf-8">


$(function() {
	var //price=$( "#payDetail_price" );
	fr = $("#change_pay");
	//tips = $(".validateTips");
	
	   
	   
	function add(form) {
		if ($("#regiserPatient_name").val() == "") {
			updateTips("»¼ÕßÐÕÃû²»ÄÜÎª¿Õ£¡");
			return false;
		}
		if ($("#regiserPatient_sex").val() == "") {
			updateTips("»¼ÕßÐÔ±ð²»ÄÜÎª¿Õ£¡");
			return false;
		}
		if ($("#regiserPatient_birthday").val() == "") {
			updateTips("»¼Õß³öÉúÄêÔÂ²»ÄÜÎª¿Õ£¡");
			return false;
		}
		if ($("#regiserPatient_address").val() == "") {
			updateTips("»¼ÕßµØÖ·²»ÄÜÎª¿Õ£¡");
			return false;
		}
		if ($("#regiserPatient_phoneNo").val() == "") {
			updateTips("»¼ÕßÁªÏµµç»°²»ÄÜÎª¿Õ£¡");
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
		width : 510,
		modal : true,
		buttons : {
			"È·ÈÏÐÞ¸Ä" : function() {
				var bValid = true;
				
				/*allFields.removeClass( "ui-state-error" );*/
				
				bValid = add(fr);
				//bValid = bValid && checkRegexp(price, /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/, "¼Û¸ñÖ»ÄÜÊäÈë·Ç¸ºÊý" );
				if (bValid) {
					$("#change_pay").submit();
					$(this).dialog("close");
				}
			},
			"È¡Ïû" : function() {
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
		//ÏÞÖÆÆäÊµÃüÁî£¬Ö»Ö´ÐÐ±¾²Ù×÷
		event.preventDefault();
		//»ñÈ¡¸¸ÀàµÄÇ°½Úµã
		var temp = $(this).parent().prev();
		//½«Ç°½ÚµãµÄÖµ¸³¸øÖ¸¶¨IDµÄvalue
		$("#regiserPatient_phoneNo").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#regiserPatient_address").val($.trim((temp).text()));
		temp = $(temp).prev();
		$("#regiserPatient_birthday").val($.trim((temp).text()));
		temp = $(temp).prev();
		$("#regiserPatient_sex").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#regiserPatient_name").val($.trim((temp).text()));
		
		temp = $(temp).prev();
		$("#regiserPatient_caseNo").val($.trim((temp).text()));
		
	    temp = $(temp).prev();
		$("#regiserPatient_id").val($.trim((temp).text()));
		//¸ø³õÊ¼Ãû³Æ¸³Öµ*/
		
		$("#dialog-form").dialog("open");
	});

		$('#regiserPatient_birthday').datepicker({
				yearRange: '1900:2099', //È¡Öµ·¶Î§.
				showOn: 'both', //ÊäÈë¿òºÍÍ¼Æ¬°´Å¥¶¼¿ÉÒÔÊ¹ÓÃÈÕÀú¿Ø¼þ¡£
				buttonImage: '../image/CRUD_image/calendar.gif', //ÈÕÀú¿Ø¼þµÄ°´Å¥
				buttonImageOnly: true,
				showButtonPanel: true,
				dateFormate:'yy-MM-dd'
			});	
		$("#telephone").blur(function(){
			if(!(/(^(\d{3,4}-)?\d{7,8})$|(^1[3|4|5|8][0-9]{9})/.test($("#telephone").val()))){
				        alert("²»ÊÇÕýÈ·µÄ11Î»ÊÖ»úºÅ»òÕßÕýÈ·µÄ¹Ì»°");
				        $("#telephone").val("");
				    }
		});

});
</script>
</head>
<body>
  <p>
    <input type="button" onclick="window.location.href='<%=contextPath %>/RegPatient/getStringTime.action';" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 30px">
    <input type="button" onclick="window.location.href='<%=contextPath %>/JSP_OutPatientService/regPatient_query.jsp';" style="background-image:url(../image/CRUD_image/query1.png);width: 100px; height: 30px">
  </p>
  <div id="dialog-form" title="ÐÞ¸Ä²¡»¼ÐÅÏ¢">
         <p>×¢Òâ£ºÐÞ¸ÄÊ±ÈôÓÐÖµÎª¿Õ½«²»ÄÜ½øÐÐ±£´æ</p>
   <form action="<%=contextPath %>/RegPatient/save.action" id="change_pay" method="post">
      <fieldset>
         <table width="" >
     <tr>
        <td colspan="3">
          <input type="hidden" name="regPatient.regiserPatient_id" id="regiserPatient_id"/>
        </td>
     </tr>
     <tr>
        <td>
            &nbsp;&nbsp;²¡ÀúºÅ£º<input type="text" width="100" name="regPatient.regiserPatient_caseNo" id="regiserPatient_caseNo" class="text ui-widget-content ui-corner-all" readonly>
        </td>
        <td>
            &nbsp;&nbsp;&nbsp;&nbsp; ÐÕÃû£º <input type="text" name="regPatient.regiserPatient_name" id="regiserPatient_name" class="text ui-widget-content ui-corner-all">
        </td>
        <td>
            &nbsp;&nbsp;ÐÔ±ð:<SELECT style="WIDTH: 100px;height:20px" name="regPatient.regiserPatient_sex" id="regiserPatient_sex"> 
                   <OPTION >ÄÐ</OPTION> 
                   <OPTION >Å®</OPTION></SELECT>
            <!--  <input type="text" name="regPatient.regiserPatient_sex" id="regiserPatient_sex" class="text ui-widget-content ui-corner-all">-->
        </td>
     </tr>
     <tr>
        <td>
                                 ³öÉúÈÕÆÚ£º<input type="text" name="regPatient.regiserPatient_birthday" id="regiserPatient_birthday" class="text ui-widget-content ui-corner-all">
        
        </td>
        <td>
            &nbsp;ÁªÏµµç»°£º&nbsp;<input type="text" id="telephone" name="regPatient.regiserPatient_phoneNo" id="regiserPatient_phoneNo" class="text ui-widget-content ui-corner-all">
        </td>
     </tr>
     <tr>
        <td colspan="2">
            &nbsp;&nbsp;×¡&nbsp;&nbsp;Ö·:<input type="text" size="50" name="regPatient.regiserPatient_address" id="regiserPatient_address" class="text ui-widget-content ui-corner-all">
        </td>
        <!-- <td colspan="">
           <input type="submit" value="Ìá½»">
        <input type="button" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 30px" 
                              class="text ui-widget-content ui-corner-all" onclick="window.location.href='<%=contextPath %>/RegPatient/save.action';"></td> -->
     </tr>
     
  </table>
				
	</fieldset>
   </form>
</div>
  <c:choose>
                 <c:when test="${empty pageModel.list}">
								
			 	<p style="padding-left:300px" align="center"><font color="red">Ã»ÓÐ»¼ÕßÐÅÏ¢!</font></p>
								
				</c:when>
				<c:otherwise>
				<div id="header"><h1>
                                                È«²¿»¼ÕßÐÅÏ¢
                 </h1></div>
                 <div class="content">  
	<table align="center" border="1" cellspacing="0" width="800">
      
      <tr style="background:#CCCCCC">
         <td>
                                ×¢²áºÅ
         </td>
         <td width="" align="center">
                                ²¡ÀúºÅ
         </td>
         <td width="" align="center">
                                 »¼ÕßÐÕÃû
         </td>
         <td width="" align="center">
                                 ÐÔ±ð
         </td>
         <td width="" align="center">
                                  ³öÉúÄêÔÂ
         </td>
         <td>
                                  ×¡Ö·
         </td>
         <td>
                                   ÁªÏµµç»°
         </td>
         <td>
                                       ÐÞ¸Ä
         </td>
         <td>
                                        É¾³ý
         </td>
         
      </tr>
      <s:iterator value="pageModel.list" id="m">
         <tr>
             
             <td width="" align="center">
                <s:property value="#m.regiserPatient_id" /> 
             </td>
             <td width="" align="center"> 
                <s:property value="#m.regiserPatient_caseNo"/>
             </td>
             <td width="" align="center"> 
                <s:property value="#m.regiserPatient_name" />
             </td>
             <td width="" align="center"> 
                <s:property value="#m.regiserPatient_sex"/>
             </td> 
              <td>
               <s:date name="regiserPatient_birthday"  format="yyyy-MM-dd"/> 
             </td>
             <td>
               <s:property value="#m.regiserPatient_address"/>
             </td>
             <td>
                 <s:property value="#m.regiserPatient_phoneNo"/>
             </td>
             <td>
                <input type="button" value="ÐÞ  ¸Ä" name="change"  >
             </td>
             
             <td>
                <input type="button" value=""  onclick="window.location.href='<%=contextPath %>/RegPatient/delete.action?regiserPatient_id=${m.regiserPatient_id}';"
                               style="background-image:url(../image/CRUD_image/delete.png);width: 80px; height: 28px">
             </td>
             
         </tr>
      </s:iterator>
     <!--<c:forEach items="${pageModel.list}" var="m">
         <tr>
             <td width="" align="center">
                 ${m.regiserPatient_id}
             </td>
             <td width="" align="center">
                 ${m.regiserPatient_caseNo}
             </td>
             <td width="" align="center"> 
                 ${m.regiserPatient_name}
             </td>
             <td width="" align="center"> 
                 ${m.regiserPatient_sex}
             </td>
           <td width="" align="center"> 
                 ${m.regiserPatient_birthday}
             </td> 
             <td>
               <s:date  name="m.regiserPatient_birthday"  format="yyyy-MM-dd"/>
             </td>
             <td>
                 ${m.regiserPatient_address}
             </td>
             <td>
                 ${m.regiserPatient_phoneNo}
             </td>
             <td>
                <input type="button" value="ÐÞ  ¸Ä" name="change"  >
             </td>
             
             <td>
                <input type="button" value=""  onclick="window.location.href='<%=contextPath %>/RegPatient/delete.action?regiserPatient_id=${m.regiserPatient_id}';"
                               style="background-image:url(../image/CRUD_image/delete.png);width: 80px; height: 28px">
             </td>
             
         </tr>
     </c:forEach> -->
     </table> 
     </div>
      </c:otherwise>
</c:choose>  
   
  
   
   <table border="0" width="750" align="center">
	   <tr>
		  <td align="right">
		       ×Ü¼ÇÂ¼Êý£º${pageModel.totalRecords}
		        µ±Ç°${pageModel.currPage}/${pageModel.totalPage}Ò³
		   <a href="<%=contextPath %>/RegPatient/queryAll.action?currPage=${pageModel.previousPage}">ÉÏÒ»Ò³</a>
		   <a href="<%=contextPath %>/RegPatient/queryAll.action?currPage=${pageModel.nextPage}">ÏÂÒ»Ò³</a>
		   <select id="currpage" onchange="changePage()">
			   <c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			   <c:choose>
			      <c:when test="${pageModel.currPage ne vs.count}">
						<option value="${vs.count}">
							µÚ${vs.count}Ò³
					    </option>
				  </c:when>
			      <c:otherwise>
			            <option value="${vs.count}" selected="selected">
							µÚ${vs.count}Ò³
						</option>
				  </c:otherwise>
			   </c:choose>
			   </c:forEach>
		  </select>
		</td>
	</tr>
</table>
</body>
</html>