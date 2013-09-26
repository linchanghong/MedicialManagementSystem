<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
        <td>
        病人姓名：<input id="name"></input>
        </td>
        <td>
        病人性别：<input id="gender"></input>
        </td>
        <td>
        病人年龄：<input id="age"></input>
        </td>
    </tr>
    <tr>
        <td>
        住院诊断：<input id="diagnosis"></input>
        </td>
        <td>
        身份证：<input id="idnumber"></input>
        </td>
        <td>
        住院日期：<input id="date" type="text" onClick="WdatePicker()"></input>
        </td>
    </tr>
    <tr>
        <td>
        科室：
        </td>
    </tr>
</table>
</body>
</html>