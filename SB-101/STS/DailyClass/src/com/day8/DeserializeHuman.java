package com.day8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class DeserializeHuman {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInput objStream = new ObjectInputStream(new FileInputStream("Human.ser"));
		Human human = (Human) objStream.readObject();
		objStream.close();
		System.out.println(human);
	}
}
