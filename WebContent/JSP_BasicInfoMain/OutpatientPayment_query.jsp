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
   <h4 align="center">门诊收费种类信息查询</h4>
          <c:choose>
                 <c:when test="${empty list}">
								<tr>
									<td align="center">
										<p style="padding-left:300px"><font color="red">未查询到你想要的信息!</font></p>
									</td>
								</tr>
				 </c:when>
		         <c:otherwise>
                    <table border=1 align=center width="750" align="center" cellpadding="0" cellspacing="0">
                       <tr align=center style="background:#CCCCCC">
                          <td>门诊收费名称：</td>
                          <td>门诊收费编号：</td>
                          <td>门诊收费性质：</td>
                          <td>门诊收费对象：</td>
                          <td>备注：</td>
                          <td>助记码：</td>
                       </tr>
                       <tr align=center>
                           <c:forEach items="${list}" var="list">
                           <tr align=center>
                              <td>${list.outpatientPayment_name}</td>
                              <td>${list.outpatientPayment_number}</td>
                              <td>${list.outpatientPayment_property}</td>
                              <td>${list.outpatientPayment_object}</td>
                              <td>${list.outpatientPayment_remark}</td>
                              <td>${list.outpatientPayment_zjm}</td>
                              <td>
								<a href="<%=contextPath %>/OutpatientPayment/modify1.action?outpatientPayment_id=${list.outpatientPayment_id}">修改</a>
							  </td>
							  <td>
							    <a id="deleteOrNot" href="<%=contextPath %>/OutpatientPayment/delete.action?outpatientPayment_id=${list.outpatientPayment_id}">删除</a>
							  </td>
                          </tr>
                          </c:forEach>
                      </tr>
                    </table>
                  </c:otherwise>
              </c:choose>
              <p align="center"><a href="<%=contextPath %>/OutpatientPayment/queryAll.action">返回</a></p>
   
</body>
</html>