package edu.sdccd.cisc190.generalstuff;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TitleScreen {
    private final Scene scene;

    public TitleScreen(Stage primaryStage) {
        // Create the title text
        Text titleText = new Text("The NightShift at SevenGuys\n" +
                "Isn't entirely perfect, but... it works!!!");
        titleText.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Wrap the title text using TextFlow so the text doesn't run off-screen.
        TextFlow titleTextFlow = new TextFlow(titleText);
        titleTextFlow.setTextAlignment(TextAlignment.CENTER);
        titleTextFlow.setMaxWidth(380); // Set max width to wrap text within scene width

        // Create the start button
        Button startButton = new Button("Prelude to Insanity");
        startButton.setStyle("-fx-font-size: 20px;");

        // Center the button explicitly
        BorderPane.setAlignment(startButton, javafx.geometry.Pos.CENTER);

        // Create the MainMenu instance, but do not create the scene yet
        MainMenu mainMenu = new MainMenu(primaryStage);

        // Set the action of the button to switch to the MainMenu scene
        startButton.setOnAction(e -> primaryStage.setScene(mainMenu.getScene()));

        // Set up the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add the wrapped titleTextFlow to the top of the BorderPane
        layout.setTop(titleTextFlow);
        BorderPane.setAlignment(titleTextFlow, javafx.geometry.Pos.CENTER);

        // Add the startButton to the center of the BorderPane
        layout.setCenter(startButton);

        // Create the scene with the layout and set the preferred size
        scene = new Scene(layout, 400, 300);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
