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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

public class PatientList implements Initializable {

    @FXML
    private TableColumn<Patient, String> CIN;

    @FXML
    private TableColumn<Patient, Date> DATENP;

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
    private TableView<Patient> table;

    @FXML
    private TextField tfCIN;

    @FXML
    private TextField tfDATE;

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

    @FXML
    void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public PatientList() throws ParseException {

    }

    @FXML
    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void manip_assistant(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("ajouter un Assistant");
        stage.setScene(scene);
        stage.show();
    }

    public void manip_patient(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    void overview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Acceuil");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void insert(ActionEvent event) throws IOException {
        Patient patient = new Patient(Integer.parseInt(tfID.getText()),tfNOM.getText(),tfPRENOM.getText(),tfDATE.getText(),tfSexe.getText(),tfCIN.getText());
        table.getItems().add(patient);
        /*root = FXMLLoader.load(getClass().getResource("Intervention_details.fxml"));
        stage = new Stage();
        scene = new Scene(root, 362, 267);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("ajouter un patient");
        stage.setScene(scene);
        stage.show();*/

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CIN.setCellValueFactory(new PropertyValueFactory<>("CIN"));
        DATENP.setCellValueFactory(new PropertyValueFactory<>("DateNaissance"));
        IDP.setCellValueFactory(new PropertyValueFactory<>("IDPatient"));
        NOMP.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        PRENOMP.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        SEXE.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        action.setCellValueFactory(new PropertyValueFactory<>("btn_enter"));
        //table.setItems(observableList);
    }
    //ObservableList<Patient> observableList = FXCollections.observableList(new Patient(13,"boukhdimi","meryem","13022002","f","123456"),new Patient(14,"fff","hhh","222","f","555"));
}

/*
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
        root = FXMLLoader.load(getClass().getResource("Intervention_details.fxml"));
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
        stage.setTitle("Acceuil");
        stage.setScene(scene);
        stage.show();
    }

    public void manip_assistant(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("ajouter un Assistant");
        stage.setScene(scene);
        stage.show();
    }
    public void logout(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }
    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
**/