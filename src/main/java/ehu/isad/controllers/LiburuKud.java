package ehu.isad.controllers;

import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak mainApp;


    public void setMainApp(Liburuak main){
        this.mainApp = main;
    }

    @FXML
    private AnchorPane pn_pane;

    @FXML
    private Label lbl_hautatu;

    @FXML
    private ComboBox<?> cmbbx_liburuak;

    @FXML
    private Button btn_ikusi;

    @FXML
    void klikEgin(ActionEvent event) {
        mainApp.xehetasunakErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}



