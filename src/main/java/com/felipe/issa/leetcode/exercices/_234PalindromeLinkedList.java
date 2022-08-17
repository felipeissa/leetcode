package com.felipe.issa.leetcode.exercices;

import java.util.ArrayList;
import java.util.List;

public class _234PalindromeLinkedList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	 public boolean isPalindrome(ListNode head) {
		 List<Integer> values = new ArrayList<>();
		 ListNode current = head;
		 values.add(current.val);
		 while(current.next != null) {
			 current = current.next;
			 values.add(current.val);
		 }
		 
		 for(int i = 0, end = values.size() -1; i < end; i++, end-- ) {
			 if(values.get(i) != values.get(end)) {
				 return false;
			 }
		 }
		 
		 return true;
    }
	 
	 public static void main(String[] args) {
		ListNode node = new ListNode(1);
//		node = new ListNode(2, node);
//		node = new ListNode(4, node);
//		node = new ListNode(4, node);
//		node = new ListNode(2, node);
//		node = new ListNode(1, node);
		
		boolean data = new _234PalindromeLinkedList().isPalindrome(node);
		System.out.println(data);
	}
}
