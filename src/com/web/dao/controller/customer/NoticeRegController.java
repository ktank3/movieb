package com.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.NoticeDao;
import com.web.dao.mybatis.MybatisNoticeDao;
import com.web.entities.Notice;
import com.web.model.NoticeModel;

@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String title= request.getParameter("title");
		  String content= request.getParameter("content");
		  
		  NoticeDao noticeDao = new MybatisNoticeDao();
		  
		  Notice n = new Notice();
		  n.setTitle(title);
		  n.setContent(content);
		  //로그인사용자 정보를얻는로직
		  n.setWriter("newlec");
	
		  noticeDao.insert(n);
		  
		  response.sendRedirect("notice");
	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, response);
	}

}
