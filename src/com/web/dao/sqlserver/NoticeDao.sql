
select * from Notices;


SELECT ISNULL(MAX(CAST(CODE AS int)),0)+1 AS CODE FROM NOTICES

SELECT ISNULL(MAX(CONVERT(int,CODE)),0)+1 AS CODE FROM NOTICES



������� ���°Ը��Ե�


insert into Notices(
		code,
		title,
		content,
		writer)
values(
	'1151',
	'�ظ��� �ȳ��ϼ���',
	'�ظ��� �������׸��ϼ���',
	'���ٰ�'
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
Ÿ��Ʋ�˻�����

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





SQLSERVER ������ WHERE���� ���߿� ����Ǳ⶧���� ���������� ��������Ѵ�..
	
	DELETE NOTICES