package com.utd.robocode.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Access;

import com.utd.robocode.dto.AccessRights;
import com.utd.robocode.dto.Robots;
import com.utd.robocode.dto.Users;
import com.utd.robocode.repository.AccessRightsRepository;
import com.utd.robocode.repository.CreateRobotRepository;
import com.utd.robocode.utils.DataStoreUtils;
import com.utd.robocode.utils.URLReader;

public class MossRobotService {
	private CreateRobotRepository objRobotRepo = null;
	
	public void compareRobotCode(){
		//Process p = null;
		try{			
			/*objRobotRepo = new CreateRobotRepository(objRobot,domain, objUser);
			objRobot = objRobotRepo.doCreateRobotStepOne();*/
			//String[] aCmdArgs = { "perl", "print \"Hello World, Hello Avi\"" };
			Process p = Runtime.getRuntime().exec("cmd /c perl print \"Hello World, Hello Avi\"");			
			
			BufferedReader output = new BufferedReader (new InputStreamReader(p.getInputStream()));
			String line = output.readLine();
			output.close();
			
		}catch(Exception ex){
			
		}	
		System.out.println();
	}
	
	public void assignAccessRightToRobot() throws Exception{
		String[] cmdArr = new String[]{"c:\\Perl64\\bin\\perl", "print \"Hello World, Hello Avi\""};
		int returnValue = 0;
		if (cmdArr != null) {
		        Process p = null;
		        Runtime rt = Runtime.getRuntime();
		        try {
		            // p = rt.exec(cmdArr);  // throws IOException
		        	p = Runtime.getRuntime().exec("c:\\Perl64\\bin\\perl A:\\cloud\\RobocodeLatest\\robocode_online\\src\\com\\utd\\robocode\\services\\moss.pl C:\\apps\\hellodei.java C:\\apps\\deidei.java");
		        	
		            returnValue = p.waitFor();    // throws InterruptedException
		        }
		        catch (IOException xIo) {
		            throw new RuntimeException("Error executing command.",xIo);
		        }
		        catch (InterruptedException xInterrupted) {
		            throw new RuntimeException("Command execution interrupted.",xInterrupted);
		        }
		        
		       
		        {
		    		System.out.println("Process Executed Normally");
		        
		    		
			        InputStreamReader isr = new InputStreamReader(p.getInputStream());
			        BufferedReader stdout = null;
			        stdout = new BufferedReader(isr);
			        String line = null;
			        try {
			        	StringBuffer outputURL = null;
			            while ((line = stdout.readLine()) != null) {
			                System.out.println(line);
			                outputURL = new StringBuffer(line);
			            }
			            int result = URLReader.fetchResults(outputURL.toString());
			        }
			        catch (IOException xIo) {
			            throw new RuntimeException("Error reading process output", xIo);
			        }
		        }
		    }
	}
}
