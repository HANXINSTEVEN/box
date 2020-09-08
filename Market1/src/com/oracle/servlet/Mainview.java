package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.oracle.service.ProductService;


public class Mainview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ps=new ProductService();
		doPost(request,response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=UTF-8");
//		PrintWriter out=response.getWriter();
//		int i=1;
//		out.print("<html>");
//		out.print("<center>");
//		out.print("<form action='View' method='post'>");
//		out.print("<table width=300px height=300px border=1>");
//		try {
//			ArrayList<Product>	list1 = ps.FindFen();
//			for (Product p : list1) {
//			out.print("<tr>");
//			out.print("<td><input type=checkbox name=check /></td>");
//			out.print("<td>"+p.getName()+"</td>");
//			out.print("<td>"+p.getAddress()+"</td>");
//			out.print("<td>"+p.getPrice()+"</td>");
//			out.print("</tr>");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		out.print("</table>");
//		out.print("<form>");
//		out.print("</center>");
//		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=UTF-8");
//		String username=request.getParameter("username");
//		System.out.println(username);
//		Cookie[] cook=request.getCookies();
//		   String nam="";
//		   if(cook!=null){
//			   for (Cookie c : cook) {
//				   if("username".equals(c.getName())){
//					 nam=c.getValue();
//				   }
//				  
//				}
//		   }
//		response.getWriter().write("��ӭ����"+nam);
//		PrintWriter out=response.getWriter();
//		ProductService ps=new ProductService();
//		out.print("<html>");
//		out.print("<center>");
//		out.print("<form action='View' method='post'>");
//		out.print("��Ʒ��Ϣ��ѯ</br>");
//		out.print("��Ʒ����<input type=text name=uname></br>");
//		out.print("<input type=submit name=btn1 value=��ѯ>");
//		out.print("<input type=submit name=btn2 value=���></br>");
//		out.print("<table width=300px height=300px border=1>");
//		out.print("<tr>");
//		out.print("<td><input type=checkbox name=check /></td>");
//		out.print("<td>��Ʒ����</td>");
//		out.print("<td>��Ʒ����</td>");
//		out.print("<td>��Ʒ�۸�</td>");
//		out.print("</tr>");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=UTF-8");
    	ProductService ps=new ProductService();
	    Product product=new Product();
		String txt=request.getParameter("uname");
	String btn1=request.getParameter("btn1");
		System.out.println(btn1);
		
		String btn3=request.getParameter("btn3");    
		String btn4=request.getParameter("btn4");
		System.out.println(btn4);
	if("��ѯ".equals(btn1)){
		try {
			product.setName(txt);
			ArrayList<Product> prod=ps.Find2(product);
			HttpSession session=request.getSession();
			session.setAttribute("prod",prod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("Find.jsp").forward(request, response);
		
		
	}
	//���
	String but1=request.getParameter("but1");
	if("ȷ��".equals(but1)){
		String name=request.getParameter("name1");
		String price=request.getParameter("price");
		String address=request.getParameter("address");
		String imagine=request.getParameter("imagine");	
		product.setName(name);
		product.setPrice(price);
		product.setAddress(address);
		product.setImagine(imagine);
		int no=0;
		try {
			no=ps.Add(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(no>0){
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
			request.getRequestDispatcher("Mainview.jsp").forward(request, response);
		}
		
	}

	//ɾ��
			String[] ch1=request.getParameterValues("check");
			
			String delt1=request.getParameter("btn3");
			System.out.println("++++++++++++++++");
			System.out.println(delt1);
			if("ɾ��".equals(delt1)){
				if(ch1!=null&&ch1.length==1){
					int no=0;
						product.setName(ch1[0]);
					    try {
							no=ps.delete(product);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
					    if(no>0){
					    	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					    	request.getRequestDispatcher("Mainview.jsp").forward(request, response);
					    }
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��/����ɾ������");
					response.sendRedirect("Mainview.jsp");
				}
			}
				
		}
//}else{
//	
//	JOptionPane.showMessageDialog(null, "����ɾ������");
//	response.sendRedirect("Mainview.jsp");
//}
		
		
		
		
		
	
		
		    
//			for (Product p : list) {
//			out.print("<tr>");
//			out.print("<td><input type=checkbox name=check /></td>");
//			out.print("<td>"+p.getName()+"</td>");
//			out.print("<td>"+p.getAddress()+"</td>");
//			out.print("<td>"+p.getPrice()+"</td>");
//			out.print("</tr>");
			
//		out.print("</table>");
//		out.print("<form>");
//		out.print("<input type=submit name=btn3 value=ɾ��>");
//		out.print("<input type=submit name=btn4 value=�鿴></br>");
//		out.print("��1ҳ");
//		out.print("<a href='Register?i=0' >��ҳ</a>");
//		out.print("<a href='Mainview'?i=-1>��һҳ</a>");
//		
//		out.print("<a href='Mainview?i=1'>��һҳ</a>");
//		out.print("<a href='Mainview'>βҳ</a>");
//		out.print("</center>");
//		out.print("</html>");
		

	

}
