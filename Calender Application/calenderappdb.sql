

CREATE SEQUENCE  TEAM_SEQUENCE  MINVALUE 100 MAXVALUE 999999 INCREMENT BY 1 START WITH 101 ;


CREATE SEQUENCE USER_SEQUENCE  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 101;


CREATE SEQUENCE EVENT_SEQUENCE MINVALUE 100 MAXVALUE 999999 INCREMENT BY 1 START WITH 101 ;




 CREATE TABLE TEAM 
   (	TEAM_NAME VARCHAR2(20), 
	TEAM_SEQUENCE NUMBER NOT NULL, 
	CLIENT_NAME VARCHAR2(20), 
	CLIENT_LOCATION VARCHAR2(20), 
	 CONSTRAINT TEAM_PK PRIMARY KEY (TEAM_SEQUENCE)
   );
 







  CREATE TABLE TEAMS_USER 
   (	ID VARCHAR2(20), 
	NAME VARCHAR2(20), 
	EMAIL VARCHAR2(20), 
	MOBILE_NUMBER VARCHAR2(20), 
	DESIGNATION VARCHAR2(20), 
	PASSWORD VARCHAR2(20), 
	TEAMS_USER_SEQID NUMBER NOT NULL, 
	 CONSTRAINT TEAMS_USER_PK PRIMARY KEY (TEAMS_USER_SEQID)
   );
 






  CREATE TABLE EVENTS 
   (	EVENT_TITLE VARCHAR2(20), 
	EVENT_DATE DATE, 
	EVENT_PLACE VARCHAR2(20), 
	TEAM_SEQUENCE NUMBER, 
	EVENT_SEQUENCE_D NUMBER, 
	 CONSTRAINT EVENTS_TEAM_FK1 FOREIGN KEY (TEAM_SEQUENCE)
	  REFERENCES TEAM (TEAM_SEQUENCE) 
   ) ;
 





  CREATE TABLE USER_LOGIN 
   (    EMAIL VARCHAR2(20), 
	PASSWORD VARCHAR2(20), 
	USER_SEQ_ID NUMBER NOT NULL, 
	 CONSTRAINT USER_LOGIN_PK PRIMARY KEY (USER_SEQ_ID)
   );
 

 
 
