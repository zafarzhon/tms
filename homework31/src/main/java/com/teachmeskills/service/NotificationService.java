package com.teachmeskills.service;

import com.teachmeskills.entity.Horse;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
public interface NotificationService {
    void sendStartGameNotification();

    void sendStartRacingNotification();

    void sendWinnerNotification();

    void sendGameOverNotification();

    void sendListOfHorses(List<Horse> horses);

    void sendChooseHorseNotification();

    void sendLoseNotification();

    void sendDepositReminderNotification(Double deposit);

    void sendChooseBetNotification();

    void sendNotEnoughMoneyNotification();
}
