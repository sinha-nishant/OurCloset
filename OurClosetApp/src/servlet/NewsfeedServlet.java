package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import util.SQL_Util;

/**
 * Servlet implementation class NewsfeedServlet
 */
@WebServlet("/newsfeed")
public class NewsfeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsfeedServlet() {
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

		// get trending posts
		ArrayList<Product> trending = SQL_Util.getPopularProducts();
		request.setAttribute("trending", trending);
		System.out.println("trending size in the servlet : " + trending.size());
		// get posts by recent order
		ArrayList<Product> recent = SQL_Util.getAllProducts();
		System.out.println("trending size in the servlet : " + recent.size());

		request.setAttribute("recent", recent);
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/newsfeed.jsp");
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
