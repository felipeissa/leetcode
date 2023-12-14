package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ListNode;
import com.felipe.issa.leetcode.shared.ListNodeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2AddTwoNumbers {


    /**
     * https://leetcode.com/problems/add-two-numbers/
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        java.math.BigInteger sum = getSum(l1);
        sum = sum.add(getSum(l2));

        String[] value = sum.toString().split("");

        ListNode result = null;
        for(String current: value) {
            result = new ListNode(Integer.parseInt(current), result);
        }

        return result;
    }

    private java.math.BigInteger getSum(ListNode l1) {
        int index = 0;
        java.math.BigInteger sum = java.math.BigInteger.valueOf(0l);
        ListNode current = l1;

        while(current != null) {
            if(index == 0) {
                sum = java.math.BigInteger.valueOf(current.val);
                index ++;
            } else {
                sum = sum.add(java.math.BigInteger.valueOf(10).pow(index++).multiply(java.math.BigInteger.valueOf(current.val)));
            }
            current = current.next;
        }

        return sum;
    }

    @Test
    public void firstCase() {
        ListNode output = new _2AddTwoNumbers().addTwoNumbers(
            ListNodeBuilder.buildList("[2,4,3]"), ListNodeBuilder.buildList("[5,6,4]")
        );

        assertEquals(ListNodeBuilder.buildList("[7,0,8]"), output);
    }

    @Test
    public void secondCase() {
        ListNode output = new _2AddTwoNumbers().addTwoNumbers(
            ListNodeBuilder.buildList("[0]"), ListNodeBuilder.buildList("[0]")
        );

        assertEquals(ListNodeBuilder.buildList("[0]"), output);
    }

    @Test
    public void thirdCase() {
        ListNode output = new _2AddTwoNumbers().addTwoNumbers(
            ListNodeBuilder.buildList("[9,9,9,9,9,9,9]"), ListNodeBuilder.buildList("[9,9,9,9]")
        );

        assertEquals(ListNodeBuilder.buildList("[8,9,9,9,0,0,0,1]"), output);
    }
}
