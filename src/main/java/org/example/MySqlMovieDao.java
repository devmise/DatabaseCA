package org.example;

import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlMovieDao extends MySqlDao implements MovieDaoInterface {

    @Override
    public List<Movie> findAllMovies() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM MOVIES";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int movie_id = resultSet.getInt("movie_id");
                String movie_name = resultSet.getString("movie_name");
                String director = resultSet.getString("director");
                float rating = resultSet.getFloat("rating");
                int release_year = resultSet.getInt("release_year");
                Movie m = new Movie(movie_id, movie_name, director, rating, release_year);
                movieList.add(m);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllMovies() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return movieList;     // may be empty
    }

    @Override
    public Movie findMovieById(int movie_id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;

        try {
            connection = this.getConnection();

            String query = "SELECT * FROM MOVIES WHERE MOVIE_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, movie_id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                movie_id = resultSet.getInt("movie_id");
                String movie_name = resultSet.getString("movie_name");
                String director = resultSet.getString("director");
                float rating = resultSet.getFloat("rating");
                int release_year = resultSet.getInt("release_year");
                movie = new Movie(movie_id, movie_name, director, rating, release_year);

            }
        } catch (SQLException e) {
            throw new DaoException("findMovieById()" + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword() " + e.getMessage());
            }
        }
        return movie;
    }

    @Override
    public Movie deleteMovieById(int movie_id) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;


        try {
            connection = this.getConnection();

            String query = "DELETE FROM MOVIES WHERE MOVIE_ID = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, movie_id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new DaoException("No movie with ID " + movie_id + " was found.");
            }

        } catch (SQLException e) {
            throw new DaoException("deleteMovieById()" + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("deleteMovieById()" + e.getMessage());
            }

            return movie;
        }

    }

    @Override
    public Movie insertMovie(String movieName, String movieDirector, float movieRate, int movieYear) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movie movie = null;

        String name = movieName;
        String director = movieDirector;
        float rate = movieRate;
        int year = movieYear;


        try {
            connection = this.getConnection();

            String query = "INSERT INTO MOVIES VALUES = (null, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, director);
            preparedStatement.setFloat(3, rate);
            preparedStatement.setInt(4, year);

            preparedStatement.executeUpdate();

            movie = new Movie(name, director, rate, year);

        } catch (SQLException e) {
            throw new DaoException("insertMovie()" + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("insertMovie()" + e.getMessage());
            }

            return movie;
        }
    }

    @Override
    public String findAllMoviesJsonString() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM MOVIES";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int movie_id = resultSet.getInt("movie_id");
                String movie_name = resultSet.getString("movie_name");
                String director = resultSet.getString("director");
                float rating = resultSet.getFloat("rating");
                int release_year = resultSet.getInt("release_year");
                Movie m = new Movie(movie_id, movie_name, director, rating, release_year);
                movieList.add(m);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllMovies() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        Gson gson = new Gson();
        return gson.toJson(movieList);
    }
}
