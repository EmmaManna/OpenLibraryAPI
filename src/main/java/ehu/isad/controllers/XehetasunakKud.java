package ehu.isad.controllers;



import ehu.isad.Liburuak;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class XehetasunakKud implements Initializable {

    private Liburuak mainApp;


    public void setMainApp(Liburuak main){
        this.mainApp = main;
    }

    @FXML
    private Label lbl_xehetasunak;

    @FXML
    private Label lbl_izenburua;

    @FXML
    private Label lbl_argitaletxea;

    @FXML
    private Label lbl_orrikop;

    @FXML
    private Label lbl_irudia;

    @FXML
    private TextField txt_izenburua;

    @FXML
    private TextField tt_argitaletxea;

    @FXML
    private TextField txt_orrikop;

    @FXML
    private Button btn_atzera;

    @FXML
    private Pane pn_irudia;

    @FXML
    void klikEgin(ActionEvent event) {
        mainApp.mainErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
