package com.example.stefansator.brealth.rezepte;

public class Rezept {
    private String name;
    private String instructions;
    //TODO: Include picture of food

    public Rezept(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }
}
