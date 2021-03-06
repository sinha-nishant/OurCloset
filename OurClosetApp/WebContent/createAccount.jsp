<!-- Josie Jitzel Alvarez, Anjalee Patel, Can Toraman, Alex Qiu, Nishant Sinha, Florence Yang --->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Create Account</title>
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<!-- fonts -->
	<!-- poppins -->
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- montserrat -->
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">

	<!-- icons -->
	<script src="https://kit.fontawesome.com/7ce1d97a87.js" crossorigin="anonymous"></script>

	<!-- css -->
	<style>
		html {
			margin:0;
		}
		body {
			height: 100%;
			margin:0;
			background: linear-gradient(-135deg, #FFCC00, #990000);
			font-family: 'Poppins', sans-serif;	
			background-repeat: no-repeat;
			background-attachment: fixed;
			font-weight: 700;
			font-size: 20px;
		}
		h1, .labels {
			font-weight: 700;
		}
		#back-area {
			cursor: pointer;
		}
		#back-button {
			margin-top: 50px;
			margin-left: 50px;
			color: white;
		}
		#back-text {
			margin: 5px;
			font-size: 30px;
			vertical-align: 10px;
			color: white;
			font-weight: lighter;
		}
		.outer-box {
			margin: 50px;
			padding: 50px;
			padding-top: 20px;
			background-color: white;
			border-radius: 20px;
		}
		.placeholder-text {
			font-family: 'Montserrat', sans-serif;
		}
		@media (min-width: 992px) {
			h1 {
				font-size: 60px;
			}
			.labels {
				font-size: 30px;
			}
			.placeholder-text {
				margin-top: 5px;
				font-size: 20px;
			}
			.outer-box {
				margin-left: 10%;
				margin-right: 10%;
			}
		}
		@media (min-width: 1200px) {
			h1 {
				font-size: 70px;
			}
			.labels {
				font-size: 40px;
			}
			.placeholder-text {
				margin-top: 5px;
				font-size: 30px;
			}
		}
	</style>

</head>
<body>
	<div id="back-area"><i id="back-button" class="fas fa-chevron-left fa-3x"></i><span id="back-text">back</span></div>
	<div class="outer-box">

		<div class="container">
			<div class="row">
				<h1 class="col-12 mt-5 d-flex justify-content-center">Create Account</h1>
			</div>
		</div>

		<div class="container">

			<form action="CreateAccountServlet" method="POST" class="mt-3">
				<!-- first name -->
				<div class="form-group row">
					<label for="fname" class="col-md-3 col-lg-4 col-form-label labels">First Name</label>
					<div class="col-md-9 col-lg-8">
						<input type="text" class="form-control placeholder-text" name="fname" id="fname" placeholder="i.e. Tommy">
					</div>
				</div>
				<!-- last name -->
				<div class="form-group row">
					<label for="lname" class="col-md-3 col-lg-4 col-form-label labels">Last Name</label>
					<div class="col-md-9 col-lg-8">
						<input type="text" class="form-control placeholder-text" name="lname" id="lname" placeholder="i.e. Trojan">
					</div>
				</div>
				<!-- email -->
				<div class="form-group row">
					<label for="loginEmail" class="col-md-3 col-lg-4 col-form-label labels">USC Email</label>
					<div class="col-md-9 col-lg-8">
						<input type="email" class="form-control placeholder-text" name="email" id="loginEmail" placeholder="i.e. ttrojan@usc.edu">
					</div>
				</div>
				<!-- password -->
				<div class="form-group row">
					<label for="loginPassword" class="col-md-3 col-lg-4 col-form-label labels">Password</label>
					<div class="col-md-9 col-lg-8">
						<input type="password" class="form-control placeholder-text" name="password" id="loginPassword" placeholder="i.e. OurClosetRoxx">
					</div>
				</div>

				<!-- submit button -->
				<div class="form-group row mt-5 d-flex justify-content-center">
					<button type="submit" class="btn btn-success labels">
					CREATE!
					</button>
				</div>
			</form>
			<c:if test="${not empty createAccountMessage}">
				<div>${createAccountMessage}</div>
			</c:if>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<!-- javascript to make back button work -->
	<script>
		$("#back-area").click(function() {
			console.log("back clicked");
			location.href = "login.jsp";
		});
	
	</script>
</body>
</html>