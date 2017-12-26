package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {
	
	ArrayList<HashMap<String, Object>> getUserList(String tableName);
	HashMap<String, Object> getUser();
	String[] getColumns(String tableName);
	String getPrimaryKeyName(String tableName);
	int insertUser(HashMap<String, String> user, String tableName);
	int deleteUser(HashMap<String, String> user, String tableName);
	int updateUser(HashMap<String, String> user, String tableName);
	
}
