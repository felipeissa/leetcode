package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _1697MaxNumber {

    // best approach from leetcode
    public int maxOperationsBetter(int[] nums, int k) {
        int index = 0;

        //remove greater than k, to sort less numbers
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < k) nums[index++] = nums[i];
        }

        // sort only smaller than k
        Arrays.sort(nums, 0, index);

        int start = 0;
        int end = index -1;
        int operations = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k) {
                operations ++;
                start ++;
                end --;
            } else if( sum <  k) {
                start++;
            } else {
                end --;
            }
        }

        return operations;
    }

    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Map<Integer, Integer> db = new HashMap<>();

        for(int i = 0; i < nums.length ; i++) {
            int value = nums[i];
            int target = k - value;
            if(db.containsKey(target)) {
                operations++;
                int targetCount = db.get(target);

                if(targetCount > 1) {
                    db.put(target, targetCount - 1);
                } else {
                    db.remove(target);
                }

                continue;
            }
            db.put(nums[i], db.getOrDefault(nums[i], 0) +1);
        }

        return operations;
    }


    @Test
    public void firstCase() {
        int output = new _1697MaxNumber().maxOperations(ArrayParser.parse("[1,2,3,4]"), 5);
        assertEquals(2, output);
    }

    @Test
    public void second() {
        int output = new _1697MaxNumber().maxOperations(ArrayParser.parse("[3,1,3,4,3]"), 6);
        assertEquals(1, output);
    }
}
