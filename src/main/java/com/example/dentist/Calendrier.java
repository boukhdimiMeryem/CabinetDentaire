package com.example.dentist;

import javafx.scene.control.Button;

public class Calendrier {
    private int Monday;
    private int Tuesday;
    private int Wednesday;
    private int Thursday;
    private int Friday;
    private int Saturday;
    private int Sunday;
    private Button enter;

    public Calendrier(int m, int tu, int w, int th, int f, int sa, int su){
        this.Monday=m;
        this.Tuesday=tu;
        this.Wednesday=w;
        this.Thursday=th;
        this.Friday=f;
        this.Saturday=sa;
        this.Sunday=su;
        this.enter=new Button("Check this week");
    }

    public int getMonday() {
        return Monday;
    }

    public void setMonday(int monday) {
        Monday = monday;
    }

    public int getTuesday() {
        return Tuesday;
    }

    public void setTuesday(int tuesday) {
        Tuesday = tuesday;
    }

    public int getWednesday() {
        return Wednesday;
    }

    public void setWednesday(int wednesday) {
        Wednesday = wednesday;
    }

    public int getThursday() {
        return Thursday;
    }

    public void setThursday(int thursday) {
        Thursday = thursday;
    }

    public int getFriday() {
        return Friday;
    }

    public void setFriday(int friday) {
        Friday = friday;
    }

    public int getSaturday() {
        return Saturday;
    }

    public void setSaturday(int saturday) {
        Saturday = saturday;
    }

    public int getSunday() {
        return Sunday;
    }

    public void setSunday(int sunday) {
        Sunday = sunday;
    }


    public Button getEnter() {
        return enter;
    }

    public void setEnter(Button enter) {
        this.enter = enter;
    }
}
