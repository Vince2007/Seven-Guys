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

public class fiveAttackWater {
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
    private final Button continueButton; // Button for next actions

    public fiveAttackWater(Stage primaryStage) {
        // Show game status when the scene starts
        gameStatus = new Text("You attacked Mika the Monkey by splashing water...\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Set up player stats text (Conviction and Madness)
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize buttons for different choices
        oneButton = new Button("Attack with water (25% remaining)");
        twoButton = new Button("Dodge attack");
        threeButton = new Button("Left");
        fourButton = new Button("Middle");
        fiveButton = new Button("Right");
        sixButton = new Button("Continue");
        sevenButton = new Button("Endings");
        continueButton = new Button("Transition to 6 AM");

        // TODO: Set buttons to not visible at first
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
        continueButton.setVisible(false);

        // TODO: Action for "Attack with water" button
        oneButton.setOnAction(e -> {
            updateStats();  // Update stats after action

            sixButton.setVisible(true); // Show "Continue" button
            hideOtherButtons(); // Hide other buttons
        });

        // TODO: Action for "Dodge attack" button
        twoButton.setOnAction(e -> {
            gameStatus.setText("You slid under Ozzy the Ostrich...\n");
            updateStats();  // Update stats

            // TODO: Show more options
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            fiveButton.setVisible(true);

            hideOtherButtons(); // Hide the first two buttons
        });

        // TODO: Action for "Left" button
        threeButton.setOnAction(e -> {
            gameStatus.setText("You dodged the attack...\n");
            updateStats();  // Update stats

            continueButton.setVisible(true); // Show "Continue" button
            hideMoreButtons(); // Hide other buttons
        });

        // TODO: Action for "Middle" button
        fourButton.setOnAction(e -> {
            gameStatus.setText("You were attacked...\n");
            updateStats();  // Update stats

            sevenButton.setVisible(true); // Show "Endings" button
            hideMoreButtons(); // Hide other buttons
        });

        // TODO: Action for "Right" button
        fiveButton.setOnAction(e -> {
            gameStatus.setText("You successfully dodged the attack...\n");
            updateStats();  // Update stats

            continueButton.setVisible(true); // Show "Continue" button
            hideMoreButtons(); // Hide other buttons
        });

        // TODO: Action for "Continue" button (next scene)
        sixButton.setOnAction(e -> primaryStage.setScene(new fiveAttackWaterMore(primaryStage).getScene()));
        sevenButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));
        continueButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        // TODO: Create layout for the scene
        BorderPane layout = new BorderPane();

        layout.setTop(gameStatus); // Add status text to the top
        layout.setBottom(statsText); // Add stats text to the bottom

        // TODO: Arrange buttons vertically
        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, continueButton);

        layout.setCenter(buttonBox); // Place buttons in the center

        // TODO: Create the scene
        scene = new Scene(layout, 400, 400);
    }

    // TODO: Method to update player stats text
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // TODO: Hide unnecessary buttons after an option is selected
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
    }

    // TODO: Hide extra buttons after a choice is made
    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
    }

    // TODO: Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
