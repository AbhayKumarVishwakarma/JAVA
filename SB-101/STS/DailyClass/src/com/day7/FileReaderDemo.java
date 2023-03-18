package com.day7;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo {
    public static void main(String[] args) throws Exception {
    	File file = new File("A.txt");
    	Reader reader = new FileReader(new File("A.txt"));
    	
    	// first type 
/*	    while(true) {
	    	int currentChar = reader.read();
	    	if(currentChar == -1) break;
	    	System.out.print((char) currentChar);
	    }
	    System.out.println("\nBye Bye file reader");
	    reader.close();   */
	    
	    // second type
        char[] ch = new char[(int) file.length()];
        reader.read(ch);
        System.out.println(new String(ch));
		System.out.println("Bye Bye Again file reader");
		reader.close();   
	}
}
