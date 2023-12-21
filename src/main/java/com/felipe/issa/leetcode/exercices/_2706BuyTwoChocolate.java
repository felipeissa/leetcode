package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2706BuyTwoChocolate {
    public int buyChoco(int[] prices, int money) {
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;

        for(int price: prices) {
            if(price < lowest) {
                secondLowest = Math.min(secondLowest, lowest);
                lowest = price;
            } else {
                secondLowest = Math.min(secondLowest, price);
            }
        }

        int minimumAmount = secondLowest + lowest;
        return (minimumAmount <= money) ? money - minimumAmount : money;
    }

    @Test
    public void fistCase() {
        int output = new _2706BuyTwoChocolate().buyChoco(ArrayParser.parse("[1,2,2]"), 3);
        assertEquals(0, output);
    }

    @Test
    public void secondCase() {
        int output = new _2706BuyTwoChocolate().buyChoco(ArrayParser.parse("[3,2,3]"), 3);
        assertEquals(3, output);
    }
}
