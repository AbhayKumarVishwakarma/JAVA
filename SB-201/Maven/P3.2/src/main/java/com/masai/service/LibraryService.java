package com.masai.service;

import com.masai.model.Book;
import com.masai.model.Librarian;
import com.masai.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LibraryService {
    // Hint: Use setter injection to inject bookMap, librarianList, and memberList

    @Autowired
    private Map<Librarian, List<Book>> bookMap; // inject 3 entries with valid details
    @Autowired
    private List<Librarian> librarianList; // inject a list of 5 Librarian objects
    @Autowired
    private List<Member> memberList; // inject a list of 7 Member objects

    public void printBookMap() {
        // print all the librarians and their associated book details from the bookMap
        for(Map.Entry<Librarian,List<Book>> entry : bookMap.entrySet()){
            System.out.println(entry.getKey());
            entry.getValue().forEach(book -> System.out.println(book));
            System.out.println();
        }
    }

    public void printLibrarianList() {
        // sort the list of librarians according to the decreasing order of the noOfBooksIssued
        // if noOfBooksIssued are the same, then sort by age
        // print all the sorted Librarian details
        librarianList.sort((o1, o2) -> {
            if(o1.getNoOfBooksIssued() == o2.getNoOfBooksIssued()) return o1.getAge() - o2.getAge();
            else return o2.getNoOfBooksIssued() - o1.getNoOfBooksIssued();
        });
        librarianList.forEach(librarian -> System.out.println(librarian));
    }

    public void printMemberList() {
        // sort the list of members according to the decreasing order of the noOfBooksBorrowed
        // if noOfBooksBorrowed are the same, then sort by age
        // print all the sorted Member details
        memberList.sort((o1, o2) -> {
            if(o1.getNoOfBooksIssued() == o2.getNoOfBooksIssued()) return o1.getAge() - o2.getAge();
            else return o2.getNoOfBooksIssued() - o1.getNoOfBooksIssued();
        });
        memberList.forEach(member -> System.out.println(member));
    }

    public void issueBook(int librarianId, int memberId, int bookId) {
        // Find the Librarian, Member, and Book objects by their respective IDs
        // Check if the book is available and the member can borrow books (based on a borrowing limit)
        // Update the book's availability, the librarian's noOfBooksIssued, and the member's noOfBooksBorrowed
        // Add the issued book to the bookMap

        Librarian librarian = null;
        Book book = null;
        Member member = null;
        List<Book> bookList = null;
        for (Librarian l : librarianList){
            if(l.getId() == librarianId){
                librarian = l;
                break;
            }
        }

        for(Map.Entry<Librarian,List<Book>> entry : bookMap.entrySet()){
            if(entry.getKey().getId() == librarianId){
                bookList = entry.getValue();
                for(Book b : bookList){
                    if(b.getId() == bookId){
                        book = b;
                        break;
                    }
                }
                break;
            }
        }

        for(Member m : memberList){
            if(m.getId() == memberId){
                member = m;
                break;
            }
        }

        if(librarian == null || book == null || member == null){
            System.out.println(librarian + " " + book + " " + member);
            throw new RuntimeException("not find all ...");
        }

        if(book.isAvailable()){
            if(member.getNoOfBooksIssued() <= 3){
                book.setAvailable(false);
                bookList.add(book);
                bookMap.put(librarian,bookList);
                librarian.setNoOfBooksIssued(librarian.getNoOfBooksIssued()+1);
                member.setNoOfBooksIssued(member.getNoOfBooksIssued()+1);
                System.out.println(book.getTitle() + " is issued to " + member.getName() + " by " + librarian.getName());
            }
            else throw new RuntimeException("Member is already borrowed more than 3 books");
        }
        else throw new RuntimeException("Book is already borrowed by some other person");
    }

    public void returnBook(int librarianId, int memberId, int bookId) {
        // Find the Librarian, Member, and Book objects by their respective IDs
        // Check if the book is currently borrowed by the member
        // Update the book's availability, the librarian's noOfBooksIssued, and the member's noOfBooksBorrowed
        // Remove the returned book from the bookMap

        Librarian librarian = null;
        Book book = null;
        Member member = null;
        List<Book> bookList = null;
        for (Librarian l : librarianList){
            if(l.getId() == librarianId){
                librarian = l;
                break;
            }
        }

        for(Map.Entry<Librarian,List<Book>> entry : bookMap.entrySet()){
            if(entry.getKey().getId() == librarianId){
                bookList = entry.getValue();
                for(Book b : bookList){
                    if(b.getId() == bookId){
                        book = b;
                        break;
                    }
                }
                break;
            }
        }

        for(Member m : memberList){
            if(m.getId() == memberId){
                member = m;
                break;
            }
        }

        if(librarian == null || book == null || member == null){
            System.out.println(librarian + " " + book + " " + member);
            throw new RuntimeException("not find all ...");
        }

        if(!book.isAvailable()){
            if(bookList.contains(book)){
                book.setAvailable(true);
                member.setNoOfBooksIssued(member.getNoOfBooksIssued()-1);
                librarian.setNoOfBooksIssued(librarian.getNoOfBooksIssued()-1);
                bookList.remove(book);
                bookMap.put(librarian,bookList);
                System.out.println(book.getTitle() + " is return to " + member.getName() + " by " + librarian.getName());
            }
            else throw new RuntimeException("Member did not borrowed book");
        }
        else throw new RuntimeException("Book is not borrowed by some other person");
    }
}
