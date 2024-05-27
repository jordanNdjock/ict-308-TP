module com.example.easyquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.easyquiz to javafx.fxml;
    exports com.example.easyquiz;
}