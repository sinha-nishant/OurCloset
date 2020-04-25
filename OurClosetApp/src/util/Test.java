package util;

import java.util.ArrayList;
import model.*;

public class Test {

	public static void main(String[] args) {
		SQL_Util.initDataSource();
		SQL_Util.clear();
		User user1 = new User("sinhan", "xyz", "Nish", "Sinha", "somePathNish");
		SQL_Util.addUser(user1);
		User user2 = new User("alexanrq", "abc", "Alex", "Qiu", "somePathAlex");
		SQL_Util.addUser(user2);
		User user3 = new User("anjaleep", "123", "Anjalee", "Patel", "somePathAnjalee");
		SQL_Util.addUser(user3);
		User user4 = new User("floreny", "000", "Florence", "Yang", "somePathFlorence");
		SQL_Util.addUser(user4);
		System.out.println(SQL_Util.authenticate("sinhan", "xyz"));
		System.out.println(SQL_Util.authenticate("sinhan", "abc"));
		System.out.println(SQL_Util.authenticate("sinhan@usc.edu", "xyz"));
		System.out.println(SQL_Util.authenticate("sinhan@usc.edu", "abc"));
		System.out.println(SQL_Util.getUser(2).getFirstName() + " " + SQL_Util.getUser(2).getLastName());
		ArrayList<Tag> tags1 = new ArrayList<Tag>();
		tags1.add(new Tag("Summer"));
		tags1.add(new Tag("Italian"));
		ArrayList<String> imagePaths = new ArrayList<String>();
		ArrayList<String> colors1 = new ArrayList<String>();
		colors1.add("aaa9ad");
		colors1.add("#20262c");
		imagePaths.add("somePath1");
		imagePaths.add("somePath2");
		Product product = new Product(1, "Pagani", "Huayra", colors1, "Car", "Medium", "Hypercar", tags1, 1.00, 825.00, imagePaths);
		SQL_Util.addProduct(product);
		ArrayList<Tag> tags2 = new ArrayList<Tag>();
//		tags2.add(new Tag(2, "Track"));
//		tags2.add(new Tag(2, "British"));
		ArrayList<String> colors2 = new ArrayList<String>();
		colors2.add("#a12929");
		colors2.add("#20262c");
		product = new Product(2, "McLaren", "P1", colors2, "Car", "Small", "Hypercar", tags2, 1.00, 999.99, imagePaths);
		SQL_Util.addProduct(product);
		ArrayList<Tag> tags3 = new ArrayList<Tag>();
		tags3.add(new Tag("GT"));
		tags3.add(new Tag("German"));
		ArrayList<String> colors3 = new ArrayList<String>();
		colors3.add("aaa9ad");
		colors3.add("#20262c");
		product = new Product(2, "Porsche", "918", colors3, "Car", "Medium", "Hypercar", tags3, 1.00, 845.00, imagePaths);
		SQL_Util.addProduct(product);
		Comment comment = new Comment(2, 1, "someComment");
		SQL_Util.addComment(comment);
		SQL_Util.addInterest(new Interest(2, 1));
		SQL_Util.addInterest(new Interest(1, 2));
		SQL_Util.addInterest(new Interest(3, 1));
		SQL_Util.addInterest(new Interest(4, 1));
		SQL_Util.addInterest(new Interest(4, 2));
		SQL_Util.addInterest(new Interest(3, 3));
		SQL_Util.addInterest(new Interest(1, 3));
		SQL_Util.addInterest(new Interest(2, 3));

//		Product retrievedProduct = SQL_Util.getProductsByUser(1).get(0);
//		System.out.println(retrievedProduct);
		
		System.out.println("\n\n" + SQL_Util.getAllProducts().toString());
		
		System.out.println("\n\n" + SQL_Util.getNotifications(1));
		
		System.out.println("\n\nPopular products:");
		
		System.out.println(SQL_Util.getPopularProducts().toString());
		
		System.out.println("\n\nProducts by price:");
		
		System.out.println(SQL_Util.getProductsByPrice().toString());
		
		System.out.println("\n\nProducts with color #aa9ad");
		
		System.out.println(SQL_Util.getProductsByColor("#aa9ad").toString());
	}
}