package com.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadOneAndWriteInAnotherFile {
      public static void main(String[] args) throws IOException {
		Path p = Paths.get("PathFileFolderDay9//A.txt");
		Path q = Paths.get("PathFileFolderDay9//B.txt");
		if(!Files.exists(p)) Files.createFile(q);
		
		// reading from A.txt file
		List<String> list = Files.readAllLines(p);
		
		// writing in B.txt file
		Files.write(q, list);
		
		System.out.println("Done");
	}
}
