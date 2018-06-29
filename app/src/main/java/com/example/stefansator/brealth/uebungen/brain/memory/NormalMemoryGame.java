package com.example.stefansator.brealth.uebungen.brain.memory;

import com.example.stefansator.brealth.uebungen.MemoryGame;

/**
 * Created by StefanSator on 04.06.18.
 */

public class NormalMemoryGame extends MemoryGame {

    public NormalMemoryGame() {
        super();
    }

    @Override
    public String[] setCardNames() {
        String cardNames[] = {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F"};
        return cardNames;
    }
}
