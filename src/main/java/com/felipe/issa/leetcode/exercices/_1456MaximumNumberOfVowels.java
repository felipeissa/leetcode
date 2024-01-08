package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.assertEquals;

public class _1456MaximumNumberOfVowels {

    public int maxVowels(String s, int k) {

        int maxVowels = 0;
        for(int i = 0; i  <= s.length() - k ; i++) {
            int vowelsFound = isVowel(s.charAt(i)) ? 1 : 0;
            for(int j = i+1; j < ( i + k ); j++) {
                vowelsFound += isVowel(s.charAt(j)) ? 1 : 0;
            }
            maxVowels = Math.max(vowelsFound, maxVowels);
        }

        return maxVowels;
    }

    public int maxVowels2(String s, int k) {
        int vowelsFound = 0;

        int[] value = new int[123];
        value['a'] = 1;
        value['e'] = 1;
        value['i'] = 1;
        value['o'] = 1;
        value['u'] = 1;


        for(int i = 0; i < k; i++)
            vowelsFound+= value[s.charAt(i)];

        int maxVowels = vowelsFound;
        for(int i = k; i < s.length(); i++) {
            vowelsFound += value[s.charAt(i)];
            vowelsFound -= value[s.charAt(i-k)];
            maxVowels = Math.max(maxVowels, vowelsFound);
            if(maxVowels == k) return maxVowels;
        }

        return maxVowels;
    }

    public boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }

    @Test
    public void firstCase() {
        int output = new _1456MaximumNumberOfVowels().maxVowels("abciiidef", 3);
        assertEquals(3, output);
    }

    @Test
    public void secondCase() {
        int output = new _1456MaximumNumberOfVowels().maxVowels("aeiou", 2);
        assertEquals(2, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1456MaximumNumberOfVowels().maxVowels("leetcode", 3);
        assertEquals(2, output);
    }

    @Test
    public void test98() {
        int output = new _1456MaximumNumberOfVowels().maxVowels("weallloveyou", 7);
        assertEquals(4, output);
    }
}
