package com.teachmeskills.entities;

import com.teachmeskills.dto.MovieDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
public class MovieEntity {
    @NotNull
    private UUID id;
    @NotBlank(message = "Must be without spaces")
    @Length(min = 4, max = 30, message = "Make sure it contains at least 4 letters and no more than 30 letters")
    private String name;
    @NotBlank(message = "Must be without spaces")
    @Length(min = 4, max = 30, message = "Make sure it contains at least 4 letters and no more than 30 letters")
    private String description;
    @NotNull(message = "Include [1950:2024]")
    @Min(value = 1950, message = "Include [1950:2024]")
    @Max(value = 2024, message = "Include [1950:2024]")
    private Short releaseYear;
    @NotNull
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

    //    public MovieEntity(UUID id, MovieDto movieDto) {
//        this.id = id;
//        this.name = movieDto.getName();
//        this.description = movieDto.getDescription();
//        this.releaseYear = movieDto.getReleaseYear();
//        this.isView = movieDto.getIsView();
//    }
    public MovieEntity(UUID id, String name, String description, Short releaseYear, Boolean isView) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseYear = releaseYear;
        this.isView = isView;
    }
}
