package com.teachmeskills.shop.service;

import com.teachmeskills.shop.domain.ProductEntity;
import com.teachmeskills.shop.dto.ProductDto;
import com.teachmeskills.shop.dto.SearchDto;
import org.springframework.data.jpa.domain.Specification;

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

    Specification<ProductEntity> createSpecification(SearchDto searchDto);

    List<ProductDto> search(SearchDto searchDto);
}
