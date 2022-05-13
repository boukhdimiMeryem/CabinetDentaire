package com.example.dentist;

public class Assistant extends User{
    private int IDAssistant;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private String DateNaissance;

    public Assistant(String login, String password,int IDAssistant,String Nom,String Prenom,String Sexe,String DateNaissance) {
        super(login, password);
        this.IDAssistant=IDAssistant;
        this.Nom=Nom;
        this.Prenom=Prenom;
        this.Sexe=Sexe;
        this.DateNaissance=DateNaissance;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getIDAssistant() {
        return IDAssistant;
    }

    public void setIDAssistant(int IDAssistant) {
        this.IDAssistant = IDAssistant;
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

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        DateNaissance = dateNaissance;
    }
}
