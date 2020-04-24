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
            <a href="newsfeed.jsp"> Our Closet </a>
            <a href="newsfeed.jsp"> Home </a>
            <a href="profilepage.jsp"> Profile</a>
            <a href="search.jsp"><i class="fa fa-fw fa-search"></i>Search</a>
            <a href="#" ><i class="fa fa-bell"></i> Notifications</a>
    	</nav>
    </div>
 	
	<%@page import="java.util.ArrayList" %>
	<%@page import="model.Product" %>
	
 	
	<%
		ArrayList<Product> trending = (ArrayList<Product>) request.getAttribute("trending");
		ArrayList<Product> recent = (ArrayList<Product>) request.getAttribute("recent");
	
	%>
	<h2>TRENDING</h2>
	
	<c:forEach items="${trending}" var="product">
		<div id="wrapper">
			<div id="innerwrapper">
				<form action="details" method="GET" name="details" value="Details">
					<input type="image" class="image" src="${product.getImagePaths().get(0)}" border="0" alt="Submit" />
					<input type="hidden" name="brand" value="${product.getBrand()}">
					<input type="hidden" name="productName" value="${product.getProductName()}">
					<input type="hidden" name="itemType" value="${product.getItemType()}">
					<input type="hidden" name="size" value="${product.getSize()}">
					<input type="hidden" name="description" value="${product.getDescription()}">
					<input type="hidden" name="rentPrice" value="${product.getRentPrice()}">
					<input type="hidden" name="buyPrice" value="${product.getBuyPrice()}">
					<input type="hidden" name="interest" value="${product.getInterest()}">
					<%-- <input type="hidden" name="comments" value="${product.getComments()}">
					<input type="hidden" name="images" value="${product.getImagePaths()}"> --%>
				</form>
  			</div>
  		</div>
	  	<!-- The Modal -->
		<div class="product-modal" class="modal">
		  <!-- Modal content -->
		  <div id="modal-content" class="modal-content">
		    <!-- <span class="close">&times;</span> -->
		 	<div id="product-info" style="height:400px;width:50%;"></div>
		  </div>
		
		</div>
	</c:forEach>
	
	<h3>NEWSFEED</h3>
	<c:forEach items="${recent}" var="product">
		<div class="column">
			<form action="details" method="GET" name="details" value="Details">
				<input type="image" class="image" src="${product.getImagePaths().get(0)}" border="0" alt="Submit" />
				<input type="hidden" name="brand" value="${product.getBrand()}">
				<input type="hidden" name="productName" value="${product.getProductName()}">
				<input type="hidden" name="itemType" value="${product.getItemType()}">
				<input type="hidden" name="size" value="${product.getSize()}">
				<input type="hidden" name="description" value="${product.getDescription()}">
				<input type="hidden" name="rentPrice" value="${product.getRentPrice()}">
				<input type="hidden" name="buyPrice" value="${product.getBuyPrice()}">
				<input type="hidden" name="interest" value="${product.getInterest()}">
				<%-- <input type="hidden" name="comments" value="${product.getComments()}">
				<input type="hidden" name="images" value="${product.getImagePaths()}"> --%>
				
			</form>
  		</div>
	</c:forEach>
	
	<script>
		function openModal(number) {
			
		}
		// Get the modal
		var modal = document.getElementById("map-modal");
		var modalContent = document.getElementById("modal-content");
	
		// Get the button that opens the modal
		var btn = document.getElementById("map-btn");
	
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
	
		// When the user clicks on the button, open the modal
		btn.onclick = function() {
		  modal.style.display = "block";
		}
	
		//When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == modal || event.target == modalContent) {
		    modal.style.display = "none";
		  }
		}

	</script>
</body>
</html>