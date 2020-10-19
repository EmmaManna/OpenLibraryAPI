package ehu.isad.controllers.db;

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

}
