To deploy this application within Eclipse, import the CS201_FinalProject_OurClosetApp.zip file using the built in import function. This should generate a project called OurClosetApp with root folders src, images, assets, and a MySQL script. The WebContent folder contains the page jsps. The src folder contains the client, server, servlet, and backend classes and code. Assets such as images will also be included in the project folder.

### We are using 8 outside libraries:
 - mysql-connector-java-8.0.19.jar
 - Jstl-1.2.jar
 - Bootstrap 
 - jQuery
 - HikariCP-3.4.2.jar
 - slf4j-api-1.7.9.jar
 - slf4j-nop-1.7.9.jar
 - tomcat-servlet-api-9.0.1.jar

### Step-by-step instructions on how to run the program:
 1. Execute the OurCloset.sql file in your MySQL Workbench
 2. Change password on line 41 in SQL_Util.java to your password for MySQL server
 3. Run test.java
 4. To execute the server for OurCloset, run the Server inside the networking package.
 5. To start OurCloset, open the login.jsp with a browser such as Chrome.
 6. In the login page, you can choose to login if you already have an account or sign up if you do not have an account. If this does not seem to be working, sign in with email: sinhan@usc.edu and password : "xyz"
 7. If you do not want to login or register, you can go to the main page with limited functionality by clicking the “View as Guest” button.
 8. After you have logged in, you can then start to explore OurCloset!

### Bugs:
 - User can show interest in same post repeatedly if they refresh the page
 - User can instantly add a product they just added by refreshing the home page immediately after submitting a new product
 - Notifications aren't updated for a seller's page after prospective buyer adds a comment or indicates interest
 - Can only start the program through login.jsp
 - If screen size is decreased below a certain size (ie below 400 pixels in width), Trending may not be viewable
 - Sometimes the JRE system library becomes unbound in the build path, correct this by deleting this JRE and adding the 'system default' JRE
