package model;

import java.sql.Timestamp;

/**
 * @author Nishant Sinha
 */
public class Notification {
	
	/**
	 * The primary key ID of this notification, 0 by default.
	 */
	private int notificationID = 0;
	
	/**
	 * The primary key ID of the user who caused the notification, 0 by default.
	 */
	private int notifierID = 0;
	
	/**
	 * The primary key ID of the product this notification corresponds to, 0 by default.
	 */
	private int productID = 0;
	
	/**
	 * The time the action causing this notification (Interest/Comment) occurred, null by default.
	 */
	private Timestamp notificationTime = null;
	
	/**
	 * Tracks whether this notification has been viewed, null by default.
	 */
	private Timestamp whenViewed = null;
	
	/**
	 * Called from the frontend when a user indicates interest in a product or leaves a comment.
	 * @param notifierID The primary key ID of the user who caused this notification.
	 * @param productID The primary key ID of the product this notification corresponds to.
	 */
	public Notification (int notifierID, int productID) {
		this.notifierID = notifierID;
		this.productID = productID;
	}
	
	/**
	 * Overloaded constructor with notificationTime for database retrievals.
	 * @param notificationID The primary key ID of this notification.
	 * @param notifierID The primary key ID of the user who caused this notification.
	 * @param productID The primary key ID of the product this notification corresponds to.
	 * @param notificationTime The time the action causing this notification (Interest/Comment) occurred.
	 */
	public Notification (int notificationID, int notifierID, int productID, Timestamp notificationTime) {
		this.notificationID = notificationID;
		this.notifierID = notifierID;
		this.productID = productID;
		this.notificationTime = notificationTime;
	}
	
	/**
	 * @return The primary key ID of this notification.
	 */
	public int getNotificationID() {
		return this.notificationID;
	}

	/**
	 * @return The primary key ID of the user who commented or showed interest resulting in this notification.
	 */
	public int getNotifierID() {
		return this.notifierID;
	}

	/**
	 * @return The primary key ID of the product this notification is regarding.
	 */
	public int getProductID() {
		return this.productID;
	}

	/**
	 * @return Timestamp of when this notification was generated.
	 */
	public Timestamp getNotificationTime() {
		return this.notificationTime;
	}

	/**
	 * @return Timestamp of when this notification was viewed, returns null if the notification has not yet been viewed.
	 */
	public Timestamp getWhenViewed () {
		return this.whenViewed;
	}
	
	public String toString() {
		return "Notification from user " + notifierID + " regarding product " + productID;
	}
}