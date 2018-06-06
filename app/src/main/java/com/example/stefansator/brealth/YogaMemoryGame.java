package com.example.stefansator.brealth;

/**
 * Created by StefanSator on 06.06.18.
 */

public class YogaMemoryGame extends MemoryGame {
    /*private String yoga_bruecke = "" + R.drawable.yoga_bruecke;
    private String yoga_firefly = "" + R.drawable.yoga_firefly;
    private String yoga_hund = "" + R.drawable.yoga_hund;
    private String yoga_kobra = "" + R.drawable.yoga_kobra;
    private String yoga_pflug = "" + R.drawable.yoga_pflug;
    private String yoga_dreieck = "" + R.drawable.yoga_dreieck; */

    public YogaMemoryGame() {
        super();
    }

    @Override
    public String[] setCardNames() {
        String cardNames[] = {"" + R.drawable.yoga_bruecke, "" + R.drawable.yoga_bruecke, "" + R.drawable.yoga_firefly, "" + R.drawable.yoga_firefly,
                "" + R.drawable.yoga_hund, "" + R.drawable.yoga_hund, "" + R.drawable.yoga_kobra, "" + R.drawable.yoga_kobra,
                "" + R.drawable.yoga_pflug, "" + R.drawable.yoga_pflug, "" + R.drawable.yoga_dreieck, "" + R.drawable.yoga_dreieck};
        return cardNames;
    }
}
