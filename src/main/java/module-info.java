module com.example.QuestioApp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.QuestionApp to javafx.fxml;
    exports com.example.QuestionApp;
}
