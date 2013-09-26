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
<title>药品编码查找</title>
</head>
<body background="">
	<div id="queryCondition">
		<h3 align="center">药品编码查找</h3>
		<form action="<%=contextPath%>/DrugCode/drugcode_Find" method="post">
			<table style="padding-left:100px">
			    <tr>
                   <td>选择查询条件：
                   <SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <OPTION selected value="drugCode_number">药品编码</OPTION> 
                   <OPTION value="drugCode_zjm">助记码</OPTION> 
                   </SELECT> 
                  </td>
                </tr>
				<tr>
					<td>输入查询内容: <input type="text" name="queryData"> <input
						type="submit" value=""
						style="background-image: url(../image/CRUD_image/query1.png); width: 100px; height: 25px; margin-left: 5px">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr />
	<div id="showDetails">
		<c:choose>
			<c:when test="${empty pageModel.list}">
				<tr>
					<td align="center">
						<p style="padding-left: 300px">
							<font color="red">没有药品编码信息!</font>
						</p>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<table border="1" width="750" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center">
						<td>药品编码</td>
						<td>助记码</td>
						<td>选择</td>
					</tr>
					<c:forEach items="${pageModel.list}" var="m">
						<tr align="center">
							<td>
								<!-- 药品编码 -->
								<div class="title1">${m.drugCode_number}</div>
							</td>
							<td>
								<!-- 助记码 -->
								<div class="td1">${m.drugCode_zjm}</div>
							</td>
							<td>
							<input type="button" onclick="getValue('${m.drugCode_number}')" value="选择"> 
							</td>
						</tr>
					</c:forEach>
				</table>
				<table border="0" width="750" align="center">
					<tr>
						<td align="right">总记录数：${pageModel.totalRecords}
							当前${pageModel.currPage}/${pageModel.totalPage}页 <a
							href="<%=contextPath %>/DrugCode/drugcode_findAll?currPage=${pageModel.previousPage}">上一页</a>
							<a
							href="<%=contextPath %>/DrugCode/drugcode_findAll?currPage=${pageModel.nextPage}">下一页</a>
							<select id="currpage" onchange="changePage()">
								<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
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
	<script type="text/javascript">
		function getValue(str){   
		window.opener.document.getElementById("getcode").value=str;   
		window.close();   
		}   
	</script>
</body>
</html>