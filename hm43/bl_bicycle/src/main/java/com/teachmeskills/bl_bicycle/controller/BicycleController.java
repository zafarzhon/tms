package com.teachmeskills.bl_bicycle.controller;

import com.teachmeskills.bl_bicycle.dto.BicycleDto;
import com.teachmeskills.bl_bicycle.model.enums.Brand;
import com.teachmeskills.bl_bicycle.model.enums.Status;
import com.teachmeskills.bl_bicycle.service.BicycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RestController
@RequestMapping("/bicycle")
@RequiredArgsConstructor
public class BicycleController {
    private final BicycleService bicycleService;

    @GetMapping("/all/{page}")
    public List<BicycleDto> getAll(@PathVariable int page) {
        return bicycleService.getAllBicycles(page);
    }

    @GetMapping("/{id}")
    public BicycleDto getById(@PathVariable UUID id) {
        return bicycleService.getBicycleById(id);
    }

    @GetMapping("/all/brand/{brand}/{page}")
    public List<BicycleDto> getByStatus(@PathVariable(name = "brand") Brand brand,
                                        @PathVariable(name = "page") int page) {
        return bicycleService.getAllBicyclesByBrand(brand, page);
    }

    @GetMapping("/all/status/{status}/{page}")
    public List<BicycleDto> getByBrand(@PathVariable(name = "status") Status status,
                                       @PathVariable(name = "page") int page) {
        return bicycleService.getAllBicyclesByStatus(status, page);
    }

    @PostMapping
    public BicycleDto create(@RequestBody BicycleDto bicycleDto) {
        return bicycleService.createBicycle(bicycleDto);
    }

    @PutMapping("/{id}")
    public BicycleDto update(@PathVariable UUID id, @RequestBody BicycleDto bicycleDto) {
        return bicycleService.updateBicycle(id, bicycleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bicycleService.deleteBicycleById(id);
    }
}
