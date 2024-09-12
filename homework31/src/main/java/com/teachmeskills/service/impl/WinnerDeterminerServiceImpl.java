package com.teachmeskills.service.impl;

import com.teachmeskills.entity.Horse;
import com.teachmeskills.service.DataService;
import com.teachmeskills.service.WinnerDeterminerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RequiredArgsConstructor
@Service
public class WinnerDeterminerServiceImpl implements WinnerDeterminerService {
    private final DataService dataService;

    @Override
    public Integer determineWinner() {
        Optional<Horse> winner =
                dataService.getAllHorses().stream().sorted(Comparator.comparingInt(Horse::getSpeed).reversed()).findFirst();
        return winner.get().getId();
    }
}
