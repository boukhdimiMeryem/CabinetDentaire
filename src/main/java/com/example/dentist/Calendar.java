package com.example.dentist;

public class Calendar {
    private int year;
    private int month;
    private int day;

    public Calendar(int year, int month , int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    //le concept est qu'on va donner une date de depart qui est bien reelle et qu'on va definir une methode pour completer le calendrier qui va être de 10ans


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
