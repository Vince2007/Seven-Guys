package edu.sdccd.cisc190.altscenes;

import edu.sdccd.cisc190.generalstuff.ExitGame;
import edu.sdccd.cisc190.generalstuff.MainMenu;
import edu.sdccd.cisc190.scenes.fiveMorning;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class fiveAttackWaterMore {
    private Scene scene;
    private int conviction; // Track conviction stat
    private int madness; // Track madness stat
    private final Text gameStatus;
    private final Text statsText;
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button fourButton;
    private final Button fiveButton;
    private final Button sixButton;
    private final Button sevenButton;
    private final Button eightButton;
    private final Button continueButton; // Button for continuing the game

    public fiveAttackWaterMore(Stage primaryStage) {
        // TODO: Set up the initial game status text
        gameStatus = new Text("You know that you conserved your water usage...\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Set up the player stats text (Conviction, Madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize the buttons for gameplay options
        oneButton = new Button("Left");
        twoButton = new Button("Middle");
        threeButton = new Button("Right");
        fourButton = new Button("Attack with a water bottle (10% remaining)");
        fiveButton = new Button("Attack immediately");
        sixButton = new Button("Dodge attack");
        sevenButton = new Button("Continue");
        eightButton = new Button("Continue");
        continueButton = new Button("Transition to 6 AM");

        // TODO: Set initial visibility of some buttons
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
        eightButton.setVisible(false);
        continueButton.setVisible(false);

        // TODO: Action for the "Left" button (oneButton)
        oneButton.setOnAction(e -> {
            gameStatus.setText("You successfully dodged Daniel the Dog’s attack...\n");
            updateStats(); // Update the stats text

            // TODO: Show additional buttons for more choices
            fourButton.setVisible(true);
            fiveButton.setVisible(true);
            sixButton.setVisible(true);
            hideOtherButtons(); // Hide the irrelevant buttons
        });

        // TODO: Action for the "Middle" button (twoButton)
        twoButton.setOnAction(e -> {
            gameStatus.setText("You were attacked…");
            updateStats(); // Update the stats text

            // TODO: Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            hideOtherButtons(); // Hide buttons not needed anymore
        });

        // TODO: Action for the "Right" button (threeButton)
        threeButton.setOnAction(e -> {
            gameStatus.setText("You were attacked…");
            updateStats(); // Update the stats text

            // TODO: Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            hideOtherButtons(); // Hide buttons not needed anymore
        });

        // TODO: Action for the "Attack with a water bottle" button (fourButton)
        fourButton.setOnAction(e -> {
            gameStatus.setText("An unexpected move, Rumble was splashed with water...\n");
            updateStats(); // Update the stats text

            // TODO: Show the continue button and hide other buttons
            continueButton.setVisible(true);
            hideMoreButtons(); // Hide buttons after choice is made
        });

        // TODO: Action for the "Attack immediately" button (fiveButton)
        fiveButton.setOnAction(e -> {
            gameStatus.setText("He noticed your selflessness...\n");
            updateStats(); // Update the stats text

            // TODO: Show the continue button and hide other buttons
            sevenButton.setVisible(true);
            hideMoreButtons(); // Hide buttons after choice is made
        });

        // TODO: Action for the "Dodge attack" button (sixButton)
        sixButton.setOnAction(e -> {
            updateStats(); // Update the stats text

            // TODO: Show the continue button and hide other buttons
            eightButton.setVisible(true);
            hideMoreButtons(); // Hide buttons after choice is made
        });

        // TODO: Action for the "Continue" button (sevenButton)
        sevenButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        // TODO: Action for the "Continue" button (eightButton)
        eightButton.setOnAction(e -> primaryStage.setScene(new theFight(primaryStage).getScene()));

        // TODO: Action for the "Transition to 6 AM" button
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        // TODO: Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // TODO: Add game status text to the top
        layout.setTop(gameStatus);

        // TODO: Add stats text below the game status text
        layout.setBottom(statsText);

        // TODO: Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, continueButton);

        // TODO: Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // TODO: Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);
    }

    // TODO: Method to update the stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // TODO: Hide the irrelevant buttons after a choice is made
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
        threeButton.setVisible(false);
    }

    // TODO: Hide additional buttons after a choice is made
    private void hideMoreButtons() {
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
    }

    // TODO: Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
