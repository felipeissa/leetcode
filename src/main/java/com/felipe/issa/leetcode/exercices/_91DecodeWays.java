package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _91DecodeWays {

    int[] db;

    public int numDecodings(String s) {
        db = new int[s.length()];
        Arrays.fill(db, -1);
        return solve(s, 0);
    }

    public int solve(String s, int position) {
        if(position == s.length()) return 1;
        if(db[position] > -1 ) return db[position];

        int current = s.charAt(position) - '0';
        int answer = 0;
        if(current >= 1 && current <= 9) {
            answer += solve(s, position + 1);
        }

        if(position +1 < s.length()) {
            int second = Integer.parseInt(s.substring(position, position + 2));
            if(second > 9 && second <= 26) {
                answer += solve(s, position+2);
            }
        }

        return db[position] = answer;
    }

    @Test
    public void firstCase() {
        int output = new _91DecodeWays().numDecodings("12");
        assertEquals(2, output);
    }

    @Test
    public void secondCase() {
        int output = new _91DecodeWays().numDecodings("226");
        assertEquals(3, output);
    }

    @Test
    public void thirdCase() {
        int output = new _91DecodeWays().numDecodings("06");
        assertEquals(0, output);
    }

    @Test
    public void test41() {
        int output = new _91DecodeWays().numDecodings("10");
        assertEquals(1, output);
    }

    @Test
    public void test179() {
        int output = new _91DecodeWays().numDecodings("1123");
        assertEquals(5, output);
    }
}
