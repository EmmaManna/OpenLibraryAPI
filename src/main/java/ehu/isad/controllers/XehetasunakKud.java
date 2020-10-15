package ehu.isad.controllers;



import ehu.isad.Book;
import ehu.isad.Liburuak;
import ehu.isad.utils.Sarea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


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
    private Text txt_izenburua;

    @FXML
    private Button btn_atzera;

    @FXML
    private Pane pn_irudia;

    @FXML
    private Label lbl_izenburuJarri;

    @FXML
    private Text txt_argitaletxea;

    @FXML
    private Text txt_orrikop;

    @FXML
    private ImageView mgvw_irudia;

    @FXML
    void klikEgin(ActionEvent event) {

        mainApp.mainErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_izenburua.setWrappingWidth(400);
    }

    public void datuakJarri(Book b){
        txt_izenburua.setText(b.getDetails().getTitle()+ " " + b.getDetails().getSubtitle());
        txt_argitaletxea.setText(b.getDetails().getPublishers()[0]);
        for (int i=1; i < b.getDetails().getPublishers().length; i++){
            txt_argitaletxea.setText(txt_argitaletxea.getText()+ ", " +  b.getDetails().getPublishers()[i]);
        }
        txt_orrikop.setText(String.valueOf(b.getDetails().getNumber_of_pages()));
        try {
            mgvw_irudia.setImage(new Sarea().irudiaSortu(b.getThumbnail_url()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
