package com.tss.assignment6;

import com.tss.exceptions.NoSuchMovieFoundException;

import static com.tss.assignment6.Main.getMovieById;
import static com.tss.utils.GlobalConstants.scanner;
import static com.tss.utils.Validate.validateInt;

public class MovieController {
    private MovieManager movieManager;
    public MovieController() {
        movieManager=new MovieManager();
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public static void start(){
        displayMenu();
    }

    private static void displayMenu(){
        System.out.println();
        System.out.println("Welcome to Movie Manager !!");
        System.out.println("1. Add Movie to List");
        System.out.println("2. Display Movies From List");
        System.out.println("3. Save movies to File");
        System.out.println("4. Delete All movies from File");
        System.out.println("5. Clear movies from List");
        System.out.println("6. Update Movie Details");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public void setMovieDetails() throws NoSuchMovieFoundException {
        System.out.print("Enter Movie ID to update the details: ");
        int movieId=scanner.nextInt();
        Movie m=getMovieById(movieId);
        if(m==null){
            throw new NoSuchMovieFoundException();
        }
        scanner.nextLine();
        System.out.print("Enter New Movie Name: ");
        String movieName= scanner.nextLine();
        System.out.print("Enter New Movie Release Year: ");
        int movieYear=validateInt();
        scanner.nextLine();
        System.out.print("Enter New Movie Genre: ");
        String genre= scanner.nextLine();

        m.setGenre(genre);
        m.setName(movieName);
        m.setYear(movieYear);
        System.out.println("Movie Details Updated !!");
    }

}
