package yatzy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }

    public void init() {
        List<String> tables = createTables();

        // "try with resources" sulkee resurssin automaattisesti lopuksi
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            // suoritetaan komennot
            for (String table : tables) {
//                System.out.println("Running command >> " + table);
                st.executeUpdate(table);
            }

        } catch (Throwable t) {
            // jos tietokantataulu on jo olemassa, ei komentoja suoriteta
//            System.out.println("Error >> " + t.getMessage());
        }
    }

    private List<String> createTables() {
        ArrayList<String> list = new ArrayList<>();

        // create tables
        list.add("CREATE TABLE user (id integer PRIMARY KEY, username varchar(30), name varchar(30));");

        list.add("CREATE TABLE statistics (user_id integer,"
                + " ones integer,"
                + " twos integer,"
                + " threes integer,"
                + " fours integer,"
                + " fives integer,"
                + " sixes integer,"
                + " uppersectiontotal integer,"
                + " bonus integer,"
                + " onepair integer,"
                + " twopair integer,"
                + " threeofakind integer,"
                + " fourofakind integer,"
                + " smallstraight integer,"
                + " bigstraight integer,"
                + " fullhouse integer,"
                + " chance integer,"
                + " yatzy integer,"
                + " lowersectiontotal integer,"
                + " total integer,"
                + " FOREIGN KEY (user_id) REFERENCES user(id));");

        // test data
        list.add("INSERT Into user (username, name) VALUES ('xdjonttu', 'johannes')");

        return list;
    }

    public void deleteAllData() throws SQLException {
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            // suoritetaan komennot
            String command = "DELETE FROM statistics";
            st.executeUpdate(command);
            
            command = "DELETE FROM user";
            st.executeUpdate(command);

        } catch (Throwable t) {
        }

    }

}
