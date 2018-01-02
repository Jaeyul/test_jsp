<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String param = request.getParameter("param");
Gson gs = new Gson();
HashMap hm = gs.fromJson(param, HashMap.class);
/*System.out.println(hm);
System.out.println(hm.get("id"));
System.out.println(hm.get("pwd"));
System.out.println(hm.get("name"));
hm.put("id","이건 서버에서 바꾼값");
out.println(gs.toJson(hm));
out.println(param);*/

hm.put("msg","로그인 성공!");
if(hm.get("id").equals("test")){
	if(!hm.get("pwd").equals("1234")){
		hm.put("msg", "비밀번호를 확인하세요");
	}	
}else{
	hm.put("msg", "아이디를 확인하세요.");
}

String res = gs.toJson(hm);
out.println(res);


%>



   