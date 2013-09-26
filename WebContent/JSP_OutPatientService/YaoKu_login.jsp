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
<LINK 
href="../cs/login_cs/Default.css" type=text/css rel=stylesheet><LINK 
href="../cs/login_cs/xtree.css" type=text/css rel=stylesheet><LINK 
href="../cs/login_cs/User_Login.css" type=text/css rel=stylesheet>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR></HEAD>
<BODY id=userlogin_body>
<DIV></DIV>

<DIV id=user_login>
<DL>
  <DD id=user_top>
  <UL>
    <LI class=user_top_l></LI>
    <LI class=user_top_c></LI>
    <LI class=user_top_r></LI></UL>
  <DD id=user_main>
  <UL>
  <li><form action="<%=contextPath %>/Register/processLogin.action">
    <LI class=user_main_l></LI>
    <LI class=user_main_c>
      <DIV class=user_main_box>
        <UL>
        
         <LI class=user_main_text>用户名： </LI>
         <LI class=user_main_input><INPUT class=TxtUserNameCssClass id=TxtUserName type="text" maxLength=20 name=userName></LI>
        </UL>
        <UL>
         <LI class=user_main_text>密 码： </LI>
         <LI class=user_main_input><INPUT class=TxtPasswordCssClass id=TxtPassword type=password name=password></LI>
        </UL>
      </DIV>
    </LI>
    <LI class=user_main_r>
      
      <INPUT type="submit" value="" class=IbtnEnterCssClass id=IbtnEnter style="background-image:url(../image/login_image/user_botton.gif);BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"  name=IbtnEnter> 
      
    </LI>
    </form></li>
  </UL>
    <DD id=user_bottom>
  <UL>
    <LI class=user_bottom_l></LI>
    <LI class=user_bottom_c><SPAN style="MARGIN-TOP: 40px"></SPAN> </LI>
    <LI class=user_bottom_r></LI></UL></DD></DL></DIV><SPAN id=ValrUserName 
style="DISPLAY: none; COLOR: red"></SPAN><SPAN id=ValrPassword 
style="DISPLAY: none; COLOR: red"></SPAN><SPAN id=ValrValidateCode 
style="DISPLAY: none; COLOR: red"></SPAN>
<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

<DIV></DIV>

</BODY>
</html>