package edu.sdccd.cisc190.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class fourMorning {
    private Scene scene;
    private int conviction; // Variable to track the conviction stat
    private int madness; // Variable to track the madness stat
    private final Text gameStatus;
    private final Text statsText;       // Text to display the stats

    // Declare buttons as instance variables to use them in different methods
    private final Button oneButton;
    private final Button twoButton;
    private final Button threeButton;
    private final Button fourButton;
    private final Button fiveButton;
    private final Button sixButton;
    private final Button sevenButton;
    private final Button eightButton;
    private final Button nineButton;
    private final Button continueButton;

    public fourMorning(Stage primaryStage) {
        // TODO: Set up the initial game status message to describe the situation.
        gameStatus = new Text("Back in your room, SCAM, running in the back.\n" +
                "With your better judgment, you close the doors, leaving to drain you of your precious power.\n" +
                "But safe… for now. You wanna go home? You didn’t sign up for this. Killer animatronics. How original.\n" +
                "\n" +
                "Now being aware of the dangers that await.\n" +
                "You’re… paranoid. What dangers await you? What lies ahead? More text? More ways to die?\n" +
                "You seem to need a well-deserved break, so you decide to go to the kitchen and check on any foods to eat while at it. " +
                "\nSomehow the walk there was peaceful enough.\n" +
                "Any pizza? Any drinks? Anything to fuel up to at least make me calm. However, more noises come your way while you try to reach for some food.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Set up the stats text to display Conviction and Madness.
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Initialize buttons for user actions.
        oneButton = new Button("Kitchen time");
        twoButton = new Button("Investigate");
        threeButton = new Button("Bottle of water");
        fourButton = new Button("Cold Pizza");
        fiveButton = new Button("Rotten Cheese");
        sixButton = new Button("Investigate");
        sevenButton = new Button("Go Back");
        eightButton = new Button("Investigate");
        nineButton = new Button("Go Back");
        continueButton = new Button("Transition to 5 AM");

        // TODO: Style buttons to maintain consistent design.
        oneButton.setStyle("-fx-font-size: 14px;");
        twoButton.setStyle("-fx-font-size: 14px;");
        threeButton.setStyle("-fx-font-size: 14px;");
        fourButton.setStyle("-fx-font-size: 14px;");
        fiveButton.setStyle("-fx-font-size: 14px;");
        sixButton.setStyle("-fx-font-size: 14px;");
        sevenButton.setStyle("-fx-font-size: 14px;");
        eightButton.setStyle("-fx-font-size: 14px;");
        nineButton.setStyle("-fx-font-size: 14px;");
        continueButton.setStyle("-fx-font-size: 14px;");

        // TODO: Set visibility of buttons initially
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
        eightButton.setVisible(false);
        nineButton.setVisible(false);
        continueButton.setVisible(false);

        // TODO: Set actions for buttons.
        // Action for "Kitchen time" button
        oneButton.setOnAction(e -> {
            gameStatus.setText("Deciding that the noise is just some random object that is DEFINITELY not part of the noise from the restroom earlier, a need to go to the kitchen seems like the most reasonable choice for you and your break.\n" +
                    "\n" +
                    "You check on the fridge, the fridge contains a bottle of water, cold left-over pizzas, and some rotten cheese. \n" +
                    "\n" +
                    "What’s your poison?\n");
            updateStats();  // TODO: Update stats after making a choice

            // Show the continue button and hide other buttons
            threeButton.setVisible(true);
            fourButton.setVisible(true);
            fiveButton.setVisible(true);
            hideOtherButtons();  // TODO: Hide other irrelevant buttons
        });

        // Action for "Investigate" button
        twoButton.setOnAction(e -> {
            gameStatus.setText("You go out to the party area, just empty tables, where party hats are just sitting there.\n" +
                    "You realize the sound was just some more fallen objects (coincidence).\n" +
                    "This object was just a Janitor Cart left at the party area just falling over, unfortunately, the Janitor Cart was full of water, so you have no choice but to clean the water up.\n" +
                    "Using the mop from the Janitor Cart that was also fallen, you use the water, to at least clean the entirety of the Party Area floor, because you’re a good worker.\n" +
                    "Thinking that you just did an outstanding job cleaning the floor of the Party Area, you should go back to the office. Having the best time of your life…\n" +
                    "You hear something. The worst part is that you see IT moving. It looks like… Ozzy the Ostrich\n" +
                    "Are you seeing animatronics moving? You want to go back to your office, but in times like this, you must go for an investigation…\n");
            updateStats();  // TODO: Update stats after this decision

            // Show the continue button and hide other buttons
            eightButton.setVisible(true);
            nineButton.setVisible(true);
            hideOtherButtons();  // TODO: Hide irrelevant buttons
        });

        // Action for other buttons like "Bottle of water", "Cold Pizza", etc.
        // TODO: Add actions for the remaining buttons similar to above.

        // Action for continueButton to transition to next scene
        continueButton.setOnAction(e -> primaryStage.setScene(new fiveMorning(primaryStage).getScene()));  // TODO: Make sure this transitions correctly to the next scene.

        // TODO: Create the BorderPane layout for the scene
        BorderPane layout = new BorderPane();

        // TODO: Add game status text to the top of the layout
        layout.setTop(gameStatus);

        // TODO: Add stats text below the game status text in the layout
        layout.setBottom(statsText);

        // TODO: Create a VBox layout for the buttons vertically
        VBox buttonBox = new VBox(10);  // 10px spacing between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, continueButton);

        // TODO: Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);

        // TODO: Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);
    }

    // TODO: Method to update the stats text dynamically based on the player's actions
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness);
    }

    // TODO: Helper method to hide buttons when not needed.
    private void hideOtherButtons() {
        oneButton.setVisible(false);
        twoButton.setVisible(false);
    }

    // TODO: Helper method to hide more buttons when progressing in the game.
    private void hideMoreButtons() {
        threeButton.setVisible(false);
        fourButton.setVisible(false);
        fiveButton.setVisible(false);
        eightButton.setVisible(false);
        nineButton.setVisible(false);
    }

    // TODO: Helper method to hide even more buttons as the game progresses
    private void hideEvenMoreButtons() {
        sixButton.setVisible(false);
        sevenButton.setVisible(false);
    }

    // TODO: Getter method for the scene to be used in other classes
    public Scene getScene() {
        return scene;
    }
}
