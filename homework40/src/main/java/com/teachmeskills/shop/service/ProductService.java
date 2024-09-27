package com.teachmeskills.shop.service;

import com.teachmeskills.shop.dto.ProductDto;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface ProductService {
    void createProduct(ProductDto productDto);

    void updateProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(int id);
}
