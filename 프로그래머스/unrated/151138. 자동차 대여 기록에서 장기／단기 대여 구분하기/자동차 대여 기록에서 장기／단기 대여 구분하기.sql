-- between 시작일 and 종료일 의 경우 종료일을 포함하지 않음.
-- 종료일을 '2022-09-30 23:59:59' 라고 표시하거나
-- 종료일 + 1 을 해줘야 함
SELECT HISTORY_ID, CAR_ID, 
    DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE, 
    DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE, 
    CASE WHEN DATEDIFF(END_DATE, START_DATE) + 1 >= 30 
        THEN
            '장기 대여'
        ELSE
            '단기 대여'
        END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE LEFT(START_DATE, 7) = '2022-09'
ORDER BY HISTORY_ID DESC;