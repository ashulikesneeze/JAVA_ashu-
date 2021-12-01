
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

insert into category(cat_main,cat_sub) values('아우터','점퍼'),('아우터','코트'),('상의','티셔츠'),
('상의','블라우스/셔츠'),('하의','데님'),('하의','팬츠'),('하의','스커트');
insert into product(pro_num,pro_name,pro_price,pro_detail,cat_num) values(1, '아크 폭스터 패딩',159000,'패딩입니다',1),
(2, '앨비아 앙모코트',229000,'앙모코트입니다',2),(3, '클로 다운후드',99000,'다운 후드입니다',3),(4, '파코 레이어드탑',43000,'탑',4),
(5, '기모 와이드 데님 팬츠',43000,'팬츠',5),(6, '롤스 버튼 팬츠',36000,'팬츠',6);

ALTER TABLE `shoppingmall`.`product` 
DROP COLUMN `pro_sub_category`,
DROP COLUMN `pro_main_category`;

-- 회원가입 순서1 : member에 insert => address에 insert => member에 update
-- 회원가입 순서2 : address에 insert => member에 insert
 
SELECT * FROM `option`;
insert into address values(1,'청주시', '1234',null,'그린컴퓨터학원');
insert into user values('abc123','abc123','홍길동','840613-1023697','010-1234-5678','남자',1);

insert into `option` values(1, '화이트', 's', 10, 1);
insert into `order` values(1, now(), 'abc123', 1, null, 1);
update `option` set opt_stock = opt_stock -1 where opt_num = 1;
insert into review values(1, '패딩좋아요','따뜻하고 좋아요',now(),'abc123', 1);


ALTER TABLE `shoppingmall`.`product` 
DROP FOREIGN KEY `FK_category_TO_product_1`;
ALTER TABLE `shoppingmall`.`product` 
CHANGE COLUMN `cat_num` `pro_cat_num` INT NOT NULL ;
ALTER TABLE `shoppingmall`.`product` 
ADD CONSTRAINT `FK_category_TO_product_1`
  FOREIGN KEY (`pro_cat_num`)
  REFERENCES `shoppingmall`.`category` (`cat_num`);

select pro_name from product join category on cat_num = pro_cat_num where cat_main = '아우터';
select pro_name from product join category on cat_num = pro_cat_num join `option` on opt_pro_num = pro_num
where cat_main = '아우터' and opt_stock >= 1;    

-- 가장 많이 팔린 탑 4 outer (환불,반품 제외) 
select pro_name from product join category on cat_num = pro_cat_num join `option` on opt_pro_num = pro_num
join `order` on opt_num = order_opt_num
where cat_main ='아우터' group by pro_num order by sum(order_amount) desc limit 4;

select count(*) as '아우터 제품의 갯수' from product join category on cat_num = pro_cat_num where cat_main ='아우터';
-- 
select * from product join category on cat_num = pro_cat_num where cat_main ='아우터' limit 10,10;

select count(*) as 'abc123 회원이 주문한 횟수' from `order` where order_user_id = 'abc123';
 
select sum(order_totalPrice) as 'abc123 회원의 상반기 사용 금액' from `order` where order_user_id = 'abc123' 
and order_datetime like '2021%' and order_datetime < '2021-07-01'; 



 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
