package com.masaischool.filedemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ZooSerializationDemo {
	public static void main(String[] args) {
		//Create an object of class Dog
		Dog dog = new Dog(2.7f, 32.0f);
		
		//Create an object of class Cat
		Cat cat = new Cat("Meow", "Anywhere");
		
		Zoo zoo = new Zoo("National", cat, dog);
		System.out.println(zoo);
		
		System.out.println("Going to perform Serialization");
		//Create an object of 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("zoo.ser"));){
			oos.writeObject(zoo);
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Serialization completed");
		
		System.out.println("Going to perform De-serialization");
		Zoo zoo2 = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("zoo.ser"));){
			zoo2 = (Zoo)ois.readObject();
			System.out.println(zoo2);
		}catch(IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Deserialization completed");
		
	}
}
