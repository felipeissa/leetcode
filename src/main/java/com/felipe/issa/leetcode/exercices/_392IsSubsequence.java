package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int subIndex = 0;
        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(subIndex)) {
                subIndex++;
                if(subIndex == s.length()) return true;
            }
        }
        return false;
    }


    @Test
    public void firstCase(){
        boolean output = new _392IsSubsequence().isSubsequence("abc", "ahbgdc");
        assertEquals(true, output);
    }

    @Test
    public void secondCase(){
        boolean output = new _392IsSubsequence().isSubsequence("acc", "ahbgdc");
        assertEquals(false, output);
    }

}
