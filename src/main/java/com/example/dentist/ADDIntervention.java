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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ADDIntervention implements Initializable {
    @FXML
    private TableView<Intervention> table;

    @FXML
    private TableColumn<Intervention, Button> Action;

    @FXML
    private TableColumn<Intervention, String> DatePrevu;

    @FXML
    private TableColumn<Intervention, String> DateReelle;

    @FXML
    private TableColumn<Intervention, String> EtatRV;

    @FXML
    private TableColumn<Intervention, Integer> ID;

    @FXML
    private TableColumn<Intervention, Integer> PrixB;

    @FXML
    private TableColumn<Intervention, String> Type;

    @FXML
    private Label Num_Patient;

    @FXML
    private Label display_cin;

    @FXML
    private Label display_dateN;

    @FXML
    private Label display_nom;

    @FXML
    private Label display_prenom;


    public void loadInfo() throws FileNotFoundException {
        EtatRV.setCellValueFactory(new PropertyValueFactory<>("EtatRV"));
        DatePrevu.setCellValueFactory(new PropertyValueFactory<>("DatePrevue"));
        DateReelle.setCellValueFactory(new PropertyValueFactory<>("DateReelle"));
        ID.setCellValueFactory(new PropertyValueFactory<>("IDIntervention"));
        Type.setCellValueFactory(new PropertyValueFactory<>("typeIntervention"));
        PrixB.setCellValueFactory(new PropertyValueFactory<>("prixBase"));
        Action.setCellValueFactory(new PropertyValueFactory<>("btn_modify"));

        ObservableList<Intervention> L = FXCollections.observableArrayList();

        //ce code pour chercher les données du patient
        File file = new File("src/main/java/com/example/test2/BufferData.txt");
        String Id = "";
        try {
            Scanner s = new Scanner(file);
            String[] List;
            if (s.hasNextLine()) {
                String data = s.nextLine();
                String[] res = data.split("\t");
                Id = res[0] + ".txt";
                String path = "src/main/java/com/example/test2/patient/" + Id;
                File file2 = new File(path);
                if (!file2.exists()) System.out.println("second file doesn't exist");
                else {
                    try {
                        Scanner sc = new Scanner(file2);
                        data = sc.nextLine();
                        List = data.split("\t");
                        Patient p = new Patient(Integer.valueOf(List[0]), List[1], List[2], List[3], List[4], List[5]);
                        Num_Patient.setText("Patient N°" + p.getIDPatient());
                        display_nom.setText("Nom : " + p.getNom());
                        display_prenom.setText("Prenom : " + p.getPrenom());
                        display_dateN.setText("Date de naissance : " + p.getDateNaissance());
                        display_cin.setText("CIN :" + p.getCIN());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            s.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        //ce code pour chercher les interventions (alors il faut d'abord savoir de quel acte on parle)
        File file2 = new File("src/main/java/com/example/test2/BufferData.txt");
        Scanner s = new Scanner(file2);
        String id =s.nextLine()+".txt";
        String dataa = s.nextLine();
        File file3 = new File("src/main/java/com/example/test2/patient/"+id);
        Scanner ss= new Scanner(file3);
        while(ss.hasNextLine()){
            String data=ss.nextLine();
            String[] res=data.split("\t");
            if(res[0].equals("AC/") && res[1].equals(dataa) && ss.hasNextLine()){
                while(!((data=ss.nextLine()).equals("-"))){
                    res=data.split("\t");
                    if(res[2].equals("-1"))
                    {
                        Intervention i = new Intervention(Integer.valueOf(res[0]),res[1],"non fixé encore","non fixé",res[3],0);
                        L.add(i);
                    }
                    else{
                        Intervention i = new Intervention(Integer.valueOf(res[0]),res[1],res[2],res[3],res[4],Integer.valueOf(res[5]));
                        L.add(i);
                    }
                }
            }
        }
        table.setItems(L);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void switchh(ActionEvent event,String file, int width , int heigth , boolean isNewStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file));
        Stage stage;
        if(isNewStage==true) stage = new Stage();
        else stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, width, heigth);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void overview(ActionEvent event) throws IOException {
        switchh(event,"acceuil.fxml",1024,700,false);
    }

    public void manip_assistant(ActionEvent event) throws IOException {
        switchh(event,"Assistant_List.fxml",1024,700,false);
    }

    public void manip_patient(ActionEvent event) throws IOException {
        switchh(event,"Patient_List.fxml",1024,700,false);
    }
}
