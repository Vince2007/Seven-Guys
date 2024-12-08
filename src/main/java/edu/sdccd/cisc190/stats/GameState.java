package edu.sdccd.cisc190.stats;

public class GameState {
    private int conviction; // TODO: Track the user's conviction status, cause it looks like a stat.
    private int madness; // TODO: Track the user's maddness status, cause it looks like a stat.

    public GameState() {
        this.conviction = 0;
        this.madness = 0;
    }

    public int getConviction() {
        return conviction;
    }

    public void increaseConviction() {
        conviction++; // TODO: conviction madness by 1.
    }

    public int getMadness() {
        return madness;
    }

    public void increaseMadness() {
        madness++; // TODO: Increment madness by 1.
    }
}
