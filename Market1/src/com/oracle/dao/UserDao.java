package com.oracle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.oacle.DButils.DButils;
import com.oracle.entity.User;

public class UserDao {
	User user=null;
	DButils db=new DButils();
	public int  Add(User user) throws SQLException{
		//�����û���Ϣ�����ݿ�
		String sql="insert into users values(?,?)";
		int no=db.executeUpdatePs(sql, new Object[]{user.getName(),user.getPassword()});
	return no;
	}
	//��ѯ
	public User check(User user) throws SQLException {
		String sql = "select * from users where name = ?";
		ResultSet ps = db.executeQueryPs(sql, new Object[]{user.getName()});
		while(ps.next()){
			user.setName(ps.getString("name"));
			user.setPassword(ps.getString("password"));
		}
		return user;
	}

}
