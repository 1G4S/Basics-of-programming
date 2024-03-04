package com.app.service;

import com.app.model.Question;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Scanner;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionService {
    private List<Question> questions;
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.displayQuestion());
            List<String> answers = question.displayAnswers();
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i));
            }
            System.out.print("Wybierz odpowiedź (numer): ");
            int userAnswer = scanner.nextInt();
            if (question.checkAnswer(userAnswer - 1)) { // Adjusting index since user input starts from 1
                System.out.println("Dobrze!");
                score++;
            } else {
                System.out.println("Źle!");
            }
        }

        System.out.println("Twój wynik to: " + score + "/" + questions.size());
    }
}
