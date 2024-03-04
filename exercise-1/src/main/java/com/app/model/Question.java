package com.app.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Question {
    private final String contentOfQuestion;
    private final List<String> answers;
    private final int correctAnswerIndex;

    public boolean checkAnswer(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }

    public String displayQuestion() {
        return contentOfQuestion;
    }

    public List<String> displayAnswers() {
        return answers;
    }

    public static Question parseInputToQuestion(String input) {
        var parts = input.split(";");
        var contentOfQuestion = parts[0];
        List<String> answers = new ArrayList<>();
        var correctAnswerIndex = -1;
        for (int i = 1; i < parts.length; i++) {
            var answerParts = parts[i].split("-");
            if (answerParts[1].equals("TAK")) {
                correctAnswerIndex = i - 1;
            }
            answers.add(answerParts[0]);
        }
        return new Question(contentOfQuestion, answers, correctAnswerIndex);
    }

}
