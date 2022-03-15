package sample.var_palvelut;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class var_palvelutDAO {

    public static ObservableList<var_palvelut> etsiVarPalv () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM varauksen_palvelut";

        try {
            ResultSet rsVPa = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<var_palvelut> vpData = getVpList(rsVPa);

            return vpData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }
    public static var_palvelut etsiVarPal (String varaus_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM varauksen_palvelut WHERE varaus_id="+ varaus_id;
        try {
            ResultSet rsVp = dbconnect.dbExecuteQuery(selectStmt);
            var_palvelut vp = vpRS(rsVp);
            return vp;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static var_palvelut vpRS(ResultSet rs) throws SQLException
    {
        var_palvelut vp = null;
        if (rs.next()) {
            vp = new var_palvelut();
            vp.setVaraus_id(rs.getInt("varaus_id"));
            vp.setPalvelu_id(rs.getInt("palvelu_id"));
            vp.setLkm(rs.getInt("lkm"));


        }
        return vp;
    }



    private static ObservableList<var_palvelut> getVpList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<var_palvelut> vpList = FXCollections.observableArrayList();

        while (rs.next()) {
            var_palvelut vp = new var_palvelut();
            vp.setVaraus_id(rs.getInt("varaus_id"));
            vp.setPalvelu_id(rs.getInt("palvelu_id"));
            vp.setLkm(rs.getInt("lkm"));

            vpList.add(vp);
        }
        return vpList;
    }

    public static void deleteVP (String varaus_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM varauksen_palvelut WHERE varaus_id ="+ varaus_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertVp (String varaus_id, String palvelu_id, String lkm) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "INSERT INTO varauksen_palvelut\n" +
                        "(varaus_id, palvelu_id, lkm )\n" +
                        "VALUES\n" + "('"+varaus_id+"', '"+palvelu_id+"', '"+lkm+"') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void updateVp (String varaus_id, String palvelu_id, String lkm) throws SQLException, ClassNotFoundException
    {

        String updateStmt =

                "UPDATE varauksen_palvelut\n" +
                        "SET varaus_id= '"+varaus_id+"', palvelu_id='"+palvelu_id+"', lkm='"+lkm+"' WHERE varaus_id='" + varaus_id + "'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

}
