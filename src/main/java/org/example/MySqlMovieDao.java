package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlMovieDao extends MySqlDao implements MovieDaoInterface{

    @Override
    public List<Movie> findAllMovies() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Movie> movieList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM MOVIES";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int movie_id = resultSet.getInt("movie_id");
                String movie_name = resultSet.getString("movie_name");
                String director = resultSet.getString("director");
                float rating = resultSet.getFloat("rating");
                int release_year = resultSet.getInt("release_year");
                Movie m = new Movie(movie_id, movie_name, director, rating, release_year);
                movieList.add(m);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllMovies() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllMovies() " + e.getMessage());
            }
        }
        return movieList;     // may be empty
    }
}
