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
<title>药品信息维护</title>
</head>
<body background="">
	<div id="queryCondition">
		<h3 align="center">药品信息维护</h3>
		<form action="<%=contextPath%>/DrugInfo/druginfo_Query" method="post">
			<table style="padding-left: 100px">
				<tr>
					<td>选择查询条件： <SELECT style="WIDTH: 100px; height: 20px"
						name="queryType">
							<OPTION selected value="drugInfo_name">药品名称</OPTION>
							<OPTION value="drugInfo_zjm">助记码</OPTION>
					</SELECT>
					</td>
				</tr>
				<tr>
					<td>输入查询内容: <input type="text" name="queryData"> <input
						type="submit" value=""
						style="background-image: url(../image/CRUD_image/query1.png); width: 100px; height: 25px; margin-left: 5px">
						<input type="button" id="new"
						style="background-image: url(../image/CRUD_image/add.png); width: 100px; height: 25px; margin-left: 0px">
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
							<font color="red">没有药品信息!</font>
						</p>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<table border="1" width="800" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center" style="background:#CCCCCC">
						<td>药品名称</td>
						<td>药品编码</td>
						<td>药品规格</td>
						<td>药品分类</td>
						<td>药品生产商</td>
						<td>批准文字</td>
						<td>销售分类</td>
						<td>药品剂型</td>
						<td>助记码</td>
						<td></td>
						<td></td>
					</tr>
					<c:forEach items="${pageModel.list}" var="m">
						<tr align="center">
							<td>
								<!-- 药品名称 -->
								<div class="title1">${m.drugInfo_name}</div>
							</td>
							<td>
								<!-- 药品编码 -->
								<div class="title1">${m.drugCode.drugCode_number}</div>
							</td>
							<td>
								<!-- 药品规格 -->
								<div class="title1">${m.drugInfo_standard}</div>
							</td>
							<td>
								<!-- 药品分类 -->
								<div class="title1">${m.drugCategory.drugCategory_name}</div>
							</td>
							<td>
								<!-- 药品生产厂商 -->
								<div class="title1">${m.drugManuf.drugManuf_name}</div>
							</td>
							<td>
								<!-- 批准文字 -->
								<div class="title1">${m.drugInfo_approve}</div>
							</td>
							<td>
								<!-- 销售分类 -->
								<div class="title1">${m.drugInfo_saleclassification}</div>
							</td>
							<td>
								<!-- 药品生剂型-->
								<div class="title1">${m.drugInfo_dosage}</div>
							</td>

							<td>
								<!-- 药品助记码-->
								<div class="title1">${m.drugInfo_zjm}</div>
							</td>

							<td><a href="<%=contextPath %>/DrugInfo/druginfo_BeforeModify?drugInfo_id=${m.drugInfo_id}">修改</a></td>
							<td><a href="<%=contextPath %>/DrugInfo/druginfo_Delete?drugInfo_id=${m.drugInfo_id}" onclick="return confirm('确定要删除吗?')">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<table border="0" width="800" align="center">
					<tr>
						<td align="right">总记录数：${pageModel.totalRecords}
							当前${pageModel.currPage}/${pageModel.totalPage}页 <a
							href="<%=contextPath %>/DrugInfo/druginfo_queryAll?currPage=${pageModel.previousPage}">上一页</a>
							<a
							href="<%=contextPath %>/DrugInfo/druginfo_queryAll?currPage=${pageModel.nextPage}">下一页</a>
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

	<div id="newView" style="display: none;"><jsp:include
			page="DrugInfo_add.jsp"></jsp:include></div>

	<script type="text/javascript">
		function changePage() {
			var currPage = document.getElementById("currpage").value;
			window.self.location = "<%=contextPath %>/DrugInfo/druginfo_queryAll?currPage="
					+ currPage;
		}

		document.getElementById("new").onclick = function() {
			document.getElementById("queryCondition").style.display = "none";
			document.getElementById("showDetails").style.display = "none";
			document.getElementById("newView").style.display = "block";
		}
	</script>
</body>
</html>