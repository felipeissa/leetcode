package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1561MaximumCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int output = 0;
        for (int bob = 0, a = piles.length - 1; a - 2 >= bob; a -= 2, bob++) {
            output += piles[a - 1];
        }
        return output;
    }

    @Test
    public void firstCase() {
        int output = new _1561MaximumCoins().maxCoins(new int[]{2, 4, 1, 2, 7, 8});
        assertEquals(9, output);
    }

    @Test
    public void secondCase() {
        int output = new _1561MaximumCoins().maxCoins(new int[]{2, 4, 5});
        assertEquals(4, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1561MaximumCoins().maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4});
        assertEquals(18, output);
    }
}
