DROP TABLE IF EXISTS movies;
CREATE TABLE movies
(movie_id int NOT NULL AUTO_INCREMENT,
movie_name varchar (40) NOT NULL,
director varchar (30) NOT NULL,
rating float (3,1) CHECK (rating >= 0.0 AND rating <= 10.0),
release_year int (4),
PRIMARY KEY (movie_id));

insert into movies (movie_name, director, rating, release_year)
values ("Brokeback Mountain","Ang Lee",7.7,2005);
insert into movies (movie_name, director, rating, release_year)
values ("Pride", "Matthew Warchus", 7.8, 2014);
insert into movies (movie_name, director, rating, release_year)
values ("Everything Everywhere All at Once", "Daniel Kwan", 7.9, 2022);
insert into movies (movie_name, director, rating, release_year)
values ("Spider-Man: Into the Spider-Verse", "Bob Persichetti", 8.4, 2018);
insert into movies (movie_name, director, rating, release_year)
values ("Hot Fuzz", "Edgar Wright", 7.8, 2007);
insert into movies (movie_name, director, rating, release_year)
values ("Monsters, Inc", "Pete Docter", 8.1, 2001);
insert into movies (movie_name, director, rating, release_year)
values ("Fargo", "Joel Coen", 8.1, 1996);
insert into movies (movie_name, director, rating, release_year)
values ("Baby Driver", "Edgar Wright", 7.6, 2017);
insert into movies (movie_name, director, rating, release_year)
values ("Kingsman: The Secret Service", "Matthew Vaughn", 7.7, 2014);
insert into movies (movie_name, director, rating, release_year)
values ("Rocketman", "Dexter Fletcher", 7.3, 2019);
insert into movies (movie_name, director, rating, release_year)
values ("The Imitation Game", "Morten Tyldum", 8.0, 2014);
insert into movies (movie_name, director, rating, release_year)
values ("Dallas Buyers Club", "Jean-Marc Vallée", 7.9, 2013);
insert into movies (movie_name, director, rating, release_year)
values ("Erin Brockovich", "Steven Soderbergh", 7.4, 2000);