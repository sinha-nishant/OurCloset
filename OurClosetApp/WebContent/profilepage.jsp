<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile Page </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <!-- Add icon library -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <!--icon library for hanger-->
     <script src="https://code.iconify.design/1/1.0.5/iconify.min.js"></script>
     <!-- Add font: Poppins -->
     <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
     <!--Generating thumbnail code from: http://talkerscode.com/webtricks/preview-image-before-upload-using-javascript.php-->
     <script type='text/javascript'>
      function preview_image(event) 
      {
       var reader = new FileReader();
       reader.onload = function()
       {
        var output = document.getElementById('profileImage');
        output.src = reader.result;
       }
       reader.readAsDataURL(event.target.files[0]);
      }
  </script>
</head>
<style>
  html, body {
    margin: 0;
    padding: 0;
    font-family: Poppins, Arial;
    background: white;
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
   .profile{
    max-width: 935px;
    margin-right: auto;
    margin-left: auto;
    overflow: auto;
  }
  header{
    margin-top: auto;
    margin-right: auto;
    margin-left: auto;
    max-height: 170px;
    overflow: auto;
    display: flex;
    border-bottom: 1px solid rgb(177, 175, 175);
  }
  .userprofilepic{
    margin-left: 64px;
    margin-right: 65px;
    margin-top: 9px;
    margin-bottom: 9px;
    float: left;
    background: url(images/stormtrooper.jpg) no-repeat;
    background-size: 150px;
    width: 150px;
    height: 150px;
    border-radius: 50%;
    border: 2px solid black;
    display: flex;
    justify-content: center;
    align-items: center;
  } 
   input:focus, textarea:focus, select:focus{
      outline: none;
   }
   input[type="file"] {
      display: none !important;
   }
   .userprofilepic img:hover{ 
     background:rgba(151, 150, 150, 0.301);
   }
  .profileInfo{
    float: right;
    margin-top: auto;
    margin-bottom: auto;
    margin-left: auto;
    margin-right: 64px;
    padding: 10px, 20px;
    max-width: auto;
    max-height: 150px;
    flex: 1;
  }
  .name{
    font-weight: 600;
    font-size: 35px;
  }
  .profileInfo li{
     list-style-type: none;
     display: inline;
     margin: 0;
     padding-right: 10px;
     font-size: 25px;
  }
  .profile-stat-count{
    font-weight: 600;
  }
  .gridProduct{
    display: grid;
    margin-top: 20px;
    grid-template-columns: repeat(3, 278px);
    grid-gap: 50px;
    grid-auto-rows: 278px;
    overflow: auto;
  }
  #UploadProductPage{
    display: block;
    text-decoration: none;
    margin: 0 auto;
    width: 278px;
    height: 278px;
  }
  #ProductFormat{
    display: block;
    text-decoration: none;
    margin: 0 auto;
    width: 278px;
    height: 278px;
  }
  #profileImage
  {
      cursor: pointer;
      width: 150px;
      height: 150px;
      border-radius: 50%;
      display: flex;
      justify-content: center;
      align-items: center;
  }
  @media screen and (max-width: 1280px) {
    .navbar a {
      float: none;
      display: block;
    }
    .profile{
      float: none;
      display: block;
    }
  }
</style>
<body>
    <div class="navbar">
      <nav>
            <a href="homeUsers.jsp"> Our Closet </a>
            <a href="homeUsers.jsp"> Home </a>
            <a href="profilePage.jsp"> Profile</a>
            <a href="search.jsp"><i class="fa fa-fw fa-search"></i>Search</a>
            <a href="#" ><i class="fa fa-bell"></i> Notifications</a>
    </nav>
    </div>
   <div class="profile">
     <header>
        <span>
            <label class="userprofilepic">
              <input type="file" accept="image/*" onchange="preview_image(event)">
              <img id="profileImage"/>
            </label>
        </span>
        
        <%@ page import="model.User" %>
        
        <%  User user = (User) session.getAttribute("user");
        	int interests = user.getInterest();
        	
        	int products = 0;
        	if (user.getProducts() != null) products = user.getProducts().size();
        %>
        <div class="profileInfo">
          <ul>
            <span class="name">First & Last Name</span>
          </ul>
          <ul>
            <li> <span class="profile-stat-count"> </span> <%=products%> </li>
            <li> <span class="profile-stat-count"> <%=interests%> </span> <span class="iconify" data-icon="si-glyph:hanger" data-inline="false"></span> </li>
          </ul>
        </div>
      </header>
      <span class="gridProduct">
        <a href="uploadProduct.html"> <img src="images/plussign.png"id="UploadProductPage" alt="Upload"> </a>
    </span>
   </div>
  
</body>
</html>
