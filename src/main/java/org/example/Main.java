package org.example;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;


public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.menu();
    }

    public void menu(){

        Scanner scanner = new Scanner(System.in);

                System.out.println("\n****MENU****");
                System.out.println("1) Display all movies\n" +
                        "2)Find movie by ID\n" +
                        "3)Delete movie by ID\n" +
                        "4)Insert movie into database\n" +
                        "5)Display movies by filter\n" +
                        "6)Retrieve all movies as JSON String\n" +
                        "7)Find move by ID as JSON String\n" +
                        "8)Exit\n");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayAllMovies();
                menu();
            case 2:
                findMovieById();
                menu();
            case 3:
                deleteMovieById();
                menu();
            case 4:
                insertMovie();
                menu();
            case 5:
                System.out.println("This feature is not working");
//                displayMovieByFilter();
                menu();
            case 6:
                displayAllMoviesJSON();
                menu();
            case 7:
//                findMovieByIdJSON();
                menu();
            case 8:
                System.out.println("Goodbye...");
                System.exit(0);
        }
    }

    public static void displayAllMovies() {
        MovieDaoInterface IMovieDao = new MySqlMovieDao();

        try {
            System.out.println("\nCall findAllMovies");
            List<Movie> movies = IMovieDao.findAllMovies();

            if (movies.isEmpty())
                System.out.println("There are no movies");
            else {
                for (Movie movie : movies)
                    System.out.println("Movies: " + movie.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

        public static void findMovieById() {
            MovieDaoInterface IMovieDao = new MySqlMovieDao();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter movie ID: ");
            int movie_id = scanner.nextInt();

            System.out.println("\nCall: findMovieById");
            Movie movie = IMovieDao.findMovieById(movie_id);

            if (movie != null)
                System.out.println("Movie found: " + movie);
            else
                System.out.println("Movie with that id was not found");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMovieById() {
        MovieDaoInterface IMovieDao = new MySqlMovieDao();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter movie ID: ");
            int movie_id = scanner.nextInt();

            System.out.println("\nCall deleteMovieById");
            Movie movie = IMovieDao.deleteMovieById(movie_id);

            if (movie == null)
                System.out.println("Movie with id = " + movie_id + " successfully deleted");
            else
                System.out.println("Movie with that id was not found");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static void insertMovie() {
        MovieDaoInterface IMovieDao = new MySqlMovieDao();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter movie name: ");
        String name = scanner.nextLine();

        System.out.println("Enter director name: ");
        String director = scanner.nextLine();

        System.out.println("Enter rating: ");
        float rate = scanner.nextFloat();

        System.out.println("Enter release year: ");
        int year = scanner.nextInt();

        System.out.println(name);

        try {
            Movie movie = IMovieDao.insertMovie(name, director, rate, year);
            if(movie != null){
                System.out.println("Movie successfully insterted with id: ");
            }
            else{
                System.out.println("Movie insert failed");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }


    }

    public static void displayAllMoviesJSON(){
        MovieDaoInterface IMovieDao = new MySqlMovieDao();
        Gson gsonParser = new Gson();
        String movieJsonString = null;
        try{
            List<Movie> movies = IMovieDao.findAllMovies();
            if (movies.isEmpty())
                System.out.println("There are no movies");
            else {
                movieJsonString = gsonParser.toJson(movies);
                System.out.println(movieJsonString);
            }
        }
        catch (DaoException e) {
            e.printStackTrace();
        }
    }

    }
