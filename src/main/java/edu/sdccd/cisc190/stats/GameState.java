package edu.sdccd.cisc190.stats;

/**
 * Javadoc your public classes and methods
 * Explain what GameState does. Why is Conviction and Madness significant to your game?
 */
public class GameState {

    private int conviction;
    private int madness;

    public GameState(int conviction, int madness) {
        this.conviction = conviction;
        this.madness = madness;
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
