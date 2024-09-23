package com.teachmeskills.entities;

import com.teachmeskills.dto.MovieDto;
import lombok.Data;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
public class MovieEntity {
    private UUID id;
    private String name;
    private String description;
    private Short releaseYear;
    private Boolean isView;

    public MovieEntity() {
    }

    public MovieEntity(MovieDto movieDto) {
        this.id = UUID.randomUUID();
        this.name = movieDto.getName();
        this.description = movieDto.getDescription();
        this.releaseYear = movieDto.getReleaseYear();
        this.isView = movieDto.getIsView();
    }

        public MovieEntity(UUID id, MovieDto movieDto) {
        this.id = id;
        this.name = movieDto.getName();
        this.description = movieDto.getDescription();
        this.releaseYear = movieDto.getReleaseYear();
        this.isView = movieDto.getIsView();
    }
    public MovieEntity(UUID id, String name, String description, Short releaseYear, Boolean isView) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseYear = releaseYear;
        this.isView = isView;
    }
}
