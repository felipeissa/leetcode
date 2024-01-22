package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1347MinimumSteps {
    public int minSteps(String s, String t) {
        int[] sCount = charsCount(s);
        int[] tCount = charsCount(t);

        int count = 0;
        for(int i = 0; i < sCount.length; i++) {
            int diff = tCount[i] - sCount[i];
            if(diff > 0)
                count+= diff;
        }

        return count;
    }

    public int[] charsCount(String string) {
        int[] count = new int[26];
        for(int i = 0; i < string.length(); i++) {
            count[string.charAt(i) - 'a']++;
        }
        return count;
    }

    @Test
    public void firstCase(){
        int output = new _1347MinimumSteps().minSteps("bab", "aba");
        assertEquals(1, output);
    }

    @Test
    public void secondCase(){
        int output = new _1347MinimumSteps().minSteps("leetcode", "practice");
        assertEquals(5, output);
    }

    @Test
    public void thirdCase(){
        int output = new _1347MinimumSteps().minSteps("anagram", "mangaar");
        assertEquals(0, output);
    }
}
