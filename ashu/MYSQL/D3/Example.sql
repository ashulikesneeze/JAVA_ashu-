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

select 제품명, 단가 from 제품 where 단가 between 3000 and 6000 order by 단가;
-- or 가 여러번 쓰이는 것보다 in 으로 쓰면 편리하다 
select * from 고객 where 등급 in('silver', 'gold') order by 등급 desc;

-- silver, gold 회원이 주문한 제품명 확인
select distinct 고객아이디, 등급, 제품명 from 제품
join 주문 on 주문제품 = 제품번호 
join 고객 on 주문고객 = 고객아이디 
where 등급 in('silver', 'gold');

-- 가격이  2600원 이상인 제품의 제품명과 단가 확인 
select 제품명, 단가 from 제품 where 단가 >= 2600 order by 단가;
-- sub-query : select () from () [where()]
select 제품명, 단가 from 제품 where 단가 >= (select 단가 from 제품 where 제품명 = '그냥만두');
-- 그냥만두의 가격보다 크거나 같고 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가 확인
select 제품명, 단가 from 제품 where 단가 >= (select 단가 from 제품 where 제품명= '얼큰라면')
                             and 단가 >= (select 단가 from 제품 where 제품명= '그냥만두');
 -- 방법 2                            
select 제품명, 단가 from 제품 where 단가 >= (select MAX(단가) from 제품 where 제품명 IN ('그냥만두','얼큰라면'));
-- 방법 3 : all() 전부를 만족하는 경우들만 확인 AND
select 제품명, 단가 from 제품 where 단가 >= all(select 단가 from 제품 where 제품명 IN ('그냥만두','얼큰라면'));

-- ANY() : 하나이상 만족하는 경우들만 확인 OR
-- 그냥만두 가격보다 크거나 같거나 얼큰라면 가격보다 크거나 같은 제품의 제품명과 단가 확인 
select 제품명, 단가 from 제품 where 단가 >= any(select 단가 from 제품 where 제품명 IN ('그냥만두','얼큰라면')) order by 단가;

-- GROUP BY : where 다음 order by 전 
-- 대한식품에서 만든 제품 갯수 확인 
select count(제품번호) from 제품 where 제조업체 = '대한식품';
-- 각 회사별 만든 제품 개수 확인 
select 제조업체, count(*) as '제품수' from 제품 group by 제조업체;
-- 1번이상 주문한 고객별 주문한 제품 개수
select 주문고객, count(주문제품) as '고객별 주문 제품 갯수' from 주문 group by 주문고객;
-- 주문 갯수
select 주문고객, count(주문번호) as '고객별 주문 횟수' from 주문 group by 주문고객 order by count(주문번호);
select 주문고객, sum(수량) as '고객별 주문 갯수' from 주문 group by 주문고객 order by sum(수량);
-- 1번이상 주문한 고객별 고객의 총 주문 금액 
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
join 제품 on 제품번호 = 주문제품 group by 주문고객 order by `총 주문 금액` desc;  
-- 1번 이상 주문한 고객중 총 주문 금액이 100000원 이상인 고객 확인
-- where..group by NO!! having..group by YES!!!
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
join 제품 on 제품번호 = 주문제품 group by 주문고객
having sum(수량*단가) >= 100000;

-- 제품별 주문한 제품번호와 수량 확인 
select 제품명, 제조업체, sum(수량) as '제품별 주문 수량' from 주문
join 제품 on 제품번호 = 주문제품 group by 제품명 order by `제품별 주문 수량`;

-- 제조업체별 가장 많이 팔린 제품을 제조업체, 제품번호, 주문수량을 확인 
select 제조업체, 제품번호, sum(수량) from 주문 
join 제품 on 제품번호 = 주문제품 group by 제조업체 order by sum(수량) desc limit 1;
    
-- with rollup : 부분 총합을 구해줌 
select 주문제품, 주문고객, sum(수량) from 주문 
	group by 주문제품, 주문고객
    with rollup;
    
-- LIMIT : 검색결과의 갯수를 제한할 때 사용 
-- LIMIT 정수1 : 정수1개만큼 결과를 보여줌
select * from 주문 limit 5;
-- 한번에 주문내역을 확인 할 수 있는 갯수가 5개인 경우, 1페이지
select * from 주문 limit 0, 5;
-- 한번에 주문내역을 확인할 수 있는 갯수가 5개인 경우, 2페이지
select * from 주문 limit 5,5; 
-- 한번에 주문내역을 확인 할 수 잇는 갯수가 5개인 경우, 3페이지
select * from 주문 limit 10,5; 

-- select 속성 from 테이블 where 조건 group by 속성 order by 속성 [desc] limit 갯수 

-- 가장 많은 금액을 사용한 고객 아이디 확인
select 주문고객, sum(단가*수량) from 주문 
join 제품 on 제품번호 = 주문제품 group by 주문고객 order by sum(단가*수량) desc limit 1;

-- 가장 많은 제품 갯수를 구매한 고객 아이디 확인
select 주문고객, sum(수량) from 주문
join 제품 on 제품번호 = 주문제품 group by 주문고객 order by sum(수량) desc limit 1;

-- 20대가 구매한 제품목록을 확인
select distinct 제품명, 제품번호 from 제품
join 주문 on 주문제품 = 제품번호 
join 고객 on 고객아이디 = 주문고객 where 나이 between 20 and 29 order by 제품번호;

-- 20대가 구매를 가장 많이한 제품 
select 제품명, 제품번호, sum(수량) from 제품
join 주문 on 주문제품 = 제품번호 
join 고객 on 고객아이디 = 주문고객 where 나이 between 20 and 29
group by 제품명 limit 1;



