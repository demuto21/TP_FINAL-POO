package com.example.POO_2.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.*;
import com.example.POO_2.exception.CapaciteMaximalAtteinteException;
import com.example.POO_2.observer.EvenementObservable;
import com.example.POO_2.service.NotificationService;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Concert.class, name = "concert"),
        @JsonSubTypes.Type(value = Conference.class, name = "conference")
})

public abstract class Evenement {
    protected String id;
    protected String nom;
    protected LocalDateTime date;
    protected String lieu;
    protected int capaciteMax;
    protected List<Participant> participants = new ArrayList<>();

    public List<Participant> getParticipants() {
        return participants;
    }
@JsonIgnore
    public EvenementObservable getObservable() {
        return observable;
    }

    public String getNom() {
        return nom;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public Evenement(String id, String nom, LocalDateTime date, String lieu, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.lieu = lieu;
        this.capaciteMax = capaciteMax;
    }

    @JsonIgnore
    private final EvenementObservable observable = new EvenementObservable();

    public void inscrireEtObserver(Participant participant) throws CapaciteMaximalAtteinteException {
        ajouterParticipant(participant);
        observable.ajouterObserver(participant);
    }

    public void annuler() {
    String message = "L'événement '" + nom + "' est annulé.";
    System.out.println(">> " + message);

    for (Participant p : participants) {
        NotificationService.envoyerNotificationAsync(p, message);
    }
}

    public void ajouterParticipant(Participant p) throws CapaciteMaximalAtteinteException {
        if (participants.size() >= capaciteMax) {
            throw new CapaciteMaximalAtteinteException("Capacité maximale atteinte pour l'événement : " + nom);
        }
        participants.add(p);
    }

    public void afficherDetails() {
        System.out.println("Événement : " + nom + " | Date : " + date + " | Lieu : " + lieu);
    }

    public String getId() {
        return id;
    }

}