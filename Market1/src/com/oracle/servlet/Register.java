package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=UTF-8");
		Cookie[] cook=request.getCookies();
		   String num="";
		   if(cook!=null){
			   for (Cookie c : cook) {
				   if("number".equals(c.getName())){
					 num=c.getValue();
				   }
				  
				}
		   }
		   int i=(int) (Math.random()*3+1)*3231;
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<form action='ShowUser' method='post'>");
		out.print("<table width=200px height=200px border=1>");
		out.print("<tr><td>XXXX���л�ӭ��</td></tr>");
		out.print("<tr>");
		out.print("<td>");
		out.print("�û�<input type=text name=username></br>");
		out.print("����<input type=password name=password></br>");
//		out.print("��֤��<input type=text name=number value="+i+"></br>");
		out.print("<input type=text   name=numb placeholder='��������֤��'></br>");
		out.print("<img src='CheckCodeServlet1'��nclick=location.href='CheckCodeServlet1' ></br>");
		
//		out.print("������֤��<input type=text name=numb></br>");
		out.print("<input type=submit name=but1 value='ע��'>");
		out.print("<input type=submit name=but2 value='��¼'>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</html>");	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
