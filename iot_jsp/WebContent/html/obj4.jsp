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

	function callback(res){
		alert(res);	
		var obj = JSON.parse(res);
		alert(obj.msg);
		
	}

	function checkValue(){
		var user = {
				id : document.getElementById("id").value,
				pwd : document.getElementById("pwd").value,
				name : document.getElementById("name").value				
		}		
		/*for(var key in user){
			console.log(key + " : " + user[key]);			
		}*/
		
		var data = "param=" + encodeURIComponent(JSON.stringify(user));
		alert(data);	
		
		
		$.ajax({
			url : "./test.jsp",
			data : data,
			type : "get",
			success : callback,
			error : function(xhr, status, error){
				$("#result_div").html(xhr.responseText);				
			}			
		})		
	}
	
	
	

</script>
<body>
<div id="result_div"></div>
	Id = <input type="text" id="id"><br>
	Password = <input type="text" id="pwd"><br>
	Name = <input type="text" id="name"><br>
	<input type="button" value="값 확인" onclick="checkValue()">
</body>
</html>