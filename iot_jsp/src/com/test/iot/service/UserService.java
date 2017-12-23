package com.test.iot.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {
	
	ArrayList<HashMap<String, Object>> getUserList();
	HashMap<String, Object> getUser();
	int insertUser(HashMap<String, String> user);

}
