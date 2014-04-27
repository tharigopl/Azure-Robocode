package com.utd.robocode.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.tools.*;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.bind.v2.TODO;
import com.utd.robocode.utils.DataStoreUtils;


/**
 * Servlet implementation class Login
 */
//@WebServlet("/compilerobocode")
public class CompileRobocode extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//Create Robot File - Start

		//File creation
		String robotsDir = "C:\\robocode_robots\\";
		String robotsUserDir = "test@test.com";
		String robotFileName = req.getParameter("robocode_file_name");
		String robotJavaFileName = robotFileName+".java";
		String robotFileContent = req.getParameter("robocode_file_content");
		String robotFileFullPath = robotsDir+robotsUserDir+robotJavaFileName;

		File robotFileFullPathFile = new File(robotFileFullPath);

		if (robotFileFullPathFile.exists())
			robotFileFullPathFile.delete();
		boolean fileCreated = robotFileFullPathFile.createNewFile();

		//File appending
		Writer objWriter = new BufferedWriter(new FileWriter(robotFileFullPath));
		objWriter.write(robotFileContent);
		objWriter.flush();
		objWriter.close();

		//Create Robot File - End


		// Compilation - Start
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//System.out.println(compiler);

		String contextpath = req.getContextPath();
		//out.println(contextpath);
		String contextrealpath = req.getRealPath("/");
		//out.println(contextrealpath);

		List<String> optionList = new ArrayList<String>();  
		optionList.addAll(Arrays.asList("-cp", contextrealpath+"/WEB-INF/lib/robocode.jar")); 

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList(robotFileFullPath));
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, optionList, null, compilationUnits);
		boolean success = task.call();
		fileManager.close();
		//System.out.println("Success: " + success);
		//out.println(success);

		//Properties prop = System.getProperties(); 
		//out.println(prop.getProperty("java.class.path"));
		
		
	}
}
