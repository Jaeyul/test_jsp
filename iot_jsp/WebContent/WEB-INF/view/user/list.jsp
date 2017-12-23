<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유저 리스트</title>
</head>
<body>
<%
ArrayList<HashMap<String, Object>> userList = null;
userList = (ArrayList<HashMap<String, Object>>)request.getAttribute("list");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>부서번호</th>
		<th>가입일자</th>
		<th>주소</th>
	</tr>
<%
for(HashMap<String, Object> hm : userList){
%>
	<tr>
		<td><%=hm.get("uino") %></td>
		<td><%=hm.get("uiname") %></td>
		<td><%=hm.get("uiage") %></td>
		<td><%=hm.get("uiid") %></td>
		<td><%=hm.get("uipwd") %></td>
		<td><%=hm.get("cino") %></td>
		<td><%=hm.get("uiregdate") %></td>
		<td><%=hm.get("address") %></td>
	</tr>
<%
}
%>
</table>
</body>
</html>