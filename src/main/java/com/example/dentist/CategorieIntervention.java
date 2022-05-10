package com.example.dentist;

public class CategorieIntervention {
    private int IDcategorie;
    private String Type;
    private double PrixBase;

    public CategorieIntervention (int IDcategorie, String Type, double PrixBase ){
        this.IDcategorie = IDcategorie;
        this.Type = Type;
        this.PrixBase = PrixBase;
    }

    public int getIDcategorie(){
        return IDcategorie;
    }

    public void setIDcateforie( int IDcategorie){
        this.IDcategorie = IDcategorie;
    }

    public String getType(){
        return Type;
    }

    public void setType( String Type ){
        this.Type = Type;
    }

    public double getPrixBase(){
        return PrixBase;
    }

    public void setPrixBase( double PrixBase){
        this.PrixBase = PrixBase;
    }
}
