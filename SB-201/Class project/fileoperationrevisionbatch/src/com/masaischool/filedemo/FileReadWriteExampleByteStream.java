package com.masaischool.filedemo;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class FileReadWriteExampleByteStream {
	public static void main(String[] args) {
		System.out.println("Opening the file for writing");
		try(Writer writer = new FileWriter("B.txt"); PrintWriter pw = new PrintWriter(writer)) {
			pw.println("Surya");	//writing the String value
			pw.println(18);	//writing the integer value
			pw.println(74.25);	//writing the double value
			pw.println(true);	//writing the boolean value
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("File writing completed");
		
		try(InputStream is = new FileInputStream("B.txt"); Scanner sc = new Scanner(is)) {
			String name = sc.nextLine();	//read the string value
			int age = sc.nextInt();	//read the int value
			double percentage = sc.nextDouble();	//read the double value
			boolean eligible = sc.nextBoolean();	//read the boolean value
			System.out.println("Name = " + name);
			System.out.println("Age = " + age);
			System.out.println("Percentage =" + percentage);
			System.out.println("Eligible for scholarship = " + eligible);
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}