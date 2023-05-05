package org.example;

import java.util.List;

public interface MovieDaoInterface {

    public List<Movie> findAllMovies() throws DaoException;
    public Movie findMovieById(int movie_id) throws DaoException;
    public Movie deleteMovieById(int movie_id) throws DaoException;
    public Movie insertMovie(String name, String director, float rate, int year) throws DaoException;
    public String findAllMoviesJsonString() throws DaoException;
}
