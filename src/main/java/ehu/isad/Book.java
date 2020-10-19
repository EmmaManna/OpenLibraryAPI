package ehu.isad;


import com.google.gson.Gson;
import ehu.isad.utils.Sarea;

public class Book {
    private long ISBN;
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

    public long getISBN() {
        return ISBN;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public Details getDetails() {
        return details;
    }

    public Book liburuaLortu(long isbn)  {

        Sarea s = new Sarea();
        String lerroa = s.URLtikIrakurri(isbn);

        Gson gson = new Gson();
        Book b = gson.fromJson(lerroa,Book.class);
        b.ISBN = isbn;
        return b;
    }

    public String irudiErtainaLortu(){
        String ertaina = this.thumbnail_url.substring(0, this.thumbnail_url.length()-5);
        ertaina = ertaina + "M.jpg";
        return ertaina;
    }

}
