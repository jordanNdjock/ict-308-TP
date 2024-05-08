package com.example.QuestionApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class QuestionGameUI extends Application {
    private QuestionGame game;
    private Label questionLabel;
    private Button[] answerButtons;
    private Label resultLabel;

    public QuestionGameUI() {
        game = new QuestionGame();
        // Chargement du fichier questions.txt en utilisant un chemin relatif
        String filePath = "src/main/resources/questions.txt";
        File file = new File(filePath);
        game.loadQuestionsFromFile(String.valueOf(file));
    }

    @Override
    public void start(Stage primaryStage) {
        questionLabel = new Label();
        answerButtons = new Button[4];

        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new Button();
            int index = i;
            answerButtons[i].setOnAction(event -> handleAnswer(index));
        }
        resultLabel = new Label();
        VBox root = new VBox(60);
        root.setPadding(new Insets(60));
        root.getChildren().add(questionLabel);
        root.getChildren().addAll(answerButtons);
        root.getChildren().add(resultLabel);

        Scene scene = new Scene(root, 600, 500); // Définis la largeur et la hauteur de la scène

        // Définis la taille minimale de la fenêtre
        primaryStage.setMinWidth(600); // Définis la largeur minimale de la fenêtre
        primaryStage.setMinHeight(400); // Définis la hauteur minimale de la fenêtre


        // Affichage de la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question Game");
        primaryStage.show();
        questionLabel.requestFocus();

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

    private void handleAnswer(int selectedIndex) {
        System.out.println("Selected answer index: " + selectedIndex);
        displayRandomQuestion();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

