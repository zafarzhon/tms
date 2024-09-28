package com.teachmeskills.shop.mapper;

import com.teachmeskills.shop.domain.ProductEntity;
import com.teachmeskills.shop.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(ProductDto productDto);

    ProductDto toProductDto(ProductEntity productEntity);

    //    List<ProductEntity> toProductEntityList(List<ProductDto> productDtoList);
    List<ProductDto> toProductDtoList(List<ProductEntity> productEntityList);
}
