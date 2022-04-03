package com.example.dentist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource("authentification.fxml"));
        Scene scene = new Scene(root.load(), 766, 515);
        stage.setTitle("Dental Application");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}