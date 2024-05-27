package com.example.easyquiz;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ResultController {

    @FXML
    public Label remark, correcttext;

    @FXML
    public ProgressIndicator correct_progress, wrong_progress;

    int correct;
    int wrong;

    @FXML
    private void initialize() {
        correct = QuizController.correct;

        correcttext.setText("Votre Score : " + correct);

        float correctf = (float) correct/10;
        correct_progress.setProgress(correctf);

        if (correct < 2) {
            remark.setText("Oh non..! Vous avez échoué au quiz. Il semble que vous ayez besoin d'améliorer votre culture générale. Pratiquez tous les jours ! Consultez vos résultats ici.");
        } else if (correct >= 2 && correct < 5) {
            remark.setText("Oups..! Vous avez obtenu un score bas. Il semble que vous ayez besoin d'améliorer votre culture générale. Consultez vos résultats ici.");
        } else if (correct >= 5 && correct <= 7) {
            remark.setText("Bien. Un peu plus d'amélioration pourrait vous aider à obtenir de meilleurs résultats. La pratique est la clé du succès. Consultez vos résultats ici.");
        } else if (correct == 8 || correct == 9) {
            remark.setText("Félicitations ! C'est votre travail acharné et votre détermination qui vous ont aidé à obtenir de bons résultats. Consultez vos résultats ici.");
        } else if (correct == 10) {
            remark.setText("Félicitations ! Vous avez réussi le quiz avec la note maximale grâce à votre travail acharné et à votre dévouement aux études. Continuez comme ça ! Consultez vos résultats ici.");
        }

    }

    @FXML
    public void btnClicked(ActionEvent event) throws IOException {
        Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        thisstage.close();
        QuizController.correct = 0;
        QuizController.counter = 0;
        FXMLLoader quiz = new FXMLLoader(getClass().getResource("quiz.fxml"));
        Scene quizscene = new Scene(quiz.load());
        quizscene.setFill(Color.TRANSPARENT);
        Stage quizstage = new Stage();
        quizstage.setResizable(false);
        quizstage.getIcons().add(new Image("logo.png"));
        quizstage.setScene(quizscene);
        quizstage.setTitle("Quizz IT");
        quizstage.initStyle(StageStyle.DECORATED);
        quizstage.show();
    }

}
