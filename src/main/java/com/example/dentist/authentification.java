package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class authentification{

    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_connx;


    @FXML
    private AnchorPane cont_s;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField tfadress;



    public void switchh(ActionEvent event,String file, int width , int heigth , boolean isNewStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, width, heigth);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void login(ActionEvent event) throws IOException {
        String adress = tfadress.getText();
        String password = tfpassword.getText();
        byte test = 0;
        File file = new File("src/main/java/com/example/test2/COMBOLIST.txt");
        if (!file.exists()) {
            System.out.println("file dont found");
        } else {
            try {
                Scanner s = new Scanner(file);
                while (s.hasNextLine()) {
                    String auth_data = s.nextLine();
                    String[] testt=auth_data.split("\t");
                    if (adress.equals(testt[0])) {
                        if (password.equals(testt[1])) {
                            test=1;
                            if(testt[2].equals("AD")) switchh(event,"acceuil.fxml",1024,700,false);
                            else switchh(event,"Calendar.fxml",1024,700,false);
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(test==0) System.out.print("account not found");


    }

    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
