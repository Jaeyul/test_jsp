<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	var AjaxObj = function(params){
		this.url = params.url;		
		this.val = function(){
			alert("유효성검사 함수");			
		}
		this.send = function(){
			alert(this.url + "로 ajax 전송 함수");
			this.callback("파라미터를 넣어랑");
		}
		
		this.callback = params.func;
	}
		
	
	var func = function(res){
		alert(res);
	}		
	var params = {url : './test.jsp', func : func};	
	var ao = new AjaxObj(params);	
	ao.send();
	
	//ao.callback();
	
	
	
	

</script>
</body>
</html>