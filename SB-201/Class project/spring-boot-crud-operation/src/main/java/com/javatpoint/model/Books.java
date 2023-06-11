package com.javatpoint.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Books
{
//Defining book id as primary key
@Id
@Column
private int bookid;
@Column
private String bookname;
@Column
private String author;
@Column
private int price;
public int getBookid() 
{
return bookid;
}
public void setBookid(int bookid) 
{
this.bookid = bookid;
}
public String getBookname()
{
return bookname;
}
public void setBookname(String bookname) 
{
this.bookname = bookname;
}
public String getAuthor() 
{
return author;
}
public void setAuthor(String author) 
{
this.author = author;
}
public int getPrice() 
{
return price;
}
public void setPrice(int price) 
{
this.price = price;
}
}