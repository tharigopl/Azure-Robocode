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
import com.utd.robocode.dto.Users;
import com.utd.robocode.dto.Robots;
import com.utd.robocode.services.myrobotservice;
import com.utd.robocode.utils.DataStoreUtils;




/**
 * Servlet implementation class my_robots
 */
//@WebServlet("/my_robots")
public class my_robots extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		Users objUser = new Users();
		objUser.getUser_name();
				
		List <result> result = new myrobotservice().robots1(objUser);
		HttpSession session = null;
		if(result){
			
		}else{
			//TODO: Redirect to login page
			req.setAttribute("msg_error", "No Robot!!!");
			req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
		}
		
	}
}
