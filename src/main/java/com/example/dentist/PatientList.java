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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.io.*;
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


    private Stage stage;
    private Scene scene;
    private Parent root;

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

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button manip_patient2;

    @FXML
    private TextField tfCIN;

    @FXML
    private DatePicker tfDATE;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfNOM;

    @FXML
    private TextField tfPRENOM;

    @FXML
    private TextField tfSexe;

    @FXML
    private Button zoom;


    public PatientList() throws ParseException {

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

    /*public void refresh(ActionEvent event) {
        refresh_table();
    }*/
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
    public int NextID() throws FileNotFoundException {
        File file = new File("src/main/java/com/example/test2/archive_patient.txt");
        Scanner s = new Scanner(file);
        String data="";
        if(s.hasNextLine()) {
            while (s.hasNextLine()) {
                data = s.nextLine();
            }
            String[] res = data.split("\t");
            return Integer.valueOf(res[1])+1;
        }
        else return 1;
    }

    public void insert(ActionEvent event) throws FileNotFoundException, ParseException {
        String dateN = tfDATE.getValue().toString();
        String data="";
        //il faut penser a utiliser une autre methode d ecriture dans le fichier qui support l ecriture dans plusieur files en meme temps afin d optimiser le programme
        Patient p = new Patient(NextID(),this.tfNOM.getText(),this.tfPRENOM.getText(),dateN,this.tfSexe.getText(),this.CIN.getText());
        File file1 = new File("src/main/java/com/example/test2/archive_patient.txt");
        try {
            Scanner s = new Scanner(file1);
            if(s.hasNextLine())
            {
                while (s.hasNextLine()) {
                    data += s.nextLine()+"\n";
                }
                data+=p.getNom() + "\t" + p.getIDPatient();
            }
            else data = p.getNom()+"\t"+p.getIDPatient();
            FileWriter f = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(data);
            bw.close();
            f.close();
            refresh_table();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fichier = p.getIDPatient()+".txt";
        File file2 = new File("src/main/java/com/example/test2/patient/"+fichier);
        if(!file2.exists()){
            try{
                file2.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        try {
            FileWriter f2 = new FileWriter(file2);
            BufferedWriter bw = new BufferedWriter(f2);
            String input= p.getIDPatient()+"\t"+p.getNom()+"\t"+p.getPrenom()+"\t"+p.getDateNaissance()+"\t"+p.getSexe()+"\t"+p.getCIN();
            bw.write(input);
            bw.close();
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manip_patient(ActionEvent event) throws IOException {
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

    @FXML
    public void goToSettings(ActionEvent event) throws  IOException {
        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }
}
