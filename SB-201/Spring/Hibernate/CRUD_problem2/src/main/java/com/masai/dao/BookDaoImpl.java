package com.masai.dao;

import com.masai.exception.BookException;
import com.masai.modul.Book;
import com.masai.utils.EMUtils;

import javax.persistence.EntityManager;

public class BookDaoImpl implements BookDao{
    @Override
    public Book getBookById(int id) throws BookException {
        EntityManager em = EMUtils.getEntityManager();

        Book book = em.find(Book.class, id);
        if(book != null)
            return book;
        em.close();

        return null;
    }

    @Override
    public String createBook(Book book){
        String msg = "Unable to crate book";
        EntityManager em = EMUtils.getEntityManager();

        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        msg = "Book created";
        em.close();

        return msg;
    }

    @Override
    public String deleteBook(int id) throws BookException {
        String msg = "Unable to delete book";
        EntityManager em = EMUtils.getEntityManager();

        Book book = em.find(Book.class, id);
        if(book != null){
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
            msg = "Book deleted!";
        }
        else
            throw new BookException("Something went wrong! Unable to delete book...");
        em.close();

        return msg;
    }

    @Override
    public String updateBookPriceById(int id, int price) throws BookException {
        String msg = "Unable to update book";
        EntityManager em = EMUtils.getEntityManager();

        Book book = em.find(Book.class, id);
        if(book != null){
            em.getTransaction().begin();
            book.setPrice(price);
            em.getTransaction().commit();
            msg = "Book updated";
        }
        else
            throw new BookException("Something went wrong! Unable to update book...");

        return msg;
    }
}
