package edu.sdccd.cisc190.generalstuff;

import edu.sdccd.cisc190.scenes.twelveMorning;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PreLude {
    private Scene scene;

    // Constructor to accept conviction and madness
    public PreLude(Stage primaryStage, int conviction, int madness) {
        // Create the game status text
        //TODO: BREAKUP TEXT OR USE TRIPLE QUOTATION MARKS FOR ALL YOUR LONG TEXTS. In this way, you can split your text up into smaller chunks instead of using newline characters
        Text gameStatus = new Text("What was that? Did the stat points that should be appearing on a “screen” increase. " +
                "Apparently, everything you do is judge. Of Judgey devs. Huh what did we do-.\n" +
                "“Whatever, I can do this” you say anxiously of the sanity meter that is also there.\n" +
                "“But we'll probably avoid getting that meter down to 0. Just a thought”\n" +
                "(We won’t tell the nightguard this but, you’ll die. Don’t do dumb sounding stuff and you won’t die. " +
                "I mean unless you want to :p)\nHere you are, sitting in your new office. " +
                "There’s the door to the main stage on your left, a table filled with monitors of the different cameras around the restaurant, " +
                "a fan on top that barely works, and of course, a flashlight and a badge on your moldy chair " +
                "that you’re sure hasn’t been cleaned in weeks… you have a bad feeling about this. How… cliche.\n");
        gameStatus.setStyle("-fx-font-size: 9px; -fx-font-weight: bold;");

        //TODO: ensure that the text wraps inside the layout. Do this for all your long texts
        gameStatus.setWrappingWidth(200);


        // Create the display for stats (Conviction and Madness)
        Text statsText = new Text("Conviction: " + conviction + " | Madness: " + madness);
        statsText.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create the action button
        Button actionButton = new Button("Feeling a little 12AM?");
        actionButton.setStyle("-fx-font-size: 14px;");
        actionButton.setOnAction(e -> primaryStage.setScene(new twelveMorning(primaryStage).getScene()));

        // Set up the BorderPane layout
        BorderPane layout = new BorderPane();

        // Add the gameStatus text to the top of the BorderPane
        layout.setTop(gameStatus);

        // Add the statsText below the gameStatus
        layout.setBottom(statsText);

        // Add the actionButton to the center of the BorderPane
        VBox buttonLayout = new VBox(10, actionButton);
        layout.setCenter(buttonLayout);

        //TODO: Center alignment for narrative text. Do this for all windows.
        BorderPane.setAlignment(gameStatus, Pos.TOP_CENTER);

        // Create the scene with the layout and set the preferred size
        scene = new Scene(layout, 300, 400);
    }

    public PreLude(Stage primaryStage) {
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
