
select * from Notices;


SELECT ISNULL(MAX(CAST(CODE AS int)),0)+1 AS CODE FROM NOTICES

SELECT ISNULL(MAX(CONVERT(int,CODE)),0)+1 AS CODE FROM NOTICES



뷰단위로 쓰는게많게됨


insert into Notices(
		code,
		title,
		content,
		writer)
values(
	'1151',
	'준모형 안녕하세요',
	'준모형 군것질그만하세요',
	'난다고래'
	)
	
CREATE VIEW NOTICES_VIEW
AS
SELECT N.*, COUNT(C.CODE) AS CMTCNT
FROM
	NOTICES N LEFT OUTER JOIN COMMENTS C ON N.CODE = C.NOTICECODE
GROUP BY N.CODE, N.TITLE, N.WRITER, N.CONTENT, N.REGDATE, N.HIT 	
ORDER BY N.REGDATE DESC
	
SELECT *FROM NOTICES_VIEW


SELECT *FROM
		(
			SELECT 
				ROW_NUMBER()OVER (ORDER BY REGDATE DESC) NUM, 
				NOTICES_VIEW.*
			FROM  NOTICES_VIEW
			WHERE TITLE LIKE'%%'
		) N
WHERE NUM BETWEEN 1 AND 10;
타이틀검색쿼리

SELECT *FROM
		(
			SELECT 
				ROW_NUMBER()OVER (ORDER BY REGDATE DESC) NUM, 
				NOTICES_VIEW.*
			FROM  NOTICES_VIEW
			WHERE TITLE LIKE'%%'
		) N
WHERE NUM BETWEEN 1 AND 10;


SELECT  COUNT(*) FROM
		(
			SELECT 
				ROW_NUMBER()OVER (ORDER BY REGDATE DESC) NUM, 
				NOTICES_VIEW.*
			FROM  NOTICES_VIEW
			WHERE TITLE LIKE'%%'
		) N





SQLSERVER 에서는 WHERE절이 나중에 실행되기때문에 서브쿼리로 감싸줘야한다..
	
	DELETE NOTICES