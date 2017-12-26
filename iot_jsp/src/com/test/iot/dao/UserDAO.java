package com.test.iot.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {
	
	ArrayList<HashMap<String, Object>> selectUserList(Connection con, String tableName);
	HashMap<String, Object> selectUser(Connection con);
	int insertUser(Connection con, HashMap<String, String> user, String tableName, String[] colNames);
	int deleteUser(Connection con, HashMap<String, String> user, String tableName, String PrimaryKeyName);
	int updateUser(Connection con, HashMap<String, String> user, String tableName, String[] colNames, String PrimaryKeyName);
}
