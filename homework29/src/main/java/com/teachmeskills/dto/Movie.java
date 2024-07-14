package com.teachmeskills.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Data
public class Movie {
    private UUID id;
    private String name;
    private String description;
    private Integer releaseYear;
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
