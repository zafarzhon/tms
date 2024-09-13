package com.teachmeskills;

import com.teachmeskills.entity.Player;
import com.teachmeskills.service.HorseRacingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.teachmeskills");
        Player player = context.getBean(Player.class);
        player.setDeposit(100.);
        HorseRacingService bean = context.getBean(HorseRacingService.class);
        bean.run();
    }
}
