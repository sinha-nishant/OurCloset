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

import org.apache.taglibs.standard.tag.common.sql.TransactionTagSupport;

import apple.laf.JRSUIConstants.Size;
import model.Product;
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
		String next = "/uploadProduct.jsp";
				
		boolean invalid = false;
		String message = "";

		//TODO: check all - if they are empty or full...
		String productBrand = request.getParameter("brand");
		String productName = request.getParameter("name");
		String colorOption = request.getParameter("color");
		String itemType = request.getParameter("item");
		String productSize = request.getParameter("size");
		String productPrice = request.getParameter("price");
		String productTags = request.getParameter("tags");
		String description = request.getParameter("description");

		System.out.println("printing color - " + colorOption); /* only getting the first/uppermost value */
		
		Double productPriceCasted = Double.parseDouble(productPrice);
		
		//trim strings
		productName = productName.trim();
		itemType = itemType.trim();
		productSize = productSize.trim();
		productPrice = productPrice.trim();
		
		
		ArrayList<String> colorList = new ArrayList<String>();
		/**
		 * 
		 * For now, just add the only color code you can access - to be fixed probably
		 */
		colorList.add(colorOption);

		
		//checking for null - brand
		boolean brandNull = true;
		ArrayList<String> tagsList = null;
		if (productBrand != null || !productBrand.contentEquals("")) {
			productBrand = productBrand.trim();
			brandNull = false;
		}
		
		//checking for null - tags
		boolean tagsNull = true;
		if (productTags != null || !productTags.contentEquals("")) {
			
			if (productTags.charAt(0) != '#') {
				message = "Please make sure that you start with a '#'.";
				session.setAttribute("uploadMessage", message);
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
				dispatch.forward(request, response);

			}
			else {
				message = "";
				session.setAttribute("uploadMessage", message);
				tagsNull = false;
				
				//up to 10 tags - split (rest, rip)
				char val = '#';
				int count = 0;
				for (int i = 0; i < productTags.length(); i++) {
					if (productTags.charAt(i) == val) count++;
				}
				
				tagsList = new ArrayList<String>();
				String [] arr = productTags.split("#", count+1);
				for (int i = 0; i <= count; i++) {
					tagsList.add(arr[i]);
				}
				tagsList.remove(0);
				
				System.out.println("size of the hashtag list - " + tagsList.size());
				for (int i = 0; i < tagsList.size(); i++) {
					System.out.println("name at index " + i + " is " + tagsList.get(i));
				}
			}
		}
		
		ArrayList<String> imagePaths = null;
		imagePaths.add("TODO");
		
		//testing user object accessibility::
		User user = (User)session.getAttribute("user");
		if (user == null) {
			System.out.println("Something is wrong - user is null in upload product servlet!");
		}
		else {
			int sellerID = user.getID();
			System.out.println("milestone: moving to construct the product object");
			
			if (!brandNull && !tagsNull) {
				model.Product product = new model.Product(sellerID, productBrand, productName, colorList, itemType, productSize, description, tagsList, 0.0, productPriceCasted, imagePaths);
			}
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
