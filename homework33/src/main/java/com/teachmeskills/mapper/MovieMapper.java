package com.teachmeskills.mapper;

import com.teachmeskills.dto.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Component
public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = rs.getObject("id", UUID.class);
        String name = rs.getString("name");
        String description = rs.getString("description");
        int releaseYear = rs.getInt("release_year");
        boolean isView = rs.getBoolean("is_view");
        return new Movie(id,name,description,releaseYear,isView);
    }
}
