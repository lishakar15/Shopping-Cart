package com.shoppingCart.model;

public class UserVO {
	private String userName;
	private int id;
	private String emailId;
	private String password;
	
	public UserVO(String userName, int id, String emailId, String password) {
		this.userName = userName;
		this.id = id;
		this.emailId = emailId;
		this.password = password;
	}
	public UserVO ()
	{
		//Empty Constructor
	}
	
	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", id=" + id + ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
