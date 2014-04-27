package com.utd.robocode.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.utd.robocode.dto.Users;
import com.utd.robocode.dto.Robots;
import com.utd.robocode.utils.DataStoreUtils;

public class myrobotrepository extends Repository{

	public StringBuilder sbdomain = null;	
	public int id;
	public Users objUser = null;
	public Robots objrobot = null;
	public update objupdate = null;
	public DataStoreUtils dataStoreUtils = new DataStoreUtils();
	public static HashMap<String, SessionFactory> sessionFactories = DataStoreUtils.buildSessionFactory();
	
	public myrobotrepository(Users objUser) {
		// TODO Auto-generated constructor stub
		this.objUser = objUser;
		if(objUser.getUser_domain_id().equalsIgnoreCase("1")){
			sbdomain = new StringBuilder("DBConnectionDomain1");
		}else{
			sbdomain = new StringBuilder("DBConnectionDomain2");
		}
	}
	
	public Users displayrobotHibernate() throws Exception{
		SessionFactory sessionFactory = sessionFactories.get(sbdomain.toString());
		try {
			if(sessionFactory != null){
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				id = session.createQuery("select user_id from Users where usre_name=" + objUser.getUser_name);
				List<Robots> robots = session.createQuery("select robot_name, robot_desc, robot_ranking from robots where created_by =" + id).list();
				//List<update> update = session.createQuery("select ru_user_id, update_date from robot_updates where ru_robot_id ='" + id).list();
				//System.out.println(Robots.size());
				//System.out.println(update.size());
				
				if(robots.size()!=0)
					objrobot = robots.get(0); 
				else
					objrobot = null;
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally{
			//sessionFactory.close();
		}
		return robots;
	}
}
