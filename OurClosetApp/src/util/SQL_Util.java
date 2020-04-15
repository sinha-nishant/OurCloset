package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import model.*;

@SuppressWarnings("resource")
public class SQL_Util {
	
	private static HikariDataSource dataSource = null;
	
	/**
	 * Initializes the connection between JDBC and the MySQL database.<br>
	 * <b><i>Necessary at the beginning of all programs involving this class.
	 */
	public static void initDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost/OurCloset?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=America/Los_Angeles");
		config.setUsername("root");
		config.setPassword("MySQLServer");
		config.addDataSourceProperty("cachePrepStmts", true);
		dataSource = new HikariDataSource(config);
	}
	
	private static Connection getConnection() {
		if (dataSource == null) {
			initDataSource();
			System.err.println("The dataSource has not been initialized, it is initializing now.");
		}
		
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void executeUpdateAndClose(Connection connection, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.executeUpdate();
				ps.close();
			}
			
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll (Connection connection, PreparedStatement ps, ResultSet rs) {
		try {
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * Add a user to the database.
	 * @param user The User object for the user you would like to add.
	 */
	public static void addUser(User user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("INSERT INTO Users(uscEmail, pass, fName, lName, profileImagePath) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getProfileImagePath());
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			executeUpdateAndClose(connection, ps);
		}
	}
	
	/**
	 * Validates a user's login credentials.
	 * @param uscEmail Can be in the format ttrojan@usc.edu or ttrojan.
	 * @param pass A String formatted password.
	 * @return 0 if invalid username/password combination. Otherwise, returns primary key ID of the user.
	 */
	public static int authenticate(String uscEmail, String pass) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (uscEmail.contains("@usc.edu")) {
			uscEmail = uscEmail.split("@usc.edu")[0];
		}
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT userID, pass FROM Users WHERE valid = TRUE AND uscEmail = ?");
			ps.setString(1, uscEmail);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("pass").equals(pass)) {
					return rs.getInt("userID");
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return 0;
	}

	/**
	 * 
	 * @param userID The primary key ID for the user.
	 * @return A User object corresponding to the primary key entered.
	 */
	public static User getUser(int userID) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM Users WHERE userID = ?");
			ps.setInt(1, userID);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				String uscEmail = rs.getString("uscEmail");
				String pass = rs.getString("pass");
				String fName = rs.getString("fname");
				String lName = rs.getString("lname");
				String profileImagePath = rs.getString("profileImagePath");
				int interest = rs.getInt("interest");
				return new User(userID, uscEmail, pass, fName, lName, profileImagePath, interest, getProducts(userID));
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param userID
	 */
	public static void removeUser(int userID) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("UPDATE Users SET valid = FALSE WHERE userID = ?");
			ps.setInt(1, userID);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			executeUpdateAndClose(connection, ps);
		}
	}
	
	/**
	 * 
	 * @param product
	 */
	public static void addProduct(Product product) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int addedPrimaryKey = 1;
		try {
			connection = getConnection();
			
			ps = connection.prepareStatement("INSERT INTO "
					+ "Products(sellerID, brand, pName, color, itemType, size, descrip, rentPrice, buyPrice, quantity) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, product.getSellerID());
			ps.setString(2, product.getBrand());
			ps.setString(3, product.getProductName());
			ps.setString(4, product.getColor());
			ps.setString(5, product.getItemType());
			ps.setString(6, product.getSize());
			ps.setString(7, product.getDescription());
			ps.setDouble(8, product.getRentPrice());
			ps.setDouble(9, product.getBuyPrice());
			ps.setShort(10, product.getQuantity());
			
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				addedPrimaryKey = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			executeUpdateAndClose(connection, ps);
		}
		
		addProductImagePaths(addedPrimaryKey, product.getImagePaths());
		addTags(addedPrimaryKey, product.getTags());
	}
	
	/**
	 * 
	 * @param sellerID
	 * @return
	 */
	public static ArrayList<Product> getProducts(int sellerID) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM Products WHERE sellerID = ?");
			ps.setInt(1, sellerID);
			
			ArrayList<Product> products = new ArrayList<Product>();
			rs = ps.executeQuery();
			while (rs.next()) {
				int productID = rs.getInt("productID");
				Product product = new Product(
						productID,
						rs.getInt("sellerID"),
						rs.getString("brand"),
						rs.getString("pName"), 
						rs.getString("color"),
						rs.getString("itemType"),
						rs.getString("size"),
						rs.getTimestamp("timePosted"),
						rs.getString("descrip"),
						getTags(productID),
						rs.getDouble("rentPrice"),
						rs.getDouble("buyPrice"),
						rs.getShort("quantity"),
						rs.getInt("interest"),
						getProductImagePaths(productID),
						getComments(productID));
				
				products.add(product);
			}
			
			return products;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return null;
	}
	
	private static void addProductImagePaths(int productID, ArrayList<String> imagePaths) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("INSERT INTO ProductImages(productID, productImagePath) VALUES (?, ?)");
			for (String path: imagePaths) {
				ps.setInt(1, productID);
				ps.setString(2, path);
				ps.addBatch();
			}
			
			ps.executeBatch();
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<String> getProductImagePaths(int productID) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT productImagePath from ProductImages WHERE productID = ?");
			ps.setInt(1, productID);
			
			ArrayList<String> imagePaths = new ArrayList<String>();
			rs = ps.executeQuery();
			while(rs.next()) {
				String imagePath = "productImages/" + rs.getString("productImagePath");
				imagePaths.add(imagePath);
			}
			
			return imagePaths;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param productID
	 * @return
	 */
	public static ArrayList<Tag> getTags(int productID) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM Tags WHERE productID = ?");
			ps.setInt(1, productID);
			
			ArrayList<Tag> tags = new ArrayList<Tag>();
			rs = ps.executeQuery();
			while (rs.next()) {
				Tag tag = new Tag(rs.getInt("tagID"), rs.getInt("productID"), rs.getString("tagName"));
				tags.add(tag);
			}
						
			return tags;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return null;
	}
	
	private static void addTags(int productID, ArrayList<Tag> tags) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("INSERT INTO Tags(productID, tagName) VALUES (?, ?)");
			for (Tag tag : tags) {
				ps.setInt(1, productID);
				ps.setString(2, tag.getTagName());
				ps.addBatch();
			}
			ps.executeBatch();
			ps.close();
			connection.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param productID
	 */
	public static void removeTags(int productID) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Tags WHERE productID = ?");
			ps.setInt(1, productID);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			executeUpdateAndClose(connection, ps);
		}
	}
	
	/**
	 * 
	 * @param comment
	 */
	public static void addComment(Comment comment) {
		Connection connection = null;
		PreparedStatement ps = null;
		int addedPrimaryKey = 1;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("INSERT INTO Notifications(notifierID, productID) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, comment.getNotifierID());
			ps.setInt(2, comment.getProductID());
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				addedPrimaryKey = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			executeUpdateAndClose(connection, ps);
		}
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement("INSERT INTO Comments(commentID, message, replyTo) VALUES (?, ?, ?)");
			ps.setInt(1, addedPrimaryKey);
			ps.setString(2, comment.getMessage());
			ps.setInt(3, comment.isReplyTo());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			executeUpdateAndClose(connection, ps);
		}
	}
	
	/**
	 * 
	 * @param productID
	 * @return
	 */
	public static ArrayList<Comment> getComments(int productID) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * from Notifications N, Comments C WHERE N.productID = ? AND C.commentID = N.notificationID");
			ps.setInt(1, productID);
			
			ArrayList<Comment> comments = new ArrayList<Comment>();
			rs = ps.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment(rs.getInt("commentID"), rs.getInt("notifierID"), rs.getInt("productID"), rs.getString("message"), rs.getTimestamp("notificationTime"), rs.getInt("replyTo"));
				comments.add(comment);
			}
			
			return comments;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public static ArrayList<Transaction> getTransactions(int userID) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("SELECT * FROM Transactions WHERE buyerID = ? OR sellerID = ?");
			ps.setInt(1, userID);
			ps.setInt(2, userID);
			
			ArrayList<Transaction> transactions = new ArrayList<Transaction>();
			rs = ps.executeQuery();
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("productID"), rs.getInt("buyerID"), rs.getTimestamp("timeSold"));
				transactions.add(transaction);
			}
			
			return transactions;
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeAll(connection, ps, rs);
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param transaction
	 */
	public static void addTransaction(Transaction transaction) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement("INSERT INTO Transactions(productID, buyerID) VALUES (?, ?)");
			ps.setInt(1, transaction.getproductID());
			ps.setInt(2, transaction.getBuyerID());
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			executeUpdateAndClose(connection, ps);
		}
	}

//	// this method returns all available items (not yet sold)
//	public static ArrayList<Product> getListedProducts() {
//		ArrayList<Product> products = null;
//		try {
//			PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM Products WHERE Products.productID NOT IN (SELECT productID FROM Transactions)");
//			ResultSet rs1 = ps1.executeQuery();
//			products = handleProducts(rs1);
//			
//			ps1.close();
//			rs1.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return products;
//	}
//	
//	// this method returns a user's product history
//	public static ArrayList<Product> getProductHistory(int userID) {
//		ArrayList<Product> products = null;
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE userID = ?");
//			ps.setInt(1,  userID);
//			ResultSet rs = ps.executeQuery();
//			products = handleProducts(rs);
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return products;
//	}
//
//	// this method returns the 8 most recently sold items (trending items)
//	public static ArrayList<Product> recentlySold() {
//		ArrayList<Product> products = null;
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT P.* FROM Products P JOIN Transactions ON P.productID=Transactions.productID ORDER BY dateSold ASC LIMIT 8");
//			ResultSet rs = ps.executeQuery();
//			products = handleProducts(rs);
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return products;
//	}
//
//	// this method gets a user's selling history
//	public static ArrayList<Transaction> getSellHistory(int userID) {
//		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT T.* FROM Transactions T JOIN Products ON T.productID=Products.productID WHERE userID = ?");
//			ps.setInt(1,  userID);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("productID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
//				transactions.add(transaction);
//			}
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return transactions;
//	}
//
//	// this method gets a user's buying history
//	public static ArrayList<Transaction> getBuyHistory(int userID) {
//		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Transactions WHERE buyerID = ?");
//			ps.setInt(1,  userID);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Transaction transaction = new Transaction(rs.getInt("transactionID"), rs.getInt("productID"), rs.getInt("buyerID"), rs.getTimestamp("dateSold"));
//				transactions.add(transaction);
//			}
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return transactions;
//	}
//
//	// this method returns the 5 most popular tags for items sold (could be used for a suggested feature when users are uploading products)
//	public static ArrayList<Tag> getPopularTags() {
//		ArrayList<Tag> tags = new ArrayList<Tag>();
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT TG.* From Tags TG JOIN Transactions ON TG.productID=Transactions.productID GROUP BY tagID ORDER BY COUNT(*) DESC LIMIT 5");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Tag tag = new Tag(rs.getInt("tagID"), rs.getInt("productID"), rs.getString("tagName"));
//				tags.add(tag);
//			}
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return tags;
//	}
//
//	// this method gets the average listed price of current items (not yet sold)
//	public static double getAvgListedPrice() {
//		double price = 0;
//		try {
//			
//			PreparedStatement ps = connection.prepareStatement("SELECT AVG(Products.price) as price FROM Products WHERE Products.productID NOT IN (SELECT productID FROM Transcations");
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				price = rs.getDouble("price");
//			}
//			ps.close();
//			rs.close();
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return price;
//	}
//
//	// this method gets the average price of all items sold 
//	public static double getAvgSellingPrice() {
//		double price = 0;
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT AVG(Products.price) as price FROM Products WHERE Products.productID IN (SELECT productID FROM Transcation");
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				price = rs.getDouble("price");
//			}
//			ps.close();
//			rs.close();
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return price;
//	}
//
//	// this method gets all items available for rent
//	public static ArrayList<Product> forRent() {
//		ArrayList<Product> products = null;
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE rent = 1");
//			ResultSet rs = ps.executeQuery();
//			products = handleProducts(rs);
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return products;
//	}
//
//	// this method gets all items available for purchase
//	public static ArrayList<Product> forBuy() {
//		ArrayList<Product> products = null;
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE buy = 1");
//			ResultSet rs = ps.executeQuery();
//			products = handleProducts(rs);
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return products;
//	}
//
//	// this method returns all items available for less than or equal to the given price
//	public static ArrayList<Product> maxPrice(int maxPrice) {
//		ArrayList<Product> products = null;
//		try {
//			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Products WHERE Products.productID NOT IN (SELECT productID FROM Transcations) AND price <= ?");
//			ps.setInt(1, maxPrice);
//			ResultSet rs = ps.executeQuery();
//			products = handleProducts(rs);
//			
//			ps.close();
//			rs.close();
//		}
//		
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return products;
//	}
//	
	// Clears all entries in the database but doesn't drop the actual tables
	public static void clear() {
		try {
			
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Tags");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("ALTER TABLE Tags AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Comments");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Interest");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Notifications");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("ALTER TABLE Notifications AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Transactions");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("ALTER TABLE Transactions AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM ProductImages");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("ALTER TABLE ProductImages AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Products");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("ALTER TABLE Products AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("DELETE FROM Users");
			executeUpdateAndClose(connection, ps);
			
			connection = getConnection();
			ps = connection.prepareStatement("ALTER TABLE Users AUTO_INCREMENT = ?");
			ps.setInt(1, 1);
			executeUpdateAndClose(connection, ps);
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}