<!-- Josie Jitzel Alvarez, Anjalee Patel, Can Toraman, Alex Qiu, Nishant Sinha, Florence Yang --->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Upload Product Page </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <!-- Add font: Poppins -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">
    <script src="js/index.js"></script>

    <!--Generating thumbnail code from: http://talkerscode.com/webtricks/preview-image-before-upload-using-javascript.php-->
    <script type='text/javascript'>
        function preview_image(event) 
        {
         var reader = new FileReader();
         reader.onload = function()
         {
          var output = document.getElementById('image_src');
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
    input:focus, textarea:focus, select:focus{
        outline: none;
    }
    .EntirePage{
        width: auto;
        margin: auto 75px;
        position: absolute;
        top: 23%;
    }
    .uploadPage{
        width: auto;
        overflow: auto;
        display: flex;
        flex-wrap: nowrap;
        justify-content: center;
        flex-direction: row;
    }
    .uploadPage > div {
        align-items: center;
        margin-right: 15px;
        width: 330px;
        height: 320px;
    }
    textarea {
        width: 100%;
        height: 100%;
        font-size: 20px;
        padding: 12px 20px;
        background-color: white;
        color: #e7420f;
        display: inline-block;
        border-radius: 10px;
        border: solid;
        border-color: #AA1945;
        box-sizing: border-box;
        overflow: auto;
        outline: none;
        -webkit-box-shadow: none;
        -moz-box-shadow: none;
        box-shadow: none;
        resize: none; /*remove the resize handle on the bottom right*/
    }
    select[multiple] {
        width: 100%;
        height: 100%;
        font-size: 20px;
        padding: 12px 20px;
        background-color: white;
        color: #e7420f;
        display: inline-block;
        border-radius: 10px;
        border: solid;
        border-color: #AA1945;
        box-sizing: border-box;
    }
    ::placeholder {
        font-weight: bold;
        color: #e7420f;
    }
    input[type=text], select {
        width:100%;
        font-size: 20px;
        padding: 12px 20px;
        background-color: white;
        color: #e7420f;
        display: inline-block;
        border-radius: 10px;
        border: solid;
        border-color: #AA1945;
        box-sizing: border-box;
    }
    input[type=number], select {
        width:100%;
        font-size: 20px;
        color: #e7420f;
        padding: 12px 20px;
        background-color: white;
        display: inline-block;
        border-radius: 10px;
        border: solid;
        border-color: #AA1945;
        box-sizing: border-box;
    }
    input[type=submit] {
        width: 25%;
        background-color:white;
        color: #AA1945;
        font-size: x-large;
        float: right;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
    }
    input[type=submit]:hover{
        float: right;
        color:gray;
    }
    input[type=button] {
        width: 25%;
        background-color:white;
        color: #AA1945;
        font-size: x-large;
        float: left;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
    }
    input[type=button]:hover{
        color:gray;
    }
    .uploadImage{
        margin-top: 33px;
        background: url(images/plussign.png) no-repeat;
        background-size: 300px;
        background-size: cover;
        background-position: center;
        border-style: solid;
        border-image-source: linear-gradient(to right, #d15d0f 0%, #e7420f 100%);
        border-width: 5px;
        border-image-slice: 1;
        display: block;
        width: 250px;
        height: 250px;
    }
    #item{
        height: 55px;
    }
   input[type="file"] {
        display: none !important;
    }
    #image_src {
        max-width: 250px;
        max-height: 250px;
    }
</style>
<body>
    <form class="EntirePage" method="POST" action="UploadProductServlet">
        <div class="uploadPage">
            <div style="width:260px; height: 260px;">
                <span>
                    <label class="uploadImage">
                        <input required name="image" type="file" accept="image/*" onchange="preview_image(event)">
                        <img id="image_src"/>
                    </label>
                </span>
             </div>
                <div>
                    <input type="text" id="brand" name="brand" placeholder="Brand"><br> 
                    <input type="text" id="name" name="name" placeholder="Name" required><br> 

                    <select name="item" id="item" required>
                        <option value="" disabled selected >Item Type(shoes, shirt, etc.)</option>
                        <option value="tshirt"> T-Shirt </option>
                        <option value="tank"> Tank Top</option>
                        <option value="buttonUp"> Button Up Shirt</option>
                        <option value="pants">Pants</option>
                        <option value="coat"> Coat</option>
                        <option value="dress"> Dress</option>
                        <option value="swimsuit"> Swimsuit </option>
                        <option value="shoe"> Shoes</option>
                        <option value="heels"> Heels</option>
                        <option value="sandals"> Sandals</option>
                        <option value="boots">Boots</option>
                        <option value="hat"> Hat</option>
                        <option value="scarf"> Scarf</option>
                        <option value="gloves">Gloves</option>
                        <option value="socks"> Socks</option>
                    </select>
                    
                    <input type="text" id="size" name="size" placeholder="Size" required><br>
                    <input type="number" placeholder="$0.00" step="0.01" id="price" name="price" required><br> 
                    <input type="text" id="tags" name="tags" placeholder="Tags (Separate with #)"><br>
                </div>
                <div>
                    <select style="font-size: 13px;"
                     name="color" multiple="multiple" id="colorSelector" required>
                        <optgroup label="Color (for multiple: hold 'Command' or 'Control')">
                        <option value="#00FFF" style="background-color:aqua;"></option>
                        <option value="#F5F5DC" style="background-color: beige;"></option>
                        <option value="#000000" style="background-color: black;"></option>
                        <option value="#0000FF" style="background-color: #0000FF;"></option>
                        <option value="#A52A2A" style="background-color: #A52A2A;"></option>
                        <option value="#FF7F50" style="background-color: #FF7F50;"></option>
                        <option value="#808080" style="background-color: #808080;"></option>
                        <option value="#800000" style="background-color: #800000;"></option>
                        <option value="#000080" style="background-color: #000080;"></option>
                        <option value="#DDA0DD" style="background-color: #DDA0DD;"></option>
                        <option value="#008080" style="background-color: #008080;"></option>
                        <option value="#FFA500" style="background-color: #FFA500;"></option>
                        <option value="#FFC0CB" style="background-color: #FFC0CB;"></option>
                        <option value="#800080" style="background-color: #800080;"></option>
                        <option value="#40E0D0" style="background-color: #40E0D0;"></option> <!--turqoise-->
                        <option value="#FF0000" style="background-color: #FF0000;"></option>
                        <option value="#87CEEB" style="background-color: #87CEEB;"></option>
                        <option value="#FFFFFF" style="background-color: #FFFFFF;"></option>
                        <option value="#FFFF00" style="background-color: #FFFF00;"></option>
                    </select>
                </div>
                <div> 
                    <textarea required name="description" rows="10" cols="30" placeholder="Description"></textarea>
                </div>
        </div>
        <div>
            <input type="submit" value="Post >">
            <input type="button" value="< Back" onclick="history.back(-1)" />
        </div>
        
        <script>
        function getSelectValues(select) {
        	  var result = [];
        	  var options = select && select.options;
        	  var opt;

        	  for (var i=0, iLen=options.length; i<iLen; i++) {
        	    opt = options[i];

        	    if (opt.selected) {
        	      result.push(opt.value || opt.text);
        	    }
        	  }
        	  return result;
        	}
        </script>
    </form>
    <c:if test="${not empty uploadMessage}">
		<div>${uploadMessage}</div>
	</c:if>
</body>