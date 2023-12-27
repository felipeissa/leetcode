package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1768MergeStrings {
    public String mergeAlternately(String word1, String word2) {
        int length = Math.max(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if(word1.length() > i) sb.append(word1.charAt(i));
            if(word2.length() > i) sb.append(word2.charAt(i));
        }

        return sb.toString();
    }

    @Test
    public void firstCase(){
        String output = new _1768MergeStrings().mergeAlternately("abc", "pqr");
        assertEquals("apbqcr", output);
    }

    @Test
    public void secondCase(){
        String output = new _1768MergeStrings().mergeAlternately("ab", "pqrs");
        assertEquals("apbqrs", output);
    }

    @Test
    public void thirdCase(){
        String output = new _1768MergeStrings().mergeAlternately("abcd", "pq");
        assertEquals("apbqcd", output);
    }
}
