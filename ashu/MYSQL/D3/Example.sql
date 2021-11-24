-- example 데이터베이스 생성
create database example;
-- example 데이터베이스 선택
use example;
-- 고객 테이블 생성

create table 고객(
	고객아이디 varchar(20) not null,
    고객이름	varchar(10) not null,
    나이		int,
    등급		varchar(10) not null,
	직업		varchar(20) ,
    적립금	int default 0,
    primary key(고객아이디)
);

-- desc 고객;
-- 제품 테이블 생성

create table 제품(
	제품번호	char(3)	not null,
    제품명	varchar(20),
    재고량	int,
    단가		int,
    제조업체	varchar(20),
    primary key(제품번호),
    check(재고량 >=0 and 재고량 <= 10000)
);

-- desc 제품;
-- 주문 테이블 생성

create table 주문(
	주문번호	char(3)	not null,
    주문고객	varchar(20),
    주문제품	char(3),
    수량 	int,
    배송지	varchar(30),
    주문일자	datetime,
    primary key(주문번호),
    foreign key(주문고객)	references 고객(고객아이디),
    foreign key(주문제품) references 제품(제품번호)
);

-- desc 주문;
-- 고객 테이블에 고객 데이터 추가

insert into 고객(고객아이디, 고객이름, 나이, 등급, 직업, 적립금)
values('apple','정소화', 20, 'gold','학생',1000),
('banana','김선우', 25, 'vip','간호사', 2500),
('carrot','고명석', 28, 'gold','교사', 4500),
('orange','김용욱', 22, 'silver','학생',0),
('melon','성원용', 35, 'gold','회사원',5000),
('peach','오형준', null, 'silver','의사',300),
('pear','채광주', 31, 'silver','회사원',500);

-- 제품 테이블 데이터 추가

insert into 제품(제품번호, 제품명, 재고량, 단가, 제조업체)
values ('p01', '그냥만두', 5000, 4500, '대한식품'),
('p02', '매운쫄면', 2500, 5500, '민국푸드'),
('p03', '쿵떡파이', 3600, 2600, '한빛제과'),
('p04', '맛난초콜렛', 1250, 2500, '한빛제과'),
('p05', '얼큰라면', 2200, 1200, '대한식품'),
('p06', '통통우동', 1000, 1550, '민국푸드'),
('p07', '달콤비스켓', 1650, 1500, '한빛제과');

-- 주문 테이블 데이터 추가

insert into 주문(주문번호, 주문고객, 주문제품, 수량, 배송지, 주문일자)
values('o01', 'apple', 'p03',10,'서울시 마포구','2013-01-01'),
('o02', 'melon', 'p01',5,'인천시 계양구','2013-01-10'),
('o03', 'banana', 'p06',45,'경기도 부천시','2013-01-11'),
('o04', 'carrot', 'p02',8,'부산시 금정구','2013-02-01'),
('o05', 'melon', 'p06',36,'경기도 용인시','2013-02-20'),
('o06', 'banana', 'p01',19,'충청북도 보은군','2013-03-02'),
('o07', 'apple', 'p03',22,'서울시 영등포구','2013-03-15'),
('o08', 'pear', 'p02',50,'강원도 춘천시','2013-04-10'),
('o09', 'banana', 'p04',15,'전라남도 목포시','2013-04-11'),
('o10', 'carrot', 'p03',20,'경기도 안양시','2013-05-22');

-- 중복제거 
select distinct 등급 from 고객;

-- 아이디가 apple인 고객 주문 제품 확인  
select distinct 제품번호, 제품명 from 주문
join 제품 on 주문제품 = 제품번호 where 주문고객 = 'apple'; 



