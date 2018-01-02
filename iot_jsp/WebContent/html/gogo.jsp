<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="/js/jquery-3.2.1.js"></script>
<script>



function getMovie(){
	
	
	var arr = {
			"1987" : "김윤석",
			"신과함께" : "하정우",
			"겨울왕국" : "엘사"	,
			"영화" : document.getElementById("actor").value		
	}
		
	
	var data = "param=" + encodeURIComponent(JSON.stringify(arr));
	
	$.ajax({
		url : "./actorarr.jsp",
		data : data,
		type : "get",
		success : function(res){
			var obj = JSON.parse(res);
			alert(obj.msg);
		},
		error : function(xhr, status, error){
			$("#result_div").html(xhr.responseText);				
		}			
	})		
	
	
}

</script>
<body>
<div id="result_div"></div>
영화 제목 : <input type="text" id="actor">
<input type="button" value="눌러주세용" onclick="getMovie()">

</body>
</html>