<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}
  html, body {
    margin: 0;
    padding: 0;
    font-family: Poppins, Arial;
  }

  @media screen and (max-width: 1500px) {
  .navbar a {
    float: none;
    display: block;
  }
  .navbar {
    width: 100%;
    background: linear-gradient(to right, #993300 0%, #ffcc00 100%);
    overflow: auto;
  }
  
  .navbar a {
    float: left;
    padding: 15px;
    color: white;
    text-decoration: none;
    font-size: 20px;
  }
 
  .navbar a:hover {
    background-color: #fc6f03;
  }

h3 {
  font-size: 38px;
  font-family: Poppins, Arial;
  background: linear-gradient(to right, #993300 0%, #ffcc00 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  position: relative;
  left: 20px;
}

.alert {
  padding: 20px;
  color: white;
  opacity: 1;
  transition: opacity 0.6s;
  margin-bottom: 15px;
   text-decoration: none;
}

.alert.interest {background-color: #f7c200;}
.alert.comment {background-color: #de8512;}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

a {
  text-decoration: none;
  color: white;
}

.closebtn:hover {
  color: black;
}

</style>
</head>
<body>

<div class="navbar">
      <nav>
            <a href="newsfeed"> Our Closet </a>
            <a href="newsfeed"> Home </a>
            <a href="profilepage.html"> Profile</a>
            <a href="searchServlet"><i class="fa fa-fw fa-search"></i>Search</a>
            <a href="notifications.jsp" ><i class="fa fa-bell"></i> Notifications </a>
    </nav>
 </div>

<%@page import="java.util.ArrayList" %>
<%@page import="util.SQL_Util" %>
<%@page import="model.Notification" %>

<%int userID = (int) request.getSession().getAttribute("user");
ArrayList<Notification> notifications = SQL_Util.getNotifications(userID);
request.setAttribute("notifications", notifications);
System.out.println("number of notifs:" + notifications.size());

%>
<h3>Notifications</h3>

<div>
<c:forEach items="${notifications}" var="notif">	
<%-- 	<p>${notif.getCommenterName()}</p>
 --%>	<div class="alert comment">
		<span class="closebtn">&times;</span>
		<a href="product.jsp"> ${notif.toString()}</a>
	
	</div>
</c:forEach>
</div>



<script>
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
  close[i].onclick = function(){
    var div = this.parentElement;
    div.style.opacity = "0";
    setTimeout(function(){ div.style.display = "none"; }, 600);
  }
}
</script>


</body>
</html>


</html>