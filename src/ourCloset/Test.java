package ourCloset;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		SQL_Util.initDataSource();
		SQL_Util.clear();
		User user = new User("sinhan", "xyz", "Nish", "Sinha", "somePath");
		SQL_Util.addUser(user);
		System.out.println(SQL_Util.authenticate("sinhan", "xyz"));
		System.out.println(SQL_Util.authenticate("sinhan", "abc"));
		System.out.println(SQL_Util.authenticate("sinhan@usc.edu", "xyz"));
		System.out.println(SQL_Util.authenticate("sinhan@usc.edu", "abc"));
		ArrayList<Tag> tags = new ArrayList<Tag>();
		tags.add(new Tag(1, "Summer"));
		tags.add(new Tag(1, "Italian"));
		ArrayList<String> imagePaths = new ArrayList<String>();
		imagePaths.add("somePath1");
		imagePaths.add("somePath2");
		Product product = new Product(1, "Pagani", "Huayra", "Silver", "Car", "Medium", "Hypercar", tags, 1.00, 999.99, (short) 2, imagePaths);
		SQL_Util.addProduct(product);
		Comment comment = new Comment(1, 1, "someComment");
		SQL_Util.addComment(comment);
		Product retrievedProduct = SQL_Util.getProducts(1).get(0);
		System.out.println(retrievedProduct);
	}
}