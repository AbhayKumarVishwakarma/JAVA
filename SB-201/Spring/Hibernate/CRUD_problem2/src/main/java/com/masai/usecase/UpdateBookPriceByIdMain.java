package com.masai.usecase;

import com.masai.dao.BookDao;
import com.masai.dao.BookDaoImpl;
import com.masai.exception.BookException;
import com.masai.modul.Book;

import java.util.Scanner;

public class UpdateBookPriceByIdMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book id ");
        int id = sc.nextInt();

        System.out.print("Enter new price ");
        int price = sc.nextInt();

        BookDao bookDao = new BookDaoImpl();
        try {
            String msg = bookDao.updateBookPriceById(id, price);
            System.out.println("\n" + msg + "\n");
        }catch (BookException e){
            System.out.println(e.getMessage());
        }
    }
}
