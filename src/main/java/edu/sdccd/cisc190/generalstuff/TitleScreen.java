package edu.sdccd.cisc190.generalstuff;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TitleScreen {
    private final Scene scene;

    public TitleScreen(Stage primaryStage) {
        // Create the title text
        Text titleText = new Text("The NightShift at SevenGuys\n" +
                "Isn't entirely perfect, but... it works!!!");
        titleText.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Create the start button
        Button startButton = new Button("Prelude to Insanity");
        startButton.setStyle("-fx-font-size: 20px;");

        // Create the MainMenu instance, but do not create the scene yet
        // TODO: Make sure that the MainMenu class correctly handles passing the primaryStage and any other necessary data.
        MainMenu mainMenu = new MainMenu(primaryStage);

        // Set the action of the button to switch to the MainMenu scene
        startButton.setOnAction(e -> primaryStage.setScene(mainMenu.getScene()));

        // Set up the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add the titleText to the top of the BorderPane
        layout.setTop(titleText);

        // Add the startButton to the center of the BorderPane
        layout.setCenter(startButton);

        // Create the scene with the layout and set the preferred size
        // TODO: Consider making the scene size adjustable based on the screen or user preferences.
        scene = new Scene(layout, 400, 300);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
