package com.felipe.issa.leetcode.shared;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeNodeBuilder {

    public static TreeNode buildNode(String nodes) {
        if("[]".equals(nodes)) return null;
        String[] nodesValues = nodes.substring(1, nodes.length()-1).split(",");
        List<TreeNode> nodesStack = new ArrayList<>();
        TreeNode initialNode = new TreeNode(Integer.parseInt(nodesValues[0]));
        nodesStack.add(initialNode);
        int listIndex = 0;

        boolean left = true;
        for(int i = 1; i < nodesValues.length; i++) {
            String stringValue = nodesValues[i];
            if(!"null".equals(stringValue)) {
                TreeNode value = new TreeNode(Integer.parseInt(stringValue));
                nodesStack.add(value);
                TreeNode currentNode = nodesStack.get(listIndex);
                if(left) currentNode.left = value;
                else {
                    currentNode.right = value;
                }
            }
            if(!left) listIndex ++;
            left = !left;

        }

        return initialNode;
    }

    @Test
    public void testSimpleScenario() {
        TreeNode expected = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3));
        TreeNode output = TreeNodeBuilder.buildNode("[1,2,3,4]");

        assertEquals(expected, output);;
    }

    @Test
    public void testLeftScenario() {
        TreeNode expected = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        TreeNode output = TreeNodeBuilder.buildNode("[1,2,3,null,4]");

        assertEquals(expected, output);;
    }
}
