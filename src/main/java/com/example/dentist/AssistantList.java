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

    public void switchh(ActionEvent event,String file, int width , int heigth , boolean isNewStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource(file));
        Stage stage;
        if(isNewStage==true) stage = new Stage();
        else stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, width, heigth);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void switch_add_Assistant(ActionEvent event) throws IOException {
        switchh(event,"ADD_Patient.fxml",362,267,true);
    }
    @FXML
    public void Overview(ActionEvent event) throws IOException {
        switchh(event,"acceuil.fxml",1024,700,false);
    }
    @FXML
    public void manip_patient(ActionEvent event) throws IOException {
        switchh(event,"Patient_List.fxml",1024,700,false);
    }
    @FXML
    public void logout(ActionEvent event) throws IOException {
        switchh(event,"authentification.fxml",1024,700,false);
    }

    @FXML
    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
