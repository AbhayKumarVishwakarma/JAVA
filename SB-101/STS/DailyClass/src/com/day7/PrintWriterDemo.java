package com.day7;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {
     public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("E.txt");
		pw.write(100);
		pw.println();
		pw.println(100);
		pw.println(true);
		pw.println('c');
		pw.println("Ankit");
		
		pw.flush();
		pw.close();
		System.out.println("Done");
	}
}
