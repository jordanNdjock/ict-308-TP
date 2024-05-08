package com.example.QuestionApp;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answers;
    private String correctAnswer;

    public Question(String questionText, List<String> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswers() {
        return answers;
    }
    public boolean isCorrectAnswer(String answer) {
        return answer.equals(correctAnswer);
    }
}
