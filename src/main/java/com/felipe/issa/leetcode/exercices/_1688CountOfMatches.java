package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

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

    public static void main(String[] args) {
        int output, expected;
        output = new _1688CountOfMatches().numberOfMatches(7);
        expected = 6;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}.", output == expected, expected, output));

        output = new _1688CountOfMatches().numberOfMatches(14);
        expected = 13;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}.", output == expected, expected, output));
    }
}
