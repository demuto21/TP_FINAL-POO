package com.example.POO_2.observer;

import java.util.ArrayList;
import java.util.List;

public class ParticipantObserverTest implements ParticipantObserver {
    private List<String> messages = new ArrayList<>();

    @Override
    public void notifier(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}