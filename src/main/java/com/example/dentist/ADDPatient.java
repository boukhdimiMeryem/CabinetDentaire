package com.example.dentist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class ADDPatient {
    @FXML
    private TextField CIN;

    @FXML
    private TextField Nom;

    @FXML
    private TextField Prenom;

    @FXML
    private TextField Sexe;

    @FXML
    private DatePicker DateNaissance;


    public int NextID() throws FileNotFoundException {
        File file = new File("src/main/java/com/example/test2/archive_patient.txt");
        Scanner s = new Scanner(file);
        String data="";
        if(s.hasNextLine()) {
            while (s.hasNextLine()) {
                data = s.nextLine();
            }
            String[] res = data.split("\t");
            return Integer.valueOf(res[1])+1;
        }
        else return 1;
    }

    public void submit(ActionEvent event) throws FileNotFoundException, ParseException {
        String dateN = DateNaissance.getValue().toString();
        String data="";
        //il faut penser a utiliser une autre methode d ecriture dans le fichier qui support l ecriture dans plusieur files en meme temps afin d optimiser le programme
        Patient p = new Patient(NextID(),this.Nom.getText(),this.Prenom.getText(),dateN,this.Sexe.getText(),this.CIN.getText());
        File file1 = new File("src/main/java/com/example/test2/archive_patient.txt");
        try {
            Scanner s = new Scanner(file1);
            if(s.hasNextLine())
                {
                    while (s.hasNextLine()) {
                        data += s.nextLine()+"\n";
                    }
                    data+=p.getNom() + "\t" + p.getIDPatient();
                }
            else data = p.getNom()+"\t"+p.getIDPatient();
            FileWriter f = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(f);
            bw.write(data);
            bw.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fichier = p.getIDPatient()+".txt";
        File file2 = new File("src/main/java/com/example/test2/patient/"+fichier);
        if(!file2.exists()){
            try{
                file2.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        try {
            FileWriter f2 = new FileWriter(file2);
            BufferedWriter bw = new BufferedWriter(f2);
            String input= p.getIDPatient()+"\t"+p.getNom()+"\t"+p.getPrenom()+"\t"+p.getDateNaissance()+"\t"+p.getSexe()+"\t"+p.getCIN();
            bw.write(input);
            bw.close();
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cancel(ActionEvent event) throws IOException {
        final Node source = (Node) event.getSource();
        final Stage stagee = (Stage) source.getScene().getWindow();
        stagee.close();
    }
}
