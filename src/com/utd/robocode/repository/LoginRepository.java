package com.utd.robocode.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.utd.robocode.dto.User;
import com.utd.robocode.utils.DataStoreUtils;

public class LoginRepository extends Repository{

	public StringBuilder domain = null;	
	public User objUser = null;
	public DataStoreUtils dataStoreUtils = new DataStoreUtils();
	public static HashMap<String, SessionFactory> sessionFactories = DataStoreUtils.buildSessionFactory();
	
	public LoginRepository(User objUser) {
		// TODO Auto-generated constructor stub
		this.objUser = objUser;
		if(objUser.getDomain_id().equalsIgnoreCase("1")){
			domain = new StringBuilder("DBConnectionDomain1");
		}else{
			domain = new StringBuilder("DBConnectionDomain2");
		}
	}
	
	public User loginUsingHibernate() throws Exception{
		SessionFactory sessionFactory = sessionFactories.get(domain.toString());
		try {
			if(sessionFactory != null){
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				List<User> user = session.createQuery("from User where user_name ='" + objUser.getUser_name() + "'"
						+ "and user_pwd='"+objUser.getPassword()+"'").list();
				System.out.println(user.size());
				
				if(user.size()!=0)
					objUser = user.get(0); 
				else
					objUser = null;
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally{
			//sessionFactory.close();
		}
		return objUser;
	}
}
