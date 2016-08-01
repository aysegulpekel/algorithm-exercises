package com.aysegulpekel.test;

import com.aysegulpekel.main.Searcher;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class SearcherTest {
    private Searcher searcher = new Searcher();

    @Test
    public void findCandidatesTest() throws IOException {
        String basePath = new File("").getAbsolutePath().concat("/words.txt");
        TreeMap<String, Integer> candidatesList = searcher.findCandidates(basePath, "aysegul");

        assertEquals(new Integer(4), candidatesList.get("AASVOGEL"));
        assertEquals(new Integer(3), candidatesList.get("ABSEIL"));
    }

    @Test
    public void getMostSimilarWords() throws IOException {
        String basePath = new File("").getAbsolutePath().concat("/words.txt");
        TreeMap<String, Integer> candidatesList = searcher.findCandidates(basePath, "aysegul");

        List<String> mostSimilarWords = searcher.getMostSimilarWords(candidatesList, "aysegul");
        List<String> correctSimilarWords = Arrays.asList(
                "ABSEIL", "ARSENAL", "ASEXUAL", "ASSEGAI", "EASEFUL",
                "EYEFUL", "MUSEFUL", "SEGUE", "USEFUL", "WISEGUY");

        assertEquals(correctSimilarWords, mostSimilarWords);
    }
}