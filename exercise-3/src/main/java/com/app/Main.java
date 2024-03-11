package com.app;

import com.app.model.Data;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var files = List.of(
                "plik1.txt",
                "plik2.txt",
                "plik3.txt",
                "plik4.txt",
                "plik5.txt"
        );
        var dataServ = new Data(files);
        System.out.println(dataServ.getFiles());
    }
}