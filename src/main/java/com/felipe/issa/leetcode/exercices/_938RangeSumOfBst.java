package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.TreeNode;
import com.felipe.issa.leetcode.shared.TreeNodeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _938RangeSumOfBst {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int count =  rangeSumBST(root.left, low, high);
        count += rangeSumBST(root.right, low, high);

        if(root.val >= low && root.val <= high) {
            count += root.val;
        }

        return count;
    }


    @Test
    public void firstCase() {
        int output = new _938RangeSumOfBst().rangeSumBST(TreeNodeBuilder.buildNode("[10,5,15,3,7,null,18]"), 7, 15);
        assertEquals(32, output);
    }

    @Test
    public void secondCase() {
        int output = new _938RangeSumOfBst().rangeSumBST(TreeNodeBuilder.buildNode("[10,5,15,3,7,13,18,1,null,6]"), 6, 10);
        assertEquals(23, output);
    }


}
