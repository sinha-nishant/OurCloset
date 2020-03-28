package com.FinalProject.Our_Closet.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userID;
	@Column(name="uscEmail", columnDefinition="VARCHAR(30) UNIQUE NOT NULL")
	private String uscEmail;
	@Column(name="pass", columnDefinition="VARCHAR(30) NOT NULL")
	private String pass;
	@Column(name="fName", columnDefinition="VARCHAR(30) NOT NULL")
	private String fName;
	@Column(name="lName", columnDefinition="VARCHAR(30) NOT NULL")
	private String lName;
	@Column(name="lastlogin", columnDefinition="TIMESTAMP")
	private Timestamp lastLogin = new Timestamp(System.currentTimeMillis());
	@Column(name="dateCreated", columnDefinition="TIMESTAMP")
	private Timestamp dateCreated = new Timestamp(System.currentTimeMillis());
	@Column(name="privacyStatus", columnDefinition="BOOL")
	private Boolean privacyStatus = true; // true means private profile, false means public profile
	@Column(name="valid", columnDefinition="VALID")
	private Boolean valid = true; // make false when user deletes their account
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUscEmail() {
		return uscEmail;
	}
	public void setUscEmail(String uscEmail) {
		this.uscEmail = uscEmail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
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
	public boolean isPrivacyStatus() {
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
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", uscEmail=" + uscEmail + ", pass=" + pass + ", fName=" + fName + ", lName="
				+ lName + ", lastLogin=" + lastLogin + ", dateCreated=" + dateCreated + ", privacyStatus="
				+ privacyStatus + ", valid=" + valid + "]";
	}
	public boolean isMissingFields() {
		return !(userID==null || uscEmail==null || pass==null || fName==null || lName==null || lastLogin==null |
				dateCreated==null || privacyStatus==null || valid==null);
	}
	
//	public Users (int userID, String uscEmail, String password, String fName, String lName, boolean privacyStatus) {
//		this.userID = userID;
//		this.uscEmail = uscEmail;
//		this.pass = password;
//		this.fName = fName;
//		this.lName = lName ;
//		this.privacyStatus = privacyStatus;
//	}
//	
//	// User constructor overloaded with lastLogin and dateCreated
//	public Users (int userID, String uscEmail, String password, String fName, String lName, boolean privacyStatus, Timestamp lastLogin, Timestamp dateCreated) {
//		this.userID = userID;
//		this.uscEmail = uscEmail;
//		this.pass = password;
//		this.fName = fName;
//		this.lName = lName;
//		this.privacyStatus = privacyStatus;
//		this.lastLogin = lastLogin;
//		this.dateCreated = dateCreated;
//	}

	
}
