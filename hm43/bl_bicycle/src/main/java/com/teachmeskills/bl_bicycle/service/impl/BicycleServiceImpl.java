package com.teachmeskills.bl_bicycle.service.impl;

import com.teachmeskills.bl_bicycle.dto.BicycleDto;
import com.teachmeskills.bl_bicycle.exception.BicycleException;
import com.teachmeskills.bl_bicycle.mapper.BicycleMapper;
import com.teachmeskills.bl_bicycle.model.Bicycle;
import com.teachmeskills.bl_bicycle.model.enums.Brand;
import com.teachmeskills.bl_bicycle.model.enums.Status;
import com.teachmeskills.bl_bicycle.repository.BicycleRepository;
import com.teachmeskills.bl_bicycle.service.BicycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
@RequiredArgsConstructor
public class BicycleServiceImpl implements BicycleService {
    private final BicycleRepository repo;
    private final BicycleMapper mapper;
    @Value("${app.page.size}")
    private int sizeOfPages;

    @Override
    public List<BicycleDto> getAllBicycles(int page) {
        return mapper.toDtosFromPage(repo.findAll(PageRequest.of(page - 1,
                sizeOfPages)));
    }

    @Override
    public List<BicycleDto> getAllBicyclesByStatus(Status status, int page) {
        return mapper.toDtos(repo.getAllByStatus(status, PageRequest.of(page - 1
                , sizeOfPages)));
    }

    @Override
    public List<BicycleDto> getAllBicyclesByBrand(Brand brand, int page) {
        return mapper.toDtos(repo.getAllBicyclesByBrand(brand,
                PageRequest.of(page - 1,
                        sizeOfPages)));
    }

    @Override
    public BicycleDto getBicycleById(UUID id) {
        Bicycle bicycle = repo.
                findById(id).
                orElseThrow(() -> new BicycleException(400, "bicycle not found"));
        return mapper.toDto(bicycle);
    }

    @Override
    public BicycleDto createBicycle(BicycleDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public BicycleDto updateBicycle(UUID id, BicycleDto dto) {
        Bicycle bicycle = repo.
                findById(id).
                orElseThrow(() -> new BicycleException(400, "bicycle not found"));
        Bicycle updated = mapper.updateBicycleFromDto(dto, bicycle);
        return mapper.toDto(repo.save(updated));
    }

    @Override
    public void deleteBicycleById(UUID id) {
        repo.deleteById(id);
    }
}
