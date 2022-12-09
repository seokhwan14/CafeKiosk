drop database if exists Insurance_DB;
create database Insurance_DB;
use Insurance_DB;



create table member( -- 회원가입
	
    name char(6) not null,
    pw varchar(10) not null,
    phone varchar(15) not null primary key,
    ssn varchar(14) not null

);

create table board( -- 게시판

	b_num int primary key auto_increment,
	b_title varchar(30) not null,
    b_content varchar(100) not null,
    b_pw varchar(10) not null,
	phone varchar(15) not null,
    foreign key (phone) references member(phone)
);

select b.b_title , b.b_content from member m , board b where m.phone = b.phone;

select name, phone from member where phone = "aa";

select b.b_num , b.b_title, m.name , m.phone from member m , board b where m.phone = b.phone ORDER BY (b.b_num);
-- 1. member , board 테이블에서 검색
-- 2. 두 테이블간 폰번호가 동일한 레코드 검색 [ pk - fk 연결된것 ]
-- 3. 검색 결과에는 번호, 제목, 내용, 이름, 폰번호

select * from worker;
select * from subworker;
insert into subworker values( 1 , "dd" );

select * from member;
drop table member;
select * from board;
drop table board;
select * from board where b_num = 2;

insert into member values( "1번" , "1번" , "1번", "1번" );
insert into member values( "2번" , "2번" , "2번", "2번" );
insert into member values( "3번" , "3번" , "3번", "3번" );

insert into member values( "11" , "11" , "11", "11" );
insert into member values( "gg" , "gg" , "gg" , "gg"  );
insert into member values( "ㅁㅁ" , "ㅁㅁ" , "11", "ㅁㅁ" );

insert into board values( null , "aa" , "aa" , "aa", "1번" );
insert into board values( null , "ss" , "ss" , "ss", "2번" );
insert into board values( null , "dd" , "dd" , "dd", "dd" );
insert into board values( null , "ㅁㅁ", "ㅁㅁ" , "ㅁㅁ", "11" );

insert into board values( null , "gg" , "gg" , "gg" , "gg" );





-- --------------------------------------------------보험사--------------------------------------

create table list( -- 보험종류 카테고리
	c_num int auto_increment primary key,
    c_title varchar(10)
    
); 

create table sublist( -- 보험 종류 세부내역
 
	 s_num int auto_increment primary key,
	 s_name varchar(10),
	 s_text text,
	 c_num int , 
	 foreign key (c_num) references list(c_num)

);

create table worker( -- 상담사 카테고리 리스트

	w_num int auto_increment primary key,
	w_name varchar(10) unique not null
    
);

select * from worker;
drop table worker;

select * from subworker;
drop table subworker;

insert into worker values( null , "상담사A");
insert into worker values( null , "상담사B");
insert into worker values( null , "상담사C");


INSERT INTO subworker sw (b_num, w_num, w_name, w_reply) SELECT b.b_num, w.w_num, w.w_name, 'asdf' FROM board b LEFT JOIN worker w ON w.w_name = sw.w_name; 

insert into subworker  values( 1,  "상담사C", "댓글ㄹㄹㄹㄹㄹ" );

insert into subworker (b_num, w_name, w_reply) VALUES(1, "상담사C", "아무말이나적어봐요");
insert into subworket ( 


create table subworker( --  상담직원 상세내용 
	
	b_num int ,	
    w_num int ,
    w_name varchar(10) ,
   	w_reply varchar(100) ,
	foreign key (b_num) references board(b_num) ,
    foreign key (w_num) references worker(w_num) ,
    CONSTRAINT subworker_worker_FK foreign key (w_name) references worker(w_name)
	
   
);
drop table subworker;

 -- worker = 상담사 번호(pk), 상담사 이름
 -- subworker = 상담사 번호(fk), 댓글내용
 -- board = 게시판
 
insert into subworker values( 1, 1, "냐용" );
 
select w.w_num, sw.w_reply, w.w_name from worker w , subworker sw where w.w_num = 1;
select b.b_num, sw.w_reply, w.w_name from worker w , subworker sw, board b where w.w_num = 1 and b.b_num = 2;
select b.b_num, sw.w_reply, w.w_name from worker w , subworker sw , board b where b.b_num =2;
select b.b_num, sw.w_reply, w.w_name from worker w , subworker sw , board b where b_num = 2;


create table mypage( -- 나의 페이지

	c_num int,
	s_num int,
	foreign key (c_num) references list(c_num),
	foreign key (s_num) references sublist(s_num)
);

select * from member where phone="bb";
