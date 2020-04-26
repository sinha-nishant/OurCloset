package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.image.IntToBytePixelConverter;

import model.Interest;
import util.SQL_Util;

/**
 * Servlet implementation class InterestCounterServlet
 */
@WebServlet("/interestCounter")
public class InterestCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterestCounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("interest servlet working");
		Boolean addToInterest = Boolean.parseBoolean((String) request.getParameter("addToInterest"));
		int productID = Integer.parseInt((String)request.getParameter("productID")); 
		int userID = (int) request.getSession().getAttribute("user"); 
		if (addToInterest) {
			Interest interest = new Interest(userID, productID);
			SQL_Util.addInterest(interest);
		}
		else {
			// maybe remove interest, probably not
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
