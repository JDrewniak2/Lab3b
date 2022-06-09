module sample.lab7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.lab7 to javafx.fxml;
    exports sample.lab7;
}