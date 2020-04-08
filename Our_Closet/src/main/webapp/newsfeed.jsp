<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- <link rel="stylesheet" type="text/css" href="newsfeedStyle/polaroid.css">
<link rel="stylesheet" type="text/css" href="newsfeedStyle/nav.css">
<link rel="stylesheet" type="text/css" href="newsfeedStyle/hover.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Newsfeed</title>
</head>
<!-- --------------------------------------------------------------------------------------------------- -->
<body>

<!-- 	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-sticky"> <a
		class="navbar-brand" href="#">Our Closet</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li id="profile" class="nav-item"><a class="nav-link" href="../profile">Profile</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Dropdown </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
	</nav> -->
<%-- 	
	<div class="wrapper">
		<c:if test="${not empty postsRepo.returnAllPosts()}">
			<c:forEach items="${postsRepo.returnAllPosts()}" var="posts">
				<div class="item">
					<div class="polaroid">
						<img
							src="https://ca-times.brightspotcdn.com/dims4/default/99f1978/2147483647/strip/true/crop/1548x871+0+0/resize/1486x836!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F81%2F7f%2F9963576d6219c441c5d1e339361c%2Flat-sp-usc-full-logo-20140126">
						<a href="#"><div class="caption">${posts.getpName()}</div></a>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
	 --%>
	 (Nav bar here with Home, Profile, Upload, Search Bar, and Log Out)
	<h1>Welcome back ${user.getfName() }</h1>
	<div>
		<c:if test="${not empty postsRepo.returnAllPosts()}">
			<c:forEach items="${postsRepo.returnAllPosts()}" var="posts">
				<div>
					<img style="width: 400px; height: 200px; margin-left: 20px; margin-top:10px; margin-bottom:10px"
						src="https://ca-times.brightspotcdn.com/dims4/default/99f1978/2147483647/strip/true/crop/1548x871+0+0/resize/1486x836!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F81%2F7f%2F9963576d6219c441c5d1e339361c%2Flat-sp-usc-full-logo-20140126">
					<a href="#"><div">${posts.getpName()}</div></a>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<!--===============================================================================================-->
<!-- 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script> -->
</body>
</html>
