create database EffectMail

use EffectMail
GO

create table [dbo].[COMPANY]
([COMPANY_IDX] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
[COMPANY_NAME] [nvarchar] (100) NOT NULL, 
[PASSWORD] [nvarchar] (100) NOT NULL,
[ADMIN_ID] [nvarchar] (100) NOT NULL,
[FIRST_NAME] [nvarchar] (50) NOT NULL,
[MIDDLE_NAME] [nvarchar] (50) NULL,
[LAST_NAME] [nvarchar] (100) NOT NULL,
[PHONE_NO] [nvarchar] (200) NULL,
[URL] [nvarchar] (1000) NULL,
[EMAIL] [nvarchar] (2000) NULL,
[ACTIVATION_FLAG] [nvarchar] (10) NOT NULL )
ON [PRIMARY] 

GO


INSERT COMPANY(COMPANY_NAME, PASSWORD, ADMIN_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME,PHONE_NO, URL, EMAIL, ACTIVATION_FLAG)
VALUES ('The_Grill_On_The_Alley', '********', 'grill.admin', 'Mike', '', 'Lawrence', 07960606838, 'http://blackhouse.uk.com/grill-on-the-alley', 'manchesterpa@blackhouse.uk.com', 'Yes'),
        ('Burger_&_Lobster', '********', 'burgerandlobster.admin', 'Simon', '', 'Carter', 07760896338, 'http://burgerandlobster.com/en', 'manchester@burgerandlobster.com', 'Yes'),
		('Wasabi_Sushi', '********', 'wasabi.admin', 'John', '','Smith', 07760896338, 'http://wasabisushi.co.uk/', 'info@wasabisushi.co.uk', 'Yes'),
		('Almost_Famous', '********', 'almostfamous.admin', 'Sara', '', 'Thompson', 07865406535, 'http://www.almostfamousburgers.com/', 'manchester@almostfamousburgers.com', 'Yes'),
		('Tattu', '********', 'tattu.admin', 'Jane', '', 'Colvin', 07456606765, 'http://tattu.co.uk/', 'hello@tattu.co.uk', 'No');
GO 


UPDATE COMPANY
SET PHONE_NO=01618333465
WHERE COMPANY_NAME='The_Grill_On_The_Alley';

GO




CREATE TABLE [dbo].[MULTI-USERS] 
([USER_IDX] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
[COMPANY_IDX] [int] NOT NULL,
[USER_ID] [nvarchar] (100) NOT NULL,
[TITLE] [nvarchar] (100) NULL,
[FIRST_NAME] [nvarchar] (50) NOT NULL,
[MIDDLE_NAME] [nvarchar] (50) NULL,
[LAST_NAME] [nvarchar] (100) NOT NULL,
[EMAIL] [nvarchar] (2000) NULL,
[TEL_NO] [nvarchar] (30) NULL, 
[DEPARTMENT] [nvarchar] (100) NOT NULL, 
[PERMISSION_ID] [INT] NULL, 
CONSTRAINT [fk_multi-users_company] FOREIGN KEY([COMPANY_IDX])
REFERENCES [dbo].[company]([COMPANY_IDX]))
ON [PRIMARY] 

GO




INSERT [MULTI-USERS]
VALUES ('2', 'ben_sushi', 'Mr', 'Ben', '', 'Hayes', 'ben@wasabisushi.co.uk', '07849327758', '', 2),
       ('2', 'vicki_sushi', 'Miss', 'Vicki', '', 'Dudley', 'vicki@wasabisushi.co.uk','' , 'Member Info Management', 1),
	   ('2', 'saumya_sushi', 'Mrs', 'Saumya', 'Joshi', 'Mishra', '', '07470262353', 'Marketing', 3),
	   ('2', 'christina_sushi', 'Miss', 'Christina', '', 'Kts', 'christina@wasabisushi.co.uk', '07574941325', 'Marketing', 2);

GO



DELETE FROM [MULTI-USERS]
WHERE FIRST_NAME='Saumya' AND LAST_NAME='Mishra';

INSERT [MULTI-USERS]
VALUES ('2', 'lakshmi_sushi', 'Mrs', 'lakshmi', '', 'Deepak', '', '07470262353', 'Marketing', 3);

GO


UPDATE [MULTI-USERS]
SET FIRST_NAME='Anthony', LAST_NAME='Barnett'
WHERE FIRST_NAME='Ben' AND LAST_NAME='Hayes';

GO



CREATE TABLE [dbo].[PERMISSION]
([PERMISSION_ID] [INT] NOT NULL IDENTITY(1,1) PRIMARY KEY, 
[LEVEL_NAME] [nvarchar] (200) NOT NULL, 
[description] [nvarchar] (max) NULL)
ON [PRIMARY]

GO 



INSERT PERMISSION
VALUES ('ACCOUNT_MANAGER', 'ONLY ACCESS TO SUBSCRIBERS INFORMATION'),
       ('MARKETING ASSISTANT', 'ONLY ACCESS TO MANAGE TEMPLATE AND CAMPAIGN WITHOUT SEEING SUBSCRIBERS INFO /TRACKING CAMPAIGN SERVICE'),
	   ('MARKETING EXECUTIVE', 'ALLOWING ENTIRE ACCESS IN RELATION TO MARKETING');
GO 


ALTER TABLE [dbo].[MULTI-USERS]
ADD CONSTRAINT FK_PERMISSIONMULTI_USERS FOREIGN KEY (PERMISSION_ID)
REFERENCES PERMISSION (PERMISSION_ID)
GO 






CREATE TABLE [dbo].[CONFIRMATION] 
([CONFIRMATION_IDX] [INT] IDENTITY(1,1) NOT NULL PRIMARY KEY,
[COMPANY_IDX] [int] NOT NULL,
[CONFIRMATION_KEY] [nvarchar] (200) NOT NULL,
[CONFIRMATION_DATETIME] [DATETIME] NOT NULL,
[LAST_NAME] [nvarchar] (100) NOT NULL
CONSTRAINT [fk_confirmation_company] FOREIGN KEY([COMPANY_IDX])
REFERENCES [dbo].[company]([COMPANY_IDX]))
ON [PRIMARY] 

GO



CREATE PROC [dbo].[CONFIRMATION_KEY]
@ID AS VARCHAR(100)
AS BEGIN INSERT INTO [CONFIRMATION]
(CONFIRMATION_IDX, CONFIRMATION_KEY, CONFIRMATION_DATETIME)
VALUES (@ID, CONVERT(NVARCHAR(1000), CONVERT(INT, RAND() *1000000)), GETDATE())
END 
GO




CREATE TABLE [dbo].[PREMIUM] 
([PREMIUM_IDX] [INT] IDENTITY(1,1) NOT NULL PRIMARY KEY,
[PREMIUM_NAME] [nvarchar] (50) NOT NULL, 
[FEE] [float] NOT NULL,
[DESCRIPTION][TEXT] NULL)
ON [PRIMARY]

GO

INSERT [dbo].[PREMIUM]
VALUES ('mild plan', '20.00', 'up to 500 subscribers'),
       ('moderate plan', '30.00', 'up to 1,000 subscribers'),
	   ('intensive plan', '40.00', 'up to 2,000 subscribers');

GO

ALTER TABLE [dbo].[COMPANY]
ADD [PREMIUM_IDX] [INT] NULL DEFAULT 0;
GO 




ALTER TABLE [dbo].[COMPANY]
ADD CONSTRAINT FK_PREMIUMCOMPANY FOREIGN KEY (PREMIUM_IDX)
REFERENCES PREMIUM(PREMIUM_IDX)
GO 



CREATE PROC [dbo].[HANDY_CALCULATOR]
@AMOUNT AS INT 
AS BEGIN 
IF @AMOUNT >= 2000
BEGIN SELECT 40
END
ELSE IF @AMOUNT >= 1000
BEGIN SELECT 30
END
ELSE IF @AMOUNT >= 500
BEGIN SELECT 20
END
ELSE SELECT 0
END 

EXECUTE [dbo].[HANDY_CALCULATOR] 1500; 




CREATE TABLE [dbo].[SUBSCRIBER_LIST] 
([SUBSCRIBER_IDX] [INT] NOT NULL IDENTITY(1,1) PRIMARY KEY,
[COMPANY_IDX] [INT] NOT NULL,
[USER_IDX] [INT] NOT NULL, 
[EMAIL] [nvarchar] (2000) NULL,
[FIRST_NAME] [nvarchar] (50) NOT NULL,
[MIDDLE_NAME] [nvarchar] (50) NULL,
[LAST_NAME] [nvarchar] (100) NOT NULL,
[TEL_NO] [nvarchar] (30) NULL, 
[ADDRESS] [nvarchar] (1000) NULL,
[POST_CODE] [nvarchar] (50) NULL,
[DOB] [nvarchar] (50) NULL,
[GENDER] [nvarchar] (20) NULL,
[MARITAL_STATUS] [nvarchar] (50) NULL
CONSTRAINT [fk_subscriber_list_company] FOREIGN KEY([COMPANY_IDX])
REFERENCES [dbo].[company]([COMPANY_IDX]),
CONSTRAINT [fk_subscriber_list_multi-user] FOREIGN KEY([USER_IDX])
REFERENCES [dbo].[MULTI-USERS]([USER_IDX]))
ON [PRIMARY] 

GO




INSERT [dbo].[SUBSCRIBER_LIST]
VALUES (3, 2, 'taiba_alqatami@gmail.com', 'Taiba', '', 'Alqatami', 01634592753, '4 Oxford Road, Great Manchester, England', 'M1 6GB', '23-05-1992', 'FEMALE', 'SINGLE'),
       (3, 2, 'claire_dutton@nuggetlab.com', 'Claire', '', 'Dutton', 01643329873, 'Peasley Close, Warrington, England', 'WA2 0QB', '30-10-1954', 'FEMALE', 'MARRIED'), 
	   (3, 2, 'najla_alsaeed@edu.manchester.ac.uk', 'Najla', '', 'Alsaeed', 0793846382, '1 Hillcourt Street, Manchester, England', 'M3 5SE', '31-10-1993', 'FEMALE', 'SINGLE'),
	   (3, 2, 'catherine_duffy@2013.ljmu.ac.uk', 'Catherine', '', 'Duffy', 0798364852, '85 Atlantic point, Bold Street, England', 'L3 4SA', '21-04-1991', 'FEMALE', 'SINGLE'),
	   (3,2, 'dfkedf@daum.net', 'Natalia', 'Jane', 'Bullett', 6403947692743, '23 Hulligo Street, Columbia', '45 Estilo directo', '24-11-1991', 'FEMALE', 'SINGLE'),
	   (3,2, 'davidmrris@nuggetlab.com', 'David', '', 'Morris', 008293048563930, '12 12 Leigh, England', '', '', 'MALE', 'Married');

GO 


INSERT [dbo].[SUBSCRIBER_LIST]
VALUES (1, 2, 'claire_dutton@nuggetlab.com', 'Claire', '', 'Dutton', 01643329873, 'Peasley Close, Warrington, England', 'WA2 0QB', '30-10-1954', 'FEMALE', 'MARRIED');
GO

UPDATE [dbo].[SUBSCRIBER_LIST] 
SET LAST_NAME='Smith' WHERE FIRST_NAME='Taiba' AND LAST_NAME='Alqatami'
GO

UPDATE [dbo].[SUBSCRIBER_LIST] 
SET [MARITAL_STATUS]='MARRIED' WHERE FIRST_NAME='Taiba' AND TEL_NO=01634592753;
GO

UPDATE [dbo].[SUBSCRIBER_LIST]
SET POST_CODE='M2 7TH' WHERE EMAIL='davidmrris@nuggetlab.com'
GO 

DELETE FROM [dbo].[SUBSCRIBER_LIST]
WHERE EMAIL='catherine_duffy@2013.ljmu.ac.uk'
GO



CREATE VIEW vSubscriber_withPostcode
AS SELECT sl.company_idx, sl.post_code, sl.email FROM SUBSCRIBER_LIST AS sl INNER JOIN COMPANY AS c 
ON sl.COMPANY_IDX=c.COMPANY_IDX WHERE sl.POST_CODE like 'M%';

GO




CREATE VIEW vSubscriber_withDOB
AS SELECT ISNULL(sl.FIRST_NAME, '') + '' + ISNULL(sl.MIDDLE_NAME,'') + '' +ISNULL(sl.LAST_NAME,'') AS FULL_NAME, 
sl.company_idx, sl.DOB, sl.email FROM SUBSCRIBER_LIST AS sl INNER JOIN COMPANY AS c 
ON sl.COMPANY_IDX=c.COMPANY_IDX WHERE sl.DOB = '30-10-1954';

GO



CREATE VIEW vSubscriber_withMaritalStatus
AS SELECT ISNULL(sl.FIRST_NAME, '') + '' + ISNULL(sl.MIDDLE_NAME,'') + '' +ISNULL(sl.LAST_NAME,'') AS FULL_NAME, 
sl.company_idx, sl.[MARITAL_STATUS], sl.email FROM SUBSCRIBER_LIST AS sl INNER JOIN COMPANY AS c 
ON sl.COMPANY_IDX=c.COMPANY_IDX WHERE sl.[MARITAL_STATUS] IN ('SINGLE','S');

GO





CREATE TABLE [dbo].[TEMPLATE]
([TEMPLATE_KEY] [INT] NOT NULL IDENTITY(1,1) PRIMARY KEY,
[COMPANY_IDX] [INT] NOT NULL,
[USER_IDX] [INT] NOT NULL,
[HTML_CODE] [TEXT] NOT NULL, 
[BACKGROUND] [nvarchar] (MAX) NULL,
[IMAGE] [binary] NULL, 
[DATE_ORIGIN] [DATETIME] NOT NULL,
[DATE_LATEST_USAGE] [DATETIME] NOT NULL
CONSTRAINT [fk_template_company] FOREIGN KEY([COMPANY_IDX])
REFERENCES [dbo].[company]([COMPANY_IDX]),
CONSTRAINT [fk_ctemplate_multi-user] FOREIGN KEY([USER_IDX])
REFERENCES [dbo].[MULTI-USERS]([USER_IDX]))
ON [PRIMARY] 

GO 

ALTER TABLE [dbo].[TEMPLATE]
DROP CONSTRAINT [fk_template_company]
GO

ALTER TABLE [dbo].[TEMPLATE]
DROP CONSTRAINT [fk_ctemplate_multi-user]
GO


DROP TABLE [dbo].[TEMPLATE]
GO


CREATE TABLE [dbo].[TEMPLATE]
([TEMPLATE_ID] [INT] NOT NULL IDENTITY(1,1) PRIMARY KEY,
[COMPANY_IDX] [INT] NOT NULL,
[USER_IDX] [INT] NOT NULL,
[HTML_CODE] [TEXT] NOT NULL, 
[IMAGE] [nvarchar] (MAX) NULL,
[DATE_ORIGIN] [DATETIME] NOT NULL,
[DATE_LATEST_USAGE] [DATETIME] NULL,
[DEVICE] [nvarchar] (20) NULL
CONSTRAINT [fk_template_company] FOREIGN KEY([COMPANY_IDX])
REFERENCES [dbo].[company]([COMPANY_IDX]),
CONSTRAINT [fk_ctemplate_multi-user] FOREIGN KEY([USER_IDX])
REFERENCES [dbo].[MULTI-USERS]([USER_IDX]))
ON [PRIMARY] 

GO 


ALTER TABLE [dbo].[TEMPLATE]
DROP COLUMN [IMAGE]

GO 


INSERT [dbo].[TEMPLATE]
VALUES (2, 4, 
'<!DOCTYPE html>
<html>
<body>

<h1>My First Heading</h1>
<p>My first paragraph.</p>

</body>
</html>', '<img src="html5.gif" alt="HTML5 Icon" style="width:128px;height:128px;">', '2017-01-27 10:12:23.500', '', 'mobile');

GO 


UPDATE [dbo].[TEMPLATE]
SET DATE_LATEST_USAGE='2017-03-03 09:07:15.500' WHERE DATE_ORIGIN='2017-01-27 10:12:23.500';

GO 



CREATE TABLE [dbo].[CAMPAIGN] 
([CAMPAIGN_IDX] [INT] NOT NULL IDENTITY(1,1) PRIMARY KEY, 
[USER_IDX] [INT] NOT NULL,
[TEMPLATE_ID] [INT] NOT NULL,
[CAMPAIGN_TITLE] [nvarchar] (1000) NOT NULL, 
[CAMPAIGN_TEXT] [TEXT] NULL, 
[CAMPAIGN_DATE] [DATETIME] NOT NULL,
[NO_ERRORS] [BIT] NULL,
[EMAIL_SUM] [BIGINT] NULL
CONSTRAINT [fk_campaign_multi-users] FOREIGN KEY([USER_IDX])
REFERENCES [dbo].[MULTI-USERS]([USER_IDX]),
CONSTRAINT [fk_campaign_template] FOREIGN KEY([TEMPLATE_ID])
REFERENCES [dbo].[TEMPLATE]([TEMPLATE_ID]))
ON [PRIMARY] 

GO


ALTER TABLE [dbo].[CAMPAIGN]
DROP CONSTRAINT [fk_campaign_company]
GO


ALTER TABLE [dbo].[CAMPAIGN]
ADD [TEMPLATE_ID] [INT] NULL DEFAULT 0;
GO 


ALTER TABLE [dbo].[CAMPAIGN]
ADD CONSTRAINT FK_TEMPLATE_CAMPAIGN FOREIGN KEY (TEMPLATE_ID)
REFERENCES TEMPLATE(TEMPLATE_ID)
GO 



INSERT [dbo].[CAMPAIGN]
VALUES (2, 1, 'MANCHESTER SUSHI DAY', 'Let Yourself to explore Wasabi covered peas', '03/03/2017', '0', 298);

GO



CREATE PROC [dbo].[POP-UP_MESSAGE]
@COMPANY_IDX INT,
@USER_IDX INT,
@CAMPAIGN_IDX INT
AS BEGIN SELECT
c.EMAIL, ISNULL(c.FIRST_NAME, '') + '' + ISNULL(c.MIDDLE_NAME,'') + '' +ISNULL(c.LAST_NAME,'') AS FULL_NAME,
ca.EMAIL_SUM, ca.CAMPAIGN_TITLE FROM COMPANY c INNER JOIN [MULTI-USERS] mu ON c.COMPANY_IDX = mu.COMPANY_IDX
INNER JOIN CAMPAIGN ca ON mu.USER_IDX=ca.USER_IDX
WHERE ca.CAMPAIGN_IDX = @CAMPAIGN_IDX AND mu.USER_IDX = @USER_IDX AND c.COMPANY_IDX = @COMPANY_IDX
END


EXECUTE [dbo].[POP-UP_MESSAGE] 2, 2, 1; 


SELECT * FROM [dbo].[CAMPAIGN] WHERE CAMPAIGN_DATE=(SELECT MAX(c.CAMPAIGN_DATE)
         FROM [dbo].[CAMPAIGN] c);
GO


CREATE PROC [dbo].[CAMPAIGN_BY_USER_IDX] 
@USER_IDX INT AS SET NOCOUNT ON
SELECT * FROM [dbo].[CAMPAIGN]
WHERE USER_IDX = @USER_IDX;

EXEC [dbo].[CAMPAIGN_BY_USER_IDX] 2

GO  


CREATE TABLE [dbo].[TRACKING_A_CAMPAIGN]
([TRACKING_IDX] [INT] NOT NULL IDENTITY(1,1) PRIMARY KEY,
[SUBSCRIBER_IDX] [INT] NOT NULL,
[CAMPAIGN_IDX] [INT] NOT NULL,
[SCHEDULE_FLAG] [nvarchar] (10) NULL,
[SCHEDULE_DATETIME] [DATETIME] NULL,
[BOUNCE_FLAG] [nvarchar] (10) NULL,
[FORWARD_FLAG] [nvarchar] (10) NULL,
[FORWARD_DATETIME] [DATETIME] NULL,
[OPEN_FLAG] [nvarchar] (10) NULL,
[OPEN_DATETIME] [DATETIME] NULL,
[CLICK_FLAG] [nvarchar] (10) NULL,
[CLICK_DATETIME] [DATETIME] NULL,
[UNSUBSCRIBE_FLAG] [nvarchar] (10) NULL,
[UNSUBSCRIBE_DATETIME] [DATETIME] NULL
CONSTRAINT [fk_tracking_a_campaign_subscriber_list] FOREIGN KEY([SUBSCRIBER_IDX])
REFERENCES [dbo].[subscriber_list]([SUBSCRIBER_IDX]),
CONSTRAINT [fk_tracking_a_campaign_campaign] FOREIGN KEY([CAMPAIGN_IDX])
REFERENCES [dbo].[campaign]([CAMPAIGN_IDX]))
ON [PRIMARY] 

GO



--TRACKING A CAMPAIGN: SUM OF EMAILS 

SELECT
SUM (CASE BOUNCE_FLAG WHEN 'Y' THEN 1
ELSE 0 END) AS [BOUNCE]
FROM [dbo].[TRACKING_A_CAMPAIGN] 
WHERE CAMPAIGN_IDX = '1' 



--REPLACES NULL WITH 'N' (NO) VALUE 
SELECT FORWARD_FLAG, ISNULL(FORWARD_FLAG, 'N') AS 'FORWARD_FLAG'
FROM [dbo].[TRACKING_A_CAMPAIGN]




--EMAIL_SUM 
SELECT COUNT(*)[TRACKING IDX]
FROM TRACKING_A_CAMPAIGN
WHERE CAMPAIGN_IDX 
IN (SELECT CAMPAIGN_IDX FROM CAMPAIGN 
WHERE CAMPAIGN_IDX = '')


 

 













