package ourCloset;

public class Tag {
	private int tagID;
	private int postID;
	private String tagName;
	
	public Tag(int tagID, int postID, String tagName) {
		this.tagID = tagID;
		this.postID = postID;
		this.tagName = tagName;
	}
	
	public int getTagID() {
		return tagID;
	}
	public void setTagID(int tagID) {
		this.tagID = tagID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public String toString() {
		return "Tag ID: " + tagID + "\nPost ID: " + postID + "\nTag Name: " + tagName; 
	}
}