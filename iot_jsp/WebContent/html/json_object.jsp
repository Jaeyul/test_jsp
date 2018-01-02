<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.2.1.js"></script>
</head>
<script>
	var car = {
			wheels : 4,
			engines : 1,
			seats : 5			
	}	

	var str = "";
	for(var key in car){
		str += key + " : " + car[key] + "<br>";
		
	}
	
	
	function test(){
		document.getElementById("result_div").innerHTML += str;		
	}		
</script>
<body onload = test()>
<div id="result_div"></div>
</body>
</html>