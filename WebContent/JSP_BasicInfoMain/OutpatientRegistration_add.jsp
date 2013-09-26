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
</head>
<h4>新建门诊挂号种类</h4>
<body>
     <form action="<%=contextPath %>/OutpatientRegistration/add.action" method="post" >
       <table align=center>
         <tr>
           <td>门诊挂号名称：</td>
           <td><input type="text" name="outpatientRegistration_name" ></td>
         </tr>
         <tr>
           <td>门诊挂号编号：</td>
           <td><input type="text" name="outpatientRegistration_number" onblur="checkNumber(this.value)"><span id="msg"></span></td>
         </tr>
         <tr>
           <td>门诊挂号价格：</td>
           <td><input type="text" name="outpatientRegistration_price"></td>
         </tr>
         <tr>
          <tr>
           <td>助记码：</td>
           <td><input type="text" name="outpatientRegistration_zjm"></input></td>
         </tr>
         <tr>
           <td><input type="submit" value="" style="background-image:url(../image/CRUD_image/save1.png);width: 100px; height: 26px"></td>
           <td><input type="reset" value="" style="background-image:url(../image/CRUD_image/Reset.png);width: 100px; height: 26px"></td>
         </tr>
       </table>
     </form>
     <script language="JavaScript">  
    var xmlHttp;  
    var flag;  
    function createXMLHttp(){  
        if (window.XMLHttpRequest){                     // 创建XMLHttpRequest核心对象  
            xmlHttp = new XMLHttpRequest();                  // 使用FireFox内核  
        }else {  
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");   // 使用IE内核的浏览器  
        }  
    }  
  
    function checkNumber(number){       // 显示信息  
        createXMLHttp();    //  
        // 设置请求,通过地址重写方式将userid传递到JSP中  
          
        xmlHttp.open("POST","<%=contextPath %>/OutpatientRegistration/isInput.action?outpatientRegistration_number="+number);  
        // 设置完请求后调用处理回调函数  
        xmlHttp.onreadystatechange = checkUseridCallback;  
        xmlHttp.send(null); // 发送请求，不设置参数  
       // document.getElementById("msg").innerHTML = "正在验证……";  
                //alert("*******");  
  
    }  
  
    function checkUseridCallback(){ // 回调函数  
        if (xmlHttp.readyState == 4){           // 数据返回完毕  
            if (xmlHttp.status == 200){         // HTTP操作正常  
                //alert("*****8");  
                var text = xmlHttp.responseText;// 接收返回内容  
                if (text == "true"){  
                    flag = false;               // 无法提交表单  
                    document.getElementById("msg").innerHTML = "门诊挂号编号重复，无法使用";  
                }else {  
                    flag = true;                // 可以提交表单  
                    document.getElementById("msg").innerHTML = "恭喜！此编号可以使用";  
                }  
            }  
        }  
    }  
  
    function checkForm(){   // 对表单判断能否进行提交操作  
        return flag;  
    }  
</script>  
</body>
</html>