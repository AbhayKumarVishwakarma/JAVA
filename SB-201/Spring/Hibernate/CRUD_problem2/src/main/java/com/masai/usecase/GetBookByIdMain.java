package com.masai.usecase;

import com.masai.dao.BookDao;
import com.masai.dao.BookDaoImpl;
import com.masai.exception.BookException;
import com.masai.modul.Book;

import java.util.Scanner;

public class GetBookByIdMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book id ");
        int id = sc.nextInt();

        BookDao bookDao = new BookDaoImpl();
        try {
            Book book = bookDao.getBookById(id);
            System.out.println("\n" + book + "\n");
        }catch (BookException e){
            System.out.println(e.getMessage());
        }
    }
}
