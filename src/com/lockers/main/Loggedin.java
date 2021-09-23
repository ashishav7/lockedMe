package com.lockers.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loggedin {
	private User loggedInUser;
	public Loggedin(User loggedInUser){
		this.loggedInUser = loggedInUser;
	}
	public void showMenu() {

		Scanner s = new Scanner(System.in);
		boolean status = true;
		do {
			System.out.println("------------------------------------------------------");
			System.out.println("                  Locker Options                      ");
			System.out.println("------------------------------------------------------");
			System.out.println("Welcome " + loggedInUser.getName() + ", here are some options for you");
			System.out.println("1)Fetch Creds");
			System.out.println("2)Insert Creds");
			System.out.println("3)Delete Creds");
			System.out.println("4)Any other key to logout");
			int c = s.nextInt();
			switch(c) {
				case 1:
					DeserializationDemo ds = new DeserializationDemo(loggedInUser.getName());
					Map<String,Credentials> creds = ds.getCredentialUser();
					
					if(creds.size()>0) {
						int i =1;
						Map<Integer,Credentials> temp = new HashMap<Integer,Credentials>(); 
						for(Map.Entry<String, Credentials> entry : creds.entrySet()) {
							System.out.println(i +") "+ entry.getKey());
							temp.put(i,entry.getValue());
							i++;
						}
						System.out.println("Enter the site you want to fetch data for");
						int a = s.nextInt();
						if(temp.get(a) == null) {
							System.out.println("No such option!!");
						}
						else {
							System.out.println(temp.get(a));
						}
						temp.clear();
					}
					else {
						System.out.println("No Credential Present");
					}
					break;
				case 2:
					System.out.println("Enter Site Name");
					String site = s.next();
					System.out.println("Enter username");
					String username = s.next();
					System.out.println("Enter your password");
					String password = s.next();
					
					Credentials cred = new Credentials(username, password, site);
					cred.insert(loggedInUser.getName());
					break;
				case 3:
					DeserializationDemo ds1 = new DeserializationDemo(loggedInUser.getName());
					Map<String,Credentials> creds1 = ds1.getCredentialUser();
					if(creds1.size()>0) {
						Map<Integer,Credentials> temp1 = new HashMap<Integer,Credentials>();
						int j=1;
						for(Map.Entry<String, Credentials> entry : creds1.entrySet()) {
							System.out.println(j +") "+ entry.getKey());
							temp1.put(j,entry.getValue());
							j++;
						}
						System.out.println("Which Site credentials you want to delete");
						int b = s.nextInt();
						
						if(temp1.get(b) == null) { 
							System.out.println("No such option!!");
						}
						else {
							temp1.remove(b);
							try {
								new FileOutputStream(loggedInUser.getName()+"-db.txt").close();
								for(Map.Entry<Integer, Credentials> entry : temp1.entrySet()) {
									new SerializationDemo(entry.getValue().getUsername(), entry.getValue().getPassword(), entry.getValue().getSitename(), loggedInUser.getName());
								}
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
					          
						}
					}
					else {
						System.out.println("No Credential Present");
					}
					
					break;
				default:
					status = false;
					break;
				}
		}while(status);
	}
}
