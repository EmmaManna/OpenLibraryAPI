/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;

import ehu.isad.controllers.ui.LiburuKud;
import ehu.isad.controllers.ui.XehetasunakKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Liburuak extends Application {

    private Parent liburuakUI;
    private Parent xehetasunakUI;

    private Stage stage;
    private Scene sceneL;
    private Scene sceneX;

    private LiburuKud liburuKud;
    private XehetasunakKud xehetasunakKud;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("OpenLibrary API");
        stage.setScene(sceneL);
        stage.show();
    }

    private void pantailakKargatu() throws IOException{
        FXMLLoader loaderLiburuak = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
        liburuakUI = (Parent) loaderLiburuak.load();
        liburuKud = loaderLiburuak.getController();
        liburuKud.setMainApp(this);
        sceneL = new Scene(liburuakUI);

        FXMLLoader loaderXehetasunak = new FXMLLoader(getClass().getResource("/Xehetasunak.fxml"));
        xehetasunakUI = (Parent) loaderXehetasunak.load();
        xehetasunakKud = loaderXehetasunak.getController();
        xehetasunakKud.setMainApp(this);
        sceneX = new Scene(xehetasunakUI);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void mainErakutsi(){
        stage.setScene(sceneL);
        stage.show();
    }

    public void xehetasunakErakutsi(long isbn){
        xehetasunakKud.datuakJarri(isbn);
        stage.setScene(sceneX);
        stage.show();

    }
}
