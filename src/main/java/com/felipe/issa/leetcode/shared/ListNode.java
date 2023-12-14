package com.felipe.issa.leetcode.shared;

import com.felipe.issa.leetcode.exercices._234PalindromeLinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof ListNode)) return false;

        ListNode objValue = (ListNode) obj;

        if(objValue.val != this.val) return false;
        if((next != null && !next.equals(objValue.next)) || (next == null && objValue.next != null)) return false;

        return true;
    }
}
