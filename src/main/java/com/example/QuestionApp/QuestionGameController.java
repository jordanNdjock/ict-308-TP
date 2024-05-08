package com.example.QuestionApp;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class QuestionGameController {
    @FXML
    private Label questionLabel;

    private Question currentQuestion;
    @FXML
    private Label resultLabel;

    @FXML
    private Button[] answerButtons;

    private QuestionGame game;

    public QuestionGameController() {
        game = new QuestionGame();
        game.loadQuestionsFromFile("questions.txt");
    }

    @FXML
    public void initialize() {
        initAnswerButtons();
        displayRandomQuestion();
    }

    private void displayRandomQuestion() {
        Question randomQuestion = game.getRandomQuestion();
        questionLabel.setText(randomQuestion.getQuestionText());
        List<String> answers = randomQuestion.getAnswers();
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setText(answers.get(i));
        }
    }
    private void initAnswerButtons() {
        for (Button button : answerButtons) {
            // Ajout d'un gestionnaire d'événements pour chaque bouton
            button.setOnAction(this::handleAnswerButtonClick);
        }
    }

    @FXML
    protected void handleAnswerButtonClick(javafx.event.ActionEvent event) {
        Button buttonClicked = (Button) event.getSource();
        String selectedAnswer = buttonClicked.getText();
        String resultText;
        if (currentQuestion.isCorrectAnswer(selectedAnswer)) {
            resultText = "Bonne réponse!";
        } else {
            resultText = "Mauvaise réponse!";
        }
        // Affichage du résultat de la réponse
        resultLabel.setText(resultText);
        System.out.println("Reponse selectionnée : " + selectedAnswer);
        displayRandomQuestion();
    }
}
