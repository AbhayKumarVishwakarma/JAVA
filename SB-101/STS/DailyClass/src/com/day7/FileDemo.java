package com.day7;

import java.io.File;
import java.io.IOException;

public class FileDemo {
     public static void main(String[] args) throws IOException, InterruptedException{
		File fileOne = new File("A.txt");
		System.out.println("Is A.txt file is present : " + fileOne.exists());
		System.out.println("name of the file is : " + fileOne.getName());
		System.out.println("path of the file is : " + fileOne.getPath());
		System.out.println("absolute pate of the file is " + fileOne.getAbsolutePath());
		System.out.println("A.txt is file? : " + fileOne.isFile());
		System.out.println("A.txt is dirctory? : " + fileOne.isDirectory());
		System.out.println("Total character/Length of file A.txt is : " + fileOne.length());
		System.out.println();
		
		File fileTwo = new File("B.txt");
		System.out.println("Is B.txt file is present : " + fileTwo.exists());
		if(!fileTwo.exists()) {
			System.out.println("No file with name : B.txt");
			System.out.println("Creating B.txt file");
			fileTwo.createNewFile();
			System.out.println("Is B.txt file is present : " + fileTwo.exists());
		}
		System.out.println("Total character/Length of file B.txt is : " + fileTwo.length());
		System.out.println("name of the file is : " + fileTwo.getName());
		System.out.println("path of the file is : " + fileTwo.getPath());
		System.out.println("absolute pate of the file is " + fileTwo.getAbsolutePath());
		System.out.println("Deleting file B.txt");
		Thread.sleep(10000);
		fileTwo.delete();
		System.out.println("Is file B.txt present after detetion : " + fileTwo.exists()); 
	}
}
