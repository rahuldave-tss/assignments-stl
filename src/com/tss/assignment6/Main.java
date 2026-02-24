package com.tss.assignment6;

import com.tss.exceptions.CapacityFullException;
import com.tss.exceptions.NoSuchMovieFoundException;

import java.io.IOException;
import java.util.List;

import static com.tss.assignment6.MovieController.start;
import static com.tss.assignment6.MovieManager.numberOfMovies;
import static com.tss.utils.GlobalConstants.*;
import static com.tss.utils.Validate.*;

public class Main {
    private static int MAX_MOVIES=5;
    static MovieController movieController=new MovieController();
    public static void main(String[] args) throws IOException, ClassNotFoundException, CapacityFullException, NoSuchMovieFoundException {

        while(true){
            start();
            int choice=validateInt();
            switch (choice){
                case 1:{
                    addMovie();
                    break;
                }
                case 2:{
                    displayMovies();
                    break;
                }
                case 3:{
                    saveMovies();
                    break;
                }
                case 4:{
                    deleteAllMovies();
                    break;
                }
                case 5:{
                    clearMoviesFromList();
                    break;
                }
                case 6:{
                    updateMovieDetails();
                    break;
                }
                case 7:{
                    System.out.println("Have a Good Day !!!");
                    return;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }

    }

    private static void updateMovieDetails() throws NoSuchMovieFoundException {
        movieController.setMovieDetails();
    }

    static Movie getMovieById(int movieId) {
        for(Movie m:movieController.getMovieManager().getMovies()){
            if(m==null)break;
            if(m.getId()==movieId)return m;
        }
        return null;
    }

    private static void clearMoviesFromList() {
        movieController.getMovieManager().clearMovies();
        System.out.println("Movies cleared from List !!");
    }

    private static void deleteAllMovies() {
        movieController.getMovieManager().deleteAllMovies();
        System.out.println("Movies deleted from file !!");
    }

    private static void saveMovies() {
        movieController.getMovieManager().saveMovies();
        System.out.println("Movies saved to File !!");
    }

    private static void displayMovies() {
        List<Movie> l=movieController.getMovieManager().getMovies();
        if(l.isEmpty()){
            System.out.println("No Movies Found !!");
            return;
        }
        System.out.println("Total Movies :");
        for(Movie m:l){
            if(m==null)break;
            System.out.println(m);
            System.out.println();
        }

    }

    private static void addMovie() throws CapacityFullException {
        if(numberOfMovies==MAX_MOVIES){
            throw new CapacityFullException(MAX_MOVIES);
        }

        System.out.print("Enter Movie ID: ");
        int movieId=scanner.nextInt();
        while(movieIdExists(movieId)){
            System.out.println("Movie ID already exists !!");
            System.out.print("Enter Movie ID: ");
            movieId=scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print("Enter Movie Name: ");
        String movieName= scanner.nextLine();
        System.out.print("Enter Movie Release Year: ");
        int movieYear=validateInt();
        scanner.nextLine();
        System.out.print("Enter Movie Genre: ");
        String genre= scanner.nextLine();

        Movie movie=new Movie(movieId,movieName,movieYear,genre);
        movieController.getMovieManager().addMovie(movie);

        System.out.println("Movie Added !!");

    }

    private static boolean movieIdExists(int movieId) {
        List<Movie> l=movieController.getMovieManager().getMovies();
        for(Movie m:l){
            if(m==null)break;
            if(m.getId()==movieId)return true;
        }
        return false;
    }
}
