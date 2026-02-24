package com.tss.assignment7;

import java.util.ArrayList;
import java.util.List;


public class Member {
    private static int id=1;
    private int memberId;
    private String memberName;
    private String memberEmail;
    private List<Book> borrowedBooks;

    public Member(String memberName, String memberEmail) {
        this.memberId = id;
        id+=2;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.borrowedBooks=new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public String toString() {
        return String.format(
                "| %-3d | %-14.14s | %-22.22s | %-14d |",
                memberId,
                memberName,
                memberEmail,
                borrowedBooks == null ? 0 : borrowedBooks.size()
        );
    }



}
