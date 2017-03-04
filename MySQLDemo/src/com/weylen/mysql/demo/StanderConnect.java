package com.weylen.mysql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StanderConnect {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/consumption";
	public static final String DB_USER = "root";
	public static final String DB_PWD = "king";
	
	public static void main(String args[]){
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");
			// ����MYSQL
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			if (connection != null) {
				System.out.println("���ݿ����ӳɹ�");
			}
			String dateStr = "2014-12-10";
			// ����һ��ִ��SQL�����Ķ���
//			Statement statement = connection.createStatement();
			// ִ�в�ѯ�Ĳ���
//			ResultSet rs = statement.executeQuery("select * from events where date(date) > date('"+dateStr+"')");
			String sql = "select * from events where date(date) > date(?) and id > ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			// 1.�������±�  2.value
			ps.setString(1, dateStr);
			ps.setInt(2, 2);
			// ִ��sql
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next()){ // next�������ǽ�����ƶ�����һ�У���������򷵻�true
				// rs.findColumn("id") �õ��������ڵ��±�
				int id = rs.getInt(rs.findColumn("id"));
				String title = rs.getString(rs.findColumn("title")); // ��java.sql���� �±��Ǵ�1��ʼ
				String desc = rs.getString(rs.findColumn("description"));
				String date = rs.getString(rs.findColumn("date"));
				double money = rs.getDouble(rs.findColumn("money"));
				System.out.println("id:"+id+",title:"+title+",desc:"+desc+",date:"+date+",money:"+money);
			}
			
			rs.close();
			ps.close();
//			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
