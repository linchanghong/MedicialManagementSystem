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
</head>
<body>
     <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
         <tr>
         <td>
          <div id="showDetails">
           <c:choose>
                 <c:when test="${empty pageModelPatient.list}">
								<tr>
									<td>
										<p ><font color="red">未找到病人</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="750" align="left" cellpadding="0" cellspacing="0">
											<tr align="left">
											  <td>病人信息</td>	
											</tr>
                                       <c:forEach items="${pageModelPatient.list}" var="m">
											<tr align="left">
												<td>
												   <div>
												   
          <a href="<%=contextPath%>/Prescription/findPatient.action?registerMain_id=${m.registerMain_id}&registerMain_No=${m.registerMain_No}" target="details">${m.registerMain_name}</a> 
                                                   
												   </div>
												</td>
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											总记录数：${pageModelPatient.totalRecords}
											当前${pageModelPatient.currPage}/${pageModelPatient.totalPage}页
											<a href="<%=contextPath %>/Prescription/add.action?currPagePatient=${pageModelPatient.previousPage}">上一页</a>
											<a href="<%=contextPath %>/Prescription/add.action?currPagePatient=${pageModelPatient.nextPage}">下一页</a>
											<select id="currpage" onchange="changePage()">
												<c:forEach begin="1" end="${pageModelPatient.totalPage}"
													varStatus="vs">
													<c:choose>
														<c:when test="${pageModelPatient.currPage ne vs.count}">
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
      </td>
      </tr>      
     </table>
</body>
</html>