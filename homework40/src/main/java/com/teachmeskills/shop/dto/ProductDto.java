package com.teachmeskills.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private Integer count;
    private Double price;
    private Boolean isDelivery;
    private Boolean isRemoved;
}
