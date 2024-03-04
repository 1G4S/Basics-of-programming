package com.app;

import com.app.data.FileData;
import com.app.service.QuestionService;
// ZMIEN NA POBIERANIE Z PLIKU TYLKO I WYLACZNIE
public class Main {
    public static void main(String[] args) {

        var questions = FileData.loadQuestions("questions_sample.txt");
        var serv = new QuestionService(questions);
        System.out.println(questions);
        serv.startQuiz();
    }
}