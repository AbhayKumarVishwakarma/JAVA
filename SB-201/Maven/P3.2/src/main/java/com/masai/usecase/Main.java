package com.masai.usecase;

import com.masai.service.LibraryService;
import com.masai.util.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        LibraryService libraryService = ctx.getBean(LibraryService.class);
        libraryService.printBookMap();
        System.out.println();
        libraryService.printLibrarianList();
        System.out.println();
        libraryService.printMemberList();
        System.out.println();
        libraryService.issueBook(1,1,3);
        System.out.println();
        libraryService.returnBook(1,1,3);
        System.out.println();
        ((AnnotationConfigApplicationContext) ctx).close();
    }
}