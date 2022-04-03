package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AssistantList {



    @FXML
    private Button add_pat_btn_option;

    @FXML
    private Button logout;

    @FXML
    private Button refresh;

    @FXML
    private Button switch_add_patient;


    private Parent root;

    @FXML
    public void switch_add_Assistant(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ADD_Patient.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root, 362, 267);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("ajouter un Assistant");
        stage.setScene(scene);
        stage.show();
    }

    public void refresh(ActionEvent event) {
    }

    public void add_Patient(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 766, 515);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("ajouter un patient");
        stage.setScene(scene);
        stage.show();
    }

    public void switch_acceuil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 766, 515);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Acceuil");
        stage.setScene(scene);
        stage.show();
    }
}
