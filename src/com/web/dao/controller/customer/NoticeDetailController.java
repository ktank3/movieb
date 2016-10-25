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

@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	   String _code = request.getParameter("code");

		
		NoticeDao noticeDao;
		Notice notice;
		noticeDao= new MybatisNoticeDao();
		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);

		// --->${n.컬럼} or ${n["컬럼"]}

		// 1. 그냥부르기
		// response.sendRedirect("notice.jsp");
		// 2. 자원을 공유하면서 부르기: 일을계속하거라
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp").forward(request, response);//

	}


}
