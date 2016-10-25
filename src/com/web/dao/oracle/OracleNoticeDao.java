package com.web.dao.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.model.NoticeModel;

import com.web.dao.NoticeDao;
import com.web.entities.Notice;


/*public class OracleNoticeDao implements NoticeDao {

   @Override
   public Notice get(String code) throws Exception{
         String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
         String sq1="SELECT * FROM NOTICE_VIEW WHERE CODE = ?";
         String query = "";
         
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(url,"c##sist","dclass"); // 연결,인증   
         //Statement st = con.createStatement(); // 실행, 단 이것은 값을 꽂을 수는 없다
         PreparedStatement st = con.prepareStatement(sq1);
         st.setString(1, code);
         
         ResultSet rs = st.executeQuery(); 
         
         // model 출력할 데이터
         String code="";
         String title="";
         String writer="";
         String content="";
         Date regdate=null;
         int hit=0;
         Notice notice= new Notice();
         
         if(rs.next()){
             notice.setCode(rs.getString("CODE"));
             notice.setTitle(rs.getString("TITLE"));
             notice.setWriter(rs.getString("WRITER"));
             notice.setContent(rs.getString("CONTENT"));
             notice.setRegdate(rs.getDate("REGDATE"));
             notice.setHit(rs.getInt("hit"));
         }
         rs.close();
         st.close();
         con.close();
      return notice;
   }
   
    public List<NoticeModel> getList(int page,String field,String query) throws ClassNotFoundException, SQLException {
		{
		     String sql = "SELECT *"+ 
		    		 	  "FROM("+
		    		 	  "	SELECT ROWNUM NUM, N.*"+ 
		    		 	  "	FROM("+
		    		 	  "		SELECT *"+
		    		 	  "		FROM"+
		    		 	  "			NOTICE VIEW"+
		    		 	  "		WHERE "+field+" LIKE ?"+
		    		 	  "		ORDER BY REGDATE DESC"+
		    		 	  "	)N"+
		    		 	  ")"+
		    		 	  "WHERE NUM BETWEEN ? AND ?";
		     
		     int starNum= 1+(page-1)*10;//1,11,21,31,41,...
		     int endNum= page*10;//10,20,30...
		     query ="%"+ query+ "%";
		    		
		     
		     String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		     Class.forName("oracle.jdbc.driver.OracleDriver");
		     Connection con = DriverManager.getConnection(url,"c##sist","dclass"); // 연결,인증   
		     //Statement st = con.createStatement(); // 실행, 단 이것은 값을 꽂을 수는 없다
		     PreparedStatement st = con.prepareStatement(sql);
		     st.setString(1,query);
		     st.setInt(2,starNum);
		     st.setInt(3,endNum);
		     
		     ResultSet rs = st.executeQuery(); 
		     
		     // model 출력할 데이터
         String code="";
		     String title="";
		     String writer="";
		     String content="";
		     Date regdate=null;
		     int hit=0;
		     List<NoticeModel>list= new ArrayList<>();
		     
		     while(rs.next()){
		    	 NoticeModel notice= new NoticeModel();
		         notice.setCode(rs.getString("CODE"));
		         notice.setCode(rs.getString("TITLE"));
		         notice.setWriter(rs.getString("WRITER"));
		         notice.setContent(rs.getString("CONTENT"));
		         notice.setRegdate(rs.getDate("REGDATE"));
		         notice.setHit(rs.getInt("hit"));
		         list.add(notice);
		     }
		     rs.close();
		     st.close();
		     con.close();

		     return list;
		  }
	} 
    public List<NoticeModel> getList(int page) throws ClassNotFoundException, SQLException {
		return getList(page,"TITLE","");
	}
       
    
    public List<NoticeModel> getList() throws ClassNotFoundException, SQLException {
		return getList(1,"TITLE","");
	}

	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String sqlCode= "SELECT NVL(MAX(TO_NUMBER(CODE)),0)+1 CODE FROM NOTICE";
		
		String sql= "INSERT INTO NOTICE("
						+ "CODE,"
						+ "TITLE,"
						+ "WRITER,"
						+ "CONTENT,"
						+ "REGDATE,"
						+ "HIT)"
						+ "VALUES(?,?,?,?,SYSDATE,0)";
		
	     String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     Connection con = DriverManager.getConnection(url,"c##sist","dclass");
	     
	     Statement stCODE= con.createStatement();
	     ResultSet rs= stCODE.executeQuery(sqlCode);
	     rs.next();
	     
	     String code=rs.getString("CODE");
	     rs.close();
	     stCODE.close();
	     
	     // 연결,인증   
	     PreparedStatement st = con.prepareStatement(sql);
	     st.setString(1,code);
	     st.setString(2,notice.getTitle());
	     st.setString(3,notice.getWriter());
	     st.setString(4,notice.getContent());
	   
	     
	     int result = st.executeUpdate();
	     
	     st.close();
	     con.close();
	   
	     
		return result;
	}

	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
	
		
		String sql= "UPDATE NOTICE("
						+ "SET TITLE=?,"
						+ "WRITER=?,"
						+ "CONTENT=?,"
						+ "WHERE CODE=?";
					
	     String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     Connection con = DriverManager.getConnection(url,"c##sist","dclass");
	     
	
	     
		// 연결,인증
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, notice.getTitle());
		st.setString(2, notice.getWriter());
		st.setString(3, notice.getContent());
		st.setString(4, notice.getCode());
		// st.executeQuery();
		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	@Override
	public int delete(String code) throws ClassNotFoundException, SQLException {
		String sql = "DELETE NOTICE WHERE CODE=?";

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, code);

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}
    

   

}*/