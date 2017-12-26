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
		if (idx != -1) {
			return uri.substring(idx + 1);
		}
		return "";
	}

	public String getTableName(String uri) {

		int idx = (uri.substring(1, uri.length())).indexOf("/");
		if (idx != -1) {
			return uri.substring(1, idx + 1);
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

	// public void doProcess(HttpServletRequest req, HttpServletResponse res) throws
	// ServletException, IOException {
	// req.setCharacterEncoding("utf-8");
	// res.setCharacterEncoding("utf-8");
	// res.setContentType("text/html;charset=utf-8");
	//// String url = req.getRequestURL().toString();
	// String uri = req.getRequestURI();
	// String cmd = getCommand(uri);
	// String tableName = getTableName(uri);
	// System.out.println("tableName : " + tableName);
	// System.out.println("cmd : " + cmd);
	// System.out.println(uri);
	// if(cmd.equals("list")) {
	// req.setAttribute("list", us.getUserList());
	// }
	// else if(cmd.equals("view")) {
	// us.getUser();
	// }
	// else if(cmd.equals("insertok")){
	// HashMap<String,String> hm = new HashMap<String,String>();
	// hm.put("uiname", req.getParameter("uiname"));
	// hm.put("uiage", req.getParameter("uiage"));
	// hm.put("uiid", req.getParameter("uiid"));
	// hm.put("uipwd", req.getParameter("uipwd"));
	// hm.put("address", req.getParameter("address"));
	// us.insertUser(hm);
	// req.setAttribute("list", us.getUserList());
	// uri="/user/list";
	// }
	// else if(cmd.equals("deleteok")){
	// HashMap<String,String> hm = new HashMap<String,String>();
	// hm.put("uino", req.getParameter("uino"));
	// us.deleteUser(hm);
	// req.setAttribute("list", us.getUserList());
	// uri="/user/list";
	// }
	// else if(cmd.equals("updateok")){
	// HashMap<String,String> hm = new HashMap<String,String>();
	// hm.put("uiage", req.getParameter("uiage"));
	// hm.put("uino", req.getParameter("uino"));
	// us.updateUser(hm);
	// req.setAttribute("list", us.getUserList());
	// uri="/user/list";
	// }
	// else {
	// cmd = "/common/error";
	// }
	//// cmd += ".jsp";
	//// RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/"
	// +cmd);
	//
	// uri = "/WEB-INF/view" + uri + ".jsp" ;
	// RequestDispatcher rd = req.getRequestDispatcher(uri);
	// rd.forward(req, res);
	//// PrintWriter out = res.getWriter();
	//
	//
	//
	// }

	public void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		// String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();
		String cmd = getCommand(uri);
		String tableName = getTableName(uri);
		System.out.println("tableName : " + tableName);
		System.out.println("cmd : " + cmd);
		System.out.println(uri);

		if (cmd.equals("list")) {
			req.setAttribute("list", us.getUserList(tableName));
		} 
		else if (cmd.equals("view")) {
			us.getUser();
		} 
		else if (cmd.equals("insertok")) {			
			HashMap<String, String> hm = new HashMap<String, String>();
			String[] colNames = us.getColumns(tableName);
			for(int i=0; i<colNames.length; i++) {
				hm.put(colNames[i], req.getParameter(colNames[i]));				
			}
//			hm.put("uiname", req.getParameter("uiname"));
//			hm.put("uiage", req.getParameter("uiage"));
//			hm.put("uiid", req.getParameter("uiid"));
//			hm.put("uipwd", req.getParameter("uipwd"));
//			hm.put("address", req.getParameter("address"));
			us.insertUser(hm, tableName);
			req.setAttribute("list", us.getUserList(tableName));
			uri = "/"+tableName+"/list";
		} 
		else if (cmd.equals("deleteok")) {
			HashMap<String, String> hm = new HashMap<String, String>();
			
			String PrimaryKeyName = us.getPrimaryKeyName(tableName);
			hm.put(PrimaryKeyName, req.getParameter(PrimaryKeyName));
			us.deleteUser(hm, tableName);
			req.setAttribute("list", us.getUserList(tableName));
			uri = "/"+tableName+"/list";
		} 
		else if (cmd.equals("updateok")) {
			HashMap<String, String> hm = new HashMap<String, String>();
			String PrimaryKeyName = us.getPrimaryKeyName(tableName);
			String[] colNames = us.getColumns(tableName);
			for(int i=0; i<colNames.length; i++) {
				hm.put(colNames[i], req.getParameter(colNames[i]));				
			}
			hm.put(colNames[1], req.getParameter(colNames[1]));
			hm.put(PrimaryKeyName, req.getParameter(PrimaryKeyName));
//			hm.put("uiage", req.getParameter("uiage"));
//			hm.put("uino", req.getParameter("uino"));
			us.updateUser(hm, tableName);
			req.setAttribute("list", us.getUserList(tableName));
			uri = "/"+tableName+"/list";
		} 
		else {
			cmd = "/common/error";
		}

		// cmd += ".jsp";
		// RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/" +cmd);

		uri = "/WEB-INF/view" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
		// PrintWriter out = res.getWriter();

	}
}
