package edu.sdccd.cisc190.stats;

//TODO: Implement conviction and madness
//TODO: Clarify the intent and purpose behind having conviction and madness

public class GameState {
    private int conviction;
    private int madness;

    public GameState() {
        this.conviction = 0;
        this.madness = 0;
    }

    public int getConviction() {
        return conviction;
    }

    public void increaseConviction() {
        conviction++;
    }

    public int getMadness() {
        return madness;
    }

    public void increaseMadness() {
        madness++;
    }
}
