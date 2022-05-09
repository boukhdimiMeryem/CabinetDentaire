package com.example.dentist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.stream.Collectors.toList;

public class Calendar implements Initializable {
    @FXML
    private TableView<Calendrier> tab;
    @FXML
    private TableColumn<Calendrier, Integer> Friday;

    @FXML
    private TableColumn<Calendrier, Integer> Monday;

    @FXML
    private TableColumn<Calendrier, Integer> Saturday;

    @FXML
    private TableColumn<Calendrier, Integer> Sunday;

    @FXML
    private TableColumn<Calendrier, Integer> Thursday;

    @FXML
    private TableColumn<Calendrier, Integer> Tuesday;

    @FXML
    private TableColumn<Calendrier, Button> Action;

    @FXML
    private Button NW;

    @FXML
    private Button WB;

    static int var1=0;
    static int var2=0;
    static int month;
    static int year;

    @FXML
    private TableColumn<Calendrier, Integer> Wednesday;
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
                    year = String.valueOf(Integer.parseInt(year) + 1);
                    months = "01";
                } else {
                    Day = "01";
                    months = String.valueOf(Integer.parseInt(months) + 1);
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
    public String getData(String data,ObservableList L, TableView tab){
        LocalDate daate =LocalDate.parse(data);
        List<LocalDate> testt= Arrays.asList(DayOfWeek.values()).stream().map(daate::with).collect(toList());
        Calendrier C = new Calendrier(Integer.parseInt(testt.get(0).toString().split("-")[2]),Integer.parseInt(testt.get(1).toString().split("-")[2]),Integer.parseInt(testt.get(2).toString().split("-")[2]),Integer.parseInt(testt.get(3).toString().split("-")[2]),Integer.parseInt(testt.get(4).toString().split("-")[2]),Integer.parseInt(testt.get(5).toString().split("-")[2]),Integer.parseInt(testt.get(6).toString().split("-")[2]));
        L.add(C);
        tab.setItems(L);
        return getNextDate(testt.get(6).toString());
    }
    public void fetchData(String date) {
        //java.time.DayOfWeek dayOfWeek = datee.getDayOfWeek();// the result is stocked in dayOfWeek.toString()
        //List<LocalDate> test= Arrays.asList(DayOfWeek.values()).stream().map(datee::with).collect(toList());
        ObservableList<Calendrier> L = FXCollections.observableArrayList();
        Monday.setCellValueFactory(new PropertyValueFactory<>("Monday"));
        Tuesday.setCellValueFactory(new PropertyValueFactory<>("Tuesday"));
        Wednesday.setCellValueFactory(new PropertyValueFactory<>("Wednesday"));
        Thursday.setCellValueFactory(new PropertyValueFactory<>("Thursday"));
        Friday.setCellValueFactory(new PropertyValueFactory<>("Friday"));
        Saturday.setCellValueFactory(new PropertyValueFactory<>("Saturday"));
        Sunday.setCellValueFactory(new PropertyValueFactory<>("Sunday"));
        Action.setCellValueFactory(new PropertyValueFactory<>("enter"));
        String[] dateCheck = date.split("-");
        month=Integer.parseInt(dateCheck[1]);
        year=Integer.parseInt(dateCheck[0]);
        String ID = dateCheck[0] + "-" + dateCheck[1] + "-" + "01";
        for (byte i = 0; i < 5; i++) {
            ID = getData(ID, L, tab);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetchData(LocalDate.now().toString());
    }

    public void NWeek(ActionEvent event) {
        var1++;
        month+=var1;
        String date =LocalDate.now().toString();
        String[] test = date.split("-");
        if(month<=8) fetchData(String.valueOf(year)+"-0"+String.valueOf(month)+"-01");
        else fetchData(String.valueOf(year)+"-"+String.valueOf(month)+"-01");//il faut faire attention au mois Janvier et au mois Decembre
        var2=0;
    }

    public void Wbefore(ActionEvent event) {
        var2++;
        month-=var2;
        if(month<=8) fetchData(String.valueOf(year)+"-0"+String.valueOf(month)+"-01");
        else fetchData(String.valueOf(year)+"-"+String.valueOf(month)+"-01");//il faut faire attention au mois Janvier et au mois Decembre
        var1=0;
    }
}
