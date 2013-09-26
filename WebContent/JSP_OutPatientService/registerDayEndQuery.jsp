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
        <h4 style="padding-left:60px">查询条件</h4>
        
           <table style="padding-left:100px">
             <tr>
               <td>挂号人员：</td>
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
										<p style="padding-left:300px"><font color="red">没有日结信息!</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="800" align="center" cellpadding="0" cellspacing="0">
											<tr align="center" style="background:#CCCCCC">
											  <td>开始时间</td>
											  <td>截止日期</td>
											  <td>操作人员</td>
											  <td>总的挂号费 </td>
											  <td>正常单数</td>
											  <td>退号单数</td>
											  <td>处理的总的单数</td>
											  
											</tr>
                                       <c:forEach items="${pageModel.list}" var="m">
											<tr align="center">
												<td>
													<!-- 开始时间 -->
													<div class="title1">${m.dayEnd_beginDate}</div>
												</td>
												<td>
													<!-- 截止时间 -->
													<div class="td1">${m.dayEnd_endDate}</div>
												</td>
												<td>
													<!-- 操作人员 -->
													<div class="td1">${m.dayEnd_oper}</div>
												</td>
												<td>
													<!--总的挂号费 -->
													<div class="td1">${m.dayEnd_feeCount}</div>
												</td>
												<td>
													<!--正常单号 -->
													<div class="td1">${m.dayEnd_danHaoZC}</div>
												</td>
												<td>
													<!--退号单号 -->
													<div class="td1">${m.dayEnd_danHaoTH}</div>
												</td>
												<td>
													<!--总的单数 -->
													<div class="td1">${m.dayEnd_danHaoCount}</div>
												</td>
												
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											总记录数：${pageModel.totalRecords}
											当前${pageModel.currPage}/${pageModel.totalPage}页
											<a href="<%=contextPath %>/Register/queryAllDayEnd.action?currPage=${pageModel.previousPage}">上一页</a>
											<a href="<%=contextPath %>/Register/queryAllDayEnd.action?currPage=${pageModel.nextPage}">下一页</a>
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
</body>
</html>