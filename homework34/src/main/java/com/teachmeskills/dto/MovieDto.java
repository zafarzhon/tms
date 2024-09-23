package com.teachmeskills.dto;

import com.teachmeskills.entities.MovieEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
public class MovieDto {
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

    public MovieDto() {
    }

    public MovieDto(MovieEntity movieEntity) {
        this.name = movieEntity.getName();
        this.description = movieEntity.getDescription();
        this.releaseYear = movieEntity.getReleaseYear();
        this.isView = movieEntity.getIsView();
    }
}
