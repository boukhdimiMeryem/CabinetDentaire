package com.example.dentist;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SettingsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button manip_patient;

    @FXML
    private Button manip_patient2;

    @FXML
    private Button zoom;

    @FXML
    void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void goTypeIntervention(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("categorieIntervention.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 766);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goTypeRadio(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("TypeRadio.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 766);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    void manip_assistant(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    void manip_patient(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    public void overview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
