package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private Button button;
    //il faut trouver une solution pour que DateNaissance soit de type Date
    //il faut faire en sorte que l'ID du patient s'auto incremente

    public void removeField(String fichier, int ID) throws IOException {
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
    }

    public Patient(int IDPatient,String Nom,String Prenom,String DateNaissance,String Sexe,String CIN){
        this.IDPatient=IDPatient;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Sexe=Sexe;
        this.CIN=CIN;
        this.DateNaissance=DateNaissance;
        this.button= new Button("delete");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    removeField("src/main/java/com/example/test2/archive_patient.txt",IDPatient);
                    File file = new File("src/main/java/com/example/test2/patient/"+IDPatient+".txt");
                    file.delete();//il fonctionne pas ,il faut trouver une autre alternatif(cette ligne)
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

    public void setDateNaissance(Date DateNaissance) {
        DateNaissance = DateNaissance;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }



}
