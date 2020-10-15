package ehu.isad.utils;

import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Sarea {

    public Sarea(){}

    public String URLtikIrakurri(String isbn){
        return this.zatitu(this.datuakLortu(isbn),isbn);
    }

    private String datuakLortu(String isbn){
        String lerroa = " ";
        URL openLibrary;

        try {
            openLibrary = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=details&format=json");
            URLConnection konexioa = openLibrary.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(konexioa.getInputStream()));
            lerroa = in.readLine();
            in.close();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return lerroa;
    }

    private String zatitu(String lerroa, String isbn){
        String[] zatiak = lerroa.split("ISBN:" + isbn+ "\": ");
        lerroa = zatiak[1].substring(0, zatiak[1].length()-1);
        System.out.println(lerroa);

        return lerroa;
    }

    public Image irudiaSortu(String url) throws IOException{
        URLConnection konexioa = new URL(url).openConnection();
        konexioa.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36");
        try (InputStream stream = konexioa.getInputStream()) {
            return new Image(stream);
        }

    }
}
