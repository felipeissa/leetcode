package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;
import java.util.Arrays;

public class _1561MaximumCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int output = 0;
        for(int bob = 0, a = piles.length - 1; a-2 >= bob ;a-=2, bob++) {
            output += piles[a-1];
        }
        return output;
    }

    public static void main(String[] args) {
        int output;
        int expected;
        output = new _1561MaximumCoins().maxCoins(new int[] {2, 4, 1, 2, 7, 8});
        expected = 9;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _1561MaximumCoins().maxCoins(new int[] {2, 4, 5});
        expected = 4;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));

        output = new _1561MaximumCoins().maxCoins(new int[] {9,8,7,6,5,1,2,3,4});
        expected = 18;
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", output == expected, expected, output));
    }
}
