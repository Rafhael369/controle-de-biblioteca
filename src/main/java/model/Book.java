package model;

import java.sql.Date;

public class Book {
    private int id;
    private String name;
    private Date date;
    private Author author;
    private BookStatus bookStatus;

    public Book(int id, String name, Date date, Author author, BookStatus bookStatus) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.bookStatus = bookStatus;
    }
    
    public Book() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}