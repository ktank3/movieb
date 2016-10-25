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

@WebServlet("/customer/notice-del")
public class NoticeDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	   String code = request.getParameter("code");
	   NoticeDao noticeDao = new MybatisNoticeDao();
	   noticeDao.delete(code);
		
	   
	   //--->${n.�÷�}  or   ${n["�÷�"]}

		//1. �׳ɺθ���
		response.sendRedirect("notice");
		//2. �ڿ��� �����ϸ鼭 �θ���: ��������ϰŶ�
	
		
		

	}

}
