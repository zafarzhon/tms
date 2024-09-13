package com.teachmeskills.service.impl;

import com.teachmeskills.entity.Horse;
import com.teachmeskills.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendStartGameNotification() {
        System.out.println("Start Game!!!");
    }

    @Override
    public void sendStartRacingNotification() {
        System.out.println("Start Racing!!!");
    }

    @Override
    public void sendChooseHorseNotification() {
        System.out.println("Choose Horse!!!");
    }

    @Override
    public void sendWinnerNotification() {
        System.out.println("You win:)");
    }

    @Override
    public void sendGameOverNotification() {
        System.out.println("not enough money. Game over");
    }

    @Override
    public void sendListOfHorses(List<Horse> horses) {
        System.out.println("|  #  | Max speed |");
        horses.forEach(horse -> System.out.printf("| %2d  | %6d\t|\n",
                horse.getId(), horse.getMaxSpeed()));
    }

    @Override
    public void sendLoseNotification() {
        System.out.println("You lose:(");
    }

    @Override
    public void sendDepositReminderNotification(Double deposit) {
        System.out.println("your deposit : " + deposit + "$");
    }

    @Override
    public void sendChooseBetNotification() {
        System.out.println("your bet: ");
    }

    @Override
    public void sendNotEnoughMoneyNotification() {
        System.out.println("Incorrect bet. Not enough money!!!");
    }
}
