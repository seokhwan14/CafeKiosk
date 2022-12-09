CREATE TABLE MenuCategory (
	cid			BIGINT 			PRIMARY KEY AUTO_INCREMENT,
	menuName	VARCHAR(20)		UNIQUE		NOT NULL
)AUTO_INCREMENT = 3001;

SELECT * FROM MenuCategory;

DROP TABLE MenuCategory;

INSERT INTO MenuCategory (menuName) VALUE ('asdf');

CREATE TABLE MenuItem (
	menuCategoryName	VARCHAR(20)		NOT NULL,
	menuItemName		VARCHAR(20)		UNIQUE		NOT NULL,
	price				DOUBLE			NOT NULL	DEFAULT 0.0,
	menuImage			VARCHAR(1000)	NOT NULL,
	menuDesc			VARCHAR(200)	DEFAULT '해당없음',
	CONSTRAINT Category_MenuItem_FK FOREIGN KEY (menuCategoryName) REFERENCES MenuCategory(menuName)
);

DROP TABLE MenuItem;

SELECT * FROM MenuItem;

SELECT * FROM MenuItem WHERE menuCategoryName = '김경태';

CREATE TABLE Cart(
	menuItemName		VARCHAR(20)		NOT NULL,
	countMenu			DOUBLE			NOT NULL 	DEFAULT 0,
	tempType			VARCHAR(20)		NOT NULL	DEFAULT 'C',
	size				VARCHAR(10)		NOT NULL	DEFAULT 'small',
	CONSTRAINT Cart_MenuItem_FK	FOREIGN KEY (menuItemName) REFERENCES MenuItem(menuItemName)
);

DROP TABLE Cart;

SELECT * FROM Cart;

DELETE FROM Cart;

innerjoin쓰는방법 좀 보고오자


CREATE TABLE Cart (
					menuItemName 	VARCHAR(20) 	NOT NULL, 
				 countMenu			DOUBLE			NOT NULL 	DEFAULT 0,
					tempType		CHAR			NOT NULL	DEFAULT 'C',
					size			VARCHAR(10)		NOT NULL	DEFAULT	'small',
					CONSTRAINT Cart_MenuItem_FK FOREIGN KEY (menuItemName)
				 REFERENCES MenuItem(menuItemName) );




