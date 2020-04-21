package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import apple.laf.JRSUIConstants.Size;
import model.User;

/**
 * Servlet implementation class UploadProductServlet
 */
@WebServlet("/UploadProductServlet")
public class UploadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		boolean invalid = false;
		String productTags = request.getParameter("tags");
		
		if (productTags.charAt(0) != '#') {
			invalid = true;
		}

		//TODO: check all - if they are empty or full...
		String productBrand = request.getParameter("brand");
		String productName = request.getParameter("name");
		String colorOption = request.getParameter("color"); /* only getting the first/uppermost value */
		String itemType = request.getParameter("item");
		String productSize = request.getParameter("size");
		String productPrice = request.getParameter("price");
		
		productBrand = productBrand.trim();
		productName = productName.trim();
		//color
		itemType = itemType.trim();
		productSize = productSize.trim();
		productPrice = productPrice.trim();
		
		

		User user = (User)session.getAttribute("user");
		if (user == null) {
			System.out.println("user is null");
		}
		
		System.out.println("testing access permissions: " + user.getInterest());

		//System.out.println(colorOption);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
