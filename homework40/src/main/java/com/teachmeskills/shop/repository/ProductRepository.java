package com.teachmeskills.shop.repository;

import com.teachmeskills.shop.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}