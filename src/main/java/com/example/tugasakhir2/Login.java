package com.example.tugasakhir2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Login  extends Application {

    private String adminUsername = "admin";
    private String adminPassword = "admin";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 0);

        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        grid.add(hbBtn, 1, 2);

        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Form Error!", "Please enter your username and password");
                return;
            }

            if (adminUsername.equals(username) && adminPassword.equals(password)) {
                infoBox("Login Successful!", null, "Success");
            } else {
                infoBox("Please enter correct username and password", null, "Failed");
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}