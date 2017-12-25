<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user/deleteok">
<table border="1">
	<tr>
		<td>번호</td>
		<td><input type="text" name="uino" id="uino"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="삭제"></td>
	</tr>					
</table>
</form>
</body>
</html>