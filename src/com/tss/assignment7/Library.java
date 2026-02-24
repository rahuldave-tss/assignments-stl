package com.tss.assignment7;

import java.util.*;

import static com.tss.assignment7.EmailValidator.isValidEmail;
import static com.tss.utils.GlobalConstants.*;
import static com.tss.utils.Validate.*;

public class Library {
    LinkedHashSet<Book> totalBooks=new LinkedHashSet<>();
    List<Member> totalMembers=new ArrayList<>();
    Set<String> emailChecker=new HashSet<>();
    Set<Category> categoryChecker=new HashSet<>();
    Map<Book,Member> borrowedBooks=new HashMap<>();

    public void addBook(){
        Category category=validateCategory();

        System.out.print("Enter the Book Title: ");
        String bookTitle=validateString();
        System.out.print("Enter Book Author Name: ");
        String authorName=validateString();

        Book b=new Book(bookTitle,authorName,category);

        totalBooks.add(b);

        System.out.println("Book Added !!");

    }

    public void addMember(){
        System.out.print("Enter Member Name: ");
        String memberName=validateString();
        String memberEmail;
        while(true){
            System.out.print("Enter Member Email: ");
            memberEmail= scanner.nextLine();
            if(!isValidEmail(memberEmail)){
                System.out.println("Please Enter Valid Email !!");
            }
            else{
                if(!emailChecker.contains(memberEmail)){
                    emailChecker.add(memberEmail);
                    break;
                }
                System.out.println("Email already exists !!");
            }
        }
        Member m=new Member(memberName,memberEmail);
        totalMembers.add(m);

        System.out.println("Member Added !!");
    }

    public void borrowBook(){
        if(totalBooks.isEmpty()){
            System.out.println("No Books Found !!");
            return;
        }
        if(totalMembers.isEmpty()){
            System.out.println("No Members Found !!");
            return;
        }

        int booksTotal=totalBooks.size();
        int booksBorrowed =borrowedBooks.size();
        if(booksTotal== booksBorrowed){
            System.out.println("All Books Are Borrowed For Now !!");
            return;
        }

        viewAllBooks();
        Book b;
        while(true){
            b=getBookById();
            try{
                if(borrowedBooks.containsKey(b)){
                    throw new RuntimeException("Book is Already Borrowed !!");
                }
                else break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Enter Book Details again !!");
        }
        viewAllMembers();
        Member m=getMemberById();
        List<Book> books=m.getBorrowedBooks();
        books.add(b);
        borrowedBooks.put(b,m);

        System.out.println("Book borrowed !!");

    }

    public void viewAllBooks(){
        if(totalBooks.isEmpty()){
            System.out.println("No Books Found !!");
            return;
        }
        System.out.println("All Books in Library: ");
        bookHeader();
        for(Book b:totalBooks){
            System.out.println(b);
        }
    }

    public void viewAllMembers(){
        if(totalMembers.isEmpty()){
            System.out.println("No Members Found !!");
            return;
        }
        System.out.println("All Members of Library: ");
        memberHeader();
        for(Member m:totalMembers){
            System.out.println(m);
        }
    }

    private void memberHeader() {
        System.out.println("| ID  | Name           | Email                  | Books Borrowed |");
        System.out.println("----------------------------------------------------------------");
    }

    public void viewBooksBorrowedByMember(){
        viewAllMembers();
        Member m=getMemberById();
        System.out.println("Books borrowed by Member "+m.getMemberId());
        List<Book> l=m.getBorrowedBooks();
        if(l.isEmpty()){
            System.out.println("This member has not borrowed any books !!");
            return;
        }
        bookHeader();
        for(Book b:l){
            System.out.println(b);
        }
    }

    private void bookHeader() {
        System.out.println("| ID     | Title                | Author               | Category        |");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void viewMemberWhoBorrowedParticularBook(){
        viewAllBooks();
        Book b=getBookById();
        Member m=borrowedBooks.get(b);
        try{
            if(m==null){
                throw new RuntimeException("Book not borrowed yet !!");
            }
            System.out.println("Details of Member who borrowed Book "+b.getBookId());
            memberHeader();
            System.out.println(m);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    private Book getBookById() {
        while(true){
            System.out.print("Enter Book ID: ");
            int id=validateInt();
            try{
                for(Book b:totalBooks){
                    if(id==b.getBookId()) {
                        return b;
                    }
                }
                throw new RuntimeException("Book not found of ID: "+id);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private Member getMemberById() {
        while(true){
            System.out.print("Enter Member ID: ");
            int id=validateInt();
            try{
                for(Member m:totalMembers){
                    if(id==m.getMemberId()) {
                        return m;
                    }
                }
                throw new RuntimeException("Member not found of ID: "+id);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Category validateCategory() {
        System.out.println("Category Options Available: ");
        Category[] categories=Category.values();
        System.out.println(Arrays.toString(categories));
        String userInput;
        Category c;
        while(true){
            try{
                System.out.print("Enter the Category of Book: ");
                userInput= validateString();
                c=getCategory(userInput);

                if(c==null){
                    throw new RuntimeException("Category Not Found !!");
                }
                if(categoryChecker.contains(c)){
                   throw new RuntimeException("Category is already present in library, Enter another one !!");
                }
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        categoryChecker.add(c);
        return c;
    }

    private Category getCategory(String userInput) {
        for(Category c:Category.values()){
            if(c.name().equalsIgnoreCase(userInput)){
                return c;
            }
        }
        return null;
    }

    public void returnBook() {
        if(borrowedBooks.isEmpty()){
            System.out.println("No Books Borrowed !!");
            return;
        }
        viewAllBooks();
        Book b=getBookById();
        if(!borrowedBooks.containsKey(b)){
            System.out.println("Member for this book is not found !!");
            return;
        }
        Member m=borrowedBooks.get(b);
        borrowedBooks.remove(b);
        if(m==null){
            throw new RuntimeException("Member for this book is not found !!");
        }
        List<Book> list=m.getBorrowedBooks();
        list.remove(b);

        System.out.println("Book Returned !!");
    }
}
