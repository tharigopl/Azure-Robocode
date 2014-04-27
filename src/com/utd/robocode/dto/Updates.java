package com.utd.robocode.dto;

import java.util.Date;

public class Updates {
	
	private String ru_id;
	private String ru_robot_id;
	private String ru_user_id;
	private String ru_domain_id;
	private Date created_date;
	private Date updated_date;
	
	public String getru_id() {
		return ru_id;
	}
	
	public String getru_robot_id() {
		return ru_robot_id;
	}
	
	public String getru_user_id() {
		return ru_user_id;
	}
	
	public String getru_domain_id() {
		return ru_domain_id;
	}
	
	public void setru_id(String a) {
		this.ru_id = a;
	}
	
	public void setru_robot_id(String a) {
		this.ru_robot_id = a;
	}
	
	public void setru_user_id(String a) {
		this.ru_user_id = a;
	}
	
	public void setru_domain_id(String a) {
		this.ru_domain_id=a;
	}
	
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}


	public Date getUpdated_date() {
		return updated_date;
	}


	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}


}
