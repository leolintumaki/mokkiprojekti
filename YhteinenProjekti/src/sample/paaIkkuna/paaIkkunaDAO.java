package sample.paaIkkuna;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class paaIkkunaDAO {

    public static ObservableList<paaIkkuna> etsiInfot () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT varaus.varaus_id, varaus.asiakas_id, varaus.toimipiste_id, asiakas.etunimi, asiakas.sukunimi, toimipiste.nimi, varaus.varattu_alkupvm, varaus.varattu_loppupvm,\n" +
                "varauksen_palvelut.lkm FROM varaus, asiakas, toimipiste, varauksen_palvelut WHERE varaus.asiakas_id = asiakas.asiakas_id AND varaus.toimipiste_id = toimipiste.toimipiste_id AND varauksen_palvelut.varaus_id = varaus.varaus_id";

        try {
            ResultSet rsPIk = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<paaIkkuna> piData = getpiLista(rsPIk);

            return piData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }
    public static paaIkkuna etsiInfo (String varausID) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM varaus WHERE varaus_id="+ varausID;
        try {
            ResultSet rsPI = dbconnect.dbExecuteQuery(selectStmt);
            paaIkkuna pi = infoRS(rsPI);
            return pi;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static paaIkkuna infoRS(ResultSet rs) throws SQLException
    {
        paaIkkuna pi = null;
        if (rs.next()) {
            pi = new paaIkkuna();
            pi.setVarausID(rs.getInt("varaus_id"));
            pi.setAsiakasID(rs.getInt("asiakas_id"));
            pi.setToimipisteID(rs.getInt("toimipiste_id"));
            pi.setEtunimi(rs.getString("etunimi"));
            pi.setSukunimi(rs.getString("sukunimi"));
            pi.setToimipiste(rs.getString("nimi"));
            pi.setVar_alku(rs.getString("varattu_alkupvm"));
            pi.setVar_loppu(rs.getString("varattu_loppupvm"));
            pi.setPalvelu_lkm(rs.getInt("lkm"));

        }
        return pi;
    }



    private static ObservableList<paaIkkuna> getpiLista(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<paaIkkuna> piList = FXCollections.observableArrayList();

        while (rs.next()) {
            paaIkkuna pi = new paaIkkuna();
            pi.setVarausID(rs.getInt("varaus_id"));
            pi.setAsiakasID(rs.getInt("asiakas_id"));
            pi.setToimipisteID(rs.getInt("toimipiste_id"));
            pi.setEtunimi(rs.getString("etunimi"));
            pi.setSukunimi(rs.getString("sukunimi"));
            pi.setToimipiste(rs.getString("nimi"));
            pi.setVar_alku(rs.getString("varattu_alkupvm"));
            pi.setVar_loppu(rs.getString("varattu_loppupvm"));
            pi.setPalvelu_lkm(rs.getInt("lkm"));
            piList.add(pi);
        }
        return piList;
    }

}
