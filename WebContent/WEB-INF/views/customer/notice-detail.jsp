<%@page import="com.web.dao.mybatis.MybatisNoticeDao"%>
<%@page import="com.web.entities.Notice"%>
<%@page import="com.web.dao.NoticeDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%    

/*    String _code = request.getParameter("code");

	
	NoticeDao noticeDao= new MybatisNoticeDao();
	Notice notice = noticeDao.get(_code);  
   
   pageContext.setAttribute("n", notice);//--->${n.컬럼}  or   ${n["컬럼"]}
 */
   
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>
		<a href="">게시판상세</a>
	</h1>
	<ul>
		<li><a href="../index.jsp">home</a>
		<li>
		<li><a href="notice">공지사항</a>
		<li>
	</ul>
	<table border=1>
		<tbody>

			<tr>
				<td>제목</td>
				<td colspan="3">${n.title}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3">${n.regdate}</td>

			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.writer}</td>
				<td>조회수</td>
				<td>${n.hit}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3"></td>

			</tr>
			<tr>
				<td colspan="4">${n.content}</td>

			</tr>

		</tbody>
	</table>
	<div>
		<input type="hidden" name="code" value="${n.code}">
		<ul>
			<li><a href="notice">목록</a></li>
			<li><a href="notice-edit?code=${n.code}">수정</a></li>
			<li><a href="notice-del?code=${n.code}">삭제</a></li>
		</ul>
	</div>
</body>
</html>