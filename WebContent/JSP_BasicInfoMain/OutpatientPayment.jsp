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
        <h3>门诊收费种类</h3>
        <h4>查询条件</h4>
        <p style="padding-left:650px"><input type="button" id="new" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 23px"></p>
           <table style="padding-left:100px">
             <tr>
               <td>选择查询条件：</td>
                 <td>
                   <SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <OPTION selected value="outpatientPayment_name">门诊收费名称</OPTION> 
                   <OPTION value="outpatientPayment_number">门诊收费编号</OPTION>   
                   <option value="outpatientPayment_property">门诊收费性质</option>  
                   <option value="outpatientPayment_object">门诊收费对象</option>    
                   <option value="outpatientPayment_remark">备注</option>     
                   <option value="outpatientPayment_zjm">助记码</option>       
                   </SELECT>
                 </td>
             </tr>
             <tr>
               <td>输入查询数据：</td>
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
										<p style="padding-left:300px"><font color="red">没有门诊收费种类信息！</font></p>
									</td>
								</tr>
				</c:when>
				<c:otherwise>
                          <table border="1" width="750" align="center" cellpadding="0" cellspacing="0">
											<tr align="center" style="background:#CCCCCC">
											  <td>门诊收费种类</td>
											  <td>门诊收费编号</td>
											  <td>门诊收费性质</td>
											  <td>门诊收费对象</td>
											  <td>备注</td>
											  <td>助记码</td>
											  <td></td>
											  <td></td>
											</tr>
                                       <c:forEach items="${pageModel.list}" var="m">
											<tr align="center">
												<td>
													<!-- 门诊收费种类 -->
													<div class="title1">${m.outpatientPayment_name}</div>
												</td>
												<td>
													<!-- 门诊收费编号 -->
													<div class="td1">${m.outpatientPayment_number}</div>
												</td>
												<td>
													<!-- 门诊收费性质 -->
													<div class="td1">${m.outpatientPayment_property}</div>
												</td>
												<td>
												    <!--门诊收费对象  -->
												    <div class="td1">${m.outpatientPayment_object}</div>
												</td>
												<td>
												    <!-- 备注 -->
												    <div class="td1">${m.outpatientPayment_remark}</div>
												</td>
												<td>
												    <!-- 助记码 -->
												    <div class="td1">${m.outpatientPayment_zjm}</div>
												</td>
												<td>
												    <a href="<%=contextPath %>/OutpatientPayment/modify1.action?outpatientPayment_id=${m.outpatientPayment_id}">修改</a>
												</td>
												<td>
												    <a id="deleteOrNot" href="<%=contextPath %>/OutpatientPayment/delete.action?outpatientPayment_id=${m.outpatientPayment_id}">删除</a>
												</td>
											</tr>
								      </c:forEach>
					     </table>
					     
					     <table border="0" width="750" align="center">
										<tr>
										<td align="right">
											总记录数：${pageModel.totalRecords}
											当前${pageModel.currPage}/${pageModel.totalPage}页
											<a href="<%=contextPath %>/OutpatientPayment/add.action?currPage=${pageModel.previousPage}">上一页</a>
											<a href="<%=contextPath %>/OutpatientPayment/add.action?currPage=${pageModel.nextPage}">下一页</a>
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
		confirm("确定删除吗？");
		}
</script>
  
</body>
</html>