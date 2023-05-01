-- 아이스크림 가게 '상반기 주문 정보' FIRST_HALF
-- 아이스크림 성분 정보 ICECREAM_INFO
-- 총주문량이 3000 초과, 주 성분이 과일. 정렬 : 총 주문량이 큰 순서대로 조회
SELECT h.FLAVOR FROM FIRST_HALF h
INNER JOIN ICECREAM_INFO info
ON h.FLAVOR = info.FLAVOR
WHERE TOTAL_ORDER > 3000 AND INGREDIENT_TYPE = 'fruit_based'
ORDER BY TOTAL_ORDER DESC;
