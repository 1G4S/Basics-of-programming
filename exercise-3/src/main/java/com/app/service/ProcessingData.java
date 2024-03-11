package com.app.service;

import com.app.model.Data;
import com.app.model.User;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ProcessingData {
    private final HashMap<User, Data> userFiles;

    public void addUser(User user, Data data) {
        userFiles.put(user, data);
    }

    public void updateFileContent(User user, String fileName, String newContent) {
        if (user.isAdmin()) {
            Data data = userFiles.get(user);
            if (data != null) {
                Map<String, String> fileContents = data.getFiles();
                fileContents.put(fileName, newContent);
            }
        } else {
            System.out.println("Brak uprawnień.");
        }
    }

    public int countPatternInFiles(User user, String pattern) {
        int count = 0;
        Data data = userFiles.get(user);
        if (data != null) {
            for (var content : data.getFiles().values()) {
                count += countOccurrences(content, pattern);
            }
        }
        return count;
    }

    private int countOccurrences(String content, String pattern) {
        int count = 0;
        int idx = 0;
        while ((idx = content.indexOf(pattern, idx)) != -1) {
            count++;
            idx += pattern.length();
        }
        return count;
    }

}
