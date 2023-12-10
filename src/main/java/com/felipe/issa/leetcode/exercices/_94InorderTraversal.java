package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.TreeNode;
import com.felipe.issa.leetcode.shared.TreeNodeBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class _94InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }

        return result;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traversal(root, result);

        return result;
    }

    public List<Integer> traversal(TreeNode node, List<Integer> result) {
        if(node == null) return  result;

        traversal(node.left, result);
        result.add(node.val);
        traversal(node.right, result);

        return result;
    }

    @Test
    public void caseOne() {
        List<Integer> output = new _94InorderTraversal().inorderTraversal(TreeNodeBuilder.buildNode("[1,null,2,3]"));
        assertEquals(Arrays.asList(1,3,2), output);
    }
    @Test
    public void caseTwo() {

        List<Integer> output = new _94InorderTraversal().inorderTraversal(TreeNodeBuilder.buildNode("[]"));
        assertEquals(Collections.emptyList(), output);
    }
}
