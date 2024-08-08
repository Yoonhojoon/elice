
-- ------------------------------------------------------------------------------
-- [실습1] 1차 정규화 적용하기
-- ------------------------------------------------------------------------------

-- 정의되어 있는 테이블을 확인해보세요.
DESC customer;

-- 1차 정규화를 적용하세요.

-- DELETE 구문을 실행해서 기존 데이터를 삭제.
DELETE FROM customer;

INSERT INTO customer
    VALUES(
            'kmax6',
            '김민준',
            '2020-08-20 13:01:02',
            '서울시 강남구 역삼동',
            'boardkick',
            2015,
            100,
            1000,
            'elice'
    );


INSERT INTO customer
    VALUES(
            'kmax6',
            '김민준',
            '2020-09-01 20:39:52',
            '서울시 강남구 역삼동',
            'boardkick',
            2015,
            100,
            1000,
            'elice'
    );

-- 정규화된 결과를 확인해보세요.
SELECT * FROM customer;



-- ------------------------------------------------------------------------------
-- [실습2] 2차 정규화 적용하기
-- ------------------------------------------------------------------------------

-- 정의되어 있는 테이블을 확인해보세요.
-- DESC customer;

-- 2차 정규화를 적용하세요.
-- 테이블 삭제 -> drop
DROP TABLE customer;

CREATE TABLE customer(
    customer_id VARCHAR(5) PRIMARY KEY,
    customer_name VARCHAR(10) NOT NULL
);

CREATE TABLE borrow(
    customer_id VARCHAR(5) NOT NULL,
    rental_time DATETIME NOT NULL,
    rental_location VARCHAR(20) NOT NULL,
    brand VARCHAR(20) NOT NULL,
    model_year INT NOT NULL,
    price_per_minute INT NOT NULL,
    basic_price INT NOT NULL,
    company VARCHAR(20) NOT NULL,
    CONSTRAINT borrow_pk PRIMARY KEY (customer_id,rental_time),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

-- DESC customer;
-- DESC borrow;

-- 주석을 해제하여 2차 정규화로 분해한 customer 테이블과 borrow 테이블의 구조 및 외래키 설정을 확인하세요.
SELECT * FROM information_schema.table_constraints WHERE CONSTRAINT_TYPE = 'FOREIGN KEY';
DESC customer;
DESC borrow;



-- ------------------------------------------------------------------------------
-- [실습3] 3차 정규화 적용하기
-- ------------------------------------------------------------------------------

-- 정의되어 있는 테이블을 확인해보세요.
DESC customer;
DESC borrow;

-- 3차 정규화를 적용하세요.
DROP TABLE borrow;

CREATE TABLE company(
    brand VARCHAR(20) PRIMARY KEY,
    price_per_minute INT NOT NULL,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE price(
    brand VARCHAR(20) NOT NULL,
    model_year INT NOT NULL,
    basic_price INT NOT NULL,
    CONSTRAINT price_pk PRIMARY KEY (brand, model_year),
    FOREIGN KEY (brand) REFERENCES company(brand)
);

CREATE TABLE borrow(
    customer_id VARCHAR(5) NOT NULL,
    rental_time DATETIME NOT NULL,
    rental_location VARCHAR(20) NOT NULL,
    brand VARCHAR(20) NOT NULL,
    model_year INT NOT NULL,
    CONSTRAINT borrow_pk PRIMARY KEY (customer_id, rental_time),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (brand, model_year) REFERENCES price(brand, model_year)
);
-- 주석을 해제하여 3차 정규화로 분해한 테이블의 구조 및 외래키 설정을 확인하세요.
SELECT * FROM information_schema.table_constraints WHERE CONSTRAINT_TYPE = 'FOREIGN KEY';
DESC company;
DESC price;
DESC borrow;


-- ------------------------------------------------------------------------------
-- [실습4] 공유 킥보드 DB 완성
-- ------------------------------------------------------------------------------

-- 3차 정규화 설정된 테이블을 수정하여 최종 형태의 공유 킥보드 DB를 만드세요.
CREATE TABLE customer(
    customer_number VARCHAR(10) PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    id VARCHAR(15) NOT NULL UNIQUE,
    pw VARCHAR(20) NOT NULL,
    phone_number VARCHAR(11),
    birth_date DATE
);

CREATE TABLE brand(
    brand_number INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE,
    company VARCHAR(20) NOT NULL
);

CREATE TABLE kickboard(
    id VARCHAR(4) PRIMARY KEY,
    brand_number INT NOT NULL,
    model_year INT NOT NULL,
    basic_price INT NOT NULL,
    price_per_minute INT NOT NULL,
    FOREIGN KEY (brand_number) REFERENCES brand(brand_number)
);

CREATE TABLE borrow(
    customer_number VARCHAR(10),
    rental_time DATETIME,
    lat_location FLOAT NOT NULL,
    lon_location FLOAT NOT NULL,
    rental_status ENUM('대여', '반납') NOT NULL,
    kickboard_id VARCHAR(4) NOT NULL,
    CONSTRAINT borrow_pk PRIMARY KEY (customer_number, rental_time),
    FOREIGN KEY (customer_number) REFERENCES customer(customer_number),
    FOREIGN KEY (kickboard_id) REFERENCES kickboard(id)
);


-- 주석을 해제하여 전체 테이블의 구조 및 외래키 설정을 확인하세요.
SELECT * FROM information_schema.table_constraints WHERE CONSTRAINT_TYPE = 'FOREIGN KEY';
DESC customer;
DESC brand;
DESC kickboard;
DESC borrow;





-- ------------------------------------------------------------------------------
-- [실습8] 인덱스 성능 비교
-- ------------------------------------------------------------------------------
-- 쿼리 수행 속도를 확인하기 위한 명령어입니다.
SET profiling = 1;

-- 이름이 '배형찬'인 고객의 데이터를 검색하세요.
-- select * from customer;
-- DESC customer;
SELECT * FROM customer WHERE name="배형찬";

-- name 컬럼의 인덱스를 설정하세요.
CREATE INDEX customer_name_idx ON customer(name);

-- 다시 한 번 이름이 '배형찬'인 고객의 데이터를 검색하세요.
SELECT * FROM customer WHERE name="배형찬";

-- 쿼리 수행 속도 결과를 확인해보세요.
SHOW profiles;



