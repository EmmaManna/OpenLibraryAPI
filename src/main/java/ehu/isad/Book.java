package ehu.isad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class Book {
    private String ISBN;
    private String thumbnail_url;
    private Details details;

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", thumbnail_url=" + thumbnail_url +
                ", details=" + details +
                '}';
    }

    public Book(){}

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public Details getDetails() {
        return details;
    }

    public Book liburuaLortu(String isbn)  {

        String lerroa = this.datuakLortu(isbn);
        lerroa = this.zatitu(lerroa, isbn);

        //Json json = readUrl("https://api.gdax.com/products/" + txanponMota + "-eur/ticker");
        Gson gson = new Gson();
        Book b = new Book();
        b = gson.fromJson(lerroa,Book.class);
        b.ISBN = isbn;
        return b;
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
}
