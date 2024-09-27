package com.teachmeskills.shop.service.impl;

import com.teachmeskills.shop.domain.ProductEntity;
import com.teachmeskills.shop.dto.ProductDto;
import com.teachmeskills.shop.mapper.ProductMapper;
import com.teachmeskills.shop.repository.ProductRepository;
import com.teachmeskills.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void createProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toEntity(productDto);
        productRepository.save(productEntity);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toEntity(productDto);
        productRepository.save(productEntity);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductEntity> all = productRepository.findAll();
        List<ProductDto> productDtoList = productMapper.toProductDtoList(all);
        return productDtoList;
    }

    @Override
    public ProductDto getProductById(int id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return productMapper.toProductDto(productEntity);
    }
}
