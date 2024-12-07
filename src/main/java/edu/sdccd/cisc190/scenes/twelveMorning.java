package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class twelveMorning {
    private final Scene scene;
    private int conviction = 0;   // Variable to track the conviction stat
    private int madness = 0;      // Variable to track the madness stat
    private final Text gameStatus; // Text to display game status (storyline)
    private final Text statsText;  // Text to display the stats (conviction, madness)

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button continueButton;

    public twelveMorning(Stage primaryStage) {
        // TODO: Initialize game status text with the first part of the story
        gameStatus = new Text("You've been sitting in your office, playing Brawl Stars, " +
                "ignoring any work because there’s nothing to do besides staring at the ceiling, " +
                "lights on and off, and looking at the animatronics on the SCAM.\nThe clock struck midnight." +
                "\nIn the background, the SCAM flashes statics.\nThat’s important, probably.\n" +
                "Looking closer, your eyes opened wide realizing the stage was missing a person.\n" +
                "Wait... is one of them gone?\nLooking closer, you noticed Chica was gone.\n" +
                "Weird, what should you do?");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize the stats text, starting with default values (conviction = 0, madness = 0)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize buttons for player choices
        oneButton = new Button("Check the cameras (+1 conviction)");
        twoButton = new Button("Ignorance is bliss (+1 conviction, +1 madness)");
        threeButton = new Button("This place is crazy, leave");
        continueButton = new Button("Transition to 1 AM");

        // TODO: Set styles for the buttons to make them visually consistent
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // TODO: Initially hide the "Continue" button (it will only appear after a decision is made)
        continueButton.setVisible(false);

        // TODO: Add actions to each button that will change the game status, update stats, and hide/show buttons
        // Button action for oneButton (Check the cameras)
        oneButton.setOnAction(e -> {
            conviction++;  // Increase conviction stat
            gameStatus.setText("You’ve decided to check the cameras, from the nearby halls to adjacent rooms from the main stage.\n" +
                    "You find no trace of the missing animatronic, but you were more worried about how the management would react hearing about one of their mascots just disappearing.");
            updateStats();  // TODO: Update the stats text when this option is selected

            // Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        // Button action for twoButton (Ignorance is bliss)
        twoButton.setOnAction(e -> {
            conviction++;  // Increase conviction stat
            madness++;     // Increase madness stat
            gameStatus.setText("Whatever! The pay wasn’t good in the first place! Besides, you got more important things to do, such as getting that victory in Brawl Stars!\n" +
                    "You got up from your chair and cheered, but it was a short victory as you noticed the animatronic right behind you. *SLASH*");
            updateStats();  // TODO: Update the stats text when this option is selected

            // Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        // Button action for threeButton (Leave the place)
        threeButton.setOnAction(e -> {
            gameStatus.setText("This place is nuts!\nNo way you’re going to deal with something like this on a late evening, let alone on the FIRST HOUR.\n" +
                    "You prepare to ditch this job without a single care of what will happen next.");
            updateStats();  // TODO: Update the stats text when this option is selected

            // Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideOtherButtons();
        });

        // Action for continueButton to transition to the next scene (1 AM)
        continueButton.setOnAction(e -> primaryStage.setScene(new oneMorning(primaryStage).getScene()));

        // TODO: Create a BorderPane layout to arrange the elements on the screen
        BorderPane layout = new BorderPane();

        // TODO: Add game status text at the top of the layout
        layout.setTop(gameStatus);

        // TODO: Add stats text at the bottom of the layout
        layout.setBottom(statsText);

        // TODO: Add buttons to the layout, ensuring they are aligned properly
        BorderPane.setAlignment(oneButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(twoButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(threeButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(continueButton, javafx.geometry.Pos.CENTER);

        // TODO: Use a VBox to arrange buttons vertically in the center of the BorderPane
        VBox buttonLayout = new VBox(10, oneButton, twoButton, threeButton, continueButton);
        layout.setCenter(buttonLayout);

        // TODO: Create the scene with appropriate size (400x400)
        scene = new Scene(layout, 400, 400);  // Adjusted width for better appearance
    }

    // TODO: Method to update the stats text (conviction and madness)
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // TODO: Helper method to hide action buttons after one has been chosen
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
        threeButton.setVisible(false);
    }

    // TODO: Getter method to return the scene object for transition
    public Scene getScene() {
        return scene;
    }
}
