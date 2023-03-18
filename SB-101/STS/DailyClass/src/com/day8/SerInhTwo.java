package com.day8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class P{
	int i;
	
	public P() {
		i = -1;
	}
	
	public P(int i) {
		this.i = i;
	}
}

class Q extends P implements Serializable{
	int j;

	public Q(int i, int j) {
		super(i);
		this.j = j;
	}

	@Override
	public String toString() {
		return "Q [i = "+ i +", j = " + j + "]";
	}
}

public class SerInhTwo {
    public static void main(String[] args) throws Exception {
		Q q = new Q(10, 20);
		
		ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("SerInhTwo.ser"));
		oo.writeObject(q);
		oo.close();
		System.out.println("Serialization completed");
		
		ObjectInput oi = new ObjectInputStream(new FileInputStream("SerInhTwo.ser"));
		Q q2 = (Q) oi.readObject();
		System.out.println("Deserialization completed");
		System.out.println(q2);
		oi.close();
	}
}
