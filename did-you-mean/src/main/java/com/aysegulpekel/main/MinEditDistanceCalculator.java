package com.aysegulpekel.main;

public class MinEditDistanceCalculator {

    public int[][] initializeMatrix(int rowLength, int columnLength) {

        int matrix[][] = new int[rowLength][columnLength];

        for (int i = 0; i < rowLength; i++) {
            matrix[i][0] = i;
        }
        for (int j = 0; j < columnLength; j++) {
            matrix[0][j] = j;
        }
        return matrix;
    }

    public char[] convertWordToCharArray(String word) {

        return word.toUpperCase().toCharArray();
    }

    public int findMinimum(int a, int b, int c) {
        int min = a;

        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    public int calculateMinimumDistance(String candidateWord, String enteredWord) {

        char[] candidateWordArray = convertWordToCharArray(candidateWord);
        char[] enteredWordArray = convertWordToCharArray(enteredWord);
        int[][] distanceMatrix = initializeMatrix(candidateWordArray.length + 1, enteredWordArray.length + 1);

        for (int i = 1; i <= candidateWordArray.length; i++) {
            for (int j = 1; j <= enteredWordArray.length; j++) {
                 /*
                 If letters are the same, get the left upper corner's cost.
                 */
                if (candidateWordArray[i - 1] == enteredWordArray[j - 1]) {
                    distanceMatrix[i][j] = distanceMatrix[i - 1][j - 1];
                } else {
                    /*
                     Upper triangle gives the previous change costs.
                     So if there is any change with the current letter,it just increments the latest minimum cost.
                     */
                    distanceMatrix[i][j] = findMinimum(
                            distanceMatrix[i][j - 1],
                            distanceMatrix[i - 1][j],
                            distanceMatrix[i - 1][j - 1]) + 1;
                }
            }
        }
        return distanceMatrix[candidateWordArray.length][enteredWordArray.length];
    }
}
