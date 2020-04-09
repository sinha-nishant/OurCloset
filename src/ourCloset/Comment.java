package ourCloset;

import java.sql.Timestamp;

/**
 * @author Nishant Sinha
 */
public class Comment extends Notification {
	
	/**
	 * The String message the user wrote, null by default.<br>For example, "What's the size?"
	 */
	private String message = null;
	
	/**
	 * The primary key ID of the comment the user replied to, 0 if this comment at the root level.
	 */
	private int replyTo = 0;
	 
	/**
	 * Called from the front-end when a user comments on a product.
	 * @param commenterID The primary key ID of the user who made this comment.
	 * @param productID The primary key ID of the product this comment is relevant to.
	 * @param message The String message the user wrote. For example, "What's the size?"
	 */
	public Comment(int commenterID, int productID, String message) {
		super(commenterID, productID);
		this.message = message;
	}
	
	/**
	 * Called from the frontend when a user replies to a comment.
	 * @param commenterID The primary key ID of the user who made this comment.
	 * @param productID The primary key ID of the product this comment is relevant to.
	 * @param message The String message the user wrote. For example, "What's the size?"
	 * @param replyTo The primary key ID of the comment the user replied to, 0 if this comment at the root level.
	 */
	public Comment(int commenterID, int productID, String message, int replyTo) {
		super(commenterID, productID);
		this.message = message;
		this.replyTo = replyTo;
	}
	
	/**
	 * Overloaded constructor with commentTime and Comment replyTo for database retrievals.
	 * @param commentID The primary key ID of this comment.
	 * @param commenterID The primary key ID of the user who made this comment.
	 * @param productID The primary key ID of the product this comment is relevant to.
	 * @param message The String message the user wrote. For example, "What's the size?"
	 * @param commentTime The time this comment was created.
	 * @param replyTo The primary key ID of the comment the user replied to, 0 if this comment at the root level.
	 */
	public Comment(int commentID, int commenterID, int productID, String message, Timestamp commentTime, int replyTo) {
		super(commentID, commenterID, productID, commentTime);
		this.message = message;
		this.replyTo = replyTo;
	}
	
	/**
	 * @return String attribute of comment. For example, "What's the size?"
	 */
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * @return The primary key ID of the comment that this comment replied to.<br>
	 * For example, Seller replied "10" to the comment "What's the size?". This comment would be "10". The comment containing "What's the size" would be returned.
	 */
	public int isReplyTo() {
		return this.replyTo;
	}
}