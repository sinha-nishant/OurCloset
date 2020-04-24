package model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author Nishant Sinha
 */
public class Product {
	
	/**
	 * 
	 * @param tags
	 * This one is made by Can and Alex!
	 */
	private void setTag(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	/**
	 * The primary key ID of this product, 0 by default.
	 */
	private int productID = 0;
	
	/**
	 * The primary key ID of the seller offering this product, 0 by default.
	 */
	private int sellerID = 0;
	
	/**
	 * The brand of this product, null by default.
	 */
	private String brand = null;
	
	/**
	 * The name of this product, null by default. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 */
	private String pName = null;
	
	/**
	 * The time the product was posted to the website, null by default.
	 */
	private Timestamp timePosted = null;
	
	/**
	 * The colors of this product, null by default. For example, [#FF5733, #27B147].
	 */
	private ArrayList<String> colors = null;
	
	/**
	 * The type of Product, null by default. For example "shirt", "jeans", or "shoes".
	 */
	private String itemType = null;

	/**
	 * The size of this item, null by default, all standardized to strings to conform to guidelines for a wide variety of products.
	 */
	private String size = null;
	
	/**
	 * The description the seller provides for the product, null by default.
	 */
	private String descrip = null;
	
	/**
	* The rental price of this product per unit, 0 by default.
	*/
	private double rentPrice = 0;
	
	/**
	* The outright purchase price of this product per unit, 0 by default.
	*/
	private double buyPrice = 0;
	
	/**
	 * A counter of the number of users indicating interest in this product, 0 by default.
	 */
	private int interest = 0;
	
	/**
	 * ArrayList of Strings where each element is the path to an image of this product, null by default.
	 */
	private ArrayList<String> imagePaths = null;
	
	/**
	 * ArrayList of Tag objects regarding this product, null be default.
	 */
	private ArrayList<Tag> tags = null;
	
	/**
	 * ArrayList of Comment objects regarding this product, null by default.
	 */
	private ArrayList<Comment> comments = null;
	
	/**
	 * Basic Product constructor called by frontend when user is adding a product without tags or a brand name.
	 * @param sellerID The primary key ID of the seller offering this product.
	 * @param pName The name of this product. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 * @param colors The colors of this product.
	 * @param itemType The type of Product. For example "shirt", "jeans", or "shoes".
	 * @param size The size of this item, null by default, all standardized to strings to conform to guidelines for a wide variety of products.
	 * @param descrip The description the seller provides for the product.
	 * @param rentPrice The rental price of this product per unit, pass 0 if the user is not offering this product as a rental.
	 * @param buyPrice The outright purchase price of this product per unit, pass 0 if the user is not offering this product for purchase.
	 * @param imagePaths ArrayList of Strings where each element is the path to an image of this product.
	 */ 
	public Product(int sellerID, String pName, ArrayList<String> colors, String itemType, String size, String descrip, double rentPrice, double buyPrice, ArrayList<String> imagePaths) {
		this.sellerID = sellerID;
		this.pName = pName;
		this.colors = colors;
		this.itemType = itemType;
		this.size = size;
		this.descrip = descrip;
		this.rentPrice = rentPrice;
		this.buyPrice = buyPrice;
		this.imagePaths = imagePaths;
	}
	
	/**
	 * Overloaded Product constructor called by frontend when user is adding a project without a brand name, but with tags.
	 * @param sellerID The primary key ID of the seller offering this product.
	 * @param pName The name of this product. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 * @param colors The colors of this product.
	 * @param itemType The type of Product. For example "shirt", "jeans", or "shoes".
	 * @param size The size of this item, null by default, all standardized to strings to conform to guidelines for a wide variety of products.
	 * @param descrip The description the seller provides for the product.
	 * @param tags ArrayList of Tag objects regarding this product.
	 * @param rentPrice The rental price of this product per unit, pass 0 if the user is not offering this product as a rental.
	 * @param buyPrice The outright purchase price of this product per unit, pass 0 if the user is not offering this product for purchase.
	 * @param imagePaths ArrayList of Strings where each element is the path to an image of this product.
	 */
	public Product(int sellerID, String pName, ArrayList<String> colors, String itemType, String size, String descrip, ArrayList<Tag> tags, double rentPrice, double buyPrice, ArrayList<String> imagePaths) {
		this.sellerID = sellerID;
		this.pName = pName;
		this.colors = colors;
		this.itemType = itemType;
		this.size = size;
		this.descrip = descrip;
		this.tags = tags;
		this.rentPrice = rentPrice;
		this.buyPrice = buyPrice;
		this.imagePaths = imagePaths;
	}

	/**
	 * Overloaded Product constructor called by frontend when user is adding a project with a brand name, but without tags.
	 * @param sellerID The primary key ID of the seller offering this product.
	 * @param brand The brand of this product.
	 * @param pName The name of this product. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 * @param colors The colors of this product.
	 * @param itemType The type of Product. For example "shirt", "jeans", or "shoes".
	 * @param size The size of this item, null by default, all standardized to strings to conform to guidelines for a wide variety of products.
	 * @param descrip The description the seller provides for the product.
	 * @param rentPrice The rental price of this product per unit, pass 0 if the user is not offering this product as a rental.
	 * @param buyPrice The outright purchase price of this product per unit, pass 0 if the user is not offering this product for purchase.
	 * @param imagePaths ArrayList of Strings where each element is the path to an image of this product.
	 */
	public Product(int sellerID, String brand, String pName, ArrayList<String> colors, String itemType, String size, String descrip, double rentPrice, double buyPrice, ArrayList<String> imagePaths) {
		this.sellerID = sellerID;
		this.brand = brand;
		this.pName = pName;
		this.colors = colors;
		this.itemType = itemType;
		this.size = size;
		this.descrip = descrip;
		this.rentPrice = rentPrice;
		this.buyPrice = buyPrice;
		this.imagePaths = imagePaths;
	}

	/**
	 * Overloaded Product constructor called by frontend when user is adding a product with tags AND a brand name.
	 * @param sellerID The primary key ID of the seller offering this product.
	 * @param brand The brand of this product.
	 * @param pName The name of this product. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 * @param colors The colors of this product.
	 * @param itemType The type of Product. For example "shirt", "jeans", or "shoes".
	 * @param size The size of this item, null by default, all standardized to strings to conform to guidelines for a wide variety of products.
	 * @param descrip The description the seller provides for the product.
	 * @param tags ArrayList of Tag objects regarding this product.
	 * @param rentPrice The rental price of this product per unit, pass 0 if the user is not offering this product as a rental.
	 * @param buyPrice The outright purchase price of this product per unit, pass 0 if the user is not offering this product for purchase.
	 * @param imagePaths ArrayList of Strings where each element is the path to an image of this product.
	 */
	public Product(int sellerID, String brand, String pName, ArrayList<String> colors, String itemType, String size, String descrip, ArrayList<Tag> tags, double rentPrice, double buyPrice, ArrayList<String> imagePaths) {
		this.sellerID = sellerID;
		this.brand = brand;
		this.pName = pName;
		this.colors = colors;
		this.itemType = itemType;
		this.size = size;
		this.descrip = descrip;
		this.tags = tags;
		this.rentPrice = rentPrice;
		this.buyPrice = buyPrice;
		this.imagePaths = imagePaths;
	}

	/**
	 * Product constructor with all parameters for database retrievals.
	 * @param productID The primary key ID of this product.
	 * @param sellerID The primary key ID of the seller offering this product.
	 * @param brand The brand of this product.
	 * @param pName The name of this product. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 * @param colors The colors of this product.
	 * @param itemType The type of Product. For example "shirt", "jeans", or "shoes".
	 * @param size The size of this item, null by default, all standardized to strings to conform to guidelines for a wide variety of products.
	 * @param timePosted The time the product was posted to the website.
	 * @param descrip The description the seller provides for the product.
	 * @param tags ArrayList of Tag objects regarding this product.
	 * @param rentPrice The rental price of this product per unit, pass 0 if the user is not offering this product as a rental.
	 * @param buyPrice The outright purchase price of this product per unit, pass 0 if the user is not offering this product for purchase.
	 * @param interest A counter of the number of users indicating interest in this product.
	 * @param imagePaths ArrayList of Strings where each element is the path to an image of this product.
	 * @param comments ArrayList of Comment objects regarding this product.
	 */
	public Product(int productID, int sellerID, String brand, String pName, ArrayList<String> colors, String itemType, String size, Timestamp timePosted, String descrip, ArrayList<Tag> tags, 
			double rentPrice, double buyPrice, int interest, ArrayList<String> imagePaths, ArrayList<Comment> comments) {
		this.productID = productID;
		this.sellerID = sellerID;
		this.brand = brand;
		this.pName = pName;
		this.colors = colors;
		this.itemType = itemType;
		this.size = size;
		this.timePosted = timePosted;
		this.descrip = descrip;
		this.tags = tags;
		this.rentPrice = rentPrice;
		this.buyPrice = buyPrice;
		this.interest = interest;
		this.imagePaths = imagePaths;
		this.comments = comments;
	}

	/**
	 * @return The primary key ID of this product.
	 */
	public int getProductID() {
		return this.productID;
	}

	/**
	 * @return The primary key ID of the seller offering this product.
	 */
	public int getSellerID() {
		return this.sellerID;
	}

	/**
	 * @return The brand of this product.<br>Will return null if the brand was not provided.
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * @return The name of this product. For example, in "Nike Air Force 1", the name would be "Air Force 1".
	 */
	public String getProductName() {
		return this.pName;
	}

	/**
	 * @return The time the product was posted to the website.
	 */
	public Timestamp getTimePosted() {
		return this.timePosted;
	}

	/**
	 * @return The colors of this product.
	 */
	public ArrayList<String> getColors() {
		return this.colors;
	}

	/**
	 * @return The type of Product. For example "shirt", "jeans", or "shoes".
	 */
	public String getItemType() {
		return this.itemType;
	}

	/**
	 * @return The size of this item, all standardized to strings to conform to guidelines for a wide variety of products.
	 */
	public String getSize() {
		return size;
	}

	/** 
	 * @return The description the seller provides for the product.<br>Will return null if a description was not provided.
	 */
	public String getDescription() {
		return this.descrip;
	}

	/**
	 * @return The rental cost of this product per unit.<br>Will return 0 if a rent price has not been provided.
	 */
	public  double getRentPrice() {
		return this.rentPrice;
	}

	/**
	 * @return The per unit purchase price of this product.<br>Will return 0 if a purchase price has not been provided.
	 */
	public double getBuyPrice() {
		return this.buyPrice;
	}

	/**
	 * @return Number of users indicating interest in this product.
	 */
	public int getInterest() {
		return this.interest;
	}
	
	/**
	 * @return ArrayList of Tag objects regarding this product.
	 */
	public ArrayList<Tag> getTags() {
		return this.tags;
	}

	/**
	 * @return ArrayList of Comment objects regarding this product.
	 */
	public ArrayList<Comment> getComments() {
		return this.comments;
	}

	/**
	 * @return ArrayList of image paths for this product. Ex: ["images/shirt1", "images/shirt2"]
	 */
	public ArrayList<String> getImagePaths() {
		return this.imagePaths;
	}

	public String toString() {
		return "Product ID: " + productID + "\nSeller ID: " + sellerID + "\nBrand: " + brand +
				"\nProduct Name: " + pName + "\nTime Posted: " + timePosted.toString() +
				"\nDescription: " + descrip + "\nColors: " + colors.toString() +
				"\nRental Price: " + rentPrice + "\nBuy Price: " + buyPrice + "\nImage Paths: " + imagePaths +
				"\nTags: " + tags.toString() + "\nInterest: " + interest + "\nComments: " + comments.toString();
	}
}
