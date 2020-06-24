####크로스핏홈페이지 프로젝트

##오라클 사용자 생성 
````sql
alter session set "_ORACLE_SCRIPT"=true;  
CREATE USER crossfit IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO crossfit ;
GRANT CREATE TABLESPACE TO crossfit ;
GRANT CREATE TABLE TO crossfit ;
GRANT CREATE SEQUENCE TO crossfit ;
alter user crossfit default tablespace users quota unlimited on users;
````

##테이블 
````sql
CREATE TABLE users(
	id number primary key,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    email varchar2(100) not null,
    address varchar2(100) not null,
    userProfile varchar2(200) default '/crossfit/img/userProfile.png',
    userRole varchar2(20),
    createDate timestamp

insert into users values(1,'클핏마스터',1234,'7@naver.com','부산시 부산진구','','ADMIN',SYSDATE);
) ;

CREATE TABLE board(
	id number primary key,
    userId number,
    title varchar2(100) not null,
    content clob,
    wodImage varchar2(200), 
    readCount number default 0,
    createDate timestamp,
    foreign key (userId) references users (id)
);


CREATE TABLE reply(
	id number primary key,
    userId number,
    boardId number,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
);


````

##시퀀스 만들기 
````sql
 create SEQUENCE users_seq
  start with 1 
  increment by 1;

create SEQUENCE board_seq
  start with 1 
  increment by 1; 

create SEQUENCE reply_seq
  start with 1 
  increment by 1;
````  