package com.teachmeskills.service.impl;

import com.teachmeskills.entity.Player;
import com.teachmeskills.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Service
@RequiredArgsConstructor
public class HorseRacingServiceImpl implements HorseRacingService {
    private final GenerateHorsesService generateHorsesService;
    private final DataService dataService;
    private final NotificationService notificationService;
    private final WinnerDeterminerService winnerDeterminerService;
    private final WinService winService;
    private final LoseService loseService;
    private final Player player;

    @Override
    public void run() {
        notificationService.sendStartGameNotification();
        notificationService.sendDepositReminderNotification(player.getDeposit());
        do {

            dataService.getAllHorses().clear();
            generateHorsesService.generateHorses();
            if (dataService.getAllHorses().size() < 3) {
                continue;
            }
            notificationService.sendStartRacingNotification();
            notificationService.sendListOfHorses(dataService.getAllHorses());
            notificationService.sendChooseHorseNotification();
            Scanner scanner = new Scanner(System.in);
            int horseNumber = scanner.nextInt();
            notificationService.sendChooseBetNotification();
            Double bet = scanner.nextDouble();
            while (player.getDeposit() < bet) {
                notificationService.sendNotEnoughMoneyNotification();
                notificationService.sendChooseBetNotification();
                bet = scanner.nextDouble();
            }

            int winnerId = winnerDeterminerService.determineWinner();
            if (winnerId == horseNumber) {
                winService.startWinProcess(bet);
            } else {
                loseService.startLoseProcess(bet);
            }
            notificationService.sendDepositReminderNotification(player.getDeposit());
        } while (player.getDeposit() > 6);
        notificationService.sendGameOverNotification();
    }
}
