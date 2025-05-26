package com.example.POO_2;

import com.example.POO_2.model.*;
import java.time.LocalDateTime;

public class NotificationTest {
    public static void main(String[] args) {
        Evenement concert = new Concert("C10", "Afro Night", LocalDateTime.now(), "Yaoundé", 2, "Fally", "Rumba");

        concert.ajouterParticipant(new Participant("P1", "Alice", "alice@example.com"));
        concert.ajouterParticipant(new Participant("P2", "Bob", "bob@example.com"));

        concert.annuler();  // -> déclenche les notifications asynchrones
    }
}