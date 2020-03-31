package com.FinalProject.Our_Closet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/xxx";
    private String dbUser = "root";
    private String dbPass = "secret";
    public static final String CREDENTIAL_STRING = "jdbc:mysql://localhost:3306/xxx?user=root&password=yyy!&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
     
    /* replace 'xxx' with database name, and 'yyy' with your MySQL password */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String userID = request.getParameter("userID");
        String brand = request.getParameter("brand");
        String pName = request.getParameter("pName");
        String descrip = request.getParameter("descrip");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String rent = request.getParameter("rent");
        String buy = request.getParameter("buy");
         
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(CREDENTIAL_STRING);
    
 
            // constructs SQL statement
            String sql = "INSERT INTO Posts (userID, brand, pName, descrip, price, quantity, rent, buy, photo) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userID);
            statement.setString(2, brand);
            statement.setString(3, pName);
            statement.setString(4, descrip);
            statement.setString(5, price);
            statement.setString(6, quantity);
            statement.setString(7, rent);
            statement.setString(8, buy);
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(9, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);
             
            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
    }
}
