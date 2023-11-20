package com.felipe.issa.leetcode.exercices;

import java.util.HashMap;
import java.util.Map;

public class _3LongestSubstring {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     */

    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int left = 0, right = 0;
        int maxLength = 0;
        String[] values = s.split("");
        Map<String, Integer> position = new HashMap<>();

        while (right < size) {
            String currentChar = values[right];
            Integer lastPosition = position.getOrDefault(currentChar, -1);
            if (lastPosition >= left) {
                left = lastPosition + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            position.put(currentChar, right++);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringMineWithString(String s) {

        String currentWord = "";
        int biggestFound = 0;
        String[] chars = s.split("");

        for (String character : chars) {
            int index = currentWord.indexOf(character);

            if (index >= 0 && currentWord.length() > 0) {
                if (biggestFound < currentWord.length()) {
                    biggestFound = currentWord.length();
                }
                currentWord = currentWord.substring(index + 1);

            }

            currentWord += character;
        }

        if (currentWord.length() > biggestFound)
            biggestFound = currentWord.length();


        return biggestFound;
    }

    public static void main(String[] args) {
        int result = new _3LongestSubstring().lengthOfLongestSubstring("abcabcbb");
        System.out.println("Result is: " + result + ", should be 3");

        result = new _3LongestSubstring().lengthOfLongestSubstring("bbbbb");
        System.out.println("Result is: " + result + ", should be 1");

        result = new _3LongestSubstring().lengthOfLongestSubstring("pwwkew");
        System.out.println("Result is: " + result + ", should be 3");

        result = new _3LongestSubstring().lengthOfLongestSubstring("");
        System.out.println("Result is: " + result + ", should be 0");

        result = new _3LongestSubstring().lengthOfLongestSubstring(" ");
        System.out.println("Result is: " + result + ", should be 1");
    }
}
