<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    max-width: 100%;
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

#wrapper {
  height: 300px;
  overflow: auto;
  width: 1600px;
  overflow-y: hidden;
}

img {
  height: 300px;
  width: 300px;
  position: relative;
  display: inline-block;
  float: left;
}

#innerwrapper {
  width: 2400px;
  position: relative;
}

h2 {
  font-size: 38px;
  font-family: Poppins, Arial;
  background: linear-gradient(to right, #993300 0%, #ffcc00 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

h3 {
  font-size: 38px;
  font-family: Poppins, Arial;
  background: linear-gradient(to right, #993300 0%, #ffcc00 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.row {
  display: flex;
  flex-wrap: wrap;
  padding: 0 4px;
}

/* Create four equal columns that sits next to each other */
.column {
  flex: 25%;
  max-width: 25%;
  padding: 0 4px;
}

.column img {
  margin-top: 8px;
  vertical-align: middle;
  width: 100%;
}

/* Responsive layout - makes a two column-layout instead of four columns */
@media screen and (max-width: 800px) {
  .column {
    flex: 50%;
    max-width: 50%;
  }
}

/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column {
    flex: 100%;
    max-width: 100%;
  }
}

</style>
</head>
<body>

<div class="navbar">
      <nav>
            <a href="#"> Our Closet </a>
            <a href="hometest.jsp"> Home </a>
            <a href="profilepage.jsp"> Profile</a>
            <a href="#"><i class="fa fa-fw fa-search"></i>Search</a>
            <a href="#" ><i class="fa fa-bell"></i> Notifications </a>
    </nav>
 </div>

<h2>TRENDING</h2>


<div id="wrapper">
   <div id="innerwrapper">
   	<a href="https://www.google.com/">
    	<img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg"/>
    </a>
    <a href="https://www.google.com/">
    	<img src="https://i.etsystatic.com/19181655/r/il/fd6649/1740098704/il_570xN.1740098704_3m72.jpg"/>
    </a>
    <a href="https://www.google.com/">
    	<img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1ad64451-9ef5-42c5-9c48-d5bee7a736a8/air-max-97-big-kids-shoe-cTXsh6.jpg"/>
    </a>
    <a href="https://www.google.com/">
    	<img src="https://images.prod.meredith.com/product/63a507a2a4949af6efca1206d89505cc/1551577991272/l/herringbone-metro-high-waisted-legging-black-athleta-pants"/>
    </a>
    <a href="https://www.google.com/">
    	<img src="https://content.backcountry.com/images/items/900/PAT/PAT00KM/NATBLB.jpg"/>
    </a>
    <a href="https://www.google.com/">
   		<img src="https://i.s-madewell.com/is/image/madewell/H7397_WQ4092_ld?wid=500&hei=635&fmt=jpeg&fit=crop&qlt=75,1&resMode=bisharp&op_usm=0.5,1,5,0"/>
   	</a>
   	<a href="https://www.google.com/">
    	<img src="https://www.honestbrandreviews.com/wp-content/uploads/2020/02/mejuri-1.jpg"/>
    </a>
    <a href="https://www.google.com/">
    	<img src="https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1566314990-stories-1566314984.jpg"/>
	</a>
   </div>
 </div>

<h3>	NEWSFEED</h3>

<!-- <div class="row">
  <div class="column"> -->
<div class="flex-container">
    <img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg">
    <img src="https://i.etsystatic.com/19181655/r/il/fd6649/1740098704/il_570xN.1740098704_3m72.jpg">
    <img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg">
    <img src="https://images.prod.meredith.com/product/63a507a2a4949af6efca1206d89505cc/1551577991272/l/herringbone-metro-high-waisted-legging-black-athleta-pants">
    <img src="https://content.backcountry.com/images/items/900/PAT/PAT00KM/NATBLB.jpg">
    <img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1ad64451-9ef5-42c5-9c48-d5bee7a736a8/air-max-97-big-kids-shoe-cTXsh6.jpg">
    <img src="https://i.s-madewell.com/is/image/madewell/H7397_WQ4092_ld?wid=500&hei=635&fmt=jpeg&fit=crop&qlt=75,1&resMode=bisharp&op_usm=0.5,1,5,0">
<!--   </div>
  <div class="column"> -->
    <img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg">
    <img src="https://images.prod.meredith.com/product/63a507a2a4949af6efca1206d89505cc/1551577991272/l/herringbone-metro-high-waisted-legging-black-athleta-pants">
    <img src="https://i.etsystatic.com/19181655/r/il/fd6649/1740098704/il_570xN.1740098704_3m72.jpg">
    <img src="https://content.backcountry.com/images/items/900/PAT/PAT00KM/NATBLB.jpg">
    <img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1ad64451-9ef5-42c5-9c48-d5bee7a736a8/air-max-97-big-kids-shoe-cTXsh6.jpg">
    <img src="https://i.etsystatic.com/19181655/r/il/fd6649/1740098704/il_570xN.1740098704_3m72.jpg">
<!--   </div>
  <div class="column"> -->
    <img src="https://i.s-madewell.com/is/image/madewell/H7397_WQ4092_ld?wid=500&hei=635&fmt=jpeg&fit=crop&qlt=75,1&resMode=bisharp&op_usm=0.5,1,5,0">
    <img src="https://images.prod.meredith.com/product/63a507a2a4949af6efca1206d89505cc/1551577991272/l/herringbone-metro-high-waisted-legging-black-athleta-pants">
    <img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg">
    <img src="https://content.backcountry.com/images/items/900/PAT/PAT00KM/NATBLB.jpg">
    <img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1ad64451-9ef5-42c5-9c48-d5bee7a736a8/air-max-97-big-kids-shoe-cTXsh6.jpg">
    <img src="https://i.s-madewell.com/is/image/madewell/H7397_WQ4092_ld?wid=500&hei=635&fmt=jpeg&fit=crop&qlt=75,1&resMode=bisharp&op_usm=0.5,1,5,0">
    <img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg">
<!--   </div>
  <div class="column"> -->
    <img src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto/1ad64451-9ef5-42c5-9c48-d5bee7a736a8/air-max-97-big-kids-shoe-cTXsh6.jpg">
    <img src="https://www.honestbrandreviews.com/wp-content/uploads/2020/02/mejuri-1.jpg">
    <img src="https://content.backcountry.com/images/items/900/PAT/PAT00KM/NATBLB.jpg">
    <img src="https://di2ponv0v5otw.cloudfront.net/posts/2019/10/26/5db491d8b3e9170d4bc01ad0/m_5db49230de696ad6cb5f34dd.jpg">
    <img src="https://www.honestbrandreviews.com/wp-content/uploads/2020/02/mejuri-1.jpg">
    <img src="https://content.backcountry.com/images/items/900/PAT/PAT00KM/NATBLB.jpg">
<!--   </div>
</div> -->
</div>



</body>
</html>