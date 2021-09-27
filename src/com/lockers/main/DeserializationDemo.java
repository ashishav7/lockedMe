package com.lockers.main;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class DeserializationDemo {
	private Map<String,User> mp = new HashMap<String,User>();
	public DeserializationDemo() {
		try {
			
			FileInputStream file = new FileInputStream("file-db.txt");
		
			
			//method to de-serialize the object
			ObjectInputStream input = null;
			while(file.available()>0) {
				input = new ObjectInputStream(file);
				User user = (User) input.readObject();
				mp.put(user.getMail(), user);
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("No users Registered , please register a user before login");
		}
		catch(EOFException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public Map<String,User> getRegisteredUsers(){
		return mp;
	}

	
// deserialization creds
	private Map<String,Credentials> credsMap = new HashMap<String,Credentials>();
	
	public DeserializationDemo(String fileName) {
		try {
			FileInputStream file = new FileInputStream(fileName + "-db.txt");
			
			
			ObjectInputStream input = null;
			
			
			while(file.available()>0) {
				input = new ObjectInputStream(file);
				Credentials creds = (Credentials) input.readObject();
				credsMap.put(creds.getSitename(),creds);
			}
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("please register a credential before using!");
		}
		catch(EOFException e) {

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public Map<String,Credentials> getCredentialUser() {
		return credsMap;
	}
}
