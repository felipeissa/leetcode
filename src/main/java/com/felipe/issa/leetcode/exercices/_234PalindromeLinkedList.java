package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _234PalindromeLinkedList {
	
	 public boolean isPalindrome(ListNode head) {
		 List<Integer> values = new ArrayList<>();
		 ListNode current = head;
		 values.add(current.getVal());
		 while(current.getNext() != null) {
			 current = current.getNext();
			 values.add(current.getVal());
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
