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
			req.setAttribute("list", us.getUserList());
		}else if(cmd.equals("view")) {			
			us.getUser();
		}else if(cmd.equals("insert")) {
		} if(cmd.equals("insertok")){
			HashMap<String,String> hm = new HashMap<String,String>();
			hm.put("uiname", req.getParameter("uiname"));
			hm.put("uiage", req.getParameter("uiage"));
			hm.put("uiid", req.getParameter("uiid"));
			hm.put("uipwd", req.getParameter("uipwd"));
			hm.put("address", req.getParameter("address"));
			us.insertUser(hm);
			req.setAttribute("list", us.getUserList());
			uri="/user/list";
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
