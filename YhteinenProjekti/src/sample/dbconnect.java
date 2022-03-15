package sample;

import javax.sql.rowset.*;
import java.sql.*;


public class dbconnect {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3307/vn";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ruutti";

    private static Connection conn = null;


    //luodaan yhteys tietokantaan
    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //määritetään statement, resultSet ja CachedRowSet
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        try {
            //Yhdistä tietokantaan
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Error : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                // Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                // Close Statement
                stmt.close();
            }
            // Close connection
            dbDisconnect();
        }
        // Return CachedRowSet
        return crs;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {

        Statement stmt = null;
        try {
            // Luo yhteys tietokantaan
            dbConnect();
            // Create Statement
            stmt = conn.createStatement();
            // ajaa sql lauseet
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                // close statement
                stmt.close();
            }
            // close connection
            dbDisconnect();
        }
    }
}

