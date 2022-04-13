package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class Intervention {
    private int IDIntervention;
    private String DatePrevue;
    private String DateReelle;
    private String typeIntervention;
    private String EtatRV;
    private Integer prixBase;
    private Button btn_modify;


    public Intervention(int ID, String DateP,String DateReelle,String typeIntervention,String EtatRV,Integer prixBase){
        this.IDIntervention=ID;
        this.DatePrevue= DateP;
        this.EtatRV=EtatRV;
        this.DateReelle=DateReelle;
        this.typeIntervention=typeIntervention;
        this.prixBase=prixBase;
        this.btn_modify= new Button("Modify");
        EventHandler<ActionEvent> event;
        /*btn_modify.setOnAction(event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });*/
    }

    public int getIDIntervention() {
        return IDIntervention;
    }

    public void setIDIntervention(int IDIntervention) {
        this.IDIntervention = IDIntervention;
    }

    public String getDatePrevue() {
        return DatePrevue;
    }

    public void setDatePrevue(String datePrevue) {
        DatePrevue = datePrevue;
    }

    /*public String getDateReelle() {
        return DateReelle;
    }

    public void setDateReelle(String dateReelle) {
        DateReelle = dateReelle;
    }*/

    public String isEtatRV() {
        return EtatRV;
    }

    public void setEtatRV(String etatRV) {
        EtatRV = etatRV;
    }

    public Integer getPrixBase() {
        return prixBase;
    }

    public void setPrixBase(Integer prixBase) {
        this.prixBase = prixBase;
    }

    public Button getBtn_modify() {
        return btn_modify;
    }

    public void setBtn_modify(Button btn_modify) {
        this.btn_modify = btn_modify;
    }

    public String getDateReelle() {
        return DateReelle;
    }

    public void setDateReelle(String dateReelle) {
        DateReelle = dateReelle;
    }

    public String getTypeIntervention() {
        return typeIntervention;
    }

    public void setTypeIntervention(String typeIntervention) {
        this.typeIntervention = typeIntervention;
    }
}
