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

<body background="">
      <div id="queryCondition">
        <form action="<%=contextPath %>/OutpatientPayment/query.action" method="post">
        <h3>�����շ�����</h3>
        <h4>��ѯ����</h4>
        <p style="padding-left:650px"><input type="button" id="new" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 23px"></p>
           <table style="padding-left:100px">
             <tr>
               <td>ѡ���ѯ������</td>
                 <td>
                   <SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <OPTION selected value="outpatientPayment_name">�����շ�����</OPTION> 
                   <OPTION value="outpatientPayment_number">�����շѱ��</OPTION>   
                   <option value="outpatientPayment_property">�����շ�����</option>  
                   <option value="outpatientPayment_object">�����շѶ���</option>    
                   <option value="outpatientPayment_remark">��ע</option>     
                   <option value="outpatientPayment_zjm">������</option>       
                   </SELECT>
                 </td>
             </tr>
             <tr>
               <td>�����ѯ���ݣ�</td>
               <td><input type="text" name="queryData"></td>
               <td><input type="submit" value="" style="background-image:url(../image/CRUD_image/query1.png);width: 100px; height: 30px"></td>
             </tr>
           </table>
        </form>
      </div>
      <hr/>
      <div id="showDetails">
           <c:choose>
                 <c:when test="${empty pageModel.list}">
								<tr>
									<td align="center">
										<p style="padding-left:300px"><font color="red">û�������շ�������Ϣ��</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="750" align="center" cellpadding="0" cellspacing="0">
											<tr align="center" style="background:#CCCCCC">
											  <td>�����շ�����</td>
											  <td>�����շѱ��</td>
											  <td>�����շ�����</td>
											  <td>�����շѶ���</td>
											  <td>��ע</td>
											  <td>������</td>
											  <td></td>
											  <td></td>
											</tr>
                                       <c:forEach items="${pageModel.list}" var="m">
											<tr align="center">
												<td>
													<!-- �����շ����� -->
													<div class="title1">${m.outpatientPayment_name}</div>
												</td>
												<td>
													<!-- �����շѱ�� -->
													<div class="td1">${m.outpatientPayment_number}</div>
												</td>
												<td>
													<!-- �����շ����� -->
													<div class="td1">${m.outpatientPayment_property}</div>
												</td>
												<td>
												    <!--�����շѶ���  -->
												    <div class="td1">${m.outpatientPayment_object}</div>
												</td>
												<td>
												    <!-- ��ע -->
												    <div class="td1">${m.outpatientPayment_remark}</div>
												</td>
												<td>
												    <!-- ������ -->
												    <div class="td1">${m.outpatientPayment_zjm}</div>
												</td>
												<td>
												    <a href="<%=contextPath %>/OutpatientPayment/modify1.action?outpatientPayment_id=${m.outpatientPayment_id}">�޸�</a>
												</td>
												<td>
												    <a id="deleteOrNot" href="<%=contextPath %>/OutpatientPayment/delete.action?outpatientPayment_id=${m.outpatientPayment_id}">ɾ��</a>
												</td>
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											�ܼ�¼����${pageModel.totalRecords}
											��ǰ${pageModel.currPage}/${pageModel.totalPage}ҳ
											<a href="<%=contextPath %>/OutpatientPayment/add.action?currPage=${pageModel.previousPage}">��һҳ</a>
											<a href="<%=contextPath %>/OutpatientPayment/add.action?currPage=${pageModel.nextPage}">��һҳ</a>
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


<div id="newView" style=" display:none;"><jsp:include page="OutpatientPayment_add.jsp"></jsp:include></div>

<script type="text/javascript">
	document.getElementById("new").onclick=function(){
		document.getElementById("queryCondition").style.display="none";
		document.getElementById("showDetails").style.display="none";
		document.getElementById("newView").style.display="block";
		}
	
	function changePage() {
		var currPage = document.getElementById("currpage").value;
		window.self.location = "<%=contextPath %>/OutpatientPayment/add.action?currPage="
				+ currPage;
	}
	document.getElementById("deleteOrNot").onclick=function(){
		confirm("ȷ��ɾ����");
		}
</script>
  
</body>
</html>