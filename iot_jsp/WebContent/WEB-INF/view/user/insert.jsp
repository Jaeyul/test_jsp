<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저입력</title>
</head>
<body>
<form action="/user/insertok">
<table border="1">
	<tr>
		<td>이름</td>
		<td><input type="text" name="uiname" id="uiname"></td>
	</tr>		
	<tr>
		<td>나이</td>
		<td><input type="text" name="uiage" id="uiage"></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="uiid" id="uiid"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="uipwd" id="uipwd"></td>
	</tr>
	
	<tr>
		<td>주소</td>
		<td><input type="text" name="address" id="address"></td>
	</tr>
	<tr>
		<td>부서</td>
		<td><input type="text" name="cino" id="cino"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="회원가입"></td>
	</tr>
</table>
</form>	
</body>
</html>