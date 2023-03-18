package com.day8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo {
     public static void main(String[] args) throws Exception {
    	 
    	 // Serialization
		FileOutputStream fos = new FileOutputStream("E.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Human(24, "John", 'm'));
		oos.writeObject("Ankit");
		oos.writeObject(10);
		oos.close();
		
		// Deserialization
		FileInputStream fis = new FileInputStream("E.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		
		Human h = (Human) obj;
		System.out.println(h);
		
		String s = (String) ois.readObject();
		System.out.println(s);
		
		int i = (Integer) ois.readObject();
		System.out.println(i);
		
		ois.close();
	}
}
