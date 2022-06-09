module sample.lab7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens pl.lublin.wsei.java.cwiczenia.test.lab7 to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.test.lab7;
}