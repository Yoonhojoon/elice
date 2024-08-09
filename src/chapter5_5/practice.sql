

-- ------------------------------------------------------------------------------
-- [실습1] 집합 연산자 - UNION/UNION ALL
-- ------------------------------------------------------------------------------


-- 아래 쿼리는 request_past, request_new 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC request_past;
DESC request_new;

-- 1. 각 테이블에서 이름(name)과 번호(number)를 조회하고, 집합연산자를 통해 중복을 제거하지 않고 데이터를 연결해보세요.
select name, number from request_past
union all
select name, number from request_new
order by name asc;

-- 2. 각 테이블에서 이름(name)과 번호(number)를 조회하고, 집합연산자를 통해 중복을 제거하여 데이터를 연결해보세요.
select name, number from request_past
union
select name, number from request_new
order by name asc;



-- ------------------------------------------------------------------------------
-- [실습2] 집합 연산자 개념 - INTERSECT
-- ------------------------------------------------------------------------------

-- 아래 쿼리는 student, lecture_special 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC student;
DESC lecture_special;

-- 1. student 테이블에서 이름(name)와 이메일(email)을 조회하는 쿼리를 작성하세요.
select name, email from student;

-- 2. lecture_special 테이블에서 이름(name)와 이메일(email)을 조회하는 쿼리를 작성하세요.
select name, email from lecture_special;

-- 3. 위 2개의 쿼리에 대해서 집합 연산자를 이용하여 공통적으로 존재하는 데이터를 조회하는 쿼리를 작성해주세요.
select name, email from student
intersect
select name, email from lecture_special;




-- ------------------------------------------------------------------------------
-- [실습3] 집합 연산자 개념 - EXCEPT
-- ------------------------------------------------------------------------------


-- 아래 쿼리는 lecture_basic, lecture_special 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC lecture_basic;
DESC lecture_special;

-- 1. lecture_basic 테이블에서 학생번호(student_number)와 학생이름(student_name)을 조회하는 쿼리를 작성하세요.
select student_number, student_name from lecture_basic;

-- 2. lecture_special 테이블에서 학생번호(student_number)와 학생이름(student_name)을 조회하는 쿼리를 작성하세요.
select student_number, student_name from lecture_special;

-- 3. 위 2개의 쿼리에 대해서 집합 연산자를 이용하여 lecture_special 테이블에는 존재하지만, lecture_basic에는
-- 존재하지 않는 학생번호와 학생이름을 조회하는 쿼리를 작성하세요.
select student_number, student_name from lecture_special
except
select student_number, student_name from lecture_basic
order by student_number;






-- ------------------------------------------------------------------------------
-- [실습4] 계층형 질의
-- ------------------------------------------------------------------------------

-- 아래 쿼리는 MEMBER 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC MEMBER;

-- 계층형 질의, WITH RECURSIVE 를 이용하여, member_id, manager_id, lvl을 출력하되
-- member_id 오름차순, lvl 오름차순 정렬을 적용하여 쿼리를 작성하세요.
with recursive CTE(member_id, manager_id, lvl)
AS (
    select member_id, manager_id, 0 as lvl
      from MEMBER
      where manager_id is NULL
      UNION ALL
      SELECT a.member_id, a.manager_id, b.lvl + 1
      from MEMBER a
      join CTE as b
      ON a.manager_id = b.member_id
)

select member_id, manager_id, lvl
from CTE
ORDER BY member_id, lvl;




-- ------------------------------------------------------------------------------
-- [실습5] 멘토와 멘티
-- ------------------------------------------------------------------------------

-- WITH RECURSIVE 를 이용하여 계층형 질의를 작성해보세요.
with recursive CTE(mentee_id, mento_id, lvl)
AS (
    select mentee_id, mento_id, 0 as lvl
      from MEMBER
      where mento_id is NULL
      UNION ALL
      SELECT a.mentee_id, a.mento_id, b.lvl + 1
      from MEMBER a
      join CTE as b
      ON a.mento_id = b.mentee_id
)

select mentee_id, mento_id, lvl
from CTE
ORDER BY lvl, mentee_id;




-- ------------------------------------------------------------------------------
-- [실습6] FROM절 JOIN 형태 - INNER JOIN/USING
-- ------------------------------------------------------------------------------


-- 아래 쿼리는 CLASS_REQUEST, STUDENT, CLASS 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC CLASS_REQUEST;
DESC STUDENT;
DESC CLASS;

-- 1. CLASS_REQUEST 테이블에 대해 JOIN절과 USING을 이용해 STUDENT테이블과 결합하여
-- 신청번호(REQUEST_ID)와 학생이름(STUDENT_NAME)을 조회하는 쿼리를 작성해보세요.
select request_id, student_name from CLASS_REQUEST
join STUDENT USING (STUDENT_ID)
order by request_id;


-- 2. CLASS_REQUEST 테이블에 대해 JOIN절과 USING을 이용해 CLASS테이블과 결합하여
-- 신청번호(REQUEST_ID)와 과목이름(CLASS_NAME)을 조회하는 쿼리를 작성해보세요.
select request_id, class_name from CLASS_REQUEST
JOIN CLASS USING (CLASS_ID)
order by request_id;


-- 3. CLASS_REQUEST 테이블에 대해 JOIN절과 USING을 이용해 STUDENT테이블, CLASS테이블과 결합하여
-- 신청번호(REQUEST_ID)와 학생이름(STUDENT_NAME), 과목이름(CLASS_NAME)을 조회하는 쿼리를 작성해보세요.
select request_id, student_name, class_name from CLASS_REQUEST
join STUDENT USING (STUDENT_ID)
JOIN CLASS USING (class_id)
order by request_id;



-- ------------------------------------------------------------------------------
-- [실습7] FROM절 JOIN 형태 - INNER JOIN/ON/WHERE
-- ------------------------------------------------------------------------------

-- 아래 쿼리는 REQUEST_HIST, MEMBER 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC REQUEST_HIST;
DESC MEMBER;

-- REQUEST_HIST 테이블과 MEMBER 테이블을 INNER JOIN하여 조회하되, 요청상태(req_status)가 fail인 정보만 조회하는 쿼리를 작성하세요.
select request_id, req_status, member_name
from REQUEST_HIST
INNER join MEMBER
    on REQUEST_HIST.req_member_id = MEMBER.member_id
where req_status = 'fail'
order by request_id;


-- ------------------------------------------------------------------------------
-- [실습8] FROM절 JOIN 형태 - CROSS JOIN
-- ------------------------------------------------------------------------------


-- 아래 쿼리는 FIRST_NAME_T, LAST_NAME_T 테이블의 구조를 나타냅니다. 해당 테이블을 수정할 필요는 없습니다.
DESC FIRST_NAME_T;
DESC LAST_NAME_T;

-- FIRST_NAME_T와 LAST_NAME_T를 크로스조인으로 결합하고, first_name과 last_name을 출력하세요.
select first_name, last_name
from FIRST_NAME_T cross join LAST_NAME_T
order by first_name asc, last_name asc;


-- ------------------------------------------------------------------------------
-- [실습9] 뷰
-- ------------------------------------------------------------------------------

-- 아래는 EMPLOYEE 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC EMPLOYEE;

-- 1. 부서이름이 '개발'인 직원의 직원ID, 급여 정보를 가지는 뷰(EMPLOYEE_DEV)를 만드는 쿼리를 작성해봅시다.
CREATE VIEW EMPLOYEE_DEV AS (
  SELECT employee_id, salary
  FROM EMPLOYEE
  WHERE department_name = '개발'
);

-- 2. 위에서 만든 뷰(EMPLOYEE_DEV)의 모든 데이터를 조회하는 쿼리를 작성해봅시다.
SELECT * FROM EMPLOYEE_DEV;


-- ------------------------------------------------------------------------------
-- [실습10] 윈도우 함수 - 순위 함수
-- ------------------------------------------------------------------------------

-- 아래는 GYM_MEMBER 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC GYM_MEMBER;

-- 스쿼트 점수, 벤치 프레스 점수, 데드 리프트 점수의 합계에 대해 동일 점수는 같은 순위로 취급하여 순위를 매겨 조회하세요.
SELECT
    MEMBER_ID,
    SQUAT, BENCH_PRESS, DEADLIFT,
    (SQUAT + BENCH_PRESS + DEADLIFT) AS WEIGHT_SUM,
    RANK() OVER (ORDER BY WEIGHT_SUM DESC) AS 'RANK'
FROM
    GYM_MEMBER;


-- ------------------------------------------------------------------------------
-- [실습11] 윈도우 함수 - 일반 집계 함수
-- ------------------------------------------------------------------------------

-- 아래는 PRODUCT, SELL 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC PRODUCT;
DESC SELL;

-- 1. SELL 테이블과 PRODUCT 테이블을 상품 ID 기준으로 INNER JOIN 하는 쿼리를 작성하세요.
SELECT
    SELL_ID,
    SELLER_NAME,
    PRODUCT_NAME,
    QUANTITY
FROM
    SELL SELL
JOIN PRODUCT PRODUCT
ON SELL.PRODUCT_ID = PRODUCT.PRODUCT_ID
ORDER BY SELL_ID;

-- 2. SUM 집계 함수를 이용하여, 판매자 이름, 상품 ID 별 판매 금액을 구하는 쿼리를 작성하세요.
SELECT
    SELL_ID,
    SELLER_NAME,
    PRODUCT_NAME,
    QUANTITY,
    SUM(PRODUCT.PRICE * SELL.QUANTITY) OVER (PARTITION BY SELLER_NAME, SELL.PRODUCT_ID) AS 'SUM_PRICE'
FROM
    SELL SELL
JOIN PRODUCT PRODUCT
ON SELL.PRODUCT_ID = PRODUCT.PRODUCT_ID
ORDER BY SELL_ID;


-- ------------------------------------------------------------------------------
-- [실습12] 윈도우 함수 - 그룹 내 비율 함수(RATIO_TO_REPORT)
-- ------------------------------------------------------------------------------


-- 아래는 BUDGET_USE 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC BUDGET_USE;

-- 비용이 전체 비용 합계에서 차지하는 비율을 조회해 봅시다.
SELECT
    ID, USE_CODE, EXPENSE,
    ROUND(100 * EXPENSE / SUM(EXPENSE) OVER(), 4) AS 'RATIO'
FROM
    BUDGET_USE
ORDER BY ID asc;





-- ------------------------------------------------------------------------------
-- [실습13] B 등급 누가 받을까
-- ------------------------------------------------------------------------------


-- 아래는 STUDENT 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC STUDENT;

-- 1. 윈도우 함수, CUME_DIST를 이용하여 성적에 대한 누적 백분율 값을 확인하세요.
SELECT
    ID, SCORE,
    CUME_DIST() OVER(ORDER BY SCORE DESC) AS CUME_DIST
FROM
    STUDENT
ORDER BY ID;

-- 2. 1번에서 확인한 누적 백분율 값에 대해 조건을 걸어, 상위 30%초과 상위 70%이내 학생들을 출력하세요.
SELECT
    ID, SCORE, CUME_DIST
FROM
  (SELECT
      ID, SCORE,
      CUME_DIST() OVER(ORDER BY SCORE DESC) AS CUME_DIST
  FROM
      STUDENT) S
WHERE
    CUME_DIST > 0.3 AND CUME_DIST <= 0.7
ORDER BY CUME_DIST;





-- ------------------------------------------------------------------------------
-- [실습14] 윈도우 함수 - 그룹 내 비율 함수(NTILE)
-- ------------------------------------------------------------------------------


-- 아래는 STUDENT 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC STUDENT;

-- 학생들의 수학, 물리, 화학 점수의 총합 내림차순 기준으로 3개의 그룹으로 나누어 조회하는 쿼리를 작성하세요.
SELECT
    ID, MATH, PHYSICS, CHEMISTRY,
    (MATH + PHYSICS + CHEMISTRY) AS SCORE_SUM,
    NTILE(3) OVER (ORDER BY SCORE_SUM DESC) AS NTILE
FROM
    STUDENT
ORDER BY ID ASC;

-- ------------------------------------------------------------------------------
-- [실습15] 그룹 함수 - ROLL UP
-- ------------------------------------------------------------------------------


-- 아래는 BOOK_HISTORY 테이블에 대한 구조를 보여줍니다. 테이블을 수정하실 필요는 없습니다.
DESC BOOK_HISTORY;

-- 책 종류와 책 카테고리로 그룹화 하고 ROLLUP을 이용하여 각 그룹당 판매 개수 합을 구해보세요.
SELECT kind, category, sum(sell_count)
from BOOK_HISTORY
group by kind, category with ROLLUP;
