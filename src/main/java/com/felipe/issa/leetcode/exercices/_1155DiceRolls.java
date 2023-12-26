package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.Pair;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class _1155DiceRolls {

    int[][] db;
    final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        db = new int[n+1][target+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(db[i], -1);
        }

        return roll(n, k, target);
    }

    public int roll(int n, int k, int target) {
        if(target <= 0 || k <= 0) return 0;
        if(db[n][target] >= 0) return db[n][target];
        int answer = 0;

        if (target < n || n * k < target) {
            return 0;
        }

        for(int i = 1; i <= k; i++) {
            if(n == 1) {
                if(i == target){
                    answer++;
                    answer %= MOD;
                    break;
                }
            }
            else {
                answer += roll(n -1, k, target - i);
                answer %= MOD;
            }
        }

        db[n][target]=answer;
        return answer;
    }

    @Test
    public void firstCase() {
        int output = new _1155DiceRolls().numRollsToTarget(1, 6, 3);
        assertEquals(1, output);
    }

    @Test
    public void secondCase() {
        int output = new _1155DiceRolls().numRollsToTarget(2, 6, 7);
        assertEquals(6, output);
    }

    // @Test
    public void myCase() {
        int output = new _1155DiceRolls().numRollsToTarget(4, 10, 30);
        assertEquals(1, output);

    }

    @Test
    public void thirdCase() {

        int output = new _1155DiceRolls().numRollsToTarget(30, 30, 500);
        assertEquals(222_616_187, output);
    }
}
