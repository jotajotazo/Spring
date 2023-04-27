package com.ejercicios;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    public void imprimirSaludo2(){

        notificationService.imprimirSaludo();
    }
}
