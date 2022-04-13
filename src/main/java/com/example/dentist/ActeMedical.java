package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class ActeMedical {
    private int IDSoin;
    private String DebutSoin;//il faut mettre Date dans le type
    private double PrixComptabilise;
    private  boolean EtatActe;
    private String FinSoin;
    private Button btn_enter;


    public ActeMedical(int IDSoin,String DebutSoin, double PrixComptabilise,boolean EtatActe,String FinSoin){
        this.IDSoin=IDSoin;
        this.DebutSoin=DebutSoin;
        this.PrixComptabilise=PrixComptabilise;
        this.EtatActe=EtatActe;
        this.FinSoin=FinSoin;
        this.btn_enter = new Button("enter");
        EventHandler<ActionEvent> event;
        btn_enter.setOnAction(event = new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                File file = new File("src/main/java/com/example/test2/BufferData.txt");
                try {
                    Scanner s = new Scanner(file);
                    String data = s.nextLine();
                    data=data+"\n"+IDSoin;
                    FileWriter f = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(f);
                    bw.write(data);
                    bw.close();
                    f.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    Parent root = FXMLLoader.load(getClass().getResource("Intervention.fxml"));
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


    public int getIDSoin() {
        return IDSoin;
    }

    public void setIDSoin(int IDSoin) {
        this.IDSoin = IDSoin;
    }

    public String getDebutSoin() {
        return DebutSoin;
    }

    public void setDebutSoin(String debutSoin) {
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

    public String getFinSoin() {
        return FinSoin;
    }

    public void setFinSoin(String finSoin) {
        FinSoin = finSoin;
    }

    public Button getBtn_enter() {
        return btn_enter;
    }

    public void setBtn_enter(Button btn_enter) {
        this.btn_enter = btn_enter;
    }
}
