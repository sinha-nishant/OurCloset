package ourCloset;

import java.sql.Timestamp;

public class Transaction {
	
	/**
	 * The primary key ID of this transaction, 0 by default.
	 */
	private int transactionID = 0;
	
	/**
	 * The primary key ID of the post this transaction is related to, 0 by default.
	 */
	private int postID = 0;
	
	/**
	 * The primary key ID of the user who is the buyer in this transaction, 0 by default.
	 */
	private int buyerID = 0;
	
	/**
	 * The time at which this transaction occurred, null by default.
	 */
	private Timestamp timeSold = null;
	
	/**
	 * Basic Transaction constructor called by frontend when a seller has sold a product.
	 * @param postID The primary key ID of the post this transaction is related to.
	 * @param buyerID The primary key ID of the user who is the buyer in this transaction.
	 */
	public Transaction(int postID, int buyerID) {
		this.postID = postID;
		this.buyerID = buyerID;
	}
	
	/**
	 * Overloaded Transaction constructor for database retrievals.
	 * @param transactionID The primary key ID of this transaction.
	 * @param postID The primary key ID of the post this transaction is related to.
	 * @param buyerID The primary key ID of the user who is the buyer in this transaction.
	 * @param timeSold The time at which this transaction occurred.
	 */
	public Transaction(int transactionID, int postID, int buyerID, Timestamp timeSold) {
		this.transactionID = transactionID;
		this.postID = postID;
		this.buyerID = buyerID;
		this.timeSold = timeSold;
	}
	
	/**
	 * @return The primary key ID of this transaction.
	 */
	public int getTransactionID() {
		return this.transactionID;
	}

	/**
	 * @return The primary key ID of the post this transaction is related to.
	 */
	public int getPostID() {
		return this.postID;
	}
	
	/**
	 * @return The primary key ID of the user who is the buyer in this transaction.
	 */
	public int getBuyerID() {
		return this.buyerID;
	}
	
	/**
	 * @return The time at which this transaction occurred.
	 */
	public Timestamp getTimeSold() {
		return this.timeSold;
	}
	
	public String toString() {
		return "Transaction ID: " + transactionID + "\nPost ID: " + postID + "\nBuyer: " + buyerID +
		"\nTime Sold: " + timeSold;
	}
}