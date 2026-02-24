package com.tss.assignment7;

import static com.tss.utils.Validate.*;

public class LibraryApp {
    static Library library=new Library();
    public static void main(String[] args) {
        while(true){
            displayMenu();
            int choice=validateInt();
            switch (choice){
                case 1:{
                    library.addBook();
                    break;
                }
                case 2:{
                    library.addMember();
                    break;
                }
                case 3:{
                    library.borrowBook();
                    break;
                }
                case 4:{
                    library.returnBook();
                    break;
                }
                case 5:{
                    library.viewAllBooks();
                    break;
                }
                case 6:{
                    library.viewAllMembers();
                    break;
                }
                case 7:{
                    library.viewBooksBorrowedByMember();
                    break;
                }
                case 8:{
                    library.viewMemberWhoBorrowedParticularBook();
                    break;
                }
                case 9:{
                    System.out.println("Exiting Application.....");
                    return;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }
    }
    private static void displayMenu(){
        System.out.println();
        System.out.println("=====Library Management System=====");
        System.out.println();
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display All Books");
        System.out.println("6. Display All Members");
        System.out.println("7. View Borrowed Books of Particular Member");
        System.out.println("8. View Member who borrowed Particular Book");
        System.out.println("9. Exit");
        System.out.print("Enter your choice :");
    }
}
