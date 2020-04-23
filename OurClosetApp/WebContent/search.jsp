<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>OurCloset Search Form</title>
	<!-- bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

	<!-- fonts -->
	<!-- poppins -->
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- montserrat -->
	<link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
	<style>
		.form-check-label {
			padding-top: calc(.5rem - 1px * 2);
			padding-bottom: calc(.5rem - 1px * 2);
			margin-bottom: 0;
		}

		html {
			height: 100%;
			margin:0;
		}
		body {
			height: 100%;
			margin:0;
			background: linear-gradient(-135deg, #FFCC00, #990000);
			font-family: 'Poppins', sans-serif;	
			background-repeat: no-repeat;
			background-attachment: fixed;
			overflow:hidden;
			font-weight: 700;
			font-size: 20px;
		}
		.navbar {
			width: 100%;
			background: linear-gradient(to right, #993300 0%, #ffcc00 100%);
			overflow: auto;
			border-bottom: 1px black solid;
		}
		.navbar a {
			float: left;
			padding: 15px;
			color: white;
			text-decoration: none;
			font-size: 20px;
			text-shadow: 1px 1px black;
		}
		.navbar a:hover {
			background-color: #fc6f03;
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
		@media screen and (max-width: 1280px) {
		.navbar a {
      		float: none;
     		 display: block;
    		}
		}
	</style>
</head>
<body>
	<div class="navbar">
		<nav>
			  <a href="home.html"> Our Closet </a>
			  <a href="home.html"> Home </a>
			  <a href="profilepage.html"> Profile</a>
			  <a href="search.html"><i class="fa fa-fw fa-search"></i>Search</a>
			  <a href="#" ><i class="fa fa-bell"></i> Notifications</a>
	  </nav>
	  </div>
	<div class="outer-box">
		<div class="container">
			<div class="row">
				<h1 class="col-12 mt-4 mb-4">Search OurCloset</h1>
			</div> <!-- .row -->
		</div> <!-- .container -->

		<div class="container">

		<form action="searchServlet" method="GET">

			<div class="form-group row">
				<label for="name-id" class="col-sm-3 col-form-label text-sm-right">Product Name:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="name-id" name="track_name">
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<label for="brand-id" class="col-sm-3 col-form-label text-sm-right">Brand:</label>
				<div class="col-sm-9">
					<select name="brand" id="brand-id" class="form-control">
						<option value="" selected>-- All --</option>

						<!-- put dynamic results from database here -->
						
					</select>
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<label for="item-type-id" class="col-sm-3 col-form-label text-sm-right">Item type:</label>
				<div class="col-sm-9">
					<select name="item" id="item-type-id" class="form-control">
						<option value="" selected>-- All --</option>

						<!-- put dynamic results from database here -->

					</select>
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<label for="size-type-id" class="col-sm-3 col-form-label text-sm-right">Size:</label>
				<div class="col-sm-9">
					<select name="size" id="size-type-id" class="form-control">
						<option value="" selected>-- All --</option>

						<!-- put dynamic results from database here -->

					</select>
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<label for="price-type-id" class="col-sm-3 col-form-label text-sm-right">Price:</label>
				<div class="col-sm-9">
					<select name="price" id="price-type-id" class="form-control">
						<option value="" selected>-- All --</option>

						<!-- put dynamic results from database here -->
						<!-- this will be ranges of prices (i.e. under $25, under $50, etc.) -->

					</select>
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<label for="color-type-id" class="col-sm-3 col-form-label text-sm-right">Color:</label>
				<div class="col-sm-9">
					<select name="color" id="color-type-id" class="form-control">
						<option value="" selected>-- All --</option>

						<!-- put dynamic results from database here -->

					</select>
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<label for="tag-id" class="col-sm-3 col-form-label text-sm-right">Tags:</label>
				<div class="col-sm-9">
					<input type="tag" class="form-control" id="tag-id" name="track_tag">
				</div>
			</div> <!-- .form-group -->
			<div class="form-group row">
				<div class="col-sm-3"></div>
				<div class="col-sm-9 mt-2">
					<button type="submit" class="btn btn-primary">Search</button>
					<button type="reset" class="btn btn-light">Reset</button>
				</div>
			</div> <!-- .form-group -->
		</form>
		<c:if test="${not empty searchMessage}">
			<div>${searchMessage}</div>
		</c:if>
	</div> <!-- .container -->
</div>
	
</body>
</html>