package com.oracle.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.dao.ProductDao;
import com.oracle.entity.Product;

public class ProductService {
//��ѯ
	ProductDao pd=new ProductDao();
	public ArrayList<Product> Find1() throws SQLException {
		
		ArrayList<Product> list=pd.check();
		
	    return list;
	}	
//������ѯ
		public ArrayList<Product> Find2(Product product) throws SQLException{
			ArrayList<Product> list1=pd.Find(product);
		   return list1;
		}
		//ɾ��
		public int  delete(Product product) throws SQLException{
			
			int no=pd.Delete(product);
			return no;
		}
		//����
		public int  Add(Product product) throws SQLException{
			int no=pd.Add(product);
		return no;
		}
		//��ҳ
		public ArrayList<Product> FindFen() throws SQLException {
			
			ArrayList<Product> list=pd.Page();
			
		    return list;
		}	
		
		

}
