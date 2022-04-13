package com.example.dentist;

import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;
import java.util.ResourceBundle;

import java.util.Scanner;


public class PatientList implements Initializable {
    @FXML
    private TableView<Patient> table;
    @FXML
    private TableColumn<Patient, String> CIN;

    @FXML
    private TableColumn<Patient, LocalDate> DATENP;

    @FXML
    private TableColumn<Patient, Integer> IDP;

    @FXML
    private TableColumn<Patient, String> NOMP;

    @FXML
    private TableColumn<Patient, String> PRENOMP;

    @FXML
    private TableColumn<Patient, String> SEXE;

    @FXML
    private TableColumn<Patient, Button> action;

    @FXML
    private Button add_pat_btn_option;

    @FXML
    private Button logout;

    @FXML
    private Button switch_add_patient;

    private Parent root;
    private Stage stage;
    private Scene scene;

    public PatientList() throws ParseException {

    }

    @FXML
    public void switch_add_patient(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ADD_Patient.fxml"));
        stage = new Stage();
        scene = new Scene(root, 362, 267);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("ajouter un patient");
        stage.setScene(scene);
        stage.show();
    }

    public void refresh_table(){
        IDP.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("IDPatient"));
        NOMP.setCellValueFactory(new PropertyValueFactory<Patient, String>("Nom"));
        PRENOMP.setCellValueFactory(new PropertyValueFactory<Patient, String>("Prenom"));
        DATENP.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("DateNaissance"));
        SEXE.setCellValueFactory(new PropertyValueFactory<Patient, String>("Sexe"));
        CIN.setCellValueFactory(new PropertyValueFactory<Patient, String>("CIN"));
        action.setCellValueFactory(new PropertyValueFactory<Patient, Button>("btn_enter"));



        String data = "";
        String fichier = "";
        byte m=0;
        byte test=0;
        File file = new File("src/main/java/com/example/test2/archive_patient.txt");
        LocalDate localDate = LocalDate.now(Clock.systemDefaultZone());
        ObservableList<Patient> L = FXCollections.observableArrayList();
        if (!file.exists()) System.out.println("file doesn't exist");
        else {
            try {
                Scanner s = new Scanner(file);
                while (s.hasNextLine()) {
                    data = s.nextLine();
                    char[] res = data.toCharArray();
                    String ID = "";
                    byte i = 0;
                    while (res[i] != '\t') {
                        i++;
                    }
                    for (byte k = (byte) (i + 1); k < res.length; k++) {
                        ID += res[k];
                    }
                    ID += ".txt";
                    String path = "src/main/java/com/example/test2/patient/" + ID;
                    File file2 = new File(path);
                    if (!file2.exists()) System.out.println("second file doesn't exist");
                    else {
                        try {
                            Scanner sc = new Scanner(file2);
                            data = sc.nextLine();
                            String[] List = data.split("\t");
                            Patient p = new Patient(Integer.valueOf(List[0]), List[1], List[2],List[3], List[4], List[5]);
                            L.add(p);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                s.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        table.setItems(L);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refresh_table();
    }

    public void refresh(ActionEvent event) {

        refresh_table();
    }
    public void overview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void manip_assistant(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
