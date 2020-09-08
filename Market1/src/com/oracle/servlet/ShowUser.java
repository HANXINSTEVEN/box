package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.oracle.entity.Product;
import com.oracle.entity.User;
import com.oracle.service.ProductService;
import com.oracle.service.UserService;

/**
 * Servlet implementation class ShowUser
 */
public class ShowUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String btn1=request.getParameter("but1");
		String btn2=request.getParameter("but2");
		//��֤��
//		int num=(int) (Math.random()*4+1)*10000;
//		String num1=String.valueOf(num);
//		Cookie cookie=new Cookie("number",num1);
//		response.addCookie(cookie);
		User user=new User();
		user.setName(username);
		user.setPassword(password);
		Cookie cookie=new Cookie("username",user.getName());
		response.addCookie(cookie);
		UserService us=new UserService();
		int no=0;
		
	if("ע��".equals(btn1)){
		try {
			no=us.AddUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(no>0){
			JOptionPane.showMessageDialog(null, "ע��ɹ�");
			response.sendRedirect("Register");
		}else{
			JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ�������ע��");
			response.sendRedirect("/Register");
		}
	}
	User user1=null;
	 //��ȡ���û��������֤��
    String numb=request.getParameter("numb");
    System.out.println(numb);
    HttpSession session = request.getSession();
   String na= (String) session.getAttribute("checkCode");
   System.out.println(na);
   //���û��������֤����session��ȡ������֤����бȽϣ���ȵĻ��ͽ��е�¼�������ɹ��򷵻صõ���¼����
   ProductService ps=new ProductService();
	if("��¼".equals(btn2)){
		try {
			 user1=us.Find(user);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(user1!=null&&na.equalsIgnoreCase(numb)){
			JOptionPane.showMessageDialog(null, "��¼�ɹ�");
			try {
				ArrayList<Product> list1 = ps.Find1();
				HttpSession session1=request.getSession();
				session1.setAttribute("list1",list1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("Mainview.jsp").forward(request, response);
		}else{
			JOptionPane.showMessageDialog(null, "��¼ʧ��");
			response.sendRedirect("Register.jsp");
		}
		
		
	}
	
		
	
}
	
}
