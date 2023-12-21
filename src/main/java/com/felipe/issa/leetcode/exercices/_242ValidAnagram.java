package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int length = s.length();
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
        }

        for(int i = 0; i < length; i++) {
            char currentChar = t.charAt(i);
            int count = charCount.getOrDefault(currentChar, 0);
            if(count <= 0) return false;
            charCount.put(currentChar, count -1 );
        }

        return true;
    }

    @Test
    public void firstTest() {
        boolean output = new _242ValidAnagram().isAnagram("anagram", "nagaram");
        assertEquals(true, output);
    }

    @Test
    public void secondTest() {
        boolean output = new _242ValidAnagram().isAnagram("rat", "car");
        assertEquals(false, output);
    }
}
