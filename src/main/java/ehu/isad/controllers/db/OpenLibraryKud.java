package ehu.isad.controllers.db;

import ehu.isad.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpenLibraryKud {

    private static final OpenLibraryKud instance = new OpenLibraryKud();

    public static OpenLibraryKud getInstance() {
        return instance;
    }

    private OpenLibraryKud() {
    }

    public List<String> lortuLiburuak() {

        String query = "select isbn, izenburua from liburua";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<String> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {

                long isbn = rs.getLong("isbn");
                String izenburua = rs.getString("izenburua");

                System.out.println(isbn + ":" + izenburua);
                emaitza.add(izenburua);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public long lortuISBN(String izenburua){
        long isbn = 0;

        String query = "select isbn from liburua where izenburua='" + izenburua +"'";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        try {
            while (rs.next()) {

                isbn = rs.getLong("isbn");
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return isbn;
    }


    public boolean konprobatuDagoen(String izenburua){
        String query = "select orrikop from liburua where izenburua='"+izenburua+"'";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        boolean dago = true;

        try {
            rs.next();
            dago = rs.getInt("orrikop")!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dago;
    }

    public void liburuaKargatu(long isbn){
        Book b = new Book();
        b = b.liburuaLortu(isbn);

        String query = "update liburua set subtitulua='"+b.getDetails().getSubtitle()+"', orrikop="+b.getDetails().getNumber_of_pages()+" where isbn="+b.getISBN();
        System.out.println(query);
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        dbKudeatzaile.execSQL(query);

        for(int i = 0; i<b.getDetails().getPublishers().length; i++){
            if(!this.konprobatuArgitaletxea(b.getDetails().getPublishers()[i])){
                String query1 = "insert into argitaletxea values (\"" +b.getDetails().getPublishers()[i]+ "\")";
                System.out.println(query1);
                dbKudeatzaile.execSQL(query1);
            }
            String query2 = "insert into libargitaletxe values (\"" +b.getDetails().getPublishers()[i]+ "\"," + b.getISBN()+")";
            System.out.println(query2);
            dbKudeatzaile.execSQL(query2);
        }
    }

    private boolean konprobatuArgitaletxea(String argitaletxea){
        String query = "select izena from argitaletxea where izena=\""+argitaletxea+"\"";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        boolean dago = true;

        try {

            dago =  rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dago;
    }

    public String lortuDatuak(long isbn){
        String datuak = "";

        String query = "select izenburua, subtitulua, orrikop from liburua where isbn="+isbn;
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        try {
            while (rs.next()) {

                datuak = rs.getString("izenburua");
                datuak = datuak + ","+ rs.getInt("orrikop");

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return datuak;
    }

    public List<String> lortuArgitaletxeak(long isbn){
        List<String> argitaletxeak= new ArrayList<>();

        String query = "select argitaletxea from libargitaletxe where liburua="+isbn;
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        try {
            while (rs.next()) {
                argitaletxeak.add(rs.getString("argitaletxea"));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return argitaletxeak;
    }

}
