package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.UserException;

import com.sun.xml.internal.bind.v2.model.core.ID;

import model.User;
import util.SQL_Util;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (!SQL_Util.isEstablished())
			SQL_Util.initDataSource();
		
		String next = "/login.jsp";
		String message = "";
		String loggedIn = "";
		
		String newEmail = request.getParameter("email");
		String newFirstName = request.getParameter("fname");
		String newLastName = request.getParameter("lname");
		String newPassword = request.getParameter("password");
		
        String[] arr = newEmail.split("@"); 
        
        if (!arr[2].contentEquals("@usc.edu")) {
			message = "Please make sure that you enter a USC email";
			request.setAttribute("nonUSCEmail", message);
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			return;
        }
        
		model.User newUser = SQL_Util.getUser(Integer.parseInt(arr[1]));

		
		if (newUser == null) {
			SQL_Util.addUser(new model.User(arr[0]+arr[1], newPassword, newFirstName, newLastName, null));
			next = "/newsfeed";
			HttpSession session = request.getSession();
			session.setAttribute("user", SQL_Util.getUser(Integer.parseInt(arr[0])));
			loggedIn = "true";
			session.setAttribute("isLoggedIn", loggedIn);
		} else {
			message = "The account already exists.";
			request.setAttribute("accountExists", message);	
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
		dispatch.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
