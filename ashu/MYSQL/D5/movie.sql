CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL,
	`mo_title`	varchar(50)	NULL,
	`mo_age`	int	NULL,
	`mo_runtime`	int	NULL,
	`mo_date`	date	NULL,
	`mo_detail`	longtext	NULL
);

CREATE TABLE `genre` (
	`ge_name`	varchar(50)	NOT NULL,
	`Field`	VARCHAR(255)	NULL
);

CREATE TABLE `movie_genre` (
	`mg_num`	int	NOT NULL,
	`mg_ge_name`	varchar(50)	NOT NULL,
	`mg_mo_num`	int	NOT NULL
);

CREATE TABLE `character` (
	`ch_num`	int	NOT NULL,
	`ch_name`	varchar(50)	NULL,
	`ch_dob`	varchar(10)	NULL,
	`ch_nationality`	varchar(50)	NULL,
	`ch_occupation`	varchar(50)	NULL
);

CREATE TABLE `participation` (
	`pt_num`	int	NOT NULL,
	`pt_role`	varchar(50)	NULL,
	`pt_ch_num`	int	NOT NULL,
	`pt_mo_num`	int	NOT NULL
);

CREATE TABLE `cenema` (
	`ce_num`	int	NOT NULL,
	`ce_area`	varchar(50)	NULL,
	`ce_brench`	varchar(50)	NULL,
	`ce_address`	varchar(50)	NULL,
	`ce_traffic`	longtext	NULL,
	`ce_parking`	longtext	NULL,
	`ce_audience_count`	int	NULL,
	`ce_seat_count`	int	NULL
);

CREATE TABLE `seat` (
	`st_num`	int	NOT NULL,
	`st_name`	char(3)	NULL,
	`st_room_num`	int	NULL,
	`st_state`	varchar(50)	NULL,
	`st_type`	varchar(50)	NULL,
	`st_ce_num`	int	NOT NULL
);

CREATE TABLE `schedule` (
	`sc_num`	int	NOT NULL,
	`sc_date`	date	NULL,
	`sc_time`	varchar(5)	NULL,
	`sc_room_num`	int	NULL,
	`sc_option`	varchar(10)	NULL,
	`sc_total_seat`	int	NULL,
	`sc_seat`	int	NULL,
	`sc_mo_num`	int	NOT NULL,
	`sc_ce_num`	int	NOT NULL
);

CREATE TABLE `member` (
	`me_id`	varchar(50)	NOT NULL,
	`me_pw`	varchar(255)	NULL
);

CREATE TABLE `ticketing` (
	`tk_num`	int	NOT NULL,
	`tk_sc_num`	int	NOT NULL,
	`tk_me_id`	varchar(50)	NOT NULL
);

CREATE TABLE `ticketing_list` (
	`ti_num`	int	NOT NULL,
	`ti_st_num`	int	NOT NULL,
	`ti_tk_num`	int	NOT NULL
);

ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`mo_num`
);

ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `PK_MOVIE_GENRE` PRIMARY KEY (
	`mg_num`
);

ALTER TABLE `character` ADD CONSTRAINT `PK_CHARACTER` PRIMARY KEY (
	`ch_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `PK_PARTICIPATION` PRIMARY KEY (
	`pt_num`
);

ALTER TABLE `cenema` ADD CONSTRAINT `PK_CENEMA` PRIMARY KEY (
	`ce_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`st_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `PK_TICKETING` PRIMARY KEY (
	`tk_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `PK_TICKETING_LIST` PRIMARY KEY (
	`ti_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_character_TO_participation_1` FOREIGN KEY (
	`pt_ch_num`
)
REFERENCES `character` (
	`ch_num`
);

ALTER TABLE `participation` ADD CONSTRAINT `FK_movie_TO_participation_1` FOREIGN KEY (
	`pt_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_cenema_TO_seat_1` FOREIGN KEY (
	`st_ce_num`
)
REFERENCES `cenema` (
	`ce_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_cenema_TO_schedule_1` FOREIGN KEY (
	`sc_ce_num`
)
REFERENCES `cenema` (
	`ce_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_schedule_TO_ticketing_1` FOREIGN KEY (
	`tk_sc_num`
)
REFERENCES `schedule` (
	`sc_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`tk_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_seat_TO_ticketing_list_1` FOREIGN KEY (
	`ti_st_num`
)
REFERENCES `seat` (
	`st_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `FK_ticketing_TO_ticketing_list_1` FOREIGN KEY (
	`ti_tk_num`
)
REFERENCES `ticketing` (
	`tk_num`
);

-- CGV 홈페이지에서 영화 듄 정보를 이용하여 영화정보, 인물 등 필요한 정보를 DB에 추가 단, 배우는 대표 2명
insert into genre values('가족'),('공포/호러'),('드라마'),('SF'),('멜로/로맨스'),('코미디'),('미스터리'),('단편'),('다큐멘터리'),('로드무비'),
('무협'),('뮤지컬'),('뮤직'),('범죄'),('옴니버스'),('서부'),('스릴러'),('스포츠'),('시대극/사극'),('액션'),('어드벤쳐'),('환타지');

insert into movie values(1,'듄',12,155,'2021-10-20',"듄을 지배하는 자가 우주를 지배한다!”

10191년, 아트레이데스 가문의 후계자인 폴(티모시 샬라메)은 시공을 초월한 존재이자 
전 우주를 구원할 예지된 자의 운명을 타고났다. 
그리고 어떤 계시처럼 매일 꿈에서 아라키스 행성에 있는 한 여인을 만난다. 
모래언덕을 뜻하는 '듄'이라 불리는 아라키스는 물 한 방울 없는 사막이지만 
우주에서 가장 비싼 물질인 신성한 환각제 스파이스의 유일한 생산지로 이를 차지하기 위한 전쟁이 치열하다. 
황제의 명령으로 폴과 아트레이데스 가문은 죽음이 기다리는 아라키스로 향하는데…

위대한 자는 부름에 응답한다, 두려움에 맞서라, 이것은 위대한 시작이다!");
insert into movie_genre values(1,'SF',1);
insert into `character` values(1, '티모시 살라메', '1995.12.27', null, '배우'),
(2, '레베카 퍼거슨', '1986.10.19','스웨덴', '배우'),(3, '드니 빌뇌브', '1967.10.3', '캐나다', '영화감독, 시나리오작가');
insert into participation values(1,'주연',1,1),(2,'주연',2,1),(3,'감독',3,1);

insert into cenema values(1, '서울', 'CGV강남', "서울특별시 강남구 역삼동 814-6 스타플렉스", "# 지하철
2호선 | 강남역 11번 출구
9호선 | 신논현역 5번출구

# 버스
- 분당지역
   좌석버스: 1005-1, 1005-2, 6800, 5500-2
   간선버스: 408, 462
   광역버스: 9404, 9408
- 강북지역
   간선버스: 140, 144, 145, 471
- 강서지역
   좌석버스: 1500
   간선버스: 360
- 강동지역
   간선버스: 402, 420, 470, 407
- 인근경기지역
   좌석버스: 3030, 2002, 2002-1
   광역버스: 9409, 9500, 9501, 9503, 9700, 9711", "# 주차정보
- 위치: 건물 지하2F ~ 지하4F

# 주차요금
- CGV 영화 관람 시 주차 3시간 6,000원
- 주차시간 (3시간) 초과 시 10분 당 1,000원
※ 발렛서비스 운영시간 : 오전 8시 이후 ~ 오후 20시

※ 발렛 무료 서비스는 영화 관람 고객 한 함.  (영화 미관람 시 건물 주차장에서 별도 정산)
※ 20시 이후 입차 차량은 발렛서비스 이용이 제한될 수 있으며, 별도 운영되는 주차팀의 사정에 따라 변경될 수 있습니다.

# 이용안내
- 주차공간이 협소하여 평일 오후/주말은 주차가 어렵습니다.
- 편리한 대중교통 이용을 이용하여 주시기 바랍니다.",3 ,30); 

-- 상영시간표 x, 좌석은 A1~5, B1~5 추가, 관은 총 3관scheduleticketing_listticketing
insert into seat values(1, 'A1', 1, null, null, 1),(2, 'A2', 1, null, null, 1),(3, 'A3', 1, null, null, 1),(4, 'A4', 1, null, null, 1),
(5, 'A5', 1, null, null, 1),(6, 'B1', 1, null, null, 1),(7, 'B2', 1, null, null, 1),(8, 'B3', 1, null, null, 1),(9, 'B4', 1, null, null, 1),
(10, 'B5', 1, null, null, 1),(11, 'A1', 2, null, null, 1),(12, 'A2', 2, null, null, 1),(13, 'A3', 2, null, null, 1),(14, 'A4', 2, null, null, 1),
(15, 'A5', 2, null, null, 1),(16, 'B1', 2, null, null, 1),(17, 'B2', 2, null, null, 1),(18, 'B3', 2, null, null, 1),(19, 'B4', 2, null, null, 1),
(20, 'B5', 2, null, null, 1),(21, 'A1', 3, null, null, 1),(22, 'A2', 3, null, null, 1),(23, 'A3', 3, null, null, 1),(24, 'A4', 3, null, null, 1),
(25, 'A5', 3, null, null, 1),(26, 'B1', 3, null, null, 1),(27, 'B2', 3, null, null, 1),(28, 'B3', 3, null, null, 1),(29, 'B4', 3, null, null, 1),
(30, 'B5', 3, null, null, 1);
insert into schedule(sc_num, sc_date, sc_time, sc_room_num, sc_mo_num, sc_ce_num) values(1,'2021-12-01','15:45',1,1,1),
(2,'2021-12-01','21:20',1,1,1),(3,'2021-12-02','10:20',1,1,1),(4,'2021-12-02','16:20',1,1,1),(5,'2021-12-02','19:30',1,1,1),
(6,'2021-12-03','10:30',1,1,1),(7,'2021-12-03','16:30',1,1,1),(8,'2021-12-03','17:45',1,1,1),(9,'2021-12-03','21:40',1,1,1);

-- *****set 다음에는 and가 아니고 ,를 써야함!!! and는 where 절에서만!***** 
update `schedule` set sc_total_seat = 10,sc_seat = 10,sc_option = '2D' where sc_ce_num = 1;
insert into member values('abc123','abc123');

-- abc123회원인 12월 1일 강남 1관 21:20분 듄을 A1,A2예약

insert into ticketing select 1, sc_num , 'abc123' from schedule
where sc_date = '2021-12-01' and sc_time = '21:20' and sc_room_num = 1; 

insert into ticketing_list select 1, st_num,1 from seat 
where st_room_num = 1 and st_name = 'A1';
insert into ticketing_list select 2, st_num, 1 from seat 
where st_room_num = 1 and st_name = 'A2';

update `schedule` set sc_seat = sc_seat -2 where sc_room_num = 1 
and sc_mo_num = 1 and sc_ce_num = 1 and sc_date = '2021-12-01' and sc_time = '15:45';
select * from cenema;

-- CGV 강남 12월 1일 15:45분 1관에서 하는 영화에서 예매가능한 좌석 확인 
select * from seat join cenema on ce_num = st_ce_num where ce_brench = 'CGV강남' and st_room_num = 1;
select * from ticketing_list 
join ticketing on ti_tk_num = tk_num
join `schedule` on tk_sc_num = sc_num
where sc_ce_num =1 and sc_room_num =1 and sc_date = '2021-12-01' and sc_time = '15:45';

select*from ticketing_list
join ticketing on ti_tk_num = tk_num
where tk_sc_num =2; 

select st_name from seat left
join(select * from ticketing_list
      join ticketing on ti_tk_num = tk_num
       where tk_sc_num = 2) as t1
       on st_num = ti_st_num 
       where st_ce_num =1 and st_room_num =1 and t1_num is null;

 


