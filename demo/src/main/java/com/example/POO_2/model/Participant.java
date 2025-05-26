package com.example.POO_2.model;

import com.example.POO_2.observer.ParticipantObserver;

public class Participant implements ParticipantObserver{
    private String id;
    private String nom;
    private String email;

    // Constructeurs
    public Participant() {
    }

    public Participant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public void notifier(String message) {
        System.out.println("Notification envoyee a " + nom + "(" + email + ") : " + message);
    }

    // Getters/Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
