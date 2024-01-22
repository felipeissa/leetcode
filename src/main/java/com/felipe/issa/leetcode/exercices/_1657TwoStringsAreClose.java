package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1657TwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        int[] charCount = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            charCount[word1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < word2.length(); i++) {
            int index = word2.charAt(i) - 'a';
            charCount[index]--;
            if(charCount[index] < 0) return false;
        }
        return true;
    }

    @Test
    public void firstCase(){
        boolean output = new _1657TwoStringsAreClose().closeStrings("abc", "bca");
        assertEquals(true, output);
    }

    @Test
    public void secondCase(){
        boolean output = new _1657TwoStringsAreClose().closeStrings("a", "aa");
        assertEquals(false, output);
    }
    @Test
    public void thirdCase(){
        boolean output = new _1657TwoStringsAreClose().closeStrings("acabbba", "abbccc");
        assertEquals(true, output);
    }
}
