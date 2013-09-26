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
			<h3>ҩƷ�������̲�ѯ</h3>
			<table style="padding-left: 100px">
				<tr>
					<td>ѡ���ѯ������</td>
					<td><SELECT style="WIDTH: 100px; height: 20px"
						name="queryType">
							<OPTION selected value="drugManuf_number">�����̱���</OPTION>
							<OPTION value="drugManuf_name">����������</OPTION>
							<OPTION value="drugManuf_zjm">������������</OPTION>
					</SELECT></td>
				</tr>
				<tr>
					<td>�����ѯ���ݣ�</td>
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
							<font color="red">û����������Ϣ!</font>
						</p>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<table border="1" width="750" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center">
						<td>�����̱���</td>
						<td>����������</td>
						<td>������������</td>
						<td>�����̵�ַ</td>
						<td>�������ʱ�</td>
						<td>�����̵绰</td>
						<td>�����̴���</td>
						<td>��������ϵ��</td>
                        <td>ѡ��</td>
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
							<input type="button" onclick="getValue('${a.drugManuf_name}')" value="ѡ��"> 
							</td>
						</tr>
					</c:forEach>
				</table>

				<table border="0" width="750" align="center">
					<tr>
						<td align="right">�ܼ�¼����${pageModel.totalRecords}
							��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ <a
							href="<%=contextPath %>/DrugManuf/findAll.action?currPage=${pageModel.previousPage}">��һҳ</a>
							<a
							href="<%=contextPath %>/DrugManuf/findAll.action?currPage=${pageModel.nextPage}">��һҳ</a>
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
	<script type="text/javascript">
	function getValue(str){   
		window.opener.document.getElementById("getsupplier").value=str;   
		window.close();   
		} 
	</script>
</body>
</html>