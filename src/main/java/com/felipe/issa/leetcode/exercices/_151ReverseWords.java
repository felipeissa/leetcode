package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class _151ReverseWords {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();

        int end = s.length();
        for(int i = s.length() -1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(end - i-1 > 0) {
                    words.add(s.substring(i+1, end));
                }
                end = i;
            }
        }
        if(end > 0) {
            words.add(s.substring(0, end));
        }

        return words.stream().collect(Collectors.joining(" "));
    }

    @Test
    public void firstCase(){
        String output = new _151ReverseWords().reverseWords("the sky is blue");
        assertEquals("blue is sky the", output);
    }

    @Test
    public void secondCase(){
        String output = new _151ReverseWords().reverseWords("  hello world  ");
        assertEquals("world hello", output);
    }

    @Test
    public void thirdCase(){
        String output = new _151ReverseWords().reverseWords("a good   example");
        assertEquals("example good a", output);
    }
}
