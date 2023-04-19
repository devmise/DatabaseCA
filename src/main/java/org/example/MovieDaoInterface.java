package org.example;

import java.util.List;

public interface MovieDaoInterface {

    public List<Movie> findAllMovies() throws DaoException;
}
