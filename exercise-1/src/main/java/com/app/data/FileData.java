package com.app.data;

import com.app.model.Question;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public final class FileData {
    @SneakyThrows
    public static List<Question> loadQuestions(String filename) {
        var reader = new BufferedReader(new FileReader(filename));
        String line;
        var questions = new ArrayList<Question>();
        while ((line = reader.readLine()) != null) {
            questions.add(Question.parseInputToQuestion(line));
        }
        return questions;
    }
}