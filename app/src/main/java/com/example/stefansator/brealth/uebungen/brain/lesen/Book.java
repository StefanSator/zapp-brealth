package com.example.stefansator.brealth.uebungen.brain.lesen;

import com.example.stefansator.brealth.R;

import java.util.Random;

/**
 * Created by stefansator on 20.05.18.
 */

public class Book {
    private int bookNr;

    public Book() {
        bookNr = randomNumberGenerator(0, 2);
    }

    public void setBook(int bookNr) {
        if (bookNr > 2)
            System.out.println("bookNr is invalid.");
        this.bookNr = bookNr;
    }

    public int getBook() {
        return convertNrToBook(bookNr);
    }

    private int convertNrToBook(int bookNr) {
        switch (bookNr) {
            case 0:
                return R.raw.derfalschetag;
            case 1:
                return R.raw.herrinderdaecher;
            case 2:
                return R.raw.sophiesreferat;
            default:
                return R.raw.texterror;
        }
    }

    private int randomNumberGenerator(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
