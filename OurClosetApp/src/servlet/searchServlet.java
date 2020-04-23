package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public searchServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//System.out.println("in searchServlet");
		String message = "";
		String next = "/search.jsp";
		String productName = request.getParameter("track_name");
		
		if (productName != null) productName = productName.trim();
		if (productName == null || productName == "") {
			message = "Please make sure you have a product to search for";
			session.setAttribute("searchMessage", message);
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			return;
		}
		
		else {
			
		}
		
		
		String tagsInOne = request.getParameter("track_tag");
		if (tagsInOne != null) {
			if (!tagsInOne.contains("#")) {
				message = "Please make sure that you have # in the tags section";
				session.setAttribute("searchMessage", message);
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
				dispatch.forward(request, response);
				return;
			}
			else {
				char someChar = '#';
				int count = 0;
				for (int i = 0; i < tagsInOne.length(); i++) {
				    if (tagsInOne.charAt(i) == someChar) {
				    	count++;
					}
				}
				if (count != 0) {
					String [] tags = tagsInOne.split("#", 10);		
					for (int i = 0; i < count; i++) {
						System.out.println(tags[count]);
					}
				}
			}
		}	
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/search_results.html");
		dispatch.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
