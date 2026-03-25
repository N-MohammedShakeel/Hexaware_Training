package Hexaware.Library_Management_System;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean issuedStatus;

    public Book(){}

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issuedStatus = false;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(boolean issuedStatus) {
        this.issuedStatus = issuedStatus;
    }
}
