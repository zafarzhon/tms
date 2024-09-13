package com.teachmeskills;

import com.teachmeskills.entity.Player;
import com.teachmeskills.service.HorseRacingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@Configuration
@EnableAspectJAutoProxy
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
