-- UniEffectEmail : task scheduler (send an email at a specific time on a schedule)
--                  tracking campaign (bounces, forwards, clicks and unscribes) 

-- ERD Cloud 
-- ERD : Database -> reverse engineer 

-- 1. university_ashu DB 생성 (right click)
drop schema if exists university_ashu; 
CREATE SCHEMA university_ashu ;
-- 2. university_ashu DB 선택
use university_ashu;
-- 3. student table 생성
-- why 255? for pw? : 노출방지를 위해 긴 암호화로 변환됨 
drop table if exists university_ashu.student;
CREATE TABLE `university_ashu`.`student` (
  `st_num` CHAR(10) NOT NULL,
  `st_id` VARCHAR(15) NOT NULL,
  `st_pw` VARCHAR(255) NOT NULL,
  `st_name` VARCHAR(50) NOT NULL,
  `st_reg_name` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`st_num`),
  UNIQUE INDEX `st_id_UNIQUE` (`st_id` ASC) ,
  UNIQUE INDEX `st_reg_name_UNIQUE` (`st_reg_name` ASC) );

-- 테이블명 앞에 DB명이 붙은 경우와 안 붙는 경우의 차이 
-- 붙은경우는 현재 선택된 DB와 관계없이 테이블을 활용할 수 있다 
-- 안붙은경우는 현재 선택된 DB에 테이블을 활용할 수 있다 

create table professor(
pro_id varchar(15) not null unique,
pro_pw varchar(20) not null, 
pro_reg_num char(14) not null unique,
pro_name varchar(50) not null,
pro_num char(10) not null,
constraint primary key(pro_num)
);

drop table if exists subject;
create table subject(
sub_num int not null auto_increment,
sub_title varchar(30) not null,
sub_code char(6) not null,
sub_schedule varchar(30),
sub_class_num int not null default 1,
constraint primary key(sub_num)
);

drop table if exists course;
CREATE TABLE `university_ashu`.`course` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_st_num` CHAR(10) NOT NULL,
  `co_sub_num` INT NOT NULL,
  `co_score` VARCHAR(4) NULL,
  PRIMARY KEY (`co_num`),
  INDEX `co_st_num_idx` (`co_st_num` ASC) VISIBLE,
  INDEX `co_sub_num_idx` (`co_sub_num` ASC) VISIBLE,
  CONSTRAINT `co_st_num`
    FOREIGN KEY (`co_st_num`)
    REFERENCES `university_ashu`.`student` (`st_num`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `co_sub_num`
    FOREIGN KEY (`co_sub_num`)
    REFERENCES `university_ashu`.`subject` (`sub_num`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    drop table if exists lecture;
    CREATE TABLE `university_ashu`.`lecture` (
  `lec_num` INT NOT NULL AUTO_INCREMENT,
  `lec_pro_num` CHAR(10) NOT NULL,
  `lec_sub_num` INT NOT NULL,
  PRIMARY KEY (`lec_num`),
  INDEX `lec_pro_num_idx` (`lec_pro_num` ASC) VISIBLE,
  INDEX `lec_sub_num_idx` (`lec_sub_num` ASC) VISIBLE,
  CONSTRAINT `lec_pro_num`
    FOREIGN KEY (`lec_pro_num`)
    REFERENCES `university_ashu`.`professor` (`pro_num`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `lec_sub_num`
    FOREIGN KEY (`lec_sub_num`)
    REFERENCES `university_ashu`.`subject` (`sub_num`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    -- Delete : restrict / no action => 삭제, 참조 그대로 
    --          set null => 참조 null / cascade => 둘다 삭제   
    -- insert into table_name values(' ', ' ', ' ', ' ');
    -- 또는 insert into table_name(st_num, st_id, st_pw,...) values(' ', ' ', ' ', ' ');
	-- 여러개를 한번에 : insert into table_name values(' ', ' ', ' ', ' '), (' ', ' ', ' ', ' ');
    -- update student set st_id = ' ', st_pw = '  ' where st_num = '  '; 
    -- update할때 workbench에서는 pk가 필수 but, Edit>Preferences>SQL Editor> Safe Updates 해지한 후 창을 끄고 다시 키면 작동 
    SELECT * FROM university_ashu.student;
    select st_id from university_ashu.student;
    select*from student where st_id = 'ryker';
    select*from student where not st_id = 'ryker';
    
insert into subject(sub_code, sub_title) values('MSC004', 'Deep Learning Computer');
select * from subject;

insert into course(co_st_num,co_sub_num) values(550104410,1);
select * from course;

insert into lecture(lec_pro_num, lec_sub_num) values('2000160001', '1');
select * from lecture;

update subject set sub_schedule = '월1, 월2', sub_class_num = 3 where sub_num = 1;
select*from subject where sub_schedule is not null;
select*from subject where sub_title like '%computer%';
-- startWith computer
select*from subject where sub_title like 'computer%';
-- finishWith computer
select*from subject where sub_title like '%computer';
update student set st_reg_name = '840613-5066475' where st_id = 'casey';

update student set st_reg_name = '210918-1658947' where st_id = 'prax';
select * from  student where st_reg_name like '______-2%' or st_reg_name like '______-4%';
select * from student where st_num >= 550104412 and st_num < 550104415;
select * from student where st_pw = 123 order by st_name asc, st_num desc;
select * from  student;
-- table 1 & 2's results are different depends on order 
select * from course
left join subject
on co_sub_num = sub_num;

select * from subject
left join course
on sub_num = co_sub_num;

select co_st_num, sub_title from course
left join subject
on course.co_st_num = 550104410;
select * from lecture;

-- 2000160001 교수번호의 교수가 강의 제목 일정 확인 
select sub_title, sub_schedule from lecture 
left join subject
on lec_sub_num = sub_num
where lec_pro_num = 2000160001;

-- query for a prof.name who teaches a Computer Theory 
select lec_pro_num, pro_name from subject
left join lecture
on lec_sub_num = sub_num
left join professor
on lec_pro_num = pro_num
where sub_title = 'computer theory';



    


