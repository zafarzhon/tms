package com.teachmeskills.service;

import com.teachmeskills.dto.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public class DbService {
    private static volatile DbService instance;
    private List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie("The Shawshank Redemption", "Over the course of " +
                "several years, two convicts form a friendship, seeking " +
                "consolation and, eventually, redemption through basic " +
                "compassion.", 1994, true));
        movies.add(new Movie("The Godfather", "Don Vito Corleone, head of a " +
                "mafia family, decides to hand over his empire to his " +
                "youngest son, Michael. However, his decision unintentionally" +
                " puts the lives of his loved ones in grave danger.", 1972,
                false));

        movies.add(new Movie("The Dark Knight", "When the menace known as the" +
                " Joker wreaks havoc and chaos on the people of Gotham, " +
                "Batman must accept one of the greatest psychological and " +
                "physical tests of his ability to fight injustice.", 2008,
                true));
    }

    private DbService() {
    }

    public static DbService getInstance() {
        DbService localInstance = instance;
        if (localInstance == null) {
            synchronized (DbService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbService();
                }
            }
        }
        return localInstance;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Movie findByIdMovie(UUID id){
        Movie movie = movies.stream().filter(m -> m.getId().equals(id)).findFirst().orElseThrow();
        return movie;
    }
    public void deleteByIdMovie(UUID id) {
        movies.remove(findByIdMovie(id));
    }
}
