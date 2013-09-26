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
										<p style="padding-left:300px"><font color="red">没有挂号信息!</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="800" align="center" cellpadding="0" cellspacing="0">
											<tr align="center" style="background:#CCCCCC">
											  <td>处方号</td>
											  <td>挂号日期</td>
											  <td>病历号</td>
											  <td>患者姓名 </td>
											  <td>患者联系电话</td>
											  <td>挂号级别名称</td>
											  <td>挂号费</td>
											  <td>科室名称</td>
											  <td>医生姓名</td>
											  <td>挂号状态</td>
											  <td>操作人员</td>
											  <td>发票号</td>
											</tr>
                                       <c:forEach items="${pageModel.list}" var="m">
											<tr align="center">
												<td>
													<!-- 处方号 -->
													<div class="title1">${m.registerMain_No}</div>
												</td>
												<td>
													<!-- 挂号日期 -->
													<div class="td1">${m.registerMain_date}</div>
												</td>
												<td>
													<!-- 病历号 -->
													<div class="td1">${m.registerMain_caseNo}</div>
												</td>
												<td>
													<!--患者姓名 -->
													<div class="td1">${m.registerMain_name}</div>
												</td>
												<td>
													<!--患者联系电话 -->
													<div class="td1">${m.registerMain_phoneNo}</div>
												</td>
												<td>
													<!--挂号级别名称 -->
													<div class="td1">${m.registerMainr_rlName}</div>
												</td>
												<td>
													<!--挂号费 -->
													<div class="td1">${m.registerMain_fee}</div>
												</td>
												<td>
													<!--科室名称 -->
													<div class="td1">${m.registerMain_deptName}</div>
												</td>
												<td>
													<!--医生姓名 -->
													<div class="td1">${m.registerMain_docName}</div>
												</td>
												<td>
													<!--挂号状态 -->
													<div class="td1">${m.registerMain_status}</div>
												</td>
												<td>
													<!--操作人员 -->
													<div class="td1">${m.registerMain_operName}</div>
												</td>
												<td>
													<!--发票号 -->
													<div class="td1">${m.registerMain_invoiceNo}</div>
												</td>
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											总记录数：${pageModel.totalRecords}
											当前${pageModel.currPage}/${pageModel.totalPage}页
											<a href="<%=contextPath %>/Register/query.action?currPage=${pageModel.previousPage}&queryType=${queryType}">上一页</a>
											<a href="<%=contextPath %>/Register/query.action?currPage=${pageModel.nextPage}&queryType=${queryType}">下一页</a>
											<select id="currpage" onchange="changePage()">
												<c:forEach begin="1" end="${pageModel.totalPage}"
													varStatus="vs">
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
              <p align="center"><a href="<%=contextPath %>/Register/queryAll.action">返回</a></p>
</body>
</html>