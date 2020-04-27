 include a README.txt file in your project in the doc/ folder of your project that explains what works and what doesn't, along with any other nuances with your project about which the graders should be aware.

 To deploy this application within Eclipse, import the CS201_FinalProject_OurClosetApp.zip file using the built in import function. This should generate a project called OurClosetApp with root folders src, images, assets, and a MySQL script. The WebContent folder contains the page jsps. The src folder contains the client, server, servlet, and backend classes and code. Assets such as images will also be included in the project folder.

We are using four outside libraries:
mysql-connector-java-8.0.19.jar
Jstl-1.2.jar
Bootstrap 
jQuery
HikariCP-3.4.2.jar
slf4j-api-1.7.9.jar
slf4j-nop-1.7.9.jar
tomcat-servlet-api-9.0.1.jar

Step-by-step instructions on how to run the program:
Execute the OurCloset.sql file in your MySQL Workbench
Change password on line 41 in SQL_Util.java to your password for MySQL server
Run test.java
To execute the server for OurCloset, run the Server inside the networking package.
To start OurCloset, open the login.jsp with a browser such as Chrome.
In the login page, you can choose to login if you already have an account or sign up if you do not have an account.
If you do not want to login or register, you can go to the main page with limited functionality by clicking the “View as Guest” button.
After you have logged in, you can then start to explore OurCloset!
