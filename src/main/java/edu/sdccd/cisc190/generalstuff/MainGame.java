package edu.sdccd.cisc190.generalstuff;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        // TODO: Add a comment explaining that this is where the main scenes for the game are created (e.g., title screen, main menu, game screen).
        // Create scenes for each part of the game
        TitleScreen titleScreen = new TitleScreen(primaryStage);
        MainMenu mainMenu = new MainMenu(primaryStage);
        PreLude gameScreen = new PreLude(primaryStage);

        // Set the title screen as the initial scene
        // TODO: Explain that this line sets the initial screen that the player will see when they open the game (title screen).
        primaryStage.setTitle("NightShift at Seven Guys (UNFINISHED VERSION)");
        primaryStage.setScene(titleScreen.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
