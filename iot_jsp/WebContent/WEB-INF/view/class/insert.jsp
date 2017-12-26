<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>클래스입력</title>
</head>
<body>
<form action="/class/insertok">
<table border="1">
	<tr>
		<td>반이름</td>
		<td><input type="text" name="ciname" id="ciname"></td>
	</tr>		
	<tr>
		<td>상세정보</td>
		<td><input type="text" name="cidesc" id="cidesc"></td>
	</tr>	
	<tr>
		<td colspan="2"><input type="submit" value="클래스개설"></td>
	</tr>
</table>
</form>	
</body>
</html>