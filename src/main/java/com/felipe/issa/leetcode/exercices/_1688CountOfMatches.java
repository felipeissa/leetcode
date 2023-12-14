package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public class _1688CountOfMatches {
    public int numberOfMatches(int n) {

        int totalMatches = 0;
        while (n > 1) {
            int mod = n % 2;
            int matches = n / 2;
            totalMatches += matches;
            n = matches + mod;
        }

        return totalMatches;
    }

    @Test
    public void firstCase() {
        int output = new _1688CountOfMatches().numberOfMatches(7);;
        assertEquals(6, output);
    }
    @Test
    public void secondCase() {
        int output = new _1688CountOfMatches().numberOfMatches(14);;
        assertEquals(13, output);
    }
}
