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
				<td>������:</td>
				<td>${patientDetails.registerMain_No}</td>
				<td>��������:</td>
				<td>${patientDetails.registerMain_name}</td>
				<td>�����Ա�:</td>
				<td>${patientDetails.registerMain_sex}</td>
				<td>��������:</td>
				<td>${patientDetails.registerMain_birthday}</td>
				<td>�Һ�����:</td>
				<td>${patientDetails.registerMain_date}</td>
			</tr>
			<tr>
				<td>�շ���:</td>
				<td>${patientDetails.registerMain_operName }</td>
				<td>�������:</td>
				<td>${patientDetails.registerMain_deptName}</td>
				<td><input type="hidden" id="dept" value="${patientDetails.registerMain_deptCode}"></td>
				<td>ҽ��:</td>
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
			------------------------------------ ��ʾ��Ϣ��
			-----------------------------------</font>
			<div id="showDetails" style="margin-top: 10px; height: 200px">

				<c:choose>
					<c:when test="${empty pageModel.list}">
						<tr>
							<td align="center">
								<p style="padding-left: 300px">
									<font color="red">û���û���Ϣ��</font>
								</p>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<table onclick="Javascript:GoSel(event);" border="1" width="100%"
							align="center" cellpadding="0" cellspacing="0" id="table">
							<tr align="center">

								<td>������</td>
								<td>ҩƷ����</td>
								<td>����</td>
								<td>����</td>
								<td>���</td>
								<td>���</td>
								<td>�÷�</td>
								<td>����</td>
								<td>ÿ�μ���</td>
								<td>Ƶ��</td>
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
								<td align="right">�ܼ�¼����${pageModel.totalRecords}
									��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ <a
									href="#">��һҳ</a>
									<a
									href="#">��һҳ</a>
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
					</c:otherwise>

				</c:choose>

			</div>
		</div>

		<form name="form1"
			action="<%=contextPath%>/PrescriptionDetails/submit.action?prescriptionDetails_number=${patientDetails.registerMain_No}"
			style="margin-bottom: 100px" method="post">
			<table>
				<tr>

					<td>ҩƷ����</td>
					<td><input type="text" name="prescriptionDetails_drugname"
						id="prescriptionDetails_drugname"></input></td>
					<td>ҩƷ�۸�</td>
					<td><input name="prescriptionDetails_money"
						id="prescriptionDetails_money"></input></td>
					<td>Ƶ��</td>
					<td><input name="prescriptionDetails_frecode"
						id="prescriptionDetails_frecode"></input></td>
				</tr>
				<tr>
					<td>����</td>
					<td><input name="prescriptionDetails_applynumber"
						id="prescriptionDetails_applynumber"></input></td>
					<td>�÷�</td>
					<td><SELECT style="WIDTH: 100px; height: 20px"
						name="prescriptionDetails_usename"
						id="prescriptionDetails_usename">
							<OPTION selected value="chongji">���</OPTION>
							<OPTION value="koufu">�ڷ�</OPTION>
					</SELECT></td>
					<td>ÿ�μ���</td>
					<td><input name="prescriptionDetails_doseonce"
						id="prescriptionDetails_doseonce"></td>
				</tr>
				<tr>
					<td><input type="button" value="���ҩƷ" name="add" id="add">
					</td>
					<td>&nbsp;&nbsp;&nbsp; <input type="button" value="ɾ��ҩƷ"
						name="delete" id="delete"></input>
					</td>
					<td><input type="button" value="�޸�ҩƷ" name="modify"
						id="modify"></input></td>
					<td></td>
					<td><input type="submit" value="ȷ�ϴ���" name="submit"></input></td>
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
        if (window.XMLHttpRequest){                     // ����XMLHttpRequest���Ķ���  
            xmlHttp = new XMLHttpRequest();                  // ʹ��FireFox�ں�  
        }else {  
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");   // ʹ��IE�ں˵������  
        }  
    }  
  
    function checkUserName(username){       // ��ʾ��Ϣ  
        createXMLHttp();    //  
        // ��������,ͨ����ַ��д��ʽ��userid���ݵ�JSP��  
          
        xmlHttp.open("POST","<%=contextPath%>/LoginMaintain/isInput.action?login_name="+ username);
			// �������������ô���ص�����  
			xmlHttp.onreadystatechange = checkUseridCallback;
			xmlHttp.send(null); // �������󣬲����ò���  
			// document.getElementById("msg").innerHTML = "������֤����";  
			//alert("*******");  

		}

		function checkUseridCallback() { // �ص�����  
			if (xmlHttp.readyState == 4) { // ���ݷ������  
				if (xmlHttp.status == 200) { // HTTP��������  
					//alert("*****8");  
					var text = xmlHttp.responseText;// ���շ�������  

				}
			}
		}

		function checkForm() { // �Ա��ж��ܷ�����ύ����  
			return flag;
		}
	</script>



</body>
</html>