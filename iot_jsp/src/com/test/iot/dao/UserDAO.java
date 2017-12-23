package com.test.iot.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {
	
	ArrayList<HashMap<String, Object>> selectUserList(Connection con);
	HashMap<String, Object> selectUser(Connection con);
	int insertUser(Connection con, HashMap<String, String> user);
}
