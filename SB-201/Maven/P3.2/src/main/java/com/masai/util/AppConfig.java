package com.masai.util;

import com.masai.model.Book;
import com.masai.model.Librarian;
import com.masai.model.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.masai")
public class AppConfig {
    @Bean
    public Map<Librarian, List<Book>> bookMap(){
        Librarian l1 = new Librarian(1, "Ankit", 20, 2, "ankit@gmail.com", "4252352355");
        Librarian l2 = new Librarian(2, "Suraj", 22, 3, "suraj@gmail.com", "895652355");
        Librarian l3 = new Librarian(3, "Raj", 18, 1, "raj@gmail.com", "234352355");

        Book book1 = new Book(1,"xyz", "zyx", 2022, true);
        Book book2 = new Book(2,"yzx", "xzy", 2012, true);
        Book book3 = new Book(3,"rew", "wer", 2021, true);
        Book book4 = new Book(4,"abc", "cba", 2021, true);
        Book book5 = new Book(5,"qwe", "ewq", 2009, true);

        List<Book> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);
        bookList1.add(book3);
        bookList1.add(book4);
        bookList1.add(book5);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book2);
        bookList2.add(book3);
        bookList2.add(book4);

        List<Book> bookList3 = new ArrayList<>();
        bookList3.add(book1);
        bookList3.add(book2);
        bookList3.add(book5);

        Map<Librarian,List<Book>> librarianListMap = new HashMap<>();
        librarianListMap.put(l1,bookList1);
        librarianListMap.put(l3,bookList2);
        librarianListMap.put(l2,bookList3);

        return librarianListMap;
    }

    @Bean
    public List<Librarian> librarianList(){
        Librarian l1 = new Librarian(1, "Ankit", 20, 2, "ankit@gmail.com", "4252352355");
        Librarian l2 = new Librarian(2, "Suraj", 22, 3, "suraj@gmail.com", "895652355");
        Librarian l3 = new Librarian(3, "Raj", 18, 1, "raj@gmail.com", "234352355");
        Librarian l4 = new Librarian(4, "Aadi", 22, 2, "aadi@gmail.com", "895652355");
        Librarian l5 = new Librarian(5, "Sumi", 18, 2, "sumi@gmail.com", "234352355");

        return Arrays.asList(l1,l2,l3,l4,l5);
    }

    @Bean
    public List<Member> memberList(){
        Member member1 = new Member(1,"suresh",19,3,"suresh@gmail.com", "42523452345");
        Member member2 = new Member(2,"mukesh",19,3,"mukesh@gmail.com", "96587345235");
        Member member3 = new Member(3,"mahesh",19,3,"mahesh@gmail.com", "34723452345");
        Member member4 = new Member(4,"lalith",19,3,"lal@gmail.com", "6543452345");

        return Arrays.asList(member1,member2,member3,member4);
    }
}
