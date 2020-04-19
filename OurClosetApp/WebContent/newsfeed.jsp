<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Newsfeed</title>
</head>
<body>
	<div class="navbar">
	      <nav>
	            <a href="#"> Our Closet </a>
	            <a href="home.html"> Home </a>
	            <a href="profilepage.html"> Profile</a>
	            <a href="#"><i class="fa fa-fw fa-search"></i>Search</a>
	            <a href="#" ><i class="fa fa-bell"></i> Notifications </a>
	    </nav>
 	</div>
 	
	<%@page import="java.util.ArrayList" %>
	<%@page import="model.Product" %>
	
 	
	<%
		ArrayList<Product> trending = (ArrayList<Product>) request.getParameter("trending");
		ArrayList<Product> recent = (ArrayList<Product>) request.getParameter("recent");
	
	%>
	<h2>TRENDING</h2>
	
	<c:forEach items="${trending}" var="product">
		<div id="wrapper">
			<div id="innerwrapper">
				<form action="details" method="GET" name="details" value="Details">
					<input type="image" class="image" src="${product.getImagePath()}" border="0" alt="Submit" />
				</form>
  			</div>
  		</div>
	</c:forEach>
	
	<h3>NEWSFEED</h3>
	<c:forEach items="${recent}" var="product">
		<div class="column">
			<form action="details" method="GET" name="details" value="Details">
				<input type="image" class="image" src="${product.getImagePath()}" border="0" alt="Submit" />
			</form>
  		</div>
	</c:forEach>
	
	

</body>
</html>