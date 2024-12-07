package edu.sdccd.cisc190.generalstuff;

import edu.sdccd.cisc190.stats.GameState;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class MainMenu {
    private final Scene scene;

    //TODO: Delete these because they wont be needed due to the instantiation below
    private int conviction; // stat for conviction
    private int madness;   // stat for madness

    public MainMenu(Stage primaryStage) {
        //TODO: Make the gameState object accessible across all scenes to maintain a total of these running stats
        GameState gameState = new GameState(0,0);

        // Create the buttons and description text
        Button startButton = new Button("Unlock the door (+1 conviction, +1 madness)");
        Button exitButton = new Button("Don't Unlock the door");

        /**
         * TODO: These texts should be broken down into smaller pieces so it looks better and is easier to read. Do this for all your wordy texts.
         * Description text split into smaller, logical sections
         */
        Text description1 = new Text("You’re the new guy working in Seven Guys, a local burger shop that, on the outside, is a fun and exciting place to eat at, filled with yummy food, a huge party stage with cool party rooms, and of course, the main attraction: The High Fives.\n\n");
        Text description2 = new Text("But behind closed doors, a different story appears. Debts haven't been paid, the kitchen has violated health codes, and signs of animatronics moving on their own suggest they’re being controlled by spirits. Maybe they’re linked to the disappearing workers lately…\n\n");
        Text description3 = new Text("With the new 'Security Computer Auto Machine' (or S.C.A.M. for short), they’re able to make sure everything is A-Ok! Standing in front of the Burger-plex, you realize you were never given a key to the place. 'Lazy managers,' you murmur as a note plastered on the back entrance reads:\n\n");
        Text description4 = new Text("'Yeah, we totally forgot to give you the key, it'll be under the rock!'\n\n");
        Text description5 = new Text("Groaning, you grab the key and prepare to open the door. Suddenly, the unexplainable urge to do nothing fills your mind. 'Is this a tutorial?' (Pick the options presented to make your choice. Choose wisely—well, in this case, you only have one option, but you know, don’t fall too deep~)\n");

        // Combine all parts into a TextFlow for proper wrapping
        TextFlow description = new TextFlow(description1, description2, description3, description4, description5);
        description.setTextAlignment(TextAlignment.JUSTIFY);
        description.setMaxWidth(680); // Ensure the text wraps within the scene width
        description.setStyle("-fx-font-size: 11px; -fx-font-weight: bold;");

        // Action for unlocking the door: Increase conviction and madness, then transition to PreLude scene
        startButton.setOnAction(e -> {

            //Not necessary to manually add to conviction and madness. Use the methods increaseConviction and increase madness from GameState class.
            gameState.increaseConviction();
            gameState.increaseMadness();

            /**
             * Pass conviction and madness to PreLude when transitioning
             * Call getConviction and getMadness from GameState Class whenever the return value is needed
              */

            PreLude preludeScene = new PreLude(primaryStage, gameState.getConviction(), gameState.getMadness());
            primaryStage.setScene(preludeScene.getScene());
        });

        // Action to exit the application
        exitButton.setOnAction(e -> primaryStage.close());

        // Create a text element to display stats
        Text stats = new Text("Conviction: " + gameState.getConviction() + " | Madness: " + gameState.getMadness());
        stats.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Set the description text at the top of the layout
        layout.setTop(description);

        // Set the buttons in the bottom region
        VBox buttonLayout = new VBox(10, startButton, exitButton);
        layout.setCenter(buttonLayout);

        //Center Text, Do for ALL scenes
        BorderPane.setAlignment(description, Pos.TOP_CENTER);

        // Set stats at the bottom of the layout
        layout.setBottom(stats);

        // Align buttons to center within the bottom region
        BorderPane.setAlignment(buttonLayout, javafx.geometry.Pos.CENTER);

        // Create the scene with the BorderPane layout
        //Change width to 700 for better readability and user experience
        scene = new Scene(layout, 700, 350);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
