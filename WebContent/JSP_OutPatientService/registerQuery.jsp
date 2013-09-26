<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<div id="showDetails">
           <c:choose>
                 <c:when test="${empty pageModel.list}">
								<tr>
									<td align="center">
										<p style="padding-left:300px"><font color="red">û�йҺ���Ϣ!</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="800" align="center" cellpadding="0" cellspacing="0">
											<tr align="center" style="background:#CCCCCC">
											  <td>������</td>
											  <td>�Һ�����</td>
											  <td>������</td>
											  <td>�������� </td>
											  <td>������ϵ�绰</td>
											  <td>�Һż�������</td>
											  <td>�Һŷ�</td>
											  <td>��������</td>
											  <td>ҽ������</td>
											  <td>�Һ�״̬</td>
											  <td>������Ա</td>
											  <td>��Ʊ��</td>
											</tr>
                                       <c:forEach items="${pageModel.list}" var="m">
											<tr align="center">
												<td>
													<!-- ������ -->
													<div class="title1">${m.registerMain_No}</div>
												</td>
												<td>
													<!-- �Һ����� -->
													<div class="td1">${m.registerMain_date}</div>
												</td>
												<td>
													<!-- ������ -->
													<div class="td1">${m.registerMain_caseNo}</div>
												</td>
												<td>
													<!--�������� -->
													<div class="td1">${m.registerMain_name}</div>
												</td>
												<td>
													<!--������ϵ�绰 -->
													<div class="td1">${m.registerMain_phoneNo}</div>
												</td>
												<td>
													<!--�Һż������� -->
													<div class="td1">${m.registerMainr_rlName}</div>
												</td>
												<td>
													<!--�Һŷ� -->
													<div class="td1">${m.registerMain_fee}</div>
												</td>
												<td>
													<!--�������� -->
													<div class="td1">${m.registerMain_deptName}</div>
												</td>
												<td>
													<!--ҽ������ -->
													<div class="td1">${m.registerMain_docName}</div>
												</td>
												<td>
													<!--�Һ�״̬ -->
													<div class="td1">${m.registerMain_status}</div>
												</td>
												<td>
													<!--������Ա -->
													<div class="td1">${m.registerMain_operName}</div>
												</td>
												<td>
													<!--��Ʊ�� -->
													<div class="td1">${m.registerMain_invoiceNo}</div>
												</td>
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											�ܼ�¼����${pageModel.totalRecords}
											��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ
											<a href="<%=contextPath %>/Register/query.action?currPage=${pageModel.previousPage}&queryType=${queryType}">��һҳ</a>
											<a href="<%=contextPath %>/Register/query.action?currPage=${pageModel.nextPage}&queryType=${queryType}">��һҳ</a>
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
						</c:otherwise>
						
			</c:choose>
      </div>
<script type="text/javascript">
	
	
	function changePage() {
		var currPage = document.getElementById("currpage").value;
		window.self.location = "<%=contextPath %>/Register/queryAll.action?currPage="
				+ currPage;
	}
	
</script>
              <p align="center"><a href="<%=contextPath %>/Register/queryAll.action">����</a></p>
</body>
</html>