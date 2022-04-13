package cabinet.dentist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Patient {
    private int IDPatient;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private String CIN;
    private String DateNaissance;
    private Button btn_enter;
    //il faut trouver une solution pour que DateNaissance soit de type Date

    /*public void removeField(String fichier, int ID) throws IOException {
        File file = new File(fichier);
        if(!file.exists()) System.out.println("File don't exist");
        else
        {
            Scanner s = new Scanner(file);
            String data = "";
            String ddata="";
            while (s.hasNextLine())
            {
                data = s.nextLine();
                String[] res = data.split("\t");
                if (Integer.valueOf(res[1]) != ID) ddata = ddata + data + "\n";
            }
            FileWriter f = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(ddata);
            bw.close();
            f.close();
        }
    }*/

    public Patient(int IDPatient,String Nom,String Prenom,String DateNaissance,String Sexe,String CIN){
        this.IDPatient=IDPatient;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Sexe=Sexe;
        this.CIN=CIN;
        this.DateNaissance=DateNaissance;
        this.btn_enter = new Button("enter");


        EventHandler<ActionEvent> event;
        btn_enter.setOnAction(event = new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                File file = new File("src/main/java/com/example/test2/BufferData.txt");
                try {
                    FileWriter f = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(f);
                    String Id = String.valueOf(IDPatient);
                    bw.write(Id);
                    bw.close();
                    f.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Profil_Patient.fxml"));
                    Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root, 1024, 700);
                    scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public Patient(){

    }


    public int getIDPatient() {
        return IDPatient;
    }

    public void setIDPatient(int IDPatient) {
        this.IDPatient = IDPatient;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        DateNaissance = DateNaissance;
    }


    public Button getBtn_enter() {
        return btn_enter;
    }

    public void setBtn_enter(Button btn_enter) {
        this.btn_enter = btn_enter;
    }
}
