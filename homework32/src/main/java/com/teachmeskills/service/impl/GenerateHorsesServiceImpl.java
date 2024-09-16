package com.teachmeskills.service.impl;

import com.teachmeskills.aspects.Benchmark;
import com.teachmeskills.entity.Horse;
import com.teachmeskills.service.DataService;
import com.teachmeskills.service.GenerateHorsesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Service
@RequiredArgsConstructor
public class GenerateHorsesServiceImpl implements GenerateHorsesService {
    private final DataService dataService;

    @Benchmark
    @Override
    public void generateHorses() {
        int countHorses = (int) (Math.random() * 7 + 5);
        for (int i = 0; i < countHorses; i++) {
            int maxSpeed = (int) (Math.random() * countHorses) + 80;
            int health = (int) (Math.random() * 40) + 56;
            if (health < 80) continue;
            dataService.add(new Horse(i + 1, maxSpeed, health,
                    maxSpeed * health / 100));
        }
    }
}
