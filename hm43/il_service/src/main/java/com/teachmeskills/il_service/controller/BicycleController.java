package com.teachmeskills.il_service.controller;


import com.teachmeskills.il_service.client.BicycleClient;
import com.teachmeskills.il_service.dto.BicycleDto;
import com.teachmeskills.il_service.dto.ErrorDto;
import com.teachmeskills.il_service.model.enums.Brand;
import com.teachmeskills.il_service.model.enums.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RestController
@RequestMapping("/api/bicycle_rental")
@RequiredArgsConstructor
public class BicycleController {
    private final BicycleClient bicycleClient;

    @GetMapping("/all/{page}")
    public List<BicycleDto> getAllFree(@PathVariable int page) {
        return bicycleClient.getByStatus(Status.FREE, page);
    }

    @Operation(
            summary = "Getting bicycle by id",
            description = "This method used for finding bicycle by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "bicycle found successfully",
                            content = @Content(
                                    mediaType = "application/application-json",
                                    schema = @Schema(implementation = BicycleDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "bicycle does not exist",
                            content = @Content(
                                    mediaType = "application/application-json",
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public BicycleDto getById(@PathVariable UUID id) {
        return bicycleClient.getById(id);
    }

    @GetMapping("/all/status/{status}/{page}")
    public List<BicycleDto> getByStatus(@PathVariable(name = "status") Status status,
                                        @PathVariable(name = "page") int page) {
        return bicycleClient.getByStatus(status, page);
    }

    @GetMapping("/all/brand/{brand}/{page}")
    List<BicycleDto> getByBrand(@PathVariable(name = "brand") Brand brand,
                                @PathVariable(name = "page") int page) {
        return bicycleClient.getByBrand(brand, page);
    }


    @PostMapping
    public BicycleDto create(@RequestBody BicycleDto bicycleDto) {
        return bicycleClient.create(bicycleDto);
    }

    @PutMapping("/{id}")
    public BicycleDto update(@PathVariable UUID id, @RequestBody BicycleDto bicycleDto) {
        return bicycleClient.update(id, bicycleDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bicycleClient.delete(id);
    }
}
