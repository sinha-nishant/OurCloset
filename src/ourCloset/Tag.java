package ourCloset;

public class Tag {
	/**
	 * The primary key ID of this tag, 0 by default.
	 */
	private int tagID = 0;
	
	/**
	 * The primary key ID of the post this tag corresponds to, 0 by default.
	 */
	private int postID = 0;
	
	/**
	 * The name of this tag, null by default. For example, "Red Boots".
	 */
	private String tagName = null;
	
	/**
	 * Basic Tag constructor called from the frontend when a user adds a tag to a post.
	 * @param postID The primary key ID of the post this tag corresponds to.
	 * @param tagName The name of this tag. For example, "Red Boots".
	 */
	public Tag(int postID, String tagName) {
		this.postID = postID;
		this.tagName = tagName;
	}
	
	/**
	 * Overloaded Tag constructor including the primary key ID of this tag for database retrievals.
	 * @param tagID The primary key ID of this tag.
	 * @param postID The primary key ID of the post this tag corresponds to.
	 * @param tagName The name of this tag. For example, "Red Boots".
	 */
	public Tag(int tagID, int postID, String tagName) {
		this.tagID = tagID;
		this.postID = postID;
		this.tagName = tagName;
	}
	
	/**
	 * @return The primary key ID of this tag.
	 */
	public int getTagID() {
		return this.tagID;
	}
	
	/**
	 * @return The primary key ID of the post this tag corresponds to.
	 */
	public int getPostID() {
		return this.postID;
	}
	
	/**
	 * @return The name of this tag. For example, "Red Boots".
	 */
	public String getTagName() {
		return this.tagName;
	}
	
	public String toString() {
		return "Tag ID: " + tagID + "\nPost ID: " + postID + "\nTag Name: " + tagName; 
	}
}