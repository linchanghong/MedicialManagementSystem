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
<script src="../js/jquery-1.9.1.js"></script>
<script>

var id;
var number;
	$(function(){
		$("#add").click(function(){
			var number=$("#number").val();
			var drugname = encodeURI($("#prescriptionDetails_drugname").val());
			
			var money = $("#prescriptionDetails_money").val();
			
			var frecode = $("#prescriptionDetails_frecode").val();
			var applynumber = $("#prescriptionDetails_applynumber").val();
			var username = $("#prescriptionDetails_usename").val();
			var doseonce = $("#prescriptionDetails_doseonce").val();
			
			var pName = encodeURI($("#pName").val());
			var pSex = encodeURI($("#pSex").val());
			var pAge = $("#pAge").val();
			var pCaseNo = $("#pCaseNo").val();
			var pDept = encodeURI($("#pDept").val());
			var pDoc = encodeURI($("#pDoc").val());
			var pFapiao = encodeURI($("#pFapiao").val());
			var deptname=$("#dept").val() ;
			
			$("#showDetails").load('../PrescriptionDetails/add.action',{"prescriptionDetails_number":number,"prescriptionDetails_drugname":drugname,
				"prescriptionDetails_money":money,"prescriptionDetails_frecode":frecode,"prescriptionDetails_applynumber":applynumber,
				"prescriptionDetails_usename":username,"prescriptionDetails_doseonce":doseonce,"prescriptionDetails_deptcode":deptname,
				"pName":pName,"pSex":pSex,"pAge":pAge,"pCaseNo":pCaseNo,"pDept":pDept,"pDoc":pDoc,"pFapiao":pFapiao
				});
		});
	});
		$(function(){
			$("#modify").click(function(){
				var number=$("#number").val();
			//	alert(id);
				var drugname = encodeURI($("#prescriptionDetails_drugname").val());
				var money = $("#prescriptionDetails_money").val();
				var frecode = $("#prescriptionDetails_frecode").val();
				var applynumber = $("#prescriptionDetails_applynumber").val();
				var username = $("#prescriptionDetails_usename").val();
				var doseonce = $("#prescriptionDetails_doseonce").val();
				$("#showDetails").load('../PrescriptionDetails/modify2.action?prescriptionDetails_id='+id,{"prescriptionDetails_number":number,"prescriptionDetails_drugname":drugname,
					"prescriptionDetails_money":money,"prescriptionDetails_frecode":frecode,"prescriptionDetails_applynumber":applynumber,
					"prescriptionDetails_usename":username,"prescriptionDetails_doseonce":doseonce
				});
	         });
		});
		
		$(function(){
			$("#delete").click(function(){
			//	alert(id);
				var number=$("#number").val();
				$("#showDetails").load('../PrescriptionDetails/delete.action?prescriptiondetails_id='+id,{"prescriptionDetails_number":number
				});
	         });
		});
		
	 var selTr = null;
	 function GoSel(evt)
	 {
	    var el = evt.srcElement?evt.srcElement:evt.target;
	    if(el.tagName.toUpperCase() !="TD") return;
	    var tr = el.parentNode;
	   // alert(tr.cells[9].innerHTML);
	    document.getElementById("prescriptionDetails_drugname").value=tr.cells[1].innerHTML;
	    document.getElementById("prescriptionDetails_applynumber").value=tr.cells[2].innerHTML;
	    document.getElementById("prescriptionDetails_money").value=tr.cells[3].innerHTML;
	    document.getElementById("prescriptionDetails_usename").value=tr.cells[6].innerHTML;
	    document.getElementById("prescriptionDetails_doseonce").value=tr.cells[8].innerHTML;
	    document.getElementById("prescriptionDetails_frecode").value=tr.cells[9].innerHTML;
	    id=tr.cells[10].innerHTML;
	    number=tr.cells[0].innerHTML;
	    tr.style.backgroundColor="#cccccc";
	    if(selTr !=null)
	    {
	        selTr.style.backgroundColor ="white";
	    }
	    selTr = tr;
	 }
</script>
</head>
<body>
	<div id="all" style="height: 50px">
		<table>
			<tr>
				<td>病例号:</td>
				<td>${patientDetails.registerMain_No}</td>
				<td>患者姓名:</td>
				<td>${patientDetails.registerMain_name}</td>
				<td>患者性别:</td>
				<td>${patientDetails.registerMain_sex}</td>
				<td>患者年龄:</td>
				<td>${patientDetails.registerMain_birthday}</td>
				<td>挂号日期:</td>
				<td>${patientDetails.registerMain_date}</td>
			</tr>
			<tr>
				<td>收费人:</td>
				<td>${patientDetails.registerMain_operName }</td>
				<td>看诊科室:</td>
				<td>${patientDetails.registerMain_deptName}</td>
				<td><input type="hidden" id="dept" value="${patientDetails.registerMain_deptCode}"></td>
				<td>医生:</td>
				<td>${patientDetails.registerMain_docName }</td>
			</tr>
			<tr>
			   <td><input type="hidden" id="pName" value="${patientDetails.registerMain_name}"></td>
			   <td><input type="hidden" id="pSex" value="${patientDetails.registerMain_sex}"></td>
			   <td><input type="hidden" id="pAge" value="${patientDetails.registerMain_birthday}"></td>
			   <td><input type="hidden" id="pCaseNo" value="${patientDetails.registerMain_caseNo}"></td>
			   <td><input type="hidden" id="pDept" value="${patientDetails.registerMain_deptName}"></td>
			   <td><input type="hidden" id="pDoc" value="${patientDetails.registerMain_docName}"></td>
			   <td><input type="hidden" id="pFapiao" value="${patientDetails.registerMain_invoiceNo}"></td>
			</tr>
		</table>
		<div><font color="red">
			------------------------------------ 显示信息：
			-----------------------------------</font>
			<div id="showDetails" style="margin-top: 10px; height: 200px">

				<c:choose>
					<c:when test="${empty pageModel.list}">
						<tr>
							<td align="center">
								<p style="padding-left: 300px">
									<font color="red">没有用户信息！</font>
								</p>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<table onclick="Javascript:GoSel(event);" border="1" width="100%"
							align="center" cellpadding="0" cellspacing="0" id="table">
							<tr align="center">

								<td>处方号</td>
								<td>药品名称</td>
								<td>数量</td>
								<td>单价</td>
								<td>金额</td>
								<td>规格</td>
								<td>用法</td>
								<td>批号</td>
								<td>每次剂量</td>
								<td>频次</td>
							</tr>
							<c:forEach items="${pageModel.list}" var="m">
								<tr align="center" id="tr">

									<td id="td">${m.prescriptionDetails_number}</td>
									<td id="td">${m.prescriptionDetails_drugname}</td>
									<td id="td">${m.prescriptionDetails_applynumber}</td>
									<td>${m.prescriptionDetails_money}</td>
									<td id="td">${m.prescriptionDetails_totalmoney}</td>
									<td>${m.prescriptionDetails_drugspecs}</td>
									<td>${m.prescriptionDetails_usename}</td>
									<td id="td">${m.prescriptionDetails_batch}</td>
									<td>${m.prescriptionDetails_doseonce}</td>
									<td>${m.prescriptionDetails_frecode}</td>
									<td style="display: none">${m.prescriptionDetails_id}</td>
								</tr>
							</c:forEach>
						</table>

						<table border="0" width="750" align="center">
							<tr>
								<td align="right">总记录数：${pageModel.totalRecords}
									当前${pageModel.currPage}/${pageModel.totalPage}页 <a
									href="#">上一页</a>
									<a
									href="#">下一页</a>
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
					</c:otherwise>

				</c:choose>

			</div>
		</div>

		<form name="form1"
			action="<%=contextPath%>/PrescriptionDetails/submit.action?prescriptionDetails_number=${patientDetails.registerMain_No}"
			style="margin-bottom: 100px" method="post">
			<table>
				<tr>

					<td>药品名称</td>
					<td><input type="text" name="prescriptionDetails_drugname"
						id="prescriptionDetails_drugname"></input></td>
					<td>药品价格</td>
					<td><input name="prescriptionDetails_money"
						id="prescriptionDetails_money"></input></td>
					<td>频次</td>
					<td><input name="prescriptionDetails_frecode"
						id="prescriptionDetails_frecode"></input></td>
				</tr>
				<tr>
					<td>数量</td>
					<td><input name="prescriptionDetails_applynumber"
						id="prescriptionDetails_applynumber"></input></td>
					<td>用法</td>
					<td><SELECT style="WIDTH: 100px; height: 20px"
						name="prescriptionDetails_usename"
						id="prescriptionDetails_usename">
							<OPTION selected value="chongji">冲剂</OPTION>
							<OPTION value="koufu">口服</OPTION>
					</SELECT></td>
					<td>每次剂量</td>
					<td><input name="prescriptionDetails_doseonce"
						id="prescriptionDetails_doseonce"></td>
				</tr>
				<tr>
					<td><input type="button" value="添加药品" name="add" id="add">
					</td>
					<td>&nbsp;&nbsp;&nbsp; <input type="button" value="删除药品"
						name="delete" id="delete"></input>
					</td>
					<td><input type="button" value="修改药品" name="modify"
						id="modify"></input></td>
					<td></td>
					<td><input type="submit" value="确认处方" name="submit"></input></td>
					<td><input type="hidden" id="number" name="number"
						value="${patientDetails.registerMain_No}">
					</intput></td>
				</tr>
			</table>
		</form>
	</div>

	<script type="text/javascript">

    var xmlHttp;  
    var flag;  
    function createXMLHttp(){  
        if (window.XMLHttpRequest){                     // 创建XMLHttpRequest核心对象  
            xmlHttp = new XMLHttpRequest();                  // 使用FireFox内核  
        }else {  
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");   // 使用IE内核的浏览器  
        }  
    }  
  
    function checkUserName(username){       // 显示信息  
        createXMLHttp();    //  
        // 设置请求,通过地址重写方式将userid传递到JSP中  
          
        xmlHttp.open("POST","<%=contextPath%>/LoginMaintain/isInput.action?login_name="+ username);
			// 设置完请求后调用处理回调函数  
			xmlHttp.onreadystatechange = checkUseridCallback;
			xmlHttp.send(null); // 发送请求，不设置参数  
			// document.getElementById("msg").innerHTML = "正在验证……";  
			//alert("*******");  

		}

		function checkUseridCallback() { // 回调函数  
			if (xmlHttp.readyState == 4) { // 数据返回完毕  
				if (xmlHttp.status == 200) { // HTTP操作正常  
					//alert("*****8");  
					var text = xmlHttp.responseText;// 接收返回内容  

				}
			}
		}

		function checkForm() { // 对表单判断能否进行提交操作  
			return flag;
		}
	</script>



</body>
</html>