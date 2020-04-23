package model;

import java.util.ArrayList;

public class User {
	/**
	 * The primary key ID of this user, 0 by default.
	 */
	private int userID = 0;
	
	/**
	 * The uscEmail corresponding to this user, null by default.<br>
	 * For example, "ttrojan" in ttrojan@usc.edu
	 */
	private String uscEmail = null;
	
	/**
	 * The password for this user, null by default.
	 */
	private String pass = null;
	
	/**
	 * The first name of this user, null by default.
	 */
	private String fName = null;
	
	/**
	 * The last name of this user, null by default.
	 */
	private String lName = null;
	
	/**
	 * The path to this user's profile image.
	 */
	private String profileImagePath = null;
	
	/**
	 * The amount of total interest this user has attained as a seller across all of their products, 0 by default.
	 */
	private int interest = 0;
	
	/**
	 * Indicates whether the user is active, true by default.<br>This should be set to false when a user deletes their account.
	 */
	private boolean valid = true;
	
	/**
	 * ArrayList of Product objects which this user is selling, null by default.
	 */
	private ArrayList<Product> products = null;
	
	/**
	 * Basic User constructor to be called by frontend when a new user creates an account.
	 * @param uscEmail The uscEmail corresponding to this user.
	 * @param password The password for this user.
	 * @param fName The first name of this user.
	 * @param lName The last name of this user.
	 * @param profileImagePath The path to this user's profile image.
	 */
	public User (String uscEmail, String password, String fName, String lName, String profileImagePath) {
		this.uscEmail = uscEmail;
		this.pass = password;
		this.fName = fName;
		this.lName = lName;
		this.profileImagePath = profileImagePath;
		products = new ArrayList<Product>();
	}
	
	/**
	 * User constructor for database retrievals overloaded with userID, interest count, and ArrayList of Products.
	 * @param userID The primary key ID of this user.
	 * @param uscEmail The uscEmail corresponding to this user.
	 * @param password The password for this user.
	 * @param fName The first name of this user.
	 * @param lName The last name of this user.
	 * @param profileImagePath The path to this user's profile image.
	 * @param interest The amount of total interest this user has attained as a seller across all of their products.
	 * @param products ArrayList of Product objects which this user is selling.
	 */
	public User (int userID, String uscEmail, String password, String fName, String lName,  String profileImagePath, int interest, ArrayList<Product> products) {
		this.userID = userID;
		this.uscEmail = uscEmail;
		this.pass = password;
		this.fName = fName;
		this.lName = lName;
		this.interest = interest;
		this.products = products;
		this.profileImagePath = profileImagePath;
	}

	/**
	 * @return The primary key ID of this user.
	 */
	public int getID() {
		return this.userID;
	}

	/**
	 * @return The uscEmail corresponding to this user. For example, "ttrojan" in ttrojan@usc.edu.
	 */
	public String getEmail() {
		return this.uscEmail;
	}

	/**
	 * @return The password for this user.
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * @return The first name of this user.
	 */
	public String getFirstName() {
		return this.fName;
	}
	
	/**
	 * @return The last name of this user.
	 */
	public String getLastName() {
		return this.lName;
	}
	
	/**
	 * @return The path to this user's profile image.
	 */
	public String getProfileImagePath() {
		return this.profileImagePath;
	}
	
	/**
	 * @return The amount of total interest this user has attained as a seller across all of their products.
	 */
	public int getInterest() {
		return this.interest;
	}
	
	/**
	 * @return Whether the user is active, if false, the account has been deleted, otherwise true.
	 */
	public boolean isValid() {
		return this.valid;
	}

	/**
	 * @return ArrayList of Product objects which this user is selling.
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	public String toString() {
		return "USC Email: " + uscEmail + "\nPassword: " + pass + "\nFirst Name: " + fName + "\nLast Name: " + lName;
	}
}