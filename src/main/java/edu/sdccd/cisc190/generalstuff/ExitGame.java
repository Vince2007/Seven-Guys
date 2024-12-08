package edu.sdccd.cisc190.generalstuff;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExitGame {

    private Scene scene;
    private final Button exitButton;

    public ExitGame(Stage primaryStage) {
        // Exit message text
        Text exitMessage = new Text("Are you sure you want to quit the game?");
        exitMessage.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create an exit button
        exitButton = new Button("Exit Game");
        exitButton.setStyle("-fx-font-size: 14px;");

        // Exit button action
        exitButton.setOnAction(e -> {
            // Show confirmation alert before exiting
            showExitConfirmation(primaryStage); // TODO: Ensure that this method properly handles the stage
        });

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();
        layout.setTop(exitMessage); // TODO: Ensure text layout looks good for different screen sizes
        layout.setCenter(exitButton); // TODO: Ensure button is centered properly

        // Create the scene with appropriate size
        scene = new Scene(layout, 300, 200); // TODO: Adjust scene size if needed for better UX
    }

    // Method to display a confirmation dialog
    private void showExitConfirmation(Stage primaryStage) {
        Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Exit Confirmation");
        confirmationDialog.setHeaderText("Are you sure you want to exit the game?");
        confirmationDialog.setContentText("Click OK to exit or Cancel to go back.");

        // Handle user response
        confirmationDialog.showAndWait().ifPresent(response -> {
            if (response.getText().equals("OK")) {
                Platform.exit();  // Exit the game
            } else {
                // TODO: Handle the case where the user cancels the exit
                // Perhaps close the confirmation dialog or restore focus to the primary stage
            }
        });
    }

    // Getter for the scene
    public Scene getScene() {
        return scene; // TODO: Consider any edge cases where the scene might need to be reset
    }
}
