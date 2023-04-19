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
        }
        catch (DaoException e)
        {
            e.printStackTrace();
        }

    }
}
