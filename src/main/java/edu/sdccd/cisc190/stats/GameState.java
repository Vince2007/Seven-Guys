package edu.sdccd.cisc190.stats;

/**
 * Javadoc your public classes and methods
 * Explain what GameState does. Why is Conviction and Madness significant to your game?
 */
public class GameState {

    private int conviction;
    private int madness;

    public GameState(int conviction, int madness) {
        this.conviction = 0;
        this.madness = 0;
    }

    public static int getConviction() {
        return conviction;
    }

    public static int increaseConviction() {
        return conviction++;
    }

    public static int getMadness() {
        return madness;
    }

    public static int increaseMadness() {
        return madness++;
    }
}
