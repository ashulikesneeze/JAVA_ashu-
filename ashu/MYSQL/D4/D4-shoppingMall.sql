
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

insert into category(cat_main,cat_sub) values('?????????','??????'),('?????????','??????'),('??????','?????????'),
('??????','????????????/??????'),('??????','??????'),('??????','??????'),('??????','?????????');
insert into product(pro_num,pro_name,pro_price,pro_detail,cat_num) values(1, '?????? ????????? ??????',159000,'???????????????',1),
(2, '????????? ????????????',229000,'?????????????????????',2),(3, '?????? ????????????',99000,'?????? ???????????????',3),(4, '?????? ???????????????',43000,'???',4),
(5, '?????? ????????? ?????? ??????',43000,'??????',5),(6, '?????? ?????? ??????',36000,'??????',6);

ALTER TABLE `shoppingmall`.`product` 
DROP COLUMN `pro_sub_category`,
DROP COLUMN `pro_main_category`;

-- ???????????? ??????1 : member??? insert => address??? insert => member??? update
-- ???????????? ??????2 : address??? insert => member??? insert
 
SELECT * FROM `option`;
insert into address values(1,'?????????', '1234',null,'?????????????????????');
insert into user values('abc123','abc123','?????????','840613-1023697','010-1234-5678','??????',1);

insert into `option` values(1, '?????????', 's', 10, 1);
insert into `order` values(1, now(), 'abc123', 1, null, 1);
update `option` set opt_stock = opt_stock -1 where opt_num = 1;
insert into review values(1, '???????????????','???????????? ?????????',now(),'abc123', 1);


ALTER TABLE `shoppingmall`.`product` 
DROP FOREIGN KEY `FK_category_TO_product_1`;
ALTER TABLE `shoppingmall`.`product` 
CHANGE COLUMN `cat_num` `pro_cat_num` INT NOT NULL ;
ALTER TABLE `shoppingmall`.`product` 
ADD CONSTRAINT `FK_category_TO_product_1`
  FOREIGN KEY (`pro_cat_num`)
  REFERENCES `shoppingmall`.`category` (`cat_num`);

select pro_name from product join category on cat_num = pro_cat_num where cat_main = '?????????';
select pro_name from product join category on cat_num = pro_cat_num join `option` on opt_pro_num = pro_num
where cat_main = '?????????' and opt_stock >= 1;    

-- ?????? ?????? ?????? ??? 4 outer (??????,?????? ??????) 
select pro_name from product join category on cat_num = pro_cat_num join `option` on opt_pro_num = pro_num
join `order` on opt_num = order_opt_num
where cat_main ='?????????' group by pro_num order by sum(order_amount) desc limit 4;

select count(*) as '????????? ????????? ??????' from product join category on cat_num = pro_cat_num where cat_main ='?????????';
-- 
select * from product join category on cat_num = pro_cat_num where cat_main ='?????????' limit 10,10;

select count(*) as 'abc123 ????????? ????????? ??????' from `order` where order_user_id = 'abc123';
 
select sum(order_totalPrice) as 'abc123 ????????? ????????? ?????? ??????' from `order` where order_user_id = 'abc123' 
and order_datetime like '2021%' and order_datetime < '2021-07-01'; 



 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
