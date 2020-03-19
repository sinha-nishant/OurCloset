package ourCloset;

import java.sql.Timestamp;

public class Post {
	private static final AtomicInteger count = new AtomicInteger(0); 
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
	
	public Post(int userID, String brand, String pName, String descrip, double price, short quantity, boolean rent, boolean buy) {
		postID = count.incrementAndGet();
		this.userID = userID;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.rent = rent;
		this.buy = buy;
	}
	
	// Overloaded constructor with datePosted
	public Post(int userID, String brand, String pName, String descrip, double price, short quantity, boolean rent, boolean buy, Timestamp datePosted) {
		postID = count.incrementAndGet();
		this.userID = userID;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.rent = rent;
		this.buy = buy;
		this.datePosted = datePosted;
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
	
	public String toString() {
		return "Post ID: " + postID + "\nUSER ID: " + userID + "\nBrand: " + brand +
				"\nProduct Name: " + pName + "\nDate Posted: " + datePosted.toString() +
				"\nDescription: " + descrip + "\nPrice: " + price + "\nQuantity: " + quantity +
				"\nRent: " + rent + "\nBuy: " + buy;
	}
}
