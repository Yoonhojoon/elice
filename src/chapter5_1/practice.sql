
-- ------------------------------------------------------------------------------
-- 실습3. 테이블 수정
-- ------------------------------------------------------------------------------

-- DESC 명령어를 통해 정의된 kickboards 테이블을 확인할 수 있습니다.
DESC kickboards;

-- kickboards 테이블에 member_birthday 컬럼을 추가하세요.
-- ALTER TABLE 테이블명 ADD COLUMN 컬러명 데이터타입 제약조건
ALTER TABLE kickboards ADD COLUMN member_birthday DATE;

-- rental_date 속성의 데이터 타입을 TIME으로 수정하세요
-- ALTER TABLE 테이블명 MODIFY COLUMN 컬러명 데이터타입 제약조건
ALTER TABLE kickboards MODIFY COLUMN rental_date TIME;

-- member_id와 kickboard_id 컬럼의 제약 조건을 NOT NULL로 수정하세요.
-- ALTER TABLE 테이블명 MODIFY COLUMN 컬러명 데이터타입 제약조건
ALTER TABLE kickboards MODIFY COLUMN member_id VARCHAR(16) NOT NULL;
ALTER TABLE kickboards MODIFY COLUMN kickboard_id VARCHAR(16) NOT NULL;


-- kickboard_id와 kickboard_brand 컬럼의 이름을 변경하세요.
-- ALTER TABLE 테이블명 CHANGE COLUMN 기존컬럼명 새로운 컬러명 데이터타입 제약조건
ALTER TABLE kickboards CHANGE COLUMN kickboard_id id VARCHAR(16) NOT NULL;
ALTER TABLE kickboards CHANGE COLUMN kickboard_brand brand VARCHAR(16);


-- distance 컬럼을 삭제하세요.
-- ALTER TABLE 테이블명 DROP COLUMN 컬럼명
ALTER TABLE kickboards DROP COLUMN distance;

-- kickboards 테이블의 이름을 kickboard로 수정하세요.
-- ALTER TABLE 기존테이블명 RENAME 새로운테이블명
ALTER TABLE kickboards RENAME kickboard;

-- 수정된 kickboard 테이블의 구조를 확인해봅니다. 제출 시 아래 주석을 해제하세요.
DESC kickboard;



-- ------------------------------------------------------------------------------
-- 실습4. 테이블 삭제
-- ------------------------------------------------------------------------------
-- kickboard 테이블을 삭제하세요.
DROP TABLE kickboard;

-- kickboard 테이블이 삭제되었는지 확인해보세요. 아래 코드는 수정하면 안됩니다.
SHOW TABLES;



-- ------------------------------------------------------------------------------
-- 실습5. 제약조건 정의하기
-- ------------------------------------------------------------------------------
-- kickboard 테이블에 제약 조건을 정의하세요.
CREATE TABLE kickboard(
    member_id       VARCHAR(16) NOT NULL,
    member_name     VARCHAR(16) NOT NULL,
    member_birthday DATE CHECK(member_birthday < "2000-01-01"),
    id              VARCHAR(16) NOT NULL UNIQUE,
    brand           VARCHAR(16) NOT NULL,
    rental_location VARCHAR(32) NOT NULL,
    rental_time     TIME CHECK(rental_time < "01:00:00"),
    price           INT DEFAULT 0
);

-- DESC kickboard;

-- 제약 조건이 올바르게 설정되었는지 직접 데이터를 넣어보세요.
-- INSERT INTO kickboard(member_id, member_name, member_birthday, id, brand, rental_location, rental_time, price)
-- VALUES('kmax6', '김민준', '2000-01-01', '7YWC', 'boardkick', '서울시 관악구 신림동', '00:05:25', 4700);
-- INSERT INTO kickboard(member_id, member_name, member_birthday, id, brand, rental_location, rental_time, price)
-- VALUES('flykite', '이서연', '1999-01-01', 'JXAN', 'willgo', '서울시 동작구 대방동', '01:09:00', 7200);

-- select * from kickboard;


-- ------------------------------------------------------------------------------
-- 실습6. 제약조건 추가 및 삭제하기
-- ------------------------------------------------------------------------------
-- 아래 테이블을 직접 수정하지는 않습니다.
CREATE TABLE kickboard(
    member_id       VARCHAR(16)  NOT NULL,
    member_name     VARCHAR(16)  NOT NULL,
    member_birthday DATE,
    id              VARCHAR(16)  NOT NULL,
    brand           VARCHAR(16)  NOT NULL,
    rental_location VARCHAR(32)  NOT NULL,
    rental_time     TIME,
    price           INT          DEFAULT 0,
    CONSTRAINT id_unique UNIQUE (id),
    CONSTRAINT member_birthday_check CHECK (member_birthday < '2000-01-01'),
    CONSTRAINT rental_time_check CHECK(rental_time < '01:00:00')
);

-- kickboard 테이블에 제약 조건을 추가 및 삭제하세요.
ALTER TABLE kickboard
    ADD CONSTRAINT member_id UNIQUE (member_id);

-- 대여 시간에 대한 제약조건 제거.
ALTER TABLE kickboard DROP CONSTRAINT rental_time_check;

-- 가격의 기본값을 1000으로 변경
ALTER TABLE kickboard
    ALTER price SET DEFAULT 1000;

-- 제약 조건이 올바르게 설정되었는지 직접 데이터를 넣어보세요.
-- INSERT INTO kickboard(member_id, member_name, member_birthday, id, brand, rental_location, rental_time, price)
-- VALUES('kmax6', '김민준', '1989-03-09', '7YWC', 'boardkick', '서울시 관악구 신림동', '00:05:25', 4700);
-- INSERT INTO kickboard(member_id, member_name, member_birthday, id, brand, rental_location, rental_time, price)
-- VALUES('kmax6', '이서연', '1999-01-01', 'JXAN', 'willgo', '서울시 동작구 대방동', '00:09:00', 7200);

DESC kickboard;
-- select * from kickboard;





-- ------------------------------------------------------------------------------
-- 실습7. 테이블에 기본키 설정하기
-- ------------------------------------------------------------------------------

-- kickboard 테이블의 id 속성에 PRIMARY KEY 제약 조건을 추가하세요.
CREATE TABLE kickboard(
    member_id       VARCHAR(16)  NOT NULL UNIQUE,
    member_name     VARCHAR(16)  NOT NULL,
    member_birthday DATE,
    id              VARCHAR(16)  PRIMARY KEY,
    brand           VARCHAR(16)  NOT NULL,
    rental_location VARCHAR(32)  NOT NULL,
    rental_time     TIME,
    price           INT          DEFAULT 1000,
    CONSTRAINT id_unique UNIQUE (id),
    CONSTRAINT member_birthday_check CHECK (member_birthday < '2000-01-01')
);

-- id 속성의 Key가 PRI로 설정되는 것을 확인하세요. 아래 코드는 수정하면 안됩니다.
DESC kickboard;

-- 기본키를 삽입하지 않으면 어떻게 되는지 확인해보세요.
-- INSERT INTO kickboard(member_id, member_name, member_birthday, brand, rental_location, rental_time, price, id)
-- VALUES('kmax6', '김민준', '1989-03-09', 'boardkick', '서울시 관악구 신림동', '00:05:25', 4700, "민준kimid");

-- select * from kickboard;


-- ------------------------------------------------------------------------------
-- 실습8. 고객/ 킥보드 테이블 만들기
-- ------------------------------------------------------------------------------
-- customer 테이블을 정의하세요.
CREATE TABLE customer(
    customer_number VARCHAR(10) PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    id VARCHAR(15) NOT NULL UNIQUE,
    pw VARCHAR(20) NOT NULL,
    phone_number VARCHAR(11),
    birth_date DATE


);

-- kickboard 테이블을 정의하세요.
CREATE TABLE kickboard(
    id VARCHAR(10) PRIMARY KEY,
    brand VARCHAR(20) NOT NULL,
    model_year INT NOT NULL,
    price_per_minute INT NOT NULL,
    basic_price INT NOT NULL,
    company VARCHAR(20) NOT NULL
);

-- 정의한 두 테이블을 확인하는 코드입니다. 아래 주석을 해제하여 결과를 확인하세요.
DESC customer;
DESC kickboard;

-- 정의한 테이블에 데이터가 올바르게 삽입되는지 확인해보세요.
INSERT INTO customer
VALUES('0187642351', '김민준', 'kmax6', 'HASH-lui235dfi2', '08786173448', '1989-03-09');
INSERT INTO kickboard
VALUES('7YWC', 'boardkick', 2015, 100, 1000, 'elice');


-- SELECT * FROM customer;

-- SELECT * FROM kickboard;

-- ------------------------------------------------------------------------------
-- 실습9. 관계 테이블 만들기
-- ------------------------------------------------------------------------------

-- -- borrow 테이블을 정의하세요.
-- CREATE TABLE borrow(
--     customer_number VARCHAR(10),
--     rental_time DATETIME,
--     rental_status ENUM('대여','반납') NOT NULL,
--     rental_location VARCHAR(20) NOT NULL,
--     kickboard_id VARCHAR(10),
--     CONSTRAINT borrow_pk PRIMARY KEY (customer_number, rental_time),
--     FOREIGN KEY (customer_number) REFERENCES customer(customer_number),
--     FOREIGN KEY (kickboard_id) REFERENCES kickboard(id)
-- );

-- -- 정의한 테이블과 외래키 제약 조건을 확인하는 코드입니다. 아래 주석을 해제하여 결과를 확인하세요.
-- SELECT * FROM information_schema.table_constraints WHERE CONSTRAINT_TYPE = 'FOREIGN KEY';
-- DESC borrow;

-- -- 정의한 테이블에 데이터가 올바르게 삽입되는지 확인해보세요.
-- INSERT INTO customer
-- VALUES('0187642351', '김민준', 'kmax6', 'HASH-lui235dfi2', '08786173448', '1989-03-09');
-- INSERT INTO kickboard
-- VALUES('7YWC', 'boardkick', 2015, 100, 1000, 'elice');
-- INSERT INTO borrow
-- VALUES('0187642351', '2020-08-20 13:01:02', '대여', '서울시 강남구 역삼동', '7YWC');


-- select * from customer;
-- select * from kickboard;
-- select * from borrow;

show create table borrow;