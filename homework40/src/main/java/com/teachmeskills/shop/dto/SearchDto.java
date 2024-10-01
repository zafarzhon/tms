package com.teachmeskills.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
@NoArgsConstructor
public class SearchDto {
    private String name;
    private Integer minCount;
    private Integer maxCount;
    private Double minPrice;
    private Double maxPrice;
    private Boolean isDelivery;
}
