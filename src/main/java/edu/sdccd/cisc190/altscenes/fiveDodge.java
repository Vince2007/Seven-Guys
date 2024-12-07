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
    private int conviction; // This keeps track of how determined you are
    private int madness; // This keeps track of how crazy you're getting
    private final Text gameStatus;
    private final Text statsText;       // This shows the current stats

    public fiveDodge(Stage primaryStage) {
        // TODO: Set up the first text you see when you enter the scene
        gameStatus = new Text("You successfully dodged the attack and you closed the door...\n" +
                "However, Mika the Monkey is smart, and she decides to turn the power back off.\n" +
                "“I should’ve used the water when necessary…”, but at least she’s locked inside.\n" +
                "“I don’t think the office is a good idea, the better idea is to get the hell out of here.”\n" +
                "Turning on the flashlight, you immediately see Ozzy the Ostrich running towards you, and he’s running towards you fast.\n");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Set up the second text at the bottom that shows the stats
        statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // TODO: Create button 1 ("Attack with water bottle") and make it work
        Button oneButton = new Button("Attack with a water bottle (50% remaining)");
        oneButton.setStyle("-fx-font-size: 14px;"); // Button looks bigger
        oneButton.setOnAction(e -> primaryStage.setScene(new fiveDodge1(primaryStage).getScene())); // When pressed, move to the next scene

        // TODO: Create button 2 ("Dodge attack") and make it work
        Button twoButton = new Button("Dodge attack");
        twoButton.setStyle("-fx-font-size: 14px;"); // Button looks bigger
        // TODO: Make the game status change when you press this button
        twoButton.setOnAction(e -> gameStatus.setText("You slid under Ozzy the Ostrich and you ran as fast as you could...\n" +
                "You ran towards the main entrance/exit of the Seven Guys, however, the door won’t budge.\n" +
                "And it’s too late, Ozzy the Ostrich caught up to you."));
        twoButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene())); // If caught, the game ends

        // TODO: Create the layout (the main thing that holds everything)
        BorderPane layout = new BorderPane();

        // TODO: Put the game status at the top of the layout
        layout.setTop(gameStatus);

        // TODO: Put the stats at the bottom of the layout
        layout.setBottom(statsText);

        // TODO: Create a box to hold the buttons, so they are lined up
        VBox buttonBox = new VBox(10);  // 10px space between buttons
        buttonBox.getChildren().addAll(oneButton, twoButton); // Add buttons to the box

        // TODO: Put the buttons in the middle of the screen
        layout.setCenter(buttonBox);

        // TODO: Create the scene, this is what we see on screen
        scene = new Scene(layout, 400, 400);
    }

    // TODO: Method to update the stats if needed
    private void updateStats() {
        statsText.setText("Conviction: " + conviction + " | Madness: " + madness); // Update stats display
    }

    // TODO: Make a method that lets us get the scene (so we can show it on the screen)
    public Scene getScene() {
        return scene;
    }
}
