package com.teachmeskills.service;

import com.teachmeskills.dto.Movie;
import com.teachmeskills.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Repository
@RequiredArgsConstructor
public class DataBaseService {
    private final JdbcTemplate jdbcTemplate;
    private final MovieMapper movieMapper;
    private List<Movie> allMovies;

    public void save(String name,
                     String description,
                     Integer releaseYear,
                     Boolean isView) {
        jdbcTemplate.update("insert into movies (name, description, " +
                        "release_year, is_view) values (?,?,?,?)", name, description,
                releaseYear, isView);
    }

    public List<Movie> getAll() {
        allMovies = jdbcTemplate.query("select * from movies", movieMapper);
        return allMovies;
    }

    public Movie getMovieById(UUID id) {
        return allMovies.stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }

    public void delete(UUID id) {
        jdbcTemplate.update("delete from movies where id = ?", id);
    }

    public void update(UUID id,
                       String name,
                       String description,
                       Integer releaseYear,
                       Boolean isView) {
        jdbcTemplate.update("update movies set name=?,description=?," +
                        "release_year=?,is_view=? where id=?;", name, description,
                releaseYear.shortValue(), isView, id);
    }
}
