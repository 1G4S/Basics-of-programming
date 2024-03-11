package com.app.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FileData {

    @SneakyThrows
    public static Map<Integer, List<Integer>> getNumbers(String filePath) {
        var lineNumber = new AtomicInteger(1);

        Map<Integer, List<Integer>> map = Files
                .lines(Path.of(filePath))
                .map(line -> Arrays.stream(line.split(";"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toMap(
                        key -> lineNumber.getAndIncrement(),
                        value -> value
                ));
        return map;
    }
}
