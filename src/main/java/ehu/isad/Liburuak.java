/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;

import ehu.isad.controllers.LiburuKud;
import ehu.isad.controllers.XehetasunakKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Liburuak extends Application {

    private Parent liburuakUI;
    private Parent xehetasunakUI;

    private Stage stage;

    private LiburuKud liburuKud;
    private XehetasunakKud xehetasunakKud;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("OpenLibrary API");
        stage.setScene(new Scene(liburuakUI));
        stage.show();
    }

    private void pantailakKargatu() throws IOException{
        FXMLLoader loaderLiburuak = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
        liburuakUI = (Parent) loaderLiburuak.load();
        liburuKud = loaderLiburuak.getController();
        liburuKud.setMainApp(this);

        FXMLLoader loaderXehetasunak = new FXMLLoader(getClass().getResource("/Xehetasunak.fxml"));
        xehetasunakUI = (Parent) loaderXehetasunak.load();
        xehetasunakKud = loaderXehetasunak.getController();
        xehetasunakKud.setMainApp(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void mainErakutsi(){
        stage.setScene(new Scene(liburuakUI));
        stage.show();
    }

    public void xehetasunakErakutsi(){
        stage.setScene(new Scene(xehetasunakUI));
        stage.show();
    }
}
