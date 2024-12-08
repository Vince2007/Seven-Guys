package edu.sdccd.cisc190.generalstuff;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        // TODO: Create instances for all scenes used in the game
        TitleScreen titleScreen = new TitleScreen(primaryStage); // TODO: Ensure title screen works and transitions smoothly
        MainMenu mainMenu = new MainMenu(primaryStage); // TODO: Make sure main menu transitions to other scenes correctly
        PreLude gameScreen = new PreLude(primaryStage); // TODO: Ensure Prelude scene works, particularly if it includes game mechanics

        // TODO: Setup initial game window
        primaryStage.setTitle("NightShift at Seven Guys (UNFINISHED VERSION)");  // TODO: Update this title when the game is finished or as necessary
        primaryStage.setScene(titleScreen.getScene());  // TODO: Ensure title screen is displayed first
        primaryStage.show();  // TODO: Test to make sure the stage shows up and resizes properly on different screens

        // TODO: Consider adding window resizing logic or custom close behavior (e.g., prompt to save or confirm exit)
    }

    public static void main(String[] args) {
        // TODO: Consider logging or additional setup before launching the game
        launch(args);  // TODO: Ensure this launches the JavaFX application correctly
    }
}
