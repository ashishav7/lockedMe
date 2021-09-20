package com.lockers.main;

import java.util.Scanner;

public class Loggedin {
	private Register register;
	public Loggedin(Register register){
		this.register = register;
	}
	public void showMenu() {

		Scanner s = new Scanner(System.in);
		boolean status = true;
		do {
			System.out.println("------------------------------------------------------");
			System.out.println("                  Locker Options                      ");
			System.out.println("------------------------------------------------------");
			System.out.println("Welcome " + register.getName() + ", here are some options for you");
			System.out.println("1)Fetch Creds");
			System.out.println("2)Insert Creds");
			System.out.println("3)Delete Creds");
			System.out.println("4)Any other key to exit");
			
			
			int c = s.nextInt();
			switch(c) {
			case 1:
				String siteName;
				System.out.println("Enter Site Name");
//				siteName = s.next();
				DeserializationDemo ds = new DeserializationDemo(register.getName());
				break;
			case 2:
				System.out.println("Enter Site Name");
				String site = s.next();
				System.out.println("Enter username");
				String username = s.next();
				System.out.println("Enter your password");
				String password = s.next();
				
				Credentials cred = new Credentials(username, password, site);
				cred.insert(register.getName());
				break;
			default:
				status = false;
				break;
			}
		}while(status);
	}
}
