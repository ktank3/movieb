<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%    
   String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
   String sql = "SELECT * FROM NOTICE_VIEW WHERE TITLE LIKE ?";

   String query = "";
   Class.forName("oracle.jdbc.driver.OracleDriver");
 
   Connection con = DriverManager.getConnection(url,"c##sist","dclass"); // 연결,인증   
   //Statement st = con.createStatement(); // 실행, 단 이것은 값을 꽂을 수는 없다
   PreparedStatement st = con.prepareStatement(sql);
   st.setString(1,"%"+query+"%");
   
   ResultSet rs = st.executeQuery(); 
   
   String code="";
   String title="";
   String writer="";
   String regdate="";
   String hit="";
   %>
<title>Insert title here</title>
</head>
<body>
	<h1><a href="">김훈영 online</a></h1>
	<ul>
		<li><a href="../index.jsp">home</a><li>
		<li><a href="notice.jsp">공지사항</a><li>
		
	</ul>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>	
		<%   
		   while(rs.next()){
			   		code=rs.getString("CODE");
			   		title=rs.getString("TITLE");
			   		writer=rs.getString("WRITER");
			   		regdate=rs.getString("REGDATE");
			   		hit=rs.getString("HIT"); %>
			<tr>
				<td><%= code %></td>
				<td><a href="notice-detail.jsp?code=<%= code%>"><%= title %></a></td>
				<td><%= writer %></td>
				<td><%= regdate %></td>
				<td><%= hit %></td>
			</tr>
			<%} rs.close();
			   st.close();
			   con.close(); %>
			<tr>
				<td>2</td>
				<td>뚫숧훑</td>
				<td>우와우</td>
				<td>2016-09-30</td>
				<td>0</td>			
			</tr>
		</tbody>
	</table>

</body>
</html>