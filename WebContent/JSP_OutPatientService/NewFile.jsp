<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>jQuery Datepicker Core Demo</title>
		<!-- Include Core Datepicker Stylesheet -->		
		<link rel="stylesheet" href="../cs/ui.datepicker.css" type="text/css" media="screen"  charset="utf-8" />
		<!-- Include jQuery -->
		<script src="../js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>	
		<!-- Include Core Datepicker JavaScript -->
		<script src="../js/jquery.ui.datepicker.js" type="text/javascript" charset="utf-8"></script>	
		<script src="../js/jquery[1]. ui.datepicker-zh-CN.js" type="text/javascript" charset="utf-8"></script>	
		<!-- Attach the datepicker to dateinput after document is ready -->
		<script type="text/javascript" charset="utf-8">
			jQuery(function($){
			$('#datepicker').datepicker({
					yearRange: '1900:2099', //取值范围.
					showOn: 'both', //输入框和图片按钮都可以使用日历控件。
					buttonImage: '../image/CRUD_image/calendar.gif', //日历控件的按钮
					buttonImageOnly: true,
					showButtonPanel: true
				});	
				
			});
		</script>
	</head>
	<body>
		<h1>日历控件DatePicker </h1>
		<p>
			<input type="text" id="datepicker" value="click here to see"/>
		</p>
		


		
	</body>
</html>
