package com.utd.robocode.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.utd.robocode.dto.*;
import com.utd.robocode.utils.DataStoreUtils;

public class GalleryRepository {
	
	public StringBuilder sbdomain = null;	
	public AccessRights objAcc = null;
	public Roles objRoles = null;
	public Users objUser = null;
	public DataStoreUtils dataStoreUtils = new DataStoreUtils();
	public static HashMap<String, SessionFactory> sessionFactories = DataStoreUtils.buildSessionFactory();
	/*
	public List<AccessRights> RobotsGalleryUsingHibernate1(int a) throws Exception
	{
		SessionFactory sf = sessionFactories.get("DBConnectionDomain1");
		try {
			if(sf != null){
				Session session = sf.openSession();
				session.beginTransaction();
				access1 = session.createQuery("from AccessRights where Role_id = " + a).list();
				
			}			
		} catch (Exception e) {
				e.printStackTrace();
		}
		return access1;
	}
	public List<AccessRights> RobotsGalleryUsingHibernate2(int a) throws Exception
	{
		SessionFactory sf = sessionFactories.get("DBConnectionDomain2");
		try {
			if(sf != null){
				Session session = sf.openSession();
				session.beginTransaction();
				access2 = session.createQuery("from AccessRights where role_id = ").list();
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return access2;
	}
	public Roles UserRoleforGallery() 
	{
		SessionFactory sf = sessionFactories.get("DBConnectionDomain1");
		try {
			if(sf != null){
				Session session = sf.openSession();
				session.beginTransaction();
				List<Roles> roles = session.createQuery("from Roles").list();
				objRoles = roles.get(0);
			}			
		} catch (Exception e) {
				e.printStackTrace();
		}
		return objRoles;
	}
	*/
	public List<AccessControl> Access1(Users a)throws Exception
	{
		int acc;
		List<AccessControl> AC = null;
		List<Robots> robolist = null;
		List<AccessRights> AR = null;
		List<Updates> up = null;
		AccessControl objAc = null;
		Updates objUpdate=null;
		Robots objRobot = null;
		Users objUser = a; // add user information
		SessionFactory sf1 = sessionFactories.get("DBConnectionDomain1");
		SessionFactory sf2 = sessionFactories.get("DBConnectionDomain2");
		try
		{
			if(sf1!=null)
			{
				Session session = sf1.openSession();
				session.beginTransaction();
				robolist = session.createQuery("from Robots").list();
			}
			if(sf2!=null)
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		for(int i=0;i < robolist.size();i++ )
		{
			objRobot = robolist.get(i);
			objAc.setrobot_id(objRobot.getRobot_id());
			objAc.setrobot_name(objRobot.getRobot_name()); 
			if(objRobot.getCreated_by() == Integer.parseInt(objUser.getUser_id()) && Integer.parseInt(objUser.getUser_domain_id())==1)
			{
				objAc.setaccess(4);
			}
			else
			{
				acc=4;
				up=null;
				Session session = sf1.openSession();
				session.beginTransaction();
				up = session.createQuery("from robot_updates where ru_robot_id = " + objRobot.getRobot_id()).list();
				
				for(int j =0; j<up.size();j++)
				{
					int y=0;
					objUpdate=up.get(j);
					if(Integer.parseInt(objUpdate.getru_domain_id())==1)
					{
						List<String> mapped = session.createQuery("Select ar_right_id from access_rights where ar_role_id = "+objUser.getUser_id()).list();
 						y = Integer.parseInt(mapped.get(0));					
 					}	
					else
					{
						Session session2 = sf2.openSession();
						session2.beginTransaction();
						List<String> intermediate = session2.createQuery("Select idm_other_domain_role_id from inter_domain_mapping where idm_role_id = "+ objUser.getUser_id()).list();
						String x = intermediate.get(0);
						List<String> final_role = session.createQuery("Select idm_other_domain_role_id from inter_domain_mapping where idm_role_id = "+ x).list();
 						String final_role_id = final_role.get(0);
 						List<String> mapped = session.createQuery("Select ar_right_id from access_rights where ar_role_id = "+final_role_id).list();
 						y = Integer.parseInt(mapped.get(0)); 
					}
					acc = Math.min(acc, y);
				}
				objAc.setaccess(acc);
				
			}
			AC.set(i,objAc);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return AC;
	}
	public List<AccessControl> Access2(Users a)throws Exception
	{
		int acc;
		List<AccessControl> AC = null;
		List<Robots> robolist = null;
		List<AccessRights> AR = null;
		List<Updates> up = null;
		AccessControl objAc = null;
		Updates objUpdate=null;
		Robots objRobot = null;
		Users objUser = a; // add user information
		SessionFactory sf1 = sessionFactories.get("DBConnectionDomain2");
		SessionFactory sf2 = sessionFactories.get("DBConnectionDomain1");
		try
		{
			if(sf1!=null)
			{
				Session session = sf1.openSession();
				session.beginTransaction();
				robolist = session.createQuery("from Robots").list();
			}
			if(sf2!=null)
			{
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		for(int i=0;i < robolist.size();i++ )
		{
			objRobot = robolist.get(i);
			objAc.setrobot_id(objRobot.getRobot_id());
			objAc.setrobot_name(objRobot.getRobot_name()); 
			if(objRobot.getCreated_by() == Integer.parseInt(objUser.getUser_id()) && Integer.parseInt(objUser.getUser_domain_id())==1)
			{
				objAc.setaccess(4);
			}
			else
			{
				acc=4;
				up=null;
				Session session = sf1.openSession();
				session.beginTransaction();
				up = session.createQuery("from robot_updates where ru_robot_id = " + objRobot.getRobot_id()).list();
				
				for(int j =0; j<up.size();j++)
				{
					int y=0;
					objUpdate=up.get(j);
					if(Integer.parseInt(objUpdate.getru_domain_id())==1)
					{
						List<String> mapped = session.createQuery("Select ar_right_id from access_rights where ar_role_id = "+objUser.getUser_id()).list();
 						y = Integer.parseInt(mapped.get(0));					
 					}	
					else
					{
						Session session2 = sf2.openSession();
						session2.beginTransaction();
						List<String> intermediate = session2.createQuery("Select idm_other_domain_role_id from inter_domain_mapping where idm_role_id = "+ objUser.getUser_id()).list();
						String x = intermediate.get(0);
						List<String> final_role = session.createQuery("Select idm_other_domain_role_id from inter_domain_mapping where idm_role_id = "+ x).list();
 						String final_role_id = final_role.get(0);
 						List<String> mapped = session.createQuery("Select ar_right_id from access_rights where ar_role_id = "+final_role_id).list();
 						y = Integer.parseInt(mapped.get(0)); 
					}
					acc = Math.min(acc, y);
				}
				objAc.setaccess(acc);
				
			}
			AC.set(i,objAc);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return AC;
	}

}
