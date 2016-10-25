package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class Index extends HttpServlet {
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charest=UTF-8");
      PrintWriter out = response.getWriter();
      // ("키값")
      String _cnt = request.getParameter("cnt");
      int cnt = 100;
      if (_cnt != null)
         cnt = Integer.parseInt(_cnt);
    /*  else if (_cnt != null)
         cnt = Integer.parseInt(_cnt);
*/
      out.write("<!DOCTYPE html>");
      out.write(" <html>");
      out.write("<head>");
      out.write("<meta charset=\"UTF-8\">");
      out.write("<title>Insert title here</title>");
      out.write("</head>");
      out.write("<body>");
      out.write("	<form action=\"bb\" method=\"get\">");
      out.write("		<fieldset>");
      out.write("			<legend>환영인사 입력폼</legend>");
      out.write("			<div>");
      out.write("				<label>반복회수:</label> <input type=\"text\" name=\"cnt\" />");
      out.write("			</div>");
      out.write("			<div>");
      out.write("				<input type=\"submit\" name=\"say hello\" />");
      out.write("			</div>");
      out.write("		</fieldset>");
      out.write("	</form>");
      out.write("</body>");
      out.write("</html>");

      for (int i = 0; i <cnt; i++)
         out.println((i + 1) + " : 안녕 Serblet <br />");
   }
}