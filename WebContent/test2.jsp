<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="robocode.control.*,robocode.control.events.*" %>
<%
//System.setProperty("java.home", "C:\\Program Files (x86)\\Java\\jdk1.7.0_51");

// Disable log messages from Robocode
RobocodeEngine.setLogMessagesEnabled(false);

// Create the RobocodeEngine
//   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
RobocodeEngine engine = new RobocodeEngine(new java.io.File("C:\\ProgFiles\\robocode")); // Run from C:/Robocode

// Add our own battle listener to the RobocodeEngine 
//engine.addBattleListener(new BattleObserver());

// Show the Robocode battle view
//engine.setVisible(true);

// Setup the battle specification

int numberOfRounds = 5;
BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
RobotSpecification[] selectedRobots = engine.getLocalRepository("sample.RamFire,sample.Corners");

BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);

// Run our specified battle and let it run till it is over

engine.runBattle(battleSpec, true); // waits till the battle finishes
out.println("here");
// Cleanup our RobocodeEngine
engine.close();

// Make sure that the Java VM is shut down properly
//System.exit(0);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
</body>
</html>
</body>
</html>