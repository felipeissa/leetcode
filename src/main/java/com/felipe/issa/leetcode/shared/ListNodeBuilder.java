package com.felipe.issa.leetcode.shared;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListNodeBuilder {

    public static ListNode buildList(String nodes) {
        int[] values = ArrayParser.parse(nodes);
        if(values.length == 0) return null;

        ListNode previousNode = null;
        for(int i = values.length -1; i >=0; i--) {
            previousNode = new ListNode(values[i], previousNode);
        }

        return previousNode;
    }

    @Test
    public void testEmptyList() {
        ListNode node = ListNodeBuilder.buildList("[]");
        assertEquals(null, node);
    }

    @Test
    public void testSimpleScenario() {
        ListNode expected = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode output = ListNodeBuilder.buildList("[2,4,3]");

        assertEquals(expected, output);;
    }
}
