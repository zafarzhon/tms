package com.teachmeskills.il_service.dto;


import com.teachmeskills.il_service.model.enums.Brand;
import com.teachmeskills.il_service.model.enums.Status;
import com.teachmeskills.il_service.model.enums.Type;
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
