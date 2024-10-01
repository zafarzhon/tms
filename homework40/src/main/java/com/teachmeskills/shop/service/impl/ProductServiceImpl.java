package com.teachmeskills.shop.service.impl;

import com.teachmeskills.shop.domain.ProductEntity;
import com.teachmeskills.shop.dto.ProductDto;
import com.teachmeskills.shop.dto.SearchDto;
import com.teachmeskills.shop.mapper.ProductMapper;
import com.teachmeskills.shop.repository.ProductRepository;
import com.teachmeskills.shop.service.ProductService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ProductDto> search(SearchDto searchDto) {
        return productMapper.toProductDtoList(productRepository.findAll(createSpecification(searchDto)));
    }

    @Override
    public Specification<ProductEntity> createSpecification(SearchDto searchDto) {
        return (root, query, criteriaBuilder) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();

            String name = searchDto.getName();
            if (name != null && !name.isEmpty()) {
                Predicate predicate = criteriaBuilder.equal(root.get("name"), name);
                predicates.add(predicate);
            }
            Integer maxCount = searchDto.getMaxCount();
            Integer minCount = searchDto.getMinCount();
            if (maxCount != null && maxCount > 0 && minCount != null && minCount > 0) {
                Predicate count = criteriaBuilder.between(root.get("count"),
                        minCount.intValue(),
                        maxCount.intValue());

                predicates.add(count);
            }

            Double maxPrice = searchDto.getMaxPrice();
            Double minPrice = searchDto.getMinPrice();
            if (maxPrice != null && maxPrice > 0 && minPrice != null && minPrice > 0) {
                Predicate price = criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
                predicates.add(price);
            }

            Boolean isDelivery = searchDto.getIsDelivery();
            if (isDelivery != null) {
                Predicate predicate = criteriaBuilder.equal(root.get("isDelivery"), isDelivery);
                predicates.add(predicate);
            }
            Predicate and = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return and;
        };
    }
}
