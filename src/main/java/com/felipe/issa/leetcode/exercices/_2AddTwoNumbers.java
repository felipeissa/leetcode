package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ListNode;

import java.math.BigInteger;
import java.util.List;

public class _2AddTwoNumbers {


    /**
     * https://leetcode.com/problems/add-two-numbers/
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // my answer works, but its not ideal.
        return null;
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        new _2AddTwoNumbers().addTwoNumbers(node1, node2);

        node1 = new ListNode(9);
        node2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

//        new _2AddTwoNumbers().addTwoNumbers(node1, node2);


        node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        node1 = new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))))));
        node1 = new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, node1)))))))));
        node1 = new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(0, node1)))))))));
        node1 = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(0, node1))));

//        new _2AddTwoNumbers().addTwoNumbers(node1, node2);
    }
}
