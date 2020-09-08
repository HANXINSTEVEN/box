package com.oacle.DButils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	private static final String URL ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";

	private Connection conn =null; //��������
	private PreparedStatement ps =null; // ִ�ж���
	private ResultSet rs=null; //�����
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//��ɾ��
	public int executeUpdatePs(String sql, Object[] objects) throws SQLException {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		ps = conn.prepareStatement(sql);// 1 ps Ԥ����sql
		if (objects != null) {
			// ����
			for (int i = 0; i < objects.length; i++) {
				// 2  ps  ����ֵ
				ps.setObject(i + 1, objects[i]);

			}
		}
		// ps  ִ��
		int no = ps.executeUpdate();
		return no;

	}
/**
 * ��
 * @param sql
 * @param objects
 * @return
 * @throws SQLException
 */
	public ResultSet executeQueryPs(String sql, Object[] objects) throws SQLException {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		ps = conn.prepareStatement(sql);
		// ps ��ʲô���飿
		if (objects != null) {
			// ps ����ֵ

			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);

			}
		}

		return rs = ps.executeQuery();

	}

	public void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

