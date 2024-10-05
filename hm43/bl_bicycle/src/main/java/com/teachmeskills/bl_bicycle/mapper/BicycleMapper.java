package com.teachmeskills.bl_bicycle.mapper;

import com.teachmeskills.bl_bicycle.dto.BicycleDto;
import com.teachmeskills.bl_bicycle.model.Bicycle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Mapper(componentModel = "spring")
public interface BicycleMapper {

    Bicycle toEntity(BicycleDto bicycleDto);

    BicycleDto toDto(Bicycle bicycle);

    List<BicycleDto> toDtos(List<Bicycle> bicycles);

    Bicycle updateBicycleFromDto(BicycleDto source,
                                 @MappingTarget Bicycle target);

    List<BicycleDto> toDtosFromPage(Page<Bicycle> bicyclePage);
}
