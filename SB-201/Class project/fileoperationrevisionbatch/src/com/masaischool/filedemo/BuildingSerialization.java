package com.masaischool.filedemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BuildingSerialization {
	public static void main(String[] args) {
		House house = new House(2.0f, 1, 23);
		System.out.println("Going to perform Serialization");
		//Create an object of 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("building.ser"));){
			oos.writeObject(house);
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Serialization completed");
		
		System.out.println("Going to perform De-serialization");
		House house2 = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("building.ser"));){
			house2 = (House)ois.readObject();
			System.out.println(house2);
		}catch(IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Deserialization completed");
		
	}
}
