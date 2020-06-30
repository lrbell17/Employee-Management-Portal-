<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>	Login</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<style>
	
		body {
			margin: 50px 50px;
		}
	</style>
</head>
<body>
	
	<!-- include header file -->
	<%@ include file="header.jsp" %> <br><br>
	
	<h4> Login:</h4>	
	<form method ="post" action="useradd.html">

		<br>
		<div class="form-group">
			<label for="exampleInputEmail1">Username</label> <input
					type="text" class="form-control" 
					name="uname" placeholder="Username">
		</div>
		<br>
		
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name="pass"
					placeholder="Password">
		</div>
		<br/>
		
		<button type="submit" class="btn btn-outline-primary">Login</button>
	</form>
	
	<br><br>
	<!-- inclue footer file -->
	<%@ include file="footer.jsp" %> <br><br>
		
</body>
</html>