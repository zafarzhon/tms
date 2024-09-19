package com.teachmeskills.service;

import com.teachmeskills.entities.MovieEntity;
import com.teachmeskills.mapper.MovieRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Repository
@RequiredArgsConstructor
public class DataBaseService {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MovieRowMapper movieRowMapper;


    public void save(MovieEntity movieEntity) {
        Map<String, Object> params = MovieMap.movieEntityToMap(movieEntity);
        jdbcTemplate.update("insert into movies (id,name, description, " +
                "release_year, is_view) values (:id,:name,:description," +
                ":releaseYear,:isView)", params);
    }

    public List<MovieEntity> getAll() {
        return jdbcTemplate.query("select * from movies", movieRowMapper);
    }

    public void update(MovieEntity movieEntity) {
        Map<String, Object> params = MovieMap.movieEntityToMap(movieEntity);
        jdbcTemplate.update("update movies set name=:name," +
                "description=:description," +
                "release_year=:releaseYear,is_view=:isView where " +
                "id=:id;", params);
    }

    public MovieEntity findMovieById(UUID id) {
        Map<String, Object> namedParameters = Collections.singletonMap("id",
                id);
        return jdbcTemplate.queryForObject("select * from movies where id=:id",
                namedParameters,
                movieRowMapper);
    }

    public void delete(UUID id) {
        Map<String, Object> namedParameters = Collections.singletonMap("id",
                id);
        jdbcTemplate.update("delete from movies where id = :id", namedParameters);
    }


    private static class MovieMap {
        public static Map<String, Object> movieEntityToMap(MovieEntity movieEntity) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", movieEntity.getId());
            params.put("name", movieEntity.getName());
            params.put("description", movieEntity.getDescription());
            params.put("releaseYear", movieEntity.getReleaseYear());
            params.put("isView", movieEntity.getIsView());
            return params;
        }
    }
}
