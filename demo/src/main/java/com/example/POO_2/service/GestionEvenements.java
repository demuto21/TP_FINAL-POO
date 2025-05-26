package com.example.POO_2.service;

import java.util.HashMap;
import java.util.Map;

import com.example.POO_2.exception.EvenementDejaExistantException;
import com.example.POO_2.model.Evenement;

public class GestionEvenements {
    private static GestionEvenements instance;
    private Map<String, Evenement> evenements = new HashMap<>();

    private GestionEvenements() {}

    public static GestionEvenements getInstance() {
        if (instance == null) {
            instance = new GestionEvenements();
        }
        return instance;
    }

    public void ajouterEvenement(Evenement e) throws EvenementDejaExistantException {
        if (evenements.containsKey(e.getId())) {
            throw new EvenementDejaExistantException("L'événement avec ID " + e.getId() + " existe déjà.");
        }
        evenements.put(e.getId(), e);
    }

    public void supprimerEvenement(String id) {
        evenements.remove(id);
    }

    public Evenement rechercherEvenement(String id) {
        return evenements.get(id);
    }
}
