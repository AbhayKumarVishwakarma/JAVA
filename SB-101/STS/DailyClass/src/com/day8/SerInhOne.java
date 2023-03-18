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

class C implements Serializable{
	int i;
	
	public C(int i){
		this.i = i;
	}
}

class D extends C{
	int j;
	
	public D(int i, int j) {
		super(i);
		this.j = j;
	}
	
	@Override
	public String toString() {
		return "D [i = "+ i +", j = " + j + "]";
	}
}

public class SerInhOne {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		D d = new D(10,20);
		
		ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("SerInhOne.ser"));
		oo.writeObject(d);
		oo.close();
		System.out.println("Serialization completed");
		
		ObjectInput oi = new ObjectInputStream(new FileInputStream("SerInhOne.ser"));
		D d2 = (D) oi.readObject();
		System.out.println("Deserialization completed");
		System.out.println(d2);
		oi.close();
	}
}
