package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.TreeNode;
import com.felipe.issa.leetcode.shared.TreeNodeBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.text.MessageFormat;

import static junit.framework.TestCase.assertEquals;

public class _606StringFromBinaryTree {

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        getChildNode(root.left, sb);
        if(root.left == null && root.right != null) sb.append("()");
        getChildNode(root.right, sb);

        return sb.toString();
    }

    public StringBuilder getChildNode(TreeNode node, StringBuilder sb) {
        if(node == null) return sb;
        sb.append("(");
        sb.append(node.val);

        getChildNode(node.left, sb);
        if(node.left == null && node.right != null) sb.append("()");
        getChildNode(node.right, sb);

        sb.append(")");

        return sb;
    }

    @Test
    public void firstTestCase() {
        String output = new _606StringFromBinaryTree().tree2str(TreeNodeBuilder.buildNode("[1,2,3,4]"));
        assertEquals("1(2(4))(3)", output);
    }
    @Test
    public void leftCaseScenario() {
        String output = new _606StringFromBinaryTree().tree2str(TreeNodeBuilder.buildNode("[1,null,2,null,3,null,4,null,5,null,6]"));
        assertEquals("1()(2()(3()(4()(5()(6)))))", output);
    }
}
