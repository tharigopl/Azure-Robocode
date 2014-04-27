package com.utd.robocode.dto;

public class AccessControl {
	int Robot_id;
	String Robot_name;
	int Access;
	
	public int getrobot_id() 
	{
		return Robot_id;
	}
	public String getrobot_name()
	{
		return Robot_name;
	}
	public int getaccess()
	{
		return Access;
	}
	public void setrobot_id(String x)
	{
		this.Robot_id =Integer.parseInt(x);
	}
	public void setrobot_name(String a)
	{
		this.Robot_name=a;
	}
	public void setaccess(String y)
	{
		this.Access=Integer.parseInt(y);
	}
	public void setaccess(int y)
	{
		this.Access=y;
	}
}
