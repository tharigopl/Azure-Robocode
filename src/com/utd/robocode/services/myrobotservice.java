package com.utd.robocode.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.utd.robocode.dto.Users;
import com.utd.robocode.dto.Robots;
import com.utd.robocode.repository.myrobotrepository;
import com.utd.robocode.utils.DataStoreUtils;

public class myrobotservice {
	private myrobotrepository objmyroboRepo = null;
	List<display> dp = null;
	
	public List<display> robots1(Users objUser){
		try{
			objmyroboRepo = new myrobotrepository(objUser);
			dp = objmyroboRepo.displayrobotHibernate();
			if(dp == null){
				return false;
			}
		}catch(Exception ex){
			
		}	
		return dp; 
	}
}
