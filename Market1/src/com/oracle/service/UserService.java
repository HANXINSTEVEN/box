package com.oracle.service;

import java.sql.SQLException;

import com.oracle.dao.UserDao;
import com.oracle.entity.User;

public class UserService {
	UserDao ud=new UserDao();
//����
	public int AddUser(User user) throws SQLException{
		int no=ud.Add(user);
	return no;
	}
	//��ѯ
	public User Find(User user) throws SQLException{
	   User us=ud.check(user);
	   return us;
	}
}

