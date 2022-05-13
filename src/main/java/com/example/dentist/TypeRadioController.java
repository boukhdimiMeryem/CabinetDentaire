package com.example.dentist;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TypeRadioController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<TypeRadio, String> DescCol;

    @FXML
    private TextField Description;

    @FXML
    private TableColumn<TypeRadio, Integer> IDTRCol;

    @FXML
    private TextField IDTypeR;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button manip_patient2;

    @FXML
    private TableColumn<TypeRadio, String> nomTypeCol;

    @FXML
    private TextField nomTypeR;

    @FXML
    private TableView<TypeRadio> tableView;

    @FXML
    private Button zoom;



    @FXML
    void afficher(ActionEvent event) throws FileNotFoundException{
        File file = new File("src/main/java/com/example/test2/typeRadio");
        Scanner sc = new Scanner(file);

        String fileContent = "";
        while(sc.hasNextLine()) {
            fileContent = fileContent.concat(sc.nextLine() + "\n");
            System.err.println(fileContent);
        }
        String[] list = fileContent.split("/");
        ObservableList<com.example.dentist.TypeRadio> tableData = tableView.getItems();
        for (String s : list) {
            String[] listAtt = s.split(":");
            com.example.dentist.TypeRadio typeRadio = new com.example.dentist.TypeRadio(Integer.parseInt(listAtt[0]), listAtt[1], listAtt[2]);
            System.out.println(typeRadio.getIDTypeRadio() +" "+ typeRadio.getNomTypeRadio() +" "+ typeRadio.getDescription());
            tableData.add(typeRadio);
        }
        tableView.setItems(tableData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IDTRCol.setCellValueFactory(new PropertyValueFactory<TypeRadio, Integer>("IDTypeRadio"));
        DescCol.setCellValueFactory(new PropertyValueFactory<TypeRadio, String>("Description"));
        nomTypeCol.setCellValueFactory(new PropertyValueFactory<TypeRadio, String>("NomTypeRadio"));
    }

    @FXML
    void ajouter(ActionEvent event) {
        TypeRadio type = new TypeRadio(Integer.parseInt(IDTypeR.getText()), nomTypeR.getText(), Description.getText());
        ObservableList<TypeRadio> typesR = tableView.getItems();
        typesR.add(type);
        tableView.setItems(typesR);
        //tableView.getItems().add(type);
    }

    @FXML
    void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void logout(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    void manip_assistant(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Assistant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void manip_patient(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void overview(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1024, 700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void saveToFile(ActionEvent event) {
        try {
            String line;
            File f = new File("src/main/java/com/example/test2/typeRadio");
            FileWriter fi = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fi);
            for (TypeRadio p : tableView.getItems()) {
                line = p.getIDTypeRadio() + ":" + p.getNomTypeRadio() + ":" + p.getDescription() +"/";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void submit(ActionEvent event) {
        ObservableList<TypeRadio> currentTableData = tableView.getItems();
        int currentTypeId = Integer.parseInt(IDTypeR.getText());

        for (TypeRadio typeRadio : currentTableData) {
            if(typeRadio.getIDTypeRadio() == currentTypeId) {
                typeRadio.setDescription(Description.getText());
                typeRadio.setNomTypeRadio(nomTypeR.getText());
                tableView.setItems(currentTableData);
                tableView.refresh();
                break;
            }
        }
    }

    @FXML
    void supprimer(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    @FXML
    void rowClicked(MouseEvent event) {
        TypeRadio clickedType = tableView.getSelectionModel().getSelectedItem();
        IDTypeR.setText(String.valueOf(clickedType.getIDTypeRadio()));
        nomTypeR.setText(String.valueOf(clickedType.getNomTypeRadio()));
        Description.setText(String.valueOf(clickedType.getDescription()));
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

