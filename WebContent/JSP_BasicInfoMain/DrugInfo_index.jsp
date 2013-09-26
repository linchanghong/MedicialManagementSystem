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
<title>ҩƷ��Ϣά��</title>
</head>
<body background="">
	<div id="queryCondition">
		<h3 align="center">ҩƷ��Ϣά��</h3>
		<form action="<%=contextPath%>/DrugInfo/druginfo_Query" method="post">
			<table style="padding-left: 100px">
				<tr>
					<td>ѡ���ѯ������ <SELECT style="WIDTH: 100px; height: 20px"
						name="queryType">
							<OPTION selected value="drugInfo_name">ҩƷ����</OPTION>
							<OPTION value="drugInfo_zjm">������</OPTION>
					</SELECT>
					</td>
				</tr>
				<tr>
					<td>�����ѯ����: <input type="text" name="queryData"> <input
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
							<font color="red">û��ҩƷ��Ϣ!</font>
						</p>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<table border="1" width="800" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center" style="background:#CCCCCC">
						<td>ҩƷ����</td>
						<td>ҩƷ����</td>
						<td>ҩƷ���</td>
						<td>ҩƷ����</td>
						<td>ҩƷ������</td>
						<td>��׼����</td>
						<td>���۷���</td>
						<td>ҩƷ����</td>
						<td>������</td>
						<td></td>
						<td></td>
					</tr>
					<c:forEach items="${pageModel.list}" var="m">
						<tr align="center">
							<td>
								<!-- ҩƷ���� -->
								<div class="title1">${m.drugInfo_name}</div>
							</td>
							<td>
								<!-- ҩƷ���� -->
								<div class="title1">${m.drugCode.drugCode_number}</div>
							</td>
							<td>
								<!-- ҩƷ��� -->
								<div class="title1">${m.drugInfo_standard}</div>
							</td>
							<td>
								<!-- ҩƷ���� -->
								<div class="title1">${m.drugCategory.drugCategory_name}</div>
							</td>
							<td>
								<!-- ҩƷ�������� -->
								<div class="title1">${m.drugManuf.drugManuf_name}</div>
							</td>
							<td>
								<!-- ��׼���� -->
								<div class="title1">${m.drugInfo_approve}</div>
							</td>
							<td>
								<!-- ���۷��� -->
								<div class="title1">${m.drugInfo_saleclassification}</div>
							</td>
							<td>
								<!-- ҩƷ������-->
								<div class="title1">${m.drugInfo_dosage}</div>
							</td>

							<td>
								<!-- ҩƷ������-->
								<div class="title1">${m.drugInfo_zjm}</div>
							</td>

							<td><a href="<%=contextPath %>/DrugInfo/druginfo_BeforeModify?drugInfo_id=${m.drugInfo_id}">�޸�</a></td>
							<td><a href="<%=contextPath %>/DrugInfo/druginfo_Delete?drugInfo_id=${m.drugInfo_id}" onclick="return confirm('ȷ��Ҫɾ����?')">ɾ��</a></td>
						</tr>
					</c:forEach>
				</table>
				<table border="0" width="800" align="center">
					<tr>
						<td align="right">�ܼ�¼����${pageModel.totalRecords}
							��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ <a
							href="<%=contextPath %>/DrugInfo/druginfo_queryAll?currPage=${pageModel.previousPage}">��һҳ</a>
							<a
							href="<%=contextPath %>/DrugInfo/druginfo_queryAll?currPage=${pageModel.nextPage}">��һҳ</a>
							<select id="currpage" onchange="changePage()">
								<c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
									<c:choose>
										<c:when test="${pageModel.currPage ne vs.count}">
											<option value="${vs.count}">��${vs.count}ҳ</option>
										</c:when>
										<c:otherwise>
											<option value="${vs.count}" selected="selected">
												��${vs.count}ҳ</option>
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