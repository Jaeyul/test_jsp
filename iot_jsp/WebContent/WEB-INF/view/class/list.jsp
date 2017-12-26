<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>클래스 리스트</title>
</head>
<body>
<%
ArrayList<HashMap<String, Object>> classList = null;
classList = (ArrayList<HashMap<String, Object>>)request.getAttribute("list");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>반이름</th>
		<th>상세정보</th>		
	</tr>
<%
for(HashMap<String, Object> hm : classList){
%>
	<tr>
		<td><%=hm.get("cino") %></td>
		<td><%=hm.get("ciname") %></td>
		<td><%=hm.get("cidesc") %></td>	
	</tr>
<%
}
%>
</table>

<a href="/class/insert">클래스생성</a>
<a href="/class/delete">클래스삭제</a>
<a href="/class/update">클래스수정</a>
<br>
<a href="/">처음으로</a>
</body>
</html>