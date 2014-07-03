package com.login;

public class UserBean
{
	String userId;
	String name;
	String passwd;
	String email;
	int grade;

	
	public void setUserId(String userId) {
		this.userId = userId; 
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd; 
	}

	public void setEmail(String email) {
		this.email = email; 
	}

	public void setGrade(int grade) {
		this.grade = grade; 
	}

	public String getUserId() {
		return (this.userId); 
	}

	public String getPasswd() {
		return (this.passwd); 
	}

	public String getEmail() {
		return (this.email); 
	}

	public int getGrade() {
		return (this.grade); 
	}

	
	public void setName(String name) {
		this.name = name; 
	}

	public String getName() {
		return (this.name); 
	}
	

	
}