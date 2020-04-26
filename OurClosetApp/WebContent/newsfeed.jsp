<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/newsfeed.css">
	<title>Newsfeed</title>
</head>
<body>
	<div class="navbar">
     	<nav>
            <a href="newsfeed"> Our Closet </a>
            <a href="newsfeed"> Home </a>
            <a href="profilepage.jsp"> Profile</a>
            <a href="search.jsp"><i class="fa fa-fw fa-search"></i>Search</a>
            <a href="notifications.jsp" ><i class="fa fa-bell"></i> Notifications</a>
    	</nav>
    </div>
 	
	<%@page import="java.util.ArrayList" %>
	<%@page import="model.Product" %>
	<%@page import="model.User" %>
	
	
 	
	<%
		/* System.out.println("testing -- " + ((User)(session.getAttribute("user"))).getInterest()); */
		ArrayList<Product> trending = (ArrayList<Product>) request.getAttribute("trending");
		System.out.println(trending.size());
		for (int i = 0; i < trending.size(); i++) {
			System.out.println(trending.get(i).getProductName());
		}
		ArrayList<Product> recent = (ArrayList<Product>) request.getAttribute("recent");
	
	%>
	<h2>TRENDING</h2>
	
		<div id="wrapper">
			<div id="innerwrapper">
				<c:forEach items="${trending}" var="product">	
					<form action="product.jsp" method="GET" name="product" value="Product">
	 					<input type="image" style="width:400px;height:400px;" class="image" src="${product.getImagePaths().get(0)}" border="0" alt="Submit" />
						<input type="hidden" name="productid" value="${product.getProductID()}">
					</form>
				</c:forEach>
  			</div>
  		</div>
	
	<h3>NEWSFEED</h3>
	
	<div class="row">
			<div id="column">
				<c:forEach items="${recent}" var="product">	
					<form action="product.jsp" method="GET" name="product" value="Product">
						<img src="${product.getImagePaths().get(0)}">
						<input type="image" style="width:400px;height:400px;"class="image" src="${product.getImagePaths().get(0)}" border="0" alt="Submit" />
						<input type="hidden" name="productid" value="${product.getProductID()}">
					</form>
				</c:forEach>
  			</div>
  		</div>
	
	<!-- Modal popup -->
	<div id="product-modal" class="modal">
	  <!-- Modal content -->
	  <div id="modal-content" class="modal-content">
	    <!-- <span class="close">&times;</span> -->
		    <div class="product-card">
			  <img src="" style="height:400px;width:100%">
			  <h1>Product name here</h1>
			  <p class="modal-attr">Brand: </p>
			  <p class="modal-attr">Color: </p>
			  <p class="modal-attr">Description: </p>
			  <p class="modal-attr">Price: </p>
			  <p class="modal-attr">Quantity: </p>
			  <p class="modal-attr">Interest: </p>
			  <p class="modal-attr">Seller: </p>
			  <p><button id="modal-btn">Show Interest!</button></p>
			</div>
		
		</div>
	</div>
	
	<script src="newsfeed.js"></script>
</body>
</html>