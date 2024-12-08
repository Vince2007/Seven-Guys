package edu.sdccd.cisc190.altscenes;

import edu.sdccd.cisc190.generalstuff.ExitGame;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class fiveAttackWaterMore {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;       // Text to display the stats

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button continueButton;

    public fiveAttackWaterMore(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("You’ve managed to attack successfully with water, but the enemy fights back.\n" +
                "Your conviction and madness continue to rise as the stakes are higher than ever.\n" +
                "What will you do next?\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize buttons
        oneButton = new Button("Prepare to counterattack");
        twoButton = new Button("Run away and escape");
        threeButton = new Button("End 11 - Death");
        continueButton = new Button("Continue");

        // Set styles for the buttons
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // Set the continue button to be initially invisible
        threeButton.setVisible(false);
        continueButton.setVisible(false);

        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("You decide to counterattack. The battle becomes more intense, but you are able to land a blow.\n" +
                    "However, the consequences of your actions are dire and you start to feel the weight of your choices.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            continueButton.setVisible(true); //TODO: Make sure the continue button is visible after counterattack
            hideOtherButtons(); //TODO: Hide other buttons when counterattack option is chosen
        });

        twoButton.setOnAction(e -> {
            gameStatus.setText("You decide to flee the scene. The escape is not easy, but you manage to make it out.\n" +
                    "You find yourself alone, but the relief is short-lived. The consequences are not as expected.");
            updateStats();  // Update the stats text

            // Show the continue button and hide other buttons
            threeButton.setVisible(true); //TODO: Ensure the "End 11 - Death" button appears when escape option is chosen
            hideOtherButtons(); //TODO: Hide other buttons when escape option is chosen
        });

        // Action for continueButton to change to next scene
        threeButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene())); //TODO: Define the next scene after "End 11 - Death"
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene())); //TODO: Define the next scene after continue

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  //TODO: Check the spacing to make sure it’s visually appealing and consistent
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, continueButton);

        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400); //TODO: Adjust scene size if necessary for game design (e.g., 500x500 or 400x600)
    }

    // Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness); //TODO: Implement logic to update conviction and madness based on player choices
    }

    // Helper method to hide the action buttons
    private void hideOtherButtons() {
        oneButton.setVisible(false); //TODO: Make sure the first action button disappears when an option is selected
        twoButton.setVisible(false); //TODO: Ensure the second action button disappears when an option is selected
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
