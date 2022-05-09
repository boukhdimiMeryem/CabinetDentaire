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

public class TypeRadioController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<TypeRadio, String> DescCol;

    @FXML
    private TextField Description;

    @FXML
    private TableColumn<TypeRadio, Integer> IDTRCol;

    @FXML
    private TextField IDTypeR;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button manip_patient2;

    @FXML
    private TableColumn<TypeRadio, String> nomTypeCol;

    @FXML
    private TextField nomTypeR;

    @FXML
    private TableView<TypeRadio> tableView;

    @FXML
    private Button zoom;



    @FXML
    void afficher(ActionEvent event) {

    }

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void close(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void manip_assistant(ActionEvent event) {

    }

    @FXML
    void manip_patient(ActionEvent event) {

    }

    @FXML
    void overview(ActionEvent event) {

    }

    @FXML
    void saveToFile(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

}

