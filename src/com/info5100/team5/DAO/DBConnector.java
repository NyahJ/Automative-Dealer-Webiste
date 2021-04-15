package com.info5100.team5.DAO;
import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    public ResultSet data;

    Connection conn = null;

    public Connection getDBConnection() throws SQLException {

        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://boyce.coe.neu.edu:1433; DatabaseName=Jaya";
        String userid = "INFO6210";  
        String passwd = "NEUHusky!";
       

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userid, passwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    
    public ResultSet queryExecution(String query) throws SQLException {
        conn = getDBConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ResultSet fetchAllData() throws SQLException {
        String query = "select * from Automobiles";
        System.out.println("***fetching all vehicle details***"  +query);
        data = queryExecution(query);
        return data;
    }


    public ResultSet fetchAllDataWithFilters(String parameters) throws SQLException {
        String query = "select * from Automobiles where " + parameters ;
        System.out.println("***fetching filtered vehicle details***"  +query);
        data = queryExecution(query);
        return data;
    }

    public ResultSet fetchDistinctValues(String parameter) throws SQLException {
        String query = "select distinct " + parameter + " " + "from Automobiles ";
        System.out.println("***fetching distinct  values for*** "+ parameter     +query);
        data = queryExecution(query);
        return data;
    }


   
}

