package com.teachmeskills.mapper;

import com.teachmeskills.entities.MovieEntity;
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
public class MovieRowMapper implements RowMapper<MovieEntity> {
    @Override
    public MovieEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = rs.getObject("id", UUID.class);
        String name = rs.getString("name");
        String description = rs.getString("description");
        short releaseYear = rs.getShort("release_year");
        boolean isView = rs.getBoolean("is_view");
        return new MovieEntity(id, name, description, releaseYear, isView);
    }
}
