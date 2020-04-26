package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;


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
		ArrayList<String> tagsList = new ArrayList<String>();
		//if at least one tag is specified
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
						//System.out.println(tags[count]);
						tagsList.add(tags[count]);
					}
				}
			}
		}
		//check name
		
		ArrayList<Product> finalizedArrayList = new ArrayList<Product>();
		
		ArrayList<String> imagePaths = new ArrayList<String>();
		imagePaths.add("images/coding-onesie.jpg");
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("#FF0000");
		
		Product product = new Product(1, "McLaren", "P1", colors, "Car", "Small", "Hypercar", 1.00, 999.99, imagePaths);
		finalizedArrayList.add(product);
		session.setAttribute("searchedItems", finalizedArrayList);

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/search_results.jsp");
		dispatch.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
