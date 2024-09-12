package com.teachmeskills.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horse {
    private Integer id;
    // speed in m/s
    private Integer maxSpeed;

    // health [80-95];
    private Integer health;
    private Integer speed;


}
