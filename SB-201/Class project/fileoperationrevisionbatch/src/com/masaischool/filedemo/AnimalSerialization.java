package com.masaischool.filedemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AnimalSerialization {
	public static void main(String[] args) {
		Lion lion = new Lion("Forest", 270.0f, 4.0f);
		Monkey monkey = new Monkey("Tree", 14.0f, 8.0f);
		
		List<? super Animal> list = new ArrayList<>();
		list.add(monkey);
		list.add(lion);
		
		System.out.println("Going to perform Serialization");
		//Create an object of 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.ser"));){
			oos.writeObject(list);
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Serialization completed");
		
		System.out.println("Going to perform De-serialization");
		List<? super Animal> list2 = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animal.ser"));){
			list2 = (List<? super Animal>)ois.readObject();
			System.out.println(list2);
		}catch(IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Deserialization completed");
		
	}
}
