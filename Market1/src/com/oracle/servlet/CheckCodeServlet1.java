package com.oracle.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCodeServlet1 extends HttpServlet {
	   private Random random=new Random();
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         //�ڴ�ͼƬ����(TYPE_INT_BGR ѡ��ͼƬģʽRGBģʽ)
	        BufferedImage image = new BufferedImage(90,30,BufferedImage.TYPE_INT_BGR);
	         //�õ�����
	        Graphics graphics = image.getGraphics();
	        //��֮ǰҪ������ɫ�����û�����ɫ
	        graphics.setColor(Color.yellow);
	        //����������ָ��Ҫ����������������
	        graphics.fillRect(0,0,90,30);
	        //Ϊ�˷�ֹ�ڿ����ͨ��ɨ�����ʶ����֤�롣Ҫ����֤��ͼƬ�ϼӸ�����
	        //����������һ����graphics.drawLine();
	        for (int i=0;i<5;i++){
	            //��ɫҲҪ���������ÿ���������ɫ��
	            graphics.setColor(getRandomColor());
	            int x1=random.nextInt(90);
	            int y1=random.nextInt(30);
	            int x2=random.nextInt(90);
	            int y2=random.nextInt(30);
	            graphics.drawLine(x1,y1,x2,y2);
	        }
	  
	        //ƴ��4����֤�룬����ͼƬ��
	        char [] arrays={'A','B','C','D','E','7','1','2','3','4','5','6'};
	        StringBuilder builder = new StringBuilder();
	        for(int i=0;i<4;i++){
	               //�����ַ�����ɫ
	  
	                int index=random.nextInt(arrays.length);
	                builder.append(arrays[index]);
	          }
	          //����session�������ɵ���֤���ַ���������ΪcheckCode������session��
        	request.getSession().setAttribute("checkCode",builder.toString());
	          //��4���ַ�����ͼƬ��graphics.drawString(str ,x,y);һ���ַ�һ���ַ���
	        for (int i=0;i<builder.toString().length();i++)
	        {
	            graphics.setColor(getRandomColor());
	            char item=builder.toString().charAt(i);
	            graphics.drawString(item+"",10+(i*20),15);
	        }
	  
	  
	        //����ڴ�ͼƬ�������
	        ImageIO.write(image,"png",response.getOutputStream());
	  
	     }
	  
	     private Color getRandomColor(){
	        int r=random.nextInt(256);
	         int g=random.nextInt(256);
	         int b=random.nextInt(256);
	        return new Color(r,g,b);
	  
	     }
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request, response);
	    }
}