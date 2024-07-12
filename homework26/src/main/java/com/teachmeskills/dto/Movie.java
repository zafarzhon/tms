package com.teachmeskills.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Data
public class Movie {
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    private Integer releaseYear;
    private Boolean isView;

    public Movie(String name, String description, Integer releaseYear,
                 Boolean isView) {
        this.name = name;
        this.description = description;
        this.releaseYear = releaseYear;
        this.isView = isView;
    }

}
