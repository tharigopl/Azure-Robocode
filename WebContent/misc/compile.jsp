<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.tools.*" %>
<%
//Create Robot File - Start

//File creation
String robotsDir = "C:\\robocode_robots\\";
String robotsUserDir = "test@test.com";

String robotFileName = request.getParameter("robocode_file_name");
String robotJavaFileName = robotFileName+".java";
String robotFileContent = request.getParameter("robocode_file_content");
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

String contextpath = request.getContextPath();
//out.println(contextpath);
String contextrealpath = request.getRealPath("/");
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
out.println(success);

//Properties prop = System.getProperties(); 
//out.println(prop.getProperty("java.class.path"));

%>