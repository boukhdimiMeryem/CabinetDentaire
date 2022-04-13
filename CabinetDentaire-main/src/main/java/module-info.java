module com.example.dentist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dentist to javafx.fxml;
    exports com.example.dentist;
}