package theAlleyPOS.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerTimeClock {
    @FXML
    private Button managerClockInButton;
    @FXML
    private Button managerBreakInButton;
    @FXML
    private Button managerClockOutButton;
    @FXML
    private Button managerBreakOutButton;
    @FXML
    private Button managerInventoryButton;
    @FXML
    private Button managerAnalyticsButton;

    @FXML
    public void handleManagerClockInOut(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "Clock In":
                // Takes user to item selection screen
                loadItemSelectionScreen(actionEvent);
                break;

            case "Clock Out":
                // Takes user back to login screen
                loadLoginScreen(actionEvent);
                break;
        }
    }

    @FXML
    public void handleManagerBreakInOut(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        String buttonText = clickedButton.getText();

        switch (buttonText) {
            case "Break In":
                // Takes user to item selection screen
                loadItemSelectionScreen(actionEvent);
                break;

            case "Break Out":
                // Takes user back to login screen
                loadLoginScreen(actionEvent);
                break;
        }
    }

    @FXML
    public void handleManagerInventoryAction(ActionEvent actionEvent) {
        loadInventoryScreen(actionEvent);
    }

    @FXML
    public void handleManagerAnalyticsAction(ActionEvent actionEvent) {
        loadAnalyticsScreen(actionEvent);
    }

    private void loadLoginScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/Login.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage using any of the controls
            Stage currentStage = (Stage) managerClockInButton.getScene().getWindow();

            // Set the scene to the stage
            currentStage.setScene(loginScene);
        } catch (IOException e) {
            System.out.println("Failed to load login screen.");
            e.printStackTrace();
        }
    }

    private void loadAnalyticsScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/Analytics.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage using any of the controls
            Stage currentStage = (Stage) managerAnalyticsButton.getScene().getWindow();

            // Set the scene to the stage
            currentStage.setScene(loginScene);
        } catch (IOException e) {
            System.out.println("Failed to load analytics screen.");
            e.printStackTrace();
        }
    }

    private void loadItemSelectionScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/ItemSelection.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage using any of the controls
            Stage currentStage = (Stage) managerClockInButton.getScene().getWindow();

            // Set the scene to the stage
            currentStage.setScene(loginScene);
        } catch (IOException e) {
            System.out.println("Failed to load item selection screen.");
            e.printStackTrace();
        }
    }

    private void loadInventoryScreen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/theAlleyPOS/Inventory.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage using any of the controls
            Stage currentStage = (Stage) managerInventoryButton.getScene().getWindow();

            // Set the scene to the stage
            currentStage.setScene(loginScene);
        } catch (IOException e) {
            System.out.println("Failed to load inventory screen.");
            e.printStackTrace();
        }
    }
}