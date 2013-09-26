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
<meta http-equiv="Content-Ty
pe" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <h4 align="center">生产商信息查询</h4>
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
                          <td>生产商编码</td>
						  <td>生产商名称</td>
						  <td>生产商助记码</td>
						   <td>生产商地址</td>
					       <td>生产商邮编</td>
							<td>生产商电话</td>
							<td>生产商传真</td>
							<td>生产商联系人</td>
							<td></td>
							<td></td>
                       </tr>
                       <tr align=center>
                           <c:forEach items="${list}" var="list">
                              <td>${list.drugManuf_number}</td>
                              <td>${list.drugManuf_name}</td>
                              <td>${list.drugManuf_zjm}</td>
                              <td>${list.drugManuf_address}</td>
                              <td>${list.drugManuf_postcode}</td>
                              <td>${list.drugManuf_telephone}</td>
                              <td>${list.drugManuf_fax}</td>
                              <td>${list.drugManuf_linkman}</td>
                              <td>
								 <a href="<%=contextPath %>/DrugManuf/modify1.action?drugManuf_id=${list.drugManuf_id}">修改</a>
							  </td>
							  <td>
								 <a id="deleteOrNot" href="<%=contextPath %>/DrugManuf/delete.action?drugManuf_id=${list.drugManuf_id}">删除</a>
							  </td>
                          </c:forEach>
                      </tr>
                    </table>
                  </c:otherwise>
              </c:choose>
              <p align="center"><a href="<%=contextPath %>/DrugManuf/queryAll.action">返回</a></p>
   
</body>
</html>