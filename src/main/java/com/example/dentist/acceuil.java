package com.example.dentist;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class acceuil {
    Parent root ;
    Stage stage;
    Scene scene;

    public void manip_patient(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,766,515);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    public void manip_assistant(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,766,515);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }
}
