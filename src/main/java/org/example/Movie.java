package org.example;

public class Movie {

    private int movie_id;
    private String movie_name;
    private String director;
    private float rating;
    private int release_year;

    public Movie(String name, String director, float rate, int year) {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                ", release_year=" + release_year +
                '}';
    }



    public Movie(int movie_id, String movie_name, String director, float rating, int release_year) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.director = director;
        this.rating = rating;
        this.release_year = release_year;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
