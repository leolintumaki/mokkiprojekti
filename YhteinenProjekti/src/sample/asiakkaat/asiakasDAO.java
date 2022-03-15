package sample.asiakkaat;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.dbconnect;

public class asiakasDAO {
    public static ObservableList<asiakas> etsiAsiakkaat () throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM asiakas";

        try {
            ResultSet rsAsi = dbconnect.dbExecuteQuery(selectStmt);
            ObservableList<asiakas> asData = getAsiakasLista(rsAsi);

            return asData;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }
    }
    public static asiakas etsiAsiakas (String asiakas_id) throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM asiakas WHERE asiakas_id="+ asiakas_id;
        try {
            ResultSet rsAs = dbconnect.dbExecuteQuery(selectStmt);
            asiakas asiakas = asiakasRS(rsAs);
            return asiakas;
        } catch (SQLException e) {
            System.out.println("Virhe: " + e);
            throw e;
        }

    }


    private static asiakas asiakasRS(ResultSet rs) throws SQLException
    {
        asiakas as = null;
        if (rs.next()) {
            as = new asiakas();
            as.setAsiakas_id(rs.getInt("asiakas_id"));
            as.setEtunimi(rs.getString("etunimi"));
            as.setSukunimi(rs.getString("sukunimi"));
            as.setLahiosoite(rs.getString("lahiosoite"));
            as.setPostitoimipaikka(rs.getString("postitoimipaikka"));
            as.setPostinro(rs.getString("postinro"));
            as.setEmail(rs.getString("email"));
            as.setPuhelinnro(rs.getString("puhelinnro"));

        }
        return as;
    }



    private static ObservableList<asiakas> getAsiakasLista(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<asiakas> asList = FXCollections.observableArrayList();

        while (rs.next()) {
            asiakas as = new asiakas();
            as.setAsiakas_id(rs.getInt("asiakas_id"));
            as.setEtunimi(rs.getString("etunimi"));
            as.setSukunimi(rs.getString("sukunimi"));
            as.setLahiosoite(rs.getString("lahiosoite"));
            as.setPostitoimipaikka(rs.getString("postitoimipaikka"));
            as.setPostinro(rs.getString("postinro"));
            as.setEmail(rs.getString("email"));
            as.setPuhelinnro(rs.getString("puhelinnro"));
            asList.add(as);
        }
        return asList;
    }

    public static void deleteAsiakas (String asiakas_id) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "  DELETE FROM asiakas WHERE asiakas_id ="+ asiakas_id;

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void insertAsiakas (String asiakas_id, String etunimi, String sukunimi, String lahiosoite, String postitoimipaikka, String postinro, String email, String puhelinnro) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "INSERT INTO asiakas\n" +
                        "(asiakas_id, etunimi, sukunimi, lahiosoite, postitoimipaikka, postinro, email, puhelinnro )\n" +
                        "VALUES\n" + "('"+asiakas_id+"', '"+etunimi+"', '"+sukunimi+"','"+lahiosoite+"','"+postitoimipaikka+"', '"+postinro+"', '"+email+"', '"+puhelinnro+"') ";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }

    public static void updateAsiakas (String asiakas_id, String etunimi, String sukunimi, String lahiosoite, String postitoimipaikka, String postinro, String email, String puhelinnro) throws SQLException, ClassNotFoundException {

        String updateStmt =

                "UPDATE asiakas\n" +
                        "SET asiakas_id= '"+asiakas_id+"', etunimi='"+etunimi+"', sukunimi='"+sukunimi+"', lahiosoite='"+lahiosoite+"', postitoimipaikka='"+postitoimipaikka+"', postinro='"+postinro+"', email='"+email+"', puhelinnro='"+puhelinnro+"' WHERE asiakas_id='"+asiakas_id+"'";

        try {
            dbconnect.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Virhe: " + e);
            throw e;
        }
    }
}
