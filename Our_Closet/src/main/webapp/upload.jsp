<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
</head>
<body>
    <center>
        <h1>Upload Item</h1>
        <form method="post" action="uploadServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>userID: </td>
                    <td><input type="text" name="userID" size="50"/></td>
                </tr>
                <tr>
                    <td>Brand: </td>
                    <td><input type="text" name="brand" size="50"/></td>
                </tr>
                <tr>
                    <td>Product Name: </td>
                    <td><input type="text" name="pName" size="50"/></td>
                </tr>
                <tr>
                    <td>Short Description: </td>
                    <td><input type="text" name="descrip" size="50"/></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="text" name="price" size="50"/></td>
                </tr>
                <tr>
                    <td>Quantity: </td>
                    <td><input type="number" name="quantity" size="50"/></td>
                </tr>
                <tr>
                    <td>Rent: </td>
                    <td><input type="number" name="rent" size="50"/></td>
                </tr>
                <tr>
                    <td>Buy: </td>
                    <td><input type="number" name="buy" size="50"/></td>
                </tr>
                <!-- <tr>
                    <td><input type="checkbox" id="rent" name="rent" value="1">
					<label for="rent"> Rent</label><br></td>
                </tr>
                <tr>
                    <td><input type="checkbox" id="buy" name="buy" value="1">
					<label for="buy"> Buy</label><br></td>
                </tr> -->
                <tr>
                    <td>Image: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>