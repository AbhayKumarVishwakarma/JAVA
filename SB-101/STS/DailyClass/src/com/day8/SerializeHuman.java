package com.day8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializeHuman {
    public static void main(String[] args) throws IOException {
    	Human human = new Human(24, "John", 'm');
    	ObjectOutput objStream = new ObjectOutputStream(new FileOutputStream("Human.ser"));
    	objStream.writeObject(human);
    	objStream.close();
    	System.out.println("Object Serialized");
	}
}
