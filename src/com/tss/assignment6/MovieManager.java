package com.tss.assignment6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager{
    private ArrayList<Movie> movies;
    static int numberOfMovies=0;
    private static final String path="./MovieData/data.ser";

    public MovieManager() {
        movies=new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie){
        movies.add(movie);
        numberOfMovies++;
    }

    public void loadMovies() {
        File file=new File(path);
        if(file.length()==0){
            return;
        }
        try{
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            movies=(ArrayList<Movie>)ois.readObject();
            numberOfMovies=movies.size();
            System.out.println("Movies Loaded from File to List !!");
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

    public void clearMovies(){
        movies.clear();
        numberOfMovies=0;
    }

    public List<Movie> getMovies(){
        return movies;
    }

    public void saveMovies() {
        //save list to file
        try{
            FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos);

            oos.writeObject(movies);

            oos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public void deleteAllMovies(){
        //delete all movies from file
        try{
            new FileWriter(path,false).close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
