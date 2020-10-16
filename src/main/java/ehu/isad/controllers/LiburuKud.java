package ehu.isad.controllers;

import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak mainApp;


    public void setMainApp(Liburuak main){
        this.mainApp = main;
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lbl_hautatu;

    @FXML
    private ComboBox<String> cmbbx_liburuak;

    @FXML
    private Button btn_ikusi;

    @FXML
    private Text txt_warning;



    @FXML
    void klikEgin(ActionEvent event) {
        if(cmbbx_liburuak.getValue()!=null){
            txt_warning.setVisible(false);
            String isbn = this.isbnLortu(cmbbx_liburuak.getValue());
            mainApp.xehetasunakErakutsi(isbn);
        }
        else{//Ez bada ezer sakatu
            txt_warning.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbbx_liburuak.getItems().add(0,"Blockchain: Blueprint for a New Economy");
        cmbbx_liburuak.getItems().add(1,"R for Data Science");
        cmbbx_liburuak.getItems().add(2, "Fluent Python");
        cmbbx_liburuak.getItems().add(3, "Natural Language Processing with PyTorch");
        cmbbx_liburuak.getItems().add(4, "Data Algorithms");

        txt_warning.setVisible(false);

        //cmbbx_liburuak.getSelectionModel().selectFirst();
    }

    private String isbnLortu(String lib){
        String isbn = "";
        switch (lib) {
            case "Blockchain: Blueprint for a New Economy":
                isbn = "9781491920497";
                break;
            case "R for Data Science":
                isbn = "1491910399";
                break;
            case "Fluent Python":
                isbn = "1491946008";
                break;
            case "Natural Language Processing with PyTorch":
                isbn = "1491978236";
                break;
            case "Data Algorithms":
                isbn = "9781491906187";
                break;
        }
        return isbn;
    }
}



