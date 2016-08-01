package com.aysegulpekel.main;

public class Fibonacci {
    public int calculateIteratively(int givenNumber) {
        int previous = 1;
        int next = 1;
        int result = 0;

        if (givenNumber == 0) {
            return 0;
        }
        if (givenNumber <= 2) {
            return 1;
        } else {
            while (givenNumber > 2) {
                result = previous + next;
                previous = result - previous;
                next = result;
                givenNumber--;
            }
            return result;
        }
    }

    public int calculateRecursively(int givenNumber) {
        if (givenNumber == 0) {
            return 0;
        }
        if (givenNumber < 2) {
            return 1;
        } else {
            return calculateRecursively(givenNumber - 1) + calculateRecursively(givenNumber - 2);
        }
    }

    public int calculateWithBinet(int givenNumber) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;

        return (int) ((Math.pow(goldenRatio, givenNumber) - Math.pow((1 - goldenRatio), givenNumber)) / Math.sqrt(5));
    }
}