package ourCloset;

import java.sql.Timestamp;

public class User {
	private int userID;
	private String uscEmail;
	private String pass;
	private String fName;
	private String lName;
	private Timestamp lastLogin;
	private Timestamp dateCreated;
	private boolean privacyStatus; // true means private profile, false means public profile
	private boolean valid = true; // make false when user deletes their account
	
	public User (int userID, String uscEmail, String password, String fName, String lName, boolean privacyStatus) {
		this.userID = userID;
		this.uscEmail = uscEmail;
		this.pass = password;
		this.fName = fName;
		this.lName = lName;
		this.privacyStatus = privacyStatus;
	}
	
	// User constructor overloaded with lastLogin and dateCreated
	public User (int userID, String uscEmail, String password, String fName, String lName, boolean privacyStatus, Timestamp lastLogin, Timestamp dateCreated) {
		this.userID = userID;
		this.uscEmail = uscEmail;
		this.pass = password;
		this.fName = fName;
		this.lName = lName;
		this.privacyStatus = privacyStatus;
		this.lastLogin = lastLogin;
		this.dateCreated = dateCreated;
	}

	public int getID() {
		return userID;
	}
	
	public void setID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return uscEmail;
	}

	public void setEmail(String uscEmail) {
		this.uscEmail = uscEmail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstName() {
		return fName;
	}

	public void setFirstName(String fName) {
		this.fName = fName;
	}

	public String getLastName() {
		return lName;
	}

	public void setLastName(String lName) {
		this.lName = lName;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean getPrivacyStatus() {
		return privacyStatus;
	}

	public void setPrivacyStatus(boolean privacyStatus) {
		this.privacyStatus = privacyStatus;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String toString() {
		return "USC Email: " + uscEmail + "\nPassword: " + pass + "\nFirst Name: " + fName +
				"\nLast Name: " + lName + "\nLast Login: " + lastLogin + "\nDate Created: " + dateCreated +
				"\nPrivacy Status: " + privacyStatus;
	}
}