package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _1897RedistributeCharacters {

    public boolean makeEqual(String[] words) {
        int totalSize = 0;
        int[] db = new int[26];

        for(String word: words) {
            totalSize += word.length();
            for(int i = 0; i < word.length(); i++) {
                int key = word.charAt(i) - 'a';
                db[key] = db[key] + 1;
            }
        }

        if(totalSize % words.length != 0) return false;
        for(int charCount: db)
            if(charCount % words.length != 0) return false;


        return true;
    }

    @Test
    public void firstCase() {
        boolean output = new _1897RedistributeCharacters().makeEqual(new String[]{ "abc","aabc","bc" });
        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _1897RedistributeCharacters().makeEqual(new String[]{ "ab","a" });
        assertEquals(false, output);
    }

    @Test
    public void test162() {
        boolean output = new _1897RedistributeCharacters().makeEqual(new String[]{ "a","b" });
        assertEquals(false, output);
    }

}
