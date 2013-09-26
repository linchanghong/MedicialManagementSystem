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
      <h1 class="type"><a href="javascript:void(0)">收费基础信息</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="../JSP_BasicInfoMain/show" target="main">收费明细项目</a></li>
          <li><a href="<%=contextPath %>/OutpatientPayment/queryAll.action" target="main">门诊收费种类</a></li>
          <li><a href="<%=contextPath %>/OutpatientRegistration/queryAll.action" target="main">门诊挂号种类</a></li>
          <li><a href="../JSP_BasicInfoMain/showCAccounting" target="main">组合划价项目</a></li>
        </ul>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
      </div>
      <h1 class="type"><a href="javascript:void(0)">人员基础信息</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="<%=contextPath %>/DoctorInfo/queryAll.action" target="main">医生信息维护</a></li>
          <li><a href="<%=contextPath %>/LoginMaintain/queryAll.action" target="main">登录用户维护</a></li>
        </ul>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
      </div>
      <h1 class="type"><a href="javascript:void(0)">药品信息维护</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="<%=contextPath %>/DrugInfo/druginfo_queryAll" target="main">药品信息维护</a></li>
		  <li><a href="../JSP_BasicInfoMain/DrugCategory_index.jsp" target="main">药品分类维护</a></li>
          <li><a href="<%=contextPath %>/DrugCode/drugcode_queryAll" target="main">药品编码维护</a></li>
          <li><a href="../JSP_BasicInfoMain/Supplier_index.jsp" target="main">供应商信息</a></li>
          <li><a href="<%=contextPath %>/DrugManuf/queryAll.action" target="main">药品生产厂商信息</a></li>
          <li><a href="<%=contextPath%>/CiphPres/queryAll.action" target="main">协定处方信息</a></li>
          <li><a href="<%=contextPath %>/Icom/query.action" target="main">配伍禁忌药品维护</a></li>
        </ul>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
      </div>
      <h1 class="type"><a href="javascript:void(0)">临床基础信息</a></h1>
      <div class="content">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="../image/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="<%=contextPath %>/DeptInfo/queryAll.action" target="main">科室信息维护</a></li>
          <li><a href="<%=contextPath %>/BedInfo/queryAll.action" target="main">床位信息设置</a></li>
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