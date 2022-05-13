package com.example.dentist;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.File;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.stream.Collectors.toList;

public class Calendar implements Initializable {

    @FXML
    private Button Friday;

    @FXML
    private Button Monday;

    @FXML
    private Button NW;

    @FXML
    private Button Saturday;

    @FXML
    private Button Sunday;

    @FXML
    private Button Thursday;

    @FXML
    private Button Tuesday;

    @FXML
    private Button Wednesday;

    @FXML
    private Button btn_logout;

    @FXML
    private Button close;

    @FXML
    private Label week;

    @FXML
    private Button zoom;


    @FXML
    private Label test;

    static int var1=0;
    static int var2=0;
    static String Datee="";
    static int month;
    static int year;

    public String getNextDate(String data){
        String[] test = data.split("-");
        String year;
        String months;
        String Day;
        year=test[0];
        months=test[1];
        Day=test[2];
        if(test[2].equals("31"))
            {
                if (test[1].equals("12")) {
                    Day="01";
                    year = String.valueOf(Integer.parseInt(year) + 1);
                    months = "01";
                } else {
                    Day = "01";
                    if(Integer.parseInt(months)<=8) months = "0"+String.valueOf(Integer.parseInt(months)+ 1);
                    else months=String.valueOf(Integer.parseInt(months)+ 1);
                }

            }
        else if(test[2].equals("30"))
        {
            Day = "01";
            months = String.valueOf(Integer.parseInt(months)+ 1);
        }
        else if(test[2].equals("28") && test[1].equals("02")) {
            Day = "01";
            months = String.valueOf(Integer.parseInt(months)+ 1);
        }
        else{
            if(Integer.parseInt(Day)<=8) Day = "0"+String.valueOf(Integer.parseInt(Day)+ 1);
            else Day=String.valueOf(Integer.parseInt(Day)+ 1);

        }
        return year+"-"+months+"-"+Day;
    }
    public void verifyRDV(Button btn_name,String Date) throws FileNotFoundException {//il faut convertir toutes les dates en LocalDate
        File file= new File("src/main/java/com/example/test2/RDV.txt");
        Scanner s = new Scanner(file);
        String data;
        byte test=0;
        String testtab[];
        while(s.hasNextLine()){
            data=s.nextLine();
            testtab=data.split("\t");
            if(testtab[1].equals(Date))
            {
                btn_name.setStyle("-fx-background-color:'orange'");
                test=1;
                break;
            }
        }
        if(test==0) btn_name.setStyle("-fx-background-color:'green'");
    }
    public void FetchBtn(Calendrier C,List<LocalDate> testt) throws FileNotFoundException {
        Monday.setText(C.getMonday());
        verifyRDV(Monday,testt.get(0).toString());
        Tuesday.setText(C.getTuesday());
        verifyRDV(Tuesday,testt.get(1).toString());
        Wednesday.setText(C.getWednesday());
        verifyRDV(Wednesday,testt.get(2).toString());
        Thursday.setText(C.getTuesday());
        verifyRDV(Thursday,testt.get(3).toString());
        Friday.setText(C.getFriday());
        verifyRDV(Friday,testt.get(4).toString());
        Saturday.setText(C.getSaturday());
        verifyRDV(Saturday,testt.get(5).toString());
        Sunday.setText(C.getSunday());
        verifyRDV(Sunday,testt.get(6).toString());
    }
    public void fetchData(String data,boolean isDate) throws FileNotFoundException {
        LocalDate datee;
        if(!isDate)  datee=LocalDate.now();
        else datee = LocalDate.parse(data);
        List<LocalDate> testt= Arrays.asList(DayOfWeek.values()).stream().map(datee::with).collect(toList());
        Datee= testt.get(6).toString();
        Calendrier C = new Calendrier(testt.get(0).toString().split("-")[2]+"/"+testt.get(0).toString().split("-")[1],testt.get(1).toString().split("-")[2]+"/"+testt.get(1).toString().split("-")[1],testt.get(2).toString().split("-")[2]+"/"+testt.get(2).toString().split("-")[1],testt.get(3).toString().split("-")[2]+"/"+testt.get(3).toString().split("-")[1],testt.get(4).toString().split("-")[2]+"/"+testt.get(4).toString().split("-")[1],testt.get(5).toString().split("-")[2]+"/"+testt.get(5).toString().split("-")[1],testt.get(6).toString().split("-")[2]+"/"+testt.get(6).toString().split("-")[1]);
        Datee=getNextDate(testt.get(6).toString());
        FetchBtn(C,testt);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //fetchData(LocalDate.now().toString());
        try {
            fetchData("",false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void NWeek(ActionEvent event) throws FileNotFoundException {
        var1++;
        week.setText((var1+1)+"éme semaine");
        List<LocalDate> testt= Arrays.asList(DayOfWeek.values()).stream().map(LocalDate.parse(Datee)::with).collect(toList());
        Datee= testt.get(6).toString();
        Calendrier C = new Calendrier(testt.get(0).toString().split("-")[2]+"/"+testt.get(0).toString().split("-")[1],testt.get(1).toString().split("-")[2]+"/"+testt.get(1).toString().split("-")[1],testt.get(2).toString().split("-")[2]+"/"+testt.get(2).toString().split("-")[1],testt.get(3).toString().split("-")[2]+"/"+testt.get(3).toString().split("-")[1],testt.get(4).toString().split("-")[2]+"/"+testt.get(4).toString().split("-")[1],testt.get(5).toString().split("-")[2]+"/"+testt.get(5).toString().split("-")[1],testt.get(6).toString().split("-")[2]+"/"+testt.get(6).toString().split("-")[1]);
        Datee=getNextDate(testt.get(6).toString());
        FetchBtn(C,testt);
        //il faut faire attention au mois Janvier et au mois Decembre

    }

    public void goBack(ActionEvent event) throws FileNotFoundException {
        var1=0;
        week.setText("this week");
        fetchData("",false);
    }

    public void MondayD(ActionEvent event) {
        test.setText(Monday.getText());
    }
    public void TusdayD(ActionEvent event) {
        test.setText(Tuesday.getText());
    }
    public void WednesdayD(ActionEvent event) {
        test.setText(Wednesday.getText());
    }
    public void ThursdayD(ActionEvent event) {
        test.setText(Thursday.getText());
    }
    public void FridayD(ActionEvent event) {
        test.setText(Friday.getText());
    }
    public void SaturdayD(ActionEvent event) {
        test.setText(Saturday.getText());
    }
    public void SundayD(ActionEvent event) {
        test.setText(Sunday.getText());
    }
}

