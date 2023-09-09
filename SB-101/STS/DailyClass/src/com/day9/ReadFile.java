package com.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
     public static void main(String[] args) throws IOException {
		Path p = Paths.get("PathFileFolderDay9//B.txt");

        List<String> list = Files.readAllLines(p);
        
        Integer total = 0;
        
        
//        forEach(t -> {
//              String[] arr = t.split(" ");
//              total += Integer.parseInt(arr[2]);
//        });
	}
}
