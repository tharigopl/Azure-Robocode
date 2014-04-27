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
import com.utd.robocode.services.LoginService;
import com.utd.robocode.utils.DataStoreUtils;

import robocode.control.*;
import robocode.control.events.*;
import net.sf.robocode.repository.*;



/**
 * Servlet implementation class Login
 */
//@WebServlet("/runbattle")
public class RunBattle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

        // Disable log messages from Robocode
        RobocodeEngine.setLogMessagesEnabled(false);

        // Create the RobocodeEngine
        //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
        RobocodeEngine engine = new RobocodeEngine(new java.io.File("C:\\ProgFiles\\robocode")); // Run from C:/Robocode
System.out.print(engine);

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

        // Cleanup our RobocodeEngine
        engine.close();

        // Make sure that the Java VM is shut down properly
       // System.exit(0);

		
	}
}
//
//Our private battle listener for handling the battle event we are interested in.
//
class BattleObserver extends BattleAdaptor {

 // Called when the battle is completed successfully with battle results
 public void onBattleCompleted(BattleCompletedEvent e) {
     System.out.println("-- Battle has completed --");
     
     // Print out the sorted results with the robot names
     System.out.println("Battle results:");
     for (robocode.BattleResults result : e.getSortedResults()) {
         System.out.println("  " + result.getTeamLeaderName() + ": " + result.getScore());
     }
 }

 // Called when the game sends out an information message during the battle
 public void onBattleMessage(BattleMessageEvent e) {
     System.out.println("Msg> " + e.getMessage());
 }

 // Called when the game sends out an error message during the battle
 public void onBattleError(BattleErrorEvent e) {
     System.out.println("Err> " + e.getError());
 }
}

