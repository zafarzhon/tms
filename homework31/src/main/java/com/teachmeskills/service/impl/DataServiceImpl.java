package com.teachmeskills.service.impl;

import com.teachmeskills.entity.Horse;
import com.teachmeskills.service.DataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Service
public class DataServiceImpl implements DataService {
    private List<Horse> horses = new ArrayList<Horse>();

    public void add(Horse horse) {
        horses.add(horse);
    }

    @Override
    public List<Horse> getAllHorses() {
        return horses;
    }
}
