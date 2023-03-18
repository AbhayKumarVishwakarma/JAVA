package com.day7;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo {
     public static void main(String[] args) throws Exception {
		File file = new File("C.txt");
		Writer writer = new FileWriter(file);
		writer.write(68);
		String msg = "ear Student, You will get placed soon!";
	    writer.write(msg);
		writer.write("\n");  // going to next line
		char[] ch = {'J','a','v','a'};
		writer.write(ch);
		writer.close();
		
		System.out.println("Message write in C.txt file");
		System.out.println("go and check C.txt file");
	}
}
