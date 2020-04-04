package ourCloset;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {
	private int postID;
	private int userID;
	private String brand;
	private String pName;
	private Timestamp datePosted;
	private String descrip;
	private double price;
	private short quantity;
	private boolean rent;
	private boolean buy;
	private String[] image_paths = null;
	
	public Post(int postID, int userID, String brand, String pName, String descrip, double price, short quantity, boolean rent, boolean buy) {
		this.postID = postID;
		this.userID = userID;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.rent = rent;
		this.buy = buy;
	}
	
	// Post constructor with parameter for ArrayList of image file paths
	public Post(int postID, int userID, String brand, String pName, String descrip, double price, short quantity, boolean rent, boolean buy, ArrayList<String> image_paths) {
		this.postID = postID;
		this.userID = userID;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.rent = rent;
		this.buy = buy;
		this.image_paths = image_paths.toArray(new String[0]);
	}
	
	// Overloaded constructor with datePosted and image_paths
	public Post(int postID, int userID, String brand, String pName, String descrip, double price, short quantity, boolean rent, boolean buy, Timestamp datePosted, String[] image_paths) {
		this.postID = postID;
		this.userID = userID;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.rent = rent;
		this.buy = buy;
		this.datePosted = datePosted;
		this.image_paths = image_paths;
	}
	
	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductName() {
		return pName;
	}
	public void setProductName(String pName) {
		this.pName = pName;
	}
	public Timestamp getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	public String getDescription() {
		return descrip;
	}
	public void setDescription(String descrip) {
		this.descrip = descrip;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	
	public String[] getImagePaths() {
		return this.image_paths;
	}

	public void setImagePaths(String[] image_paths) {
		this.image_paths = image_paths;
	}

	public String toString() {
		return "Post ID: " + postID + "\nUSER ID: " + userID + "\nBrand: " + brand +
				"\nProduct Name: " + pName + "\nDate Posted: " + datePosted.toString() +
				"\nDescription: " + descrip + "\nPrice: " + price + "\nQuantity: " + quantity +
				"\nRent: " + rent + "\nBuy: " + buy + "\nImage Paths: " + image_paths;
	}
}