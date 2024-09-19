package com.teachmeskills.mapper;

import com.teachmeskills.dto.MovieDto;
import com.teachmeskills.entities.MovieEntity;
import org.springframework.stereotype.Component;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Component
public class MovieMapper {
    public MovieEntity mapToMovieEntity(MovieDto movieDto) {
        return new MovieEntity(movieDto);
    }

//    public MovieEntity mapToMovieEntity(UUID id, MovieDto movieDto) {
//        return new MovieEntity(id, movieDto);
//    }
//    public MovieDto mapToMovieDto(MovieEntity movieEntity) {
//        return new MovieDto(movieEntity);
//    }
}
