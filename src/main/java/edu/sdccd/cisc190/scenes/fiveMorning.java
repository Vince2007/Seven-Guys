package edu.sdccd.cisc190.scenes;

import edu.sdccd.cisc190.altscenes.five1Morning;
import edu.sdccd.cisc190.generalstuff.ExitGame;
import edu.sdccd.cisc190.stats.GameState;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//TODO: Correct to 'FiveMorning'. For ALL classes, ensure that you are capitalizing every word, not camelCase.
public class fiveMorning {
    private Scene scene;
    private final Text gameStatus;
    private Text statsText;       // Text to display the stats

    public fiveMorning(Stage primaryStage) {
        // Initial game status text
        gameStatus = new Text("Numerous checks on the facility maps and notes from previous security guards left in the drawers, have informed you that the generators are inconveniently located on the Backstage, so you prepare your trip to get there.\n" +
                "You get your flashlight out and prepare to go backstage.\n" +
                "Once inside the backstage, minds set in; 50/50, hallucinations or reality? Are the animatronics real beings who can move on their own? Is it just you? You’re going crazy, insane even.\n" +
                "“I think that this place just sucks.”\n" +
                "[If the player chose Bottled Water in the previous hour]\n" +
                "But you remembered something…\n" +
                "Before going backstage, you remembered the water you took from the kitchen, deciding to bring some in preparation; found a dusty satchel on one of the drawers of the office desk and decided to put the bottles there to carry.\n" +
                "You think that the water will be effective soon.\n" +
                "But snap back, you still know that the power is still out and you need to do one thing, to go fix the generators and go straight back to the office.\n" +
                "You already made it through backstage, it’s a more eerie and undesirable place compared to the party-filled area of the Seven Guys.\n" +
                "You hear noises… loud noises…");
        gameStatus.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Text for displaying stats (conviction and madness)



        BorderPane layout = getBorderPane(primaryStage);

        // Scene creation with appropriate size
        scene = new Scene(layout, 400, 400);
    }

    //contain
    private BorderPane getBorderPane(Stage primaryStage) {
        Button oneButton = new Button("Investigate");
        oneButton.setStyle("-fx-font-size: 14px;");
        oneButton.setOnAction(e -> gameStatus.setText("Going towards the loud noise, you find that Daniel the Dog fell hard from Backstage.\n" +
                "You don’t care about the suspicion of the animatronics, you just want this to end.\n" +
                "You put Daniel the Dog back in place and decide to return to the Generator.\n" +
                "But you see that Rumble the Racoon wasn’t there, you turn back, and he’s behind you.\n" +
                "He attacks you."));
        oneButton.setOnAction(e -> primaryStage.setScene(new ExitGame(primaryStage).getScene()));

        Button twoButton = new Button("Go to the Generator");
        twoButton.setStyle("-fx-font-size: 14px;");
        twoButton.setOnAction(e -> primaryStage.setScene(new five1Morning(primaryStage).getScene()));

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add game status text to the top
        layout.setTop(gameStatus);

        // Add stats text below the game status text
        layout.setBottom(statsText);

        // Create a VBox to arrange buttons vertically
        VBox buttonBox = new VBox(10, oneButton, twoButton);

        // Set the VBox containing buttons to the center of the BorderPane
        layout.setCenter(buttonBox);
        return layout;
    }

    // TODO: Plug this method in a separate file and call it whenever you want to display user's conviction and madness stats
    public void updateStats() {
        statsText.setText("Conviction: " + GameState.getConviction() + " | Madness: " + GameState.getMadness());
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
