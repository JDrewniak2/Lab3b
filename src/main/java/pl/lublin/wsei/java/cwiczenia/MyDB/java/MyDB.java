package pl.lublin.wsei.java.cwiczenia.MyDB.java;

import java.sql.*;
import java.util.Properties;

public class MyDB {
    String user;
    String password;
    String host;            //Dane do logowania do bazy
    Number port;
    String dbName;
    private Connection conn = null;
    private Statement statement = null;

    public MyDB(String host,String dbName,Number port) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;

    }

    public void connect() {
        Properties connectProps = new Properties();
        connectProps.put("user", user);
        connectProps.put("password", password);
        connectProps.put("serverTimeZone", "Europe/Warsaw");


        String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try{
            conn = DriverManager.getConnection(
                    jdbcString, connectProps);
            statement = conn.createStatement();
        }
        catch (SQLException e){
            System.out.println("Błąd podłączenia do bazy: "+jdbcString);
            System.out.println("Komunikat błędu: "+e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database "+ dbName);
    }
    public Connection getConnection(){
        if (conn == null)
            connect();
        return conn;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPasssword(String password) {
        this.password = password;
    }
    public void closeConnection(){
        if (conn != null)
            try{
                conn.close();
            }
        catch (SQLException e){
                System.out.println("Błąd przy zamykania połączenia bazodanowego: "+e.getMessage());
        }
        conn = null;
    }
    public ResultSet selectData(String selectStatement){
        if ((conn != null) &&(statement != null))
            try{
                return statement.executeQuery(selectStatement);
            }
        catch (SQLException e){
                System.out.println("Błąd realizacji zapytania: "+selectStatement+", "+e.getMessage());
        }
        return null;
    }
}
