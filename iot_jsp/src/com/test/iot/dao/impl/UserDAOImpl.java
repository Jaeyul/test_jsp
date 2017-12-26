package com.test.iot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<HashMap<String, Object>> selectUserList(Connection con, String tableName) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from ";
		sql += tableName;
		sql += "_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] colNames = new String[rsmd.getColumnCount()];
			for(int i=0; i<colNames.length; i++) {
				colNames[i] = rsmd.getColumnLabel(i+1);				
			}			
			while(rs.next()) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				for(String colName : colNames) {
					hm.put(colName, rs.getString(colName));				
				}userList.add(hm);
			}			
			
//			while(rs.next()) {
//				HashMap<String, Object> hm = new HashMap<String, Object>();
//				hm.put("uino", rs.getString("uino"));
//				hm.put("uiname", rs.getString("uiname"));
//				hm.put("uiage", rs.getString("uiage"));
//				hm.put("uiid", rs.getString("uiid"));
//				hm.put("uipwd", rs.getString("uipwd"));				
//				hm.put("cino", rs.getString("cino"));		
//				hm.put("uiregdate", rs.getString("uiregdate"));	
//				hm.put("address", rs.getString("address"));	
//				userList.add(hm);
//			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		return userList;
	}

	public int insertUser(Connection con, HashMap<String, String> user, String tableName, String[] colNames) {
		String sql = "insert into ";
		sql += tableName;
		sql += "_info(";
		for(int i=0; i<colNames.length; i++) {
			sql += colNames[i];
			if(i!=colNames.length-1) {
				sql += ",";
			}
		}
		sql += ")";
		sql += " values(";
		for(int i=0; i<colNames.length; i++) {
			sql += "?";
			if(i!=colNames.length-1) {
				sql += ",";
			}
		}
		sql += ")";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			for(int i=0; i<colNames.length; i++) {
				ps.setString((i+1), user.get(colNames[i]));				
			}
			
//			ps.setString(1, user.get("uiid"));
//			ps.setString(2, user.get("uiname"));
//			ps.setString(3, user.get("uiage"));
//			ps.setString(4, user.get("uipwd"));
//			ps.setString(5, user.get("address"));
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteUser(Connection con,HashMap<String, String> user, String tableName, String PrimaryKeyName) {
		String sql = "delete from ";
		sql += tableName;
		sql += "_info";
		sql += " where ";
		sql += PrimaryKeyName;
		sql += "=?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get(PrimaryKeyName));		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateUser(Connection con,HashMap<String, String> user, String tableName, String[] colNames, String PrimaryKeyName) {
		String sql = "update ";
		sql += tableName;
		sql += "_info";
		sql += " set ";
		sql += colNames[1];
		sql += "=? where ";
		sql += PrimaryKeyName;
		sql += "= ?";			
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);			
			ps.setString(1, user.get(colNames[1]));
			ps.setString(2, user.get(PrimaryKeyName));	
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	


	@Override
	public HashMap<String, Object> selectUser(Connection con) {
		
		return null;
	}
	
	
	
	
	
	
	

}
