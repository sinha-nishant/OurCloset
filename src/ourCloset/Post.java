package ourCloset;

import java.sql.Timestamp;

public class Post {
	private int postID;
	private String uscEmail;
	private String brand;
	private String pName;
	private Timestamp datePosted;
	private String descrip;
	private double price;
	private short quantity;
	private boolean saleType;
	
	public Post(int postID, String uscEmail, String brand, String pName, String descrip, double price, short quantity, boolean saleType) {
		this.postID = postID;
		this.uscEmail = uscEmail;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.saleType = saleType;
	}
	
	// Overloaded constructor with datePosted
	public Post(int postID, String uscEmail, String brand, String pName, String descrip, double price, short quantity, boolean saleType, Timestamp datePosted) {
		this.postID = postID;
		this.uscEmail = uscEmail;
		this.brand = brand;
		this.pName = pName;
		this.descrip = descrip;
		this.price = price;
		this.quantity = quantity;
		this.saleType = saleType;
		this.datePosted = datePosted;
	}
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getEmail() {
		return uscEmail;
	}
	public void setEmail(String uscEmail) {
		this.uscEmail = uscEmail;
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
	public boolean getSaleType() {
		return saleType;
	}
	public void setSaleType(boolean saleType) {
		this.saleType = saleType;
	}
	
	public String toString() {
		return "Post ID: " + postID + "\nUSC Email: " + uscEmail + "\nBrand: " + brand +
				"\nProduct Name: " + pName + "\nDate Posted: " + datePosted.toString() +
				"\nDescription: " + descrip + "\nPrice: " + price + "\nQuantity: " + quantity +
				"\nSale Type: " + saleType;
	}
}
