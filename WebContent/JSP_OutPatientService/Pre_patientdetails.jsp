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
										<p ><font color="red">δ�ҵ�����</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="750" align="left" cellpadding="0" cellspacing="0">
											<tr align="left">
											  <td>������Ϣ</td>	
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
											�ܼ�¼����${pageModelPatient.totalRecords}
											��ǰ${pageModelPatient.currPage}/${pageModelPatient.totalPage}ҳ
											<a href="<%=contextPath %>/Prescription/add.action?currPagePatient=${pageModelPatient.previousPage}">��һҳ</a>
											<a href="<%=contextPath %>/Prescription/add.action?currPagePatient=${pageModelPatient.nextPage}">��һҳ</a>
											<select id="currpage" onchange="changePage()">
												<c:forEach begin="1" end="${pageModelPatient.totalPage}"
													varStatus="vs">
													<c:choose>
														<c:when test="${pageModelPatient.currPage ne vs.count}">
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
      </td>
      </tr>      
     </table>
</body>
</html>