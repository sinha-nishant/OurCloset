DROP DATABASE IF EXISTS OurCloset;
CREATE DATABASE OurCloset;
USE OurCloset;

/* The User table will be used for authenticating users and consist of userID (PK), uscEmail, 
password, fname, lname, timestamp representing the last login time, privacyStatus, and dateCreated */

CREATE TABLE Users (
    /* userID is similar to a USC ID, i.e. a series of numbers, not a userID like a screen name */
    userID INTEGER(7) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    /* VARCHAR is essentially a String datatype, 
    (20) indicates the value when printed out will go to a max of 20 characters */
    uscEmail VARCHAR(30) NOT NULL UNIQUE,
    pass VARCHAR(30) NOT NULL,
    fName VARCHAR(30) NOT NULL,
    lName VARCHAR(30) NOT NULL,
    -- Keep in mind the choice of TIMESTAMP over DATETIME
    lastLogin TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    -- Could also be a VARCHAR
    privacyStatus BOOL NOT NULL
);

/* The Posts table will be used for managing all posts created and consist of  postID (PK), productName, 
description, datePosted, price, quantity, type (such as rent or buy), brandName, and userID (FK) */

CREATE TABLE Posts (
	-- Unsigned 0-4,294,967,295, (10) specifies the printed value will be max 10 characters
	postID INTEGER(10) AUTO_INCREMENT PRIMARY KEY,
	userID INTEGER(7) NOT NULL,
    FOREIGN KEY (userID) REFERENCES Users(userID),
    brand VARCHAR(30),
    pName VARCHAR(50) NOT NULL,
    -- Don't need to pass datePosted because on any insert because it will default to current timestamp
    datePosted TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    descrip VARCHAR(280),
    -- Decimal(p,s): p is the total # of digits, s is the precision to the right of the decimal point
    price DECIMAL(4,2) NOT NULL,
    -- Unsigned 0-255,
    quantity TINYINT(3) NOT NULL,
    rent BOOL NOT NULL,
    buy BOOL NOT NULL
);

/* The Transactions table will be used for recording all transaction history and consist of transactionID (PK),
userID1 (FK), userID2 (FK), and dateSold */

CREATE TABLE Transactions (
	-- Don't need to pass transactionID because on any insert because it will increment
	transactionID INTEGER(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    postID INTEGER(10) NOT NULL,
    FOREIGN KEY (postID) REFERENCES Posts(postID),
    buyer INTEGER(7) NOT NULL,
    FOREIGN KEY (buyer) REFERENCES Users(userID)
    -- Don't need to pass dateSold because on any insert because it will default to current timestamp
    dateSold TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- The Tags table will allow users to quickly search for posts by tag(s) and consist of tagID (PK), tagName, and postID (FK)

CREATE TABLE Tags (
	-- Don't need to pass tagID because on any insert because it will increment
	tagID INTEGER(4) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    postID INTEGER(10) NOT NULL,
    FOREIGN KEY (postID) REFERENCES Posts(postID),
    tagName VARCHAR(20) NOT NULL UNIQUE
);