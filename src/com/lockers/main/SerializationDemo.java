package com.lockers.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerializationDemo {

		// TODO Auto-generated method stub
	
	public SerializationDemo(int id, String name, String mail, String password) {
		
		//convert object into a bytestream
		try {
			//create file output stream
			FileOutputStream file = new FileOutputStream("file-db.txt",true);

			// create a object stream
			ObjectOutputStream out = new ObjectOutputStream(file); 
			
			// method to serialized object 
			out.writeObject(new User(id,name,mail,password));
			
			System.out.println("Serialization Complete");
			//clean up
			out.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
			//credentials serialization
	public SerializationDemo(String username,String password, String siteName, String fileName) {
		
		//convert object into a bytestream
		try {
			//create file output stream
			FileOutputStream file = new FileOutputStream(fileName + "-db.txt",true);
			
			// create a object stream
			ObjectOutputStream out = new ObjectOutputStream(file); 
			
			// method to serialized object 
			out.writeObject(new Credentials(username,password,siteName));
			
			System.out.println("Record Inserted");
			//clean up
			out.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO exception: " + e.getMessage());
			e.printStackTrace();
		}
}

}
