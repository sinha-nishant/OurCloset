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
			System.out.println((String)(session.getAttribute("loggedBy")));
		}
		/*
		 * If from create account
		 */
		if (((String)session.getAttribute("loggedBy")).contentEquals("create account")) {
			System.out.println("in Active Status -> redirected to: Create Account");
			String uniqueName = (session.getAttribute("idName")).toString();
			int id = (SQL_Util.authenticate(session.getAttribute("idName").toString(), session.getAttribute("password").toString()));
			session.setAttribute("user", SQL_Util.getUser(id));

			User user = (User)session.getAttribute("user");
			String emailString = user.getEmail();
			//System.out.println("Testing -- " + emailString);
		}
		
		
		/*
		 * If from login -> do nothing - already established (just testin)
		 */	
		else {
			System.out.println("inside");
			System.out.println(((User)session.getAttribute("user")).getInterest());
		}

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/newsfeed.jsp");
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
