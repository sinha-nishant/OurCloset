package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		/*
		 * If from login -> do nothing - already established
		 */		


		/*
		 * If from create account
		 */
		if (session.getAttribute("idName") != null && session.getAttribute("password") != null) {
			String uniqueName = (session.getAttribute("idName")).toString();
			int id = (SQL_Util.authenticate(session.getAttribute("idName").toString(), session.getAttribute("password").toString()));
			session.setAttribute("user", SQL_Util.getUser(id));
			
			User user = (User)session.getAttribute("user");
			String emailString = user.getEmail();
			//System.out.println("Testing -- " + emailString);
		}

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/hometest.jsp");
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
