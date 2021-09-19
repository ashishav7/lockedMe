package com.lockers.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	
	public static void main(String[] args) {
		

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		boolean status = true;
		while(status) {
			System.out.println("------------------------------------------------------");
			System.out.println("                  Welcome to Lockers                  ");
			System.out.println("------------------------------------------------------");
			System.out.println("1)Sign in");
			System.out.println("2)Register");
			System.out.println("3)Any other key to exit");
			
			int c = s.nextInt();
			switch(c) {
			case 1:
				String email;
				do {
					System.out.println("Enter email");
					email = s.next();
					if(!validate(email)) {
						System.out.println("Invalid email, please enter again");
					}
				}while(!validate(email));
				
				System.out.println("Enter your password");
				String pass = s.next();
				login(email,pass);
				break;
			case 2:
				System.out.println("Enter id");
				int id = s.nextInt();
				System.out.println("Enter your name");
				String name = s.next();
				String mail;
				do {
					System.out.println("Enter email");
					mail = s.next();
					if(!validate(mail)) {
						System.out.println("Invalid email, please enter again");
					}
				}while(!validate(mail));
				System.out.println("Enter your password");
				String password = s.next();
				Register register = new Register(id,name,mail,password);
				register.register();
				break;
			default:
				status = false;
				break;
			}
		}
	
	}

	private static void login(String username,String password) {
		DeserializationDemo ds = new DeserializationDemo();
		Map<String,Register> registeredUsers = new HashMap<String,Register>();
		registeredUsers = ds.getRegisteredUsers();
//		System.out.println(registeredUsers.get(username));
		if(registeredUsers.get(username).getPassword().equals(password)) {
			Loggedin loggedIn = new Loggedin(registeredUsers.get(username));
			loggedIn.showMenu();
		}
		else {
			System.out.println("Invalid Email/Password");
		}
	}

}
