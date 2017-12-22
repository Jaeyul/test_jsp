package com.test.iot.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.iot.service.UserService;
import com.test.iot.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	UserService us = new UserServiceImpl();
	public String getCommand(String uri) {	
		
		int idx = uri.lastIndexOf("/");
		if(idx != -1) {			
			return uri.substring(idx+1);			
		}		
		return "";		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
				
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
				
	}
	
	
	
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
//		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		String cmd = getCommand(uri);		
		System.out.println("cmd : " + cmd);
		System.out.println(uri);
		if(cmd.equals("list")) {		
//			HashMap<String, Object> hm = new HashMap<String, Object>();
//			hm.put("test", 1);
//			req.setAttribute("test", hm);
						
			
			req.setAttribute("list", us.getUserList());
			
			
		}else if(cmd.equals("view")) {			
			us.getUser();
		}else {			
			cmd = "/common/error";
		}
//		cmd += ".jsp";			
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/" +cmd);
		
		uri = "/WEB-INF/view" + uri + ".jsp" ;
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);		
//		PrintWriter out = res.getWriter();	
		
		
		
	}
}
