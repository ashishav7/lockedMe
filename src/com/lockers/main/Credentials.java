package com.lockers.main;

import java.io.Serializable;

public class Credentials implements Serializable{
	private String username;
	private String password;
	private String sitename;
	public Credentials(String username, String password, String sitename) {
		super();
		this.username = username;
		this.password = password;
		this.sitename = sitename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	@Override
	public String toString() {
		return "Creds [username=" + username + ", password=" + password + ", sitename=" + sitename + "]";
	}
	
	public void insert(String fileName) {
		new SerializationDemo(username, password, sitename, fileName);
	}
	
}
