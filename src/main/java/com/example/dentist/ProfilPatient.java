package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProfilPatient implements Initializable {
    @FXML
    private Button logout;

    @FXML
    private Button manip_patient;

    @FXML
    private Label display_dateN;

    @FXML
    private Label display_cin;

    @FXML
    private Label display_nom;

    @FXML
    private Label display_prenom;

    @FXML
    private Label Num_Patient;

    private Patient p ;

    public void manip_assistant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("ajouter un Assistant");
        stage.setScene(scene);
        stage.show();
    }

    public void manip_patient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("ajouter un patient");
        stage.setScene(scene);
        stage.show();
    }


    public ProfilPatient() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/java/com/example/test2/BufferData.txt");
        String ID="";
        try {
            Scanner s = new Scanner(file);
            if (s.hasNextLine()) {
                String data = s.nextLine();
                String[] res = data.split("\t");
                ID = res[0]+".txt";
                String path = "src/main/java/com/example/test2/patient/" + ID;
                File file2 = new File(path);
                if (!file2.exists()) System.out.println("second file doesn't exist");
                else {
                    try {
                        Scanner sc = new Scanner(file2);
                        data = sc.nextLine();
                        String[] List = data.split("\t");
                        p = new Patient(Integer.valueOf(List[0]), List[1], List[2],List[3], List[4], List[5]);
                        Num_Patient.setText("Patient N°"+p.getIDPatient());
                        display_nom.setText("Nom : "+p.getNom());
                        display_prenom.setText("Prenom : "+p.getPrenom());
                        display_dateN.setText("Date de naissance : "+p.getDateNaissance());
                        display_cin.setText("CIN :"+p.getCIN());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void ajout_act(ActionEvent event) {

    }

    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void overview(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 766, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Acceuil");
        stage.setScene(scene);
        stage.show();
    }
}
