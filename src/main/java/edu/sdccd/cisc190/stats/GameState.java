package edu.sdccd.cisc190.stats;

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

    // TODO: To use multithreading create a timer that shows the user how long they took to complete the game
    // TODO: To use File I/O, if the user quits the game while a session is in progress, save their conviction and madness and their place in the game
}
