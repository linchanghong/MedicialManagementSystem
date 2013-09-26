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
<div id="queryCondition">
        <form action="<%=contextPath %>/Register/queryAllDayEnd_q.action" method="post">
        <h4 style="padding-left:60px">��ѯ����</h4>
        
           <table style="padding-left:100px">
             <tr>
               <td>�Һ���Ա��</td>
               <td><input type="text" name="oper"></td>
               <td><td><input type="submit" value="" style="background-image:url(../image/CRUD_image/query1.png);width: 100px; height: 30px"></td>
               <td><input type="hidden" name="next1" value="next1"></td>
             </tr>
           </table>
        </form>
      </div>
<div id="showDetails">
           <c:choose>
                 <c:when test="${empty pageModel.list}">
								<tr>
									<td align="center">
										<p style="padding-left:300px"><font color="red">û���ս���Ϣ!</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="800" align="center" cellpadding="0" cellspacing="0">
											<tr align="center" style="background:#CCCCCC">
											  <td>��ʼʱ��</td>
											  <td>��ֹ����</td>
											  <td>������Ա</td>
											  <td>�ܵĹҺŷ� </td>
											  <td>��������</td>
											  <td>�˺ŵ���</td>
											  <td>������ܵĵ���</td>
											  
											</tr>
                                       <c:forEach items="${pageModel.list}" var="m">
											<tr align="center">
												<td>
													<!-- ��ʼʱ�� -->
													<div class="title1">${m.dayEnd_beginDate}</div>
												</td>
												<td>
													<!-- ��ֹʱ�� -->
													<div class="td1">${m.dayEnd_endDate}</div>
												</td>
												<td>
													<!-- ������Ա -->
													<div class="td1">${m.dayEnd_oper}</div>
												</td>
												<td>
													<!--�ܵĹҺŷ� -->
													<div class="td1">${m.dayEnd_feeCount}</div>
												</td>
												<td>
													<!--�������� -->
													<div class="td1">${m.dayEnd_danHaoZC}</div>
												</td>
												<td>
													<!--�˺ŵ��� -->
													<div class="td1">${m.dayEnd_danHaoTH}</div>
												</td>
												<td>
													<!--�ܵĵ��� -->
													<div class="td1">${m.dayEnd_danHaoCount}</div>
												</td>
												
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											�ܼ�¼����${pageModel.totalRecords}
											��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ
											<a href="<%=contextPath %>/Register/queryAllDayEnd.action?currPage=${pageModel.previousPage}">��һҳ</a>
											<a href="<%=contextPath %>/Register/queryAllDayEnd.action?currPage=${pageModel.nextPage}">��һҳ</a>
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
</body>
</html>