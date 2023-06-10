package com.masaischool.filedemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {
	public static void main(String[] args) {
		//Create an object of human class
		Human human = new Human("Nayan", 28, 65.25);
		System.out.println("Going to perform Serialization");
		//Create an object of 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("human.ser"));){
			oos.writeObject(human);
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Serialization completed");
		
		System.out.println("Going to perform De-serialization");
		Human human2 = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("human.ser"));){
			human2 = (Human)ois.readObject();
			System.out.println(human2);
		}catch(IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Deserialization completed");
	}
}
