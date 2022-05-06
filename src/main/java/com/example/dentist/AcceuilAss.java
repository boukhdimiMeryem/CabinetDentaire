package com.example.dentist;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AcceuilAss implements Initializable {
    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button zoom;

    public int nbDays(String months)
    {
        int i=0;
        switch(months){
            case "january": i=31;
            case "february": i=28;
            case "march": i=31;
            case "april": i=30;
            case "may": i=31;
            case "june": i=30;
            case "july": i=31;
            case "august": i=30;
            case "september": i=31;
            case "october": i=30;
            case "november": i=31;
            case "december": i=30;
        }
        return i;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(nbDays("january"));
    }
}
