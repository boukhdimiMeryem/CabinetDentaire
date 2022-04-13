package cabinet.dentist;

import java.util.Date;

public class ActeMedical {
    private int IDSoin;
    private Date DebutSoin;
    private double PrixComptabilise;
    private  boolean EtatActe;
    private Date FinSoin;


    public ActeMedical(int IDSoin,Date DebutSoin, double PrixComptabilise,boolean EtatActe,Date FinSoin){
        this.IDSoin=IDSoin;
        this.DebutSoin=DebutSoin;
        this.PrixComptabilise=PrixComptabilise;
        this.EtatActe=EtatActe;
        this.FinSoin=FinSoin;
    }


    public int getIDSoin() {
        return IDSoin;
    }

    public void setIDSoin(int IDSoin) {
        this.IDSoin = IDSoin;
    }

    public Date getDebutSoin() {
        return DebutSoin;
    }

    public void setDebutSoin(Date debutSoin) {
        DebutSoin = debutSoin;
    }

    public double getPrixComptabilise() {
        return PrixComptabilise;
    }

    public void setPrixComptabilise(double prixComptabilise) {
        PrixComptabilise = prixComptabilise;
    }

    public boolean isEtatActe() {
        return EtatActe;
    }

    public void setEtatActe(boolean etatActe) {
        EtatActe = etatActe;
    }

    public Date getFinSoin() {
        return FinSoin;
    }

    public void setFinSoin(Date finSoin) {
        FinSoin = finSoin;
    }
}
