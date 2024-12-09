package edu.sdccd.cisc190.generalstuff;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Manages the exit game confirmation screen.
 * Provides an option for users to confirm exiting the application.
 */
public class ExitGame {

    private Scene scene;
    private final Button exitButton;

    /**
     * Creates the ExitGame screen.
     *
     * @param primaryStage the primary stage for this application
     */
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
            showExitConfirmation(primaryStage);
        });

        // Create the BorderPane layout
        BorderPane layout = new BorderPane();
        layout.setTop(exitMessage);
        layout.setCenter(exitButton);

        // Create the scene with appropriate size
        scene = new Scene(layout, 300, 200);
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
            }
        });
    }

    // Getter for the scene
    public Scene getScene() {
        return scene;
    }
}
