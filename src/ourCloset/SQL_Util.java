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
			return;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(credentials);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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
	
	public static void addPost(String uscEmail, String brand, String pName, int price, int quantity, boolean saleType) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Posts(uscEmail, brand, pName, price, quantity, saleType) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, uscEmail);
			ps.setString(2, brand);
			ps.setString(3, pName);
			ps.setInt(4, price);
			ps.setInt(5,  quantity);
			ps.setBoolean(6, saleType);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Overloaded addPost() which adds the description parameter to the end
	public static void addPost(String uscEmail, String brand, String pName, int price, int quantity, boolean saleType, String description) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Posts(uscEmail, brand, pName, price, quantity, saleType, descrip) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, uscEmail);
			ps.setString(2, brand);
			ps.setString(3, pName);
			ps.setInt(4, price);
			ps.setInt(5,  quantity);
			ps.setBoolean(6, saleType);
			ps.setString(7, description);
			ps.execute();
			ps.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addTransaction(int postID, String seller, String buyer) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Transactions(postID, seller, buyer) VALUES (?, ?, ?)");
			ps.setInt(1, postID);
			ps.setString(2, seller);
			ps.setString(3, buyer);
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
	
	public static ArrayList<Post> getPosts(String uscEmail) {
		ArrayList<Post> posts = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Posts WHERE uscEmail = ?");
			ps.setString(1,  uscEmail);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Post post = new Post(rs.getInt("postID"), rs.getString("uscEmail"), rs.getString("brand"),rs.getString("pName") , rs.getString("descrip"), rs.getDouble("price"), rs.getShort("quantity"), rs.getBoolean("saleType"), rs.getTimestamp("datePosted"));
				posts.add(post);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	
	public static ArrayList<Transaction> getTransactions(String uscEmail) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Transactions WHERE seller = ? OR buyer = ?");
			ps.setString(1,  uscEmail);
			ps.setString(2,  uscEmail);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("postID"), rs.getString("seller"),rs.getString("buyer"), rs.getTimestamp("dateSold"));
				transactions.add(transaction);
			}
			
			ps.close();
			rs.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return transactions;
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
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return tags;
	}
}