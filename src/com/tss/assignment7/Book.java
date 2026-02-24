package com.tss.assignment7;

public class Book {
    private static int id=1001;
    private int bookId;
    private String bookTitle;
    private String authorName;
    private Category bookCategory;

    public Book(String bookTitle, String authorName, Category bookCategory) {
        this.bookId = id;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.bookCategory = bookCategory;
        id+=1011;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-6s | %-20s | %-20s | %-15s |",
                bookId,
                bookTitle,
                authorName,
                bookCategory
        );
    }

}
