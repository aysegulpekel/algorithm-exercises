package com.aysegulpekel.test;

import com.aysegulpekel.main.MinEditDistanceCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinEditDistanceCalculatorTest {
    private MinEditDistanceCalculator test = new MinEditDistanceCalculator();

    @Test
    public void initializeMatrixTest() {
        int matrix[][] = test.initializeMatrix(3, 3);

        assertEquals(0, matrix[0][0]);
        assertEquals(1, matrix[0][1]);
        assertEquals(2, matrix[0][2]);
        assertEquals(1, matrix[1][0]);
        assertEquals(2, matrix[2][0]);
    }

    @Test
    public void convertWordToCharArrayTest() {
        char[] word = test.convertWordToCharArray("aword");

        assertEquals('A', word[0]);
        assertEquals('W', word[1]);
        assertEquals('O', word[2]);
        assertEquals('R', word[3]);
        assertEquals('D', word[4]);
    }

    @Test
    public void findMinimumTest() {
        int min = test.findMinimum(3, 1, 2);

        assertEquals(1, min);
    }

    @Test
    public void calculateMinimumDistanceTest() {
        int distance = test.calculateMinimumDistance("monkey", "money");

        assertEquals(distance, 1);
    }
}