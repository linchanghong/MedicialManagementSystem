<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>½û¼ÉÒ©Æ·´îÅäÐÅÏ¢</title>
<style type="text/css">
   table.border{
      border-top:#000 1px solid;
      border-left:#000 1px solid;
   }
   table.border td{
      border-bottom:#000 1px solid;
      border-right:#000 1px solid;
   }
   div#header {
   background-color:#99bbbb;
   text-align:center;
                
   }
   div.content {
   
   }
   
</style>
</head>
<body>
<div>
 <a href="<%=contextPath %>/JSP_BasicInfoMain/IncompateInfo_save.jsp">ÅäÎé½û¼ÉÐÅÏ¢±£´æ</a>
</div>
<div>
        <form action="<%=contextPath %>/Icom/conditionQuery.action" method="post">
        <h4>²éÑ¯»òÉ¾³ýÌõ¼þ</h4>
        <!-- <p style="padding-left:650px"><input type="button" id="new" style="background-image:url(../image/CRUD_image/add.png);width: 100px; height: 23px"></p> -->
           <table style="padding-left:100px" >
           
             <tr>
               <td>Ñ¡ÔñÌõ¼þ£º</td>
               <td><SELECT style="WIDTH: 100px;height:20px" name="queryType"> 
                   <OPTION selected value="incompatibility_id">±àÂë</OPTION> 
                   <OPTION value="incompatibility_drugA">Ò©Æ·Ãû³Æ</OPTION>
                   <OPTION value="incompatibility_drugB">½û´îÒ©Æ·Ãû³Æ</OPTION> 
                   </SELECT>
                   </td>
             </tr>
             <tr>
               <td>ÊäÈëÏà¹ØÊý¾Ý£º</td>
               <td><input type="text" name="queryData"></td>
               <td><input type="submit" value="" id="query" style="background-image:url(../image/CRUD_image/query1.png);width: 100px; height: 30px"></td>
             </tr>
             <!--  <tr>
               
               <td><input type="submit" value="" id="delete" style="background-image:url(../image/CRUD_image/delete.png);width: 100px; height: 30px"></td>
             </tr>-->
             
             <tr><td><div  style=" display:none" >
             <c:choose>
                 <c:when test="${empty list }">
                    <tr>
                         <td colspan="4">
                              <p align=center><font color="red">Ã»ÓÐÏà¹ØÐÅÏ¢ÐÅÏ¢!</font></p>
                         </td>
                    </tr>
                 </c:when>
                 <c:otherwise>
                    <tr style="background:#CCCCCC">
                         <td width="" align="center">
                                                                            Ò©Æ·±àºÅ
                         </td>
                         <td width="" align="center">
                                                                             Ò©Æ·Ãû³Æ
                         </td>
                         <td width="" align="center">
                                                                             ½û¼ÉÒ©Æ·Ãû³Æ
                         </td>
                         <td width="" align="center">
                                                                              ÅäÎé½á¹û
                         </td>
                         <td>
                                                                              ²Ù×÷
                         </td>
                    </tr>
                   <c:forEach items="${list}" var="l">
                    <tr>
                      <td width="" align="center">
                         ${l.incompatibility_id}
                      </td>
                      <td width="" align="center"> 
                         ${l.incompatibility_drugA}
                      </td>
                      <td width="" align="center"> 
                         ${l.incompatibility_drugB}
                      </td>
                      <td width="" align="center"> 
                         ${l.incompatibility_result}
                      </td>
                      <!--  <td width="15">
                         <input type="checkbox" name="delCheck" value="${m.incompatibility_drugA}" >
                      </td>-->
                      <td>
                          <input type="button" value="" id="delete" onclick="window.location.href='<%=contextPath %>/Icom/delete.action?incompatibility_id=${l.incompatibility_id}';"
                               style="background-image:url(../image/CRUD_image/delete.png);width: 80px; height: 25px">
                      </td>
                      <td>
                          <input type="button" width="100" value=" " id="modify" onclick="window.location.href='<%=contextPath %>/Icom/getModInfo.action?incompatibility_id=${l.incompatibility_id}';"
                                style="background-image:url(../image/CRUD_image/modify1.png);width: 80px; height: 25px">
                      </td>
                 </tr>
                 </c:forEach>
                 </c:otherwise>
             </c:choose>
             </div></td></tr>
           </table>
        </form>
      </div>
      
      <div id="showDetails">
      
      
          <c:choose>
                 <c:when test="${empty pageModel.list}">
								
			 	<p align="center"><font color="red">Ã»ÓÐÅäÎé½û¼ÉÐÅÏ¢!</font></p>
								
				</c:when>
				<c:otherwise>
				<div id="header"><h1>
                                                ½ûÅäÒ©Æ·´îÅä±í
                 </h1></div>
                 <div class="content">
	<table class="border" align="center" border="0" cellspacing="0" width="800">
      
      <tr style="background:#CCCCCC">
         <td width="" align="center">
                                Ò©Æ·±àºÅ
         </td>
         <td width="" align="center">
                                 Ò©Æ·Ãû³Æ
         </td>
         <td width="" align="center">
                                 ½û¼ÉÒ©Æ·Ãû³Æ
         </td>
         <td width="" align="center">
                                  ÅäÎé½á¹û
         </td>
         <td>
                                  É¾³ý
         </td>
         <td>
                                   ÐÞ¸Ä
         </td>
      </tr>
     <c:forEach items="${pageModel.list}" var="m">
         <tr>
             <td width="" align="center">
                 ${m.incompatibility_id}
             </td>
             <td width="" align="center"> 
                 ${m.incompatibility_drugA}
             </td>
             <td width="" align="center"> 
                 ${m.incompatibility_drugB}
             </td>
             <td width="" align="center"> 
                 ${m.incompatibility_result}
             </td>
             <td>
                <input type="button" value="" id="deleteMore" onclick="window.location.href='<%=contextPath %>/Icom/delete.action?incompatibility_id=${m.incompatibility_id}';"
                               style="background-image:url(../image/CRUD_image/delete.png);width: 80px; height: 25px">
             </td>
             <td>
                <input type="button" value="" id="modifyMore" onclick="window.location.href='<%=contextPath %>/Icom/getModInfo.action?incompatibility_id=${m.incompatibility_id}';"
                               style="background-image:url(../image/CRUD_image/modify1.png);width: 80px; height: 25px">
             </td>
         </tr>
     </c:forEach> 
     </table> 
     </div>
      </c:otherwise>
</c:choose>  
   
  
   
   <table border="0" width="750" align="center">
	   <tr>
		  <td align="right">
		       ×Ü¼ÇÂ¼Êý£º${pageModel.totalRecords}
		        µ±Ç°${pageModel.currPage}/${pageModel.totalPage}Ò³
		   <a href="<%=contextPath %>/Icom/query.action?currPage=${pageModel.previousPage}">ÉÏÒ»Ò³</a>
		   <a href="<%=contextPath %>/Icom/query.action?currPage=${pageModel.nextPage}">ÏÂÒ»Ò³</a>
		   <select id="currpage" onchange="changePage()">
			   <c:forEach begin="1" end="${pageModel.totalPage}" varStatus="vs">
			   <c:choose>
			      <c:when test="${pageModel.currPage ne vs.count}">
						<option value="${vs.count}">
							µÚ${vs.count}Ò³
					    </option>
				  </c:when>
			      <c:otherwise>
			            <option value="${vs.count}" selected="selected">
							µÚ${vs.count}Ò³
						</option>
				  </c:otherwise>
			   </c:choose>
			   </c:forEach>
		  </select>
		</td>
	</tr>
</table>
</div>
<script type="text/javascript">
	
	
	function changePage() {
		var currPage = document.getElementById("currpage").value;
		window.self.location = "<%=contextPath %>/DoctorInfo/add.action?currPage="
				+ currPage;
	}
	
</script>
</body>
</html>