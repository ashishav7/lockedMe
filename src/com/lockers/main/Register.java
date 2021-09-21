package com.lockers.main;

import java.io.File;
import java.io.Serializable;

public class Register implements Serializable {
	private int id;
	private String name,mail,password;
	
	public Register(int id, String name, String mail, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
	}
	
	
	public void register() {
		
			new SerializationDemo(id, name, mail, password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", mail=" + mail + ", password=" + password + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
