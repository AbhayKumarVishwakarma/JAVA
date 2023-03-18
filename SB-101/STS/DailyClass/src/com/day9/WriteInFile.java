package com.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WriteInFile {
     public static void main(String[] args) throws IOException {
		Path p = Paths.get("PathFileFolderDay9//A.txt");
		
//		// Writing normal string
//		String msg = "Welcome to java world";
//		Files.write(p,msg.getBytes());
//		
//		// Writing a list of string
//		List<String> list = Arrays.asList("California, Washington DC, Los Angeles, San francisco");
//		Files.write(p, list);
		
		// Replacing the word
		Stream<String> str = Files.lines(p);
		str.map(line -> {
			if(line.contains("Washington")) 
			   return line.replace("Washington", "Washington DC");
			else
			   return line;
		}).forEach(line -> System.out.println(line));
	}
}
