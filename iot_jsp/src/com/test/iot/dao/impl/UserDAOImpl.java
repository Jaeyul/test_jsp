package com.test.iot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.iot.common.DBCon;
import com.test.iot.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<HashMap<String, Object>> selectUserList(Connection con) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
		String sql = "select * from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("uino", rs.getString("uino"));
				hm.put("uiname", rs.getString("uiname"));
				hm.put("uiage", rs.getString("uiage"));
				hm.put("uiid", rs.getString("uiid"));
				hm.put("uipwd", rs.getString("uipwd"));				
				hm.put("cino", rs.getString("cino"));		
				hm.put("uiregdate", rs.getString("uiregdate"));	
				hm.put("address", rs.getString("address"));	
				userList.add(hm);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		return userList;
	}

	public int insertUser(Connection con,HashMap<String, String> user) {
		String sql = "insert user_info(uiid, uiname, uiage, uipwd, cino, uiregdate, address)";
		sql += " values(?,?,?,?,1,now(),?)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("uiid"));
			ps.setString(2, user.get("uiname"));
			ps.setString(3, user.get("uiage"));
			ps.setString(4, user.get("uipwd"));
			ps.setString(5, user.get("address"));
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
