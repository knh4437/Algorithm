-- 코드를 입력하세요
/* MEMBER_PROFILE과 REST_REVIEW 테이블에서 가장 많은 댓글을 쓴 상위 1명을 조회하는 서브 쿼리 작성
    해당 서브 쿼리의 결과로 1명의 ID값과 이름을 조회한다. -> 이름까지 조회해야 메인에서 이름을 출력할 수 있다.
*/
/* 메인 쿼리에선 서브 쿼리의 결과값 이름을 출력하고,
    ID 값을 이용하여 REST_REVIEW 테이블의 ID 값과 같은 컬럼을 조회하여 
    해당 회원의 모든 댓글 정보(리뷰 텍스 트, 날짜)를 출력한다.*/
SELECT q.MEMBER_NAME, rev.REVIEW_TEXT, DATE_FORMAT(rev.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM (SELECT mem.MEMBER_NAME, mem.MEMBER_ID
     FROM MEMBER_PROFILE mem
     INNER JOIN REST_REVIEW rev
     ON mem.MEMBER_ID = rev.MEMBER_ID
     GROUP BY mem.MEMBER_ID
     ORDER BY count(REVIEW_ID) DESC
     LIMIT 1) q
INNER JOIN REST_REVIEW rev
ON q.MEMBER_ID = rev.MEMBER_ID
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC
