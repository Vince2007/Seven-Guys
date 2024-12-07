package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class oneMorning {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus; // Text to display game status (storyline)
    private final Text statsText; // Text to display the stats (conviction, madness)

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button fourButton;
    private final Button fiveButton;
    private final Button sixButton;
    private final Button continueButton;

    public oneMorning(Stage primaryStage) {
        // TODO: Initialize game status text with the first part of the story
        gameStatus = new Text("All that excitement, and you’re still bored. " +
                "Back again scrolling through your phone, bored out of your mind, totally doing your job...\n" +
                "After the hour’s… quirky encounters? You’re pretty good. Did you have a choice?\n" +
                "No. Ironic, a game like this doesn’t give you the cho- anyways...\n" +
                "The manager of the place shoved a big old note right on the SCAM...\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize the stats text, starting with default values (conviction = 0, madness = 0)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize buttons that represent player choices
        oneButton = new Button("Actually do your job");
        twoButton = new Button("Procrastinating is nice...");
        threeButton = new Button("Hide under the tables (+1 conviction)");
        fourButton = new Button("Hide behind the arcade machines (+1 madness)");
        fiveButton = new Button("Run out (boom animatronic scares you outside but doesn’t catch you… yet adds madness)");
        sixButton = new Button("Look for other way out (leads you into a vent finding a news paper gaining conviction)");
        continueButton = new Button("Transition to 4 AM");

        // TODO: Set styles for buttons to make them look better (font size)
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        fiveButton.setStyle("-fx-font-size: 14px;");
        sixButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // TODO: Initially hide certain buttons until certain actions are taken
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        continueButton.setVisible(false);

        // TODO: Add event handlers to buttons to change the game state (e.g., update game status and stats)

        // Button actions for oneButton (Actually do your job)
        oneButton.setOnAction(e -> {
            gameStatus.setText("Good choice. Before heading off you check the cameras in case anything nefarious was going on… Nothing.\n" +
                    "You head off into the dining area but as you look onto the stage, something was obviously wrong. Missing, for sure you knew...\n" +
                    "Ozzy and Daniel were gone.\n" +
                    "The dining area has an arcade nearby, chairs too.\n" +
                    "Hiding under the tables seems nicer… and what is that… a piece of newspaper?\n");
            updateStats();  // TODO: Update the stats text when this option is selected

            // TODO: Show additional choices and hide others
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            hideOtherButtons();
        });

        // Button actions for twoButton (Procrastinating is nice...)
        twoButton.setOnAction(e -> {
            madness++; // TODO: Increase madness stat when procrastinating
            gameStatus.setText("Something, maybe you actually make it to the bathrooms...\n" +
                    "You looked around for anything interesting, finding some graffiti and doodles...\n" +
                    "Picked up some cleaning supplies, and wiped off any signs of the graffiti...\n");
            updateStats();  // TODO: Update the stats text with new madness value

            // TODO: Show additional choices and hide others
            fiveButton.setVisible(true);
            sixButton.setVisible(true);
            hideOtherButtons();
        });

        // Button actions for threeButton (Hide under the tables)
        threeButton.setOnAction(e -> {
            conviction++; // TODO: Increase conviction stat for hiding under the tables
            gameStatus.setText("Quickly crawling under the table, you wait in silence... Anxiously, you grab the newspaper and read it.\n" +
                    "October 12, 20XX - DISAPPEARANCE NOTICES\n" +
                    "\tRecently, two security guards have been missing after working at Seven Guys...\n");
            updateStats();  // TODO: Update the stats text with new conviction value

            // TODO: Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Button actions for fourButton (Hide behind arcade machines)
        fourButton.setOnAction(e -> {
            madness++; // TODO: Increase madness stat for hiding behind arcade machines
            gameStatus.setText("SO MANY SPIDERS. The animatronic may have passed but your mind didn’t.\n" +
                    "After that fiasco you finally arrive in the bathrooms.\n");
            updateStats();  // TODO: Update the stats text with new madness value

            // TODO: Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Button actions for fiveButton (Run out)
        fiveButton.setOnAction(e -> {
            madness++; // TODO: Increase madness stat for running out
            updateStats();  // TODO: Update the stats text with new madness value

            // TODO: Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Button actions for sixButton (Look for other way out)
        sixButton.setOnAction(e -> {
            conviction++; // TODO: Increase conviction stat for looking for another way out
            updateStats();  // TODO: Update the stats text with new conviction value

            // TODO: Show the continue button and hide other choices
            continueButton.setVisible(true);
            hideMoreButtons();
        });

        // Action for continueButton to transition to next scene (4 AM)
        continueButton.setOnAction(e -> primaryStage.setScene(new fourMorning(primaryStage).getScene()));

        // TODO: Create layout with BorderPane
        BorderPane layout = new BorderPane();

        // TODO: Add game status text at the top of the layout
        layout.setTop(gameStatus);

        // TODO: Add stats text at the bottom of the layout
        layout.setBottom(statsText);

        // TODO: Create VBox to arrange buttons vertically and add them to the layout
        VBox buttonBox = new VBox(10, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, continueButton);
        layout.setCenter(buttonBox);

        // TODO: Create the scene with a specific size (400x400)
        scene = new Scene(layout, 400, 400);
    }

    // TODO: Method to update the stats text (conviction and madness)
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // TODO: Helper method to hide specific buttons after choice (e.g., after a button press)
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
    }

    // TODO: Helper method to hide additional buttons after making a selection
    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
    }

    // TODO: Getter method to return the scene object
    public Scene getScene() {
        return scene;
    }
}
