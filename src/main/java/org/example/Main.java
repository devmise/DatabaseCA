package org.example;

import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args)
    {
        MovieDaoInterface IMovieDao = new MySqlMovieDao();

        try
        {
            System.out.println("\nCall findAllMovies");
            List<Movie> movies = IMovieDao.findAllMovies();

            if(movies.isEmpty())
                System.out.println("There are no movies");
            else{
                for(Movie movie : movies)
                    System.out.println("Movies: " + movie.toString());
            }
//
//            System.out.println("\nCall: findMovieById");
//            int movie_id = 5;
//            Movie movie = IMovieDao.findMovieById(movie_id);
//
//            if( movie != null)
//                System.out.println("Movie found: " + movie);
//            else
//                System.out.println("Movie with that id was not found");


        System.out.println("\nCall deleteMovieById");
        int movie_id = 15;
        Movie movie = IMovieDao.deleteMovieById(movie_id);


        if(movie == null)
            System.out.println("Movie with id = " + movie_id + " successfully deleted");
        else
            System.out.println("Movie with that id was not found");
        }

        catch (DaoException e)
        {
            e.printStackTrace();
        }

    }
}
