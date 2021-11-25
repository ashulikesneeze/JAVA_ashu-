-- *****2021160015학번 학생이 컴텨 개론 3분반 강의를 신청 
-- ***** course table에  학번입력, unknown sub_num, subject table에서 매치하여 
insert into course(co_st_num, co_sub_num) select 2021160015, sub_num
from subject where sub_class_num = 3 and sub_title = 'Computer Theory';

-- 이순신 교수님이 강의하는 강의 수 
select count(*) from lecture 
join professor on pro_num = lec_pro_num 
where pro_name = '이순신';

-- 속도에서 훨씬 빠름 : join (view를 이용함), t for tmp, 'as' compulsory 
select count(*) from lecture 
join (select * from professor where pro_name = '이순신') 
as t on pro_num = lec_pro_num;

select * from professor;

-- Deep Learning Computer 3분반 강의를 듣는 학생들의 명단을 확인하는 query 
select st_num, st_name, sub_schedule from course 
join subject 
on co_sub_num = sub_num
join student 
on co_st_num = st_num
where sub_title = 'Deep Learning Computer' and sub_class_num = 3;

-- 2021160123 학번인 홍길동 학생이 수강한 모든 과목명으 확인하는 query 
select st_num, st_name, sub_num, sub_title from course
join student 
on co_st_num = st_num
join subject
on co_sub_num = sub_num
where st_num = '2021160123' and st_name = '홍길동';

-- 2021160001학번 학생이 1번 강의인 computer theory 3분반 강의를 신청했다
insert into course(co_st_num, co_sub_num) values(2021160001,1);

-- 2021160123학번 홍길동 학생이 수강중인 컴텨 개론 3분반 성적이 A+
update course set co_score = 'A+' where co_st_num = '2021160123' and co_sub_num = '2';

-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인하는 query
select st_num, st_name from student
join course on st_num = co_st_num
join subject on co_sub_num = sub_num
join lecture on lec_sub_num = sub_num
join professor on lec_pro_num = pro_num 
where pro_name = '이순신';

-- 홍길동 학생이 수강한 수강 과목의 수
select count(*) as '홍길동 학생 수강 과목 수' from course
join student on st_num = co_st_num
where st_name = '홍길동';

-- computer theory 3분반 현재 수강 신청 학생수 
select count(*) as '컴퓨터 이론 3분반 현재인원' from subject 
join course on co_sub_num = sub_num 
where sub_title = 'Computer Theory' and sub_class_num = 3; 







