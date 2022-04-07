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
                    char[] auth = auth_data.toCharArray();
                    String ad = "";
                    String pw = "";
                    String status = "";
                    byte i = 0;
                    while (auth[i] != '\t') {
                        ad += String.valueOf(auth[i]);
                        i++;
                    }
                    byte j = (byte) (i + 1);
                    while (auth[j] != '\t') {
                        pw += auth[j];
                        j++;
                    }
                    for (byte k = (byte) (j + 1); k < auth.length; k++) {
                        status += auth[k];
                    }
                    if (adress.equals(ad)) {
                        if (password.equals(pw)) {
                            test=1;
                            root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
                            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            scene = new Scene(root, 1024, 700);
                            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
                            stage.setScene(scene);
                            stage.show();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(test==0) System.out.print("test2");


    }

    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
