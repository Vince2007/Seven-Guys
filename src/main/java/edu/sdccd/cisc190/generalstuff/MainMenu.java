package edu.sdccd.cisc190.generalstuff;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
    private final Scene scene;
    private int conviction; // stat for conviction
    private int madness;   // stat for madness
    
// TODO: Explain that this button increases the conviction and madness stats, and then moves the player to the next scene (PreLude).
    public MainMenu(Stage primaryStage) {
        conviction = 0;  // Initial conviction
        madness = 0;     // Initial madness

        // Create the buttons and description text
        Button startButton = new Button("Unlock the door (+1 conviction, +1 madness)");
        Button exitButton = new Button("Don't Unlock the door");

        Text description = new Text("You’re the new guy working in Seven Guys, a local burger shop that on the outside, is a fun and exciting place to eat at, " +
                "filled with yummy food and a huge-ass party stage with cool party rooms, and of course, " +
                "the main attraction: The High Fives. But behind closed doors, a different story appears.\n" +
                "Debts haven't been paid, the kitchen has violated a bunch of health codes and laws, " +
                "and signs of the animatronics… moving on their own, like they’re being controlled by spirits. " +
                "Maybe they’re linked to the disappearing workers lately… " +
                "But hey! with the new “Security Computer Auto Machine” (or S.C.A.M for short), " +
                "they’re able to make sure everything is A-Ok!\nStanding in front of the Burger-plex. " +
                "You realize you were never given a key to the place. " +
                "“Lazy managers” you murmured as a note was plastered onto the back entrance.\n" +
                "“Yeah we totally forgot to give you the key, it'll be under the rock!”\n" +
                "Groaning you grab the key from under the rock and prepare to open the door. " +
                "Suddenly, the unexplainable urge to do nothing was filling your mind. " +
                "“Is this a tutorial?” (Pick the options presented to make your choice, choose wisely, well in this case you only have one but, you know, don’t fall too deep~)\n");
        description.setStyle("-fx-font-size: 9px; -fx-font-weight: bold;");

        // Action for unlocking the door: Increase conviction and madness, then transition to PreLude scene
        startButton.setOnAction(e -> {
            conviction += 1;  // Increase conviction
            madness += 1;     // Increase madness

            // Pass conviction and madness to PreLude when transitioning
            // TODO: Make sure the PreLude class handles the passed data (conviction and madness).
            PreLude preludeScene = new PreLude(primaryStage, conviction, madness);
            primaryStage.setScene(preludeScene.getScene());
        });

        // Action to exit the application
        exitButton.setOnAction(e -> primaryStage.close());

        // Create a text element to display stats
        Text stats = new Text("Conviction: " + conviction + " | Madness: " + madness);
        stats.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Set the description text at the top of the layout
        layout.setTop(description);

        // Set the buttons in the bottom region
        VBox buttonLayout = new VBox(10, startButton, exitButton);
        layout.setCenter(buttonLayout);

        // Set stats at the bottom of the layout
        layout.setBottom(stats);

        // Align buttons to center within the bottom region
        BorderPane.setAlignment(buttonLayout, javafx.geometry.Pos.CENTER);

        // Create the scene with the BorderPane layout
        // TODO: Think about using a larger or smaller default scene size for better display on various devices the game can manage. 
        scene = new Scene(layout, 300, 400);
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
