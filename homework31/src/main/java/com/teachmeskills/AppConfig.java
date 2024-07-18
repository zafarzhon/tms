package com.teachmeskills;

import org.springframework.context.annotation.Bean;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public class AppConfig {
    @Bean
    public NotificationService notificationService(){
        return new EmailNotificationService();
    }

    @Bean
    public UserService userService(NotificationService notificationService){
        return new UserServiceImpl(notificationService);
    }

}
