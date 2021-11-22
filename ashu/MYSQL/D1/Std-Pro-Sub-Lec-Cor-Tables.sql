/*
show databases;

create database test1;

use test1;

create table test1(num1 int default 0 not null,
num2 int 
constraint pk_num1 primary key(num1));

explain test1;

alter table test1 add num3 int;

alter table test1 modify num1 int default 100 not null;

alter table test1 change num1 num4 int not null default 0;

alter table test1 drop num4;

*typo : ctr C

alter table test2 add constraint pk_num1 primary key(num1);

alter table test2 drop primary key;

*문자열 char(fixed n), varchar(max n), longrtext 

drop table if exists student; 

create table student(
std_id varchar(15) not null unique,
std_pw varchar(20) not null, 
std_reg_num char(14) not null unique,
std_name varchar(50) not null,
std_num char(10) not null,
constraint primary key(std_num)
);

explain student;

create table professor(
pro_id varchar(15) not null unique,
pro_pw varchar(20) not null, 
pro_reg_num char(14) not null unique,
pro_name varchar(50) not null,
pro_num char(10) not null,
constraint primary key(pro_num)
);

explain professor;


drop table if exists subject;
create table subject(
sub_num int not null auto_increment,
sub_title varchar(30) not null,
sub_code varchar(6) not null,
sub_schedule varchar(30),
sub_class_num int,
constraint primary key(sub_num)
);

explain subject;

-- course table
drop table if exists course;
create table course(
cor_num int auto_increment,
cor_std_num char(10) not null,
cor_sub_num int not null,
cor_score varchar(4),
constraint primary key(cor_num),
constraint foreign key(cor_std_num) references student(std_num),
constraint foreign key(cor_sub_num) references subject(sub_num)
);
explain course;  
*/
-- lecture table
drop table if exists lecture;
create table lecture(
lec_num int auto_increment,
lec_pro_num char(10) not null,
lec_sub_num int not null,
constraint primary key(lec_num),
constraint foreign key(lec_pro_num) references professor(pro_num),
constraint foreign key(lec_sub_num) references subject(sub_num)
);
explain lecture; 

