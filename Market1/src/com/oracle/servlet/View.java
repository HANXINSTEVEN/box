package com.oracle.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.oracle.entity.Product;
import com.oracle.service.ProductService;

/**
 * Servlet implementation class View
 */
public class View extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;Charset=UTF-8");
//	String name=request.getParameter("name1");
//	String price=request.getParameter("price");
//	String address=request.getParameter("address");
//	String imagine=request.getParameter("imagine");
//	String but1=request.getParameter("but1");
//	String but2=request.getParameter("but2");
//	Product product=new Product();
//	ProductService ps=new ProductService();
//	if("ȷ��".equals(but1)){
//		product.setName(name);
//		product.setPrice(price);
//		product.setAddress(address);
//		product.setImagine(imagine);
//		int no=0;
//		try {
//			no=ps.Add(product);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(no>0){
//			JOptionPane.showMessageDialog(null, "��ӳɹ�");
//			request.getRequestDispatcher("Mainview").forward(request, response);
//		}
//		
//	}
//	if("����".equals(but2)){
//		request.getRequestDispatcher("Mainview").forward(request, response);
//	}
//	//ɾ��
//		String name1=request.getParameter("delete");
//		
//		int no=0;
//			
//			product.setName(name1);
//		    try {
//				no=ps.delete(product);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		    if(no>0){
//		    	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
//		    	request.getRequestDispatcher("Mainview").forward(request, response);
//		    }
//		String but3=request.getParameter("but3");    
//		String but4=request.getParameter("but4");
//		if("ȷ��".equals(but3)){
//			request.getRequestDispatcher("Mainview").forward(request, response);
//		}
//		if("����".equals(but4)){
//			request.getRequestDispatcher("Mainview").forward(request, response);
//		}
		doPost(request,response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=UTF-8");
		PrintWriter out=response.getWriter();
		String txt=request.getParameter("uname");
		String btn1=request.getParameter("btn1");
		String btn2=request.getParameter("btn2");
		Product product=new Product();
		product.setName(txt);
		ProductService ps=new ProductService();
		//���ҳ��
		if("���".equals(btn2)){
			out.print("<html>");
			out.print("<form action='View'>");
			out.print("<table width=300px height=300px border=1>");
			out.print("<tr>");
			out.print("<td>��Ʒ����</td>");
			out.print("<td><input type=text name=name1></td>");
			out.print("<td>��Ʒ�۸�</td>");
			out.print("<td><input type=text name=price></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>��Ʒ����</td>");
			out.print("<td colspan='3'><input type=text name=address></td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<td>��ƷͼƬ</td>");
			out.print("<td colspan='3'><input type=file name=imagine></td>");
			out.print("</tr>");
			out.print("<td><input type=submit name=but1 value='ȷ��'></td>");
			out.print("<td><input type=submit name=but2 value='����'></td>");
			out.print("</table>");
			out.print("</form>");
			out.print("</html>");
		}
		//��ѯҳ��
		if("��ѯ".equals(btn1)){
			out.print("<html>");
			out.print("<form>");
			out.print("<table width=300px height=300px border=1>");
			try {
				ArrayList<Product> prod=ps.Find2(product);
				for (Product p : prod) {
					out.print("<tr>");
					out.print("<td>��Ʒ����</td>");
					out.print("<td>"+p.getName()+"</td>");
					out.print("<td>��Ʒ�۸�</td>");
					out.print("<td>"+p.getPrice()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<td>��Ʒ����</td>");
					out.print("<td colspan='3'>"+p.getAddress()+"</td>");
					out.print("</tr>");
					out.print("<tr>");
					out.print("<td>��ƷͼƬ</td>");
					out.print("<td colspan='3'><img src=img/"+p.getImagine()+"></td>");
					
					out.print("</tr>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.print("</table>");
			out.print("<td><input type=submit name=but3 value='ȷ��'></td>");
			out.print("<td><input type=submit name=but4 value='����'></td>");
			out.print("</form>");
			out.print("</html>");
		}
	//ɾ��
	String[] ch1=request.getParameterValues("check");
	String but=request.getParameter("btn3");
	if(ch1.length==1||ch1==null){
		if("ɾ��".equals(but)){
		out.print("<html>");
		out.print("<form>");
		out.print("<input type=text name=delete>");
		out.print("<input type=submit value='ȷ��'>");
		out.print("</form>");
		out.print("</html>");
	}	
}else{
	JOptionPane.showMessageDialog(null, "����ɾ������");
	response.sendRedirect("Mainview");
}
}

}
