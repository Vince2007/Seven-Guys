package edu.sdccd.cisc190.generalstuff;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {
    private Scene scene;

    public MainMenu(Stage primaryStage) {
        Button startButton = new Button("Unlock the door (+1 conviction, +1 madness)");
        Button exitButton = new Button("Don't Unlock the door");

        Text description = new Text("You’re the new guy working in Seven Guys, a local burger shop that on the outside, is a fun and exciting place to eat at, filled with yummy food and a huge-ass party stage with cool party rooms, and of course, the main attraction: The High Fives. But behind closed doors, a different story appears.\nDebts haven't been paid, the kitchen has violated a bunch of health codes and laws, and signs of the animatronics… moving on their own, like they’re being controlled by spirits. Maybe they’re linked to the disappearing workers lately… But hey! with the new “Security Computer Auto Machine” (or S.C.A.M for short), they’re able to make sure everything is A-Ok!\nStanding in front of the Burger-plex. You realize you were never given a key to the place. “Lazy managers” you murmured as a note was plastered onto the back entrance.\n“Yeah we totally forgot to give you the key, it'll be under the rock!”\nGroaning you grab the key from under the rock and prepare to open the door. Suddenly, the unexplainable urge to do nothing was filling your mind. “Is this a tutorial?” (Pick the options presented to make your choice, choose wisely, well in this case you only have one but, you know, don’t fall too deep~)\n");
        description.setStyle("-fx-font-size: 9px;");

        startButton.setOnAction(e -> primaryStage.setScene(new PreLude(primaryStage).getScene()));
        exitButton.setOnAction(e -> primaryStage.close());

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();

        // Set the description text in the center
        layout.setTop(description);

        // Set the buttons in the bottom
        BorderPane.setAlignment(startButton, javafx.geometry.Pos.CENTER);
        BorderPane.setAlignment(exitButton, javafx.geometry.Pos.CENTER);

        // Create a VBox to hold the buttons at the bottom
        VBox buttonLayout = new VBox(10, startButton, exitButton);
        layout.setCenter(buttonLayout);

        // Create the scene with the BorderPane layout
        scene = new Scene(layout, 300, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
