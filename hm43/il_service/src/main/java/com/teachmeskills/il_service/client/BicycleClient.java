package com.teachmeskills.il_service.client;

import com.teachmeskills.il_service.config.FeignConfig;
import com.teachmeskills.il_service.dto.BicycleDto;
import com.teachmeskills.il_service.model.enums.Brand;
import com.teachmeskills.il_service.model.enums.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Component
@FeignClient(name = "bicycleClient", url = "127.0.0.1:8081", path = "/bicycle",
        configuration = FeignConfig.class)
public interface BicycleClient {
    @GetMapping("/all/{page}")
    List<BicycleDto> getAll(@PathVariable int page);

    @GetMapping("/{id}")
    BicycleDto getById(@PathVariable UUID id);

    @GetMapping("/all/brand/{brand}/{page}")
    List<BicycleDto> getByBrand(@PathVariable(name = "brand") Brand brand,
                                @PathVariable(name = "page") int page);

    @GetMapping("/all/status/{status}/{page}")
    List<BicycleDto> getByStatus(@PathVariable(name = "status") Status status,
                                 @PathVariable(name = "page") int page);

    @PostMapping
    BicycleDto create(@RequestBody BicycleDto bicycleDto);

    @PutMapping("/{id}")
    BicycleDto update(@PathVariable UUID id,
                      @RequestBody BicycleDto bicycleDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id);
}
