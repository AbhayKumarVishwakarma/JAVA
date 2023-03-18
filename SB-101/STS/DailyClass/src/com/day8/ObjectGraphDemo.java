package com.day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Rat implements Serializable{
	int i = 10;
}

class Cat implements Serializable{
	Rat r = new Rat();
}

class Dog implements Serializable{
	Cat c = new Cat();
}

public class ObjectGraphDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Dog d = new Dog();
		
		ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("object_graph.ser"));
		oo.writeObject(d);
		oo.close();
		System.out.println("Serialization completed");
		
		ObjectInput oi = new ObjectInputStream(new FileInputStream("object_graph.ser"));
		Dog d2 = (Dog)oi.readObject();
		System.out.println("Deserialization completed");
		System.out.println(d2.c.r.i);
		oi.close();
	}
}
