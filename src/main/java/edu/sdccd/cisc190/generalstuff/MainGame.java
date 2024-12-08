package edu.sdccd.cisc190.generalstuff;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGame extends Application {

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

    public static void main(String[] args) {
        // TODO: Handle any exceptions that could arise during game launch (e.g., missing resources).
        launch(args);
    }
}
