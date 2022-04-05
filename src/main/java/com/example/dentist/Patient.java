package com.example.dentist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

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


    public Patient(int IDPatient,String Nom,String Prenom,String DateNaissance,String Sexe,String CIN){
        this.IDPatient=IDPatient;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Sexe=Sexe;
        this.CIN=CIN;
        this.DateNaissance=DateNaissance;
        this.button= new Button("delete");
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
