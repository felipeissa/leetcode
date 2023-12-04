package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class _1160WordsByChars {

    public int countCharacters(String[] words, String chars) {
        Map<String, Integer> charCount = getCharCount(chars);
        int count = 0;
        for(String word: words) {
            Map<String, Integer> wordCharCount = getCharCount(word);
            if(isWordContained(wordCharCount, charCount)) {
                count += word.length();
            }
        }
        return count;
    }

    private boolean isWordContained(Map<String, Integer> wordCharCount, Map<String, Integer> charCount) {
        for(Map.Entry<String, Integer> wordChar: wordCharCount.entrySet()) {
            int targetCount = charCount.getOrDefault(wordChar.getKey(), 0);
            if(targetCount < wordChar.getValue()) return false;
        }
        return true;
    }

    private Map<String, Integer> getCharCount(String word) {
        String[] charsSplit = word.split("");
        Map<String, Integer> charCount = new HashMap<>();
        for(String current: charsSplit) {
            charCount.put(current, charCount.getOrDefault(current, 0) +1);
        }
        return charCount;
    }

    public static void main(String[] args) {
        int output;
        int expected;
        output = new _1160WordsByChars().countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
        expected = 6;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}.", output == expected, expected, output));

        output = new _1160WordsByChars().countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr");
        expected = 10;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}.", output == expected, expected, output));
    }
}
