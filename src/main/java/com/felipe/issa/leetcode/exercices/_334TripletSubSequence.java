package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _334TripletSubSequence {

    public boolean increasingTriplet(int[] nums) {
        int[] maxVal = new int[nums.length];
        int[] minVal = new int[nums.length];
        maxVal[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i > 0; i--) {
            maxVal[i] = Math.max(maxVal[i + 1], nums[i]);
        }
        minVal[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minVal[i] = Math.min(minVal[i - 1], nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if(minVal[i] < nums[i] && maxVal[i+1] > nums[i]){
                System.out.println("i: " + i);
                System.out.println("previous: " + minVal[i-1]);
                System.out.println("current: " + nums[i]);
                System.out.println("next: " + maxVal[i+1]);
                return true;
            }
        }

        return false;
    }
    @Test
    public void firstCase() {
        boolean output = new _334TripletSubSequence().increasingTriplet(ArrayParser.parse("[1,2,3,4,5]"));
        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _334TripletSubSequence().increasingTriplet(ArrayParser.parse("[5,4,3,2,1]"));
        assertEquals(false, output);
    }

    @Test
    public void thirdCase() {
        boolean output = new _334TripletSubSequence().increasingTriplet(ArrayParser.parse("[2,1,5,0,4,6]"));
        assertEquals(true, output);
    }

    @Test
    public void test66() {
        boolean output = new _334TripletSubSequence().increasingTriplet(ArrayParser.parse("[20,100,10,12,5,13]"));
        assertEquals(true, output);
    }
    @Test
    public void test76() {
        boolean output = new _334TripletSubSequence().increasingTriplet(ArrayParser.parse("[20,100,10,12,5,13]"));
        assertEquals(true, output);
    }
}
