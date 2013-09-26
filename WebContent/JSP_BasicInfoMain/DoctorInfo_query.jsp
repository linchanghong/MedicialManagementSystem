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
   <h4 align="center">科室信息查询</h4>
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
                          <td>医生名</td>
                          <td>医生年龄</td>
                          <td>医生性别</td>
                          <td>所属科室</td>
                          <td>科室编码</td>
                          <td>科室助记码</td>
                          <td></td>
                          <td></td>
                       </tr>
                       <c:forEach items="${list}" var="list">
                       <tr align=center>
                              
                              <td>${list.doctorInfo_name}</td>
                              <td>${list.doctorInfo_age}</td>
                              <td>${list.doctorInfo_sex}</td>
                              <td>${list.deptInfo.deptInfo_name}</td>
                              <td>${list.deptInfo.deptInfo_number}</td>
                              <td>${list.deptInfo.deptInfo_zjm}</td>
                              <td>
			                      <a href="<%=contextPath %>/DoctorInfo/modify1.action?doctorInfo_id=${list.doctorInfo_id}">修改</a>
							  </td>
							  <td>
								  <a id="deleteOrNot" href="<%=contextPath %>/DoctorInfo/delete.action?doctorInfo_id=${list.doctorInfo_id}">删除</a>
							  </td>
                      </tr>
                      </c:forEach>
                    </table>
                  </c:otherwise>
              </c:choose>
              <p align="center"><a href="<%=contextPath %>/DoctorInfo/queryAll.action">返回</a></p>
   <script type="text/javascript">
	document.getElementById("deleteOrNot").onclick=function(){
		if(confirm("确定删除吗？"))
			return true;
		else
			return false ;
		}
</script>
</body>
</html>