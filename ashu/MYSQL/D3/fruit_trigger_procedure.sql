/* Trigger 
1. formation 
2. occur event 
- 트리거 기본 형태 
 delimiter //
 create trigger title timing (after| before) event name (insert|update|delete) on table name 
for each row 
begin 
-- 실행코드
end //
delimiter;
- old : update 이벤트 발생할 때 사용 가능한 것으로 값이 바뀌기전의 행 
- new : insert, update 이벤트 발생할 때 사용한 것으로, 값이 바뀐후의 행 또는 새로 추가된 행 
- 변수 방법 
declare 변수명 자료형 default 기본값; 
- 변수값 변경 방법 
set 변수명 = 값;
set 변수명 = (select를 이용한 검색 결과);
*/ 
use fruit;
drop trigger if exists insert_buy;
delimiter //
create trigger insert_buy after insert on buy 
for each row 
begin 
    -- 구매한 과일의 수량 
    -- 구매한 과일의 이름 
    update fruit
        set 
        f_stock = f_stock + new.b_quantity
        where 
        f_name = new.b_f_name;
end //
delimiter ; 

select * from buy;
insert into buy values(2, '바나나', 50, '2021-12-02', '송이', '과일상회');
show triggers; 

-- 과일을 판매 했을때 과일 수량을 맞춰주는 트리거를 만들어 보세요 
delimiter //
create trigger insert_sell after insert on sell 
for each row 
begin 
	declare _quantity int default 0;
    set quantity = new 
    -- 판매한 과일의 수량 
    -- 판매한 과일의 이름 
    update fruit
        set 
        fr_stock = fr_stock - new.s_quantity 
        where 
        fr_name = new.s_fr_name;
end //
delimiter ; 
-- 트리거 확인을 위해 sell 테이블에 행 추가 
insert into sell values(2,'바나나',3,'송이',12000,now(),'credit card');

/*procedure : query 집합으로 함수 
- pros : 하나의 요청으로 여러 SQL문을 실행할 수 있다 => 네트워크 부하를 줄일 수 있다 
         처리시간이 줄어든다
         응용 프로그램측 로직을 가지지 않고도 데이터의 앞뒤가 맞게 할 수 있다 
         보수성이 뛰어나다 
- cons : 재사용성이 나쁘다 
         업무의 사양 변경 시 프로시저의 정의를 변경할 필요가 있다 
- 목록확인 : show procedure status;
- script check : show create procedure 프로시저명;

drop procedure if exists 프로시저명;
delimiter //
create procedure 프로시저명
(
	[(in | out) 변수명 타입,
    ...
    (in | out) 변수명 타입]
)
begin 
-- 실행코드 
end //
delimiter ; 
- 프로시저 호출 
call 프로시저명(변수나 값들);
*/
show procedure status;
use sakila;
show create procedure film_in_stock; 
drop procedure if exists insert_sell;
delimiter //
create procedure insert_sell (
	in in_fr_name varchar(50),
    in in_quantity int,
    in in_unit varchar(50),
    in in_type varchar(50)
)
begin 
	declare _total_price int default 0;  -- 총합 가격
    declare _price int default 0;        -- 개당 가격 
    set _price = (select f_price from fruit where fr_name = in_f_name); 
    set _total_price = _price * in_quantity; 
    insert into sell 
    select max(s_num)+1, in_f_name, in_amount, in_unit, _total_price, now(), in_type;
end //
delimiter ;
call insert_sell('strawberry', 3, 'box', 'credit card'); 
select * from sell; 

/* 
insert 트리거에서 새로 추가된 행에 update를 못함. 이때 프로시저를 이용해야 함.
트리거는 이벤트마다 동일하게 처리하는 경우 사용. 아니면 프로시저를 이용.
통신사에서 작년 사용 금액을 지준으로 올해 등급을 경정하는 과정 => 프로시저
제품 구매마다 구매 금액의 10프로를 포인트로 지급시 => 트리거 
*/


