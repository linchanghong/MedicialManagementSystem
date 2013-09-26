<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript">
 var selTr = null;
 function GoSel(evt)
 {
    var el = evt.srcElement?evt.srcElement:evt.target;
    if(el.tagName.toUpperCase() !="TD") return;
    var tr = el.parentNode;
  //  alert(tr.cells[8].innerHTML);
    document.getElementById("prescriptionDetails_drugname").value=tr.cells[1].innerHTML;
    document.getElementById("prescriptionDetails_applynumber").value=tr.cells[2].innerHTML;
    document.getElementById("prescriptionDetails_money").value=tr.cells[3].innerHTML;
    document.getElementById("prescriptionDetails_usename").value=tr.cells[6].innerHTML;
    document.getElementById("prescriptionDetails_doseonce").value=tr.cells[8].innerHTML;
    document.getElementById("prescriptionDetails_frecode").value=tr.cells[9].innerHTML;
    id=tr.cells[10].innerHTML;
  //  alert(id);
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

	 <div id="showDetails">

                

                          <table onclick="Javascript:GoSel(event);" border="1" width="750" align="center" cellpadding="0" cellspacing="0" id="table">
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
											<tr align="center"  id="tr" >
											    
												<td id="td">${m.prescriptionDetails_number}</td>
												<td id="td">${m.prescriptionDetails_drugname}</td>
												<td id="td">${m.prescriptionDetails_applynumber}</td>	
												<td id="td">${m.prescriptionDetails_money}</td>	
												<td id="td">${m.prescriptionDetails_totalmoney}</td>	
												<td id="td">${m.prescriptionDetails_drugspecs}</td>	
												<td id="td">${m.prescriptionDetails_usename}</td>
												<td id="td">${m.prescriptionDetails_batch}</td>		
												<td id="td">${m.prescriptionDetails_doseonce}</td>												
												<td id="td">${m.prescriptionDetails_frecode}</td>
												<td style="display:none">${m.prescriptionDetails_id}</td>
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											�ܼ�¼����${pageModel.totalRecords}
								 			��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ
											<a href="<%=contextPath %>/PrescriptionDetails/add.action?currPage=${pageModel.previousPage}">��һҳ</a>
											<a href="<%=contextPath %>/PrescriptionDetails/add.action?currPage=${pageModel.nextPage}">��һҳ</a>
											<select id="currpage" onchange="changePage()">
												<c:forEach begin="1" end="${pageModel.totalPage}"
													varStatus="vs">
													<c:choose>
														<c:when test="${pageModel.currPage ne vs.count}">
															<option value="${vs.count}">
																��${vs.count}ҳ
															</option>
														</c:when>
														<c:otherwise>
															<option value="${vs.count}" selected="selected">
																��${vs.count}ҳ
															</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select> 
								 
										</td>
										</tr>
									</table>
      </div>

</body>
</html>