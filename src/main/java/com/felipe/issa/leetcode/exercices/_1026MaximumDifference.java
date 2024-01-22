package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.Pair;
import com.felipe.issa.leetcode.shared.TreeNode;
import com.felipe.issa.leetcode.shared.TreeNodeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1026MaximumDifference {

    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        solve(root, root.val, root.val);

        return diff;
    }

    public void solve(TreeNode root, int previousMax, int previousMin) {

        diff = Math.max(diff, Math.max(Math.abs(previousMax - root.val), Math.abs(previousMin - root.val)));

        previousMax = Math.max(previousMax, root.val);
        previousMin = Math.min(previousMin, root.val);


        if(root.left != null)
            solve(root.left, previousMax, previousMin);
        if(root.right != null)
            solve(root.right, previousMax, previousMin);

    }

    @Test
    public void firstCase() {
        int output = new _1026MaximumDifference().maxAncestorDiff(TreeNodeBuilder.buildNode("[8,3,10,1,6,null,14,null,null,4,7,13]"));
        assertEquals(7, output);
    }

    @Test
    public void secondCase() {
        int output = new _1026MaximumDifference().maxAncestorDiff(TreeNodeBuilder.buildNode("[1,null,2,null,0,3]"));
        assertEquals(3, output);
    }

}
