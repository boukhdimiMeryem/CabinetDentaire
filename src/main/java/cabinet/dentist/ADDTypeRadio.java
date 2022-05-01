package cabinet.dentist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class ADDTypeRadio {
    @FXML
    private TextField ID;

    @FXML
    private TextField Description;


    void ADDTypeRadio(ActionEvent event) throws FileNotFoundException, ParseException{
        TypeRadio tR = new TypeRadio(this.ID.getText(), this.Description.getText());
        String data = "";
        try {
            Scanner s = new Scanner("src/main/java/cabinet/test2/TypeRadios.txt");
            if(s.hasNextLine())
            {
                while (s.hasNextLine()) {
                    data += s.nextLine()+"\n";
                }
                data+=tR.getIDTypeRadio() + "\t" + tR.getDescription();
            }
            else data = tR.getIDTypeRadio() + "\t" + tR.getDescription();
            FileWriter Type = new FileWriter("src/main/java/cabinet/test2/TypeRadios.txt");
            BufferedWriter writer = new BufferedWriter(Type);
            writer.write(data);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void AnnulerAjoutTypeR(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
