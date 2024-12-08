package edu.sdccd.cisc190.altscenes;

import edu.sdccd.cisc190.generalstuff.ExitGame;
import edu.sdccd.cisc190.generalstuff.MainMenu;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class fiveDodge {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;       // Text to display the stats

    public fiveDodge(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You successfully dodged the attack and you closed the door.\n" +
                "However, Mika the Monkey is smart, and she decides to turn the power back off.\n" +
                "“I should’ve used the water when necessary…”, but at least she’s locked inside.\n" +
                "“I don’t think the office is a good idea, the better idea is to get the hell out of here.”\n" +
                "Turning on the flashlight, you immediately see Ozzy the Ostrich running towards you, and he’s running towards you fast.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Button actions
        Button oneButton = new Button("Attack with a water bottle (50% remaining)");
        oneButton.setStyle("-fx-font-size: 14px;");
        //TODO: Ensure the oneButton triggers the correct action for continuing the story in fiveDodge1
        oneButton.setOnAction(e -> primaryStage.setScene(new fiveDodge(primaryStage).getScene()));

        Button twoButton = new Button("Dodge attack");
        twoButton.setStyle("-fx-font-size: 14px;");
        //TODO: Ensure twoButton logic correctly transitions the scene based on the player's choice
        twoButton.setOnAction(e -> gameStatus.setText("You slid under Ozzy the Ostrich and you ran as fast as you could.\n" +
                "You ran towards the main entrance/exit of the Seven Guys, however, the door won’t budge.\n" +
                "And it’s too late, Ozzy the Ostrich caught up to you."));
        //TODO: Trigger exit game scene if the player is caught by Ozzy
        twoButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  //TODO: 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton);

        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);  //TODO: Adjust scene size if necessary
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);  //TODO: Make sure conviction and madness values are updated during gameplay
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;  //TODO: Ensure scene transition logic is working as expected
    }
}
