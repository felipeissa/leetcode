package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

public class _9533KnightDialer {

    int[][] memo;
    int n;
    int MOD = (int) 1e9 + 7;
    int[][] jumps = {
        {4, 6},
        {6, 8},
        {7, 9},
        {4, 8},
        {3, 9, 0},
        {},
        {1, 7, 0},
        {2, 6},
        {1, 3},
        {2, 4}
    };

    public int dp(int remain, int square) {
        if (remain == 0) {
            return 1;
        }

        if (memo[remain][square] != 0) {
            return memo[remain][square];
        }

        int ans = 0;
        for (int nextSquare : jumps[square]) {
            ans = (ans + dp(remain - 1, nextSquare)) % MOD;
        }

        memo[remain][square] = ans;
        return ans;
    }

    public int knightDialer(int n) {
        this.n = n;
        memo = new int[n + 1][10];
        int ans = 0;
        for (int square = 0; square < 10; square++) {
            ans = (ans + dp(n - 1, square)) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        int output;
        int expected;
        output = new _9533KnightDialer().knightDialer(1);
        expected = 10;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _9533KnightDialer().knightDialer(2);
        expected = 20;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _9533KnightDialer().knightDialer(20);
        expected = 136006598;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));
    }
}
