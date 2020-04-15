package model;

import java.sql.Timestamp;

public class Transaction {
	
	/**
	 * The primary key ID of this transaction, 0 by default.
	 */
	private int transactionID = 0;
	
	/**
	 * The primary key ID of the product this transaction is related to, 0 by default.
	 */
	private int productID = 0;
	
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
	 * @param productID The primary key ID of the product this transaction is related to.
	 * @param buyerID The primary key ID of the user who is the buyer in this transaction.
	 */
	public Transaction(int productID, int buyerID) {
		this.productID = productID;
		this.buyerID = buyerID;
	}
	
	/**
	 * Overloaded Transaction constructor for database retrievals.
	 * @param transactionID The primary key ID of this transaction.
	 * @param productID The primary key ID of the product this transaction is related to.
	 * @param buyerID The primary key ID of the user who is the buyer in this transaction.
	 * @param timeSold The time at which this transaction occurred.
	 */
	public Transaction(int transactionID, int productID, int buyerID, Timestamp timeSold) {
		this.transactionID = transactionID;
		this.productID = productID;
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
	 * @return The primary key ID of the product this transaction is related to.
	 */
	public int getproductID() {
		return this.productID;
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
		return "Transaction ID: " + transactionID + "\nproduct ID: " + productID + "\nBuyer: " + buyerID +
		"\nTime Sold: " + timeSold;
	}
}