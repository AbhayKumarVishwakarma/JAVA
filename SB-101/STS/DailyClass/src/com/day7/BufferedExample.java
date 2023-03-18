package com.day7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class BufferedExample {
     public static void main(String[] args) throws Exception {
    	File file = new File("D.txt");
    	
 		Reader reader = new FileReader(file);
 		BufferedReader buffReader = new BufferedReader(reader);
 		
 		Writer writer = new FileWriter("E.txt");
 		BufferedWriter buffWriter = new BufferedWriter(writer);
 		
 		String str = buffReader.readLine();
 		buffWriter.write(str);
 		buffWriter.newLine();
 		while(true) {
 			int ch = buffReader.read();
 			if(ch == -1) break;
 			System.out.println("Writing msg in E.txt from D.txt");
 			buffWriter.write(ch);
 		}
 		buffWriter.flush();
 		buffWriter.close();
 		buffReader.close();
	}
}
