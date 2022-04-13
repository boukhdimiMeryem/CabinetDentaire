module com.example.dentist {
    requires javafx.controls;
    requires javafx.fxml;


    opens cabinet.dentist to javafx.fxml;
    exports cabinet.dentist;
}