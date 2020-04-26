package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import model.Interest;
import model.User;
import util.SQL_Util;

/**
 * Servlet implementation class loggedIn
 */
@WebServlet("/ActiveStatus")
public class ActiveStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
			
		
		if (session.getAttribute("loggedBy") != null) {
			//System.out.println("Logged by is not null -> " + (String)(session.getAttribute("loggedBy")));
		}
		/*
		 * If from create account
		 */
		if (((String)session.getAttribute("loggedBy")).contentEquals("create account")) {
			//System.out.println("in Active Status -> redirected to: Create Account");
			
			//User user = new User(session.get, password, fName, lName, profileImagePath)
			
			int id = (SQL_Util.authenticate(session.getAttribute("email").toString(), session.getAttribute("password").toString()));
			session.setAttribute("user", id);
			System.out.println("After authenticate execution -- id of the user is " + id);
			
			
			
		}
		
		
		/*
		 * If from login -> do nothing - already established (just testin)
		 */	
		else {
			SQL_Util.addInterest(new Interest(2, 1));
		}

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/newsfeed");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
