package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.User;
import util.SQL_Util;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (!SQL_Util.isEstablished())
			SQL_Util.initDataSource();
		
		String uscEmail = "";
		String password = "";
		uscEmail = request.getParameter("uscemail");
		password = request.getParameter("password");
		String next = "/login.jsp";
		String message = "";
		String loggedIn = "";
		
		int userID = SQL_Util.authenticate(uscEmail, password);
		
		if (userID == 0) {
			message = "No account was found, please try again";
			request.setAttribute("loginMessage", message);
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			
			return;
		}
		else {
			
			HttpSession session = request.getSession();

			session.setAttribute("user", SQL_Util.getUser(userID));
			

			loggedIn = "true";
			session.setAttribute("isLoggedIn", loggedIn);
			session.setAttribute("loggedBy", "login");

			
			response.sendRedirect("ActiveStatus");
			return;	
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
