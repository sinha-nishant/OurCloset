<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Product Page</title>
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
			/*overflow:hidden;*/
			font-weight: 700;
			font-size: 20px;
		}
		h1, #product {
			font-weight: 700;
		}
		.outer-box {
			margin: 100px;
			padding: 50px;
			padding-top: 0px;
			background-color: white;
			border-radius: 20px;
			margin-bottom: 75px;
			margin-left: 20%;
			margin-right: 20%;
		}

		#exit-area {
			cursor: pointer;
		}
		#exit-button {
			position: absolute;
			right: 8%;
			top: 5%;
			color: white;
		}

		.formatting {
			display: flex;
			padding-bottom: 10px;
		}
		.liked {
			color: #F76AA9;
		}
		.not-liked {
			color: #D0CECF;
		}
		#interest {
			position: absolute;
			right: 1%;
			display: flex;
		}
		#name {
			padding-left: 0px;
		}

		img {
			width: 100%;
		}
		
		#product-row {
			margin-top: 15px;
		}
		#product {
			padding-left: 0px;
		}
		#price {
			position: absolute;
			right: 2%;
		}

		p {
			margin-bottom: 0px;
			font-family: 'Montserrat', sans-serif;
		}
		.labels {
			font-family: 'Poppins', sans-serif;	
		}

		.hide {
			display: none;
		}
		#comments-toggler {
			color: #c7c7c7;
		}
		#comments {
			font-size: 15px;
			padding-left: 10%;
		}
		#comment {
			background-color: #E8E8E8;
			border-radius: 10px;
			border-style: none;
			margin-top: 5px;
		}
		.placeholder-text {
			font-family: 'Montserrat', sans-serif;
		}

		@media (min-width: 992px) {
			h1 {
				font-size: 50px;
			}
			.placeholder-text {
				margin-top: 5px;
				font-size: 20px;
			}
			.outer-box {
				margin-left: 18%;
				margin-right: 18%;
			}
		}
		@media (min-width: 1200px) {
			h1 {
				font-size: 70px;
			}
			.placeholder-text {
				margin-top: 5px;
				font-size: 30px;
			}
		}
	</style>

	<script>
	// add comment
	function addComment(source) {
		var comments = document.querySelector("comments");
		commments.innerHTML += ("<p>" + source.value + "</p>");
		return false;
	}
	</script>
</head>
<body>
	<div id="exit-area"><i id="exit-button" class="fas fa-times fa-3x"></i></div>
	<div class="outer-box">
	<%@page import="model.Product"%>
	<%@page import="util.SQL_Util" %>
	<% int productID = Integer.parseInt(request.getParameter("productid"));
	Product product = SQL_Util.getProduct(productID);
	String pName = product.getProductName();
	String brand = product.getBrand();
	%>
		<!-- seller name + interest button -->
		<div class="container">
			<div class="row formatting">
				<h1 id="name" class="col-12 mt-5 d-flex justify-content-left">Betty
					<div id="interest"><span id="interest-count">103</span><i id="interest-button" class="fas fa-hand-sparkles justify-content-right interest"></i></div>
					<!-- NEED TO ADD JSP INTO THIS ICON's "CLASS" ATTRIBUTE TO DETERMINE WHAT COLOR IT SHOULD BE PRE-COLORED (INTERESTED (class: liked) OR NOT INTERESTED (class: not-liked)) -->
				</h1>
			</div>
		</div>

		<!-- product image -->
		<div class="container">
			<div class="row">
				<img src="images/coding-onesie.jpg">
			</div>	
		</div>

		<!-- product name + price -->
		<div id="product-row" class="formatting">
			<h3 id="product" class="col-12 d-flex justify-content-left"><%=pName %>
				<span id="price">$3</span>
			</h3>
		</div>

		<!-- product info -->
		<div>
			<p><span class="labels">size:</span> S</p>
			<p><span class="labels">brand:</span> <%=brand %></p>
			<p><span class="labels">rent/sell:</span> rent</p>
			<p><span class="labels">description:</span> Try out this cute coding onesie to encourage your little one to start compiling early!</p>
		</div>

		<!-- comments -->
		<div>
			<span id="comments-toggler">view comments...</span>
			<div id="comments" class="hide">
				<p><span class="labels">Patty:</span> so cute!</p>
				<p>Elisabeth: omg I NEED this for my little one *heart eyes* asdlfjkaskldjfklasd jkfldas</p>
			</div>
		</div>
		<div>
			<form onsubmit="return (addComment(this))" >
			<input type="text" class="form-control placeholder-text" name="comment" id="comment" placeholder="Add a comment">
			</form>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<!-- javascript to make back button work -->
	<script>
		// go back to home page/where we originally clicked from to get more product details
		$("#exit-area").click(function() {
			console.log("back clicked");
			location.href = "login.html";
		});

		//interest button
		document.querySelector("#interest-button").onclick = function() {
			console.log(this);

			//toggle effect
			if(this.classList.contains("liked")) //if paragraph already has class "liked"
			{
				//on click that satisfies this condition, will change color of interest button to indicate "not interested"
				this.classList.remove("liked");
				this.classList.add("not-liked");
			}
			else {
				//on click that satisfies this condition, will change color of interest button to indicate "interested"
				this.classList.add("liked");
				this.classList.remove("not-liked");
			}
		}

		//toggle showing the comments on product page (default hidden)
		document.querySelector("#comments-toggler").onclick = function() {
			console.log(this);

			//toggle effect
			if(this.nextElementSibling.classList.contains("hide")) //if paragraph already has class "hide"
			{
				//on click that satisfies this condition, will show paragraph
				this.nextElementSibling.classList.remove("hide"); //remove from class list so won't hide anymore
				this.innerHTML = "hide comments...";
			}
			else {
				//on click that satisfies this condition, will hide paragraph
				this.nextElementSibling.classList.add("hide"); //predefined class in css, adding as class element to <p> element
				this.innerHTML = "view comments...";
			}
		}
	
	</script>
</body>
</html>