package com.example.dentist;

public class TypeRadio {
    private int IDTypeRadio;
    private String NomTypeRadio;
    private String Description;

    public TypeRadio (int IDTypeRadio, String NomTypeRadio, String Description){
        this.IDTypeRadio = IDTypeRadio;
        this.NomTypeRadio = NomTypeRadio;
        this.Description = Description;
    }

    public int getIDTypeRadio(){
        return this.IDTypeRadio;
    }

    public void setIDTypeRadio(int IDTypeRadio){
        this.IDTypeRadio = IDTypeRadio;
    }

    public String getDescription(){
        return this.Description;
    }

    public void setDescription(String Description){
        this.Description = Description;
    }

    public String getNomTypeRadio(){
        return this.NomTypeRadio;
    }

    public void setNomTypeRadio(String NomTypeRadio){
        this.NomTypeRadio = NomTypeRadio;
    }
}
