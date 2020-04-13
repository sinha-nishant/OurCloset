package ourCloset;

public class Tag {
	/**
	 * The primary key ID of this tag, 0 by default.
	 */
	private int tagID = 0;
	
	/**
	 * The primary key ID of the product this tag corresponds to, 0 by default.
	 */
	private int productID = 0;
	
	/**
	 * The name of this tag, null by default. For example, "Red Boots".
	 */
	private String tagName = null;
	
	/**
	 * Basic Tag constructor called from the frontend when a user adds a tag to a product.
	 * @param productID The primary key ID of the product this tag corresponds to.
	 * @param tagName The name of this tag. For example, "Red Boots".
	 */
	public Tag(int productID, String tagName) {
		this.productID = productID;
		this.tagName = tagName;
	}
	
	/**
	 * Overloaded Tag constructor including the primary key ID of this tag for database retrievals.
	 * @param tagID The primary key ID of this tag.
	 * @param productID The primary key ID of the product this tag corresponds to.
	 * @param tagName The name of this tag. For example, "Red Boots".
	 */
	public Tag(int tagID, int productID, String tagName) {
		this.tagID = tagID;
		this.productID = productID;
		this.tagName = tagName;
	}
	
	/**
	 * @return The primary key ID of this tag.
	 */
	public int getTagID() {
		return this.tagID;
	}
	
	/**
	 * @return The primary key ID of the product this tag corresponds to.
	 */
	public int getproductID() {
		return this.productID;
	}
	
	/**
	 * @return The name of this tag. For example, "Red Boots".
	 */
	public String getTagName() {
		return this.tagName;
	}
	
	public String toString() {
		return "Tag ID: " + tagID + "\nproduct ID: " + productID + "\nTag Name: " + tagName; 
	}
}