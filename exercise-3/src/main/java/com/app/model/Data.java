package com.app.model;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Data {
    private final Map<String, String> files;

    public Data(List<String> filenames) {
        this.files = createMapForFiles(filenames);
    }

    private HashMap<String, String> createMapForFiles(List<String> filenames) {
        return filenames
                .stream()
                .collect(Collectors.toMap(filename -> filename, this::readFromFile, (existing, replacement) -> existing, HashMap::new));
    }

    @SneakyThrows
    private String readFromFile(String filename) {
        return Files.lines(Paths.get(filename))
                .collect(Collectors.joining("\n"));
    }

    public Map<String, String> getFiles() {
        return files;
    }
}
