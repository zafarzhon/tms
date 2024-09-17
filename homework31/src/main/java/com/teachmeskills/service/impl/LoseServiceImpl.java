package com.teachmeskills.service.impl;

import com.teachmeskills.entity.Player;
import com.teachmeskills.service.LoseService;
import com.teachmeskills.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RequiredArgsConstructor
@Service
public class LoseServiceImpl implements LoseService {
    private final Player player;
    private final NotificationService notificationService;

    @Override
    public void startLoseProcess(Double bet) {
        notificationService.sendLoseNotification();
        Double currDeposit = player.getDeposit();
        player.setDeposit(currDeposit - bet);
    }
}
