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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ActeMed implements Initializable {
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

    @FXML
    private TableView<ActeMedical> table;

    @FXML
    private TableColumn<ActeMedical, Button> Action;

    @FXML
    private TableColumn<ActeMedical, String> DebutSoin;

    @FXML
    private TableColumn<ActeMedical, Boolean> EtatActe;

    @FXML
    private TableColumn<ActeMedical, String> FinSoin;

    @FXML
    private TableColumn<ActeMedical, Integer> ID;

    @FXML
    private TableColumn<ActeMedical, Integer> PrixC;

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

    public int NextID(String ID) throws FileNotFoundException {
        File file = new File("src/main/java/com/example/test2/"+ID+".txt");
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


    public void loadInfo() throws FileNotFoundException {
        File file = new File("src/main/java/com/example/test2/BufferData.txt");
        ID.setCellValueFactory(new PropertyValueFactory<ActeMedical,Integer>("IDSoin"));
        DebutSoin.setCellValueFactory(new PropertyValueFactory<ActeMedical,String>("DebutSoin"));
        PrixC.setCellValueFactory(new PropertyValueFactory<ActeMedical,Integer>("PrixComptabilise"));
        EtatActe.setCellValueFactory(new PropertyValueFactory<ActeMedical,Boolean>("EtatActe"));
        FinSoin.setCellValueFactory(new PropertyValueFactory<ActeMedical,String>("FinSoin"));
        Action.setCellValueFactory(new PropertyValueFactory<ActeMedical,Button>("btn_enter"));
        String ID="";
        try {
            ObservableList<ActeMedical> l = FXCollections.observableArrayList();
            Scanner s = new Scanner(file);
            String[] List;
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
                        List = data.split("\t");
                        p = new Patient(Integer.valueOf(List[0]), List[1], List[2],List[3], List[4], List[5]);
                        Num_Patient.setText("Patient N°"+p.getIDPatient());
                        display_nom.setText("Nom : "+p.getNom());
                        display_prenom.setText("Prenom : "+p.getPrenom());
                        display_dateN.setText("Date de naissance : "+p.getDateNaissance());
                        display_cin.setText("CIN :"+p.getCIN());
                        while(sc.hasNextLine()) {
                            data = sc.nextLine();
                            List = data.split("\t");
                            if(List[0].equals("AC/")){
                                if(List[3].equals("-1")) {
                                    ActeMedical a = new ActeMedical(Integer.valueOf(List[1]),List[2],0,true,"pas defini encore");
                                    l.add(a);
                                }
                                else{
                                    ActeMedical a = new ActeMedical(Integer.valueOf(List[1]),List[2],Integer.valueOf(List[3]),Boolean.valueOf(List[4]),List[5]);
                                    l.add(a);
                                }
                                table.setItems(l);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    public void loadtable(){
        File file = new File("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        stage.setScene(scene);
        stage.show();
    }
    public void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    /*public void ADD_ActMed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ADD_ActeMed.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root,468,458);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }*/


}
