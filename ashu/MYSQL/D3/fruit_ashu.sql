create database fruit_ashu;
CREATE TABLE `fruit_ashu`.`fruit` (
  `f_name` VARCHAR(30) NOT NULL,
  `f_price` INT NOT NULL DEFAULT 0,
  `f_stock` INT NOT NULL DEFAULT 0,
  `f_unit` VARCHAR(10) NULL,
  PRIMARY KEY (`f_name`));

CREATE TABLE `fruit_ashu`.`wholesaler` (
  `w_name` VARCHAR(20) NOT NULL,
  `w_location` VARCHAR(45) NULL,
  PRIMARY KEY (`w_name`));

CREATE TABLE `fruit_ashu`.`sell` (
  `s_id` INT NOT NULL AUTO_INCREMENT,
  `s_f_name` VARCHAR(30) NOT NULL,
  `s_date` DATETIME NOT NULL,
  `s_quantity` INT NOT NULL DEFAULT 0,
  `s_price` INT NOT NULL DEFAULT 0,
  `s_method` VARCHAR(4) NOT NULL,
  `s_unit` VARCHAR(10) NULL,
  PRIMARY KEY (`s_id`),
  INDEX `s_f_name_idx` (`s_f_name` ASC) VISIBLE,
  CONSTRAINT `s_f_name`
    FOREIGN KEY (`s_f_name`)
    REFERENCES `fruit_ashu`.`fruit` (`f_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    CREATE TABLE `fruit_ashu`.`buy` (
  `b_id` INT NOT NULL AUTO_INCREMENT,
  `b_f_name` VARCHAR(30) NOT NULL,
  `b_quantity` INT NOT NULL DEFAULT 0,
  `b_date` VARCHAR(45) NOT NULL,
  `b_unit` VARCHAR(10) NULL,
  `b_w_name` VARCHAR(20) NULL,
  PRIMARY KEY (`b_id`),
  INDEX `b_f_name_idx` (`b_f_name` ASC) VISIBLE,
  INDEX `b_w_name_idx` (`b_w_name` ASC) VISIBLE,
  CONSTRAINT `b_f_name`
    FOREIGN KEY (`b_f_name`)
    REFERENCES `fruit_ashu`.`fruit` (`f_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `b_w_name`
    FOREIGN KEY (`b_w_name`)
    REFERENCES `fruit_ashu`.`wholesaler` (`w_name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
    select * from sell;
	drop table if exists buy;
    
    insert into fruit values('strawberry', 5000, 0, 'box');
    insert into fruit values('banana', 4000, 0, 'bunch');
    insert into fruit values('grape', 10000, 0, 'box');
    insert into fruit values('watermelon', 12000, 0, 'ea');
    insert into fruit values('orange', 10000, 0, 'box');
    
     insert into wholesaler values('SmileFruit', 'Osong'),('HiOrchard', 'Cheongju'),('HappyStore', 'Cheongju');
     
     -- HappyStore에서 딸기를 100상자 개당 4000원에 지금 구매 '2021-11-24 15:10:00'
     insert into buy values(1,'strawberry', '100','2021-11-24 15:10:00','box','HappyStore');
     update buy set b_quantity = b_quantity + 100 where b_f_name = 'strawberry'; 
     
     -- 손님이 현금으로 딸기 2상자를 지금(now()) 사갔다.
     insert into sell values(1, 'strawberry', now(), 2, 10000 ,'cash', 'box'); 
     update buy set b_quantity = b_quantity - 2 where b_f_name = 'strawberry'; 
     
  select now() > '2021-11-23';
  select now() < '2021-11-25';
  select now() > '2021-11-25'; 
  
  -- 오늘 과일 판매 내역을 확인 
  select s_id, s_f_name, s_quantity, s_unit from sell 
  where s_date like '2021-11-24%';
  select s_id, s_f_name, s_quantity, s_unit from sell 
  where s_date< '2021-11-25' and s_date >= '2021-11-24';
  -- 오늘 과일 판매 총액 
  select sum(s_price) as 'total sales of today'  from sell  where s_date < '2021-11-25' and s_date >= '2021-11-24';
  -- 딸기 총 판매액 확인 
 select sum(s_price) as 'total amount for selling strawberries' 
 from sell where s_f_name = 'strawberry';
  -- 현금 판매 금액 
  select sum(s_price) as 'total cash selling amount' 
  from sell where s_method = 'cash';
 
 
     