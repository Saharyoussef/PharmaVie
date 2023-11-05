module com.example.pharmavie {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pharmavie to javafx.fxml;
    exports com.example.pharmavie;
}