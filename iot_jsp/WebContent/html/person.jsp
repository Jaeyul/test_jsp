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
	var no = 0;
	function clickme(){		
		
		var param = "no=" + no; 
		$.ajax({
			url : "./exam.jsp",
			data : param,
			type : "get",
			success : function(res){				
				$("#result_div").append(res);				
			},
			error : function(xhr, status, error){
				$("#result_div").html(xhr.responseText);				
			}			
		})		
		
		
		
	}



</script>
<body>
<input type="button" value="눌러 주세요" onclick="clickme()">
<div id="result_div"></div>


</body>
</html>