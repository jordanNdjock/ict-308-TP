package com.example.easyquiz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ResultController {

    @FXML
    public Label remark, correcttext, result;
    private String player;
    private static int totalQuestions;

    @FXML
    public ProgressIndicator correct_progress, wrong_progress;

    int correct;
    int wrong;

    @FXML
    private void initialize() {
        totalQuestions = QuizController.totalQuestions;
        correct = QuizController.correct;
        result.setText("Resultat de " + QuizController.playerName);

        correcttext.setText("Votre Score : " + correct + " / " + totalQuestions);

        float correctf = (float) correct / totalQuestions;
        correct_progress.setProgress(correctf);

        if (correct < totalQuestions * 0.2) {
            remark.setText("Oh non..! Vous avez échoué au quiz. Il semble que vous ayez besoin d'améliorer votre culture générale. Pratiquez tous les jours ! Consultez vos résultats ici.");
        } else if (correct >= totalQuestions * 0.2 && correct < totalQuestions * 0.5) {
            remark.setText("Oups..! Vous avez obtenu un score bas. Il semble que vous ayez besoin d'améliorer votre culture générale. Consultez vos résultats ici.");
        } else if (correct >= totalQuestions * 0.5 && correct < totalQuestions * 0.8) {
            remark.setText("Bien. Un peu plus d'amélioration pourrait vous aider à obtenir de meilleurs résultats. La pratique est la clé du succès. Consultez vos résultats ici.");
        } else if (correct >= totalQuestions * 0.8 && correct < totalQuestions) {
            remark.setText("Félicitations ! C'est votre travail acharné et votre détermination qui vous ont aidé à obtenir de bons résultats. Consultez vos résultats ici.");
        } else if (correct == totalQuestions) {
            remark.setText("Félicitations ! Vous avez réussi le quiz avec la note maximale grâce à votre travail acharné et à votre dévouement aux études. Continuez comme ça ! Consultez vos résultats ici.");
        }
    }

    @FXML
    private void goToHome(ActionEvent event) {
        try {
            HomeController homeController = new HomeController();
            homeController.stopMusic();
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            scene.setFill(Color.TRANSPARENT);

            Stage homeStage = new Stage();
            homeStage.setScene(scene);
            homeStage.setResizable(false);
            homeStage.getIcons().add(new Image("logo.png"));
            homeStage.setTitle("Easy Quiz IT");
            homeStage.initStyle(StageStyle.DECORATED);

            homeStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void btnClicked(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        thisstage.close();
        QuizController.correct = 0;
        QuizController.counter = 0;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("difficulty.fxml"));
        Scene scene = new Scene(loader.load());
        DifficultyController difficultyController = loader.getController();
        difficultyController.setPlayerName(player);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("logo.png"));
        stage.setTitle("Sélection de la difficulté du joueur : "+player);
        stage.initStyle(StageStyle.DECORATED);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
    public void setPlayerName(String playerName) {
        this.player = playerName;
    }

}
