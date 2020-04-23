DROP DATABASE IF EXISTS OurCloset;
CREATE DATABASE OurCloset;
USE OurCloset;

-- The User table will be used for authenticating users
CREATE TABLE Users (
    userID INTEGER(7) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    uscEmail VARCHAR(30) UNIQUE NOT NULL,
    pass VARCHAR(30) NOT NULL,
    fName VARCHAR(30) NOT NULL,
    lName VARCHAR(30) NOT NULL,
    profileImagePath VARCHAR(30) NOT NULL,
    interest INTEGER(10) DEFAULT 0 NOT NULL,
    valid BOOL DEFAULT TRUE NOT NULL
);

-- The Products table will be used for managing all products added
CREATE TABLE Products (
	productID INTEGER(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	sellerID INTEGER(7) NOT NULL,
    FOREIGN KEY (sellerID) REFERENCES Users(userID),
    brand VARCHAR(30),
    pName VARCHAR(50) NOT NULL,
    timePosted TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    color VARCHAR(20) NOT NULL,
    itemType VARCHAR(20) NOT NULL,
    size VARCHAR(20) NOT NULL,
    descrip VARCHAR(280),
    rentPrice DECIMAL(5,2) NOT NULL,
    buyPrice DECIMAL(5,2) NOT NULL,
    quantity TINYINT(3) NOT NULL,
    interest INTEGER(10) DEFAULT 0 NOT NULL
);

CREATE TABLE ProductImages (
	imageID INTEGER(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    productID INTEGER(10) NOT NULL,
    FOREIGN KEY (productID) REFERENCES Products(productID),
    productImagePath VARCHAR(30) NOT NULL
);

-- The Transactions table will be used for recording all transaction history
CREATE TABLE Transactions (
	transactionID INTEGER(10) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    productID INTEGER(10) NOT NULL,
    FOREIGN KEY (productID) REFERENCES Products(productID),
    buyerID INTEGER(7) NOT NULL,
    FOREIGN KEY (buyerID) REFERENCES Users(userID),
    timeSold TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- The Tags table will allow users to quickly search for Products by tag(s)
CREATE TABLE Tags (
	tagID INTEGER(4) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    productID INTEGER(10) NOT NULL,
    FOREIGN KEY (productID) REFERENCES Products(productID),
    tagName VARCHAR(20) NOT NULL
);

-- Contains all notifications, also a parent of Comments and Interests
CREATE TABLE Notifications (
	notificationID INTEGER(7) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    notifierID INTEGER(7) NOT NULL,
    FOREIGN KEY (notifierID) REFERENCES Users(userID),
    productID INTEGER(10) NOT NULL,
    FOREIGN KEY (productID) REFERENCES Products(productID),
    notificationTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    whenViewed TIMESTAMP DEFAULT NULL
);

-- Contains the comments on each product page
CREATE TABLE Comments (
    commentID INTEGER(7) PRIMARY KEY NOT NULL,
    FOREIGN KEY (commentID) REFERENCES Notifications(notificationID), 
	message VARCHAR(300) NOT NULL,
    replyTo INTEGER(7) NOT NULL
);

-- Indicates the various products Users have had interest in
CREATE TABLE Interest (
	interestID INTEGER(7) PRIMARY KEY NOT NULL,
    FOREIGN KEY (interestID) REFERENCES Notifications(notificationID)
);
