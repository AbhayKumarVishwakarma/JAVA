package com.day7;

import java.io.File;

public class dirDemo {
     public static void main(String[] args) throws InterruptedException {
    	File myDir = new File("mydir");
 		System.out.println("is mydir file? " + myDir.isFile());
 		System.out.println("is mydir folder? " + myDir.isDirectory());
 		
 		String[] filenames = myDir.list();
 		System.out.println("Total files in the mydir is " + filenames.length);
		System.out.println("File names are as follow - ");
		for(String file : filenames)
			System.out.println(file);
		System.out.println();
		
		System.out.println("New file creating");
		File myNewDir = new File("mynewdir");
		myNewDir.mkdir();
		System.out.println("Is mynewdir exists? " + myNewDir.exists());
		System.out.println("Deleting mynewdir");
		Thread.sleep(10000);
		myNewDir.delete();
		System.out.println("Is mynewdir exists? " + myNewDir.exists());  
	}
}
