package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _1662StringEquivalent {

    /**
     * Easy solution
     *
     * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
     */
    public boolean arrayStringsAreEqual(String[] words1, String[] words2) {
        int word1Index = 0;
        int word2Index = 0;
        int word1CharIndex = 0;
        int word2CharIndex = 0;


        while(true) {
            String word1 = words1[word1Index];
            String word2 = words2[word2Index];

            char char1 = word1.charAt(word1CharIndex++);
            char char2 = word2.charAt(word2CharIndex++);

            if(char1 != char2) return false;

            if(word1CharIndex >= word1.length()) {
                word1Index++;
                word1CharIndex = 0;
            }

            if(word2CharIndex >= word2.length()) {
                word2Index++;
                word2CharIndex = 0;
            }

            if((words1.length <= word1Index) || ((words2.length <= word2Index))) break;
        }

        return (words1.length <= word1Index) &&  (words2.length <= word2Index);
    }


    public boolean arrayStringsAreEqualEasySolution(String[] word1, String[] word2) {
        String w1 = Arrays.stream(word1).collect(Collectors.joining(""));
        String w2 = Arrays.stream(word2).collect(Collectors.joining(""));
        return w1.equals(w2);
    }


    public static void main(String[] args) {
        boolean result;
        boolean expected;
        result = new _1662StringEquivalent().arrayStringsAreEqual(new String[] {"ab", "c"}, new String[]{"a", "bc"});
        expected = true;
        System.out.println(MessageFormat.format("Result is: {0}. Expected: {1}, got: {2}", result == expected, expected, result));

        result = new _1662StringEquivalent().arrayStringsAreEqual(new String[] {"ac", "b"}, new String[]{"a", "bc"});
        expected = false;
        System.out.println(MessageFormat.format("Result is: {0}. Expected: {1}, got: {2}", result == expected, expected, result));

        result = new _1662StringEquivalent().arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[]{"abcddefg"});
        expected = true;
        System.out.println(MessageFormat.format("Result is: {0}. Expected: {1}, got: {2}", result == expected, expected, result));

    }
}
