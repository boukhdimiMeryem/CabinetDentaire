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

public class CategorieInterventionControl implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<CategorieIntervention, Integer> IDCatInCol;

    @FXML
    private TextField IdCatIntervention;

    @FXML
    private TableColumn<CategorieIntervention, Double> PrixBCol;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Button manip_patient2;

    @FXML
    private TableColumn<CategorieIntervention, String> nomTypeIntCol;

    @FXML
    private TextField prixBase;

    @FXML
    private TableView<CategorieIntervention> tableView;

    @FXML
    private TextField typeIntervention;

    @FXML
    private Button zoom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IDCatInCol.setCellValueFactory(new PropertyValueFactory<CategorieIntervention, Integer>("IDcategorie"));
        nomTypeIntCol.setCellValueFactory(new PropertyValueFactory<CategorieIntervention, String>("Type"));
        PrixBCol.setCellValueFactory(new PropertyValueFactory<CategorieIntervention, Double>("PrixBase"));
    }

    @FXML
    void afficherCatInt(ActionEvent event) throws FileNotFoundException{
        File file = new File("src/main/java/com/example/test2/categorie intervention");
        Scanner sc = new Scanner(file);

        String fileContent = "";
        while(sc.hasNextLine()) {
            fileContent = fileContent.concat(sc.nextLine() + "\n");
            System.err.println(fileContent);
        }
        String[] list = fileContent.split("/");
        ObservableList<CategorieIntervention> tableData = tableView.getItems();
        for (String s : list) {
            String[] listAtt = s.split(":");
            CategorieIntervention cat = new CategorieIntervention(Integer.parseInt(listAtt[0]), listAtt[1], Double.parseDouble(listAtt[2]));
            System.out.println(cat.getIDcategorie() +" "+ cat.getType() +" "+ cat.getPrixBase());
            tableData.add(cat);
        }
        tableView.setItems(tableData);
    }

    @FXML
    void ajouterCatInt(ActionEvent event) {
        CategorieIntervention type = new CategorieIntervention(Integer.parseInt(IdCatIntervention.getText()), typeIntervention.getText(), Double.parseDouble(prixBase.getText()));
        ObservableList<CategorieIntervention> typesi = tableView.getItems();
        typesi.add(type);
        tableView.setItems(typesi);
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
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    void manip_patient(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,1024,700);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Patient");
        stage.show();
    }

    @FXML
    void saveToFileCatInt(ActionEvent event) {
        try {
            String line;
            File f = new File("src/main/java/com/example/test2/categorie intervention");
            FileWriter fi = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(fi);
            for (CategorieIntervention p : tableView.getItems()) {
                line = p.getIDcategorie() + ":" + p.getType() + ":" + p.getPrixBase() +"/";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void submitCatInt(ActionEvent event) {
        ObservableList<CategorieIntervention> currentTableData = tableView.getItems();
        int currentTypeId = Integer.parseInt(IdCatIntervention.getText());

        for (CategorieIntervention type : currentTableData) {
            if(type.getIDcategorie() == currentTypeId) {
                type.setType(typeIntervention.getText());
                type.setPrixBase(Double.parseDouble(prixBase.getText()));
                tableView.setItems(currentTableData);
                tableView.refresh();
                break;
            }
        }
    }

    @FXML
    void supprimerCatInt(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
    }

    @FXML
    void rowClicked(MouseEvent event) {
        CategorieIntervention clickedType = tableView.getSelectionModel().getSelectedItem();
        IdCatIntervention.setText(String.valueOf(clickedType.getIDcategorie()));
        typeIntervention.setText(String.valueOf(clickedType.getType()));
        prixBase.setText(String.valueOf(clickedType.getPrixBase()));
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
}
