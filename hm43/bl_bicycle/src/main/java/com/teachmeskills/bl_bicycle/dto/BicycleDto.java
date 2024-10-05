package com.teachmeskills.bl_bicycle.dto;

import com.teachmeskills.bl_bicycle.model.enums.Brand;
import com.teachmeskills.bl_bicycle.model.enums.Status;
import com.teachmeskills.bl_bicycle.model.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
@NoArgsConstructor
public class BicycleDto {
    private Double price;
    private Brand brand;
    private Type type;
    private Status status;
}
