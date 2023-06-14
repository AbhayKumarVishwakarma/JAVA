package com.masai.usecase;

/*
	Book Id : 101,
		name: "C++",
    author: "Nitesh",
    publication: "Rajput Publication",
    category: "Computer Programming",
    pages: 1500,
    price: 240,
    created_timestamp : 2019-12-11 10:58:37
 */

import com.masai.dao.BookDao;
import com.masai.dao.BookDaoImpl;
import com.masai.modul.Book;

import java.sql.Date;
import java.util.Scanner;

public class CreateBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book id ");
        int id = sc.nextInt();
        System.out.print("Enter name ");
        String name = sc.next();
        System.out.print("Enter author ");
        String author = sc.next();
        System.out.print("Enter publication ");
        String publication = sc.next();
        System.out.print("Enter category ");
        String category = sc.next();
        System.out.print("Enter pages ");
        int pages = sc.nextInt();
        System.out.print("Enter price ");
        int price = sc.nextInt();
        System.out.print("Enter created timestamp ");
        Date date = Date.valueOf(sc.next());

        Book book = new Book(id, name, author, publication, category, pages, price, date);
        BookDao bookDao = new BookDaoImpl();

        String msg = bookDao.createBook(book);
        System.out.println("\n" + msg + "\n");
    }
}
