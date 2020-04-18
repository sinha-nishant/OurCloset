<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<!-- fonts -->
	<!-- poppins -->
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- montserrat -->
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	
	<!--  custom css -->
	<link href="css/login.css" type="text/css" rel="stylesheet">

	<!-- icons -->
	<script src="https://kit.fontawesome.com/7ce1d97a87.js" crossorigin="anonymous"></script>
	
</head>
<body>
	<div class="outer-box">

		<!-- below layout referenced from: https://startbootstrap.com/snippets/sign-in-split/ -->
		<div class="container-fluid">
			<div class="row no-gutter">
				<!-- left hand side of login page -->
				<div class="d-none d-md-flex col-md-4 col-lg-6">
					<div id="left-side">
						<img src="closet.png" alt="Responsive image of closet">
						<h2>Welcome to OurCloset!</h2>
						<p> The one-stop shop to rent or sell clothing so that you can have the fit you've always wanted for a reasonable price!</p>
					</div>
				</div>
				
				<!-- right hand side of login page -->
				<div class="col-md-8 col-lg-6 d-flex align-items-center py-5">
				<div class="container">
					<div class="row">
						<div class="col-md-9 col-lg-8 mx-auto">

							<h2 class="mt-5">Member Login</h2>
						
							<form action="login" method="POST" name="login" value="Login" >

								<!-- email -->
								<div class="form-group input-field">
									<i class="fas fa-envelope fa-4x icon"></i>
									<input type="email" class="form-control placeholder-text" name="uscemail" id="loginEmail" placeholder="USC Email">
								</div>

								<!-- password -->
								<div class="form-group input-field">
									<i class="fas fa-key fa-4x icon"></i>
									<input type="password" class="form-control placeholder-text" name="password" id="loginPassword" placeholder="Password">
								</div>

								<!-- submit button -->
								<div class="form-group mt-5">
									<button type="submit" class="btn btn-success labels">
									LOGIN
									</button>
								</div>

							</form>
							<c:if test="${not empty loginMessage}">
								<div>${loginMessage}</div>
							</c:if>
							
							<div id="create-account">
								<span>Create Account </span><i class="fas fa-arrow-right"></i>
							</div>
							
							<div id="guest-access">
								<span>Continue as Guest </span><i class="fas fa-arrow-right"></i>
							</div>

						</div> <!-- resizing classes close -->
					</div> <!-- row close -->
				</div> <!-- container close -->
				</div> <!-- resizing right hand side close -->

			</div> <!-- row: no-gutter close -->
		</div> <!-- container-fluid close -->
	</div> <!-- outer-box close -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<!-- javascript to make page redirect buttons work -->
	<script>
		// redirect to create account
		$("#create-account").click(function() {
			console.log("create account clicked");
			location.href = "createAccount.html";
		});
		
		// redirect to home page, guest view
		$("#guest-access").click(function() {
			console.log("create account clicked");
			location.href = "createAccount.html";
		});
	</script>

</body>
</html>