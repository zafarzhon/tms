package com.teachmeskills.bl_bicycle.repository;

import com.teachmeskills.bl_bicycle.model.Bicycle;
import com.teachmeskills.bl_bicycle.model.enums.Brand;
import com.teachmeskills.bl_bicycle.model.enums.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface BicycleRepository extends JpaRepository<Bicycle, UUID> {
    List<Bicycle> getAllByStatus(Status status, Pageable pageable);

    List<Bicycle> getAllBicyclesByBrand(Brand brand, Pageable pageable);
}
