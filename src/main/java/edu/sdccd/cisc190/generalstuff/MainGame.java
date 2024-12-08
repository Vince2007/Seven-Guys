package edu.sdccd.cisc190.generalstuff;

import javafx.application.Application;
import javafx.stage.Stage;

/**
* Main entry point for the application.
 * Initializes and displays the TitleScreen, MainMenu, and PreLude scenes.
 */

public class MainGame extends Application {

    /**
     * Starts the JavaFX application and sets the initial scene.
     *
     * @param primaryStage The primary stage for this application.
     */

    @Override
    public void start(Stage primaryStage) 
    // TODO: Add a README.md with instructions and the JDK version required for the project.
        // TODO: Include a check for any necessary exceptions (for example, if the scenes cannot be loaded).
        // Create scenes for each part of the game
        TitleScreen titleScreen = new TitleScreen(primaryStage);
        MainMenu mainMenu = new MainMenu(primaryStage);
        PreLude gameScreen = new PreLude(primaryStage);
    
        // TODO: Document the purpose of each scene in JavaDocs.
        // Set the title screen as the initial scene
        primaryStage.setTitle("NightShift at Seven Guys (UNFINISHED VERSION)");
        primaryStage.setScene(titleScreen.getScene());
        primaryStage.show();
    }

    /**
     * The main method to launch the application.
     *
     * @param args Command-line arguments passed to the application.
     */

    public static void main(String[] args) {
        // TODO: Handle any exceptions that could arise during game launch (e.g., missing resources).
        launch(args);
    }
}
