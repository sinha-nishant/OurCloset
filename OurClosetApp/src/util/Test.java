package util;

import java.util.ArrayList;
import model.*;

public class Test {

	public static void main(String[] args) {
		SQL_Util.initDataSource();
		SQL_Util.clear();
		User user = new User("sinhan", "xyz", "Nish", "Sinha", "somePathNish");
		SQL_Util.addUser(user);
		user = new User("alexanrq", "abc", "Alex", "Qiu", "somePathAlex");
		SQL_Util.addUser(user);
		System.out.println(SQL_Util.authenticate("sinhan", "xyz"));
		System.out.println(SQL_Util.authenticate("sinhan", "abc"));
		System.out.println(SQL_Util.authenticate("sinhan@usc.edu", "xyz"));
		System.out.println(SQL_Util.authenticate("sinhan@usc.edu", "abc"));
		System.out.println(SQL_Util.getUser(2).getFirstName() + " " + SQL_Util.getUser(2).getLastName());
		ArrayList<Tag> tags1 = new ArrayList<Tag>();
		tags1.add(new Tag(1, "Summer"));
		tags1.add(new Tag(1, "Italian"));
		ArrayList<String> imagePaths = new ArrayList<String>();
		ArrayList<String> colors1 = new ArrayList<String>();
		colors1.add("aaa9ad");
		colors1.add("#20262c");
		imagePaths.add("somePath1");
		imagePaths.add("somePath2");
		Product product = new Product(1, "Pagani", "Huayra", colors1, "Car", "Medium", "Hypercar", tags1, 1.00, 999.99, imagePaths);
		SQL_Util.addProduct(product);
		ArrayList<Tag> tags2 = new ArrayList<Tag>();
		tags2.add(new Tag(2, "Track"));
		tags2.add(new Tag(2, "British"));
		ArrayList<String> colors2 = new ArrayList<String>();
		colors2.add("#a12929");
		colors2.add("#20262c");
		product = new Product(1, "McLaren", "P1", colors2, "Car", "Medium", "Hypercar", tags2, 1.00, 999.99, imagePaths);
		SQL_Util.addProduct(product);
		Comment comment = new Comment(2, 1, "someComment");
		SQL_Util.addComment(comment);
		SQL_Util.addInterest(new Interest(2, 1));
//		Product retrievedProduct = SQL_Util.getProductsByUser(1).get(0);
//		System.out.println(retrievedProduct);
		
		System.out.println("\n\n" + SQL_Util.getAllProducts().toString());
		
		System.out.println("\n\n" + SQL_Util.getNotifications(1));
	}
}