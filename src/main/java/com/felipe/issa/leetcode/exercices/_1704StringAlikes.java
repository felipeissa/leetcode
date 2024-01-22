package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class _1704StringAlikes {

    Set<Character> vowels;
    public boolean halvesAreAlike(String s) {
        vowels = new TreeSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int half = s.length() / 2;

        int vowels1 = getVowels(s.substring(0, half));
        int vowels2 = getVowels(s.substring(half));

        return vowels1 == vowels2;
    }

    public int getVowels(String text) {
        int count = 0;
        for(int i = 0; i < text.length(); i++) {
            if(vowels.contains(text.charAt(i)))
                count++;
        }
        return count;
    }

    @Test
    public void firstCase() {
        boolean output = new _1704StringAlikes().halvesAreAlike("book");
        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _1704StringAlikes().halvesAreAlike("textbook");
        assertEquals(false, output);
    }
}
