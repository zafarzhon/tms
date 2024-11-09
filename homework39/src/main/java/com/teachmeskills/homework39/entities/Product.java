package com.teachmeskills.homework39.entities;

import lombok.Data;

import java.util.Random;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private Integer count;
    private Double price;
    private Boolean isDelivery;
    private Boolean isRemoved;

    public Product(Integer id, String name, Integer count, Double price, Boolean isDelivery) {
        this.id = this.id == null ? new Random().nextInt(1000) + 1 : id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.isDelivery = isDelivery;
    }

    public Product() {
        this.id = new Random().nextInt(1000) + 1;
    }
}
