package ehu.isad.controllers.ui;

import ehu.isad.Liburuak;
import ehu.isad.controllers.db.OpenLibraryKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
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
            long isbn = OpenLibraryKud.getInstance().lortuISBN(cmbbx_liburuak.getValue());
            if(!OpenLibraryKud.getInstance().konprobatuDagoen(cmbbx_liburuak.getValue())){ //Liburua dbasean ez badago
                System.out.println("Liburua ez dago datu basean");
                OpenLibraryKud.getInstance().liburuaKargatu(isbn);
                //mainApp.xehetasunakErakutsi(isbn);
                System.out.println("Liburua kargatuta");
            }

            //String isbn = this.isbnLortu(cmbbx_liburuak.getValue());
            mainApp.xehetasunakErakutsi(isbn);
        }
        else{//Ez bada ezer sakatu
            txt_warning.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> liburuLista = OpenLibraryKud.getInstance().lortuLiburuak();
        ObservableList<String> liburuak = FXCollections.observableArrayList(liburuLista);
        cmbbx_liburuak.setItems( liburuak );
        txt_warning.setVisible(false);

    }
}



