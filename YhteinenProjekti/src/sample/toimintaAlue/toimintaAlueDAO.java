package sample.toimintaAlue;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.toimintaAlue.toimintaAlue;
import sample.dbconnect;

public class toimintaAlueDAO {

    public static ObservableList<toimintaAlue> etsitoimintaalue () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM toimintaalue";

        try {
            ResultSet rsttA = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<toimintaAlue> taData = getToimintaAlueLista(rsttA);

            return taData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }
    public static toimintaAlue etsiToimintaAlue (String toimintaalue_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM toimintaalue WHERE toimintaalue_id="+ toimintaalue_id;
        try {
            ResultSet rstA = dbconnect.dbExecuteQuery(selectStmt);
            toimintaAlue toimintaAlue = toimintaAlueRS(rstA);
            return toimintaAlue;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static toimintaAlue toimintaAlueRS(ResultSet rs) throws SQLException
    {
        toimintaAlue ta = null;
        if (rs.next()) {
            ta = new toimintaAlue();
            ta.setToimintaAlue_id(rs.getInt("toimintaalue_id"));
            ta.setNimi(rs.getString("nimi"));

        }
        return ta;
    }



    private static ObservableList<toimintaAlue> getToimintaAlueLista(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<toimintaAlue> taList = FXCollections.observableArrayList();

        while (rs.next()) {
            toimintaAlue ta = new toimintaAlue();
            ta.setToimintaAlue_id(rs.getInt("toimintaalue_id"));
            ta.setNimi(rs.getString("nimi"));
            taList.add(ta);
        }
        return taList;
    }

    public static void deleteToimintaAlue (String toimintaalue_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM toimintaalue WHERE toimintaalue_id ="+ toimintaalue_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertToimintaAlue (String toimintaalue_id, String nimi) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "INSERT INTO toimintaalue\n" +
                        "(toimintaalue_id, nimi )\n" +
                        "VALUES\n" + "('"+toimintaalue_id+"', '"+nimi+"') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void updateToimintaAlue (String toimintaalue_id, String nimi) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "UPDATE toimintaalue\n" +
                        "SET toimintaalue_id= '"+toimintaalue_id+"', nimi='"+nimi+"'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

}
