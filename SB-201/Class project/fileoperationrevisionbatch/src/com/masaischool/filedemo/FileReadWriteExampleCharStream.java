package com.masaischool.filedemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReadWriteExampleCharStream {
	public static void main(String[] args) {	
		//check if file exists or not
		File file = new File("A.txt");
		if(file.exists()) {
			System.out.println("A.txt will be written from starting, previous content will be erased");
		}else {
			System.out.println("A.txt will be created as a new file");
		}
		
		//open a file A.txt for writing
		//size of buffer is 1024; the default size of the buffer is 512 bytes for writing operation
		try(Writer writer = new FileWriter("A.txt"); BufferedWriter bufWriter = new BufferedWriter(writer, 1024)){
			String str[] = {"Twinkle Twinkle Little Star", "How i wonder what you are", "up above the world so high"};
			for(String  s: str) {
				bufWriter.write(s);
				bufWriter.newLine();
			}
			bufWriter.flush();
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Part of poem is written");
		System.out.println("Adding one more line in the poem");
		try(Writer writer = new FileWriter("A.txt", true); BufferedWriter bufWriter = new BufferedWriter(writer, 1024)){
			String s = "Like a a diamond in the sky";
			bufWriter.write(s);
			bufWriter.flush();
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Poem is written completely");
		System.out.println("\n");
		//Let us perform the read operation
		try(Reader reader = new FileReader("A.txt"); BufferedReader buffRead = new BufferedReader(reader) ){
			String str = buffRead.readLine();
			
			while(str != null) {
				System.out.println(str);
				str = buffRead.readLine();
			}
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}