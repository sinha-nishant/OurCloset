/*
Anjalee Patel, Josie Jitzel Alvarez, Florence Yang, Alex Qiu, Can Toraman, Nishant Sinha
*/

package model;

import java.sql.Timestamp;

/**
 * @author Nishant Sinha
 */
public class Interest extends Notification {
	
	/**
	 * Called from the frontend when a user indicates interest in a product.
	 * @param interestedUserID The primary key ID of the user who showed interest.
	 * @param productID The primary key ID of the product the user showed interest in.
	 */
	public Interest(int interestedUserID, int productID) {
		super(interestedUserID, productID);
	}
	
	/**
	 * Overloaded constructor with notificationTime for database retrievals.
	 * @param interestID The primary key ID of this interest.
	 * @param interestedUserID The primary key ID of the user who showed interest.
	 * @param productID The primary key ID of the product the user showed interest in.
	 * @param interestTime The Timestamp of when interest was indicated.
	 */
	public Interest(int interestID, int interestedUserID, int productID, Timestamp interestTime) {
		super(interestID, interestedUserID, productID, interestTime);
	}
}