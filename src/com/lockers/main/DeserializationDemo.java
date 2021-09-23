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
			for(Map.Entry<String, User> entry : mp.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue().toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		catch(EOFException e) {
//			
//			for(Map.Entry<String, User> entry : mp.entrySet()) {
//				System.out.println(entry.getKey() + " " + entry.getValue().toString());
//			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
//	public List<Register> getRegisteredUsers(){
//		return regList;
//	}
	public Map<String,User> getRegisteredUsers(){
		return mp;
	}

	
 // deserialization creds
	private Map<String,Credentials> credsMap = new HashMap<String,Credentials>();
	
	public DeserializationDemo(String fileName) {
		try {
			//read a file
			FileInputStream file = new FileInputStream(fileName + "-db.txt");
			
			// creating a input object stream
			
			ObjectInputStream input = null;
			
			//method to de-serialize the object
			
			while(file.available()>0) {
				input = new ObjectInputStream(file);
				Credentials creds = (Credentials) input.readObject();
				credsMap.put(creds.getSitename(),creds);
			}
			file.close();
			for(Map.Entry<String, Credentials> entry : credsMap.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue().toString());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("please register a credential before using!");
		}
		catch(EOFException e) {
//			for(Register r: regList) {
//				System.out.println(r.toString());
//			}
			
			//Map
			
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
