<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("userId");
String pwd = request.getParameter("userPwd");
String msg = "test님의 로그인이 성공하셨습니다.";
//String name = request.getParameter("userName");
//int age = Integer.parseInt(request.getParameter("userAge"));
//out.println("<br>User Id : " + id);
//out.println("<br>User Password : " + pwd);
//out.println("<br>User name : " + name);
//out.println("<br>User age : " + age);
if(id.equals("test")){
	if(!pwd.equals("1234")){
		msg = "비밀번호를 확인하세요";		
	}	
}else{
	msg= "아이디가 틀렸습니다.";
}
out.println(msg);
%>
</body>
</html>