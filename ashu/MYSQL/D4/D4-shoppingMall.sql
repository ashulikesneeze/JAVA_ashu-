
CREATE TABLE `user` (
	`user_id`	varchar(20)	NOT NULL,
	`user_pw`	varchar(255)	NULL,
	`user_name`	varchar(15)	NULL,
	`user_reg_num`	char(14)	NULL,
	`user_phone`	char(13)	NULL,
	`user_gender`	varchar(10)	NULL,
	`user_add_num`	int	NOT NULL
);

CREATE TABLE `Order` (
	`order_num`	int	NOT NULL,
	`order_datetime`	datetime	NULL,
	`order_user_id`	varchar(50)	NOT NULL,
	`order_amount`	int	NULL,
	`order_totalPrice`	int	NULL,
	`order_opt_num`	int	NOT NULL
);

CREATE TABLE `product` (
	`pro_num`	varchar(10)	NOT NULL,
	`pro_name`	varchar(50)	NULL,
	`pro_price`	int	NULL,
	`pro_main_category`	varchar(10)	NULL,
	`pro_sub_category`	varchar(10)	NULL,
	`pro_detail`	longtext	NULL,
	`cat_num`	int	NOT NULL
);

CREATE TABLE `option` (
	`opt_num`	int	NOT NULL auto_increment,
	`opt_colour`	varchar(10)	NULL,
	`opt_size`	varchar(10)	NULL,
	`opt_stock`	int	NULL,
	`opt_pro_num`	varchar(10)	NOT NULL,
    primary key(opt_num)
);

CREATE TABLE `category` (
	`cat_num`	int	NOT NULL auto_increment,
	`cat_main`	varchar(10)	NULL,
	`cat_sub`	varchar(10)	NULL,
    primary key(cat_num)
);

CREATE TABLE `Address` (
	`add_num`	int	NOT NULL auto_increment,
	`user_address`	varchar(70)	NULL,
	`user_postcode`	varchar(10)	NULL,
	`user_address_detail`	varchar(50)	NULL,
	`add_nickname`	varchar(30)	NULL,
    primary key(add_num)
);

CREATE TABLE `review` (
	`review_num`	int	NOT NULL auto_increment,
	`review_content`	longtext	NULL,
	`review_title`	varchar(100)	NULL,
	`review_date`	datetime	NULL,
	`review_ user_id`	varchar(20)	NOT NULL,
	`review_pro_num`	varchar(10)	NOT NULL,
    primary key(review_num)
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `Order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`order_num`
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pro_num`
);

ALTER TABLE `option` ADD CONSTRAINT `PK_OPTION` PRIMARY KEY (
	`opt_num`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`cat_num`
);

ALTER TABLE `Address` ADD CONSTRAINT `PK_ADDRESS` PRIMARY KEY (
	`add_num`
);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`review_num`
);

ALTER TABLE `user` ADD CONSTRAINT `FK_Address_TO_user_1` FOREIGN KEY (
	`user_add_num`
)
REFERENCES `Address` (
	`add_num`
);

ALTER TABLE `Order` ADD CONSTRAINT `FK_option_TO_Order_1` FOREIGN KEY (
	`order_user_id`
)
REFERENCES `option` (
	`opt_num`
);

ALTER TABLE `Order` ADD CONSTRAINT `FK_user_TO_Order_1` FOREIGN KEY (
	`order_opt_num`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`cat_num`
)
REFERENCES `category` (
	`cat_num`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_product_TO_option_1` FOREIGN KEY (
	`opt_pro_num`
)
REFERENCES `product` (
	`pro_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_user_TO_review_1` FOREIGN KEY (
	`review_ user_id`
)
REFERENCES `user` (
	`user_id`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_product_TO_review_1` FOREIGN KEY (
	`review_pro_num`
)
REFERENCES `product` (
	`pro_num`
);

