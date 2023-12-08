package com.felipe.issa.leetcode.shared;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      public TreeNode(int val, TreeNode left) {
          this.val = val;
          this.left = left;
      }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof TreeNode)) return false;

        TreeNode objValue = (TreeNode) obj;

        if(objValue.val != this.val) return false;
        if((left != null && !left.equals(objValue.left)) || (left == null && objValue.left != null)) return false;
        if((right != null && !right.equals(objValue.right)) || (right == null && objValue.right != null)) return false;

        return true;
    }
}