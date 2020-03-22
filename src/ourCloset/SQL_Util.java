package ourCloset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQL_Util {
	
	public static final String credentials = "jdbc:mysql://localhost/OurCloset?user=root&password=NS@1048169&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=America/Los_Angeles";
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
	
	public static void addPost(int userID, String brand, String pName, int price, int quantity, boolean rent, boolean buy) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Posts(userID, brand, pName, price, quantity, rent, buy) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
	
	// Overloaded addPost() which adds the description parameter to the end
	public static void addPost(int userID, String brand, String pName, int price, int quantity, boolean rent, boolean buy, String description) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Posts(userID, brand, pName, price, quantity, rent, buy, descrip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
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
	
	public static void removePost(int postID) {
		try {
			SQL_Util.removeTags(postID);
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Posts WHERE postID = ? AND ? NOT IN (SELECT postID FROM Transactions)");
			ps.setInt(1, postID);
			ps.setInt(2,  postID);
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
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("postID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
				transactions.add(transaction);
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}
	
	public static void addTransaction(int postID, int buyerID) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Transactions(postID, buyerID) VALUES (?, ?)");
			ps.setInt(1, postID);
			ps.setInt(2, buyerID);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addTag(int postID, String tagName) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Tags(postID, tagName) VALUES (?, ?)");
			ps.setInt(1, postID);
			ps.setString(2, tagName);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Tag> getTags(int postID) {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Tags WHERE postID = ?");
			ps.setInt(1,  postID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tag tag = new Tag(rs.getInt("tagID"), rs.getInt("postID"), rs.getString("tagName"));
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
	
	public static ArrayList<Tag> removeTags(int postID) {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			tags = SQL_Util.getTags(postID);
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Tags WHERE postID = ?");
			ps.setInt(1, postID);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tags;
	}

	// this method returns all available items (not yet sold)
	public static ArrayList<Post> getListedPosts() {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Posts WHERE Posts.postID NOT IN (SELECT postID FROM Transactions)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getInt("userID"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("rent"), rs.getBoolean("buy"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	
	// this method returns a user's post history
	public static ArrayList<Post> getPostHistory(int userID) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Posts WHERE userID = ?");
			ps.setInt(1,  userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getInt("userID"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("rent"), rs.getBoolean("buy"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	
	// this method returns the 8 most recently sold items (trending items)
	public static ArrayList<Post> recentlySold() {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT P.* FROM Posts P JOIN Transactions ON P.postID=Transactions.postID ORDER BY dateSold ASC LIMIT 8");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getInt("userID"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("rent"), rs.getBoolean("buy"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}

	// this method gets a user's selling history
	public static ArrayList<Transaction> getSellHistory(int userID) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT T.* FROM Transactions T JOIN Posts ON T.postID=Posts.postID WHERE userID = ?");
			ps.setInt(1,  userID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("postID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
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
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("postID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
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

	// this method returns the 5 most popular tags for items sold (could be used for a suggested feature when users are uploading posts)
	public static ArrayList<Tag> getPopularTags() {
		ArrayList<Tag> tags = new ArrayList<Tag>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT TG.* From Tags TG JOIN Transactions ON TG.postID=Transactions.postID GROUP BY tagID ORDER BY COUNT(*) DESC LIMIT 5");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tag tag = new Tag(rs.getInt("tagID"), rs.getInt("postID"), rs.getString("tagName"));
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
			
			PreparedStatement ps = connection.prepareStatement("SELECT AVG(Posts.price) as price FROM Posts WHERE Posts.postID NOT IN (SELECT postID FROM Transcations");

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
			PreparedStatement ps = connection.prepareStatement("SELECT AVG(Posts.price) as price FROM Posts WHERE Posts.postID IN (SELECT postID FROM Transcation");

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
	public static ArrayList<Post> forRent() {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Posts WHERE rent = 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getInt("userID"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("rent"), rs.getBoolean("buy"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}

	// this method gets all items available for purchase
	public static ArrayList<Post> forBuy() {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Posts WHERE buy = 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getInt("userID"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("rent"), rs.getBoolean("buy"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}

	// this method returns all items available for less than or equal to the given price
	public static ArrayList<Post> maxPrice(int maxPrice) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Posts WHERE Posts.postID NOT IN (SELECT postID FROM Transcations) AND price <= ?");
			ps.setInt(1, maxPrice);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getInt("userID"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("rent"), rs.getBoolean("buy"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
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
			
			ps = connection.prepareStatement("DELETE FROM Posts");
			ps.execute();
			ps.close();
			
			ps = connection.prepareStatement("ALTER TABLE Posts AUTO_INCREMENT = ?");
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