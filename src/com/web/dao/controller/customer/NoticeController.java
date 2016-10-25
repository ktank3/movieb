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
import com.web.model.NoticeModel;

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String t = request.getParameter("t");
		String q = request.getParameter("q");
		String p = request.getParameter("p");

		int page = 1;
		String query = "";
		String field = "TITLE";
	
		
		if (p != null && !p.equals('1'))
			page = Integer.parseInt(p);
		if (t != null && !t.equals(""))
			field = t;
		if (q != null)
			query = q;

		NoticeDao noticedao;
		List<NoticeModel> list;

		noticedao = new MybatisNoticeDao();
		list = noticedao.getList(page, field, query);
		int count= noticedao.getCount(field, query);
		request.setAttribute("list", list);
		request.setAttribute("count", count);

		// 1. 그냥부르기
		// response.sendRedirect("notice.jsp");
		// 2. 자원을 공유하면서 부르기: 일을계속하거라
		request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);//

	}

}
