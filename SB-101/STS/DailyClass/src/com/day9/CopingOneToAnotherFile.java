package com.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopingOneToAnotherFile {
     public static void main(String[] args) throws IOException {
    	Path p = Paths.get("PathFileFolderDay9//A.txt");
 		Path q = Paths.get("PathFileFolderDay9//c.txt");
 		
 		Files.copy(p,q);
 		System.out.println("Done");
	}
}
