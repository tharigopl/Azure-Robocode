package com.utd.robocode.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.bind.v2.TODO;
import com.utd.robocode.dto.User;
import com.utd.robocode.services.LoginService;
import com.utd.robocode.utils.DataStoreUtils;



/**
 * Servlet implementation class Login
 */
//@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String domain = req.getParameter("domain");
		
		User objUser = new User();
		objUser.setUser_name(userName);
		objUser.setPassword(password);
		objUser.setDomain_id(domain);
				
		boolean result = new LoginService().isAValidUser(objUser);
		HttpSession session = null;
		if(result){
			session = req.getSession(true); 
			session.setAttribute("userx",userName);
			resp.sendRedirect("dashboard.jsp");		
		}else{
			//TODO: Redirect to login page
			req.setAttribute("msg_error", "User credentials does not match!!! Try Again");
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		}
		
	}
}
