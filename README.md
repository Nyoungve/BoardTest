# BoardTest

데이터 베이스 게시판 생성 테이블 쿼리문 정리 
오라클 DB

사용자 이름 : admin
비밀번호 : oracle
호스트이름 : localhost
포트 : 1521
SID : xe

1. 게시판 테이블 생성 
CREATE TABLE NY_BOARD(
    BNO NUMBER NOT NULL,		-- 게시판번호
    TITLE VARCHAR2(100)     NOT NULL,	-- 게시판제목
    CONTENT VARCHAR2(2000)  NOT NULL, 	-- 게시판내용
    WRITER VARCHAR2(100)    NOT NULL,	-- 작성자
    REGDATE DATE            DEFAULT SYSDATE, 	-- 등록일
    HIT NUMBER DEFAULT 0,			-- 조회수
    PRIMARY KEY(BNO)			-- 기본키
);

2. 게시판 댓글 테이블 생성
CREATE TABLE NY_REPLY(
BNO NUMBER NOT NULL, 			-- 게시글번호
RNO NUMBER NOT NULL,		  	-- 댓글번호
CONTENT VARCHAR2(1000) NOT NULL,	-- 내용
WRITER VARCHAR2(50) NOT NULL,		-- 작성자
REGDATE DATE	DEFAULT SYSDATE, 	-- 등록일자
PRIMARY KEY(BNO, RNO)			-- 기본키
)

ALTER TABLE NY_REPLY ADD CONSTRAINT NY_REPLY_BNO FOREIGN KEY(BNO)
REFERENCES NY_BOARD(BNO);

CREATE SEQUENCE NY_REPLY_SEQ START WITH 1 MINVALUE 0;

COMMIT;

3. 회원가입/로그인 관리 테이블 

CREATE TABLE NY_MEMBER (
USERID	VARCHAR2(40) NOT NULL,		--아이디
USERPASS VARCHAR2(100) NOT NULL,	--비밀번호
USERNAME VARCHAR2(40) NOT NULL,	--사용자명
REGDATE	DATE	DEFAULT SYSDATE,		--등록일
PRIMARY KEY(USERID)			--기본키 USERID
); 

4.게시판 첨부파일 업로드 다운로드 
CREATE TABLE NY_FILE
(
    FILE_NO NUMBER,                                      --파일 번호
    BNO NUMBER NOT NULL,                            --게시판 번호
    ORG_FILE_NAME VARCHAR2(260) NOT NULL,    --원본 파일 이름
    STORED_FILE_NAME VARCHAR2(36) NOT NULL, --변경된 파일 이름
    FILE_SIZE NUMBER,                                    --파일 크기
    REGDATE DATE DEFAULT SYSDATE NOT NULL,  --파일등록일
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL, --삭제구분
    PRIMARY KEY(FILE_NO)                               --기본키 FILE_NO
);
COMMIT;

CREATE SEQUENCE SEQ_NY_FILE_NO
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE NOCACHE;

COMMIT;
