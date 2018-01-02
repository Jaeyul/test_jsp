<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String param = request.getParameter("param");
Gson gs = new Gson();
HashMap hm = gs.fromJson(param, HashMap.class);

hm.put("msg", "관련 영화 정보가 없습니다.");
if(hm.get("영화").equals("1987")){
	hm.put("msg", hm.get("1987"));	
}
else if(hm.get("영화").equals("신과함께")){
	hm.put("msg", hm.get("신과함께"));
}
else if(hm.get("영화").equals("겨울왕국")){
	hm.put("msg", hm.get("겨울왕국"));
}

String res = gs.toJson(hm);
out.println(res);

%>