

-- ------------------------------------------------------------------------------
-- [실습1] 데이터 그룹 짓기 - Group By
-- ------------------------------------------------------------------------------

-- rental테이블의 구조를 조회합니다. 수정하실 필요는 없습니다.
DESC rental;

-- 누가 몇권의 책을 빌려갔는지 조회해 봅시다.

SELECT user_id, count(*)
FROM rental
group by user_id;



-- ------------------------------------------------------------------------------
-- [실습2] 데이터 그룹에 조건 적용하기 - HAVING
-- ------------------------------------------------------------------------------

-- rental테이블의 구조를 조회합니다. 수정하실 필요는 없습니다.
DESC rental;


-- 누가 몇권의 책을 빌려갔는지 조회해 봅시다.
-- 이때 두권 이상 빌린 사람들만 조회해 봅시다.

SELECT user_id, count(*)
FROM rental
GROUP BY user_id
HAVING count(*) >= 2;





-- ------------------------------------------------------------------------------
-- [실습3] 두 테이블 간의 교집합 - INNER JOIN 1
-- ------------------------------------------------------------------------------

-- 대출,반납에 대한 정보를 user 테이블과 연결해 조회해 봅시다.

select *
from rental
inner join user;

select count(*) as 'user를 innerjoin rental table'
from rental
inner join user;

select count(*) as '카운트 rental table'
from rental;

select count(*) as '카운트 user table'
from user;



-- select * from user;
-- select * from rental;

-- SELECT *
-- FROM rental
-- INNER JOIN user
-- ON rental.user_id = user.id;

-- select *
-- from rental
-- left join user
-- on rental.user_id = user.id;



-- ------------------------------------------------------------------------------
-- [실습4] 두 테이블 간의 교집합 - INNER JOIN 2
-- ------------------------------------------------------------------------------


-- 대출,반납에 대한 정보를 user 테이블과 연결해 조회해 봅시다.


select *
from rental
inner join user
on rental.user_id = user.id;

-- ------------------------------------------------------------------------------
-- [실습5] 인기 있는 물건
-- ------------------------------------------------------------------------------

-- 지시사항을 만족하는 쿼리를 작성해보세요.

select * from sale limit 5;

select name
        , sum(amount)
from sale
group by name
having sum(revenue) >= 50000;


-- ------------------------------------------------------------------------------
-- [실습6] 판매기록 조회하기
-- ------------------------------------------------------------------------------


-- 판매기록을 product 테이블과 연결해 출력해 봅시다.
-- 이때 product테이블이 중심이 되도록 해 봅시다.

-- select
--     product.id,
--     product.name,
--     product.stock,
--     product.expiration_date,
--     product.list_price,
--     product.selling_price,
--     product.discount_rate,
--     sale.id AS sales_id,
--     sale.product_id,
--     sale.amount,
--     sale.money
-- from product
-- left join  sale
-- on product.id = sale.product_id;

-- 판매기록을 product 테이블과 연결해 출력해 봅시다.
-- 이때 product테이블이 중심이 되도록 해 봅시다.
-- select
--     product.id,
--     product.name,
--     product.stock,
--     product.expiration_date,
--     product.list_price,
--     product.selling_price,
--     product.discount_rate,
--     sale.id AS sales_id,
--     sale.product_id,
--     sale.amount,
--     sale.money
-- from sale
-- right join product
-- on product.id = sale.product_id;

-- select count(*)
-- from sale
-- right join product
-- on product.id = sale.product_id;


-- select count(*)
-- from sale
-- right join product
-- on product.id = sale.product_id;


-- select count(*)
-- from  product
-- left join sale
-- on product.id = sale.product_id;


select *
from sale
right join product
on product.id = sale.product_id;


-- select *
-- from  product
-- left join sale
-- on product.id = sale.product_id;

-- ------------------------------------------------------------------------------
-- [실습7] 단일 행 서브쿼리
-- ------------------------------------------------------------------------------


SELECT * FROM emp;
-- 부서번호가 40인 부서의 급여 평균보다 높게 받는 사원들의 모든 컬럼과 나이를 조회하는 쿼리를 작성해주세요.

SELECT *, FLOOR( (CAST(REPLACE(CURRENT_DATE,'-','') AS UNSIGNED) -
       CAST(REPLACE(birthdate,'-','') AS UNSIGNED)) / 10000 ) as age
from emp
where
    sal > (select avg(sal) from emp where deptno = 40 group by deptno);



-- ------------------------------------------------------------------------------
-- [실습8] 다중 행 서브쿼리
-- ------------------------------------------------------------------------------

-- SELECT * FROM emp;
-- 각 부서별 급여를 제일 많이 받는 사원의 월급을 받는 사원들을 조회하는 쿼리를 작성해주세요.
-- select max(sal)
--                 from emp
--                 group by deptno;


select * from emp
where sal  in(
                select max(sal)
                from emp
                group by deptno
             );
-- ------------------------------------------------------------------------------
-- [실습9] 스칼라 서브쿼리
-- ------------------------------------------------------------------------------

-- salaries 테이블에서 직원 번호와 한 직원의 평균 급여를 중복없이 출력해보세요.
SELECT DISTINCT
    emp_no,
    (
        SELECT AVG(salary)
        FROM salaries s1
        WHERE s1.emp_no = s2.emp_no
    ) AS avg_salary
FROM salaries s2;


-- ------------------------------------------------------------------------------
-- [실습10] 중간고사 수학왕
-- ------------------------------------------------------------------------------
-- 1. 경민이보다 중간고사 수학점수를 높거나 같게 받은 학생들을 조회해 주세요.
select *
from middle_test as m
left join students as s
    on s.student_id = m.student_id
where m.math >= (
    select math
    from middle_test
    where student_id = 10504
);

-- ------------------------------------------------------------------------------
-- [실습11] 동작하는 방식에 따른 서브쿼리 분류 - 연관 서브쿼리
-- ------------------------------------------------------------------------------

-- 아래는 EMPLOYEE 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC EMPLOYEE;

-- 자신의 관리자의 급여보다 높거나 같은 급여를 가진 직원의 ID를 출력하는 쿼리를 작성해봅시다.
SELECT employee_id
from EMPLOYEE a
WHERE salary >= (
                    SELECT salary
                    FROM EMPLOYEE b
                    WHERE b.employee_id = a.manager_id
                )
ORDER BY employee_id asc;
-- ------------------------------------------------------------------------------
-- [실습12] 동작하는 방식에 따른 서브쿼리 분류 - 비연관 서브쿼리
-- ------------------------------------------------------------------------------
-- 아래는 EMPLOYEE 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC EMPLOYEE;

SELECT * FROM EMPLOYEE;

-- SELECT manager_id,salary
-- FROM EMPLOYEE
-- where salary < 8000;

-- 급여가 8000미만인 직원의 관리자 아이디와 급여를 출력하는 쿼리를 작성하세요.
SELECT
    employee_id
    , salary
from EMPLOYEE
where employee_id IN (
                        SELECT manager_id
                        FROM EMPLOYEE
                        where salary < 8000
                     )
order by employee_id asc;

-- ------------------------------------------------------------------------------
-- [실습13] 반환되는 데이터 형태에 따른 서브쿼리 분류 - 단일 행 서브쿼리
-- ------------------------------------------------------------------------------
-- 아래는 REQUEST, REQUEST_DTL 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC REQUEST;
DESC REQUEST_DTL;

-- 1. 요청상태가 FAILED인 요청 데이터를 조회하는 쿼리를 작성해보세요.
SELECT request_id
FROM REQUEST
where request_status = 'FAILED';

-- 2. 위에서 작성한 쿼리를 서브쿼리로 이용하여 REQUEST_DTL 테이블에서 요청 상세를 조회하는 쿼리를 작성해보세요.
SELECT request_dtl_id, request_id, request_name, request_content
from REQUEST_DTL
where request_id = (
    SELECT request_id
    FROM REQUEST
    where request_status = 'FAILED'
    );

-- ------------------------------------------------------------------------------
-- [실습14] 반환되는 데이터 형태에 따른 서브쿼리 분류 - 다중 행 서브쿼리 IN
-- ------------------------------------------------------------------------------
-- 아래는 REQUEST, REQUEST_DTL 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC REQUEST;
DESC REQUEST_DTL;

SELECT request_id
                        FROM REQUEST
                        where request_status = 'FAILED';

-- 요청상태가 FAILED인 요청ID를 구하고, 해당 요청들에 대한 요청상세 정보를 조회하는 쿼리를 작성해보세요.
SELECT request_dtl_id, request_id, request_name, request_content
from REQUEST_DTL
where request_id IN (
                        SELECT request_id
                        FROM REQUEST
                        where request_status = 'FAILED'
                    )
order by request_dtl_id asc;

-- ------------------------------------------------------------------------------
-- [실습15] 반환되는 데이터 형태에 따른 서브쿼리 분류 - 다중 행 서브쿼리 EXISTS
-- ------------------------------------------------------------------------------
-- 아래는 STORE, PAYMENT 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC STORE;
DESC PAYMENT;

-- EXISTS문을 응용하여, 결제금액이 5000원 이상인 가게ID, 가게이름을 조회하는 쿼리를 작성해보세요.
select store_id, store_name
from STORE s
where EXISTS (
                SELECT '1'
                FROM PAYMENT p
                WHERE
                    s.store_id = p.store_id
                    and
                    p.pay_amount >= 5000
             )
order by store_id asc;

-- ------------------------------------------------------------------------------
-- [실습16] 반환되는 데이터 형태에 따른 서브쿼리 분류 - 다중 행 서브쿼리 ALL
-- ------------------------------------------------------------------------------

-- 아래는 EMPLOYEE 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC EMPLOYEE;

-- 1. 직급이 '사원'인 직원의 급여를 조회하는 쿼리를 작성해봅시다.
select salary from EMPLOYEE
where position = '사원'
order by salary asc;

-- 2. 앞에서 작성한 쿼리와 ALL을 이용하여, 모든 사원들의 급여보다 높거나 같은 급여를 가진 직원을 조회하는 쿼리를 작성해봅시다.
select employee_id, salary, position
from EMPLOYEE
where salary >= ALL(
    select salary from EMPLOYEE
    where position = '사원'
)
order by employee_id asc;

-- asc 낮은 것 올라감
-- des 높은 것 내려감.
-- ------------------------------------------------------------------------------
-- [실습17] 반환되는 데이터 형태에 따른 서브쿼리 분류 - 다중 행 서브쿼리 ANY
-- ------------------------------------------------------------------------------
-- 아래는 FOOD 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC FOOD;

-- 음식타입이 Main인 임의의 음식의 가격보다 비싼 음식들을 조회해봅시다.
SELECT food_id, food_type, food_name, price
from FOOD
WHERE price > ANY(
                    SELECT price
                    FROM FOOD
                    WHERE food_type='Main'
              )
order by food_id asc;

-- ------------------------------------------------------------------------------
-- [실습18] 반환되는 데이터 형태에 따른 서브쿼리 분류 - 다중 컬럼 서브쿼리
-- ------------------------------------------------------------------------------

-- 아래는 BOOK, BOOK_STOCK 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC BOOK;
DESC BOOK_STOCK;

-- BOOK_STOCK 테이블에서 재고가 1이상인 데이터의 책이름, 책작가 정보를 조회후, BOOK테이블에 IN을 활용하여 조회하는 쿼리를 작성해봅시다.
SELECT book_id, book_name, book_writer, price
from BOOK
where (book_name, book_writer)
    IN (
        SELECT book_name, book_writer
        FROM BOOK_STOCK
        WHERE stock >= 1
    )
order by book_id asc;