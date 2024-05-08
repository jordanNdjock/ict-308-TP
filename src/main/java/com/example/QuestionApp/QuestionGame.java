package com.example.QuestionApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionGame {
    private List<Question> questions;

    public QuestionGame() {
        questions = new ArrayList<>();
    }

    public void loadQuestionsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";"); // Assuming that ";" is the delimiter between parts of the question
                String questionText = parts[0];
                List<String> answers = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    answers.add(parts[i]);
                }
                questions.add(new Question(questionText, answers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        } else {
            return null;
        }
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
