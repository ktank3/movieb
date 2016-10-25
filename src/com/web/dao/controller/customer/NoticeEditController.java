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

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String code = request.getParameter("code");
		  String content= request.getParameter("content");
		  String title= request.getParameter("title");
		  
		  NoticeDao noticeDao = new MybatisNoticeDao();
		  Notice n = new Notice();
		  
		
		  n.setTitle(title);
		  n.setCode(code);
		  n.setContent(content);	 
		  
		  noticeDao.update(n);
		  
		  response.sendRedirect("notice-detail?code="+code);
	
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _code = request.getParameter("code");

	      NoticeDao noticeDao = new MybatisNoticeDao();
	      Notice notice;
	      
	      notice = noticeDao.get(_code);
	      request.setAttribute("n", notice);
	      
	      request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);
	}
	

}
