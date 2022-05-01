package cabinet.dentist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

public class TypeRadioController{
    @FXML
    private TableView<TypeRadio> table;
    @FXML
    private TableColumn<TypeRadio, Integer> IDTypeRadio;

    @FXML
    private TableColumn<TypeRadio, String> Description;

    @FXML
    private Button add_typeRadio_btn_option;

    @FXML
    private Button delete_typeRadio_btn_option;

    private Parent root;
    private Stage stage;
    private Scene scene;

    public TypeRadioController() throws ParseException {

    }

    @FXML
    public void ADDTypeR(ActionEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("ADDTypeRadio.fxml"));
            stage = new Stage();
            scene = new Scene(root, 362, 267);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setResizable(false);
            stage.setTitle("Ajouter un type de radio");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.append("Erreur d'affichage ");
            e.printStackTrace();
        }


    }
}

