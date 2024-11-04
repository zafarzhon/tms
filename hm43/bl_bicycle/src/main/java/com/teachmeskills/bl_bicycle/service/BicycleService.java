package com.teachmeskills.bl_bicycle.service;

import com.teachmeskills.bl_bicycle.dto.BicycleDto;
import com.teachmeskills.bl_bicycle.model.enums.Brand;
import com.teachmeskills.bl_bicycle.model.enums.Status;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface BicycleService {
    List<BicycleDto> getAllBicycles(int page);

    List<BicycleDto> getAllBicyclesByStatus(Status status, int page);

    List<BicycleDto> getAllBicyclesByBrand(Brand brand, int page);

    BicycleDto getBicycleById(UUID id);

    BicycleDto createBicycle(BicycleDto dto);

    BicycleDto updateBicycle(UUID id, BicycleDto dto);

    void deleteBicycleById(UUID id);
}
