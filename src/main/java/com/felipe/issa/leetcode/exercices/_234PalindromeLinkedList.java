package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ListNode;
import com.felipe.issa.leetcode.shared.ListNodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class _234PalindromeLinkedList {

    /**
     * https://leetcode.com/problems/palindrome-linked-list/description/
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        values.add(current.getVal());
        while (current.getNext() != null) {
            current = current.getNext();
            values.add(current.getVal());
        }

        for (int i = 0, end = values.size() - 1; i < end; i++, end--) {
            if (values.get(i) != values.get(end)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void firstCase() {
        boolean output = new _234PalindromeLinkedList().isPalindrome(ListNodeBuilder.buildList("[1,2,2,1]"));
        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _234PalindromeLinkedList().isPalindrome(ListNodeBuilder.buildList("[1,2]"));
        assertEquals(false, output);
    }
}
