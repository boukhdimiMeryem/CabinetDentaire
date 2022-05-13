package com.example.dentist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AssistantList implements Initializable {

    @FXML
    private TableView<Assistant> table;

    @FXML
    private TableColumn<Assistant, String> LoginA;

    @FXML
    private TableColumn<Assistant, String> PasswordA;

    @FXML
    private TableColumn<Assistant, LocalDate> DATENA;

    @FXML
    private TableColumn<Assistant, Integer> IDA;

    @FXML
    private TableColumn<Assistant, String> NOMA;

    @FXML
    private TableColumn<Assistant, String> PRENOMA;

    @FXML
    private TableColumn<Assistant, String> SEXE;

    @FXML
    private DatePicker tfDATE;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfNOM;

    @FXML
    private TextField tfPRENOM;

    @FXML
    private ChoiceBox<String> tfSexe;

    @FXML
    private Button logout;

    @FXML
    private Button refresh;

    private String[] sexe = {"Homme", "Femme"};


    private Parent root;

    public void cleartf() {
        tfLogin.clear();
        tfNOM.clear();
        tfPassword.clear();
        tfPRENOM.clear();
    }

    public void switchh(ActionEvent event, String file, int width, int heigth, boolean isNewStage) throws IOException {
        root = FXMLLoader.load(getClass().getResource(file));
        Stage stage;
        if (isNewStage == true) stage = new Stage();
        else stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, width, heigth);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void refresh_table() {
        IDA.setCellValueFactory(new PropertyValueFactory<Assistant, Integer>("IDAssistant"));
        NOMA.setCellValueFactory(new PropertyValueFactory<Assistant, String>("Nom"));
        PRENOMA.setCellValueFactory(new PropertyValueFactory<Assistant, String>("Prenom"));
        DATENA.setCellValueFactory(new PropertyValueFactory<Assistant, LocalDate>("DateNaissance"));
        SEXE.setCellValueFactory(new PropertyValueFactory<Assistant, String>("Sexe"));
        LoginA.setCellValueFactory(new PropertyValueFactory<Assistant, String>("Login"));
        PasswordA.setCellValueFactory(new PropertyValueFactory<Assistant, String>("Password"));
        String data = "";
        String fichier = "";
        byte m = 0;
        byte test = 0;
        File file = new File("src/main/java/com/example/test2/COMBOLIST.txt");
        LocalDate localDate = LocalDate.now(Clock.systemDefaultZone());
        ObservableList<Assistant> L = FXCollections.observableArrayList();
        if (!file.exists()) System.out.println("file doesn't exist");
        else {
            try {
                Scanner s = new Scanner(file);
                if (s.hasNextLine()) {
                    s.nextLine();
                    while (s.hasNextLine()) {
                        data = s.nextLine();
                        String path = "src/main/java/com/example/test2/assistant/" + data.split("\t")[3] + ".txt";
                        File file2 = new File(path);
                        if (!file2.exists()) System.out.println("second file doesn't exist");
                        else {
                            try {
                                Scanner sc = new Scanner(file2);
                                data = sc.nextLine();
                                String[] List = data.split("\t");
                                Assistant assistant = new Assistant(List[0], List[1], Integer.valueOf(List[2]), List[3], List[4], List[5], List[6]);
                                L.add(assistant);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                s.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        table.setItems(L);
        cleartf();
    }

    public int NextID() throws FileNotFoundException {
        File file = new File("src/main/java/com/example/test2/COMBOLIST.txt");
        Scanner s = new Scanner(file);
        String data = "";
        if (s.hasNextLine()) {
            while (s.hasNextLine()) {
                data = s.nextLine();
            }
            String[] res = data.split("\t");
            return Integer.valueOf(res[3]) + 1;
        } else return 1;
    }

    public void inserer(ActionEvent event) throws FileNotFoundException, IllegalArgumentException {
        String dateNaissance = String.valueOf(tfDATE.getValue());
        String data = "";
        //il faut penser a utiliser une autre methode d ecriture dans le fichier qui support l ecriture dans plusieur files en meme temps afin d optimiser le programme
        Assistant assistant = new Assistant(this.tfLogin.getText(), this.tfPassword.getText(), Integer.parseInt(this.IDA.getText()), this.tfNOM.getText(), this.tfPRENOM.getText(), getSexe(tfSexe), dateNaissance);
        File file1 = new File("src/main/java/com/example/test2/COMBOLIST.txt");
        try {
            Scanner s = new Scanner(file1);
            while (s.hasNextLine()) {
                data += s.nextLine() + "\n";
            }
            data += assistant.getLogin() + "\t" + assistant.getPassword() + "\tAS\t" + assistant.getIDAssistant();
            FileWriter f = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(data);
            bw.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fichier = assistant.getIDAssistant() + ".txt";
        File file2 = new File("src/main/java/com/example/test2/assistant/" + fichier);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter f2 = new FileWriter(file2);
            BufferedWriter bw = new BufferedWriter(f2);
            String input = assistant.getLogin() + "\t" + assistant.getPassword() + "\t" + assistant.getIDAssistant() + "\t" + assistant.getNom() + "\t" + assistant.getPrenom() + "\t" + assistant.getSexe() + "\t" + assistant.getDateNaissance();
            bw.write(input);
            bw.close();
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        refresh_table();
    }


    @FXML
    public void Overview(ActionEvent event) throws IOException {
        switchh(event, "acceuil.fxml", 1024, 700, false);
    }

    @FXML
    public void manip_patient(ActionEvent event) throws IOException {
        switchh(event, "Patient_List.fxml", 1024, 700, false);
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        switchh(event, "authentification.fxml", 1024, 700, false);
    }

    @FXML
    public void close(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refresh_table();
        tfSexe.getItems().addAll(sexe);
        tfSexe.setOnAction(event -> getSexe(tfSexe));
        fromTableToextField();
    }

    private String getSexe(ChoiceBox<String> tfSexe) {
        String s = tfSexe.getValue();
        return s;
    }

    private void fromTableToextField() {
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Assistant a = table.getItems().get(table.getSelectionModel().getSelectedIndex());
                tfLogin.setText(a.getLogin());
                tfNOM.setText(a.getNom());
                tfPRENOM.setText(a.getPrenom());
                tfPassword.setText(a.getPassword());
                tfSexe.setValue(a.getSexe());
                tfDATE.setValue(LocalDate.parse((a.getDateNaissance())));
            }
        });
    }

    @FXML
    private void update() throws FileNotFoundException {
        String dateNaissance = String.valueOf(tfDATE.getValue());
        String data = "";
        Assistant assistant = new Assistant(this.tfLogin.getText(), this.tfPassword.getText(), NextID(), this.tfNOM.getText(), this.tfPRENOM.getText(), getSexe(tfSexe), dateNaissance);
        System.out.println(Integer.parseInt(IDA.getText()));
        File file1 = new File("src/main/java/com/example/test2/COMBOLIST.txt");
        try {
            Scanner s = new Scanner(file1);
            data = s.nextLine();
            String id = "";
            while (s.hasNextLine()) {
                data = s.nextLine();
                String[] m = data.split("\t");
                if (String.valueOf(assistant.getLogin()).equals(m[0]) && String.valueOf(assistant.getPassword()).equals(m[1])) {
                    id = m[3];
                    break;
                }
            }
            /*String[] m=data.split("\t");
            if(assistant.getLogin()==m[0]&&assistant.getPassword()==m[1]){
                id = m[3];
            }*/
            s.close();
            System.out.println(id);
            String fichier = id + ".txt";
            File file2 = new File("src/main/java/com/example/test2/assistant/" + fichier);
            String dataa = "";
            try {
                dataa = assistant.getLogin() + "\t" + assistant.getPassword() + "\t" + assistant.getIDAssistant() + "\t" + assistant.getNom() + "\t" + assistant.getPrenom() + "\t" + assistant.getSexe() + "\t" + assistant.getDateNaissance();
                FileWriter f = new FileWriter(file2);
                BufferedWriter bw = new BufferedWriter(f);
                bw.write(dataa);
                bw.close();
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println("fichier d'un assistant non trouvé");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        refresh_table();
    }

    @FXML
    private void cancel() {
        cleartf();
    }

    @FXML
    private void delete() throws FileNotFoundException {
        String dateNaissance = String.valueOf(tfDATE.getValue());
        String data = "";
        Assistant assistant = new Assistant(this.tfLogin.getText(), this.tfPassword.getText(), NextID(), this.tfNOM.getText(), this.tfPRENOM.getText(), getSexe(tfSexe), dateNaissance);
        File file1 = new File("src/main/java/com/example/test2/COMBOLIST.txt");
        try {
            Scanner s = new Scanner(file1);
            data = s.nextLine();
            String id = "";
            while (s.hasNextLine()) {
                data = s.nextLine();
                String[] m = data.split("\t");
                if (String.valueOf(assistant.getLogin()).equals(m[0]) && String.valueOf(assistant.getPassword()).equals(m[1])) {
                    id = m[3];
                    break;
                }
            }
            s.close();
            String fichier = id + ".txt";
            File file2 = new File("src/main/java/com/example/test2/assistant/" + fichier);
            try{
                file2.delete();
            }catch(Exception e){
                System.out.println("file not deleted");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}








