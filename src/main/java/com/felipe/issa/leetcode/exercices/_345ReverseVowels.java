package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class _345ReverseVowels {

    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() -1;

        char[] response = s.toCharArray();
        while(start < end) {
            boolean startVowel = isVowel(response[start]);
            boolean endVowel = isVowel(response[end]);

            if(!startVowel) start++;
            if(!endVowel) end --;
            if(startVowel && endVowel) {
                char temp = response[start];
                response[start] = response[end];
                response[end] = temp;
                start++;
                end--;
            }
        }

        return new String(response);
    }

    public boolean isVowel(char character) {
        return vowels.contains(character);
    }

    @Test
    public  void firstCase(){
        String output = new _345ReverseVowels().reverseVowels("hello");
        assertEquals("holle", output);
    }

    @Test
    public  void secondCase(){
        String output = new _345ReverseVowels().reverseVowels("leetcode");
        assertEquals("leotcede", output);
    }
}
