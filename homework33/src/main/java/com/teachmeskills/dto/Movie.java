package com.teachmeskills.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Data
public class Movie {
    private UUID id;
    @NotNull
    @Size(min = 4, max = 20)
    private String name;
    @NotNull
    @Size(min = 8, max = 50)
    private String description;
    @NotNull
    @Min(1950)
    @Max(2024)
    private Integer releaseYear;
    @NotNull
    private Boolean isView;

    public Movie(UUID id,String name, String description, Integer releaseYear,
                 Boolean isView) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseYear = releaseYear;
        this.isView = isView;
    }

}
