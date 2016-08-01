package com.aysegulpekel.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String args[]) throws IOException {
        System.out.print("Enter a word to search: ");
        Scanner in = new Scanner(System.in);
        String enteredWord = in.nextLine();

        Searcher searcher = new Searcher();

        String basePath = new File("").getAbsolutePath().concat("/words.txt");

        TreeMap<String, Integer> candidatesList = searcher.findCandidates(basePath, enteredWord);

        if (candidatesList != null) {
            List<String> similarWords = searcher.getMostSimilarWords(candidatesList, enteredWord);

            searcher.printSimilarWords(similarWords);
        }
    }
}