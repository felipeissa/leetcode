package com.felipe.issa.leetcode.exercices;

import java.text.MessageFormat;

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

//    public int totalMoney(int n) {
//        int total = 0;
//        int weeks = n / 7;
//        int mod = n % 7;
//
//        if(weeks > 0) {
//            total = 21 + (weeks * 7);
//        }
//
//        System.out.println("total? "+ total);
//        System.out.println("mod: " + mod);
//
//        if(mod == 1) total+= 1 + (1 * weeks);
//        if(mod == 2) total+= 3 + (2 * weeks);
//        if(mod == 3) total+= 6 + (3 * weeks);
//        if(mod == 4) total+= 10 + (4 * weeks);
//        if(mod == 5) total+= 15 + (5 * weeks);
//        if(mod == 6) total+= 21 + (6 * weeks);
//
//
//        return total;
//    }

    public static void main(String[] args) {
        int expected, output;

        expected = 10;
        output = new _1716MoneyLeetCodeBank().totalMoney(4);
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", expected == output, expected, output));

        expected = 37;
        output = new _1716MoneyLeetCodeBank().totalMoney(10);
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", expected == output, expected, output));

        expected = 96;
        output = new _1716MoneyLeetCodeBank().totalMoney(20);
        System.out.println(MessageFormat.format("Is same: {0}. Expected: {1}, got: {2}", expected == output, expected, output));
    }
}
