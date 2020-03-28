package com.FinalProject.Our_Closet.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Posts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postID;
	@Column(name="userID", columnDefinition="INTEGER(7) NOT NULL")
	private Integer userID;
	@Column(name="brand", columnDefinition="VARCHAR(30)")
	private String brand;
	@Column(name="pName", columnDefinition="VARCHAR(50) NOT NULL")
	private String pName;
	@Column(name="datePosted", columnDefinition="TIMESTAMP")
	private Timestamp datePosted = new Timestamp(System.currentTimeMillis());
	@Column(name="descrip", columnDefinition="VARCHAR(280)")
	private String descrip;
	@Column(name="price", columnDefinition="DECIMAL(5,2) NOT NULL")
	private Double price;
	@Column(name="quantity", columnDefinition="TINYINT(3) NOT NULL")
	private short quantity;
	@Column(name="rent", columnDefinition="BOOL NOT NULL")
	private boolean rent = true; 
	@Column(name="buy", columnDefinition="BOOL NOT NULL")
	private boolean buy = true; 
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Timestamp getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public short getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	public boolean isRent() {
		return rent;
	}
	public void setRent(boolean rent) {
		this.rent = rent;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	@Override
	public String toString() {
		return "Posts [postID=" + postID + ", userID=" + userID + ", brand=" + brand + ", pName=" + pName
				+ ", datePosted=" + datePosted + ", descrip=" + descrip + ", price=" + price + ", quantity=" + quantity
				+ ", buy=" + buy + ", rent=" + rent + "]";
	}
	
}
