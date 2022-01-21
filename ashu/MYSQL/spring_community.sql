drop schema if exists community;
create schema community;
use community;

CREATE TABLE `member` (
	`me_id`	varchar(20)	NOT NULL,
	`me_pw`	varchar(250)	NULL,
	`me_name`	varchar(30)	NULL,
	`me_gender`	varchar(6)	NULL,
	`me_birth`	date	NULL,
	`me_address`	varchar(100)	NULL,
	`me_phone`	varchar(13)	NULL,
    PRIMARY KEY (`me_id`)
);

CREATE TABLE `board` (
	`bd_num`	int	NOT NULL auto_increment,
	`bd_title`	varchar(100)	NULL,
	`bd_contents`	longtext	NULL,
	`bd_reg_date`	datetime	NULL,
	`bd_up_date`	datetime	NULL,
	`bd_type`	varchar(10)	NULL,
	`bd_me_id`	varchar(20)	NOT NULL,
	`bd_ori_num`	int	NOT NULL,
	`bd_del`	varchar(2)	NULL,
	`bd_del_date`	datetime	NULL,
    PRIMARY KEY (`bd_num`)
);

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL auto_increment,
	`fi_ori_name`	varchar(255)	NULL,
	`fi_name`	varchar(255)	NULL,
	`fi_bd_num`	int	NOT NULL,
	`fi_del`	varchar(2)	NULL,
	`fi_del_date`	datetime	NULL,
    PRIMARY KEY (`fi_num`)
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bd_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_TO_board_1` FOREIGN KEY (
	`bd_ori_num`
)
REFERENCES `board` (
	`bd_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bd_num`
)
REFERENCES `board` (
	`bd_num`
);


select * from member;

select * from board where bd_type = '일반' order by bd_num desc;

select * from community.board;

select * from community.member;

select * from community.file;

CREATE TABLE `community`.`comment` (
  `co_num` INT NOT NULL AUTO_INCREMENT,
  `co_bd_num` INT NOT NULL,
  `co_me_id` VARCHAR(20) NOT NULL,
  `co_reg_date` VARCHAR(45) NOT NULL DEFAULT 'now()',
  `co_del` VARCHAR(2) NOT NULL DEFAULT 'N',
  `co_ori_num` INT NOT NULL,
  `co_contents` LONGTEXT NOT NULL,
  PRIMARY KEY (`co_num`));


