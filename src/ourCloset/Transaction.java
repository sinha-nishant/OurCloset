package ourCloset;

import java.sql.Timestamp;

public class Transaction {
	private int transactionID;
	private int postID;
	private int buyerID;
	private Timestamp dateSold;
	
	public Transaction(int transactionID, int postID, int buyer) {
		this.transactionID = transactionID;
		this.postID = postID;
		this.buyerID = buyer;
	}
	
	// Overloaded Transaction constructor with dateSold
	public Transaction(int transactionID, int postID, int buyerID, Timestamp dateSold) {
		this.transactionID = transactionID;
		this.postID = postID;
		this.buyerID = buyerID;
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
	
	public int getBuyer() {
		return this.buyerID;
	}
	public void setBuyer(int buyerID) {
		this.buyerID = buyerID;
	}
	public Timestamp getDateSold() {
		return dateSold;
	}
	public void setDateSold(Timestamp dateSold) {
		this.dateSold = dateSold;
	}
	
	public String toString() {
		return "Transaction ID: " + transactionID + "\nPost ID: " + postID + "\nBuyer: " + buyerID +
		"\nDate Sold: " + dateSold;
	}
}