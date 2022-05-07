package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AcceuilAss implements Initializable {
    @FXML
    private AnchorPane  Friday;

    @FXML
    private AnchorPane Monday;

    @FXML
    private AnchorPane Saturday;

    @FXML
    private AnchorPane Thursday;

    @FXML
    private AnchorPane Tuesday;

    @FXML
    private AnchorPane Wednesday;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button zoom;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void test(ActionEvent actionEvent) {
        Friday.setStyle("-fx-background-color:'blue'");

    }

}
