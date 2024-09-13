package com.teachmeskills.service.impl;

import com.teachmeskills.entity.Player;
import com.teachmeskills.service.NotificationService;
import com.teachmeskills.service.WinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RequiredArgsConstructor
@Service
public class WinServiceImpl implements WinService {
    private final Player player;
    private final NotificationService notificationService;

    @Override
    public void startWinProcess(Double bet) {
        notificationService.sendWinnerNotification();
        Double currDeposit = player.getDeposit();
        player.setDeposit(currDeposit + 2 * bet);
    }
}
