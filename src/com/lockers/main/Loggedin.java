package com.lockers.main;

import com.lockers.main.Register;

public class Loggedin {
	private Register register;
	public Loggedin(Register register){
		this.register = register;
	}
	public void showMenu() {
		System.out.println("------------------------------------------------------");
		System.out.println("                  Locker Options                      ");
		System.out.println("------------------------------------------------------");
		System.out.println("Welcome " + register.getName() + ", here are some options for you");
		System.out.println("1)Fetch Creds");
		System.out.println("2)Insert Creds");
		System.out.println("3)Delete Creds");
	}
}
