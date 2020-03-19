package ourCloset;

import java.sql.Timestamp;

public class Transaction {
	private int transactionID;
	private int postID;
	private String seller;
	private String buyer;
	private Timestamp dateSold;
	
	public Transaction(int transactionID, int postID, String seller, String buyer) {
		this.transactionID = transactionID;
		this.postID = postID;
		this.seller = seller;
		this.buyer = buyer;
	}
	
	// Overloaded Transaction constructor with dateSold
	public Transaction(int transactionID, int postID, String seller, String buyer, Timestamp dateSold) {
		this.transactionID = transactionID;
		this.postID = postID;
		this.seller = seller;
		this.buyer = buyer;
		this.dateSold = dateSold;
	}
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Timestamp getDateSold() {
		return dateSold;
	}
	public void setDateSold(Timestamp dateSold) {
		this.dateSold = dateSold;
	}
	
	public String toString() {
		return "Transaction ID: " + transactionID + "\nPost ID: " + postID + "\nSeller: " + seller + "\nBuyer: " + buyer +
		"\nDate Sold: " + dateSold;
	}
}
