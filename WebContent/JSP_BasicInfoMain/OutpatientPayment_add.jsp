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
<h4>�½������շ�����</h4>
<body>
     <form action="<%=contextPath %>/OutpatientPayment/add.action" method="post" >
       <table align=center>
         <tr>
           <td>�����շ����ƣ�</td>
           <td><input type="text" name="outpatientPayment_name" ></td>
         </tr>
         <tr>
           <td>�����շѱ��룺</td>
           <td><input type="text" name="outpatientPayment_number" onblur="checkNumber(this.value)"><span id="msg"></span></td>
         </tr>
         <tr>
           <td>�����շ����ʣ�</td>
           <td><input type="text" name="outpatientPayment_property"></td>
         </tr>
         <tr>
           <td>�����շѶ���</td>
           <td><input type="text" name="outpatientPayment_object"></input></td>
         </tr>
         <tr>
           <td>��ע��</td>
           <td><input type="text" name="outpatientPayment_remark"></input></td>
         </tr>
         <tr>
          <tr>
           <td>�����룺</td>
           <td><input type="text" name="outpatientPayment_zjm"></input></td>
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
        if (window.XMLHttpRequest){                     // ����XMLHttpRequest���Ķ���  
            xmlHttp = new XMLHttpRequest();                  // ʹ��FireFox�ں�  
        }else {  
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");   // ʹ��IE�ں˵������  
        }  
    }  
  
    function checkNumber(number){       // ��ʾ��Ϣ  
        createXMLHttp();    //  
        // ��������,ͨ����ַ��д��ʽ��userid���ݵ�JSP��  
          
        xmlHttp.open("POST","<%=contextPath %>/OutpatientPayment/isInput.action?outpatientPayment_number="+number);  
        // �������������ô����ص�����  
        xmlHttp.onreadystatechange = checkUseridCallback;  
        xmlHttp.send(null); // �������󣬲����ò���  
       // document.getElementById("msg").innerHTML = "������֤����";  
                //alert("*******");  
  
    }  
  
    function checkUseridCallback(){ // �ص�����  
        if (xmlHttp.readyState == 4){           // ���ݷ������  
            if (xmlHttp.status == 200){         // HTTP��������  
                //alert("*****8");  
                var text = xmlHttp.responseText;// ���շ�������  
                if (text == "true"){  
                    flag = false;               // �޷��ύ����  
                    document.getElementById("msg").innerHTML = "�������ظ����޷�ʹ��";  
                }else {  
                    flag = true;                // �����ύ����  
                    document.getElementById("msg").innerHTML = "��ϲ�����û�������ע��";  
                }  
            }  
        }  
    }  
  
    function checkForm(){   // �Ա����ж��ܷ�����ύ����  
        return flag;  
    }  
</script>  
</body>
</html>