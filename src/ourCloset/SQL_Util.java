package ourCloset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Timestamp;

public class SQL_Util {
	
	public static final String credentials = "jdbc:mysql://localhost/OurCloset?user=root&password=MySQLServer&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=America/Los_Angeles";
	static Connection connection;
	
	public static void initConnection() {
		if (connection != null) {
			System.out.println("[WARN] Connection has already been established.");
		}
		else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(credentials);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addUser(String uscEmail, String pass, String fName, String lName, boolean privacyStatus) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Users(uscEmail, pass, fName, lName, privacyStatus) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, uscEmail);
			ps.setString(2, pass);
			ps.setString(3, fName);
			ps.setString(4,  lName);
			ps.setBoolean(5, privacyStatus);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static User getUser(String uscEmail) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Users WHERE uscEmail = ?");
			ps.setString(1, uscEmail);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("userID"), rs.getString("uscEmail"), rs.getString("pass"), rs.getString("fName"), rs.getString("lName"), rs.getBoolean("privacyStatus"), rs.getTimestamp("lastLogin"), rs.getTimestamp("dateCreated"));
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static User getUser(int userID) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Users WHERE userID = ?");
			ps.setInt(1, userID);
			ps.execute();
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("userID"), rs.getString("uscEmail"), rs.getString("pass"), rs.getString("fName"), rs.getString("lName"), rs.getBoolean("privacyStatus"), rs.getTimestamp("lastLogin"), rs.getTimestamp("dateCreated"));
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static User removeUser(int userID) {
		User user = null;
		try {
			user = SQL_Util.getUser(userID);
			PreparedStatement ps = connection.prepareStatement("UPDATE Users SET valid = ? WHERE userID = ?");
			ps.setBoolean(1, false);
			ps.setInt(2, userID);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static void addProduct(int userID, String brand, String pName, int price, int quantity, boolean rent, boolean buy) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Products(userID, brand, pName, price, quantity, rent, buy) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, userID);
			ps.setString(2, brand);
			ps.setString(3, pName);
			ps.setInt(4, price);
			ps.setInt(5,  quantity);
			ps.setBoolean(6, rent);
			ps.setBoolean(7, buy);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Overloaded addProduct() which adds the description parameter to the end
	public static void addProduct(int userID, String brand, String pName, int price, int quantity, boolean rent, boolean buy, String description) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Products(userID, brand, pName, price, quantity, rent, buy, descrip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, userID);
			ps.setString(2, brand);
			ps.setString(3, pName);
			ps.setInt(4, price);
			ps.setInt(5,  quantity);
			ps.setBoolean(6, rent);
			ps.setBoolean(7, buy);
			ps.setString(8, description);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Overloaded addProduct() which adds the description and image_paths parameter to the end
	public static void addProduct(int userID, String brand, String pName, int price, int quantity, boolean rent, boolean buy, ArrayList<String> image_paths) {
		try {
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO Products(userID, brand, pName, price, quantity, rent, buy) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps1.setInt(1, userID);
			ps1.setString(2, brand);
			ps1.setString(3, pName);
			ps1.setInt(4, price);
			ps1.setInt(5,  quantity);
			ps1.setBoolean(6, rent);
			ps1.setBoolean(7, buy);
			ps1.execute();
			ps1.close();
			
			PreparedStatement ps2 = connection.prepareStatement("INSERT INTO Images(productID, filename) VALUES ((SELECT LAST_INSERT_ID()), ?)");
			for (int i = 0; i < image_paths.size(); i++) {
				ps2.setString(1, "images/" + image_paths.get(i));
				ps2.addBatch();
			}
			ps2.executeBatch();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Overloaded addProduct() which adds the description and image_paths parameter to the end
	public static void addProduct(int userID, String brand, String pName, int price, int quantity, boolean rent, boolean buy, String description, ArrayList<String> image_paths) {
		try {
			PreparedStatement ps1 = connection.prepareStatement("INSERT INTO Products(userID, brand, pName, price, quantity, rent, buy, descrip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps1.setInt(1, userID);
			ps1.setString(2, brand);
			ps1.setString(3, pName);
			ps1.setInt(4, price);
			ps1.setInt(5,  quantity);
			ps1.setBoolean(6, rent);
			ps1.setBoolean(7, buy);
			ps1.setString(8, description);
			ps1.execute();
			ps1.close();
			
			PreparedStatement ps2 = connection.prepareStatement("INSERT INTO Images(productID, filename) VALUES ((SELECT LAST_INSERT_ID()), ?)");
			for (int i = 0; i < image_paths.size(); i++) {
				ps2.setString(1, "images/" + image_paths.get(i));
				ps2.addBatch();
			}
			ps2.executeBatch();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeProduct(int productID) {
		try {
			SQL_Util.removeTags(productID);
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Products WHERE productID = ? AND ? NOT IN (SELECT productID FROM Transactions)");
			ps.setInt(1, productID);
			ps.setInt(2,  productID);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Transaction> getTransactions(int userID) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Transactions WHERE buyerID = ? OR sellerID = ?");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("productID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
				transactions.add(transaction);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}
	
	public static void addTransaction(int productID, int buyerID) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Transactions(productID, buyerID) VALUES (?, ?)");
			ps.setInt(1, productID);
			ps.setInt(2, buyerID);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addTag(int productID, String tagName) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Tags(productID, tagName) VALUES (?, ?)");
			ps.setInt(1, productID);
			ps.setString(2, tagName);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Tag> getTags(int productID) {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Tags WHERE productID = ?");
			ps.setInt(1,  productID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tag tag = new Tag(rs.getInt("tagID"), rs.getInt("productID"), rs.getString("tagName"));
				tags.add(tag);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}
	
	public static ArrayList<Tag> removeTags(int productID) {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			tags = SQL_Util.getTags(productID);
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Tags WHERE productID = ?");
			ps.setInt(1, productID);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}
	
	public static ArrayList<Product> handleProducts(ResultSet rs) {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			while (rs.next()) {
				int productID = rs.getInt("productID");
				int userID = rs.getInt("userID");
				String brand = rs.getString("brand");
				String pName = rs.getString("pName");
				String descrip = rs.getString("descrip");
				double price = rs.getDouble("price");
				short quantity = rs.getShort("quantity");
				boolean rent = rs.getBoolean("rent");
				boolean buy = rs.getBoolean("buy");
				Timestamp datePosted = rs.getTimestamp("datePosted");
				
				PreparedStatement ps2 = connection.prepareStatement("SELECT Images.filename FROM Images WHERE Images.productID = ?");
				ps2.setInt(1, productID);
				ResultSet rs2 = ps2.executeQuery();
				ArrayList<String> image_paths = new ArrayList<String>();
				while(rs2.next()) {
					image_paths.add(rs2.getString("filename"));
				}
				
				ps2.close();
				rs2.close();
								
				Product product = new Product(productID, userID, brand, pName, descrip, price, quantity, rent, buy, datePosted, image_paths);
				
				products.add(product);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	// this method returns all available items (not yet sold)
	public static ArrayList<Product> getListedProducts() {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM Products WHERE Products.productID NOT IN (SELECT productID FROM Transactions)");
			ResultSet rs1 = ps1.executeQuery();
			products = handleProducts(rs1);
			
			ps1.close();
			rs1.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	// this method returns a user's product history
	public static ArrayList<Product> getProductHistory(int userID) {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE userID = ?");
			ps.setInt(1,  userID);
			ResultSet rs = ps.executeQuery();
			products = handleProducts(rs);
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	// this method returns the 8 most recently sold items (trending items)
	public static ArrayList<Product> recentlySold() {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT P.* FROM Products P JOIN Transactions ON P.productID=Transactions.productID ORDER BY dateSold ASC LIMIT 8");
			ResultSet rs = ps.executeQuery();
			products = handleProducts(rs);
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	// this method gets a user's selling history
	public static ArrayList<Transaction> getSellHistory(int userID) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT T.* FROM Transactions T JOIN Products ON T.productID=Products.productID WHERE userID = ?");
			ps.setInt(1,  userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("productID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
				transactions.add(transaction);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

	// this method gets a user's buying history
	public static ArrayList<Transaction> getBuyHistory(int userID) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Transactions WHERE buyerID = ?");
			ps.setInt(1,  userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("productID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
				transactions.add(transaction);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

	// this method returns the 5 most popular tags for items sold (could be used for a suggested feature when users are uploading products)
	public static ArrayList<Tag> getPopularTags() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT TG.* From Tags TG JOIN Transactions ON TG.productID=Transactions.productID GROUP BY tagID ORDER BY COUNT(*) DESC LIMIT 5");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tag tag = new Tag(rs.getInt("tagID"), rs.getInt("productID"), rs.getString("tagName"));
				tags.add(tag);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}

	// this method gets the average listed price of current items (not yet sold)
	public static double getAvgListedPrice() {
		double price = 0;
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT AVG(Products.price) as price FROM Products WHERE Products.productID NOT IN (SELECT productID FROM Transcations");

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				price = rs.getDouble("price");
			}
			ps.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

	// this method gets the average price of all items sold 
	public static double getAvgSellingPrice() {
		double price = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT AVG(Products.price) as price FROM Products WHERE Products.productID IN (SELECT productID FROM Transcation");

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				price = rs.getDouble("price");
			}
			ps.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}

	// this method gets all items available for rent
	public static ArrayList<Product> forRent() {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE rent = 1");
			ResultSet rs = ps.executeQuery();
			products = handleProducts(rs);
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	// this method gets all items available for purchase
	public static ArrayList<Product> forBuy() {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE buy = 1");
			ResultSet rs = ps.executeQuery();
			products = handleProducts(rs);
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	// this method returns all items available for less than or equal to the given price
	public static ArrayList<Product> maxPrice(int maxPrice) {
		ArrayList<Product> products = null;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE Products.productID NOT IN (SELECT productID FROM Transcations) AND price <= ?");
			ps.setInt(1, maxPrice);
			ResultSet rs = ps.executeQuery();
			products = handleProducts(rs);
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	// Clears all entries in the database but doesn't drop the actual tables
	public static void clear() {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Tags");
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("ALTER TABLE Tags AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("DELETE FROM Transactions");
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("ALTER TABLE Transactions AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("DELETE FROM Images");
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("ALTER TABLE Images AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("DELETE FROM Products");
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("ALTER TABLE Products AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("DELETE FROM Users");
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("ALTER TABLE Users AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}