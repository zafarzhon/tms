package com.teachmeskills.service;

import com.teachmeskills.entity.Horse;

import java.util.List;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public interface DataService {
    void add(Horse horse);

    List<Horse> getAllHorses();
}
