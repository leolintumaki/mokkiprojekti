package sample.palvelu;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class palveluDAO {

    public static ObservableList<palvelu> etsiPalvelut () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM palvelu";

        try {
            ResultSet rsPal = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<palvelu> paData = getPalveluLista(rsPal);

            return paData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }

    public static palvelu etsiPalvelu (String palvelu_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM palvelu WHERE palvelu_id="+ palvelu_id;
        try {
            ResultSet rsPa = dbconnect.dbExecuteQuery(selectStmt);
            palvelu palvelu = palveluRS(rsPa);
            return palvelu;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static palvelu palveluRS(ResultSet rs) throws SQLException
    {
        palvelu pa = null;
        if (rs.next()) {
            pa = new palvelu();
            pa.setPalvelu_id(rs.getInt("palvelu_id"));
            pa.setPa_tpid(rs.getInt("toimintaalue_id"));
            pa.setNimi(rs.getString("nimi"));
            pa.setTyyppi(rs.getString("tyyppi"));
            pa.setKuvaus(rs.getString("kuvaus"));
            pa.setHinta(rs.getInt("hinta"));
            pa.setAlv(rs.getInt("alv"));


        }
        return pa;
    }



    private static ObservableList<palvelu> getPalveluLista(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<palvelu> paList = FXCollections.observableArrayList();

        while (rs.next()) {
            palvelu pa = new palvelu();
            pa.setPalvelu_id(rs.getInt("palvelu_id"));
            pa.setPa_tpid(rs.getInt("toimintaalue_id"));
            pa.setNimi(rs.getString("nimi"));
            pa.setTyyppi(rs.getString("tyyppi"));
            pa.setKuvaus(rs.getString("kuvaus"));
            pa.setHinta(rs.getInt("hinta"));
            pa.setAlv(rs.getInt("alv"));
            paList.add(pa);
        }
        return paList;
    }

    public static void deletePalvelu (String palvelu_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM palvelu WHERE palvelu_id ="+ palvelu_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertPalvelu (String palvelu_id, String toimintaalue_id, String nimi, String tyyppi, String kuvaus, String hinta, String alv) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "INSERT INTO palvelu\n" +
                        "(palvelu_id, toimintaalue_id, nimi, tyyppi, kuvaus, hinta, alv )\n" +
                        "VALUES\n" + "('"+palvelu_id+"', '"+toimintaalue_id+"', '"+nimi+"', '"+tyyppi+"','"+kuvaus+"','"+hinta+"','"+alv+"') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void updatePalvelu (String palvelu_id, String toimintaalue_id, String nimi, String tyyppi, String kuvaus, String hinta, String alv) throws SQLException, ClassNotFoundException
    {

        String updateStmt =

                "UPDATE palvelu\n" +
                        "SET palvelu_id= '"+palvelu_id+"', toimintaalue_id='"+toimintaalue_id+"', nimi='"+nimi+"', tyyppi='"+tyyppi+"', kuvaus='"+kuvaus+"', hinta='"+hinta+"', alv='"+alv+"' WHERE palvelu_id='" + palvelu_id + "'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }


//TODO FUNC poista valittu palvelu

}
