package com.masai.usecase;

import com.masai.dao.BookDao;
import com.masai.dao.BookDaoImpl;
import com.masai.exception.BookException;
import com.masai.modul.Book;

import java.util.Scanner;

public class DeleteBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book id ");
        int id = sc.nextInt();

        BookDao bookDao = new BookDaoImpl();
        try {
            String msg = bookDao.deleteBook(id);
            System.out.println("\n" + msg + "\n");
        }catch (BookException e){
            System.out.println(e.getMessage());
        }
    }
}
