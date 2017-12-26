package com.test.iot.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;
import com.test.iot.dao.impl.UserDAOImpl;
import com.test.iot.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO ud = new UserDAOImpl();
	
	@Override
	public ArrayList<HashMap<String, Object>> getUserList(String tableName) {
		Connection con = DBCon.getCon();
		ArrayList<HashMap<String, Object>> userList = ud.selectUserList(con, tableName);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return userList;
	}
	
	@Override
	public String[] getColumns(String tableName) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String sql = "select * from ";
		sql += tableName;
		sql += "_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] colNames = new String[rsmd.getColumnCount()-1];
			for(int i=0; i<colNames.length; i++) {
				colNames[i] = rsmd.getColumnLabel(i+2);				
			}
			con.close();
			con = null;
			return colNames;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;		
	}
	@Override
	public String getPrimaryKeyName(String tableName) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String sql = "select * from ";
		sql += tableName;
		sql += "_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			String PrimaryKeyName = rsmd.getColumnLabel(1);			
			con.close();
			con = null;
			return PrimaryKeyName;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return null;
	}


	public int insertUser(HashMap<String, String> user, String tableName) {

		Connection con = DBCon.getCon();
		int result = 0;
		String[] colNames = getColumns(tableName);
		result = ud.insertUser(con, user, tableName, colNames);
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return result;
	}
	
	public int deleteUser(HashMap<String, String> user, String tableName) {

		Connection con = DBCon.getCon();
		int result = 0;
		String PrimaryKeyName = getPrimaryKeyName(tableName);
		result =  ud.deleteUser(con, user, tableName, PrimaryKeyName);
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return result;
	}
	
	public int updateUser(HashMap<String, String> user, String tableName) {

		Connection con = DBCon.getCon();
		int result = 0;
		String[] colNames = getColumns(tableName);
		String PrimaryKeyName = getPrimaryKeyName(tableName);
		result =  ud.updateUser(con, user, tableName, colNames, PrimaryKeyName);
		try {
			con.commit();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con = null;
		return result;
	}

	

	@Override
	public HashMap<String, Object> getUser() {
		
		return null;
	}

	


	

}
