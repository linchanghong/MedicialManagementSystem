<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--ÒýÈëjqueryÀà¿âÎÄ¼þ-->  
<script type="text/javascript" language="javascript" src="../js/jquery-1.3.2.min.js"></script>  
<script type="text/javascript" language="javascript" src="../js/jquery-ui-1.8.16.custom.min.js"></script>  
<script type="text/javascript" language="javascript" src="../js/jquery[1].ui.datepicker-zh-CN.js"></script>  
  
<!--css-->  
<link type="text/css" rel="stylesheet" href="../cs/jquery-ui-1.10.3.custom.css" /> 
<script type="text/javascript" charset="utf-8">
			jQuery(function($){
			$('#datepicker').datepicker({
					yearRange: '1900:2099', //È¡Öµ·¶Î§.
					showOn: 'both', //ÊäÈë¿òºÍÍ¼Æ¬°´Å¥¶¼¿ÉÒÔÊ¹ÓÃÈÕÀú¿Ø¼þ¡£
					buttonImage: '../image/CRUD_image/calendar.gif', //ÈÕÀú¿Ø¼þµÄ°´Å¥
					buttonImageOnly: true,
					showButtonPanel: true
				});	
				
			});
		</script>
	</head>
	<body>
		<h1>ÈÕÀú¿Ø¼þDatePicker </h1>
		<p>
			<input type="text" id="datepicker" value="click here to see">
		</p>
		


		
	</body>
</html>