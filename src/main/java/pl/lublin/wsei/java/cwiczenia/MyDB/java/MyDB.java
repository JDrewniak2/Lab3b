package pl.lublin.wsei.java.cwiczenia.MyDB.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyDB {
    String user;
    String password;
    String host;            //Dane do logowania do bazy
    Number port;
    String dbName;
    private Connection conn = null;

    public MyDB(String host,String dbName,Number port) {
        this.host = host;
        this.dbName = dbName;
        this.port = port;
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
}
