package com.example.easyquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class QuizController {

    @FXML
    public Label question;

    @FXML
    public Button opt1, opt2, opt3, opt4;

    static int counter = 0;
    static int correct = 1;


    // Déclarez une liste pour stocker les questions
    private List<String> questions = new ArrayList<>();

    @FXML
    private void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/questions.txt"));
            String line = null;

            for (int i = 0; i <= counter; i++) {
                line = reader.readLine();
            }

            if (line != null) {
                String[] parts = line.split("/");
                question.setText(parts[0]);
                opt1.setText(parts[1]);
                opt2.setText(parts[2]);
                opt3.setText(parts[3]);
                opt4.setText(parts[4]);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void optionClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        checkAnswer(clickedButton.getText());
        boolean isCorrect = checkAnswer(clickedButton.getText());
        if (isCorrect) {
            correct++;
            counter++;
            loadQuestions();
        } else {
            try {
                Stage thisstage = (Stage) clickedButton.getScene().getWindow();
                thisstage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.setResizable(false);
                quizstage.getIcons().add(new Image("logo.png"));
                quizstage.setTitle("Quizz IT");
                quizstage.initStyle(StageStyle.DECORATED);
                quizstage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    boolean checkAnswer(String answer) {

        if (counter == 0) {
            if (answer.equals("7")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 1) {
            if (answer.equals("Alan Turing")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 2) {
            if (answer.equals("Disque dur")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 3) {
            if (answer.equals("FTP")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 4) {
            if (answer.equals("SQL")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 5) {
            if (answer.equals("Guido van Rossum")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 6) {
            if (answer.equals("Programme")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 7) {
            if (answer.equals("CPU")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 8) {
            if (answer.equals("Android")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 9) {
            if (answer.equals("Javascript")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


}

