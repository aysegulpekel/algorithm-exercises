package com.aysegulpekel.test;

import com.aysegulpekel.main.Fibonacci;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTests {
    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void testIterative() {
        assertEquals(0, fibonacci.calculateIteratively(0));
        assertEquals(1, fibonacci.calculateIteratively(1));
        assertEquals(1, fibonacci.calculateIteratively(2));
        assertEquals(1836311903, fibonacci.calculateIteratively(46));
    }

    @Test
    public void testRecursive() {
        assertEquals(0, fibonacci.calculateRecursively(0));
        assertEquals(1, fibonacci.calculateRecursively(1));
        assertEquals(1, fibonacci.calculateRecursively(2));
        assertEquals(1836311903, fibonacci.calculateRecursively(46));
    }

    @Test
    public void testBinet() {
        assertEquals(0, fibonacci.calculateWithBinet(0));
        assertEquals(1, fibonacci.calculateWithBinet(1));
        assertEquals(1, fibonacci.calculateWithBinet(2));
        assertEquals(1836311903, fibonacci.calculateWithBinet(46));
    }
}