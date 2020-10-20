package ehu.isad.controllers.ui;

import ehu.isad.Liburuak;
import ehu.isad.controllers.db.OpenLibraryKud;
import ehu.isad.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
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

    public void datuakJarri(long isbn){
        String b = OpenLibraryKud.getInstance().lortuDatuak(isbn);
        String[] zatiak = b.split(",");
        txt_izenburua.setText(zatiak[0]+ " ");
        txt_orrikop.setText(String.valueOf(zatiak[1]));

        List<String> argitaletxeak = OpenLibraryKud.getInstance().lortuArgitaletxeak(isbn);
        txt_argitaletxea.setText(argitaletxeak.get(0));
        for (int i=1; i < argitaletxeak.size(); i++){
            txt_argitaletxea.setText(txt_argitaletxea.getText()+ ", " + argitaletxeak.get(i));
        }
        this.irudiaKargatu(zatiak[2]);
    }

    private void irudiaKargatu(String izena){
        String imagePath = Utils.lortuEzarpenak().getProperty("pathToImages")+izena+".png";
        try {
            mgvw_irudia.setImage(new Image(new FileInputStream(imagePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
