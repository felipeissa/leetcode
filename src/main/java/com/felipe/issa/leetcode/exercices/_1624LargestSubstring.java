package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class _1624LargestSubstring {

    public int maxLengthBetweenEqualCharacters(String s) {
        if(s.length() == 2) return 0;

        int [] firstOccurrence = new int[26];

            Arrays.fill(firstOccurrence, -1);

        int maxLength = -1;
        for(int i = 0; i < s.length(); i++) {
            int character = s.charAt(i) - 'a';

            if(firstOccurrence[character] >= 0)
                maxLength = Math.max(maxLength, i - 1 - firstOccurrence[character]);
            else
                firstOccurrence[character] = i;
        }

        return maxLength;
    }

    @Test
    public void firstCase() {
        int output = new _1624LargestSubstring().maxLengthBetweenEqualCharacters("aa");
        assertEquals(0, output);
    }

    @Test
    public void secondCase() {
        int output = new _1624LargestSubstring().maxLengthBetweenEqualCharacters("abca");
        assertEquals(2, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1624LargestSubstring().maxLengthBetweenEqualCharacters("cbzxy");
        assertEquals(-1, output);
    }

    @Test
    public void test4() {
        int output = new _1624LargestSubstring().maxLengthBetweenEqualCharacters("cabbac");
        assertEquals(4, output);
    }

    @Test
    public void test9() {
        int output = new _1624LargestSubstring().maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv");
        assertEquals(18, output);
    }
}
