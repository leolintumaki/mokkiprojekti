package sample.mokki;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class toimipisteetDAO {

    public static ObservableList<toimipisteet> etsiToimipisteet () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM mokki";

        try {
            ResultSet rsTpt = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<toimipisteet> tpData = getToimipisteLista(rsTpt);

            return tpData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }
    public static toimipisteet etsiToimipiste (String mokki_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM mokki WHERE mokki_id=" + mokki_id;
        try {
            ResultSet rsTp = dbconnect.dbExecuteQuery(selectStmt);
            toimipisteet toimipiste = toimipisteRS(rsTp);
            return toimipiste;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static toimipisteet toimipisteRS (ResultSet rs) throws SQLException
    {
        toimipisteet tp = null;
        if (rs.next()) {
            tp = new toimipisteet();
            tp.setMokki_id(rs.getInt("mokki_id"));
            tp.setToimintaalue_id(rs.getInt("toimintaalue_id"));
            tp.setPostinro(rs.getString("postinro"));
            tp.setMokkinimi(rs.getString("mokkinimi"));
            tp.setKatuosoite(rs.getString("katuosoite"));
            tp.setKuvaus(rs.getString("kuvaus"));
            tp.setHenkilomaara(rs.getString("henkilomaara"));
            tp.setVarustelu(rs.getString("varustelu"));
            tp.setHinta(rs.getInt("hinta"));


        }
        return tp;
    }


    private static ObservableList<toimipisteet> getToimipisteLista (ResultSet rs) throws
            SQLException, ClassNotFoundException {
        ObservableList<toimipisteet> tpList = FXCollections.observableArrayList();

        while (rs.next()) {
            toimipisteet tp = new toimipisteet();
            tp.setMokki_id(rs.getInt("mokki_id"));
            tp.setToimintaalue_id(rs.getInt("toimintaalue_id"));
            tp.setPostinro(rs.getString("postinro"));
            tp.setMokkinimi(rs.getString("mokkinimi"));
            tp.setKatuosoite(rs.getString("katuosoite"));
            tp.setKuvaus(rs.getString("kuvaus"));
            tp.setHenkilomaara(rs.getString("henkilomaara"));
            tp.setVarustelu(rs.getString("varustelu"));
            tp.setHinta(rs.getInt("hinta"));
            tpList.add(tp);
        }
        return tpList;
    }

    public static void deleteToimipiste (String mokki_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM mokki WHERE mokki_id =" + mokki_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertToimipiste (String mokki_id, String toimintaalue_id, String postinro, String
            mokkinimi, String katuosoite, String kuvaus, String henkilomaara, String varustelu, String hinta) throws SQLException, ClassNotFoundException
    {

        String updateStmt =

                "INSERT INTO mokki\n" +
                        "(mokki_id, toimintaalue_id, postinro, mokkinimi, katuosoite, kuvaus, henkilomaara, varustelu, hinta )\n" +
                        "VALUES\n" + "('" + mokki_id + "', '" + toimintaalue_id + "', '" + postinro + "','" + mokkinimi + "', '" + katuosoite + "', '" + kuvaus + "', '" + henkilomaara + "', '" + varustelu + "', '" + hinta + "') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void updateToimipiste (String mokki_id, String toimintaalue_id, String postinro, String
            mokkinimi, String katuosoite, String kuvaus, String henkilomaara, String varustelu, String hinta) throws SQLException, ClassNotFoundException
    {

        String updateStmt =

                "UPDATE mokki\n" +
                        "SET mokki_id= '"+mokki_id+"', toimintaalue_id='"+toimintaalue_id+"', postinro='"+postinro+"', mokkinimi='"+mokkinimi+"', katuosoite='"+katuosoite+"', kuvaus='"+kuvaus+"', henkilomaara='"+henkilomaara+"', varustelu='"+varustelu+"', hinta='"+hinta+"' WHERE mokki_id='" + mokki_id + "'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

}
