/*
사원들의 월급을 관리하는 시트템을 위한 DB를 설계
월급 지급 내역 관리 포함 
직급 : 사원 대리 과장 부장 전무 이사 
월급 : 지급별 기본급에 직급별 호봉에 따른 추가금
*/ 
drop table if exists employee; 

CREATE TABLE `company`.`employee` (
  `emp_num` INT NOT NULL,
  `emp_reg_num` CHAR(14) NOT NULL,
  `emp_name` VARCHAR(45) NOT NULL,
  `emp_sal_level` VARCHAR(4) NOT NULL,
  `emp_year` INT NOT NULL,
  `emp_dep_department` VARCHAR(10) NULL,
  `employeecol` VARCHAR(45) NULL,
  PRIMARY KEY (`emp_num`),
  UNIQUE INDEX `emp_reg_num_UNIQUE` (`emp_reg_num` ASC) VISIBLE,
  constraint foreign key(emp_sal_level) references salary(sal_level),
  constraint foreign key(emp_dep_department) references department(dep_department));
  
  CREATE TABLE `company`.`department` (
  `dep_department` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`dep_department`));
  
  CREATE TABLE `company`.`salary` (
  `sal_level` VARCHAR(4) NOT NULL,
  `sal_add_salary` INT NOT NULL,
  `sal_base_salary` INT NOT NULL,
  PRIMARY KEY (`sal_level`));
  
  ALTER TABLE `company`.`employee` 
DROP COLUMN `employeecol`;

ALTER TABLE `company`.`employee` 
ADD COLUMN `emp_join_year` INT NOT NULL AFTER `emp_dep_department`;

/* 직급에 다음 데이터를 추가하는 쿼리 
 - 사원, 대리, 과장, 부장, 전무, 이사, 대표이사 
 */
 insert into salary values('사원',10, 200),('대리',15,230),('과장',20,250),
 ('부장',30,280),('전무',35,300),('이사',40,350),('대표이사',50,400);
 SELECT * FROM company.salary order by sal_base_salary desc;
 
 insert into department values('영업'),('회계'),('관리'),('마케팅'),('개발');
 insert into employee values(2019001, '123456-1234567','홍길동','사원',2,'회계',2019);
 update employee set emp_year = 2 where emp_num = 2019001;
 
 select (sal_base_salary + (sal_add_salary*emp_year)) as '홍길동 사원의 급여'  
 from salary join employee on emp_sal_level = sal_level
 where emp_name = '홍길동' and sal_level = '사원'; 
 
 -- 각 부서별 평균 급여 출력 쿼리. 단, 직원이 등룍된 부서만!
 select emp_dep_department, avg(sal_base_salary + (sal_add_salary*emp_year)) as '부서별 평균 급여' 
 from salary join employee on emp_sal_level = sal_level
 group by emp_dep_department; 
 

    
 
 
 

