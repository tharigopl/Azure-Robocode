package com.utd.robocode.dto;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
Robot table
*/

@XmlRootElement
public class Robots implements java.io.Serializable{
	
	private String robot_id;
	private String robot_name;
	private String robot_desc;
	private String robot_code;
	private int robot_ranking;
	private int created_by;
	private Date created_date;
	private Date updated_date;
	
	
	public String getRobot_id() {
		return robot_id;
	}
	public void setRobot_id(String robot_id) {
		this.robot_id = robot_id;
	}
	public String getRobot_name() {
		return robot_name;
	}
	public void setRobot_name(String robot_name) {
		this.robot_name = robot_name;
	}
	public String getRobot_desc() {
		return robot_desc;
	}
	public void setRobot_desc(String robot_desc) {
		this.robot_desc = robot_desc;
	}
	public String getRobot_code() {
		return robot_code;
	}
	public void setRobot_code(String robot_code) {
		this.robot_code = robot_code;
	}
	public int getRobot_ranking() {
		return robot_ranking;
	}
	public void setRobot_ranking(int robot_ranking) {
		this.robot_ranking = robot_ranking;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_date() {
		return created_date;
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



