package com.konstantin.kustov.multidrag;

public class Cell {
    private String character;
    private boolean chosen;

    public Cell(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}
