package sample.varaus;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class varauksetDAO {

    public static ObservableList<varaukset> etsiVaraukset () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM varaus";

        try {
            ResultSet rsVar = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<varaukset> vaData = getVarausLista(rsVar);

            return vaData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }

    public static varaukset etsiVaraus (String varaus_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM varaus WHERE varaus_id="+ varaus_id;
        try {
            ResultSet rsVa = dbconnect.dbExecuteQuery(selectStmt);
            varaukset varaus = varausRS(rsVa);
            return varaus;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static varaukset varausRS(ResultSet rs) throws SQLException
    {
        varaukset va = null;
        if (rs.next()) {
            va = new varaukset();
            va.setVaraus_id(rs.getInt("varaus_id"));
            va.setAsiakas_id(rs.getInt("asiakas_id"));
            va.setMokki_id(rs.getInt("mokki_id"));
            va.setVarattu_pvm(rs.getString("varattu_pvm"));
            va.setVahvistus_pvm(rs.getString("vahvistus_pvm"));
            va.setVarattu_alkupvm(rs.getString("varattu_alkupvm"));
            va.setVarattu_loppupvm(rs.getString("varattu_loppupvm"));


        }
        return va;
    }



    private static ObservableList<varaukset> getVarausLista(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<varaukset> vaList = FXCollections.observableArrayList();

        while (rs.next()) {
            varaukset va = new varaukset();
            va.setVaraus_id(rs.getInt("varaus_id"));
            va.setAsiakas_id(rs.getInt("asiakas_id"));
            va.setMokki_id(rs.getInt("mokki_id"));
            va.setVarattu_pvm(rs.getString("varattu_pvm"));
            va.setVahvistus_pvm(rs.getString("vahvistus_pvm"));
            va.setVarattu_alkupvm(rs.getString("varattu_alkupvm"));
            va.setVarattu_loppupvm(rs.getString("varattu_loppupvm"));
            vaList.add(va);
        }
        return vaList;
    }

    public static void deleteVaraus (String varaus_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM varaus WHERE varaus_id ="+ varaus_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertVaraus (String varaus_id, String asiakas_id, String mokki_id, String varattu_pvm, String vahvistus_pvm, String varattu_alkupvm, String varattu_loppupvm) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "INSERT INTO varaus\n" +
                        "(varaus_id, asiakas_id, mokki_id, varattu_pvm, vahvistus_pvm, varattu_alkupvm, varattu_loppupvm )\n" +
                        "VALUES\n" + "('"+varaus_id+"' , '"+asiakas_id+"', '"+mokki_id+"', '"+varattu_pvm+"', '"+vahvistus_pvm+"','"+varattu_alkupvm+"','"+varattu_loppupvm+"') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }


    public static void updateVaraus (String varaus_id, String asiakas_id, String mokki_id, String varattu_pvm, String vahvistus_pvm, String varattu_alkupvm, String varattu_loppupvm) throws SQLException, ClassNotFoundException
    {

        String updateStmt =

                "UPDATE varaus\n" +
                        "SET varaus_id= '"+varaus_id+"', asiakas_id='"+asiakas_id+"', toimipiste_id='"+mokki_id+"', varattu_pvm='"+varattu_pvm+"', vahvistus_pvm='"+vahvistus_pvm+"', varattu_alkupvm='"+varattu_alkupvm+"', varattu_loppupvm='"+varattu_loppupvm+"' WHERE varaus_id='" + varaus_id + "'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    //todo funktio joka poistaa valitun varauksen
}
