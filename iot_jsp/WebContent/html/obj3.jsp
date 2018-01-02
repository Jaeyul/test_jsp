<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var obj = {
			func1 : function(res){
				alert(res);
			},
			func2 : function(res){
				alert(res);
			}			
	}
	
	var func = function(obj){
		this.callAllFunc = function(){
			obj.func1("ㅋㅋㅋ");
			obj.func2("ㄲㄲㄲ");			
		}		
	}	
	
	var f = new func(obj);
	f.callAllFunc();
	
	var Car = function(params){
		this.wheels = params.wheels;
		this.engines = params.engines;
		this.seats = params.seats;		
	}
	
	params = {
			wheels : 1,
			engines : 2,
			seats : 3			
	}
	
	var c = new Car(params);
	alert(c.wheels);
	
	
	
</script>
<body>

</body>
</html>