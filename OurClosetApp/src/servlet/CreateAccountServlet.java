package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
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

		System.out.println("In the servlet");
		if (!SQL_Util.isEstablished())
			SQL_Util.initDataSource();
		
		String newEmail = "";
		String newFirstName = "";
		String newLastName = "";

		String newPassword = request.getParameter("password");
		
		String next = "/createAccount.jsp";
		String message = "";
		String loggedIn = "";
		
		newEmail = request.getParameter("email");
		newFirstName = request.getParameter("firstName");
		newLastName = request.getParameter("lname");
		newPassword = request.getParameter("password");	
		String path = "";

		//empty input
		if (newEmail == null || newEmail == "" || newFirstName == null || newFirstName == "" || newLastName == null || newLastName == ""
				|| newPassword == null || newPassword == "") {
	
			message = "Please fill all the inputs above.";
			request.setAttribute("createAccountMessage", message);
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			return;
		}
		
		//non-USC email
		else if (!("@" + newEmail.split("@")[1]).contentEquals("@usc.edu")) {
			System.out.println("Email is Wrong");

			message = "Please enter a USC email.";
			request.setAttribute("createAccountMessage", message);

			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			return;
		}
		
		//user already exists
		else if (SQL_Util.checkIfExists(newEmail.split("@")[0])) {
			System.out.println("Account already exists");

			message = "This email address is already registered.";
			request.setAttribute("createAccountMessage", message);
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			return;
		}
		
		else {
			System.out.println("Valid - not exists");
			
			path = newEmail + "Path";			
		
			SQL_Util.addUser(new User(newEmail.split("@")[0], newPassword, newFirstName, newLastName, path));
			//Integer userID = SQL_Util.authenticate(newEmail.split("@")[1], newPassword);

			HttpSession session = request.getSession();
			
			session.setAttribute("idName", newEmail.split("@")[0]);
			session.setAttribute("password", newPassword);

			loggedIn = "true";
			session.setAttribute("isLoggedIn", loggedIn);

			response.sendRedirect("ActiveStatus");
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

