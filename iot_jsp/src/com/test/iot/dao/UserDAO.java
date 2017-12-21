package com.test.iot.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserDAO {
	
	ArrayList<HashMap<String, Object>> selectUserList();
	HashMap<String, Object> selectUser();
	
	
	
}
