package com.aysegulpekel.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Searcher {

    public void printSimilarWords(List<String> similarWords) {
        if (similarWords.size() == 0) {
            System.out.println("Sorry, couldn't find any match.");
            return;
        }

        System.out.println("Did you mean?");

        for (int i = 0; i < similarWords.size(); i++) {
            System.out.println(similarWords.get(i));
        }
    }

    /*
    getMostSimilarWords extracts the first 10 suggestions and orders by distance cost ascending and then alphabetically.
     */
    public List<String> getMostSimilarWords(TreeMap candidates, String enteredWord) {
        List<String> mostSimilarWords = new ArrayList<>();

        for (int i = 1; i <= enteredWord.length(); i++) {
            Set set = candidates.entrySet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                if ((Integer) me.getValue() == i) {
                    if (mostSimilarWords.size() < 10) {
                        mostSimilarWords.add((String) me.getKey());
                    }
                }
            }
        }
        return mostSimilarWords;
    }

    /*
    findCandidates creates a dictionary of words paired with their distance to entered keyword.
     */
    public TreeMap<String, Integer> findCandidates(String filePath, String enteredWord) throws IOException {
        BufferedReader bagOfWords = new BufferedReader(new FileReader(filePath));

        TreeMap<String, Integer> candidatesList = new TreeMap<>();
        MinEditDistanceCalculator calculator = new MinEditDistanceCalculator();

        String candidate;
        int distance;

        while ((candidate = bagOfWords.readLine()) != null) {
            distance = calculator.calculateMinimumDistance(candidate, enteredWord);
            if (distance == 0) {
                System.out.println("I found the word " + enteredWord);
                return null;
            }
            candidatesList.put(candidate, distance);
        }
        return candidatesList;
    }
}