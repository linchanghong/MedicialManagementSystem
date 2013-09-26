<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>HIS3000医疗信息管理系统</title>
<style type="text/css">
body {background: #686868; font-family:Arial, Helvetica, sans-serif; font-size:12px; margin:0px; margin-bottom:2px;border-bottom: 1px #ccc solid;}
h1 {color: #FFF;}
a {color: #FFF; text-decoration: none;/*防止滤镜下链接失效*/position:relative;}
ul { list-style:none;}
#all {width: 100%;}
#banner {margin-top: 8px; margin-left: 32px;}
#main {width: 100%; margin-bottom: 2px; background:#eeeeee; margin-left: 0px; margin-right:0px; height: 30px; color: #000; line-height: 2.4;overflow: auto;}
#main a {color:#000;}
#welcome { float:left; width: 40%; font-weight: 800; padding-left: 8px; position:relative;}
#adminop { float:left; width: 59%; position:relative; text-align:right; line-height:1; *line-height:2.2;}
#adminop ul li {float: right; width: 80px;}
#nav {width: 100%; clear: both;}
#nav ul li {float: right; width:115px; height:25px; line-height: 2.1; text-align: center;}
.inactive { background-image/**/:url(image/nav_bg_inactive2.png) !important;background: none; margin-left: 2px; margin-right:2px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=image/nav_bg_inactive2.png);}
.inactive a {color: #000;}
.active {width:115px; height:25px;background:url(image/nav_bg_active2.png) !important;background: none; margin-left: 2px; margin-right:2px;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=image/nav_bg_active2.png);}
.active a {color:#fff;}
.blankgray {background:#bbb; height:2px; width:100%; margin:0; padding:0; clear:both; font-size:2px;}
</style>
<script type="text/javascript" language="javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box', 'school', 'config', 'other');
$(document).ready(function() {
	$('#nav').find("a").click(function() {
		var id = $(this).attr('id');
		$.each(oplist, function(i, n) {
			$('#'+n).attr('class', 'inactive');
		});
		$(this).parents("li").attr('class', 'active');
	});
});
</script>
</head>

<body>
<div id="all">
	<div id="banner"><h1>HIS3000医疗信息管理系统</h1></div>
    <div id="nav">
    	<ul>
            <li class="inactive" id="about"><a href="JSP_Index/PharmacyInfoManagement.jsp" target="leftFrame">药房信息管理系统</a></li>
            <li class="inactive" id="user"><a href="JSP_Index/InPatientManagement.jsp" target="leftFrame">住院信息管理系统</a></li>
            <li class="inactive" id="news"><a href="JSP_Index/DrugStorageManagement.jsp" target="leftFrame">药库信息管理系统</a></li>
            <li class="inactive" id="mars"><a href="JSP_Index/MedicalRecordManage.jsp" target="leftFrame">病案信息管理系统</a></li>
            <li class="inactive" id="jielong"><a href="JSP_Index/NurseStationManagement.jsp" target="leftFrame">护士工作站</a></li>
            <li class="inactive" id="school"><a href="JSP_Index/HealthMaterialsInfoManagement.jsp" target="leftFrame">卫材信息管理系统</a></li>
            <li class="inactive" id="other"><a href="JSP_Index/OutPatientService.jsp" target="leftFrame">门诊管理系统</a></li>
            <li class="active"   id="config"><a href="JSP_Index/BasicInfoMain.jsp" target="leftFrame">基础信息管理系统</a></li>
        </ul>
    </div>
</div>
</body>
</html>