package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1716MoneyLeetCodeBank {

    public int totalMoney(int n) {
        int daysCont = 0;
        int amountToAdd = 1;
        int weekDay = 0;
        int total = 0;

        while(daysCont < n) {
            daysCont++;
            weekDay++;
            total += amountToAdd++;

            if(weekDay == 7) {
                weekDay = 0;
                amountToAdd = amountToAdd -6;
            }
        }

        return total;
    }

    @Test
    public void firstCase() {
        int output = new _1716MoneyLeetCodeBank().totalMoney(4);;
        assertEquals(10, output);
    }
    @Test
    public void secondCase() {
        int output = new _1716MoneyLeetCodeBank().totalMoney(10);
        assertEquals(37, output);
    }
    @Test
    public void thirdCase() {
        int output = new _1716MoneyLeetCodeBank().totalMoney(20);
        assertEquals(96, output);
    }

}
