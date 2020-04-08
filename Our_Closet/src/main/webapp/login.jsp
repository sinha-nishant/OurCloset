<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Our Closet Login</title>
	<meta charset="UTF-8">
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1">
===============================================================================================	
	<link rel="icon" type="image/png" href="loginStyle/images/icons/favicon.ico"/>
===============================================================================================
	<link rel="stylesheet" type="text/css" href="loginStyle/vendor/bootstrap/css/bootstrap.min.css">
===============================================================================================
	<link rel="stylesheet" type="text/css" href="loginStyle/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
===============================================================================================
	<link rel="stylesheet" type="text/css" href="loginStyle/vendor/animate/animate.css">
===============================================================================================	
	<link rel="stylesheet" type="text/css" href="loginStyle/vendor/css-hamburgers/hamburgers.min.css">
===============================================================================================
	<link rel="stylesheet" type="text/css" href="loginStyle/vendor/select2/select2.min.css">
===============================================================================================
	<link rel="stylesheet" type="text/css" href="loginStyle/css/util.css">
	<link rel="stylesheet" type="text/css" href="loginStyle/css/main.css">
=============================================================================================== -->
</head>
<body>

	<h1>Member Login</h1>
	<form action="closet_login" method="post">
		<table>
			<tr>
				<td><input type="email" name="uscEmail" placeholder="USC Email"></td>
			</tr>
			<tr>
				<td><input type="password" name="pass" placeholder="Password"></td>
			</tr>
			<tr>
				<td><button type="submit" value="Login">Log in</button></td>
			</tr>
		</table>
	
	</form>
	<div>${errorMessage}</div>
	
	<%-- 
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="loginStyle/images/img-01.png" alt="IMG">
				</div>

				<form action="closet_login" method="post" class="login100-form validate-form">
					<span class="login100-form-title">
						Member Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="uscEmail" placeholder="USC Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div>${errorMessage}</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit" value="Login">
							Login
						</button>
					</div>


					<div class="text-center p-t-136">
						<a class="txt2" href="../register">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
	<script src="loginStyle/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="loginStyle/vendor/bootstrap/js/popper.js"></script>
	<script src="loginStyle/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="loginStyle/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="loginStyle/vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="loginStyle/js/main.js"></script> --%>
</body>
</html>