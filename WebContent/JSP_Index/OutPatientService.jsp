<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%
String contextPath = request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<script src="../js/prototype.lite.js" type="text/javascript"></script>
<script src="../js/moo.fx.js" type="text/javascript"></script>
<script src="../js/moo.fx.pack.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../cs/style.css">
</head>

<body>
<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top"><div id="container">
      <h1 class="type"><a href="javascript:void(0)">门诊挂号管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="<%=contextPath %>/Register/login.action" target="main">门诊挂号</a></li>
          <li><a href="<%=contextPath %>/JSP_OutPatientService/registerDayEnd.jsp" target="main">门诊挂号日结</a></li>
          <li><a href="<%=contextPath %>/JSP_OutPatientService/RegisterLevel_index.jsp" target="main">门诊级别信息维护</a></li>
          <li><a href="<%=contextPath %>/RegPatient/queryAll.action" target="main">患者信息维护</a></li>
          <li><a href="<%=contextPath %>/Register/queryAll.action" target="main">门诊挂号信息查询</a></li>
          <li><a href="<%=contextPath %>/Register/queryAllDayEnd.action" target="main">门诊日结信息查询</a></li>
          <li><a href="<%=contextPath %>/JSP_OutPatientService/QuitRegisterNo.jsp" target="main">门诊挂号退号</a></li>
          <li><a href="<%=contextPath %>/JSP_OutPatientService/registerFaPiaoBuDa.jsp" target="main">挂号收据补打</a></li>
        </ul>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
      </div>
      <h1 class="type"><a href="javascript:void(0)">门诊收费管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="../JSP_OutPatientService/shouFei.jsp" target="main">划价收费</a></li>
        </ul>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
      </div>
      <h1 class="type"><a href="javascript:void(0)">门诊药房发药管理</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
		  <li><a href="<%=contextPath%>/Prescription/queryAll.action" target="main">医生发药管理</a></li>
          <li><a href="../JSP_OutPatientService/ShowPatientNameDetail" target="main">药房配药管理</a></li>
          <li><a href="../JSP_OutPatientService/FaYaoShowPatientNameDetail" target="main">药房发药管理</a></li>
          <li><a href="../JSP_OutPatientService/ReturnDrug.jsp" target="main">门诊退费(药品)审核管理</a></li>
        </ul>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
      </div>
      
        
      </div>
      
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
        </td>
  </tr>
</table>
</body>
</html>