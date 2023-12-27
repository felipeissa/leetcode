package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class _443StringCompression {

    public int compress(char[] chars) {
        if(chars.length == 0) return 0;

        char lastChar = chars[0];
        int charCount = 1;
        int charIndex = 0;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == lastChar) {
                charCount++;
                continue;
            }

            charIndex = processResult(chars, lastChar, charCount, charIndex);
            charCount = 1;
            lastChar = chars[i];
        }

        charIndex = processResult(chars, lastChar, charCount, charIndex);
        return charIndex;
    }

    private static int processResult(char[] chars, char lastChar, int charCount, int charIndex) {
        chars[charIndex++] = lastChar;
        if(charCount > 1) {
            char[] value = Integer.toString(charCount).toCharArray();
            for(char charValue: value) {
                chars[charIndex++] = charValue;
            }
        }
        return charIndex;
    }

    @Test
    public void firstCase() {
        char[] input = new char[] {'a','a','b','b','c','c','c'};
        int output = new _443StringCompression().compress(input);
        assertEquals(6, output);

        char[] expectedArray = new char[] {'a','2','b','2','c','3'};
        for(int i = 0; i < output; i++) {
            assertEquals(expectedArray[i], input[i]);
        }
    }

    @Test
    public void secondCase() {
        char[] input = new char[] {'a'};
        int output = new _443StringCompression().compress(input);
        assertEquals(1, output);

        char[] expectedArray = new char[] {'a'};
        for(int i = 0; i < output; i++) {
            assertEquals(expectedArray[i], input[i]);
        }
    }

    @Test
    public void thirdCase() {
        char[] input = new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int output = new _443StringCompression().compress(input);
        assertEquals(4, output);

        char[] expectedArray = new char[] {'a','b','1','2'};
        System.out.println(Arrays.toString(input));
        for(int i = 0; i < output; i++) {
            assertEquals(expectedArray[i], input[i]);
        }
    }
}
