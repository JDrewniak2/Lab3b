package pl.lublin.wsei.java.cwiczenia.MyDB.java;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB dataBase = new MyDB("localhost","mydb", 3306);
        dataBase.setUser("root");
        dataBase.setPasssword("zaq1@WSX");
        Connection conn= dataBase.getConnection();
        if(conn!=null){
            System.out.printf("udalo sie");
        }
    }




}