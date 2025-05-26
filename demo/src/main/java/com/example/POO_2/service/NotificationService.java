package com.example.POO_2.service;

import com.example.POO_2.model.Participant;

import java.util.concurrent.CompletableFuture;

public class NotificationService {

    public static CompletableFuture<Void> envoyerNotificationAsync(Participant p, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                // Simulation de délai
                Thread.sleep(1000);
                System.out.println("Notification envoyée à " + p.getNom() + " : " + message);
            } catch (InterruptedException e) {
                System.out.println("Erreur lors de l'envoi : " + e.getMessage());
            }
        });
    }
}