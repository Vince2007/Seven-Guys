package edu.sdccd.cisc190.altscenes;

import edu.sdccd.cisc190.generalstuff.ExitGame;
import edu.sdccd.cisc190.scenes.fiveMorning;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class fiveDodge1 {
    private Scene scene;
    private int conviction; // TODO: Variable to track the conviction stat
    private int madness; // TODO: Variable to track the madness stat
    private final Text gameStatus; // TODO: Text to display the game's current status
    private final Text statsText; // TODO: Text to display the player's stats (conviction and madness)

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton; // TODO: Button for attacking Daniel the Dog with water
    private final Button twoButton; // TODO: Button for attacking Rumble the Racoon with water
    private final Button threeButton; // TODO: Button for dodging the attack
    private final Button fourButton; // TODO: Button to end the game (Death)
    private final Button continueButton; // TODO: Button to continue to the next scene

    public fiveDodge1(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("Splashing Ozzy the Ostrich with water, allowed him to be disabled, although realizing the amount of water you have, meant that you had to conserve the water, as you only have 25% remaining.\n" +
                "You ran to the main entrance/exit of the Seven Guys but realized something was wrong, the door wouldn’t budge.\n" +
                "This is bad, although you at least know there’s an alternative exit at the Kitchen, your journey is still not over.\n" +
                "You ran past the party area and you went straight to the Kitchen. There you see both Daniel the Dog and Rumble the Racoon.\n" +
                "They’re heading to you on both sides. You have the water, what are you going to do???\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness); // TODO: Set the initial stats text
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Initialize the buttons
        oneButton = new Button("Attack Daniel the Dog with water (25% remaining)");
        twoButton = new Button("Attack Rumble the Racoon with water (25% remaining)");
        threeButton = new Button("Dodge");
        fourButton = new Button("End 9 - Death");
        continueButton = new Button("Transition to 6 AM");

        // Set styles for the buttons (make buttons look consistent)
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // Set the continue button to be initially invisible
        fourButton.setVisible(false); // TODO: Hide the "End 9 - Death" button initially
        continueButton.setVisible(false); // TODO: Hide the "Continue" button initially

        // Button actions
        oneButton.setOnAction(e -> {
            gameStatus.setText("You disabled Daniel the Dog, but Rumble the Racoon was able to attack you fully.");
            updateStats(); // TODO: Update stats after this action
            fourButton.setVisible(true); // TODO: Show the "End 9 - Death" button after action
            hideOtherButtons(); // TODO: Hide other buttons to limit choices
        });

        twoButton.setOnAction(e -> {
            gameStatus.setText("You disabled Rumble the Racoon, but Daniel the Dog was able to attack you fully.");
            updateStats(); // TODO: Update stats after this action
            fourButton.setVisible(true); // TODO: Show the "End 9 - Death" button after action
            hideOtherButtons(); // TODO: Hide other buttons to limit choices
        });

        threeButton.setOnAction(e -> {
            gameStatus.setText("You dodged their attack, went underneath the table, and rushed towards the door.\n" +
                    "You sense both Daniel the Dog and Rumble the Racoon and once you get to the door and open it, you do a 180 and splash water on them as your final ditch effort, and immediately close the door.\n" +
                    "It wasn’t even 6 AM yet, but you don’t care. You ran towards your car and drove away.");
            updateStats(); // TODO: Update stats after this action
            continueButton.setVisible(true); // TODO: Show the "Continue" button after successful dodge
            hideOtherButtons(); // TODO: Hide other buttons to limit choices
        });

        // Action for continueButton to transition to the next scene
        fourButton.setOnAction(e -> primaryStage.setScene(new fiveAttackWater(primaryStage).getScene())); // TODO: Update this action for the next scene
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene())); // TODO: Update this action to transition to the appropriate scene

        // Create the BorderPane layout for arranging elements on the screen
        BorderPane layout = new BorderPane();

        // Add game status text to the top of the layout
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically in the center of the layout
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, continueButton);

        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // Create the scene with the layout and set its size
        scene = new Scene(layout, 400, 400);
    }

    // Method to update the stats text on the screen
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness); // TODO: Update Conviction and Madness
    }

    // Helper method to hide the action buttons that are no longer needed
    private void hideOtherButtons() {
        oneButton.setVisible(false); // TODO: Hide the "Attack Daniel" button after action
        twoButton.setVisible(false); // TODO: Hide the "Attack Rumble" button after action
        threeButton.setVisible(false); // TODO: Hide the "Dodge" button after action
    }

    // Getter for the scene to switch between scenes
    public Scene getScene() {
        return scene; // TODO: Ensure the scene is updated as per new actions
    }
}
