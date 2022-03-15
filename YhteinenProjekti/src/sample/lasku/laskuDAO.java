package sample.lasku;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class laskuDAO {

    public static ObservableList<lasku> etsiLaskut () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM lasku";

        try {
            ResultSet rsLas = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<lasku> laskuData = getLaskuLista(rsLas);

            return laskuData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }
    public static lasku etsiLasku (String lasku_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM lasku WHERE lasku_id="+ lasku_id;
        try {
            ResultSet rsLa = dbconnect.dbExecuteQuery(selectStmt);
            lasku lasku = laskuRS(rsLa);
            return lasku;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static lasku laskuRS(ResultSet rs) throws SQLException
    {
        lasku la = null;
        if (rs.next()) {
            la = new lasku();
            la.setLasku_id(rs.getInt("lasku_id"));
            la.setVaraus_id(rs.getInt("varaus_id"));
            la.setSumma(rs.getInt("summa"));
            la.setAlv(rs.getInt("alv"));

        }
        return la;
    }



    private static ObservableList<lasku> getLaskuLista(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<lasku> laskuList = FXCollections.observableArrayList();

        while (rs.next()) {
            lasku la = new lasku();
            la.setLasku_id(rs.getInt("lasku_id"));
            la.setVaraus_id(rs.getInt("varaus_id"));
            la.setSumma(rs.getInt("summa"));
            la.setAlv(rs.getInt("alv"));
            laskuList.add(la);
        }
        return laskuList;
    }

    public static void deleteLasku (String lasku_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM lasku WHERE lasku_id ="+ lasku_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertLasku (String lasku_id, String varaus_id, String summa, String alv) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "INSERT INTO lasku\n" +
                        "(lasku_id, varaus_id, summa, alv )\n" +
                        "VALUES\n" + "('"+lasku_id+"', '"+varaus_id+"', '"+summa+"', '"+alv+"') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void updateLasku (String lasku_id, String varaus_id, String summa, String alv) throws SQLException, ClassNotFoundException
    {

        String updateStmt =

                "UPDATE lasku\n" +
                        "SET lasku_id= '"+lasku_id+"', varaus_id='"+varaus_id+"', summa='"+summa+"', alv='"+alv+"' WHERE lasku_id='" + lasku_id + "'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

}
