package com.example.POO_2.model;

import java.time.LocalDateTime;
import java.util.List;

public class Conference extends Evenement {
    private String theme;
    private List<String> intervenants;

    public Conference(){
        super("", "",LocalDateTime.now(),"", 0 );
    }

    public Conference(String id, String nom, LocalDateTime date, String lieu, int capaciteMax,
                      String theme, List<String> intervenants) {
        super(id, nom, date, lieu, capaciteMax);
        this.theme = theme;
        this.intervenants = intervenants;
    }
}
