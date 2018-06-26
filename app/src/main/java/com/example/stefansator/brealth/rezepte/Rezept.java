package com.example.stefansator.brealth.rezepte;

import android.media.Image;

public class Rezept {
    private String name;
    private String instructions;
    private int imageResource;
//    private Image
    //TODO: Include picture of food

    public Rezept(String name, String instructions, int imageResource) {
        this.name = name;
        this.instructions = instructions;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getImageResource() { return imageResource; }
}
