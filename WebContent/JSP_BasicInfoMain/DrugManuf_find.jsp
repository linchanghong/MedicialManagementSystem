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
</head>
<jsp:include page="DrugManuf_header.jsp"></jsp:include>
<body background="">
	<div id="queryCondition">
		<form action="<%=contextPath%>/DrugManuf/Find.action" method="post">
			<h3>药品生产厂商查询</h3>
			<table style="padding-left: 100px">
				<tr>
					<td>选择查询条件：</td>
					<td><SELECT style="WIDTH: 100px; height: 20px"
						name="queryType">
							<OPTION selected value="drugManuf_number">生产商编码</OPTION>
							<OPTION value="drugManuf_name">生产商名称</OPTION>
							<OPTION value="drugManuf_zjm">生产商助记码</OPTION>
					</SELECT></td>
				</tr>
				<tr>
					<td>输入查询数据：</td>
					<td><input type="text" name="queryData"></td>
					<td><input type="submit" value=""
						style="background-image: url(../image/CRUD_image/query1.png); width: 100px; height: 30px"></td>
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
							<font color="red">没有生产商信息!</font>
						</p>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<table border="1" width="750" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center">
						<td>生产商编码</td>
						<td>生产商名称</td>
						<td>生产商助记码</td>
						<td>生产商地址</td>
						<td>生产商邮编</td>
						<td>生产商电话</td>
						<td>生产商传真</td>
						<td>生产商联系人</td>
                        <td>选择</td>
					</tr>
					<c:forEach items="${pageModel.list}" var="a">
						<tr align="center">
							<td>
								<div class="title1">${a.drugManuf_number}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_name}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_zjm}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_address}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_postcode}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_telephone}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_fax}</div>
							</td>
							<td>
								<div class="td1">${a.drugManuf_linkman}</div>
							</td>
							<td>
							<input type="button" onclick="getValue('${a.drugManuf_name}')" value="选择"> 
							</td>
						</tr>
					</c:forEach>
				</table>

				<table border="0" width="750" align="center">
					<tr>
						<td align="right">总记录数：${pageModel.totalRecords}
							当前${pageModel.currPage}/${pageModel.totalPage}页 <a
							href="<%=contextPath %>/DrugManuf/findAll.action?currPage=${pageModel.previousPage}">上一页</a>
							<a
							href="<%=contextPath %>/DrugManuf/findAll.action?currPage=${pageModel.nextPage}">下一页</a>
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
		window.opener.document.getElementById("getsupplier").value=str;   
		window.close();   
		} 
	</script>
</body>
</html>