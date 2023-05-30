-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, SUM(b.PRICE) TOTAL_SALES
FROM USED_GOODS_USER u
INNER JOIN USED_GOODS_BOARD b
ON u.USER_ID = b.WRITER_ID
WHERE b.STATUS = 'DONE'
GROUP BY u.USER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES ASC