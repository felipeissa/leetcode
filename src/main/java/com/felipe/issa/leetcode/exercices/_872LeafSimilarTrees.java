package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.TreeNode;
import com.felipe.issa.leetcode.shared.TreeNodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _872LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> node1 = solve(root1);
        List<Integer> node2 = solve(root2);

        return node1.equals(node2);
    }

    private List<Integer> solve(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<Integer> nodes = new ArrayList<>();
        List<Integer> left = solve(root.left);
        List<Integer> right = solve(root.right);

        if(left.isEmpty() && right.isEmpty()) {
            nodes.add(root.val);
        } else {
            nodes.addAll(left);
            nodes.addAll(right);
        }
        return nodes;
    }


    @Test
    public void firstCase() {
        boolean output = new _872LeafSimilarTrees().leafSimilar(
            TreeNodeBuilder.buildNode("[3,5,1,6,2,9,8,null,null,7,4]"),
            TreeNodeBuilder.buildNode("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]"));

        assertEquals(true, output);
    }

    @Test
    public void secondCase() {
        boolean output = new _872LeafSimilarTrees().leafSimilar(
            TreeNodeBuilder.buildNode("[1,2,3]"),
            TreeNodeBuilder.buildNode("[1,3,2]"));

        assertEquals(false, output);
    }
}
